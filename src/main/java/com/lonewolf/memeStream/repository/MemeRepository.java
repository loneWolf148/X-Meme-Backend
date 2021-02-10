package com.lonewolf.memeStream.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lonewolf.memeStream.entity.Meme;

/**
 * This interface acts as repository to provide methods with necessary queries
 * 
 * @author Subham Das
 * @version 1.0
 * @see {@link com.lonewolf.memeStream.service.MemeService}
 */
@Repository
public interface MemeRepository extends JpaRepository<Meme, Integer> {

	/**
	 * 
	 * @return 100 most recently uploaded memes
	 */
	public List<Meme> findTop100ByOrderByIdDesc();

	/**
	 * 
	 * @param owner   - Uploader of Meme
	 * @param caption - Caption of Meme
	 * @param url     - URL to Meme Image
	 * @return - If same payload already exists returns the meme, otherwise null
	 */
	@Query("SELECT m FROM Meme m WHERE lower(m.name)=?1 AND lower(m.caption)=?2 AND lower(m.url)=?3")
	public Meme memeExists(String owner, String caption, String url);
}
