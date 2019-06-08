package com.guimaraes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.guimaraes.constant.AppConstants;
import com.guimaraes.resource.PlayListResource;
import com.guimaraes.services.PlayListService;

@RestController
public class PlayListController {

	@Autowired
	private PlayListService playListService;

	private static final String RESOURCE_NAME = "/playList";
	private static final String CONTEXT_RESOURCE = "/" + AppConstants.VERSION_V1 + RESOURCE_NAME;

	@PostMapping(CONTEXT_RESOURCE)
	public void newPlayList(@RequestBody PlayListResource playListResource) {
		playListService.newPlayList(playListResource);
	}

	@PostMapping(CONTEXT_RESOURCE + "/score")
	public void updateScoreOfPlayList(@RequestBody PlayListResource playListResource) {
		playListService.newPlayList(playListResource);
	}

	@GetMapping(CONTEXT_RESOURCE)
	public List<PlayListResource> getAll() {
		return playListService.getAll();
	}

}
