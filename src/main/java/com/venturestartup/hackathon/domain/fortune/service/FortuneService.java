package com.venturestartup.hackathon.domain.fortune.service;

import com.venturestartup.hackathon.domain.fortune.constant.FortuneType;
import com.venturestartup.hackathon.domain.fortune.dto.GetRecItemDto;
import com.venturestartup.hackathon.domain.fortune.entity.Fortune;
import com.venturestartup.hackathon.domain.fortune.repository.FortuneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class FortuneService {

    private final FortuneRepository fortuneRepository;

    /**
     * 추천 리스트
     */
    public List<GetRecItemDto> getRecommendItem() {
        List<GetRecItemDto> result = new ArrayList<>();

        for (FortuneType type : FortuneType.values()) {
            List<Fortune> fortunes = fortuneRepository.findByFortuneType(type);
            List<GetRecItemDto> dtoList = fortunes.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
            result.addAll(dtoList);
        }

        return result;
    }

    private GetRecItemDto convertToDto(Fortune fortune) {
        return new GetRecItemDto(
                fortune.getId(),
                fortune.getFortuneType().name(),
                fortune.getBigTitle(),
                fortune.getFortunePhoto(),
                fortune.getSmallTitle(),
                fortune.getComments(),
                fortune.getItemName(),
                fortune.getSellPrice(),
                fortune.getDiscount()
        );
    }
}
