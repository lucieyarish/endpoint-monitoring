package com.endpointsmonitoring.repository;

import com.endpointsmonitoring.model.entity.MonitoringResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoringResultRepository extends JpaRepository<MonitoringResult, Long> {
}
