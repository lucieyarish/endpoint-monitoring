package com.endpointsmonitoring.controller;

import com.endpointsmonitoring.exceptions.InvalidEmailException;
import com.endpointsmonitoring.model.dto.UserCreateRequestDTO;
import com.endpointsmonitoring.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserCreateRequestDTO request) throws InvalidEmailException {
        if (StringUtils.isBlank(request.getUserName())
                && StringUtils.isBlank(request.getEmail())) {
            Map<String, String> body = new HashMap<>();
            body.put("error", "Please provide user name and email.");
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        } else if (StringUtils.isBlank(request.getUserName())) {
            Map<String, String> body = new HashMap<>();
            body.put("error", "All required fields must be filled out.");
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        } else if (StringUtils.isBlank(request.getEmail())) {
            Map<String, String> body = new HashMap<>();
            body.put("error", "All required fields must be filled out.");
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }

        userService.createUser(request);

        Map<String, String> body = new HashMap<>();
        body.put("status", "ok");

        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
