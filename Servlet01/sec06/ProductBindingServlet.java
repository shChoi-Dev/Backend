package sec06;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * @author Choi SH.
 */

/**
 * Servlet implementation class MemberBindingServlet
 */
@SuppressWarnings("serial")
@WebServlet("/prdBinding")
public class ProductBindingServlet extends HttpServlet {
	
    /**
	 * 요청을 doProcess로 넘김
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * 요청을 doProcess로 넘김
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	// Get/Post 요청 모두를 처리하는 처리 메서드
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB의 member 테이블에서 데이터를 select해와서 ArrayList에 저장한다고 가정
		ProductVO vo1 = new ProductVO("SM-S938N", "갤럭시 S25 울트라", "1850000", "삼성전자", "티타늄 블랙");
		ProductVO vo2 = new ProductVO("NK-CJ001-800", "나이키 에어맥스 97", "219000", "나이키", "선셋 오렌지");
		ProductVO vo3 = new ProductVO("NES-VP-D123", "네스프레소 버츄오 플러스", "299000", "드롱기", "체리 레드");
		
		ArrayList<ProductVO> prdList = new ArrayList<ProductVO>();
		prdList.add(vo1);
		prdList.add(vo2);
		prdList.add(vo3);
		
		//데이터 바인딩
		request.setAttribute("productList", prdList); //바인딩되는 data Object 타입이므로 데이터 타입 상관없이 바인딩 가능
		
		//포워딩
		RequestDispatcher dispatch = request.getRequestDispatcher("prdView");
		dispatch.forward(request, response);
	}

}
