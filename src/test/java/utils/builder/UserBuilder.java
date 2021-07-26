package utils.builder;

public class UserBuilder {

    private User user;

    public static UserBuilder aUser(){
        return new UserBuilder();
    }

    public UserBuilder but(){
        return withDefaultInfo();
    }

    public UserBuilder withDefaultInfo(){
        this.user = User.builder()
                .firstName("Joe")
                .lastName("Doe")
                .phone("+59899123456")
                .email("jdoe@gmail.com")
                .userID("jdoe")
                .password("jdoe99")
                .confirmPassword("jdoe99")
                .build();
        return this;
    }

    public User build(){
        return this.user;
    }
}
