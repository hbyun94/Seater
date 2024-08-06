package mok.seater.join.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JoinRequest {
    private String userId;
    private String password;
    private String userNm;
    private String mobilNo;
    private String gubun;
    private String socialType;
    private String accessToken;
}
