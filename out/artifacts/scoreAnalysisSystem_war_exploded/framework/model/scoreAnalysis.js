/**
 * Created by Administrator on 2017/12/20.
 */
function showScoreForm() {
    $("#table_score").bootstrapTable('destroy');
    $('#table_score').bootstrapTable({
        url:"/fwwb/courseScore/page",
        toolbar:"#rootScoreToolbar",
        queryParams:{
            courseName:encodeURI($("#courseName").val()),
            termName:encodeURI($("#termName").val()),
            courseType:encodeURI($("#courseType").val())
        },
        dataField:"data.entities",
        sidePagination: "server",
        pagination: "true",
        pageList: "[30, 60, 90, ALL]",
        pageSize: "30",
        columns:[
            {
                field: 'stuId',
                title: '学号',
                align: 'center',
                class: 'col-md-3',
                valign: 'middle'
            },{
                field: 'stuGender',
                title: '性别',
                align: 'center',
                class: 'col-md-3',
                valign: 'middle'
            },{
                field: 'stuClassName',
                title: '班级',
                align: 'center',
                class: 'col-md-3',
                valign: 'middle'
            },{
                field: 'scoreCourseScore',
                title: '成绩',
                align: 'center',
                class: 'col-md-3',
                valign: 'middle'
            },
        ]

    });
    getMore();
}

function getMore() {
    $.ajax({
        url:"/fwwb/courseScore/more",
        dataType:"json",
        type:"GET",
        data:{
            courseName:encodeURI($("#courseName").val()),
            termName:encodeURI($("#termName").val()),
            courseType:encodeURI($("#courseType").val())
        },
        success:function (data) {
            scoreCount(data);
            drawPie(data);
        }
    })
}

function scoreCount(data) {
    var last = data.data.length - 1;
    var tableStr = "";
    tableStr += "<tr><td align='center'>最高分</td><td align='center'>"
        +data.data[0].stuId+
        "</td><td align='center'>"
        +data.data[0].maximum+ "</td></tr>"+
        "<tr><td align='center'>最低分</td><td align='center'>"
        +data.data[last].stuId+
        "</td><td align='center'>"+
        +data.data[0].minimum+"</td></tr>"+
        "<tr><td align='center'>平均分</td><td align='center'>"
        +data.data[0].average+ "</td></tr>"
    //将动态生成的table添加的事先隐藏的div中.
    $("#dataTable").html(tableStr);
}

function drawPie(data) {
    var chart = echarts.init(document.getElementById('chart_pie_score'));
    var yData = [];
    yData[0] = data.data[0].excellentNumber;
    yData[1] = data.data[0].goodNumber;
    yData[2] = data.data[0].mediumNumber;
    yData[3] = data.data[0].passNumber;
    yData[4] = data.data[0].notPassNumber;
    var option = {
        title : {
            text: $("#courseName").val()+'南丁格尔玫瑰图',
            subtext: '课程分析',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            x : 'center',
            y : 'bottom',
            data:['优秀率(>=85)','良好率(75-84)','中等率(66-74)','及格率(60-65)','不及格率(<60)']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {
                    show: true,
                    type: ['pie', 'funnel']
                },
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        series : [
            {
                name:'面积模式',
                type:'pie',
                radius : [30, 110],
                roseType : 'radius',
                x: '50%',               // for funnel
                max: 40,                // for funnel
                sort : 'ascending',     // for funnel
                data:[
                    {value:yData[0], name:'优秀率(>=85)'},
                    {value:yData[1], name:'良好率(75-84)'},
                    {value:yData[2], name:'中等率(66-74)'},
                    {value:yData[3], name:'及格率(60-65)'},
                    {value:yData[4], name:'不及格率(<60)'}
                ]
            }
        ]
    };
    chart.setOption(option);
}

