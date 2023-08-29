package com.venturestartup.hackathon.domain.waitingroom.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChangeWaitingNumResponseDto {
    private Boolean isSuccess;

    public static ChangeWaitingNumResponseDto of(Boolean isSuccess){
        return ChangeWaitingNumResponseDto.builder()
                .isSuccess(isSuccess)
                .build();
    }
}
