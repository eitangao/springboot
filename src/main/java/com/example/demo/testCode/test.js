javascript: (function () {
    var chap = null;
    $.ajax({
        async: false,
        type: "get",
        url: "http://xxjs.dtdjzx.gov.cn/quiz-api/chapter_info/list",
        dataType: "json",
        success: function (d) {
            chap = d
        }, error: function (err) {
            console.log(err)
        }
    });
    var datalist = [];
    for (var id = 0; id < chap.data.length; id++) {
        var data = null;
        $.ajax({
            async: false,
            type: "get",
            url: "http://xxjs.dtdjzx.gov.cn/quiz-api/subject_info/list?chapterId=" + chap.data[id].id,
            dataType: "json",
            success: function (d) {
                data = d
            }, error: function (err) {
                console.log(err)
            }
        });
        datalist[id] = data
    }

    function getAnswer(text) {
        for (var j = 0; j < datalist.length; j++) {
            var data = datalist[j];
            for (var i = 0; i < 200; i++) {
                var item = data.data.subjectInfoList[i];
                if (item.subjectTitle == text) return item.answer
            }
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