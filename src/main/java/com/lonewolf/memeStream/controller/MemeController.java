package com.lonewolf.memeStream.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lonewolf.memeStream.entity.Meme;
import com.lonewolf.memeStream.exception.MemeException;
import com.lonewolf.memeStream.service.MemeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This class acts as
 * {@link org.springframework.web.bind.annotation.RestController} to provide API
 * end-points to get,post and update Memes
 * 
 * @author Subham Das
 * @version 1.0
 * @see {@link com.lonewolf.memeStream.controller.HomeController}
 */
@Api
@CrossOrigin
@RestController
public class MemeController {

	@Autowired
	private MemeService service;

	@ApiResponses({ @ApiResponse(code = 200, message = "100 recent most memes fetched successfully"),
			@ApiResponse(code = 404, message = "Not Found") })
	@ApiOperation(value = "Returns 100 most recently uploaded memes")
	@GetMapping("/memes")
	public List<Meme> getMemes() {
		return service.getMemes();
	}

	@ApiResponses({ @ApiResponse(code = 200, message = "Meme Details Fetched Successfully"),
			@ApiResponse(code = 404, message = "Meme With Given ID Doesn't Exists") })
	@ApiOperation(value = "Returns Meme Payload with given ID if exists")
	@GetMapping("/memes/{id}")
	public Meme getMeme(@PathVariable("id") int id) {
		Meme meme = service.getMeme(id);
		if (meme == null) {
			throw new MemeException("Meme Doesn't exist", HttpStatus.NOT_FOUND);
		}

		return meme;
	}

	@ApiResponses({ @ApiResponse(code = 409, message = "Duplicate Meme Payload"),
			@ApiResponse(code = 500, message = "Meme Upload Failure"),
			@ApiResponse(code = 201, message = "Meme Uploaded Successfully") })
	@ApiOperation(value = "Uploads Meme to Database")
	@PostMapping("/memes")
	public ResponseEntity<Map<String, Integer>> submitMeme(@RequestBody Meme newMeme) {
		boolean exists = service.memeExists(newMeme);
		if (exists) {
			throw new MemeException("Duplicate Meme Payload", HttpStatus.CONFLICT);
		}

		Meme uploadedMeme = service.uploadMeme(newMeme);
		if (uploadedMeme == null) {
			throw new MemeException("Meme Cannot Be Uploaded", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		Map<String, Integer> responseBody = new HashMap<>();
		responseBody.put("id", uploadedMeme.getId());

		return new ResponseEntity<Map<String, Integer>>(responseBody, HttpStatus.CREATED);
	}

	@ApiResponses({ @ApiResponse(code = 500, message = "Meme Update Failure"),
			@ApiResponse(code = 200, message = "Meme Payload Updated Successfully") })
	@ApiOperation(value = "Updates Meme Payload")
	@PatchMapping("/memes/{id}")
	public ResponseEntity<Map<String, String>> updateMeme(@PathVariable("id") int id, @RequestBody Meme updateRequest) {
		Meme updatedMeme = service.updateMeme(id, updateRequest);
		if (updatedMeme == null) {
			throw new MemeException("Meme Couldn't be Updated", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		Map<String, String> responseBody = new HashMap<>();
		responseBody.put("message", "Meme Updated Successfully");

		return new ResponseEntity<Map<String, String>>(responseBody, HttpStatus.OK);
	}
}
