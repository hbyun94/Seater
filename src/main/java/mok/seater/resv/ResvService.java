package mok.seater.resv;

import mok.seater.resv.dto.ResvResponse;
import mok.seater.resv.entity.Resv;
import mok.seater.resv.entity.ResvId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResvService {

    @Autowired
    private ResvRepository resvRepository;

    public Resv createResv() {
        LocalDateTime now = LocalDateTime.now();
        String resvDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String resvTime = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        String storeCd = "testStore";
        String userId = "testUser";

        // Find the current maximum seq for the given storeCd, resvDate, userId, and resvTime
        int maxSeq = resvRepository.findMaxSeq(storeCd, resvDate, userId, resvTime).orElse(0);

        Resv resv = Resv.builder()
                .resvId(ResvId.builder()
                        .storeCd(storeCd)
                        .resvDate(resvDate)
                        .resvTime(resvTime)
                        .userId(userId)
                        .seq(String.valueOf(maxSeq + 1))
                        .build())
                .userCnt(4)
                .resvDeposit(100)
                .noShowYn("N")
                .cancelYn("N")
                .confirmYn("N")
                .useYn("Y")
                .build();
        return resvRepository.save(resv);
    }

    public List<ResvResponse> getResv(String storeCd) {
        List<Resv> resvs = resvRepository.findByStoreCd(storeCd);
        return resvs.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ResvResponse convertToDTO(Resv resv) {
        ResvResponse dto = new ResvResponse();
        dto.setUserId(resv.getResvId().getUserId());
        dto.setTime(resv.getResvId().getResvTime());
        dto.setCancelYn(resv.getCancelYn());
        dto.setNoShowYn(resv.getNoShowYn());
        dto.setConfirmYn(resv.getConfirmYn());
        dto.setCancelYn(resv.getCancelYn());
        dto.setUserCnt(resv.getUserCnt());
        return dto;
    }

}
