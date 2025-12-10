package com.setec.online_survey.security;

import com.setec.online_survey.features.auth.dto.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
@RequiredArgsConstructor
public class TokenGenerator {

    private final JwtEncoder jwtAccessTokenEncoder;
    private final @Qualifier("jwtRefreshTokenEncoder") JwtEncoder jwtRefreshTokenEncoder;

    private String createAccessToken(CustomUserDetails userDetails) {
        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("ISTAD-LMS")
                .issuedAt(now)
                .expiresAt(now.plus(3, ChronoUnit.DAYS)) // you said 3 days
                .subject(userDetails.getUsername())
                .claim("roles", userDetails.getRoles())
                .build();
        return jwtAccessTokenEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    private String createRefreshToken(CustomUserDetails userDetails) {
        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("ISTAD-LMS")
                .issuedAt(now)
                .expiresAt(now.plus(30, ChronoUnit.DAYS)) // usually longer
                .subject(userDetails.getUsername())
                .build();
        return jwtRefreshTokenEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public AuthResponse generateTokens(Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        String accessToken = createAccessToken(userDetails);

        String refreshToken;
        if (authentication.getCredentials() instanceof Jwt jwt && isRefreshTokenReusable(jwt)) {
            refreshToken = jwt.getTokenValue(); // token rotation: reuse old one
        } else {
            refreshToken = createRefreshToken(userDetails);
        }

        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    private boolean isRefreshTokenReusable(Jwt jwt) {
        Instant now = Instant.now();
        Instant expiresAt = jwt.getExpiresAt();
        if (expiresAt == null) return false;
        return Duration.between(now, expiresAt).toDays() >= 7; // reuse only if >= 7 days left
    }
}