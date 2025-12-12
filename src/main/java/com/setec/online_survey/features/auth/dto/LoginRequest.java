package com.setec.online_survey.features.auth.dto;

public record LoginRequest(
        String email,
        String password
) { }