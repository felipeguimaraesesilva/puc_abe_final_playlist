package com.guimaraes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.guimaraes.entity.PlayListEntity;

@Repository
public interface PlayListRepository extends CrudRepository<PlayListEntity, Long> {

}
