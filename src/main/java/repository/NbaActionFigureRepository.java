package repository;

import domain.NbaActionFigure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NbaActionFigureRepository extends JpaRepository<NbaActionFigure, Long> {}