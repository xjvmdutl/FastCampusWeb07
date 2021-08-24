package com.example.FastCampusWeb07.wishlist.entity;

import com.example.FastCampusWeb07.db.MemoryDBEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishListEntity extends MemoryDBEntity {//MemoryDBEntity를 상속 받아야된다
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
