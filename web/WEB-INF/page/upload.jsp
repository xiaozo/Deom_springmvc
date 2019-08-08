<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>
<html>
<head>
    <title>文件的上传和下载</title>
</head>
<body>

文件上传：
<form action="/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="testImg"/> <br>
    <input type="submit"/>
</form>

</body>
</html>