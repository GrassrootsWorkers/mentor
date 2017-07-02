<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta content="text/html;charset=utf-8"/>
    <title>注册用户</title>
    <script src="/js/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="/plugin/bootstrap/css/bootstrap.min.css"/>
    <script src="/plugin/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form class="form-horizontal" role="form" action="/mentor/user/bind" method="post">
        <div class="form-group">
            <label for="user_name" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="user_name" name="userName" placeholder="请输入用户名">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
            </div>
        </div>
        <div class="form-group">
            <label for="mobile" class="col-sm-2 control-label">手机号</label>
            <div class="col-sm-10">
                <input type="mobile" class="form-control" id="mobile" name="mobile" placeholder="请输入姓">
            </div>
        </div>
        <div class="form-group">
            <label for="captcha" class="col-sm-2 control-label">验证码</label>
            <div class="col-sm-10">
                <input type="captcha" class="form-control" id="captcha" name="captcha" placeholder="请输入微信收到的验证码">
            </div>
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" onclick="getCaptcha()" class="btn btn-default">获取验证码</button>
            </div>
        </div>
        <input type="hidden" id="id" name="id" value="${userId}"/>
        <input type="hidden" id="openId" name ="openId" value="${openId}"/>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">绑定</button>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript">
    function getCaptcha() {
        var mobile = $("#mobile").val();
        if (mobile == "") {
            alert("请输入手机号");
            return;
        }
        $.ajax({
            url: "/mentor/user/captcha?mobile=" + mobile,
            type: "GET",
            dataType: "json",
            cache: false,
            success: function (data) {
                if (data.msg == "success") {
                    alert("验证码已经发送")
                } else {
                    alert("系统繁忙！");
                }
            }
        });
    }
</script>
</body>
</html>