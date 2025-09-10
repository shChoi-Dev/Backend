package sec04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet06
 */
@SuppressWarnings("serial")
@WebServlet("/second06")
public class SecondServlet06 extends HttpServlet {

	/**
	 * 바인딩으로 전달된 파라미터 출력
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("second06에서 바인딩된 데이터 출력 : redirect가 binding 데이터 활용 가능? redirect 요청될 떄는 새로운 요청 객채가 생성");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//바인딩된 데이터 추출 : getAttribute() Object 타입 반환
		String name = (String)request.getAttribute("name");
		String address = (String)request.getAttribute("address");
		
		out.println("<html><body>");
		out.println("성명 : " + name + "<br>");
		out.println("주소 : " + address + "<br>");
		out.println("</body></html>");
	}

}
