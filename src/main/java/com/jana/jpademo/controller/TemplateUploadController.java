package com.jana.jpademo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jana.jpademo.common.TemplateConstant;

@RestController
@RequestMapping("/templateUpload")
public class TemplateUploadController {
	private static String UPLOAD_FOLDER = TemplateConstant.file_location;

	@PostMapping
	public ResponseEntity<String> fileUpload(@RequestPart("file") MultipartFile[] file,
			RedirectAttributes redirectAttributes) {
		System.out.println("inside");
		for (MultipartFile uploadedFile : file) {
			if (uploadedFile.isEmpty()) {
				return ResponseEntity.ok(TemplateConstant.ErrMsg1);
			}
			try {
				byte[] bytes = uploadedFile.getBytes();
				Path path = Paths.get(UPLOAD_FOLDER + uploadedFile.getOriginalFilename());
				Files.write(path, bytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ResponseEntity.ok(TemplateConstant.sucMsg);
	}
}
