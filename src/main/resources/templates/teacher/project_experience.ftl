<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8"> <!-- for HTML5 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>项目经验</title>
    <!-- css -->
    <link href="/plugin/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="/css/nivo-lightbox.css" rel="stylesheet" />
    <link href="/css/nivo-lightbox-theme/default/default.css" rel="stylesheet" type="text/css" />
    <link href="/css/owl.carousel.css" rel="stylesheet" media="screen" />
    <link href="/css/owl.theme.css" rel="stylesheet" media="screen" />
    <link href="/css/flexslider.css" rel="stylesheet" />
    <link href="/css/animate.css" rel="stylesheet" />
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/color/default.css" rel="stylesheet">
</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-custom">
<!-- Navigation -->
<div id="navigation">
    <nav class="navbar navbar-custom" role="navigation">
        <div class="container">
            <div class="row">
                <div class="col-md-2">
                    <div class="site-logo">
                        <a href="index.html" class="brand">Shuffle</a>
                    </div>
                </div>
                <div class="col-md-10">

                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#menu">
                            <i class="fa fa-bars"></i>
                        </button>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="menu">
                        <ul class="nav navbar-nav navbar-right">
                            <li class="active"><a href="#intro">Home</a></li>
                            <li><a href="#about">About Us</a></li>
                            <li><a href="#service">Services</a></li>
                            <li><a href="#works">Works</a></li>

                            <li><a href="#contact">Contact</a></li>
                        </ul>
                    </div>
                    <!-- /.Navbar-collapse -->

                </div>
            </div>
        </div>
        <!-- /.container -->
    </nav>
</div>
<!-- /Navigation -->
<!-- Section: contact -->
<section id="contact" style="padding-top:35px;" class="home-section nopadd-bot color-dark bg-gray text-center">
    <div class="container marginbot-20">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <div class="wow flipInY" data-wow-offset="0" data-wow-delay="0.4s">
                    <div class="section-heading text-center">
                        <h2 class="h-bold">绑定手机</h2>
                        <p id="tip_msg">${msg}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row marginbot-80">
            <div class="col-md-8 col-md-offset-2">
                <form action="/mentor/user/bind" method="post" method="post" role="form" class="contactForm">
                    <div class="form-group">
                        <label for="name" class="form-label">登陆名</label>
                        <input type="text" name="userName" class="form-control" id="name" placeholder="登录名" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                        <div class="validation"></div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="form-label">密码</label>
                        <input type="password" class="form-control" name="password" id="password" placeholder="" data-rule="minlen:6" data-msg="Please enter a valid email" />
                        <div class="validation"></div>
                    </div>
                    <div class="form-group">
                        <label for="mobile" class="form-label">手机号</label>
                        <input type="text" class="form-control" name="mobile" id="mobile" placeholder="请输入手机号"  />
                        <div class="validation"></div>
                    </div>
                    <div class="form-group">
                        <label for="captcha">验证码</label>
                        <div class="input-group">
                            <input type="text" name="captcha" id="captcha" class="form-control">
								  <span class="input-group-btn">
									<button class="btn btn-default" onclick="getCaptcha()" id="captcha_btn" type="button">获取验证码</button>
								  </span>
                        </div><!-- /input-group -->
                    </div>
                    <input type="hidden" name="id" id="id" value="${user.userId}"/>
                    <input type="hidden" name="openId" id="openId" value="${user.openId}"/>
                    <div class="text-center"><button type="submit" class="btn btn-skin btn-lg btn-block">绑定</button></div>
                </form>

            </div>
        </div>
    </div>
</section>
<!-- /Section: contact -->

<!-- Core JavaScript Files -->
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/plugin/bootstrap/js/bootstrap.min.js"></script>
<script src="/js/jquery.sticky.js"></script>
<script src="/js/jquery.flexslider-min.js"></script>
<script src="/js/jquery.easing.min.js"></script>
<script src="/js/jquery.scrollTo.js"></script>
<script src="/js/jquery.appear.js"></script>
<script src="/js/stellar.js"></script>
<script src="/js/wow.min.js"></script>
<script src="/js/owl.carousel.min.js"></script>
<script src="/js/nivo-lightbox.min.js"></script>
<script type="text/javascript">
    function getCaptcha() {
        var mobile = $("#mobile").val();
        if (mobile == "") {
            $("#tip_msg").text("请输入手机号");
            return;
        }
        $.ajax({
            url: "/mentor/user/captcha?mobile=" + mobile,
            type: "GET",
            dataType: "json",
            cache: false,
            success: function (data) {
                if (data.msg == "success") {
                    $("#captcha_btn").text("验证码已经发送")
                } else {
                    $("#captcha_btn").text("系统繁忙！");
                }
            }
        });
    }
</script>
</body>

</html>
