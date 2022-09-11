package com.endpointsmonitoring.service;

import com.endpointsmonitoring.exceptions.InvalidEmailException;
import com.endpointsmonitoring.model.dto.UserCreateRequestDTO;
import com.endpointsmonitoring.model.entity.User;
import com.endpointsmonitoring.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void createUser(UserCreateRequestDTO userCreateRequestDTO) throws InvalidEmailException {
        boolean isValidEmail = validateEmail(userCreateRequestDTO.getEmail());

        if (!isValidEmail) {
            throw new InvalidEmailException();
        }

        User user = new User();
        user.setUserName(userCreateRequestDTO.getUserName());
        user.setEmail(userCreateRequestDTO.getEmail());
        userRepository.save(user);
    }

    private boolean validateEmail(String email) {
        //Validates both Unicode & Non-Latin email addresses
        String regexPattern = "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@"
                + "[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$";

        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}
