/**
 * bookSearch3.js
 * [검색 방법 3] : @RestController의 메소드를 호출합
 * 방법 1과 클라이언트 코드 구조는 동일하며, 요청 URL만 다름
 */
$(document).ready(function(){
	// id가 'bookSearchFrm3'인 폼에서 'submit' 이벤트가 발생하면 지정된 함수를 실행
	$('#bookSearchFrm3').on('submit',function(){
		// 브라우저의 기본 폼 제출 동작(페이지 새로고침)을 중단
		event.preventDefault();
		
		// 폼 안의 입력 필드들의 name과 value를 쿼리 스트링 형식으로 변환
		let formData = $(this).serialize();
		
		let keyword=$('#keyword').val();
		let type=$('#type').val();
		
		// 검색 조건이나 검색어가 비어있는지 확인
		if(keyword==""||type==""){
			alert("검색 조건과 검색어를 입력하세요");
		}else{
			// jQuery의 $.ajax() 함수를 사용하여 서버에 비동기 HTTP 요청을 보냄
			$.ajax({
				type:"post",			// HTTP 요청 메소드를 POST로 설정
				url:"/book/book/bookSearch3",	// 요청을 보낼 서버의 URL 주소 / BookRestController의 bookSearch3() 메소드 호출
				data: formData,			// 서버로 전송할 데이터
				dataType: "json",       // 서버로부터 받을 응답 데이터의 타입을 JSON으로 받음
				success:function(result){	// 서버로부터 성공적으로 응답을 받았을 때 실행되는 함수
					// 1. 기존 결과 삭제
					$('#searchResultBox').empty(); 
					
					// 2. 결과 테이블 구조 생성
					let table = '<table id="resultTable" border="1" width="600">' +
					    		'<tr><th>도서번호</th><th>도서명</th><th>저자</th>' +
                        		'<th>가격</th><th>재고</th><th>출판일</th><th>출판사 번호</th></tr>';
                        						 
                    // 3. 검색 결과에 따라 테이블 내용 채우기
                    if(result.length == 0){
				    	table += '<tr align="center"><td colspan="7">찾는 도서가 없습니다</td></tr>';
				    } else {
				    	for(let i=0; i<result.length; i++){
				    		let book_date = new Date(result[i].bookDate);
				    		let year = book_date.getFullYear();
				    		let month = (book_date.getMonth()+1).toString().padStart(2,'0');
				    		let date = (book_date.getDate()).toString().padStart(2,'0');
				    		let bookDate = `${year}-${month}-${date}`;

							let detailUrl = '/book/book/detailViewBook/' + result[i].bookNo;

				    		table += '<tr><td><a href="' + detailUrl + '">' + result[i].bookNo +'</a></td><td>' +
				    				 result[i].bookName +'</td><td>' +
				    				 result[i].bookAuthor +'</td><td>' +
				    				 result[i].bookPrice.toLocaleString() +' 원</td><td>' +
				    				 result[i].bookStock +'</td><td>' +
				    				 bookDate +'</td><td>' +
				    				 result[i].pubNo +'</td></tr>';
				   		}
				    }
				    table += '</table>'; // 테이블 태그를 닫음
				    
				    // 4. 완성된 테이블을 화면에 출력
					$('#searchResultBox').append(table);
					
				},
				error:function(data){
					alert("요청 실패");
				}
			});
		}
	}); // submit 종료
}); //ready 종료