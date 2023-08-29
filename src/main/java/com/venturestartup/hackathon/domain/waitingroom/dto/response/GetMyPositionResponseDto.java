package com.venturestartup.hackathon.domain.waitingroom.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetMyPositionResponseDto {
    private int position;

    public static GetMyPositionResponseDto of(int position){
        if(position < 0) position = 0;

        return GetMyPositionResponseDto.builder()
                .position(position)
                .build();
    }
}
