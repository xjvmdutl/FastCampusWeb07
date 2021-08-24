package com.example.FastCampusWeb07.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class MemoryDBRepositoryAbstract<T extends MemoryDBEntity> implements MemoryDBRepositoryIfs<T>{
    //데이터를 저장할 리스트
    private final List<T> db = new ArrayList<>();
    private int index = 0;//인덱스

    @Override
    public Optional<T> findById(int index) {
        //자바의 와일드 카드 문법을 이용하여 db에 데이터들은 getIndex()메소드를 항상가지고 있어 접근이 가능하다.
        //첫번째 데이터를 Optional하게(있을수도 없을수도 있다) 가지고 온다
        return db.stream().filter(it->it.getIndex() == index).findFirst();
    }

    @Override
    public T save(T entity) {
        var optionalEntity = db.stream().filter(it->it.getIndex() == entity.getIndex()).findFirst();
        if(optionalEntity.isEmpty()){
            //db에 데이터가 없는경우
            index++;
            entity.setIndex(index);
        }else{
            //db에 이미 데이터가 있는경우
            var preIndex = optionalEntity.get().getIndex();//사전에 있던 인덱스를 가지고온다.
            entity.setIndex(preIndex);
            deleteById(preIndex);
        }
        db.add(entity);
        return entity;
    }

    @Override
    public void deleteById(int index) {
        var optionalEntity = db.stream().filter(it->it.getIndex() == index).findFirst();
        if(optionalEntity.isPresent()){//데이터가 이미 있는경우
            db.remove(optionalEntity.get());
        }
    }

    @Override
    public List<T> listAll() {
        return db;
    }
}
