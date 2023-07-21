package com.fifadata.hyuk.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class matchDTO {

    private String matchId;

    private String matchDate;

    private Integer matchType;

    private List<exsistMatchInfoDTO> matchInfo;
}
