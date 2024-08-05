package mok.seater.store.entity;

import jakarta.persistence.*;
import lombok.*;
import mok.seater.common.entity.BaseEntity;
import mok.seater.store.dto.StoreRequest;
import org.hibernate.annotations.ColumnDefault;

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
    private String desShort;
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
    @ColumnDefault("'N'")
    private String delYn;

    @PrePersist
    public void prePersist() {
        if(this.delYn == null){
            this.delYn = "N";
        }
    }

    public void updateStore(StoreRequest storeRequest) {
        this.storeName = storeRequest.getStoreName();
        this.desShort = storeRequest.getDesShort();
        this.des = storeRequest.getDes();
        this.telNo = storeRequest.getTelNo();
        this.busiHour = storeRequest.getBusiHour();
        this.regularHoli = storeRequest.getRegularHoli();
        this.homepage = storeRequest.getHomepage();
        this.facilities = storeRequest.getFacilities();
        this.resvUnit = storeRequest.getResvUnit();
        this.openTime = storeRequest.getOpenTime();
        this.closingTime = storeRequest.getClosingTime();
        this.resvPrice = storeRequest.getResvPrice();
    }

    public void updateDelYn(String delYn) {
        this.delYn = delYn;
    }
}
