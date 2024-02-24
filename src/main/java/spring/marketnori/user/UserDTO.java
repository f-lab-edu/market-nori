package spring.marketnori.user;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    @NotBlank
    @Size(max = 255)
    private String id;

    @NotEmpty(message = "패스워드를 올바르게 입력해 주세요.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
    @Size(min = 8, max = 255)
    private String password;

    @NotEmpty(message = "이름을 올바르게 입력해 주세요.")
    @Size(min = 2)
    private String name;

    @NotEmpty(message = "핸드폰 번호를 올바르게 입력해 주세요.")
    @Pattern(regexp = "^01(?:0|1|[6-9])\\d{3,4}\\d{4}$", message = "핸드폰 번호 형식이 올바르지 않습니다.")
    @Size(max = 11)
    private String phone;

    @Email
    @Size(max = 255)
    @NotEmpty(message = "이메일 주소를 올바르게 입력해 주세요.")
    private String email;

    @NotEmpty(message = "주소지를 올바르게 입력해 주세요.")
    @Size(max = 255)
    private String address;

    public UserDTO() {}

    public UserDTO(String id, String password, String name, String phone, String email, String address) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
}
