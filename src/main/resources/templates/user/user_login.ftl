<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta content="text/html;charset=utf-8"/>
    <title>注册用户</title>
    <script src="/static/js/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="/static/plugin/bootstrap/css/bootstrap.min.css"/>
    <script src="/static/plugin/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form class="form-horizontal" role="form" action="/mentorUser/login">
        <div class="form-group">
            <label for="user_name" class="col-sm-2 control-label">名字</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="user_name" value="${mentorUser.userName}" name = "userName" placeholder="请输入名字">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">姓</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="password" name="password" placeholder="请输入姓">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">登录</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>