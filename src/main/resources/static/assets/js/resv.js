$(document).ready(function() {

    $("#btn_tempData").on("click", async function () {
        insertTempData();
    })

    $("#btn_test").on("click", function () {
        selectResv();
    })


    setInterval(function() {
        console.log('This message is logged every 5 seconds');
    }, 5000); // 5000 milliseconds = 5 seconds


});


async function selectResv() {
    try {
        let storeCd = 'testStore';
        const response = await fetch(`/resvs?storeCd=${storeCd}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
        });

        if (!response.ok) throw new Error('Network response was not ok');
        const data = await response.json();
        console.log(data);
        //$('#create_result').text(`Created ID: ${data.id}`);
    } catch (error) {
        $('#create_result').text('Error');
        console.error('Error:', error);
    }
}

async function insertTempData() {
    try {
        const response = await fetch('/resvs', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
        });

        if (!response.ok) throw new Error('Network response was not ok');
        const data = await response.json();
        $('#create_result').text(`Created ID: ${data.id}`);
    } catch (error) {
        $('#create_result').text('Error creating data');
        console.error('Error:', error);
    }
}