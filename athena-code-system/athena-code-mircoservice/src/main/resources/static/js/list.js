/*
@功能：列表页js
@作者：庄小焱
@时间：2022年9月18日
*/

$(function () {
    $(".child h3").click(function () {
        $(this).toggleClass("on").parent().find("ul").toggle();
    });
});