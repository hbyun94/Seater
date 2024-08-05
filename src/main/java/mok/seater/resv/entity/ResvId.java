package mok.seater.resv.entity;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResvId implements Serializable {
    private String storeCd;
    private String resvDate;
    private String userId;
    private String resvTime;
    private String seq;

//    public ResvId() {}
//
//    public ResvId(String storeCd, String resvDate, String userId, String resvTime, String seq) {
//        this.storeCd = storeCd;
//        this.resvDate = resvDate;
//        this.userId = userId;
//        this.resvTime = resvTime;
//        this.seq = seq;
//    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ResvId resvId = (ResvId) o;
//        return Objects.equals(storeCd, resvId.storeCd) &&
//                Objects.equals(resvDate, resvId.resvDate) &&
//                Objects.equals(userId, resvId.userId) &&
//                Objects.equals(resvTime, resvId.resvTime) &&
//                Objects.equals(seq, resvId.seq);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(storeCd, resvDate, userId, resvTime, seq);
//    }
}
