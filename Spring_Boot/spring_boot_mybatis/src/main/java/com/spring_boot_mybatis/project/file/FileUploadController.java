package com.spring_boot_mybatis.project.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	@GetMapping("/fileUploadForm")
	public String ViewUploadForm() {
		return "upload/fileUploadForm";
	}
	
	@PostMapping("/fileUpload")
	public String fileUpload(@RequestParam("uploadFile") MultipartFile file, Model model) throws IOException { // 전송된 파일을 외부 장치(드라이브)에 저장, 예외처리)
		
		// 1. 파일 저장 경로 설정 - 디렉터리 마지막에 / 있어야 함
		String uploadPath = "C:/Users/Web-dev/upload/";
		
		// 2. 전송된 원본 파일 이름 저장
		String originalFileName = file.getOriginalFilename(); // 전송된 파일 명 추출
		
		// 3. 파일이름 중복되지 않도록 이름 변경
		// 서버에 저장할 파일 이름 : UUID 사용
		UUID uuid = UUID.randomUUID();
		String saveFileName = uuid.toString() + "_" + originalFileName;
		
		// 4. 저장을 위한 파일 객체 생성(저장경로를 포함한 파일명으로 객채 생성)
		File sendFile = new File(uploadPath+saveFileName);
		
		// 5. 시스템 내 저장 공간으로 파일 전송
		file.transferTo(sendFile);
		
		// 클라이언트에게 전송한 파일의 전송결과를 표현
		model.addAttribute("originalFileName", originalFileName);
		
		return "upload/fileUploadResult";
	}
	
	// 여러 파일 업로드 : 여러 파일의 정보 파라미터 전달 ArrayList
	@PostMapping("/fileUploadMultiple")
	public String fileUploadMultiple(@RequestParam("uploadFileMulti") ArrayList<MultipartFile> files, Model model) throws IOException {
		
		// 1. 파일 저장 경로 설정 - 디렉터리 마지막에 / 있어야 함
		String uploadPath = "C:/Users/Web-dev/upload/";
		
		// 2. 원본 파일 이름 추출 : 여러개를 저장할 수 있는 변수 구성 이름 저장
		ArrayList<String> originalFileNameList = new ArrayList<String> ();
		
		for(MultipartFile file:files) {
			String originalfileName = file.getOriginalFilename();
			originalFileNameList.add(originalfileName);
			
			UUID uuid = UUID.randomUUID();
			String saveFileName = uuid.toString() + "_" + originalfileName;
			
			File sendFile = new File(uploadPath + saveFileName);
			
			file.transferTo(sendFile);
		}
		
		model.addAttribute("originalFileNameList", originalFileNameList);
		return "upload/fileuploadMultipleResult";
	}
	
	// 파일 이름 변경하지 않고 파일 업로드 : 중복 파일명 허용 (오버라이트 감수)
	// 상품 진열 할때 상품 이미지명을 상품번호로 구성
	@PostMapping("/fileOriginalNameUpload")
	public String fileOrigianlNameUpload(@RequestParam("uploadFileOriginal") MultipartFile file, Model model) throws IOException {
		String uploadPath = "C:/Users/Web-dev/upload/product_image/";
		//"C:/Users/Web-dev/workspaceSpring/product_images/"
		String origianlFileName = file.getOriginalFilename();
		File sendFile = new File(uploadPath + origianlFileName);
		file.transferTo(sendFile);
		
		model.addAttribute("originalFileName", origianlFileName);
		return "upload/fileUploadResult";
	}
	
	// ============================================================= //
	// 비동기통신 요청 처리
	@GetMapping("/imageFileUploadForm")
	public String imageFileUploadForm() {
		return "upload/imageFileUploadForm";
	}
	
	@ResponseBody
	@PostMapping("/imageFileUpload")
	public String imageFileUpload(@RequestParam("uploadFile") MultipartFile file) throws IOException {
		String uploadPath = "C:/Users/Web-dev/upload/";
		String origianlFileName = file.getOriginalFilename();
		File sendFile = new File(uploadPath + origianlFileName);
		file.transferTo(sendFile);
		
		return "success";
	}
	
}
