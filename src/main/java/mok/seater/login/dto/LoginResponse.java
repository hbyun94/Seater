package mok.seater.login.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginResponse {
    private String userId;
    private String userNm;
    private String mobilNo;
    private String gubun;
    private String socialType;
    private String accessToken;
}
