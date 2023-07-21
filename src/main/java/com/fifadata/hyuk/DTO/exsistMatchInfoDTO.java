package com.fifadata.hyuk.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class exsistMatchInfoDTO {


    private String accessId;

    private String nickname;

    private matchDetailDTO matchDetail;

    private shootDTO shoot;

    private List<shootDetailDTO> shootDetail = new ArrayList<>();

    private passDTO pass;

    private defenceDTO defence;

    private List<playerDTO> player=new ArrayList<>();


}
