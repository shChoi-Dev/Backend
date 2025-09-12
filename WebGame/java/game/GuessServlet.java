package game;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GuessServlet
 */
@WebServlet("/guess")
public class GuessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

        // 새로운 게임을 위해 세션에 새 난수와 시도 횟수 저장
        Random random = new Random();
        session.setAttribute("randomNumber", random.nextInt(10) + 1);
        session.setAttribute("attempts", 0);

        // 게임 종료 상태 초기화
        request.setAttribute("gameEnd", false);

        // JSP 페이지로 포워딩
        request.getRequestDispatcher("/guess.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        
        // 세션에서 정답과 시도 횟수 가져오기
        Integer randomNumber = (Integer) session.getAttribute("randomNumber");
        Integer attempts = (Integer) session.getAttribute("attempts");
        
        // 세션이 만료되었거나 게임이 시작되지 않은 경우, 초기 화면으로 리다이렉트
        if (randomNumber == null || attempts == null) {
            response.sendRedirect("guess");
            return;
        }

        String message;
        boolean gameEnd = false;

        try {
            // 사용자가 입력한 값 가져오기
            int userGuess = Integer.parseInt(request.getParameter("userGuess"));
            attempts++; // 시도 횟수 증가

            // 정답 비교
            if (userGuess == randomNumber) {
                message = "🙌 드디어 맞혔습니다! 정답은 " + randomNumber + "입니다. (" + attempts + "번 만에 성공!)";
                gameEnd = true;
                session.removeAttribute("randomNumber"); // 게임이 끝났으므로 세션에서 정답 제거
            } else if (userGuess > randomNumber) {
                message = "🙈 아쉽네요! " + userGuess + "보다는 작습니다. 다시 시도해보세요.";
            } else {
                message = "🙈 아쉽네요! " + userGuess + "보다는 큽니다. 다시 시도해보세요.";
            }
            session.setAttribute("attempts", attempts); // 업데이트된 시도 횟수 저장
            
        } catch (NumberFormatException e) {
            message = "🙅‍♂️ ‍잘못된 입력입니다. 1~10 사이의 숫자를 입력해주세요.";
        }

        // 결과를 request에 담아 JSP로 전달
        request.setAttribute("message", message);
        request.setAttribute("gameEnd", gameEnd);
        request.getRequestDispatcher("/guess.jsp").forward(request, response);
	}

}
