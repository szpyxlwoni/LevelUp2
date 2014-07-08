//var lines = [];
//
//var Course = function(name, parent, content){
//    this.name = name;
//    this.parent = parent;
//    this.content = content;
//    this.x;
//    this.y;
//};
//
//var Line = function(x1,y1,x2,y2,color){
//    this.x1 = x1;
//    this.y1 = y1;
//    this.x2 = x2;
//    this.y2 = y2;
//    this.color = color;
//};
//
//var initData = function (courses) {
//    var courseList = [];
//
//    $.each(courses, function(i, course){
//        courseList.push(new Course(course.name, null, course.content));
//    });
//
//    return courseList
//}
//
//var drawDiagram = function (courses) {
//    var svg = d3.select("#diagram").append("svg");
//
//    svg.selectAll("rect").data(courses).enter().append("rect")
//        .attr("fill", "white").attr("stroke", "black")
//        .attr("width", "100").attr("height", "50")
//        .attr("x", function(d,i){d.x = 100; return d.x;})
//        .attr("y",function(d, i){d.y = (i * 100) + 100; return d.y;});
//
//    $.each(courses, function(i, course){
//        if (course.parent) {
//            lines.push(new Line(course.x + 50, course.y, course.parent.x + 50, course.parent.y + 50, '#000'));
//        }
//    });
//
//    svg.selectAll("line").data(lines).enter().append("line")
//        .style("stroke", function(d){return d.color;})
//        .attr("x1",function(d){return d.x1;})
//        .attr("y1",function(d){return d.y1;})
//        .attr("x2",function(d){return d.x2;})
//        .attr("y2",function(d){return d.y2;});
//
//    svg.selectAll("text").data(courses).enter().append("text")
//        .text(function(d){return d.name;})
//        .attr("y", function(d) {return d.y + 30;})
//        .attr("x", function(d) {return d.x + 20;});
//}

var levelup = angular.module('levelup', []);


