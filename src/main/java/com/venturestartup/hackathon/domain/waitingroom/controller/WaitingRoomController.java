package com.venturestartup.hackathon.domain.waitingroom.controller;


import com.venturestartup.hackathon.domain.waitingroom.dto.response.ChangeWaitingNumResponseDto;
import com.venturestartup.hackathon.domain.waitingroom.dto.response.CurWaitingUserResponseDto;
import com.venturestartup.hackathon.domain.waitingroom.dto.response.GetMyPositionResponseDto;
import com.venturestartup.hackathon.domain.waitingroom.service.WaitingRoomService;
import com.venturestartup.hackathon.global.common.BaseResponse;
import com.venturestartup.hackathon.global.common.SuccessCode;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/waiting-room")
@RestController
public class WaitingRoomController {

    private final WaitingRoomService waitingRoomService;

    @GetMapping("/cur")
    public ResponseEntity<BaseResponse<?>> getCurWaitingUserNum(){
        CurWaitingUserResponseDto curWaitingNum = waitingRoomService.getCurWaitingNum();
        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, curWaitingNum));
    }

    @GetMapping("/{position}")
    public ResponseEntity<BaseResponse<?>> getMyPosition(@PathVariable int position){
        GetMyPositionResponseDto newPosition = waitingRoomService.getMyPosition(position);
        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, newPosition));
    }

    @PatchMapping("/{num}")
    public ResponseEntity<BaseResponse<?>> change(@PathVariable int num){
        ChangeWaitingNumResponseDto response = waitingRoomService.changeWaitingNum(num);
        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, response));
    }
}
