package com.setec.online_survey.config.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EntityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//
//        if (auth == null || !(auth.getPrincipal() instanceof CustomUserDetails user)) {
//            return Optional.of("lms");
//        }
//
//        return Optional.of(user.getUsername());
        return Optional.of("default");
    }
}
