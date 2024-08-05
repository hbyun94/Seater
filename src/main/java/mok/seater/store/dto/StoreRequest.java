package mok.seater.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreRequest {
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
    private String delYn;
}
