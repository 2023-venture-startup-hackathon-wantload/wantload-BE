package com.venturestartup.hackathon.domain.readerboard.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetMyRankResponseDto {
    private int rank;

    private int score;

    public static GetMyRankResponseDto of(int rank, int score){
        return GetMyRankResponseDto.builder()
                .rank(rank)
                .score(score)
                .build();
    }
}
