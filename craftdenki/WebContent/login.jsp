<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="LoginAction">
		<table>

			<tr>
				<td><s:if test="session.unknown != ''">

						<s:property value="session.unknown" />

					</s:if></td>
			</tr>


			<tr>
				<td><s:if test="session.IDerrormsg != ''">
						<s:property value="session.IDerror" />
					</s:if></td>
			</tr>
			<tr>
				<td><s:textfield name="loginId" style="ime-mode:disabled;" value="test" /></td>
			</tr>


			<tr>
				<td><s:if test="session.Passerrormsg != ''">
						<s:property value="session.Passerror" />
					</s:if></td>
			</tr>
			<tr>
				<td><s:textfield name="loginPassword" style="ime-mode:disabled;" value="123"/></td>
			</tr>


			<tr>
				<td><s:submit value="ログイン" /></td>
			</tr>

		</table>

	</s:form>



	<s:form action="ChangePasswordAction">
	<s:submit value ="パスワード再設定"/>
	</s:form>

</body>
</html>