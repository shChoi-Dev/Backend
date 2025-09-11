package sec08;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class productListViewServlet
 */
@SuppressWarnings("serial")
@WebServlet("/productView")
public class productListViewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	 protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // 1. Controller가 보내준 request로부터 데이터를 꺼냄
	        ArrayList<ProductVO> prdList = (ArrayList<ProductVO>) request.getAttribute("prdList");

	        // 2. HTML 응답 설정
	        response.setContentType("text/html;charset=utf-8");
	        PrintWriter out = response.getWriter();
	        
	        // 3. PrintWriter를 이용해 직접 HTML 화면을 구성
			out.print("<html><head></head><body>");
			out.print("<table border=1><tr align='center' bgcolor='gold'>");
	        out.print("<th>상품번호</th><th>상품명</th><th>가격</th>"
	                + "<th>제조사</th><th>색상</th><th>카테고리 번호</th>"
	                + "</tr>");

	        if (prdList != null && !prdList.isEmpty()) {
	            NumberFormat formatter = NumberFormat.getInstance();
	            for (ProductVO vo : prdList) {
	                out.print("<tr>");
	                out.print("<td>" + vo.getPrdNo() + "</td>");
	                out.print("<td>" + vo.getPrdName() + "</td>");
	                out.print("<td>" + formatter.format(vo.getPrdPrice()) + " 원</td>");
	                out.print("<td>" + vo.getPrdMaker() + "</td>");
	                out.print("<td>" + vo.getPrdColor() + "</td>");
	                out.print("<td>" + vo.getCtgNo() + "</td>");
	                out.print("</tr>");
	            }
	        } else {
	            out.print("<tr><td>등록된 상품이 없습니다.</td></tr>");
	        }

	        out.print("</table></body></html>");
	        out.close();
	    }
	
}
