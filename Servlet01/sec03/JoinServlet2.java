package sec03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * @author Choi.SH
 */

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/insertMember")
public class JoinServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("JoinServlet init 메서드 실행");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("JoinServlet destroy 메서드 실행");
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get방식 요청");
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post방식 요청");
		doProcess(request, response);
	}


	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name"); // 이름
		String id = request.getParameter("id");	// 아이디
		String pw = request.getParameter("pw"); // 비밀번호
		
		// 휴대폰 번호
		String phonF = request.getParameter("phonF");
		String phonS = request.getParameter("phonS");
		String phonT = request.getParameter("phonT");
		String fmtPhonNum = String.format("%s-%s-%s", phonF, phonS, phonT);
		
		String grade = request.getParameter("grade"); // 학년
		String[] interests = request.getParameterValues("interests"); // 관심분야
		String department = request.getParameter("department"); // 학과
		
		// 2. 응답
		// MIME-TYPE 설정
		response.setContentType("text/html;charset=utf-8");
		
		// java i/o 스트림 사용가능한 PrintWriter 객체 생성 - HttpServletResponse의 메소드르 활용
		PrintWriter out = response.getWriter();
		
		// html 문서 형식으로 데이터 작성해서 전송(문자열이 컨테이너쪽으로 출력됨)
		out.println("<html><head></head><body>");
		out.println("성명 : " + name + "<br>");
		out.println("ID : " + id + "<br>");
		out.println("비밀번호 : " + pw + "<br>");
		out.println("휴대폰 번호 : " + fmtPhonNum + "<br>");
		out.println("학년 : " + grade + "<br>");
		out.print("관심분야 : ");
		
		if (interests != null) { // 사용자가 아무것도 선택하지 않은 경우를 대비
		    for (String interest : interests) {
		        out.print(interest + " ");
		    }
		} else {
	        out.print("선택안함");
		}
		
		out.println("<br>");
		out.println("학과 : " + department + "<br>");
		out.println("</body></html>");
		
	}

}
