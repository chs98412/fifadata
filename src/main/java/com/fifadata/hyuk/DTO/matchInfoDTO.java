package com.fifadata.hyuk.DTO;

import lombok.Data;

@Data
public class matchInfoDTO {

    private String accessId;

    private String nickname;

    private matchDetailDTO matchDetail;

    private Object shoot;

    private Object shootDetail;

    private Object pass;

    private Object defence;

    private Object player;

}
