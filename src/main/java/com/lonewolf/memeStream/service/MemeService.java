package com.lonewolf.memeStream.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.lonewolf.memeStream.entity.Meme;
import com.lonewolf.memeStream.exception.MemeException;
import com.lonewolf.memeStream.repository.MemeRepository;

/**
 * This class acts as Service Class which exposes methods to be used by
 * RestController
 * 
 * @author Subham Das
 * @version 1.0
 * @see {@link com.lonewolf.memeStream.controller.MemeController}
 */
@Service
public class MemeService {

	@Autowired
	private MemeRepository repository;

	/**
	 * 
	 * @return List of Meme objects
	 */
	public List<Meme> getMemes() {
		List<Meme> memes = repository.findTop100ByOrderByIdDesc();
		return memes == null ? new ArrayList<>() : memes;
	}

	/**
	 * 
	 * @param memeId - Unique Meme ID
	 * @return Meme object if a meme with {@value memId} exists, otherwise null
	 */
	public Meme getMeme(int memeId) {
		Meme existingMeme = repository.findById(memeId).orElse(null);
		return existingMeme;
	}

	/**
	 * This method checks whether another meme with similar payloads exists in
	 * database
	 * 
	 * @param meme - Meme Payload
	 * @return true if meme with similar payload exists, otherwise false
	 */
	public boolean memeExists(Meme meme) {
		boolean isPresent = repository.memeExists(meme.getName().toLowerCase(), meme.getCaption().toLowerCase(),
				meme.getUrl().toLowerCase()) != null;
		return isPresent;
	}

	/**
	 * 
	 * @param meme - New Meme object with payload to be inserted in database
	 * @return - Persistence Meme Object after inserting into database
	 */
	public Meme uploadMeme(Meme meme) {
		Meme newMeme = new Meme();
		newMeme.setName(meme.getName());
		newMeme.setCaption(meme.getCaption());
		newMeme.setUrl(meme.getUrl());

		return repository.save(newMeme);
	}

	/**
	 * This service method is responsible for updating meme payload in database
	 * 
	 * @param id    - Unique ID of Meme
	 * @param model - Model payload object
	 * @return - Updated Meme payload
	 */
	public Meme updateMeme(int id, Meme model) {
		Meme existingMeme = repository.findById(id).orElse(null);
		if (existingMeme != null) {
			existingMeme.setCaption(model.getCaption());
			existingMeme.setUrl(model.getUrl());
			existingMeme.setName(model.getName());

			return repository.save(existingMeme);
		}
		throw new MemeException("Meme Doesn't exist", HttpStatus.NOT_FOUND);
	}
}
