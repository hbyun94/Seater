package mok.seater.join;

import lombok.RequiredArgsConstructor;
import mok.seater.join.dto.JoinRequest;
import mok.seater.join.entity.Join;
import mok.seater.store.StoreRepository;
import mok.seater.store.dto.StoreRequest;
import mok.seater.store.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class JoinService {

    @Autowired
    private JoinRepository joinRepository;

    @Transactional
    public Join save(JoinRequest joinRequest) {
         Join join = Join.builder()
                .userId(joinRequest.getUserId())
                .password(joinRequest.getPassword())
                .userNm(joinRequest.getUserNm())
                .mobilNo(joinRequest.getMobilNo())
                .gubun(joinRequest.getGubun())
                .socialType(joinRequest.getSocialType())
                .accessToken(joinRequest.getAccessToken())
                .build();
        return joinRepository.save(join);
    }
}
