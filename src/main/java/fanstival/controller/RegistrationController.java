package fanstival.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fanstival.domain.Account;
import fanstival.mapper.AccountMapper;
import fanstival.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

/* 회원가입 컨트롤러(Servlet) */
@WebServlet(name = "RegistrationController", urlPatterns = { "/Registration" })
public class RegistrationController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("newAccount".equals(action)) {
            // 새로운 계정 생성 페이지로 이동
            request.getRequestDispatcher("/WEB-INF/jsp/account/AccountForm.jsp").forward(request, response);
        }else if ("register".equals(action)) {
            // 회원 가입 처리
            String userId = request.getParameter("user_id");
            String password = request.getParameter("user_password");
            String name = request.getParameter("user_name");
            String idol = request.getParameter("user_idol");
            String phone = request.getParameter("user_phone");
            String nick = request.getParameter("user_nick");
            String email = request.getParameter("user_email");

            // Account 객체 생성 및 값을 설정
            Account account = new Account();
            account.setUser_id(userId);
            account.setUser_password(password);
            account.setUser_name(name);
            account.setUser_idol(idol);
            account.setUser_phone(phone);
            account.setUser_nick(nick);
            account.setUser_email(email);

            // AccountMapper를 이용하여 계정 정보 저장
            SqlSession sqlSession = MyBatisUtils.getSqlSession();
            try {
                AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
                accountMapper.insertAccount(account);
                accountMapper.insertSignOn(account);
                sqlSession.commit();
                System.out.println("회원가입 성공");
                response.sendRedirect(request.getContextPath() + "/index.jsp");

            } catch (Exception e) {
                System.out.println("실패");
                sqlSession.rollback();
                throw e;
            } finally {
                sqlSession.close();
            }
        }
    }
}
