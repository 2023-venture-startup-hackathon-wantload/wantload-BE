package com.venturestartup.hackathon.domain.readerboard.service;


import com.venturestartup.hackathon.domain.readerboard.dto.request.SaveScoreResDto;
import com.venturestartup.hackathon.domain.readerboard.dto.response.SaveScoreReqDto;
import com.venturestartup.hackathon.domain.readerboard.dto.response.SearchRankResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReaderBoardService {

    private final RedisTemplate<String, String> redisTemplate;
    public SaveScoreReqDto saveUserScore(SaveScoreResDto saveScoreResDto) {
        Double score = 0.0;
        try {
            // 검색을하면 해당검색어를 value에 저장하고, score를 1 준다
            redisTemplate.opsForZSet().incrementScore("ranking", saveScoreResDto.getUserName(), 1);
        } catch (Exception e) {
        }
        //score를 1씩 올려준다.
        redisTemplate.opsForZSet().incrementScore("ranking", saveScoreResDto.getUserName(), score);
        return SaveScoreReqDto.of(Boolean.TRUE);
    }
    // 인기검색어 리스트 1위~10위까지
    public List<SearchRankResponseDto> SearchRankList() {
        String key = "ranking";
        ZSetOperations<String, String> ZSetOperations = redisTemplate.opsForZSet();
        Set<ZSetOperations.TypedTuple<String>> typedTuples = ZSetOperations.reverseRangeWithScores(key, 0, 4);  //score순으로 10개 보여줌
        return typedTuples.stream().map(SearchRankResponseDto::convertToResponseRankingDto).collect(Collectors.toList());
    }
}
