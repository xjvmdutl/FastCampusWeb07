package com.example.FastCampusWeb07.db;

import java.util.List;
import java.util.Optional;

public interface MemoryDBRepositoryIfs<T> {//제네릭 타입

    Optional<T> findById(int index);//해당 타입에 대하여 리턴
    T save(T entity);//저장
    void deleteById(int index);//삭제
    List<T> findAll();//리스트를 반환

}
