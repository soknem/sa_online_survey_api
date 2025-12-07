package com.setec.online_survey.features.user;

import com.setec.online_survey.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
