<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script type="text/javascript">
	function PurchaseHistoryAction() {
		document.getElementById('form').action = "PurchaseHistoryAction";
	}

	function Review1Action() {
		document.getElementById('form').action = "Review1Action";
	}
</script>




<title>購入履歴</title>
</head>
<body>
	<h1>新着商品一覧</h1>

	<s:if test="purchaseHistoryList == null">
		<h2>購入履歴はありません。</h2>
	</s:if>

	<s:elseif test="message == null">
		<a>購入情報は以下になります。</a>
	</s:elseif>

	<s:form id="form" name="form" action="PurchaseHistoryAction">
		<s:iterator value="purchaseHistoryList">
			<table>
				<tr>
					<td>チェック</td>
					<td>商品ID</td>
					<td>商品名</td>
					<td>ふりがな</td>
					<td>金額</td>
					<td>個数</td>
					<td>レビューボタン</td>
				</tr>
				<tr>
					<td><s:checkbox name="checkList" value="checked"
							fieldValue="%{productId}" /></td>

					<td><span><s:property value="productId" /></span></td>
					<s:hidden name="productId" value="%{productId}" />
					<td><span><s:property value="productName" /></span></td>
					<s:hidden name="productName" value="%{productName}" />
					<td><span><s:property value="productNameKana" /></span></td>
					<td><span><s:property value="price" />円</span></td>
					<td><span><s:property value="count" />個</span></td>

					<s:hidden name="registDate" value="%{registDate}" />
					<td><s:submit value="レビュー" onclick="Review1Action();" /></td>
					<td></td>
				</tr>
				<s:hidden name="deleteFlg" value="1" />
				<tr>
					<td><s:submit value="一括削除" onclick="PurchaseHistoryAction();" /></td>

				</tr>
			</table>
		</s:iterator>
	</s:form>

</body>
</html>