package fanstival.service;


import fanstival.domain.Account;
import fanstival.mapper.AccountMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountMapper accountMapper;

    public AccountService(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    public Account getAccount(String user_id){
        return accountMapper.getAccountByUserId(user_id);
    }
    public Account getAccount(String user_id, String user_password){
        return accountMapper.getAccountByUserIdAndPassword(user_id, user_password);
    }

    @Transactional//생성
    public void insertAccount(Account account) {
        accountMapper.insertAccount(account);
        accountMapper.insertSignOn(account);
    }

    @Transactional//업데이트
    public void updateAccount(Account account) {
        accountMapper.updateAccount(account);

        Optional.ofNullable(account.getUser_password()).filter(user_password -> user_password.length() > 0)
                .ifPresent(password -> accountMapper.updateSignOn(account));
    }
}

