package com.lonewolf.memeStream.config;

/**
 * <p>
 * This class acts as repository of necessary info needed by Swagger for
 * generating Documentation <br>
 * Instantiating this class will cause {@link java.lang.IllegalStateException}
 * <br>
 * </p>
 * 
 * @author Subham Das
 * @version 1.0
 * @see {@link com.lonewolf.memeStream.config.SwaggerConfig}
 */
public class SwaggerConfigRepository {

	public static final String Base_Package = "com.lonewolf.memeStream";

	public static final String Api_Title = "X-MEME Api Documentation";
	public static final String Api_Description = "This is the API Documentation for X-MEME";
	public static final String Api_Version = "1.0";
	public static final String Api_License = "APACHE LICENSE, VERSION 2.0";
	public static final String Api_License_Url = "https://www.apache.org/licenses/LICENSE-2.0";

	public static final String Developer_Name = "Subham Das";
	public static final String Developer_Website = "https://crio-profile.netlify.app/";
	public static final String Developer_Email = "subhamkumardas98@gmail.com";

	public SwaggerConfigRepository() {
		throw new IllegalStateException("Cannot Instantiage " + getClass().getName());
	}
}
