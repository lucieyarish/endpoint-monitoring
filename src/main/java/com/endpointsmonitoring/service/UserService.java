package com.endpointsmonitoring.service;

import com.endpointsmonitoring.exceptions.InvalidEmailException;
import com.endpointsmonitoring.model.dto.UserCreateRequestDTO;

public interface UserService {

    void createUser(UserCreateRequestDTO userCreateRequestDTO) throws InvalidEmailException;
}
