<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="js/jquery/jquery-1.11.0.min.js"></script>

</head>
<body>
<form action="${pageContext.request.contextPath}/TestServlet" method="post" enctype="multipart/form-data">
    学号：<input type="text" name="sno"><br>
    姓名: <input type="text" name="sname"><br>
    <input type="file" name="Photo" value="上传照片"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
