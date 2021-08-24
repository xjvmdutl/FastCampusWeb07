package com.example.FastCampusWeb07.wishlist.repository;

import com.example.FastCampusWeb07.db.MemoryDBRepositoryAbstract;
import com.example.FastCampusWeb07.wishlist.entity.WishListEntity;
import org.springframework.stereotype.Repository;

@Repository
public class WishListRepository extends MemoryDBRepositoryAbstract<WishListEntity> {
    //추상클래스로 WishListEntity를 넣었기 때문에 WishListEntity로 잘 동작한다.
}
