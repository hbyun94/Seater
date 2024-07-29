package mok.seater.store;

import lombok.RequiredArgsConstructor;
import mok.seater.store.dto.StoreRequest;
import mok.seater.store.dto.StoreResponse;
import mok.seater.store.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public List<StoreResponse> list(){
        List<Store> stores = storeRepository.findAll();

        return stores.stream()
                .map(store -> {
                    StoreResponse response = new StoreResponse();
                    response.setId(store.getId());
                    response.setStoreName(store.getStoreName());
                    response.setDesShot(store.getDesShot());
                    response.setDes(store.getDes());
                    response.setTelNo(store.getTelNo());
                    response.setBusiHour(store.getBusiHour());
                    response.setRegularHoli(store.getRegularHoli());
                    response.setHomepage(store.getHomepage());
                    response.setFacilities(store.getFacilities());
                    response.setResvUnit(store.getResvUnit());
                    response.setOpenTime(store.getOpenTime());
                    response.setClosingTime(store.getClosingTime());
                    response.setResvPrice(store.getResvPrice());
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public Store save(StoreRequest storeRequest) {
        Store store = Store.builder()
                .storeName(storeRequest.getStoreName())
                .desShot(storeRequest.getDesShot())
                .des(storeRequest.getDes())
                .telNo(storeRequest.getTelNo())
                .busiHour(storeRequest.getBusiHour())
                .regularHoli(storeRequest.getRegularHoli())
                .homepage(storeRequest.getHomepage())
                .facilities(storeRequest.getFacilities())
                .resvUnit(storeRequest.getResvUnit())
                .openTime(storeRequest.getOpenTime())
                .closingTime(storeRequest.getClosingTime())
                .resvPrice(storeRequest.getResvPrice())
                .build();
        return storeRepository.save(store);
    }

}
