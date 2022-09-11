package com.endpointsmonitoring.repository;

import com.endpointsmonitoring.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
