package scripts;

public class AppSettings
{
    private String username = "1";
    private String password = "1";

    public void setNewLogin(String newUser, String newPass)
    {
        this.username = newUser;
        this.password = newPass;
    }

    public String getUserName() { return username; }

    public String getPassword() { return password; }
}
