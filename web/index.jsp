<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<base href="<%=basePath%>">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="./css/index.css" />
    <!--场景 PRJ-WTP-WEB-035  直达顶部火箭【3/3 START】-->
    <link rel="stylesheet" href="./css/toTop.css" />
    <!--场景 PRJ-WTP-WEB-035  直达顶部火箭【3/3 END】-->
    <link href="css/index.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="common/css/common.css">

    <script src="js/jquery-1.10.2.min.js"></script>
    <script src="js/top.js"></script>

    <script type="text/javascript">
        function movein(x){
            x.style.fontSize="14px";
        }

        function moveout(y){
            y.style.fontSize="12px";
        }

    </script>

</head>
<body onload="time()" >
<!-- 顶端 -->
<input id="pic" type="hidden" value="${tid}"/>
<%--<div id="1" style="width:100%; height:163px;">
    <script type="text/javascript" src="common/js/header.js"></script>
</div>--%>
<jsp:include page="header.jsp"></jsp:include>
<!-- 内容模块开始 -->
<div id="2" class="public-box" data-count-first="国内游">
    <div class="public-tit">
        <h3><strong>国内游</strong><span>拎包就走,轻松出游</span></h3>
        <a class="public-tit-more fr" href="../trip/search.html" target="_blank">更多周边游</a></div>

    <!-- 公共左边导航模块开始 -->
    <div class="public-asidebg" data-count-first="左侧导航">
        <div class="public-asidenav">
            <div class="min-title">热点景点</div>
            <!-- 导航栏内容部分 -->
            <div class="navigation-content">
                <center>
                    <table class="navigation-table">
                        <%--<c:forEach items="${Place}" var="place" >
                            <tr>
                                <c:if test="${place.id%2!=0}">
                                    <td align="right" width="100px"><a href="../trip/search.html">${place.name}</a></td>
                                </c:if>
                                <td width="30px"></td>
                                <c:if test="${(place.id+1)%2==0}">
                                    <td align="left" width="100px"><a href="../trip/search.html">${place.name}</a></td>
                                </c:if>

                            </tr>
                        </c:forEach>--%>

                           <%-- <c:forEach items="${Place}" var="place" begin="1" step="2">
                            <tr>
                                <td align="left" width="100px"><a href="../trip/search.html">${place.name}</a></td>
                                <td width="30px"></td>
                                <c:forEach items="${Place}" var="place" begin="0" step="2">
                                    <td align="right" width="100px"><a href="../trip/search.html">${place.name}</a></td>
                                </c:forEach>
                            </tr>
                            </c:forEach>--%>
                        <tr>
                             <td align="right"><a href="${pageContext.request.contextPath}/SearchServlet?type2=${Place[0].name}">${Place[0].name}</a></td>
                            <td width="30px"></td>
                            <td align="left"><a href="${pageContext.request.contextPath}/SearchServlet?type2=${Place[1].name}">${Place[1].name}</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="${pageContext.request.contextPath}/SearchServlet?type2=${Place[2].name}">${Place[2].name}</a></td>
                            <td></td>
                            <td align="left"><a href="${pageContext.request.contextPath}/SearchServlet?type2=${Place[3].name}">${Place[3].name}</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="${pageContext.request.contextPath}/SearchServlet?type2=${Place[4].name}">${Place[4].name}</a></td>
                            <td></td>
                            <td align="left"><a href="${pageContext.request.contextPath}/SearchServlet?type2=${Place[5].name}">${Place[5].name}</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="${pageContext.request.contextPath}/SearchServlet?type2=${Place[6].name}">${Place[6].name}</a></td>
                            <td></td>
                            <td align="left"><a href="${pageContext.request.contextPath}/SearchServlet?type2=${Place[7].name}">${Place[7].name}</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="${pageContext.request.contextPath}/SearchServlet?type2=${Place[8].name}">${Place[8].name}</a></td>
                            <td></td>
                            <td align="left"><a href="${pageContext.request.contextPath}/SearchServlet?type2=${Place[9].name}">${Place[9].name}</a></td>
                        </tr>
                    </table>
                    <!-- 场景 PRJ-WTP-WEB-004：热门景点 - 景点列表1 【1/2 end】 -->
                </center>
            </div>
            <div class="line1_style">
                <img src="images/line1.png" width="23px" height="211px" alt=""/>
            </div>

            <div class="min-title">热门主题</div>
            <div class="navigation-content">
                <center>
                    <table class="navigation-table">
                        <tr>
                            <td align="right" width="100px"><a href="../trip/search.html">${Theme[0].name}</a></td>
                            <td width="30px"></td>
                            <td align="left" width="100px"><a href="../trip/search.html">${Theme[1].name}</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="../trip/search.html">${Theme[2].name}</a></td>
                            <td></td>
                            <td align="left"><a href="../trip/search.html">${Theme[3].name}</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="../trip/search.html">${Theme[4].name}</a></td>
                            <td></td>
                            <td align="left"><a href="../trip/search.html">${Theme[5].name}</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="../trip/search.html">${Theme[6].name}</a></td>
                            <td></td>
                            <td align="left"><a href="../trip/search.html">${Theme[7].name}</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="../trip/search.html">${Theme[8].name}</a></td>
                            <td></td>
                            <td align="left"><a href="../trip/search.html">${Theme[9].name}</a></td>
                        </tr>
                    </table>
                </center>
            </div>
            <div class="line2_style">
                <img src="./images/line2.png" width="23px" height="184px" alt=""/>
            </div>
        </div>

    </div>
    <!-- 公共左边导航模块结束 -->

    <!-- 自由行侧边产品list -->
    <div class="public-pro fls freedomWalk-detail" id="freedomWalk-detail1" data-count-first="右侧图片列表">
        <div class="pro-list">
            <!-- 场景 PRJ-WTP-WEB-003：推荐景点列表排序 - 列表1 【1/3 start】 -->
            <ul>
                <c:forEach items="${infs}" var="inf">
                    <li <%--onclick="javascript:href='${pageContext.request.contextPath}/TripDetailServlet?id=${inf.id}'"--%>>
                        <div class="pro_list_content">
                            <!-- 场景 PRJ-WTP-WEB-002：推荐景点图像显示 【1/1 start】 -->
                            <p>
                                <a href="${pageContext.request.contextPath}/TripDetailServlet?id=${inf.id}">
                                    <img href="${pageContext.request.contextPath}/TripDetailServlet?id=${inf.id}" src="image_cache/${inf.name}" width="290" height="200" border="1">

                                </a>
                            </p>
                            <p onmouseover="movein(this)" onmouseout="moveout(this)">
							<span class="pro-list-price fr">
								<span>￥</span>
								<span>${inf.price}</span>&nbsp;起
							</span>
                                <span>${inf.s_title}</span>
                            </p>
                        </div>
                    </li>
                </c:forEach>

                <%--<li>
                    <div class="pro_list_content">
                        <p ><a href="../tourist_detail/tourist_detail.html" title="111恐龙城万圣节" target="_blank"><img src="./images/02.jpeg"
                                                                                                                   alt="111恐龙城万圣节" width="290"
                                                                                                                   height="200"> </a></p>
                        <p  onmouseover="movein(this)" onmouseout="moveout(this)" ><span class="pro-list-price fr"><i>￥</i><em>290</em>起</span> <a href="#"
                                                                                                                                                   title="###"
                                                                                                                                                   target="_blank">111恐龙城万圣节</a>
                        </p>
                    </div>
                </li>
                <li>
                    <div class="pro_list_content">
                        <p><a href="../tourist_detail/tourist_detail.html" title="111恐龙城万圣节" target="_blank"><img src="./images/03.jpg"
                                                                                                                  alt="111恐龙城万圣节" width="290"
                                                                                                                  height="200"> </a></p>

                        <p onmouseover="movein(this)" onmouseout="moveout(this)"><span class="pro-list-price fr"><i>￥</i><em>679</em>起</span> <a href="#"
                                                                                                                                                 title="###"
                                                                                                                                                 target="_blank">111千岛湖2天1晚·住希尔顿</a>
                        </p>
                    </div>
                </li>
                <li>
                    <div class="pro_list_content">
                        <p><a href="../tourist_detail/tourist_detail.html" title="111千岛湖2天1晚·住希尔顿" target="_blank"><img src="./images/04.jpeg"
                                                                                                                        alt="111千岛湖2天1晚·住希尔顿" width="290"
                                                                                                                        height="200"> </a></p>

                        <p onmouseover="movein(this)" onmouseout="moveout(this)"><span class="pro-list-price fr"><i>￥</i><em>679</em>起</span> <a href="../trip/search.html"
                                                                                                                                                 title="111千岛湖2天1晚·住希尔顿"
                                                                                                                                                 target="_blank">111千岛湖2天1晚·住希尔顿</a>
                        </p>
                    </div>
                </li>
                <li>
                    <div class="pro_list_content">
                        <p><a href="../tourist_detail/tourist_detail.html" title="111千岛湖2天1晚·住希尔顿" target="_blank"><img src="./images/05.jpg"
                                                                                                                        alt="111千岛湖2天1晚·住希尔顿" width="290"
                                                                                                                        height="200"> </a></p>

                        <p onmouseover="movein(this)" onmouseout="moveout(this)"><span class="pro-list-price fr"><i>￥</i><em>679</em>起</span> <a href="#"
                                                                                                                                                 title="111千岛湖2天1晚·住希尔顿"
                                                                                                                                                 target="_blank">111千岛湖2天1晚·住希尔顿</a>
                        </p>
                    </div>
                </li>--%>
            </ul>
        </div>
    </div>

</div>
<div id="3" class="public-box" data-count-first="境外游">
    <div class="public-tit">
        <h3><strong>境外游</strong><span>世界有多大，我就玩多远</span></h3>
        <a class="public-tit-more fr" href="../trip/search.html" target="_blank">更多周边游</a></div>

    <!-- 公共左边导航模块开始 -->
    <div class="public-asidebg" data-count-first="左侧导航">
        <div class="public-asidenav">
            <div class="min-title">热门景点</div>
            <!-- 导航栏内容部分 -->
            <div class="navigation-content">
                <center>
                    <table class="navigation-table">
                        <tr>
                            <td align="right" width="100px"><a href="../trip/search.html">长滩岛</a></td>
                            <td width="30px"></td>
                            <td align="left" width="100px"><a href="../trip/search.html">普吉岛</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="../trip/search.html">泰国</a></td>
                            <td></td>
                            <td align="left"><a href="../trip/search.html">日本</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="../trip/search.html">巴厘岛</a></td>
                            <td></td>
                            <td align="left"><a href="../trip/search.html">香港</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="../trip/search.html">新加坡</a></td>
                            <td></td>
                            <td align="left"><a href="../trip/search.html">塞班岛</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="../trip/search.html">柬埔寨</a></td>
                            <td></td>
                            <td align="left"><a href="../trip/search.html">韩国</a></td>
                        </tr>
                    </table>
                </center>
            </div>
            <div class="line1_style">
                <img src="./images/line1.png" width="23px" height="211px" alt=""/>
            </div>

            <div class="min-title">热门主题</div>
            <div class="navigation-content">
                <center>
                    <table class="navigation-table">
                        <tr>
                            <td align="right" width="100px"><a href="../trip/search.html">达人专享</a></td>
                            <td width="30px"></td>
                            <td align="left" width="100px"><a href="../trip/search.html">当地玩乐</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="../trip/search.html">DFS返现</a></td>
                            <td></td>
                            <td align="left"><a href="../trip/search.html">探秘极光</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="../trip/search.html">游学系列</a></td>
                            <td></td>
                            <td align="left"><a href="../trip/search.html">亲自出游</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="../trip/search.html">假日海岛</a></td>
                            <td></td>
                            <td align="left"><a href="../trip/search.html">自驾系列</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="../trip/search.html">高尔夫系列</a></td>
                            <td></td>
                            <td align="left"><a href="../trip/search.html">潜水系列</a></td>
                        </tr>
                    </table>
                </center>
            </div>
            <div class="line2_style">
                <img src="./images/line2.png" width="23px" height="184px" alt=""/>
            </div>
        </div>

    </div>
    <!-- 公共左边导航模块结束 -->

    <!-- 自由行侧边产品list -->
    <div class="public-pro fls freedomWalk-detail" id="freedomWalk-detail2" data-count-first="右侧图片列表">
        <!--周末游推荐景点-->
        <div class="pro-list">
            <ul>
                <li>
                    <div class="pro_list_content">
                        <p>
                            <a href="../tourist_detail/tourist_detail.html" title="111恐龙城万圣节" target="_blank"><img src="./images/01.jpg" alt="111恐龙城万圣节" width="290"   height="200"> </a>
                        </p>
                        <p><span class="pro-list-price fr"><i>￥</i><em>290</em>起</span> <a href="../trip/search.html"
                                                                                           title="111恐龙城万圣节"
                                                                                           target="_blank">111恐龙城万圣节</a>
                        </p>
                    </div>
                </li>
                <li>
                    <div class="pro_list_content">
                        <p><a href="../tourist_detail/tourist_detail.html" title="111恐龙城万圣节" target="_blank"><img src="./images/02.jpeg"
                                                                                                                  alt="111恐龙城万圣节" width="290"
                                                                                                                  height="200"> </a></p>

                        <p><span class="pro-list-price fr"><i>￥</i><em>290</em>起</span> <a href="#"
                                                                                           title="###"
                                                                                           target="_blank">111恐龙城万圣节</a>
                        </p>
                    </div>
                </li>
                <li>
                    <div class="pro_list_content">
                        <p><a href="../tourist_detail/tourist_detail.html" title="111恐龙城万圣节" target="_blank"><img src="./images/03.jpg"
                                                                                                                  alt="111恐龙城万圣节" width="290"
                                                                                                                  height="200"> </a></p>

                        <p><span class="pro-list-price fr"><i>￥</i><em>679</em>起</span> <a href="#"
                                                                                           title="###"
                                                                                           target="_blank">111千岛湖2天1晚·住希尔顿</a>
                        </p>
                    </div>
                </li>
                <li>
                    <div class="pro_list_content">
                        <p><a href="../tourist_detail/tourist_detail.html" title="111千岛湖2天1晚·住希尔顿" target="_blank"><img src="./images/04.jpeg"
                                                                                                                        alt="111千岛湖2天1晚·住希尔顿" width="290"
                                                                                                                        height="200"> </a></p>

                        <p><span class="pro-list-price fr"><i>￥</i><em>679</em>起</span> <a href="../trip/search.html"
                                                                                           title="111千岛湖2天1晚·住希尔顿"
                                                                                           target="_blank">111千岛湖2天1晚·住希尔顿</a>
                        </p>
                    </div>
                </li>
                <li>
                    <div class="pro_list_content">
                        <p><a href="../tourist_detail/tourist_detail.html" title="111千岛湖2天1晚·住希尔顿" target="_blank"><img src="./images/05.jpg"
                                                                                                                        alt="111千岛湖2天1晚·住希尔顿" width="290"
                                                                                                                        height="200"> </a></p>

                        <p><span class="pro-list-price fr"><i>￥</i><em>679</em>起</span> <a href="#"
                                                                                           title="111千岛湖2天1晚·住希尔顿"
                                                                                           target="_blank">111千岛湖2天1晚·住希尔顿</a>
                        </p>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
<div id="4" class="public-box" data-count-first="自驾游">
    <div class="public-tit">
        <h3><strong>自驾游</strong><span>行走山水间，足迹遍中国</span></h3>
        <a class="public-tit-more fr" href="../trip/search.html" target="_blank">更多周边游</a></div>

    <!-- 公共左边导航模块开始 -->
    <div class="public-asidebg" data-count-first="左侧导航">
        <div class="public-asidenav">
            <div class="min-title">热门景点</div>
            <!-- 导航栏内容部分 -->
            <div class="navigation-content">
                <center>

                    <table class="navigation-table">
                        <tr>
                            <td align="right" width="100px"><a href="../trip/search.html">张家界</a></td>
                            <td width="30px"></td>
                            <td align="left" width="100px"><a href="../trip/search.html">九寨沟</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="../trip/search.html">丽江</a></td>
                            <td></td>
                            <td align="left"><a href="../trip/search.html">北京</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="../trip/search.html">神农架</a></td>
                            <td></td>
                            <td align="left"><a href="../trip/search.html">三亚</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="../trip/search.html">厦门</a></td>
                            <td></td>
                            <td align="left"><a href="../trip/search.html">桂林</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="../trip/search.html">西藏</a></td>
                            <td></td>
                            <td align="left"><a href="../trip/search.html">长白山</a></td>
                        </tr>
                    </table>

                </center>
            </div>
            <div class="line1_style">
                <img src="./images/line1.png" width="23px" height="211px" alt=""/>
            </div>

            <div class="min-title">热门主题</div>
            <div class="navigation-content">
                <center>
                    <table class="navigation-table">
                        <tr>
                            <td align="right" width="100px"><a href="../trip/search.html">十月金秋</a></td>
                            <td width="30px"></td>
                            <td align="left" width="100px"><a href="../trip/search.html">绝美西北</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="../trip/search.html">花都云南</a></td>
                            <td></td>
                            <td align="left"><a href="../trip/search.html">最美秋天</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="../trip/search.html">海滨岛屿</a></td>
                            <td></td>
                            <td align="left"><a href="../trip/search.html">温泉泡汤</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="../trip/search.html">古镇村落</a></td>
                            <td></td>
                            <td align="left"><a href="../trip/search.html">山水景观</a></td>
                        </tr>
                        <tr>
                            <td align="right"><a href="../trip/search.html">金牌产品</a></td>
                            <td></td>
                            <td align="left"><a href="../trip/search.html">尾房甩卖</a></td>
                        </tr>
                    </table>
                </center>
            </div>
            <div class="line2_style">
                <img src="./images/line2.png" width="23px" height="184px" alt=""/>
            </div>
        </div>

    </div>
    <!-- 公共左边导航模块结束 -->

    <!-- 自由行侧边产品list -->
    <div class="public-pro fls freedomWalk-detail" id="freedomWalk-detail3" data-count-first="右侧图片列表">
        <!--周末游推荐景点-->
        <div class="pro-list">
            <ul>
                <li>
                    <div class="pro_list_content">
                        <p>
                            <a href="../tourist_detail/tourist_detail.html" title="111恐龙城万圣节" target="_blank"><img src="./images/01.jpg" alt="111恐龙城万圣节" width="290"   height="200"> </a>
                        </p>
                        <p><span class="pro-list-price fr"><i>￥</i><em>290</em>起</span> <a href="../trip/search.html"
                                                                                           title="111恐龙城万圣节"
                                                                                           target="_blank">111恐龙城万圣节</a>
                        </p>
                    </div>
                </li>
                <li>
                    <div class="pro_list_content">
                        <p><a href="../tourist_detail/tourist_detail.html" title="111恐龙城万圣节" target="_blank"><img src="./images/02.jpeg"
                                                                                                                  alt="111恐龙城万圣节" width="290"
                                                                                                                  height="200"> </a></p>

                        <p><span class="pro-list-price fr"><i>￥</i><em>290</em>起</span> <a href="#"
                                                                                           title="###"
                                                                                           target="_blank">111恐龙城万圣节</a>
                        </p>
                    </div>
                </li>
                <li>
                    <div class="pro_list_content">
                        <p><a href="../tourist_detail/tourist_detail.html" title="111恐龙城万圣节" target="_blank"><img src="./images/03.jpg"
                                                                                                                  alt="111恐龙城万圣节" width="290"
                                                                                                                  height="200"> </a></p>

                        <p><span class="pro-list-price fr"><i>￥</i><em>679</em>起</span> <a href="#"
                                                                                           title="###"
                                                                                           target="_blank">111千岛湖2天1晚·住希尔顿</a>
                        </p>
                    </div>
                </li>
                <li>
                    <div class="pro_list_content">
                        <p><a href="../tourist_detail/tourist_detail.html" title="111千岛湖2天1晚·住希尔顿" target="_blank"><img src="./images/04.jpeg"
                                                                                                                        alt="111千岛湖2天1晚·住希尔顿" width="290"
                                                                                                                        height="200"> </a></p>

                        <p><span class="pro-list-price fr"><i>￥</i><em>679</em>起</span> <a href="../trip/search.html"
                                                                                           title="111千岛湖2天1晚·住希尔顿"
                                                                                           target="_blank">111千岛湖2天1晚·住希尔顿</a>
                        </p>
                    </div>
                </li>
                <li>
                    <div class="pro_list_content">
                        <p><a href="../tourist_detail/tourist_detail.html" title="111千岛湖2天1晚·住希尔顿" target="_blank"><img src="./images/05.jpg"
                                                                                                                        alt="111千岛湖2天1晚·住希尔顿" width="290"
                                                                                                                        height="200"> </a></p>

                        <p><span class="pro-list-price fr"><i>￥</i><em>679</em>起</span> <a href="#"
                                                                                           title="111千岛湖2天1晚·住希尔顿"
                                                                                           target="_blank">111千岛湖2天1晚·住希尔顿</a>
                        </p>
                    </div>
                </li>
            </ul>
        </div>
    </div>


</div>
<!-- 内容模块结束 -->
<!-- 小火箭置顶 开始 -->
<div style="display: none ;" id="rocket-to-top">
    <div style="opacity:0;display: block;" class="level-2"></div>
    <div class="level-3"></div>
</div>
<!-- 小火箭置顶  结束 -->

<!-- 引入尾部开始 -->
<iframe src="common/footer.html" width="100%" height="650" frameborder="0" scrolling="no"></iframe>
<!-- 引入尾部结束 -->

<!-- 左侧悬浮导航 -->
<div id="nav-right" class="nav-right">
    <div class="nav-right-nav">
        <ul class="clearfix">
            <a id="nav1" href="#1">
                <li id="dd"><h3>顶端</h3></li>
            </a>
            <a id="nav2" href="#2">
                <li id="gn"><h3>国内</h3></li>
            </a>
            <a id="nav3" href="#3">
                <li id="jw"><h3>境外</h3></li>
            </a>
            <a id="nav4" href="#4">
                <li id="zj" class="last"><h3>自驾</h3></li>
            </a>
        </ul>
    </div>
</div>

<script src="js/index.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $('#nav1').click(function () {
            $("html,body").animate({
                scrollTop:$("#1").offset().top
            },1000)
        })
        $('#nav2').click(function () {
            $("html,body").animate({
                scrollTop:$("#2").offset().top
            },1000)
        })
        $('#nav3').click(function () {
            $("html,body").animate({
                scrollTop:$("#3").offset().top
            },1000)
        })
        $('#nav4').click(function () {
            $("html,body").animate({
                scrollTop:$("#4").offset().top
            },1000)
        })

        /*鼠标移入时图片向上，移出时图片还原 开始*/
        $(".pro_list_content").hover(function(){
            $(this).css("margin-top","-5px");
            $(this).css("transition","0.5s");
        },function(){
            $(this).css("margin-top","-0px");
            $(this).css("transition","0.5s");
        });
        /*鼠标移入时图片向上，移出时图片还原 开始*/
    })
</script>
</body>
</html>
