/**
 * Created by zym on 2017/11/21.
 */

$(function(){
    adjustBoxHeight();
    adjustContentHeight();
    adjustTableContentHeight();
    $(window).resize(function(){
        adjustContentHeight();
        adjustTableContentHeight();
    });

    // var $curMenuItem = $('.treeview-menu li.active i');
    // console.log($curMenuItem);
})

function adjustContentHeight(){
    var headerHeight = $('.content-header').outerHeight() ;
    $('.content').css('height','calc(100% - ' + headerHeight + 'px)');
}

function adjustTableContentHeight(){
    var $tableContents = $('.table-content');
    $tableContents.each(function(){
        var $this = $(this),
            searchbarHeight = $this.prev().prev().outerHeight(true) || 0,
            dividerHeight = $this.prev().outerHeight(true) || 0;
        $this.css('height','calc(100% - ' + (searchbarHeight + dividerHeight) + 'px');
    })
}

function adjustBoxHeight(){
    var $boxBody = $('.box-body');
    $boxBody.each(function(){
        var $this = $(this),
            headerHeight = $this.prev().outerHeight(true) || 0,
            footerHeight = $this.next().outerHeight(true) || 0;
        $this.css('height','calc(100% - ' + (headerHeight + footerHeight) + 'px)');
    })
}