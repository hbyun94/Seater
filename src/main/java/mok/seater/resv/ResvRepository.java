package mok.seater.resv;

import mok.seater.resv.entity.Resv;
import mok.seater.resv.entity.ResvId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResvRepository extends JpaRepository<Resv, ResvId> {
    @Query("SELECT MAX(CAST(r.resvId.seq AS int)) FROM Resv r WHERE r.resvId.storeCd = :storeCd AND r.resvId.resvDate = :resvDate AND r.resvId.userId = :userId AND r.resvId.resvTime = :resvTime")
    Optional<Integer> findMaxSeq(String storeCd, String resvDate, String userId, String resvTime);

    @Query("SELECT r FROM Resv r WHERE r.resvId.storeCd = :storeCd")
    List<Resv> findByStoreCd(@Param("storeCd") String storeCd);
}
