package com.fifadata.hyuk;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fifadata.hyuk.DTO.*;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Rest {

    public matchDTO restapi(String url) {

        List<exsistMatchInfoDTO> exsistMatchInfoDTOs = new ArrayList<>();
        // create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJYLUFwcC1SYXRlLUxpbWl0IjoiNTAwOjEwIiwiYWNjb3VudF9pZCI6IjEzMDkwMDYwNTMiLCJhdXRoX2lkIjoiMiIsImV4cCI6MTY5MzU2Njc3MiwiaWF0IjoxNjc4MDE0NzcyLCJuYmYiOjE2NzgwMTQ3NzIsInNlcnZpY2VfaWQiOiI0MzAwMTE0ODEiLCJ0b2tlbl90eXBlIjoiQWNjZXNzVG9rZW4ifQ.2VamV0otVRHmOdCoo2PWdcGuB78BSAFOj4HwpQwsRqw");
        MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
        headers.setContentType(mediaType);

//        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        HttpEntity<?> request = new HttpEntity<>( headers);

        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();

        ResponseEntity<matchResponseDTO> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, request, matchResponseDTO.class);

        if (resultMap.getBody().getMatchInfo().get(0).getMatchDetail().getMatchEndType().equals(0)) {



                  exsistMatchInfoDTOs.add(makedata(resultMap.getBody().getMatchInfo().get(0)));
            exsistMatchInfoDTOs.add(makedata(resultMap.getBody().getMatchInfo().get(1)));

            matchDTO dto = matchDTO.builder().matchInfo(exsistMatchInfoDTOs).matchDate(resultMap.getBody().getMatchDate()).matchId(resultMap.getBody().getMatchId()).matchType(resultMap.getBody().getMatchType()).build();


            return dto;
        }




        return null;
    }


    private exsistMatchInfoDTO makedata (Object fromValue ){
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

        matchInfoDTO matchInfo = mapper.convertValue(fromValue, matchInfoDTO.class);
        matchDetailDTO matchDetail=mapper.convertValue(matchInfo.getMatchDetail(), matchDetailDTO.class);

        shootDTO shoot = mapper.convertValue(matchInfo.getShoot(), shootDTO.class);

        List shootDetailList = mapper.convertValue(matchInfo.getShootDetail(), List.class);
        List newShootDetailList = new ArrayList<>();
        for (Object o : shootDetailList) {
            shootDetailDTO dto=mapper.convertValue(o, shootDetailDTO.class);
            newShootDetailList.add(dto);
        }


        passDTO pass =mapper.convertValue(matchInfo.getPass(), passDTO.class);

        defenceDTO defence =mapper.convertValue(matchInfo.getDefence(), defenceDTO.class);
        List playerList =mapper.convertValue(matchInfo.getPlayer(), List.class);
        List newPlayerList = new ArrayList<>();
        for (Object o : newPlayerList) {
            playerDTO dto=mapper.convertValue(o, playerDTO.class);
            newPlayerList.add(dto);
        }


        exsistMatchInfoDTO exsistMatchInfo = exsistMatchInfoDTO.builder().accessId(matchInfo.getAccessId()).nickname(matchInfo.getNickname()).matchDetail(matchDetail).shoot(shoot).shootDetail(shootDetailList).defence(defence).pass(pass).player(playerList).build();
        return exsistMatchInfo;
    }

}
