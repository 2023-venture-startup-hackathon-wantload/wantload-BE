package com.venturestartup.hackathon.domain.item.entity;

import com.venturestartup.hackathon.domain.fortune.constant.FortuneType;
import com.venturestartup.hackathon.domain.item.constant.ItemType;
import com.venturestartup.hackathon.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "item")
@Entity
public class Item
        extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private ItemType itemType;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer originPrice;

    @Column(nullable = false)
    private Integer discount;

    @Column(length = 100, nullable = false)
    private String company;

    @Column(nullable = false)
    private Integer starPoint;

    @Column(length = 1000, nullable = false)
    private String itemPhoto;

}
