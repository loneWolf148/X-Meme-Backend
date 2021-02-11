package com.lonewolf.memeStream.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lonewolf.memeStream.entity.Review;
import com.lonewolf.memeStream.exception.MemeException;
import com.lonewolf.memeStream.service.ReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This class acts as
 * {@link org.springframework.web.bind.annotation.RestController} to provide API
 * end-points to get and post reviews about x-meme
 * 
 * @author Subham Das
 * @version 2.0
 * @since 1.0
 */
@Api(description = "REST API for Reviews", tags = { "ReviewController" })
@CrossOrigin
@RestController
public class ReviewController {

	@Autowired
	private ReviewService service;

	@ApiResponses({ @ApiResponse(code = 500, message = "Reviews couldn't be fetched"),
			@ApiResponse(code = 200, message = "Reviews fetched succesfully") })
	@ApiOperation(value = "Returns 20 most recently uploaded reviews")
	@GetMapping("/reviews")
	public List<Review> getReviews() {
		List<Review> reviews = service.getReviews();

		if (reviews == null) {
			throw new MemeException("Reviews couldn't be fetched", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return reviews;
	}

	@ApiResponses({ @ApiResponse(code = 404, message = "Review not found"),
			@ApiResponse(code = 200, message = "Review fetched successfully") })
	@ApiOperation(value = "Returns review specified by id")
	@GetMapping("/reviews/{id}")
	public Review getReview(@PathVariable("id") int reviewId) {
		Review review = service.getReview(reviewId);
		return review;
	}

	@ApiResponses({ @ApiResponse(code = 201, message = "Review Posted Successfully"),
			@ApiResponse(code = 409, message = "User already posted a review") })
	@ApiOperation(value = "Posts the review posted by reviewer")
	@PostMapping("/reviews")
	public ResponseEntity<Map<String, String>> postReview(@RequestBody Review reviewContent) {
		Review postedReview = service.postReview(reviewContent);

		Map<String, String> responseContent = new HashMap<>();

		if (postedReview.getId() > 0) {
			responseContent.put("id", Integer.toString(postedReview.getId()));
			return new ResponseEntity<Map<String, String>>(responseContent, HttpStatus.CREATED);
		} else {
			responseContent.put("message", "Review couldn't be posted");
			return new ResponseEntity<Map<String, String>>(responseContent, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
