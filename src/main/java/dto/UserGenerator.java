package dto;

public class UserGenerator {
    public static User getNewUser() {
        return User
            .builder()
            .name("Robert")
            .email("sapolsky@localhost.lo")
            .password("12345678aaa")
            .build();
    }
}
