package mok.seater.resv.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResvResponse {
    private String userId ;
    private String userName;
    private String time;
    private int userCnt;
    private String noShowYn;
    private String cancelYn;
    private String confirmYn;
    private String useYn;

}
