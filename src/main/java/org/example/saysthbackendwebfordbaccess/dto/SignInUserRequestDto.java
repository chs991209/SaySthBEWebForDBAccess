package org.example.saysthbackendwebfordbaccess.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignInUserRequestDto {
    private String email;
    private String password;
}
