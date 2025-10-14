/**
 * searchZip.js
 */
 
 $(document).ready(function() {
  	$('#searchZipBtn').on('click', function() {
  		new daum.Postcode({
  			oncomplete:function(data) {
  				let address1 = "";
  				
  				// 도로명 주소인 경우
  				if(data.userSelectedType == 'R') {
  					address1 = data.roadAddress + "(" + data.bname + data.buildingName + ")";
  				}else { // 지번 주소인 경우
  					address1 = data.jibunAddress;
  				}
  			
  				// 입력란에 우편버오, 주소1 출력 
  				document.getElementById('memZipcode').value = data.zonecode;
  				document.getElementById('memAddress1').value = address1;
  				
  				// address2에 입력 시 이미 입력되어 있는 값 삭제하고 포커스
  				let address2 = document.getElementById('memAddress2');
  				address2.value = "";
  				address2.focus();
  			}  		
  		}).open();
  	});  	
});
