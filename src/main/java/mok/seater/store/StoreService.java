package mok.seater.store;

import lombok.RequiredArgsConstructor;
import mok.seater.store.dto.StoreRequest;
import mok.seater.store.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public Store save(StoreRequest storeRequest) {
        Store store = new Store();
        return storeRepository.save(store);
    }

}
