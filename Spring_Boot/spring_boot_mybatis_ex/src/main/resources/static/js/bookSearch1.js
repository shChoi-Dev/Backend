/**
 * bookSearch1.js
 * [검색 방법 1] : Controller의 @ResponseBody 메소드를 호출
 * 서버로부터 JSON 데이터를 받아와 클라이언트에서 동적으로 HTML 테이블을 생성
 */
$(document).ready(function(){
	// 도서 검색 폼('bookSearchFrm1')의 submit 이벤트를 처리
	$('#bookSearchFrm1').on('submit',function(){
		// 폼의 기본 제출 동작(페이지 새로고침)을 방어
		event.preventDefault();
		
		// 폼 데이터를 쿼리 스트링으로 직렬화
		let formData = $(this).serialize();		
		
		let keyword=$('#keyword').val();
		let type=$('#type').val();
		
		if(keyword==""||type==""){
			alert("검색 조건과 검색어를 입력하세요");
		}else{		
			$.ajax({
				type:"post", // HTTP 요청 방식
				url:"/book/bookSearch1", // 도서 검색을 처리하는 컨트롤러의 URL
				data: formData, // 서버로 전송할 데이터
				dataType: "json", // 서버로부터 JSON 형식의 응답을 기대
				success:function(result){ // 요청이 성공하면 'result' 매개변수로 JSON 데이터가 전달
					console.log(result);
					
					// 1. 기존에 표시되던 검색 결과를 모두 지움
					$('#searchResultBox').empty();
					
					// 2. 결과를 표시할 HTML 테이블의 기본 구조(헤더)를 생성
					$('#searchResultBox').append('<table id="resultTable" border="1" width="600">' +
					                             '<tr><th>도서번호</th><th>도서명</th><th>저자</th>' +
	 											 '<th>가격</th><th>재고</th><th>출판일</th><th>출판사 번호</th></tr>');
					
				    // 3. 서버로부터 받은 데이터의 길이를 확인하여 내용 분기 처리
				    if(result.length == 0){ 
						// 검색 결과가 없는 경우 안내 메시지를 테이블에 추가
				    	$('#searchResultBox').append('<tr align="center"><td colspan="7">찾는 도서가 없습니다</td></tr>');
				    } else {
						// 검색 결과가 있는 경우, 배열을 순회하며 각 도서 정보를 행(tr)으로 추가
				    	for(let i=0; i<result.length; i++){
							// JSON으로 받은 날짜 데이터를 'yyyy-MM-dd' 형식으로 보기 좋게 변환
				    		let book_date = new Date(result[i].bookDate);
				    		let year = book_date.getFullYear();
				    		let month = (book_date.getMonth()+1).toString().padStart(2,'0');
				    		let date = book_date.getDate().toString().padStart(2,'0');
				    		let bookDate = `${year}-${month}-${date}`;
				
							// JavaScript 문자열 연결을 사용하여 상세 보기 링크를 동적으로 생성
				 			let detailLink = '<a href="/book/detailViewBook/' + result[i].bookNo + '">' + result[i].bookNo + '</a>';
				

							// 각 도서 정보가 담긴 행(tr)을 테이블에 추가
				    		$('#resultTable').append('<tr><td>' + detailLink + '</td><td>' +
																  result[i].bookNo + '</a></td><td>' +
				    											  result[i].bookName + '</td><td>' +
				    											  result[i].bookAuthor + '</td><td>' +
				    											  result[i].bookPrice.toLocaleString() + '원</td><td>' +
				    											  result[i].bookStock + '</td><td>' +
				    											  bookDate + '</td><td>' +
				    											  result[i].pubNo + '</td></tr>');
				    	}
				    }
				    $('#searchResultBox').append('</table>'); // 테이블 태그를 닫음
				},
				error:function(data){ // 요청 실패 시 실행되는 함수
					alert("요청 실패");
				}
			});
		}
	});//submit 종료
});//ready 종료