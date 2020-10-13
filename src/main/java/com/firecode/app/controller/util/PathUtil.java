package com.firecode.app.controller.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
public class PathUtil {

	@Getter
	@Value("${path.static}")
	private String pathStatic;

	@Getter
	@Value("${path.upload}")
	private String pathUpload;

	@Getter
	@Value("${path.logo}")
	private String pathLogo;

	@Getter
	@Value("${path.avatar.system}")
	private String pathAvatarSystem;

	@Getter
	@Value("${extension.image}")
	private String extensionImage;

	public String localPath() {
		// return System.getProperty("user.dir");
		return getClass().getClassLoader().getResource("").getPath().replace("%20", " ");
	}

}
