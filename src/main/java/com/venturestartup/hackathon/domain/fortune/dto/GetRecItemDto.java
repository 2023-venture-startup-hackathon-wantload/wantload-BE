package com.venturestartup.hackathon.domain.fortune.dto;

public record GetRecItemDto(

        Long itemId,
        String type,
        String bigTitle,
        String fortunePhoto,
        String smallTitle,
        String comments,
        String itemName,
        Integer sellPrice,
        Integer discount
) {
}
