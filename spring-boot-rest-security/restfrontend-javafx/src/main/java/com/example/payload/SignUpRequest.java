package com.example.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */

@Data
@NoArgsConstructor
public class SignUpRequest {
    @NotBlank
    @Size(min = 4, max = 40)
    private String name;

    @NotBlank
    @Size(min = 3, max = 15)
    private String username;

    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    public SignUpRequest(@NotBlank @Size(min = 4, max = 40) String name, @NotBlank @Size(min = 3, max = 15) String username, @NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(min = 6, max = 20) String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
