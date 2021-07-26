package utils.builder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String firstName,
            lastName,
            phone,
            email,
            userID,
            password,
            confirmPassword;
}
