package com.fifadata.hyuk.DTO;

import lombok.Data;

@Data
public class matchDetailDTO {

    private Integer seasonId;
    private String matchResult;
    private Integer matchEndType;
    private Integer systemPause;

    private Integer foul;

    private Integer injury;

    private Integer redCards;

    private Integer yellowCards;
    private Integer dribble;
    private Integer cornerKick;
    private Integer possesion;
    private Integer offsideCount;
    private Double averageRating;
    private String controller;

}
