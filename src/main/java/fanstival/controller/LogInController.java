package fanstival.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fanstival.domain.Account;
import fanstival.mapper.AccountMapper;
import fanstival.util.MyBatisUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.IOException;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

/*로그인 컨트롤러(서블릿)*/

@WebServlet(name = "LogInController", urlPatterns = { "/Login" })
public class LogInController extends HttpServlet {

    private static final String SECRET_KEY = "your-secret-key"; // JWT secret key
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("signIn".equals(action)) {
            String userId = request.getParameter("user_id");
            String password = request.getParameter("user_password");

            // 데이터베이스에서 계정을 찾음
            SqlSession sqlSession = MyBatisUtils.getSqlSession();
            try {
                AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
                Account account = accountMapper.getAccountByUserId(userId);


                if (account != null && account.getUser_password().equals(password)) {
                    // 로그인 성공
                    System.out.println("로그인 성공");
                    String token = generateToken(account.getUser_id()); // JWT 토큰 생성
                    response.addHeader("Authorization", "Bearer " + token); // 헤더에 JWT 토큰 추가
                    request.setAttribute("nickname", account.getUser_nick()); // 사용자의 닉네임 설정
                    request.setAttribute("userId", account.getUser_id()); // 사용자의 아이디 설정
                    request.getRequestDispatcher("/WEB-INF/jsp/mainPage/MainPage.jsp").forward(request, response);
                    return;
                }
                else {
                    // 로그인 실패
                    request.setAttribute("error", "Invalid username or password.");
                    request.getRequestDispatcher("/WEB-INF/jsp/account/SignOnForm.jsp").forward(request, response);
                    return;
                }
            } finally {
                sqlSession.close();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 홈페이지로 이동
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    private String generateToken(String userId) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + EXPIRATION_TIME);
        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
}
