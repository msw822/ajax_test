<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- 
1，获取当前页面的所有a节点，并为每一个人节点添加click响应函数，并取消其默认行为
2，准备放松ajax请求，url 为 a节点的href 属性  args（时间戳）
3，响应为一个json对象，包括  多少xx本书，共计xxx多少元  bookName，totalMoney，totalCount
4，

-->
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.8.3.js"></script>
<script type="text/javascript">

$(function(){
	var isHasCart = ${sessionScope.sc == null};
	alert(isHasCart);
	if(isHasCart){
		$("#cart").hide();
	}else{
		$("#cart").show();
		$("#bookName").text("${sessionScope.sc.bookName}");
		$("#totalMoney").text("${sessionScope.sc.totalMoney}");
		$("#totalCount").text("${sessionScope.sc.totalCount}");
	}
	
	$("a").click(function(){
		$("#cart").show()
		var url =this.href;
		var agrs = {"time": new Date()};
		
		$.getJSON(url,agrs,function(data){
			$("#bookName").text(data.bookName);
			$("#totalMoney").text(data.totalMoney);
			$("#totalCount").text(data.totalCount);
		});
		return false;
	})
})



</script>

</head>
<body>
<dir id="cart">
您已经将&nbsp <span id="bookName"></span> &nbsp加入到购物车中
目前购物车中有书&nbsp<span id="totalCount"></span> &nbsp本 ,总价格共计&nbsp<span id="totalMoney"> &nbsp</span>元。
</dir>
	<br><br>
	
	JAVA &nbsp &nbsp<a href="${pageContext.request.contextPath}/addToCart?id=Java&price=100">加入购物车</a> &nbsp &nbsp 100元/本
	<br><br>
	
	Oracle &nbsp &nbsp<a href="${pageContext.request.contextPath}/addToCart?id=Oracle&price=200">加入购物车</a>&nbsp&nbsp 200元/本
	<br><br>
	
	Struts2 &nbsp &nbsp<a href="${pageContext.request.contextPath}/addToCart?id=Sturts2&price=300">加入购物车</a>&nbsp &nbsp  300元/本

	<br><br>

</body>
</html>