package sec02;

import java.io.IOException;
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
public class JoinServlet extends HttpServlet {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// utf-8 또는 UTF-8
		
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
		
		// 출력 시작
		System.out.println("--- JoinServlet Console Output ---");
		System.out.println("성명 : " + name);
		System.out.println("ID : " + id);
		System.out.println("비밀번호 : " + pw);
		System.out.println("휴대폰 번호 : " + fmtPhonNum);
		System.out.println("학년 : " + grade);
		
		System.out.print("관심분야 : ");
		for(String inter : interests) {
			System.out.print(inter + " ");
		}
		System.out.println();
		
		System.out.println("학과 : " + department);
		System.out.println("----------------------");
		
		
	}

}
