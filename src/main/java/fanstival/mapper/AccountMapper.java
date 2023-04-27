package fanstival.mapper;

import fanstival.domain.Account;

public interface AccountMapper {
    Account getAccountByUserId(String user_id);
    Account getAccountByUserIdAndPassword(String user_id, String user_password);

    void insertAccount(Account account);
    void insertSignOn(Account account);
    void updateAccount(Account account);
    void updateSignOn(Account account);
    void deleteAccount(String user_id);
    void deleteSignOn(String user_id);
}
