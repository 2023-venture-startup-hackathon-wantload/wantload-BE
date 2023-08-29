package com.venturestartup.hackathon.domain.readerboard.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.ZSetOperations;

@Getter
@Builder
public class SearchRankResponseDto {

    private String userName;

    private int score;

    public static SearchRankResponseDto of(String userName, int score){
        return SearchRankResponseDto.builder()
                .userName(userName)
                .score(score)
                .build();
    }

    public static SearchRankResponseDto convertToResponseRankingDto(ZSetOperations.TypedTuple typedTuple){

        return SearchRankResponseDto.builder()
                .userName(typedTuple.getValue().toString())
                .score(typedTuple.getScore().intValue())
                .build();
    }

}
