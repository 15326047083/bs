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
                window.location.href = "/user/toIndex";
            } else {
                $("#alert").css('display', 'block');
                $("#phone").val("");
                $("#password").val("");
            }
        }
    });
}

function updateUser() {
    $.ajax({
        url: "/user/updateUser",
        type: "post",
        data: $("#form").serialize(),
        success(data) {
            if (data == "success") {
                $("#alert").css('display', 'none');
                alert("信息更新成功");
                history.back(-1);
            } else {
                $("#alert").css('display', 'block');
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