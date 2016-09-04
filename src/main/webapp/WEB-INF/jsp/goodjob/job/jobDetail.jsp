<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
     //치환 변수 선언합니다.
      pageContext.setAttribute("crcn", "\r\n"); //Space, Enter
      pageContext.setAttribute("br", "<br/>"); //br 태그
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>
<body>
	<table class="board_view">
		<colgroup>
			<col width="18%"/>
			<col width="32%"/>
			<col width="22%"/>
			<col width="28%"/>
		</colgroup>
		<caption></caption>
		<tbody> 
			<tr>
				<th scope="row">제목</th>
				<td colspan="3">${map.SEQ }. ${map.TITLE } ${map.CREATE_DTM }</td>
			</tr>
			<tr>
				<td id="contents" colspan="4">
				${fn:replace( map.CONTENTS, crcn, br)}
				</td>
			</tr>
			<tr>
				<th scope="row">작성자</th>
				<td>${map.CREA_ID }</td>
				<th scope="row">작성시간</th>
				<td>${map.CREA_DTM }</td>
			</tr>
			
			<!-- tr>
				<th scope="row">첨부파일</th>
				<td colspan="3">				
					<c:forEach var="row" items="${list }">
						<p>
							<input type="hidden" id="IDX" value="${row.IDX }">
							<a href="#this" name="file">${row.ORIGINAL_FILE_NAME }</a> 
							(${row.FILE_SIZE }kb)
						</p>
					</c:forEach>
				</td>
			</tr-->
			
		</tbody>
	</table>
	<br/>
	
	
	<a href="#this" class="btn" id="list">목록으로</a>
	<a href="#this" class="btn" id="update">수정하기</a>
	
	<%@ include file="/WEB-INF/include/include-body.jspf" %>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#list").on("click", function(e){ //목록으로 버튼
				e.preventDefault();
				fn_openBoardList();
			});
			
			$("#update").on("click", function(e){ //수정하기 버튼
				e.preventDefault();
				fn_openBoardUpdate();
			});
			
			$("a[name='file']").on("click", function(e){ //파일 이름
				e.preventDefault();
				fn_downloadFile($(this));
			});
			<%
			 //System.out.println( "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" );
			 //System.out.println( ( (java.util.Map) request.getAttribute("map")).get("CONTENTS")  );
			 //System.out.println( "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" );
			%>
			
			
			
		});
		
		function fn_openBoardList(){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/goodjob/job/openJobList.do' />");
			comSubmit.submit();
		}
		
		function fn_openBoardUpdate(){
			var seq = "${map.SEQ}";
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/goodjob/job/openJobUpdate.do' />");
			comSubmit.addParam("SEQ", seq);
			comSubmit.submit();
		}
		
		function fn_downloadFile(obj){
			var idx = obj.parent().find("#IDX").val();
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/common/downloadFile.do' />");
			comSubmit.addParam("IDX", idx);
			comSubmit.submit();
		}
	</script>
</body>
</html>