<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--  DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"-->
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="frm" name="frm" enctype="multipart/form-data">
		<table class="board_view">
			<colgroup>
				<col width="15%">
				<col width="*"/>
			</colgroup>
			<caption>Goodjob 고객등록</caption>
			<tbody>
			
			   <tr>
					<th scope="row">로그인 ID</th>
					<td><input type="text" id="LOGIN_ID" name="LOGIN_ID" class="wdp_90"></input></td>
				</tr>
			     <tr>
					<th scope="row">로그인 PASSWORD</th>
					<td><input type="password" id="LOGIN_PW" name="LOGIN_PW" class="wdp_90"></input></td>
				</tr>
			
				<tr>
					<th scope="row">고객명</th>
					<td><input type="text" id="CUSTOMER_NAME" name="CUSTOMER_NAME" class="wdp_90"></input></td>
				</tr>
				
				<tr>
					<th scope="row">고객Email</th>
					<td>
					<div class="ui-grid-c">
					  <div class="ui-block-a"  style="width:45%" >
					  	<input type="text"  id="EMAIL_ID"      name="EMAIL_ID" ></input>
					  </div>
					  <div class="ui-block-b"  style="width:10%"  >
					  <p>@</p>
					  </div>
					  <div class="ui-block-c"  style="width:45%"  >
					  <input type="text" id="EMAIL_Domain"  name="EMAIL_Domain" ></input>
					  </div>
					</div>
					</td>
				</tr>

				<tr>
					<th scope="row">고객전화</th>
					<td>
						<div class="ui-grid-d">
							<div class="ui-block-a" >
								<input type="text" id="HP_TEL_NATION_NO" name="HP_TEL_NATION_NO" ></input>
							</div>
							<div class="ui-block-b" >
								<input type="text" id="HP_TEL_AREA_NO"   name="HP_TEL_AREA_NO"   ></input>
							</div>
							<div class="ui-block-c" >
								<input type="text" id="HP_TEL_OFC_NO"    name="HP_TEL_OFC_NO"   ></input>
							</div>
							<div class="ui-block-d" >
								<input type="text" id="HP_TEL_SEQ_NO"    name="HP_TEL_SEQ_NO"   ></input>
							</div>
						</div>
					</td>
				</tr>

				<tr>
					<td colspan="2" class="view_text">
						<textarea rows="20" cols="100" title="내용" id="CONTENTS" name="CONTENTS"></textarea>
					</td>
				</tr>
			</tbody>
		</table>
		
		
		<div id="fileDiv">
			<p>
				<input type="file" id="file" name="file_0">
				<a href="#this" class="btn" id="delete" name="delete">삭제</a>
			</p>
		</div>
		
		<br/><br/>
		<a href="#this" class="btn" id="addFile">파일 추가</a>
		<a href="#this" class="btn" id="write">작성하기</a>
		<a href="#this" class="btn" id="list">목록으로</a>
	</form>

<%@ include file="/WEB-INF/include/include-body.jspf" %>
	<script type="text/javascript">
		var gfv_count = 1;
		var isloaded = false;
	
		$(document).ready(function(){
			if (isloaded) {
				return;
			}
			
			$("#list").on("click", function(e){ //목록으로 버튼
				e.preventDefault();
				fn_openBoardList();
			});
			
			$("#write").on("click", function(e){ //작성하기 버튼
				e.preventDefault();
				fn_insertBoard();
				return;
			});
			
			$("#addFile").on("click", function(e){ //파일 추가 버튼
				e.preventDefault();
				fn_addFile();
				return;
			});
			
			$("a[name='delete']").on("click", function(e){ //삭제 버튼
				e.preventDefault();
				fn_deleteFile($(this));
			});
			
			isloaded = true;
		});
		
		function fn_openBoardList(){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/goodjob/customer/openCustomerList.do' />");
			comSubmit.submit();
		}
		
		function fn_insertBoard(){
			var comSubmit = new ComSubmit("frm");
			comSubmit.setUrl("<c:url value='/goodjob/customer/insertCustomer.do' />");
			comSubmit.submit();
		}
		
		function fn_addFile(){
			var str = "<p><input type='file' name='file_"+(gfv_count++)+"'><a href='#this' class='btn' name='delete'>삭제</a></p>";
			$("#fileDiv").append(str);
			
			$("a[name='delete']").on("click", function(e){ //삭제 버튼
				e.preventDefault();
				fn_deleteFile($(this));
			});
			
		}
		
		function fn_deleteFile(obj){
			obj.parent().remove();
		}
	</script>

</body>
</html>