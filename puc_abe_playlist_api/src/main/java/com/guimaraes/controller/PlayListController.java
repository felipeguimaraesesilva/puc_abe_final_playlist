package com.guimaraes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.guimaraes.constant.AppConstants;
import com.guimaraes.request.PlayListRequest;
import com.guimaraes.request.PlayListScoreRequest;
import com.guimaraes.request.SongRequest;
import com.guimaraes.resource.PlayListResource;
import com.guimaraes.resource.SongResource;
import com.guimaraes.services.PlayListService;
import com.guimaraes.services.SongService;

@RestController
public class PlayListController {

	@Autowired
	private PlayListService playListService;

	@Autowired
	private SongService songService;

	private static final String RESOURCE_NAME = "/playList";
	private static final String CONTEXT_RESOURCE = "/" + AppConstants.VERSION_V1 + RESOURCE_NAME;

	@PostMapping(CONTEXT_RESOURCE)
	public void newPlayList(@RequestBody PlayListRequest playListRequest) {
		PlayListResource playListResource = new PlayListResource();
		playListResource.setNome(playListRequest.getNome());
		playListResource.setScore(playListRequest.getScore());
		playListService.newPlayList(playListResource);
	}

	@PostMapping(CONTEXT_RESOURCE + "/{playListId}/score")
	public ResponseEntity updateScoreOfPlayList(@PathVariable("playListId") long playListId,
			@RequestBody PlayListScoreRequest playListScoreRequest) {

		if (playListScoreRequest.getScore() > 5) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		playListService.updateScore(playListId, playListScoreRequest.getScore());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(CONTEXT_RESOURCE + "/{playListId}/song")
	public void postNewSong(@PathVariable("playListId") long playListId, @RequestBody SongRequest songRequest) {
		SongResource songResource = new SongResource();
		songResource.setPlayListId(playListId);
		songRequest.setId(songRequest.getId());
		songService.newSong(songResource);
	}

	@GetMapping(CONTEXT_RESOURCE)
	public List<PlayListResource> getAll() {
		return playListService.getAll();
	}

	@GetMapping(CONTEXT_RESOURCE + "/{playListId}/song")
	public List<SongResource> getSongsByPlayListId(@PathVariable("playListId") long playListId) {
		return songService.findByPlayListId(playListId);
	}

}
