javascript: (function () {
    var data = null;
    $.ajax({
        async: false,
        type: "get",
        url: "http://xxjs.dtdjzx.gov.cn/quiz-api/subject_info/list",
        dataType: "json",
        success: function (d) {
            data = d
        }, error: function (err) {
            console.log(err)
        }
    });

    function getAnswer(text) {
        for (var i = 0; i < 200; i++) {
            var item = data.data.subjectInfoList[i];
            if (item.subjectTitle == text) return item.answer
        }
    }
    if (true) {
        var i = 0;
        $("span.w_fz18:odd").each(function () {
            var text = $(this).text();
            var answer = getAnswer(text);
            if (answer.indexOf("A") >= 0) $('sapn.w_fz18:eq(' + i + ')').css("color", "red");
            i++;
            if (answer.indexOf("B") >= 0) $('sapn.w_fz18:eq(' + i + ')').css("color", "red");
            i++;
            if (answer.indexOf("C") >= 0) $('sapn.w_fz18:eq(' + i + ')').css("color", "red");
            i++;
            if (answer.indexOf("D") >= 0) $('sapn.w_fz18:eq(' + i + ')').css("color", "red");
            i++
        })
    }
})()