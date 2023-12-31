package com.venturestartup.hackathon.domain.fortune.entity;


import com.venturestartup.hackathon.domain.fortune.constant.FortuneType;
import com.venturestartup.hackathon.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "fortune")
@Entity
public class Fortune
    extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private FortuneType fortuneType;

    @Column(length = 100, nullable = false)
    private String bigTitle;

    @Column(length = 1000, nullable = false)
    private String fortunePhoto;

    @Column(length = 100, nullable = false)
    private String smallTitle;

    @Column(length = 1000, nullable = false)
    private String comments;

    @Column(length = 100, nullable = false)
    private String itemName;

    @Column(nullable = false)
    private Integer sellPrice;

    @Column(nullable = false)
    private Integer discount;

}
