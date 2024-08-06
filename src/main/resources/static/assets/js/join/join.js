$(function(){
})

function fnJoin() {
    var formData = $("#joinForm").serializeArray(); // 폼 데이터 직렬화
    var jsonData = {};

    $.each(formData, function() {
        jsonData[this.name] = this.value;
    });

    $.ajax({
        url: '/join/new',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(jsonData),
        success: function(response) {
            if(response.success){
                alert(response.message);
                location.href = "/newLogin";
            }
            console.log('Success:', response);
        },
        error: function(error) {
            console.log('Error:', error);
        }
    });
}