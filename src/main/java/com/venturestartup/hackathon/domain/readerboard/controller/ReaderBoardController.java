package com.venturestartup.hackathon.domain.readerboard.controller;

import com.venturestartup.hackathon.domain.readerboard.dto.request.SaveScoreResDto;
import com.venturestartup.hackathon.domain.readerboard.dto.response.SaveScoreReqDto;
import com.venturestartup.hackathon.domain.readerboard.dto.response.SearchRankResponseDto;
import com.venturestartup.hackathon.domain.readerboard.service.ReaderBoardService;
import com.venturestartup.hackathon.global.common.BaseResponse;
import com.venturestartup.hackathon.global.common.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reader-board")
public class ReaderBoardController {

    private final ReaderBoardService readerBoardService;

    @PostMapping("")
    public ResponseEntity<BaseResponse<?>> saveUserScore(SaveScoreResDto saveScoreResDto){
        SaveScoreReqDto saveScoreReqDto = readerBoardService.saveUserScore(saveScoreResDto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, saveScoreReqDto));
    }

    @GetMapping("")
    public ResponseEntity<BaseResponse<?>> getRanking(){
        List<SearchRankResponseDto> rankList = readerBoardService.SearchRankList();
        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, rankList));
    }
}
