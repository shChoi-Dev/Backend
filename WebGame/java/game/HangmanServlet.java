package game;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HangmanServlet
 */
@WebServlet("/hangman")
public class HangmanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    // 게임에서 사용할 단어 목록
    private static final String[] WORDS = {"APPLE", "BANANA", "ORANGE", "MANGO", "STRAWBERRY", "GRAPE"};
    private static final int MAX_ATTEMPTS = 6;

    // GET 요청: 새 게임 시작
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        
        // 단어 목록에서 무작위로 단어 선택
        Random random = new Random();
        String secretWord = WORDS[random.nextInt(WORDS.length)];
        
        // 게임 상태 초기화 및 세션에 저장
        char[] wordState = new char[secretWord.length()];
        Arrays.fill(wordState, '_');
        
        session.setAttribute("secretWord", secretWord);
        session.setAttribute("wordState", wordState);
        session.setAttribute("remainingAttempts", MAX_ATTEMPTS);
        session.setAttribute("guessedLetters", new HashSet<Character>()); // 추측한 모든 알파벳
        
        // JSP 페이지로 포워딩
        request.getRequestDispatcher("/hangman.jsp").forward(request, response);
    }

	// POST 요청: 알파벳 추측 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        
		if (session.getAttribute("secretWord") == null || session.getAttribute("wordState") == null ||
				session.getAttribute("remainingAttempts") == null || session.getAttribute("guessedLetters") == null) {
				
				// 정보가 없으면 새 게임을 시작하도록 GET 요청으로 리다이렉트
				response.sendRedirect("hangman");
				return;
			}
		
        String secretWord = (String) session.getAttribute("secretWord");
        char[] wordState = (char[]) session.getAttribute("wordState");
        int remainingAttempts = (int) session.getAttribute("remainingAttempts");
        @SuppressWarnings("unchecked")
        Set<Character> guessedLetters = (Set<Character>) session.getAttribute("guessedLetters");
        
        // 사용자가 추측한 알파벳 받기 (대문자로 변환)
        String guessParam = request.getParameter("guess");
        
        // 게임이 이미 끝났거나, 유효하지 않은 입력이면 JSP로 포워딩
        if (isGameFinished(session) || guessParam == null || guessParam.length() != 1) {
            request.getRequestDispatcher("/hangman.jsp").forward(request, response);
            return;
        }
        
        char guessedChar = guessParam.toUpperCase().charAt(0);
        
        // 이미 추측한 알파벳인지 확인
        if (!guessedLetters.contains(guessedChar)) {
            guessedLetters.add(guessedChar);
            
            // 추측한 알파벳이 정답에 포함되어 있는지 확인
            if (secretWord.indexOf(guessedChar) >= 0) {
                // 포함되어 있다면, '_' 를 해당 알파벳으로 변경
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == guessedChar) {
                        wordState[i] = guessedChar;
                    }
                }
            } else {
                // 포함되어 있지 않다면, 남은 기회 감소
                remainingAttempts--;
            }
        }
        
        // 업데이트된 게임 상태를 세션에 다시 저장
        session.setAttribute("wordState", wordState);
        session.setAttribute("remainingAttempts", remainingAttempts);
        session.setAttribute("guessedLetters", guessedLetters);
        
        // 게임 종료 조건 확인 및 메시지 설정
        if (isGameWon(wordState)) {
            request.setAttribute("gameMessage", "축하합니다! 단어를 맞혔습니다! 💯");
        } else if (remainingAttempts <= 0) {
            request.setAttribute("gameMessage", "게임 오버! 정답은 '" + secretWord + "' 였습니다. 😭");
        }
        
        request.getRequestDispatcher("/hangman.jsp").forward(request, response);
	}
    
    // 게임 승리 여부 확인
    private boolean isGameWon(char[] wordState) {
        for (char c : wordState) {
            if (c == '_') return false;
        }
        return true;
    }
    
    // 게임 종료 여부 확인
    private boolean isGameFinished(HttpSession session) {
        if (session.getAttribute("remainingAttempts") == null) return true;
        
        int attempts = (int) session.getAttribute("remainingAttempts");
        char[] wordState = (char[]) session.getAttribute("wordState");
        return attempts <= 0 || isGameWon(wordState);
    }

}
