package com.example.FastCampusWeb07.wishlist.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WishListServiceTest {
    @Autowired
    private WishListService wishListService;

    @Test
    public void searchTest(){
        var result = wishListService.search("갈비집");
        System.out.println(result);
        Assertions.assertNotNull(result);
        //현재 service에서 NaverClient를 DI를 받고있기 떄문에 원래는 Mocking처리해서 사용해야된다.

    }
}
