package sec06;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * @author Choi SH.
 */

/**
 * Servlet implementation class MemberViewServlet
 */
@WebServlet("/prdView")
public class ProductViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doProcess(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ProductVO> prdList = (ArrayList<ProductVO>)request.getAttribute("productList"); // 형변환
		
		//응답 처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html><head></head><body>");
		out.print("<table border=1><tr align='center' bgcolor='gold'>");
		out.print("<td>상품번호</td><td>상품명</td><td>가격</td>" 
				+ "<td>제조사</td><td>색상</td><td>삭제</td></tr>");
		
		for(int i=0; i<prdList.size(); i++) {
			ProductVO vo = (ProductVO)prdList.get(i);
			//테이블 행을 구성
			out.print("<tr><td>" + vo.getPrdNo() + "</td>");
			out.print("<td>" + vo.getPrdName() + "</td>");
			out.print("<td>" + vo.getPrdPrice() + "</td>");
			out.print("<td>" + vo.getPrdMaker() + "</td>");
			out.print("<td>" + vo.getPrdColor() + "</td>");
			out.print("<td><a href='/Servlet01/prdDelete?id=" +  vo.getPrdNo() + "'>삭제</a></td></tr>");
		}
		out.print("</table></body></html>");
		
		
	}
}
