package com.guimaraes.services;

import java.util.List;

import com.guimaraes.resource.SongResource;

public interface SongService {

	void newSong(SongResource song);

	List<SongResource> getAll();

	List<SongResource> findByPlayListId(long playListId);
}
