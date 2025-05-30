package org.example.saysthbackendwebfordbaccess.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateUserRequestDto {
    private String name;
    private String email;
    private String password;
}