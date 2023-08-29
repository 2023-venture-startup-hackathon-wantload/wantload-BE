package com.venturestartup.hackathon.domain.readerboard.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.ZSetOperations;

@Getter
@Builder
public class SearchRankResponseDto {

    private String nickName;

    private int score;

    public static SearchRankResponseDto of(String nickName, int score){
        return SearchRankResponseDto.builder()
                .nickName(nickName)
                .score(score)
                .build();
    }

    public static SearchRankResponseDto convertToResponseRankingDto(ZSetOperations.TypedTuple typedTuple){

        return SearchRankResponseDto.builder()
                .nickName(typedTuple.getValue().toString())
                .score(typedTuple.getScore().intValue())
                .build();
    }

}
