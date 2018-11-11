package com.witcher.kicker.database.repository;

import com.witcher.kicker.database.entity.InformationBody;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<InformationBody, Long> {
}
