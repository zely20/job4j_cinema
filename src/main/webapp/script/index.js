function requestPlace() {
    ($.ajax({
        type: "GET",
        url: "http://localhost:8080/cinema/hall",
        async: true,
        dataType: "json",
        success: function (data) {
            $.each(data, function (index, element) {
                let place = "input:radio#" + element.row + element.place;
                $(place).attr('disabled', true)
            })
        },
    }))
};

function payRedirection() {
    let valueRadio = $('input[name="place"]:checked').val();
    if (valueRadio === undefined || valueRadio === "") {
        alert("choose place")
        return false;
    }
    window.location.href = "payment.html?text=" + valueRadio;
}