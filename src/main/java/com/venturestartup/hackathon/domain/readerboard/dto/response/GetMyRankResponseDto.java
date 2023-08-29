package com.venturestartup.hackathon.domain.readerboard.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetMyRankResponseDto {
    private int rank;

    public static GetMyRankResponseDto of(int rank){
        return GetMyRankResponseDto.builder()
                .rank(rank)
                .build();
    }
}
