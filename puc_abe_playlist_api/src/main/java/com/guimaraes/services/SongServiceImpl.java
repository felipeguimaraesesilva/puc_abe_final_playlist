package com.guimaraes.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guimaraes.entity.SongsEntity;
import com.guimaraes.repository.SongRepository;
import com.guimaraes.resource.SongResource;

@Service
public class SongServiceImpl implements SongService {

	@Autowired
	private SongRepository songRepository;

	@Override
	public void newSong(SongResource song) {
		SongsEntity songEntity = new SongsEntity();
		songEntity.setId(song.getId());
		songEntity.setPlayListId(song.getPlayListId());
		songRepository.save(songEntity);

	}

	@Override
	public List<SongResource> getAll() {
		Iterable<SongsEntity> listSong = songRepository.findAll();
		List<SongResource> result = toSongResource(listSong);
		return result;
	}

	@Override
	public List<SongResource> findByPlayListId(long playListId) {
		Iterable<SongsEntity> listSong = songRepository.findByPlayListId(playListId);
		List<SongResource> result = toSongResource(listSong);
		return result;
	}

	private List<SongResource> toSongResource(Iterable<SongsEntity> listSong) {
		List<SongResource> result = new ArrayList<>();
		for (SongsEntity se : listSong) {
			SongResource s = new SongResource();
			s.setId(se.getId());
			s.setPlayListId(se.getPlayListId());
			result.add(s);
		}
		return result;
	}

}
