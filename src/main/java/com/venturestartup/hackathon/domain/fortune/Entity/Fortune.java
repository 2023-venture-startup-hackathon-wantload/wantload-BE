package com.venturestartup.hackathon.domain.fortune.Entity;


import com.venturestartup.hackathon.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "fortune")
@Entity
public class Fortune
    extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String bigTitle;

    @Column(length = 1000, nullable = false)
    private String fortunePhoto;

    @Column(length = 100, nullable = false)
    private String smallTitle;

    @Column(length = 1000, nullable = false)
    private String comments;

}
