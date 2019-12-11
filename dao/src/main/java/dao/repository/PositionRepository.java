package dao.repository;

import dto.PositionDto;
import entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
}
