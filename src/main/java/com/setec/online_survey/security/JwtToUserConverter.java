package com.setec.online_survey.security;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtToUserConverter implements Converter<Jwt, UsernamePasswordAuthenticationToken> {

    private final CustomUserDetailsService userDetailsService;

    @Override
    public UsernamePasswordAuthenticationToken convert(Jwt jwt) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(jwt.getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, jwt, userDetails.getAuthorities());
    }
}