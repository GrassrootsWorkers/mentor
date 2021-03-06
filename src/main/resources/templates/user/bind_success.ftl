<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8"> <!-- for HTML5 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>绑定手机成功</title>
    <!-- css -->
    <link href="/plugin/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css">
    <link href="/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="/css/nivo-lightbox.css" rel="stylesheet"/>
    <link href="/css/nivo-lightbox-theme/default/default.css" rel="stylesheet" type="text/css"/>
    <link href="/css/owl.carousel.css" rel="stylesheet" media="screen"/>
    <link href="/css/owl.theme.css" rel="stylesheet" media="screen"/>
    <link href="/css/flexslider.css" rel="stylesheet"/>
    <link href="/css/animate.css" rel="stylesheet"/>
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
        </ol>
        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                <img src="/imgs/slide1.jpg" alt="First slide">
                <!-- Static Header -->
                <div class="header-text hidden-xs">
                    <div class="col-md-12 text-center">
                        <h2>
                            <span>查看当老师的福利</span>
                        </h2>
                        <br>
                        <h3>
                            <span>分享您的开发经验,获得应有的回报</span>
                        </h3>
                        <br>
                        <div class="">
                            <a class="btn btn-theme btn-sm btn-min-block" href="#teacher">我要当老师</a>
                            <a class="btn btn-theme btn-sm btn-min-block" href="#student">我要学经验</a></div>
                    </div>
                </div><!-- /header-text -->
            </div>
            <div class="item">
                <img src="/imgs/slide2.jpg" alt="Second slide">
                <!-- Static Header -->
                <div class="header-text hidden-xs">
                    <div class="col-md-12 text-center">
                        <h2>
                            <span>良师带路,少走弯路</span>
                        </h2>
                        <br>
                        <h3>
                            <span>向大公司的大咖看齐</span>
                        </h3>
                        <br>
                        <div class="">
                            <a class="btn btn-theme btn-sm btn-min-block" href="#teacher">我要当老师</a>
                            <a class="btn btn-theme btn-sm btn-min-block" href="#student">我要学经验</a></div>
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
<section id="teacher" style="padding-top:35px;" class="home-section nopadd-bot color-dark bg-gray text-center">
    <div class="container marginbot-20">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <div class="wow flipInY" data-wow-offset="0" data-wow-delay="0.4s">
                    <div class="section-heading text-center">
                        <h2 class="h-bold">成为老师</h2>
                        <p>从事计算机10年以上</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row marginbot-80">
            <div class="col-md-8 col-md-offset-2">
                <form action="/mentor/user/teacher/extra" method="post"  role="form" id ="teacher_form" class="contactForm">
                    <div class="form-group">
                        <label for="teacher_name" class="form-label">姓名</label>
                        <input type="text" name="name" id="teacher_name" class="form-control" placeholder="您的真实姓名"/>
                        <div class="validation"></div>
                    </div>
                    <div class="form-group">
                        <label for="province_btn" class="form-label">籍贯</label>
                        <div class="btn-group">
                            <input type="hidden" name="province" id="province" value="北京市"/>
                            <button type="button" id="province_btn" class="btn btn-default">北京市</button>
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                <span class="caret"></span>
                                <span class="sr-only">切换下拉菜单</span>
                            </button>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="javascript:void(0)" onclick="select_province('0','上海市')">北京市</a></li>
                                <li><a href="javascript:void(0)" onclick="select_province('1','上海市')">上海市</a></li>
                                <li class="divider"></li>
                                <li><a href="javascript:void(0)" onclick="select_province('2','山东省')">山东省</a></li>
                            </ul>
                        </div>
                        <div class="btn-group">
                            <input type="hidden" name="city" id="city" value="北京市"/>
                            <button type="button" id="city_btn" class="btn btn-default">北京市</button>
                            <button type="button" class="btn btn-default dropdown-toggle"  data-toggle="dropdown">
                                <span class="caret"></span>
                                <span class="sr-only">切换下拉菜单</span>
                            </button>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="javascript:void(0)" onclick="select_city('1','上海市')">上海市</a></li>
                                <li class="divider"></li>
                                <li><a href="javascript:void(0)" onclick="select_city('2','济南市')">济南市</a></li>
                            </ul>
                        </div>
                        <div class="btn-group">
                            <input type="hidden" name="area" id="area" value="海淀区"/>
                            <button type="button" id="area_btn" class="btn btn-default">海淀区</button>
                            <button type="button" class="btn btn-default dropdown-toggle"
                                    data-toggle="dropdown">
                                <span class="caret"></span>
                                <span class="sr-only">切换下拉菜单</span>
                            </button>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="javascript:void(0)" onclick="select_area('1','海淀区')">上海市</a></li>
                                <li class="divider"></li>
                                <li><a href="javascript:void(0)" onclick="select_area('2','历城区')">历城区</a></li>
                            </ul>
                        </div>

                    </div>
                    <div class="form-group">
                        <label  class="form-label">毕业时间</label>
                        <input type="text" name="graduateDate" class="form-control" value="2008-07-01" id="datetimepicker">
                    </div>
                    <div class="form-group">
                        <label for="school">毕业院校</label>
                        <input type="text" class="form-control" name="school" id="school" placeholder="毕业学校"/>

                    </div>
                    <input type="hidden" name="userId" id="userId" value="${user.id}"/>

                    <div class="text-center">
                        <button type="button" onclick="submit_teacher()" class="btn btn-skin btn-lg btn-block">下一步</button>
                    </div>
                </form>

            </div>
        </div>
    </div>
</section>
<!-- /Section: contact -->
<!-- Section: contact -->
<section id="student" style="padding-top:35px;" class="home-section nopadd-bot color-dark bg-gray text-center">
    <div class="container marginbot-20">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <div class="wow flipInY" data-wow-offset="0" data-wow-delay="0.4s">
                    <div class="section-heading text-center">
                        <h2 class="h-bold">成为学生</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row marginbot-80">
            <div class="col-md-8 col-md-offset-2">
                <form action="/mentor/user/student/extra"  id = "student_form" method="post"  role="form" class="contactForm" enctype=”multipart/form-data”>
                    <div class="form-group">
                        <label for="student_name" class="form-label">姓名</label>
                        <input type="text" name="name" class="form-control" id="student_name" placeholder="您的真实姓名"/>
                        <div class="validation"></div>
                    </div>
                    <div class="form-group">
                        <label for="province_btn" class="form-label">籍贯</label>
                        <div class="btn-group">
                            <input type="hidden" name="province" id="student_province" value="北京市"/>
                            <button type="button" id="student_province_btn" class="btn btn-default">北京市</button>
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                <span class="caret"></span>
                                <span class="sr-only">切换下拉菜单</span>
                            </button>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="javascript:void(0)" onclick="student_select_province('0','上海市')">北京市</a></li>
                                <li><a href="javascript:void(0)" onclick="student_select_province('1','上海市')">上海市</a></li>
                                <li class="divider"></li>
                                <li><a href="javascript:void(0)" onclick="student_select_province('2','山东省')">山东省</a></li>
                            </ul>
                        </div>
                        <div class="btn-group">
                            <input type="hidden" name="city" id="student_city" value="北京市"/>
                            <button type="button" id="student_city_btn" class="btn btn-default">北京市</button>
                            <button type="button" class="btn btn-default dropdown-toggle"  data-toggle="dropdown">
                                <span class="caret"></span>
                                <span class="sr-only">切换下拉菜单</span>
                            </button>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="javascript:void(0)" onclick="student_select_city('1','上海市')">上海市</a></li>
                                <li class="divider"></li>
                                <li><a href="javascript:void(0)" onclick="student_select_city('2','济南市')">济南市</a></li>
                            </ul>
                        </div>
                        <div class="btn-group">
                            <input type="hidden" name="area" id="student_area" value="海淀区"/>
                            <button type="button" id="student_area_btn" class="btn btn-default">海淀区</button>
                            <button type="button" class="btn btn-default dropdown-toggle"
                                    data-toggle="dropdown">
                                <span class="caret"></span>
                                <span class="sr-only">切换下拉菜单</span>
                            </button>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="javascript:void(0)" onclick="student_select_area('1','海淀区')">上海市</a></li>
                                <li class="divider"></li>
                                <li><a href="javascript:void(0)" onclick="student_select_area('2','历城区')">历城区</a></li>
                            </ul>
                        </div>

                    </div>
                    <div class="form-group">
                        <label for="student_school">毕业院校</label>
                        <input type="text" class="form-control" name="school" id="student_school" placeholder="毕业学校"/>
                    </div>
                    <div class="form-group">
                        <label  class="form-label">从事计算机时间</label>
                        <input type="text" name="workDate" class="form-control" value="2008-07-01" id="workDatetimepicker">
                    </div>
                    <div class="form-group">
                        <label for="company" class="form-label">目前所在公司</label>
                        <input type="text" class="form-control" name="company" id="company"/>
                        <div class="validation"></div>
                    </div>
                    <div class="form-group">
                        <label for="industry" class="form-label">公司所属行业</label>
                        <input type="text" class="form-control" name="industry" id="industry"/>
                        <div class="validation"></div>
                    </div>
                    <div class="form-group">
                        <label for="skilled_in" class="form-label">擅长技能</label>
                        <input type="text" class="form-control" name="skilledIn" id="skilled_in"/>
                        <div class="validation"></div>
                    </div>
                    <div class="form-group">
                        <label for="short_skill" class="form-label">欠缺技能</label>
                        <input type="password" class="form-control" name="shortSkill" id="short_skill"/>
                        <div class="validation"></div>
                    </div>
                    <div class="form-group">
                        <label for="skill_label" class="form-label">技能标签</label>
                        <input type="password" class="form-control" name="skill_label" id="skill_label"/>
                        <div class="validation"></div>
                    </div>
                    <div class="form-group">
                        <label for="person_label" class="form-label">个人标签</label>
                        <input type="text" class="form-control" name="personLabel" id="person_label" placeholder="自我评价"/>
                        <div class="validation"></div>
                    </div>
                    <div class="form-group">
                        <label class="form-label" for="inputfile">上传简历</label>
                        <input class="form-control" type="file" id="inputfile">
                    </div>

                    <input type="hidden" name="userId" id="studentUserId" value="${user.id}"/>
                    <div class="text-center">
                        <button type="button" onclick="submit_student()" class="btn btn-skin btn-lg btn-block">成为学生</button>
                    </div>
                </form>

            </div>
        </div>
    </div>
</section>
<!-- /Section: contact -->
<!-- Core JavaScript Files -->
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/plugin/bootstrap/js/bootstrap.min.js"></script>
<script src="/js/bootstrap-datetimepicker.min.js"/>
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
    $.fn.datetimepicker.dates['en'] = {
        days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
        daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
        daysMin:  ["日", "一", "二", "三", "四", "五", "六", "日"],
        months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
        monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
        today: "今天",
        suffix: [],
        meridiem: ["上午", "下午"]
    };
    function submit_teacher(){
        $("#teacher_form").submit();
    }
    function submit_student(){
        $("#student_form").submit();
    }
    $(function(){
        $('#datetimepicker').datetimepicker({
            autoclose:true,
            format: 'yyyy-mm-dd',
            minView:3,
            startView:3
        });
        $('#workDatetimepicker').datetimepicker({
            autoclose:true,
            format: 'yyyy-mm-dd',
            minView:3,
            startView:3
        });
    });
    function select_province(id,name) {
        $("#province_btn").text(name);
        $("#province").val(id);
    }
    function select_city(id,name) {
        $("#city_btn").text(name);
        $("#city").val(id);
    }
    function select_area(id,name) {
        $("#area_btn").text(name);
        $("#area").val(id);
    }
    function student_select_province(id,name) {
        $("#student_province_btn").text(name);
        $("#student_province").val(id);
    }
    function student_select_city(id,name) {
        $("#student_city_btn").text(name);
        $("#student_city").val(id);
    }
    function student_select_area(id,name) {
        $("#student_area_btn").text(name);
        $("#student_area").val(id);
    }
</script>
</body>

</html>
