package com.venturestartup.hackathon.domain.readerboard.dto.request;

import lombok.Getter;

@Getter
public class SaveScoreResDto {
    private String userName;

    private int score;
}
