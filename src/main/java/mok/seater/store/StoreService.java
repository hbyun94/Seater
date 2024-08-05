package mok.seater.store;

import lombok.RequiredArgsConstructor;
import mok.seater.store.dto.StoreRequest;
import mok.seater.store.dto.StoreResponse;
import mok.seater.store.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void init(){
        for(int i=1; i<10; i++){
            Store store = Store.builder()
                    .storeName("store " + i)
                    .desShort("des short " + i)
                    .des("des " + i)
                    .build();
            storeRepository.save(store);
        }
    }

    public List<StoreResponse> list(){
        List<Store> stores = storeRepository.findAll();

        return stores.stream()
                .map(store -> {
                    StoreResponse response = StoreResponse.builder()
                            .id(store.getId())
                            .storeName(store.getStoreName())
                            .desShort(store.getDesShort())
                            .des(store.getDes())
                            .telNo(store.getTelNo())
                            .busiHour(store.getBusiHour())
                            .regularHoli(store.getRegularHoli())
                            .homepage(store.getHomepage())
                            .facilities(store.getFacilities())
                            .resvUnit(store.getResvUnit())
                            .openTime(store.getOpenTime())
                            .closingTime(store.getClosingTime())
                            .resvPrice(store.getResvPrice())
                            .delYn(store.getDelYn())
                            .build();
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public Store save(StoreRequest storeRequest) {
        Store store;

        if (storeRequest.getId() == null) {
            store = Store.builder()
                    .storeName(storeRequest.getStoreName())
                    .desShort(storeRequest.getDesShort())
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
        } else {
            store = storeRepository.findById(storeRequest.getId()).orElse(Store.builder().build());
            store.updateStore(storeRequest);
            return store;
        }
    }


    public StoreResponse getStore(Long id) {
        Store store = storeRepository.findById(id).orElse(null);
        StoreResponse response = StoreResponse.builder()
                .id(id)
                .storeName(store.getStoreName())
                .desShort(store.getDesShort())
                .des(store.getDes())
                .telNo(store.getTelNo())
                .busiHour(store.getBusiHour())
                .regularHoli(store.getRegularHoli())
                .homepage(store.getHomepage())
                .facilities(store.getFacilities())
                .resvUnit(store.getResvUnit())
                .openTime(store.getOpenTime())
                .closingTime(store.getClosingTime())
                .resvPrice(store.getResvPrice())
                .delYn(store.getDelYn())
                .build();
        return response;
    }

    @Transactional
    public void updateDelYn(Long id) {
        Store store = storeRepository.findById(id).orElse(null);
        store.updateDelYn("Y");
    }
}
