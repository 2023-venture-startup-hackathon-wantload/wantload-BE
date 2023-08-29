package com.venturestartup.hackathon.domain.item.controller;

import com.venturestartup.hackathon.domain.fortune.dto.GetRecItemDto;
import com.venturestartup.hackathon.domain.item.constant.ItemType;
import com.venturestartup.hackathon.domain.item.dto.GetCategoryItemDto;
import com.venturestartup.hackathon.domain.item.service.ItemService;
import com.venturestartup.hackathon.global.common.BaseResponse;
import com.venturestartup.hackathon.global.common.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/item")
@RestController
public class ItemController {

    private final ItemService itemService;

    /**
     * 카테고리 별 상품 리스트
     */
    @GetMapping(value = "{itemType}")
    public ResponseEntity<BaseResponse<?>> getCategoryItem(
            @PathVariable ItemType itemType) {
        final List<GetCategoryItemDto> getCategoryItemDtos = itemService.getCategoryItem(itemType);
        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, getCategoryItemDtos));
    }




    /**
     * 상품 상세보기
     */

}
