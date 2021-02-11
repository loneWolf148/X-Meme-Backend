package com.lonewolf.memeStream.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.lonewolf.memeStream.entity.Review;
import com.lonewolf.memeStream.exception.MemeException;
import com.lonewolf.memeStream.repository.ReviewRepository;

/**
 * <p>
 * This class encapsulates review related services
 * </p>
 * 
 * @author Subham
 * @version 2.0
 * @since 1.0
 */
@Service
public class ReviewService {
	@Autowired
	private ReviewRepository repository;

	/**
	 * 
	 * @param reviewer - Name of reviewer
	 * @return true if reviewer already posted a review, otherwise false
	 */
	private boolean reviewExists(String reviewer) {
		return repository.reviewExists(reviewer) != null;
	}

	/**
	 * 
	 * @return returns top 20 most recently uploaded reviews
	 */
	public List<Review> getReviews() {
		return repository.findTop20ByOrderByIdDesc();
	}

	/**
	 * 
	 * @param reviewId - id of review
	 * @return review specified by id if already exists in database, otherwise null
	 */
	public Review getReview(int reviewId) {
		Review review = repository.findById(reviewId).orElse(null);
		if (review == null) {
			throw new MemeException("Review Doesn't exist", HttpStatus.NOT_FOUND);
		}
		return review;
	}

	/**
	 * 
	 * @param content - content of review (reviwer name, review, stars)
	 * @return success message if review posted successfully, otherwise error status
	 */
	public Review postReview(Review content) {
		boolean exists = reviewExists(content.getReviewer());
		if (exists) {
			throw new MemeException("You already posted a review", HttpStatus.CONFLICT);
		}

		Review review = new Review();
		review.setReviewer(content.getReviewer());
		review.setComment(content.getComment());
		review.setStars(content.getStars());

		return repository.save(review);
	}
}
