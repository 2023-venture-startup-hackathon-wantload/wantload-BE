package com.venturestartup.hackathon.domain.waitingroom.service;


import com.venturestartup.hackathon.domain.waitingroom.dto.response.CurWaitingUserResponseDto;
import com.venturestartup.hackathon.domain.waitingroom.dto.response.GetMyPositionResponseDto;
import com.venturestartup.hackathon.global.config.redis.RedisUtil;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class WaitingRoomService {

    private final RedisUtil redisUtil;

    private final ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static int outWaitingNum = 0;
    public static int curWaitingNum = 0;

    private  void executeAsync() {
        Random random = new Random();

        executorService.execute(() -> {
            while(true){
                outWaitingNum = random.nextInt(40) + 1;
                int inWaitingNum = random.nextInt(45) + 1;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("[USER] OUT: " + outWaitingNum);
                log.info("[USER] IN: " + inWaitingNum);
                changeUserNumInWaitingRoom(inWaitingNum - outWaitingNum);
                log.info("[USER] CUR " + curWaitingNum);
            }
        });
    }

    // 마치.. 실제 waiting 룸처럼 유저 명수를 1초마다 업데이트해줌
    @PostConstruct
    public void waitingRoomStart(){
        curWaitingNum = 500;
        // 초기 유저 500명
        redisUtil.setData("waiting-room", String.valueOf(curWaitingNum));
        executeAsync();
    }

    private void changeUserNumInWaitingRoom(int diffNum){
        curWaitingNum += diffNum;
        redisUtil.setData("waiting-room", String.valueOf(curWaitingNum));
    }

    public CurWaitingUserResponseDto getCurWaitingNum(){
        return CurWaitingUserResponseDto.of(curWaitingNum);
    }

    public GetMyPositionResponseDto getMyPosition(int position){
        int newPosition = position - outWaitingNum;
        return GetMyPositionResponseDto.of(newPosition);
    }

}
