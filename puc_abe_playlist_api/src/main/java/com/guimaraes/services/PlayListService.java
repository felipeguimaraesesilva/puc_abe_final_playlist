package com.guimaraes.services;

import java.util.List;

import com.guimaraes.resource.PlayListResource;

public interface PlayListService {

	void newPlayList(PlayListResource cliente);

	List<PlayListResource> getAll();
}
