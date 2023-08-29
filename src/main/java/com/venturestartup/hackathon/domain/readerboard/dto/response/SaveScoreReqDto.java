package com.venturestartup.hackathon.domain.readerboard.dto.response;


import com.venturestartup.hackathon.domain.readerboard.dto.request.SaveScoreResDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SaveScoreReqDto {

    private Boolean isSuccess;

    public static SaveScoreReqDto of(Boolean isSuccess){
        return SaveScoreReqDto.builder()
                .isSuccess(isSuccess)
                .build();
    }
}
