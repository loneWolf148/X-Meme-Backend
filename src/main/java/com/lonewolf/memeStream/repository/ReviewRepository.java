package com.lonewolf.memeStream.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lonewolf.memeStream.entity.Review;

/**
 * <p>
 * This interface encapsulates queries related to reviews about x-meme
 * </p>
 * 
 * @author Subham
 * @version 2.0
 * @since 1.0
 * @see {@link com.lonewolf.memeStream.entity.Review}
 * @see {@link com.lonewolf.memeStream.controller.ReviewController}
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	/**
	 * 
	 * @return Top 20 reviews in descending order by Stars
	 */
	public List<Review> findTop20ByOrderByIdDesc();

	/**
	 * 
	 * @return Existing review of a particular user if it exists, otherwise null
	 */
	@Query("SELECT r FROM Review r WHERE lower(r.reviewer)=lower(?1)")
	public Review reviewExists(String reviewer);
}
