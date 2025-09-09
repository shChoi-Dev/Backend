package sec01;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/Hello")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
   	 * @see Servlet#init(ServletConfig)
   	 * 초기화 메서드
   	 */
   	public void init(ServletConfig config) throws ServletException {
   		System.out.println("init 메서드 호출2");
   	}

   	/**
   	 * @see Servlet#destroy()
   	 * 생명주기 마지막에 호출되는 메서드
   	 * 소스코드 변경 재 컴파일, 서버가 재시작(서버종료)시
   	 */
   	public void destroy() {
   		System.out.println("destory 메서드 호출2");
   	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메서드 호출2");
	}


}
