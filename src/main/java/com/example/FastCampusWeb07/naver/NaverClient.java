package com.example.FastCampusWeb07.naver;

import com.example.FastCampusWeb07.naver.dto.SearchImageReq;
import com.example.FastCampusWeb07.naver.dto.SearchImageRes;
import com.example.FastCampusWeb07.naver.dto.SearchLocalReq;
import com.example.FastCampusWeb07.naver.dto.SearchLocalRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class NaverClient {
    //yaml에서 설정한 값을 가지고 올수 있다.
    @Value("${naver.client.id}")
    private String naverClientId;

    @Value("${naver.client.secret}")
    private String naverClientSecret;

    @Value("${naver.url.search.local}")
    private String naverLocalSearchUrl;

    //값이 없으면 서버가 구동이 안된다.
    @Value("${naver.url.search.image}")
    private String naverImageSearchUrl;

    public SearchLocalRes searchLocal(SearchLocalReq searchLocalReq){
        var uri =
                UriComponentsBuilder
                        .fromUriString(naverLocalSearchUrl)
                        .queryParams(searchLocalReq.toMultiValueMap()) //MultiValueMap형식으로 QueryParam을 넣을수 있다.
                        .build()
                        .encode()
                        .toUri();


        //haeder세팅
        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id",naverClientId);
        headers.set("X-Naver-Client-Secret",naverClientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<SearchLocalRes>(){};

        var responseEntity = new RestTemplate().exchange(
                uri, HttpMethod.GET,httpEntity,responseType
        );
        return responseEntity.getBody();
    }

    public SearchImageRes searchImage(SearchImageReq searchImageReq){
        var uri =
                UriComponentsBuilder
                        .fromUriString(naverImageSearchUrl)
                        .queryParams(searchImageReq.toMultiValueMap()) //MultiValueMap형식으로 QueryParam을 넣을수 있다.
                        .build()
                        .encode()
                        .toUri();


        //haeder세팅
        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id",naverClientId);
        headers.set("X-Naver-Client-Secret",naverClientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<SearchImageRes>(){};

        var responseEntity = new RestTemplate().exchange(
                uri, HttpMethod.GET,httpEntity,responseType
        );
        return responseEntity.getBody();
    }
}
