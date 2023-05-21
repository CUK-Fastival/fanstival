package fanstival.controller;

import javax.servlet.http.HttpServletRequest;

import fanstival.domain.Account;
import fanstival.mapper.AccountMapper;
import fanstival.util.MyBatisUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* 로그인 컨트롤러(Controller) */
@Controller
public class LogInController {

    private static final String SECRET_KEY = "your-secret-key"; // JWT secret key
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days

    @GetMapping("/login")
    public String showLoginForm() {
        System.out.println("로그인 페이지로 이동 실행성공");
        return "/account/SignOnForm";
    }

    @PostMapping("/login")
    public String handleLoginForm(@RequestParam("user_id") String userId, @RequestParam("user_password") String password, Model model) {
        // 데이터베이스에서 계정을 찾음
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
            Account account = accountMapper.getAccountByUserId(userId);

            if (account != null && account.getUser_password().equals(password)) {
                // 로그인 성공
                System.out.println("로그인 성공");
                String token = generateToken(account.getUser_id()); // JWT 토큰 생성
                model.addAttribute("nickname", account.getUser_nick()); // 사용자의 닉네임 설정
                model.addAttribute("userId", account.getUser_id()); // 사용자의 아이디 설정
                return "redirect:/main?userId=" + userId; // userId 추가
            } else {
                // 로그인 실패
                model.addAttribute("error", "Invalid username or password.");
                return "account/SignOnForm";
            }
        }
    }

    @GetMapping("/main")
    public String showMainPage(HttpServletRequest request) {
        String userId = request.getParameter("userId"); // 모델 대신 request.getParameter() 사용
        if (userId == null) {
            return "redirect:/login";
        } else {
            return "mainPage/MainPage";
        }
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
