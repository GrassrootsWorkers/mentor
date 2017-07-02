<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta content="text/html;charset=utf-8"/>
    <title>${categoryName}</title>
    <script src="/js/jquery-3.2.1.min.js"></script>

    <link rel="stylesheet" href="/plugin/bootstrap/css/bootstrap.min.css"/>
    <script src="/plugin/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">APIStore</a>
        </div>
        <div>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>
    </div>
</nav>
<ol class="breadcrumb">
    <li><a href="#">${fatherName}</a></li>
    <li class="active">${categoryName}</li>
</ol>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-6 column">
            <div><img src="${baseInfo.icon}"/></div>
            <div>购买次数：${baseInfo.appCount}</div>
            <div>浏览次数：${baseInfo.clickedCount}</div>
            <div>收藏次数：${baseInfo.collectCount}</div>
            <div>评论次数：${baseInfo.reviewCount}</div>
        </div>
        <div class="col-md-6 column">
            <div>价格：￥${minPrice}起
                <button id="fat-btn" onclick="show_package()" class="btn btn-primary" data-loading-text="Loading..."
                        type="button"> 查看套餐
                </button>
            </div>
            <div><span>所属分类:</span></span>${categoryName}</div>
        <#list providers as provider>
            <div><span>服务商:</span>${provider.provider}</div>
        </#list>
        <#list providers as provider>
            <div id="provider_" +${provider.id}>
                <div><span>更新时间:</span></span>${provider.updateDate?string("yyyy-MM-dd HH:mm:ss")}</div>
                <div><span>服务简介:</span>${provider.providerDesc}</div>
            </div>
        </#list>


        </div>


    </div>
</div>
<table class="table" id="pricing_package" style="display: none">
    <caption>基本套餐</caption>

    <tbody>
    <#list pricing as price >
    <tr>
        <td>${price.name}</td>
        <td>${price.price}</td>
        <td>峰值:${price.peakValue}</td>
        <#if (price.chargeType ==0)>
            <td>按次计费，最大调用次数:${price.maxTimes}</td>
        <#elseif (price.chargeType ==1)>
            <td>按天计费,最大调用次数:${price.maxTimes}</td>
        <#elseif (price.chargeType ==2)>
            <td>按周计费,最大调用次数:${price.maxTimes}</td>
        <#elseif (price.chargeType ==3)>
            <td>按月计费,最大调用次数:${price.maxTimes}</td>
        <#else>
            <td>按年计费,最大调用次数:${price.maxTimes}</td>
        </#if>

        <td>${price.desc}</td>
        <td>${price.updateDate?string("yyyy-MM-dd HH:mm:ss")}</td>
        <td><input type="text" id="package_count_${price.id}" value="1"/></td>
        <td>
            <button type="button" onclick="buy_pricing_package(${price.apiId},${price.id})" class="btn btn-primary"
                    data-toggle="button">提交
            </button>
        </td>
    </tr>
    </#list>


    </tbody>
</table>
<script src="/js/jquery.cookie.js"></script>
<script type="text/javascript">
    function show_package() {
        $("#pricing_package").show()
    }
    function buy_pricing_package(apiId,id) {
        $.ajax({
            url: "/order/prepare",
            type: "POST",
            dataType: "json",
            async: false,
            data: {
                "apiId": apiId,
                "pricingPackageId":id,
                "count": $("#package_count_"+id).val()
            },
            success: function (data) {
               if("login" == data.code);{
                   $.cookie("apiId", apiId , { path: '/'});
                   window.location.href="http://localhost:8080/html/mentorUser/user_login.html";
                }
            }

        });
    }
</script>
</body>
</html>