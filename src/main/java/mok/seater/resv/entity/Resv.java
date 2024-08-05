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
    // jpa는 컬럼 순서를 직접 컨트롤할 수 없기 때문에 직접 ddl을 작성하는것을 권장한다고 함.
        @EmbeddedId
        private ResvId resvId;

        private int userCnt;
        private int resvDeposit;
        private String noShowYn;
        private String cancelYn;
        private String confirmYn;
        private String useYn;
    }



