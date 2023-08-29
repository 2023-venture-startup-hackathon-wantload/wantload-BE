package com.venturestartup.hackathon.domain.waitingroom.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CurWaitingUserResponseDto {
    private int userNum;

    public static CurWaitingUserResponseDto of(int userNum){
        return CurWaitingUserResponseDto.builder()
                .userNum(userNum)
                .build();
    }
}
