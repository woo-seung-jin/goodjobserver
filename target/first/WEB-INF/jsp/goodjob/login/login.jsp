<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


</head>
<body>
	     <div class="login-page">
            <div class="form">
                <form class="login-form" id="frm" name="frm" enctype="multipart/form-data" >
                    <input type="text"     id="LOGIN_ID" name="LOGIN_ID" placeholder="username" />
                    <input type="password" id="LOGIN_PW" name="LOGIN_PW" placeholder="password" />
                    <button  id="login" >로그인</button>
                    <p class="message">Not registered? <a href="#" id="regist" class="btn">신규등록</a></p>
                </form>
            </div>
        </div>

	<!-- form id="frm" name="frm" enctype="multipart/form-data">
		<table class="board_view">
			<colgroup>
				<col width="15%">
				<col width="*"/>
			</colgroup>
			<caption>Goodjob 고객등록</caption>
			<tbody>
				<tr>
					<th scope="row">로그인ID</th>
					<td><input type="text" id="LOGIN_ID" name="LOGIN_ID" class="wdp_90" value="${map.LOGIN_ID}" ></input></td>
				</tr>
				
				<tr>
					<th scope="row">로그인 PW</th>
					<td>
						<input type="text"  id="LOGIN_PW"      name="LOGIN_PW" ></input>
					</td>
				</tr>

			</tbody>
		</table>
		<br/><br/>
		<a href="#this" class="btn" id="login">로그인</a>
		
		<a href="#this" class="regist" id="regist">등록</a>
		
	</form-->

	<script type="text/javascript">
		var gfv_count = 0;

		$(document).ready(function(){
			$("#login").on("click", function(e){ //작성하기 버튼
				e.preventDefault();
				fn_openCustomerProcess();
			});
			
			$("#list").on("click", function(e){ //목록으로 버튼
				e.preventDefault();
				fn_openBoardList();
			});
			
			$("#regist").on("click", function(e){ //목록으로 버튼
				e.preventDefault();
				fn_openCustomerIns();
			});
			
		});
		
		
		function fn_openCustomerProcess(){
			var comSubmit = new ComSubmit("frm");
			comSubmit.setUrl("<c:url value='/goodjob/login/loginProcess.do' />");
			comSubmit.submit();
		}
		
		
		function fn_openCustomerIns(){
			var comSubmit = new ComSubmit("frm");
			comSubmit.setUrl("<c:url value='/goodjob/customer/customerInsView.do' />");
			comSubmit.submit();
		}
		
	</script>

</body>
</html>