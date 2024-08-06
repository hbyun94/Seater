package mok.seater.join.entity;

import jakarta.persistence.*;
import lombok.*;
import mok.seater.common.entity.BaseEntity;

@Entity
@Getter
@Table(name = "T_USER")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Join extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String password;
    private String userNm;
    private String mobilNo;
    private String gubun;
    private String socialType;
    private String accessToken;
}
