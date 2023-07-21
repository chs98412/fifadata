package com.fifadata.hyuk;


import com.fifadata.hyuk.DTO.matchDTO;
import com.fifadata.hyuk.DTO.matchResponseDTO;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.Charset;
import java.util.List;


@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello(){
        return "hello";

    }

    @GetMapping(path = "/getInfo")
    public matchDTO getInfo() {
        // request url
        String url = "https://api.nexon.co.kr/fifaonline4/v1.0/users/f03bef1d33e38e36501d539f/matches?matchtype=50&offset=0&limit=100";
        String jsonData = "{}";

        // create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJYLUFwcC1SYXRlLUxpbWl0IjoiNTAwOjEwIiwiYWNjb3VudF9pZCI6IjEzMDkwMDYwNTMiLCJhdXRoX2lkIjoiMiIsImV4cCI6MTY5MzU2Njc3MiwiaWF0IjoxNjc4MDE0NzcyLCJuYmYiOjE2NzgwMTQ3NzIsInNlcnZpY2VfaWQiOiI0MzAwMTE0ODEiLCJ0b2tlbl90eXBlIjoiQWNjZXNzVG9rZW4ifQ.2VamV0otVRHmOdCoo2PWdcGuB78BSAFOj4HwpQwsRqw");
        MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
        headers.setContentType(mediaType);

//        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        HttpEntity<?> request = new HttpEntity<>( headers);

        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();

        ResponseEntity<List> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, request, List.class);

        //ResponseEntity<String> response = restTemplate.getForEntity(url,String.class,request);
        System.out.println(resultMap);
        System.out.println(resultMap.getBody());
        for (Object s : resultMap.getBody()) {
            System.out.println(s.toString());
        }
        String url2="https://api.nexon.co.kr/fifaonline4/v1.0/matches/"+resultMap.getBody().get(3).toString();

        Rest rest = new Rest();
        matchDTO match = rest.restapi(url2);

        return match;
    }
}
