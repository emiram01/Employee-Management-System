package scripts;

public class AppSettings
{
    private String username = "abhishek";
    private String password = "comp380";

    public void setNewLogin(String newUser, String newPass)
    {
        this.username = newUser;
        this.password = newPass;
    }

    public String getUserName() { return username; }

    public String getPassword() { return password; }
}
