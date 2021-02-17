package app.gira.domain.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginBindingModel {
    @Email(message = "Enter a valid email address!")
    @NotBlank(message = "Email must be added!")
    private String email;
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters!")
    private String password;
}
