function userLogin() {
    $.ajax({
        type: "post",
        url: "/user/login",
        data: {
            "phone": $("#phone").val(),
            "password": $("#password").val()
        },
        success(data) {
            if (data == "success") {
                $("#alert").css('display', 'none');
                // TODO 登陆成功后的跳转
            } else {
                $("#alert").css('display', 'block');
                $("#phone").val("");
                $("#password").val("");
            }
        }
    });
}

function newUser() {
    $.ajax({
        url: "/user/newUser",
        type: "post",
        data: $("#form").serialize(),
        success(data) {
            if (data == "success") {
                $("#alert").css('display', 'none');
                // TODO 注册成功后的跳转
                alert("注册成功");
                window.location.href = "/user/toLogin";
            } else {
                $("#alert").css('display', 'block');
            }
        }
    });
}

$(document).keyup(function (event) {
    if (event.keyCode == 13) {
        $("#submit").trigger("click");
    }
});