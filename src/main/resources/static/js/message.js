var editIndex1;
var fuwenben;

function reply(discussId) {
    $("div#reply").remove();
    $("#div" + discussId).append("<div id=\"reply\" class=\"layui-form-item layui-form-text\">" +
        "<div class=\"layui-input-block\"><form id=\"replyForm\" action='' method=\"post\" class=\"layui-form layui-form-pane\">" +
        "<input id='replyId' name='replyId' type='hidden' value='" + discussId + "'/>" +
        "<textarea class=\"layui-textarea layui-hide\" name=\"info\" lay-verify=\"content\" id=\"LAY_demo_editor1\">" +
        "</textarea><button class=\"layui-btn\" lay-submit=\"\" lay-filter=\"sub\">提交</button></form></div></div>");
    fuwenben = layui.layedit;
    //创建一个编辑器
    editIndex1 = fuwenben.build('LAY_demo_editor1');
}