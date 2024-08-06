package mok.seater.join;

import mok.seater.join.entity.Join;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoinRepository extends JpaRepository<Join, Long> {
}
