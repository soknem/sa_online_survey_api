package com.setec.online_survey.features.user;

import com.setec.online_survey.features.user.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse getUserByEmail(String email);

    List<UserResponse> getAllUser();

    void deleteUserByEmail(String email);

    void disableUserByEmail(String email);

    void enableUserByEmail(String email);

}
