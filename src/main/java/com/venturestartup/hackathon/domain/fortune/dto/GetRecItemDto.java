package com.venturestartup.hackathon.domain.fortune.dto;

public record GetRecItemDto(
        String bigTitle,
        String fortunePhoto,
        String smallTitle,
        String comments
) {
}
