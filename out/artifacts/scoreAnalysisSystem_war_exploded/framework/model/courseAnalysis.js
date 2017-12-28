/**
 * Created by Administrator on 2017/12/21.
 */
function getCourseTable() {

    $('#table_course').bootstrapTable({
        url:"/fwwb/course",
        toolbar:"#rootCourseToolbar",
        clickToSelect:"true",
        dataField:"data.entities",
        sidePagination: "server",
        clickToSelect:"true",
        pagination: "true",
        pageList: "[10, 15, 20, ALL]",
        pageSize: "5",
        columns:[{
            field:'checkStatus',
            checkbox:"true"
        },
            {
                field: 'scoreCourseId',
                title: '课程代码',
                align: 'center',
                class: 'col-md-3',
                valign: 'middle'
            },{
                field: 'scoreCourseName',
                title: '课程名称',
                align: 'center',
                class: 'col-md-3',
                valign: 'middle'
            },{
                field: 'scoreCourseCredit',
                title: '学分',
                align: 'center',
                class: 'col-md-3',
                valign: 'middle'
            },{
                field: 'scoreCourseType',
                title: '课程性质',
                align: 'center',
                class: 'col-md-3',
                valign: 'middle'
            },
        ]

    });
}

function drawBar() {
    var a= $("#table_course").bootstrapTable('getSelections');
    var courseId = [];
    for(var i = 0; i < a.length;i++){
        courseId[i] = a[i].scoreCourseId;
    }
    $.ajax({
        url:"/fwwb/course/bar",
        dataType:"json",
        traditional:"true",
        type:"GET",
        data:{
            courseIds : courseId,
            termName : encodeURI($("#termName").val())
        },
        success:function (data) {
            var xData = [];
            var excellentData = [];
            var goodData = [];
            var mediumData = [];
            var passData = [];
            var notPassData = [];
            var distinctionData = [];

            for(var i = 0; i < data.data.length;i++){
                xData[i] = data.data[i].scoreCourseName;
                excellentData[i] = data.data[i].excellentRate;
                goodData[i] = data.data[i].goodRate;
                mediumData[i] = data.data[i].mediumRate;
                passData[i] = data.data[i].passRate;
                notPassData[i] = data.data[i].notPassRate;
                distinctionData[i] = data.data[i].distinction;
            }
            var chart = echarts.init(document.getElementById('chart_bar_score'));
            var chart2 = echarts.init(document.getElementById('chart_bar_course_distinction'));
            var option = {
                title : {
                    text: '课程对比',
                    subtext: '纯属虚构'
                },
                tooltip : {
                    trigger: 'axis',
                    formatter: '{a0} {b0} : {c0}%<br/>' +
                    '{a1} {b1} : {c1}%<br/>' +
                    '{a2} {b2} : {c2}%<br/>' +
                    '{a3} {b3} : {c3}%<br/>' +
                    '{a4} {b4} : {c4}%'
                },
                legend: {
                    data:['优秀率(>=85)','良好率(75-84)','中等率(66-74)','及格率(60-65)','不及格率(<60)']
                },
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: true},
                        dataView : {show: true, readOnly: false},
                        magicType : {show: true, type: ['line', 'bar']},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                calculable : true,
                xAxis : [
                    {
                        type : 'category',
                        data : xData
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'优秀率',
                        type:'bar',
                        data:excellentData,
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        },
                        markLine : {
                            data : [
                                {type : 'average', name: '平均值'}
                            ]
                        }
                    }, {
                        name:'良好率',
                        type:'bar',
                        data:goodData,
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        },
                        markLine : {
                            data : [
                                {type : 'average', name : '平均值'}
                            ]
                        }
                    }, {
                        name:'中等率',
                        type:'bar',
                        data:mediumData,
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        },
                        markLine : {
                            data : [
                                {type : 'average', name : '平均值'}
                            ]
                        }
                    }, {
                        name:'及格率',
                        type:'bar',
                        data:passData,
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        },
                        markLine : {
                            data : [
                                {type : 'average', name : '平均值'}
                            ]
                        }
                    }, {
                        name:'不及格率',
                        type:'bar',
                        data:notPassData,
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        },
                        markLine : {
                            data : [
                                {type : 'average', name : '平均值'}
                            ]
                        }
                    }
                ]
            };

            var option2 = {
                title : {
                    text: '课程区分度',
                    subtext: '纯属虚构'
                },
                tooltip : {
                    trigger: 'axis',
                    formatter: '{a} {b} : {c}'
                },
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: true},
                        dataView : {show: true, readOnly: false},
                        magicType : {show: true, type: ['line', 'bar']},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                calculable : true,
                xAxis : [
                    {
                        type : 'category',
                        data : xData
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'区分度',
                        type:'bar',
                        data:distinctionData,
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        },
                        markLine : {
                            data : [
                                {type : 'average', name: '平均值'}
                            ]
                        }
                    }
                ]
            };
            chart2.setOption(option2);
            chart.setOption(option);
        }

    })
}
