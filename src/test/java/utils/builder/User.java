package utils.builder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String userID;
    private String password;
    private String confirmPassword;

}
