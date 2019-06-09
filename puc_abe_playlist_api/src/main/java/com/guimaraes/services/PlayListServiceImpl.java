package com.guimaraes.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guimaraes.entity.PlayListEntity;
import com.guimaraes.repository.PlayListRepository;
import com.guimaraes.resource.PlayListResource;

@Service
public class PlayListServiceImpl implements PlayListService {

	@Autowired
	private PlayListRepository playListRepository;

	@Override
	public void newPlayList(PlayListResource playListR) {
		PlayListEntity newPlayList = new PlayListEntity();
		newPlayList.setNome(playListR.getNome());
		newPlayList.setScore(playListR.getScore());
		playListRepository.save(newPlayList);
	}

	@Override
	public List<PlayListResource> getAll() {
		List<PlayListResource> resultado = new ArrayList<>();
		Iterable<PlayListEntity> playLists = playListRepository.findAll();

		for (PlayListEntity playListEntity : playLists) {
			PlayListResource pl = new PlayListResource();
			pl.setId(playListEntity.getId());
			pl.setNome(playListEntity.getNome());
			pl.setScore(playListEntity.getScore());
			resultado.add(pl);
		}

		return resultado;
	}

	@Override
	public void updateScore(long playListId, int score) {
		Optional<PlayListEntity> playList = playListRepository.findById(playListId);
		if (playList.isPresent()) {
			playList.get().setScore(score);
			playListRepository.save(playList.get());
		}
	}

}
