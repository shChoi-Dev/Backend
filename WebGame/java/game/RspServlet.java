package game;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RspServlet
 */
@WebServlet("/rsp")
public class RspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 선택 받기
        String userChoice = request.getParameter("choice");

        // 사용자가 아직 선택하지 않았다면(첫 방문), 게임 로직을 실행하지 않음
        if (userChoice != null) {
            // 2. 컴퓨터 선택 생성
            String[] choices = { "가위", "바위", "보" };
            Random random = new Random();
            String computerChoice = choices[random.nextInt(3)];

            // 3. 승패 판정 (기존 GaBaBo.java의 로직 재활용)
            String resultMsg;
            if (userChoice.equals(computerChoice)) {
                resultMsg = "비겼습니다! 😮";
            } else if ((userChoice.equals("가위") && computerChoice.equals("보")) ||
                       (userChoice.equals("바위") && computerChoice.equals("가위")) ||
                       (userChoice.equals("보") && computerChoice.equals("바위"))) {
                resultMsg = "당신이 이겼습니다! 👍";
            } else {
                resultMsg = "당신이 졌습니다. 😭";
            }

            // 4. 결과를 request에 담기
            request.setAttribute("userChoice", userChoice);
            request.setAttribute("computerChoice", computerChoice);
            request.setAttribute("resultMsg", resultMsg);
        }

        // 5. JSP 페이지로 포워딩
        request.getRequestDispatcher("/rsp.jsp").forward(request, response);
    }

}
