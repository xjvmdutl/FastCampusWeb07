package com.example.FastCampusWeb07.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchLocalRes {
    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private String category;
    private List<SearchLocalItem> items;

    //item처럼 내부에 리스트 존재하는것은 클래스로 만든다
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SearchLocalItem {
        private String title;
        private String link;
        private String description;
        private String telephone;
        private String address;
        private String roadAddress;
        private int mapx;
        private int mapy;
    }
}
