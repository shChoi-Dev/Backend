package sec08;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductBindingServlet1
 */
@SuppressWarnings("serial")
@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. DAO를 통해 데이터베이스에서 상품 목록을 가져옴
        ProductDAO dao = new ProductDAO();
        ArrayList<ProductVO> prdList = dao.productSelect();

        // 2. 조회된 결과를 request 객체에 저장
        request.setAttribute("prdList", prdList);

        // 3. View 역할을 할 ProductViewServlet으로 요청을 포워딩
        RequestDispatcher dispatcher = request.getRequestDispatcher("/productView");
        dispatcher.forward(request, response);
    }

	

}
