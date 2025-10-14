/**
 * chatbot.js
 */

 $(document).ready(function() {
	// 챗봇에게 질문하고 응답받기 - 텍스트 응답	
	
		// message 입력하고 전송 버튼 눌렀을 때
		$('#chatForm').on('submit', function() {
			event.preventDefault();
			
			if($('#message').val() != "") { // 값 입력하지 않고 [전송] 버튼 누를 경우 작은 노란점 안 보이도록
				// chatBox에 보낸 메시지 추가
				$('#chatBox').append('<div class="msgBox send"><span>' +
				                                      $('#message').val() + '</span></div><br>');
				getResponse();
			}
			
			/* 입력란 비우기 */
			$('#message').val(''); 
			
		});
		
		$('#chatbotBox').addClass('visihide')
		// 창닫기
		$('#closeBtn').on('click', function() {
			$('#chatbotBox').addClass('visihide')
			$('#cbi').removeClass('visihide')
		});
		
		$('#cbi').on('click', function() {
			$('#cbi').addClass('visihide')
			$('#chatbotBox').removeClass('visihide')
		});
		
	});
	
	// 서버에서 응답을 받아서 chatBox에 응답 내용 출력하는 함수
	function getResponse() {
		// 서버로부터 받은 응답 메시지 
		let result = "저는 챗봇입니다";
		
		// chatBox에 보낸 메시지 추가
		$('#chatBox').append('<div class="msgBox receive"><br>챗봇<br><span>' +
			                                      result + '</span></div><br><br>');
		// 마지막 메시지 보이도록 위로 스크롤	                                      
	   $('#chatBox').scrollTop($('#chatBox').prop("scrollHeight"));
	}
	
	
	
	
	/*---------------------------------------*/
