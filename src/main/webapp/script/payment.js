function requestPay(r, p) {
    let name = $('#username').val();
    let phone = $('#phone').val();
    if (name==='' || phone==='') {
        alert('Незаполнены поля');
        return false;
    }
    ($.ajax({
        type: "GET",
        url: "http://localhost:8080/cinema/pay",
        data: {r: row, p: place, username: name, phone: phone},
        dataType: "json",
    }).done(function(data) {
        $('#email_form').after(data['answer']);
    }).fail(function(err){
        alert(err);
    }));
};

function addRowAndPlaceToHeader(row, place){
    $(function () {
        $('h3').append("<p>Вы выбрали ряд " + row + " место " + place + ", Сумма : 500 рублей.</p>");
    });
}
