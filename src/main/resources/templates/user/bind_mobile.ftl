<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8"> <!-- for HTML5 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>绑定手机号</title>
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
<section id="intro" class="home-slide text-light">

    <!-- Carousel -->
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>
        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                <img src="/imgs/slide1.jpg" alt="First slide">
                <!-- Static Header -->
                <div class="header-text hidden-xs">
                    <div class="col-md-12 text-center">
                        <h2>
                            <span>Welcome to Shuffle</span>
                        </h2>
                        <br>
                        <h3>
                            <span>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</span>
                        </h3>
                        <br>
                        <div class="">
                            <a class="btn btn-theme btn-sm btn-min-block" href="#about">About us</a><a class="btn btn-theme btn-sm btn-min-block" href="#works">Our works</a></div>
                    </div>
                </div><!-- /header-text -->
            </div>
            <div class="item">
                <img src="/imgs/slide2.jpg" alt="Second slide">
                <!-- Static Header -->
                <div class="header-text hidden-xs">
                    <div class="col-md-12 text-center">
                        <h2>
                            <span>Awesome Bootstrap template</span>
                        </h2>
                        <br>
                        <h3>
                            <span>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</span>
                        </h3>
                        <br>
                        <div class="">
                            <a class="btn btn-theme btn-sm btn-min-block" href="#about">About us</a><a class="btn btn-theme btn-sm btn-min-block" href="#works">Our works</a></div>
                    </div>
                </div><!-- /header-text -->
            </div>
            <div class="item">
                <img src="/imgs/slide3.jpg" alt="Third slide">
                <!-- Static Header -->
                <div class="header-text hidden-xs">
                    <div class="col-md-12 text-center">
                        <h2>
                            <span>Use without any charge</span>
                        </h2>
                        <br>
                        <h3>
                            <span>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</span>
                        </h3>
                        <br>
                        <div class="">
                            <a class="btn btn-theme btn-sm btn-min-block" href="#about">About us</a><a class="btn btn-theme btn-sm btn-min-block" href="#works">Our works</a></div>
                    </div>
                </div><!-- /header-text -->
            </div>
        </div>
        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
    </div><!-- /carousel -->

</section>
<!-- /Section: intro -->
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
                <form action="/mentor/user/bind" method="post" role="form" class="contactForm">
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
