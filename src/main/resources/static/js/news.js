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