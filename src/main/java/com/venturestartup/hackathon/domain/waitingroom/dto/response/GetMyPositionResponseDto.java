package com.venturestartup.hackathon.domain.waitingroom.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetMyPositionResponseDto {
    private int position;

    public static GetMyPositionResponseDto of(int position){
        return GetMyPositionResponseDto.builder()
                .position(position)
                .build();
    }
}
