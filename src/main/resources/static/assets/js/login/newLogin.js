$(function(){
})

function fnLogin() {
    var formData = $("#loginForm").serializeArray(); // 폼 데이터 직렬화
    var jsonData = {};

    $.each(formData, function() {
        jsonData[this.name] = this.value;
    });

    $.ajax({
        url: '/login/login',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(jsonData),
        success: function(response) {
            if(response.success){
                console.log("hihi")
                alert(response.message);
                location.href = "/main";
            }
            console.log('Success:', response);
        },
        error: function(error) {
            console.log('Error:', error);
        }
    });
}