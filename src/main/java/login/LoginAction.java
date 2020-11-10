package login;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private String username, password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Called upon Submit
    public String execute(){
        if(LoginAuth.validate(username, password)){
            return SUCCESS;
        }
        else {
            addActionError("Incorrect username or password provided.");
            return ERROR;
        }
    }

}
