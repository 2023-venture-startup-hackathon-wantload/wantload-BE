package com.venturestartup.hackathon.domain.item.dto;

public record GetItemDetailDto(
        Long itemId,
        String name,
        Integer originPrice,
        Integer discount,
        Integer sellPrice,
        String company,
        Integer starPoint,
        String itemPhoto

) {
}
