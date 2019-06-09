package com.guimaraes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.guimaraes.entity.SongsEntity;

@Repository
public interface SongRepository extends CrudRepository<SongsEntity, Long> {

	public List<SongsEntity> findByPlayListId(long playListId);

}
