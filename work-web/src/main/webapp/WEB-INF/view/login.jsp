<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
</head>
<body>
	<span id="spn_time">This is Login Page...</span>
	<button id="btn_test">测试</button>
	<br/>
	<table class="easyui-datagrid"></table>
<!-- javascript部分 -->
<script language="javascript" src="js/_b.js" charset="utf-8"></script>
<script language="javascript" src="js/jquery.min.js" charset="utf-8"></script>
<script language="javascript" src="js/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script language="javascript" src="js/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script>
BSS.interval(1000,function(){
	document.getElementById('spn_time').innerHTML = BSS.DateTime.nowStr();
});
</script>
</body>
</html>