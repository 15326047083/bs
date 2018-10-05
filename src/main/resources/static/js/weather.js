function getDate() {
    var mydate = new Date()
    var year = mydate.getYear()
    if (year < 1000)
        year += 1900
    var day = mydate.getDay()
    var month = mydate.getMonth()
    var daym = mydate.getDate()
    if (daym < 10)
        daym = "0" + daym
    var dayarray = new Array("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    var montharray = new Array("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")
    document.write("" + dayarray[day] + ", " + montharray[month] + " " + daym + ", " + year + "")
}

function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('txt').innerHTML =
        h + ":" + m + ":" + s;
    var t = setTimeout(startTime, 500);
}

function checkTime(i) {
    if (i < 10) {
        i = "0" + i
    }
    ; // add zero in front of numbers < 10
    return i;
}

function getWeather() {
    $.ajax({
        url: "/api/getWeather",
        type: "get",
        dataType: "json",
        success(data) {
            $("#today").append("<p>" + data.result.sk.temp + "°<span>C</span></p>");
            $("#ulAll").append("<li>今天 <span> " + data.result.today.temperature + "</span></li>");
            for (var i = 0; i < 5; i++) {
                $("#ulAll").append("<li>" + data.result.future[i].week + " <span> " + data.result.future[i].temperature + "</span></li>");
            }
            $("#todayWeather").append("<span>" + data.result.today.city + "</span>");
        }
    });
}


$(document).keyup(function (event) {
    if (event.keyCode == 13) {
        getCtiyWeather();
    }
});

function getCtiyWeather() {
    var city = $("#city").val();
    $.ajax({
        url: "/api/getWeather",
        type: "get",
        data: {
            "name": city
        },
        dataType: "json",
        success(data) {
            if (data.resultcode != "200")
                alert("请输入正确的城市名称");
            else {
                $("#today").empty();
                $("#ulAll").empty();
                $("#todayWeather").empty();
                $("#today").append("<p>" + data.result.sk.temp + "°<span>C</span></p>");
                $("#ulAll").append("<li>今天 <span> " + data.result.today.temperature + "</span></li>");
                for (var i = 0; i < 5; i++) {
                    $("#ulAll").append("<li>" + data.result.future[i].week + " <span> " + data.result.future[i].temperature + "</span></li>");
                }
                $("#todayWeather").append("<span>" + data.result.today.city + "</span>");
            }
        }
    });
}