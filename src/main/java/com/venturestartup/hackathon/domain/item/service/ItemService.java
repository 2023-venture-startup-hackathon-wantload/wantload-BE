package com.venturestartup.hackathon.domain.item.service;

import com.venturestartup.hackathon.domain.fortune.constant.FortuneType;
import com.venturestartup.hackathon.domain.fortune.dto.GetRecItemDto;
import com.venturestartup.hackathon.domain.fortune.entity.Fortune;
import com.venturestartup.hackathon.domain.item.constant.ItemType;
import com.venturestartup.hackathon.domain.item.dto.GetCategoryItemDto;
import com.venturestartup.hackathon.domain.item.dto.GetItemDetailDto;
import com.venturestartup.hackathon.domain.item.entity.Item;
import com.venturestartup.hackathon.domain.item.repository.ItemRepository;
import com.venturestartup.hackathon.global.error.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.venturestartup.hackathon.global.error.exception.ErrorCode.ITEM_NOT_FOUND;

@RequiredArgsConstructor
@Transactional
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    /**
     * 카테고리 별 상품 리스트
     */
    public List<GetCategoryItemDto> getCategoryItem(ItemType ItemType) {
        List<GetCategoryItemDto> result = new ArrayList<>();
        List<Item> itemList = itemRepository.findByItemType(ItemType);

        for (Item item : itemList) {
            GetCategoryItemDto dto = convertToCategoryItemDto(item);
            result.add(dto);
        }

        return result;
    }

    private GetCategoryItemDto convertToCategoryItemDto(Item item){
        return new GetCategoryItemDto(
                item.getId(),
                item.getName(),
                item.getOriginPrice() - (item.getOriginPrice() * item.getDiscount() / 100)
        );
    }

    /**
     * 상품 상세보기
     */
    public GetItemDetailDto getItemDetail(Long itemId){
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException(ITEM_NOT_FOUND));

        return new GetItemDetailDto(
                item.getId(),
                item.getName(),
                item.getOriginPrice(),
                item.getDiscount(),
                item.getOriginPrice() - (item.getOriginPrice() * item.getDiscount() / 100),
                item.getCompany(),
                item.getStarPoint(),
                item.getItemPhoto()
        );
    }

}
