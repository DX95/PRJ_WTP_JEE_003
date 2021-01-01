<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath%>">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>去哪玩_登录</title>
    <link type="text/css" rel="stylesheet" href="css/login.css" />
    <script type="text/javascript" src="js/jquery/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="js/pages/login/login.js"></script>

    <script>
        $(function () {
            var init = getUrlParam('init');
            var type = getUrlParam('type');
            if (init == 'reg') {
                $("#third_part").show();
                $("#logins").show();
                $("#pwd_p").hide();
                $("#regesits").hide();
                $("#identfy_all").hide();
                $(":button").val("注 册");
                $("#logo_img").css("display", "block");
                $("#button").click(function () {
                    register('loginForm');
                });
            }

            if (type == 'loginerror') {
                $("#contents").text("用户名或密码错误！");
            } else if (type == 'regerror') {
                $("#contents").text("当前注册账号已存在！");
            } else if (type == 'codeerror') {
                $("#contents").text("验证码错误，请重新输入！");
            } else {
                $("#contents").text("");
            }

            function getUrlParam(name) {
                var href = window.location.href;
                var params_str = href.substring(href.indexOf('?', 0) + 1, href.length);
                var params = params_str.split('&');
                for (var i = 0; i < params.length; i++) {
                    var param = params[i];
                    var key = param.split('=')[0];
                    var value = param.split('=')[1];

                    if (name == key)
                        return value;
                }
                return '';
            }

            $(".identifying img").attr('src', getProjectName() + "/code.jhtml?");

            function getProjectName() {
                var curWwwPath = window.document.location.href;
                var pathName = window.document.location.pathname;
                var pos = curWwwPath.indexOf(pathName);
                var localhostPaht = curWwwPath.substring(0, pos);
                var projectName = pathName.substring(0, pathName.substr(1).indexOf(
                    '/') + 1);
                return projectName;
            }
        })
    </script>
    <%!
        String name;
        String pwd;
    %>
    <%
        Cookie[] cookies= request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("tid")){
                name=cookie.getValue();
            }else if (cookie.getName().equals("pwd")){
                pwd=cookie.getValue();
            }
        }
    %>
</head>
<body>
<!-- 背景  开始 -->
<div class="backgrounds" id="backgrounds">
    <!-- 表单框 -->
    <div class="content" id="div_position">

        <div class="login_framework">

            <!-- PRJ-WTP-JEE-003：模拟用户登录 form的action配置 【Start】 -->
            <form id="log_reg_form" method="post" name="loginForm" action="${pageContext.request.contextPath}/login.jhtml">
                <!-- PRJ-WTP-JEE-003：模拟用户登录 form的action配置 【End】 -->

                <div class="content2">
                    <div id="contents" class="contents"></div>
                    <ul>
                        <li><input id="tid" name="tid" type="text" class="text"
                                   value="<%=(name==null? "" :name)%>"  /><br /></li>
                    </ul>
                    <ul id="pwd_p">
                        <li><input type="password" name="pwd" id="pwd" class="text"
                                   value="<%=(pwd==null? "" :pwd)%>" /></li>
                    </ul>
                    <!-- 验证码获取的时候，点击刷新，需要不同的请求才会刷新，因此我们给一个时间参数，使请求每一时刻都不同，达到刷新验证码的目的 -->
                    <ul id="identfy_all">
                        <li>
								<span class="identifying">

									<%--<img width="120px" height="40px"
                                         onclick="javascript:this.src=getProjectName()+'/code.jhtml?id='+new Date().getMilliseconds()">--%>

                                    <img src="code.jhtml" height="40px" width="120px" alt="" onclick="changeCheckCode(this)">
									<script type="text/javascript">
										//图片点击事件
                                        function changeCheckCode(img) {
                                            img.src="code.jhtml?"+new Date().getTime();
                                        }
									</script>
								</span>
                            <input type="text" name="code" id="ident" class="text identify" value="验证码" />
                        </li>
                    </ul>
                    <span class="rem_password"> <a href="#" class="texts">忘记密码?</a>
						</span> <input class="login_button" id="button" value="登  录"
                                       type="button"/>
                </div>
            </form>
            <div class="third_part centers" id="third_part"
                 style="display: none;">
                <div class="hro"></div>
                <div class="content_th">
                    用合作网站账户直接登录<br /> <a href="#" class="posit"><img
                        src="img/sina.png"><br />
                    <p>新浪微博</p></a> <a href="#" class="posit"><img src="img/qq.png"><br />
                    <p>QQ</p></a> <a href="#" class="posit"><img src="img/renren.png"><br />
                    <p>人人网</p></a> <a href="#" class="posit"><img src="img/so.png"><br />
                    <p>更多</p></a>
                </div>
            </div>
        </div>
        <div class="regist" id="regesits">
            还没有帐号?<span class="texts cursors">马上注册</span>
        </div>
        <div class="logins" id="logins" style="display: none;">
            已经注册?<span class="texts cursors">马上登录</span>
        </div>
    </div>
</div>
<!-- 背景  结束 -->

</body>
</html>