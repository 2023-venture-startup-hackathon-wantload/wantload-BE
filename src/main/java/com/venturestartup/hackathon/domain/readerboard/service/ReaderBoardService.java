package com.venturestartup.hackathon.domain.readerboard.service;


import com.venturestartup.hackathon.domain.readerboard.dto.request.SaveScoreResponseDto;
import com.venturestartup.hackathon.domain.readerboard.dto.response.GetMyRankResponseDto;
import com.venturestartup.hackathon.domain.readerboard.dto.response.SaveScoreReqDto;
import com.venturestartup.hackathon.domain.readerboard.dto.response.SearchRankResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class ReaderBoardService {

    private final RedisTemplate<String, String> redisTemplate;
    public SaveScoreReqDto saveUserScore(SaveScoreResponseDto saveScoreResponseDto) {
        System.out.println(saveScoreResponseDto.getScore() + saveScoreResponseDto.getNickName());
//        redisTemplate.opsForZSet().("ranking", saveScoreResDto.getUserName(), saveScoreResDto.getScore());
        if (redisTemplate.hasKey("ranking")) {
            Double originalScore = redisTemplate.opsForZSet().score("ranking", saveScoreResponseDto.getNickName());

            // 기존 점수랑 현재 점수랑 비교해서 더 높은 점수로 저장
            if(originalScore != null)
                redisTemplate.opsForZSet().add("ranking", saveScoreResponseDto.getNickName(), Math.max(saveScoreResponseDto.getScore(), originalScore));

            else
                redisTemplate.opsForZSet().add("ranking", saveScoreResponseDto.getNickName(), saveScoreResponseDto.getScore());
        }
        else{
            // "ranking" key가 존재하지 않으므로 그냥 값 추가
            redisTemplate.opsForZSet().add("ranking", saveScoreResponseDto.getNickName(), saveScoreResponseDto.getScore());
        }

        return SaveScoreReqDto.of(Boolean.TRUE);
    }
    // 인기검색어 리스트 1위~10위까지
    public List<SearchRankResponseDto> SearchRankList() {
        String key = "ranking";
        ZSetOperations<String, String> ZSetOperations = redisTemplate.opsForZSet();
        Set<ZSetOperations.TypedTuple<String>> typedTuples = ZSetOperations.reverseRangeWithScores(key, 0, 4);  //score순으로 10개 보여줌
        return typedTuples.stream().map(SearchRankResponseDto::convertToResponseRankingDto).collect(Collectors.toList());
    }

    public GetMyRankResponseDto getMyRank(String nickName){
        Long ranking=0L;
        Double ranking1 = redisTemplate.opsForZSet().score("ranking", nickName);
        Set<String> ranking2 = redisTemplate.opsForZSet().reverseRangeByScore("ranking", ranking1, ranking1, 0, 1);
        for (String s : ranking2) {
            ranking = redisTemplate.opsForZSet().reverseRank("ranking", s);
        }
        return GetMyRankResponseDto.of((int) (ranking+1));//index가 0부터 시작되어서 1 더해준다
    }
}
