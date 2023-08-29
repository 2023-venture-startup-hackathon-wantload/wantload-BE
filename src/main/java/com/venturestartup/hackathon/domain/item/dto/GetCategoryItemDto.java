package com.venturestartup.hackathon.domain.item.dto;

public record GetCategoryItemDto(
        Long itemId,
        String name,
        Integer price,
        String itemPhoto
) {
}
