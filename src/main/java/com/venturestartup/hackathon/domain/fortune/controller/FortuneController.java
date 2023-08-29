package com.venturestartup.hackathon.domain.fortune.controller;


import com.venturestartup.hackathon.domain.fortune.service.FortuneService;
import com.venturestartup.hackathon.domain.fortune.dto.GetRecItemDto;
import com.venturestartup.hackathon.global.common.BaseResponse;
import com.venturestartup.hackathon.global.common.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/fortune")
@Controller
public class FortuneController {

    private final FortuneService fortuneService;

    /**
     * 추천 리스트
     */
    @GetMapping
    public ResponseEntity<BaseResponse<?>> getRecommendItem() {
        final List<GetRecItemDto> getRecItemDtos = fortuneService.getRecommendItem();
        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, getRecItemDtos));
    }

}
