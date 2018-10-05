function getNews() {
    $.ajax({
        url: "/api/getTenNews",
        type: "get",
        dataType: "json",
        success(data) {
            var str1 = "    <div class=\"layui-col-xs12 layui-col-sm6 layui-col-md6\">\n" +
                "        <div class=\"layui-collapse\">\n" +
                "            <div class=\"layui-colla-item\">";
            var str2 = "<div class=\"layui-colla-content layui-show\">";
            var str3 = "</div></div></div></div>";
            for (var i = 0; i < 10; i++) {
                $("#main").append(str1 + "<h2 class='layui-colla-title'>【" + data.showapi_res_body.pagebean.contentlist[i].source + "】"
                    + data.showapi_res_body.pagebean.contentlist[i].title + "</h2>" + str2
                    + data.showapi_res_body.pagebean.contentlist[i].html + str3);
            }
        }
    });
}

function getHistoryToday() {
    $.ajax({
        url: "/api/getHistoryToday",
        type: "get",
        dataType: "json",
        success(data) {
            for (var i = 0; i < data.showapi_res_body.list.length; i++) {
                var src = "#";
                if (data.showapi_res_body.list[i].img != null)
                    src = data.showapi_res_body.list[i].img;
                $("#history").append(data.showapi_res_body.list[i].year + "年<a href='" + src + "'>" + data.showapi_res_body.list[i].title + "</a><br/>");
            }
        }
    });
}