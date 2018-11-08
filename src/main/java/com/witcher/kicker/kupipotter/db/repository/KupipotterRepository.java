package com.witcher.kicker.kupipotter.db.repository;

import com.witcher.kicker.kupipotter.db.entity.KupipotterBody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KupipotterRepository extends JpaRepository<KupipotterBody, Long> {
}
