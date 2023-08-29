package com.venturestartup.hackathon.domain.readerboard.dto.request;

import lombok.Getter;

@Getter
public class SaveScoreResponseDto {
    private String nickName;

    private int score;
}
