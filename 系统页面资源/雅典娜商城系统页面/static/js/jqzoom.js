/*
@功能：jqzoom.js
@作者：庄小焱
@时间：2022年9月18日
*/

$(function () {
    $('.jqzoom').jqzoom({
        zoomType: 'standard',
        lens: true,
        preloadImages: false,
        alwaysOn: false,
        title: false,
        zoomWidth: 400,
        zoomHeight: 400
    });
})