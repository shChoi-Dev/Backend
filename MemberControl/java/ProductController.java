
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * 현재 서블릿이 Front의 역할을 하려면 uri는 특정 uri/* -> 특정 uri로 시작하는 요청은 모두 현재 서블릿이 처리
 * member/select.do, member/abcd /member/abc
 */
@WebServlet("/product/*")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO productDAO;

	/**
	 * memberDAO 객체 인스턴스 생성 : DataSource 객체 생성
	 */
	public void init(ServletConfig config) throws ServletException {
		productDAO = new ProductDAO();
	}

	/**
	 * 모든 요청 처리 메소드 : doHandle()
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = null; // forward 시킬 페이지의 location저장
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo(); // 서블릿에 전달된 경로만 반환(서블릿에 전달되는 경로?)
		System.out.println("action : " + action);

		// http://localhost:8080/MemberControl/member/listMembers.do 로 요청하면 전체 회원정보 조회
		// 기능을 응답
		if (action == null || action.equals("/listProducts.do")) { // 회원정보 조회
			ArrayList<ProductVO> prdList = productDAO.productSelect();
			request.setAttribute("prdList", prdList);
			nextPage = "/listProducts.jsp";
		} else if (action.equals("/productForm.do")) { // 회원가입폼 전송 요청
			nextPage = "/productForm.jsp";
		} else if (action.equals("/addProduct.do")) { // 회원가입처리
			String prdNo = request.getParameter("prdNo");
			String prdName = request.getParameter("prdName");
			int prdPrice = Integer.parseInt(request.getParameter("prdPrice")); // 숫자는 형변환
			String prdMaker = request.getParameter("prdMaker");
			String prdColor = request.getParameter("prdColor");
			int ctgNo = Integer.parseInt(request.getParameter("ctgNo")); // 숫자는 형변환

			// ProductVO 객체를 생성하여 데이터를 담습니다.
			ProductVO productVO = new ProductVO(prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);

			// DAO의 addProduct 메소드를 호출하여 DB에 저장합니다.
			productDAO.addProduct(productVO);

			// 상품 목록 페이지로 리다이렉트합니다.
			nextPage = "/product/listProducts.do";

		} else if (action.equals("/delProduct.do")) {
			String prdNo = request.getParameter("prdNo");
			productDAO.delProduct(prdNo);
			nextPage = "/product/listProducts.do";

		} else if (action.equals("/modProductForm.do")) { // 1. 수정 폼으로 이동 (DB에서 정보 가져오기)
			String prdNo = request.getParameter("prdNo");
			ProductVO prdInfo = productDAO.findProduct(prdNo); // DAO에 findProduct 메소드 필요
			request.setAttribute("prdInfo", prdInfo);
			nextPage = "/modProductForm.jsp";

		} else if (action.equals("/modProduct.do")) { // 2. 수정된 내용을 DB에 반영
			String prdNo = request.getParameter("prdNo");
			String prdName = request.getParameter("prdName");
			int prdPrice = Integer.parseInt(request.getParameter("prdPrice"));
			String prdMaker = request.getParameter("prdMaker");
			String prdColor = request.getParameter("prdColor");
			int ctgNo = Integer.parseInt(request.getParameter("ctgNo"));

			ProductVO productVO = new ProductVO(prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);
			productDAO.modProduct(productVO); // DAO에 modProduct 메소드 필요
			nextPage = "/product/listProducts.do";

		} else {
			List<ProductVO> prdList = productDAO.productSelect();
			request.setAttribute("prdList", prdList);
			nextPage="/listProducts.do";
		}

		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}

}
