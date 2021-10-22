package dto;

public class UserGenerator {
    public static User getNewUser(String name, String email, String passwd) {
        return User
            .builder()
            .name(name)
            .email(email)
            .password(passwd)
            .build();
    }
}
