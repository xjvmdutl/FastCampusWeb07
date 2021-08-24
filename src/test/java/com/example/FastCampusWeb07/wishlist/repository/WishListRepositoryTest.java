package com.example.FastCampusWeb07.wishlist.repository;

import com.example.FastCampusWeb07.wishlist.entity.WishListEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest//테스트를 위한 어노테이션
public class WishListRepositoryTest {
    @Autowired
    private WishListRepository wishListRepository;

    private WishListEntity create(){
        var wishList = new WishListEntity();
        wishList.setTitle("title");
        wishList.setCategory("category");
        wishList.setAddress("address");
        wishList.setRoadAddress("roadAddress");
        wishList.setHomePageLink("");
        wishList.setImageLink("");
        wishList.setVisit(false);
        wishList.setVisitCount(0);
        wishList.setLastVisitDate(null);
        return wishList;
    }

    @Test
    public void saveTest(){
        var wishListEntity = create();
        var expected = wishListRepository.save(wishListEntity);

        Assertions.assertNotNull(expected);
        Assertions.assertEquals(1,expected.getIndex());
    }

    @Test
    public void updateTest(){
        var wishListEntity = create();
        var expected = wishListRepository.save(wishListEntity);
        //데이터가 있는경우에는 업데이트하는부분을 확인해야된다
        expected.setTitle("update Test");
        var saveEntity = wishListRepository.save(expected);

        Assertions.assertEquals("update Test",saveEntity.getTitle());
        Assertions.assertEquals(1,wishListRepository.listAll().size());

    }

    @Test
    public void findByIdTest(){
        var wishListEntity =create();
        wishListRepository.save(wishListEntity);
        var expected = wishListRepository.findById(1);
        Assertions.assertEquals(true,expected.isPresent());//값이 있는지 확인
        Assertions.assertEquals(1,expected.get().getIndex());
    }
    @Test
    public void deleteTest(){
        var wishListEntity =create();
        wishListRepository.save(wishListEntity);

        int count = wishListRepository.listAll().size();
        Assertions.assertEquals(0,count);
    }
    @Test
    public void listAllTest(){

        var wishListEntity1 =create();
        wishListRepository.save(wishListEntity1);

        var wishListEntity2 =create();
        wishListRepository.save(wishListEntity2);

        int count = wishListRepository.listAll().size();
        Assertions.assertEquals(2,count);
    }
}
