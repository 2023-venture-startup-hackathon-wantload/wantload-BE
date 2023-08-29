package com.venturestartup.hackathon.domain.readerboard.controller;

import com.venturestartup.hackathon.domain.readerboard.dto.request.SaveScoreResponseDto;
import com.venturestartup.hackathon.domain.readerboard.dto.response.GetMyRankResponseDto;
import com.venturestartup.hackathon.domain.readerboard.dto.response.SaveScoreReqDto;
import com.venturestartup.hackathon.domain.readerboard.dto.response.SearchRankResponseDto;
import com.venturestartup.hackathon.domain.readerboard.service.ReaderBoardService;
import com.venturestartup.hackathon.global.common.BaseResponse;
import com.venturestartup.hackathon.global.common.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/reader-board")
@RestController
public class ReaderBoardController {

    private final ReaderBoardService readerBoardService;

    @PostMapping("")
    public ResponseEntity<BaseResponse<?>> saveUserScore(@RequestBody SaveScoreResponseDto saveScoreResponseDto){
        SaveScoreReqDto saveScoreReqDto = readerBoardService.saveUserScore(saveScoreResponseDto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, saveScoreReqDto));
    }

    @GetMapping("/top")
    public ResponseEntity<BaseResponse<?>> getRanking(){
        List<SearchRankResponseDto> rankList = readerBoardService.SearchRankList();
        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, rankList));
    }

    @GetMapping("/rank")
    public ResponseEntity<BaseResponse<?>> getMyRank(@RequestParam String nickName){
        GetMyRankResponseDto myRank = readerBoardService.getMyRank(nickName);
        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, myRank));
    }
}
