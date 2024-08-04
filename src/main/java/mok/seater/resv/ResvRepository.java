package mok.seater.resv;

import mok.seater.resv.entity.Resv;
import mok.seater.resv.entity.ResvId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResvRepository extends JpaRepository<Resv, ResvId> {
}
