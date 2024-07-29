package mok.seater.store.entity;

import jakarta.persistence.*;
import lombok.*;
import mok.seater.common.entity.BaseEntity;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@Table(name = "Store")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String storeName;
    private String desShot;
    private String des;
    private String telNo;
    private String busiHour;
    private String regularHoli;
    private String homepage;
    private String facilities;
    private String resvUnit;
    private String openTime;
    private String closingTime;
    private String resvPrice;


}
