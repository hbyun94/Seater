package mok.seater.resv.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Table(name = "Resv")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Resv {

    @EmbeddedId
    private ResvId resvId;

    private int userCnt;
    private int resvDeposit;
    private String noShowYn;
    private String cancelYn;
    private String confirmYn;
    private String useYn;
}



