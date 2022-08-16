package com.sparta.assignment.domain;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InformationRepository extends JpaRepository<Information,Long> {

    List<Information> findAllByOrderByCreatedAtDesc();

}
