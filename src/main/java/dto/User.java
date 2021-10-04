package dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class User {
    String email;
    String name;
    String password;
}
