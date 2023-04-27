package fanstival.domain;

public class Account {
    private String user_id;
    private String user_password;
    private String user_name;
    private String user_idol;//사용자가 좋아하는 아이돌
    private String user_phone;
    private String user_nick;
    private String user_email;
    private String auth;//권한 default 값 0 으로 설정(일반 user)


    public String getUser_id(){return user_id;}
    public String getUser_password(){return user_password;}
    public String getUser_name(){return user_name;}
    public String getUser_idol(){return user_idol;}
    public String getUser_phone(){return user_phone;}

    public String getUser_nick(){return user_nick;}
    public String getUser_email(){return user_email;}
    public String getAuth(){return auth;}

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public void setUser_password(String user_password){
        this.user_password = user_password;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_idol(String user_idol) {
        this.user_idol = user_idol;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public void setUser_nick(String user_nick){this.user_nick = user_nick;}
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String toString(){
        return "ID: " + getUser_id() +"\n" + "PASSWORD: " +getUser_password()+"\n" + "NAME: " +getUser_name()+ "\n" +"NickName: " +getUser_nick()+ "\n"+
                "IDOL: " + getUser_idol() +"\n" + "PHONE: " + getUser_phone() + "\n" + "e-mail: " + getUser_email() ;
    }
}
