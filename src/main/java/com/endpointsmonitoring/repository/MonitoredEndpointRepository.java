package com.endpointsmonitoring.repository;

import com.endpointsmonitoring.model.entity.MonitoredEndpoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoredEndpointRepository extends JpaRepository<MonitoredEndpoint, Long> {
}
