package com.venturestartup.hackathon.domain.item.repository;

import com.venturestartup.hackathon.domain.item.constant.ItemType;
import com.venturestartup.hackathon.domain.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository
        extends JpaRepository<Item, Long> {

    List<Item>findByItemType(ItemType itemType);
}
