package cmtproject.comento.domain.manage.repository;

import cmtproject.comento.domain.manage.entity.Manage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ManageRepository extends JpaRepository<Manage, Long> {

    Page<Manage> findByDistinction(String distinction, Pageable pageable);

    Page<Manage> findByCategory(String category, Pageable pageable);

    Page<Manage> findByManageDateBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);
}
