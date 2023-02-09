package shopee.api.library;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
public class LoginDetail implements Serializable
{
    private String username;
    private String password;
    private String  confirmationCode; // for forgot password

    public LoginDetail()
    {
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername( String username )
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public String isConfirmationCode()
    {
        return confirmationCode;
    }

    public void setConfirmationCode( String confirmationCode )
    {
        this.confirmationCode = confirmationCode;
    }
}
