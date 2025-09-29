$(document).ready(function(){
	$('#bookSearchFrm3').on('submit',function(){
		event.preventDefault(); // submit 이벤트 중지
		
		// 폼에 입력된 여러개의 값을 쿼리스트링 방식의 데이터로 변환 : serialize() 사용
		let formData = $(this).serialize();
		
		let keyword=$('#keyword').val();
		let type=$('#type').val();
		
		if(keyword==""||type==""){
			alert("검색 조건과 검색어를 입력하세요");
			//return false;
		}else{
			$.ajax({
				type:"post",			// 요청 방식 메소드
				url:"/book/book/bookSearch3",	// 요청 url
				data: formData,			// 요청시 전송될 파라미터
				success:function(result){
					console.log(result);
					// 반환된 결과 페이지를 searchResultBox에 페이지로 삽입 : .html()
					$('#searchResultBox').empty(); // 기존 결과 지우기
					
					// 결과 테이블의 헤더 생성
					$('#searchResultBox').append('<table id="resultTable" border="1" width="600">' +
					    						 '<tr><th>도서번호</th><th>도서명</th><th>저자</th>' +
                        						 '<th>가격</th><th>재고</th><th>출판일</th><th>출판사 번호</th><th>그림</th></tr>');
                        						 
                    if(result==""){ //검색 결과가 없는 경우
				    $('#searchResultBox').append('<tr align="center"><td colspan="7">찾는 상품이 없습니다</td></tr>');
				    } else {
                        // JSON 배열(result)을 순회하며 테이블의 행(row)을 동적으로 추가
				    	for(let i=0; i<result.length; i++){
				    		let book_date = new Date(result[i].bookDate);
				    		let year = book_date.getFullYear();
				    		let month = (book_date.getMonth()+1).toString().padStart(2,'0');
				    		let date = (book_date.getDate()).toString().padStart(2,'0');
				    		let bookDate = `${year}-${month}-${date}`;
				    		$('#resultTable').append('<tr><td>' + <td><a href="<c:url value='/book/detailViewBook/${book.bookNo}'/>"> + result[i].bookNo +'</td><td>' +
				    											  result[i].bookName +'</td><td>' +
				    											  result[i].bookAuthor +'</td><td>' +
				    											  result[i].bookPrice.toLocaleString() +' 원</td><td>' +
				    											  result[i].bookStock +'</td><td>' +
				    											  bookDate +'</td><td>' +
				    											  result[i].pubNo +'</td><td>' +
				    											  '<img src="/mybatis/product_images/'+
				    											  result[i].bookNo +
				    											  '.jpg" width="30" height="20"/></td></tr>');
				   		}
				    }
				    $('#searchResultBox').append('</table>');	  											 
					
				},
				error:function(data){
					alert("요청 실패");
				}
			});
		}
	}); // submit 종료
}); //ready 종료