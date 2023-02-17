package gulas.saveli.library4.UserPackage.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @NotEmpty
    private String firstName;
    private String lastName;
    @NotEmpty(message = "Please enter an email")
    @Email
    private String email;
    @NotEmpty(message = "Please enter a password")
    private String password;
}
