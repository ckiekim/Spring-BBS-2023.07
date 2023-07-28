/**
 * aside menu control을 위해 사용됨
 */
$(document).ready(function() {
	$('#stateMsgBtn').click(function(e) {			// 이벤트 등록
		$('#stateMsgInput').attr({'class': 'mt-2'});			// 입력창이 보이게 만듦
		$('#stateInput').attr({value: $('#stateMsg').text()}); 	// 입력창에 stateMsg 내용을 삽입
	});
	$('#stateMsgSubmit').click(changeStateMsg); 	// 이벤트 등록
	$('#getWeatherButton').click(getWeather);
});

function changeStateMsg() {
	$('#stateMsgInput').attr({'class': 'mt-2 d-none'});		// 입력창이 보이지 않게 만듦
	let stateInputVal = $('#stateInput').val();
	$.ajax({
		type: 'GET',
		url: '/sbbs/aside/stateMsg',
		data: {stateMsg: stateInputVal},
		success: function(e) {
			console.log('state message:', stateInputVal);
			$('#stateMsg').html(stateInputVal);
		}
	});
}

function getWeather() {
    let addr = $('#addr').text();
    $.ajax({
        type: 'GET',
        url: '/sbbs/aside/weather',
        data: {addr: addr},
        success: function(result) {
            $('#weather').html(result);
        }
    });
}