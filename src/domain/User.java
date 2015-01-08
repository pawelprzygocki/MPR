package domain;

public class User {

    private String login;
    private String haslo;

    public User(String login, String haslo) {
        this.login = login;
        this.haslo = haslo;
    }
    
    public String getLogin() {
        return login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

}
