package mok.seater.store.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StoreResponse {
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
