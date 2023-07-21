package com.fifadata.hyuk.DTO;

import lombok.Data;

import java.util.List;

@Data

public class matchResponseDTO {

    private String matchId;

    private String matchDate;

    private Integer matchType;

    private List<matchInfoDTO> matchInfo;

}
