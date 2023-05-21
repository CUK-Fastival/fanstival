package fanstival.controller;

import fanstival.domain.Account;
import fanstival.mapper.AccountMapper;
import fanstival.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/* 회원가입 컨트롤러(Controller) */
@Controller
@RequestMapping("/Registration")
public class RegistrationController {
    private static final long serialVersionUID = 1L;

    @GetMapping("/newAccount")
    public String showAccountForm() {
        // 새로운 계정 생성 페이지로 이동
        return "account/AccountForm";
    }

    @PostMapping("/register")
    public String registerAccount(Account account, Model model) {
        // 회원 가입 처리

        // AccountMapper를 이용하여 계정 정보 저장
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        try {
            AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
            accountMapper.insertAccount(account);
            accountMapper.insertSignOn(account);
            sqlSession.commit();
            System.out.println("회원가입 성공");
            return "redirect:/index.jsp";

        } catch (Exception e) {
            System.out.println("실패");
            sqlSession.rollback();
            throw e;
        } finally {
            sqlSession.close();
        }
    }
}
