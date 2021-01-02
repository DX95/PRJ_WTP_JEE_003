
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<base href="<%=basePath%>">
<head lang="en">

    <meta charset="UTF-8">
    <title>个人空间-个人信息</title>
    <link rel="stylesheet" href="common/css/common.css">
    <link rel="stylesheet" href="css/jquery.Jcrop.min.css" />
    <link rel="stylesheet" type="text/css" href="css/img_account.css" />
    <link type="text/css" rel="stylesheet" href="css/personalCss.css" />

    <script type="text/javascript" src="js/jquery/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery.Jcrop.min.js"></script>

    <script src="js/common.js" type="text/javascript"></script>
    <script type="text/javascript">

        var jcrop_api, boundx, boundy, $preview, $pcnt, pimg;
        var xsize, ysize;
        $(document).ready(function (e) {
            $preview = $('.img-preview');
            $pcnt = $('.img-preview .img-contbox');
            $pimg = $('.img-preview .img-contbox img');
            xsize = $pcnt.width();
            ysize = $pcnt.height();
        });
    </script>

<%--    <script type="text/javascript" src="js/person_information.js"></script>--%>
    <script type="text/javascript" src="js/jquery.DB_gallery.js"></script>

    <!-- 星星等级插件 -->
    <script src="js/jquery.barrating.js"></script>
    <script src="js/examples.js"></script>

    <!-- 待评论上传图片 -->
    <!-- 引用核心层插件 -->
    <script type="text/javascript" src="js/zyFile.js"></script>
    <!-- 引用控制层插件 -->
    <script type="text/javascript" src="js/zyUpload.js"></script>
    <%--<script type="text/javascript">
        $(function () {
            $("#three").click(function () {
                alert(222)
            });
            /* $("#my_head").click(function () {
                 alert("111");
                 $("#per_de").css("color", "#fefefe");
                 $(this).css("color", "#000");
                 $("#my_head").css("font-weight", "900");
                 $("#per_de").css("background", "#d8619b");
                 $("#per_de").css("color", "white");
                 $("#per_de").removeClass('content_right_li_bg_c');
                 $("#my_head").addClass('content_right_li_bg_c');
                 $("#per_detail_content").hide();
                 $("#head_detail_content").show();
             });*/
        });
        function fun() {
            alert("111");
            $("#per_de").css("color", "#fefefe");
            $(this).css("color", "#000");
            $("#my_head").css("font-weight", "900");
            $("#per_de").css("background", "#d8619b");
            $("#per_de").css("color", "white");
            $("#per_de").removeClass('content_right_li_bg_c');
            $("#my_head").addClass('content_right_li_bg_c');
            $(".per_detail_content").hide();
            $(".head_detail_content").show();
        }

    </script>--%>
    <script>
        $(function () {
            // 个人资料
            $("#per_de").click(function() {
                $(this).css("color", "#000");
                $("#per_de").css("background", "white");
                $("#per_de").css("color", "#000");
                $("#per_de").css("font-weight", "900");
                $("#my_head").css("color", "#fefefe");
                $("#per_de").addClass('content_right_li_bg_c');
                $("#my_head").removeClass('content_right_li_bg_c');
                $(".per_detail_content").show();
                $(".head_detail_content").hide();
            });

            // 我的头像
            $("#my_head").click(function() {
                $("#per_de").css("color", "#fefefe");
                $(this).css("color", "#000");
                $("#my_head").css("font-weight", "900");
                $("#per_de").css("background", "#d8619b");
                $("#per_de").css("color", "white");
                $("#per_de").removeClass('content_right_li_bg_c');
                $("#my_head").addClass('content_right_li_bg_c');
                $(".per_detail_content").hide();
                $(".head_detail_content").show();
            });
        });
    </script>
</head>
<body>

<!-- 顶端开始 -->
<div  style="width:100%; height:163px;">
    <script type="text/javascript" src="common/js/header.js"></script>
</div>
<!-- 顶端结束  -->

<!-- 个人空间 开始-->

<div class="content_infor">
    <a href="#">我的驴妈妈</a><img class="next " src="img/next.png" /> <a
        href="#">我的信息</a><img class="next " src="img/next.png" /> <a href="#">我的个人空间</a>
</div>
<div class="content_all">
    <!-- 左边  菜单栏开始-->
    <div class="content_left ">
        <div class="content_left_first">
            <c:choose>
                <c:when test="${empty use.img_path}">
                    <img src="img/1.jpg" class="img_head" />
                </c:when>
                <c:otherwise>
                    <img src="img/${use.img_path}" class="img_head" />
                </c:otherwise>
            </c:choose>

            <p>编辑我的资料</p>
        </div>
        <div class="content_left_two">
            <ul>
                <li id="my_re_list"><span class="icon  icon_my_re_list ">
					</span> <span class="position_my_re_list"> <a
                        href="personal_myOrder.html"> 我的约单 </a>
					</span></li>
                <li id="personal_detail" class="backgroundClass"><span
                        class="icon  icon_my_re_list  icon_personal"> </span> <span
                        class="position_my_re_list"> <a
                        href="personal_information.html"> 个人信息 </a>
					</span></li>
                <li id="password_detail"><span
                        class="icon  icon_my_re_list  icon_password" style=""> </span> <span
                        class="position_my_re_list"> <a
                        href="personal_passwordChange.html"> 密码修改 </a>
					</span></li>
                <li id="my_comment"><span
                        class="icon  icon_my_re_list icon_comment " style=""> </span> <span
                        class="position_my_re_list"> <a
                        href="personal_myComments.html"> 我的点评 </a>
					</span></li>
                <span class="hr_css">
						<hr style="width: 120px; border-top: 1px #ccc solid;" />
					</span>
                <li id="usually_tourist_infor"><span
                        class="icon  icon_my_re_list iconusually" style=""> </span> <span
                        class="position_my_re_list"> <a
                        href="personal_touristInformation.html"> 常用游客信息 </a>
					</span></li>
                <li><span class="icon  icon_my_re_list icon_card " style="">
					</span> <span class="position_my_re_list">礼品卡</span></li>
                <li><span class="icon  icon_my_re_list iconmoney " style="">
					</span> <span class="position_my_re_list">我的积分</span></li>
                <li><span class="icon  icon_my_re_list icon_email " style="">
					</span> <span class="position_my_re_list">邮件订阅</span></li>
                <span class="hr_css">
						<hr style="width: 120px; border-top: 1px #ccc solid;" />
					</span>
                <li><span class="icon  icon_my_re_list icon_vip" style="">
					</span> <span class="position_my_re_list ">会员俱乐部</span></li>
                <li><span class="icon  icon_my_re_list icon_way" style="">
					</span> <span class="position_my_re_list">我的攻略</span></li>
                <li><span class="icon  icon_my_re_list icon_collection"
                          style=""> </span> <span class="position_my_re_list">我的收藏</span></li>
                <li><span class="icon  icon_my_re_list icon_my_tour" style="">
					</span> <span class="position_my_re_list">我的游记</span></li>
            </ul>
        </div>
    </div>
    <!-- 左边  菜单栏结事-->

    <!-- 右侧  选项卡开始-->
    <div class="content_right_pa">

        <!-- 右侧  个人资料开始-->
        <div class="content_right " id="personal_detail_content"
             style="display: block;">
            <div class="head_detail">

                <ul>
                    <li id="per_de">个人资料编辑</li>
                    <li id="my_head" >头像编辑</li>
                </ul>
            </div>
            <div class="per_detail_content">
                <form name="personForm" method="post" action="personal_information.html">
                    <ul>
                        <li><label> <span class="redcolor">*</span>昵称：
                        </label> <input type="text" placeholder="请输入昵称" id="myname" name="myname"
                                        class="input_style" onBlur="checkNames()" value="${use.name}"/> <span
                                id="myname_msg"></span></li>

                        <li><label>性别：</label>
                            <c:choose>
                                <c:when test="${use.sex=='女'}">
                                    <input type="radio" name="sex" value="男"   /> 男
                                    <input type="radio" name="sex" value="女" checked /> 女</li>
                                </c:when>
                                <c:otherwise>
                                     <input type="radio" name="sex" value="男" checked /> 男
                                    <input type="radio" name="sex" value="女"  /> 女</li>
                                </c:otherwise>
                            </c:choose>

                        <li><label> <span class="redcolor">*</span>手机号：
                        </label> <input type="text" placeholder="请输入手机号码" id="mobile" name="mobile"
                                        class="input_style" onchange="checkMobile()" value="${use.phone}"/> <span
                                id="mobile_tip"> </span></li>
                        <li><label> <span class="redcolor">*</span>邮箱：
                        </label> <input type="text" placeholder="请输入邮箱" id="email" name="email"
                                        class="input_style" onBlur="checkEmail()" value="${use.email}"/> <span
                                id="email_msg"></span></li>
                        <li><label> <span class="redcolor">*</span>真实姓名：
                        </label> <input type="text" placeholder="请输入真实姓名" id="realname" name="realname"
                                        class="input_style" onBlur="checkName()" value="${use.real_name}"/> <span
                                id="realname_msg"></span></li>
                        <li><label> <span class="redcolor">*</span>身份证：
                        </label> <input type="text" placeholder="请输入身份证号" id="cardId" name="cardId"
                                        class="input_style" onBlur="checkCardId()" /> <span
                                id="cardIdMsg"></span></li>

                        <li><label> 生日：</label>
                            <input type="date" class="input_style" id="birthday" name="birthday" value="${use.birthday}" placeholder="年/月/日" />
                        </li>
                         <%--   <select class="sel_year">
                            <option>---年---</option>
                            <option>1989</option>
                            <option>1990</option>
                            <option>1991</option>
                            <option>1992</option>
                            <option>1993</option>
                            <option>1994</option>
                        </select> <select class="sel_month">
                            <option>---月---</option>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                            <option>7</option>
                            <option>8</option>
                        </select> <select class="sel_day">
                            <option>---日---</option>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                            <option>7</option>
                            <option>8</option>
                            <option>9</option>
                            <option>10</option>
                            <option>11</option>
                            <option>12</option>
                            <option>13</option>
                            <option>14</option>
                            <option>15</option>
                        </select></li>--%>

                        <li><label>地区：</label> <select id="province"
                                                       class="cityclass">
                            <option>----请选择省份----</option>
                            <option>北京</option>

                        </select> <select id="select_city" class="city cityclass" >
                            <option>----请选择城市----</option>
                            <option>东城</option>
                            <option>西城</option>
                            <option>崇文</option>
                            <option>宣武</option>
                            <option>朝阳</option>
                        </select> <span id="city_msg"></span></li>
                        <li><label> </label> <input type="submit"
                                                    class="save_button" id="save_button" value="保  存"
                                                    onmouseover="mouseOver()" onmouseout="mouseOut()" /></li>

                    </ul>
                </form>
            </div>
            <div class="head_detail_content">

                <!-- PRJ-WTP-JEE-006：上传用户头像 设置表单提交url 【Start】 -->
                <form name="headForm" method="post" action="${pageContext.request.contextPath}/TestServlet" enctype="multipart/form-data" >
                    <!-- PRJ-WTP-JEE-006：上传用户头像 设置表单提交url 【End】 -->

                    <div class="headMain">
                        <div class="preview_pane">
                            <p>设置您的头像：</p>
                            <p class="preview_background">
                                <img src="img/" id="target" class="mainImage" />
                            </p>
                            <p>仅支持GIF、JPG、PNG图片</p>
                        </div>
                        <div class="source_pane">
                            <p>头像预览（大小：200 * 200）</p>
                            <div class="img-preview">
                                <div class="img-contbox">
                                    <img src="img/" id="litte_pre" class="jcrop-preview"
                                         alt="Preview">
                                </div>
                            </div>
                            <div>
                                <a href="javascript:void(0);" class="file">上传照片
                                    <input type="file" name="image" id="imgOne" accept=".png,.jpg,.gif"
                                        onChange="preImg(this.id);">
                                </a>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" id="x1" name="x1" /> <input type="hidden"
                                                                     id="y1" name="y1" /><input type="hidden"
                                                                                                id="w" name="w" /> <input type="hidden" id="h" name="h" /> <input
                        type="hidden" id="ratio" name="ratio" /> <img
                        style="display: none" src="img/icon.jpg" id="org_file"
                        name="org_file" />
                    <div class="text-center" style="margin-top: 100px">
                        <input type="submit" id="btnHeadSave"
                               class="save_button save_left" onclick="checkImage()"
                               value="保   存" />
                    </div>
                </form>
            </div>
        </div>
        <!-- 右侧  个人资料  开始-->
    </div>
    <!-- 右边  选项卡结束-->
</div>
<!-- 个人空间 结束-->

<!-- 引入尾部开始 -->
<iframe src="common/footer.html"
        style="width: 100%; height: 650px; border: 0; overflow: hidden;"></iframe>
<!-- 引入尾部结束 -->

</body>
</html>
