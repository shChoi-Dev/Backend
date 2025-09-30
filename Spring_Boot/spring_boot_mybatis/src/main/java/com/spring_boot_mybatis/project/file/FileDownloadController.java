package com.spring_boot_mybatis.project.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.http.HttpServletResponse;


@Controller
public class FileDownloadController {

	// 다운로드 리스트 페이지 요청 처리
	@GetMapping("/fileDownloadList")
	public String fileDownloadList(Model model) {
		
		File path = new File("C:/Users/Web-dev/upload");
		String[] fileList = path.list(); // 객체가 dir로 구성된 경우 디렌터리의 모든 파일 정보(파일명) 반환
		
		model.addAttribute("fileList", fileList);
		
		return "upload/fileDownloadList";
	}
	
	// 다운로드 요청 처리
	@GetMapping("/fileDownload/{file}")
	public void fileDownload(@PathVariable String file, HttpServletResponse response) throws IOException{
		// 파일 객체 생성(서버내에서 사용)
		File f = new File("C:/Users/Web-dev/upload", file);
		
		// 한글파일명 인코딩
		String encodedFileName = new String(file.getBytes("UTF-8"),"ISO-8859-1");
		
		// response 객체 헤더 구성(파일 정보)
		response.setContentType("application/download");
		response.setContentLength((int)f.length()); // 파일 크기정보
		response.setHeader("Content-Disposition",  
				"attatchment;filename=\"" + encodedFileName + "\"");
		
		// 파일 다운로드 처리 (file i/o stream을 통해서 FileCopyUtils.copy()
		FileInputStream fis = new FileInputStream(f);
		OutputStream os = response.getOutputStream();
		
		// 파일 다운로드
		FileCopyUtils.copy(fis, os);
	}
	
}
