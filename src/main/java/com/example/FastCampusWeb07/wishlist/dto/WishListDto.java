package com.example.FastCampusWeb07.wishlist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishListDto {
    //DataBase을 엔티티가 변경이 되면 frontEnd까지 영향을 끼치기 때문에
    //그렇기 때문에 DTO는 중간에 변환만 하는 과정만 있으면 되기때문에 따로 빼서 만들어야된다.
    private Integer index;
    private String title;               //음식명,장소명
    private String category;            //카테고리
    private String address;             //주소
    private String roadAddress;         //도로명
    private String homePageLink;        //홈페이지 주소
    private String imageLink;           //음식, 가게 이미지 주소
    private boolean isVisit;            //방문여부
    private int visitCount;             //방문획수
    private LocalDate lastVisitDate;    //마지막 방문일자
}
