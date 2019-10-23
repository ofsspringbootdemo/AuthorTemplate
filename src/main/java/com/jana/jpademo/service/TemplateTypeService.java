package com.jana.jpademo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jana.jpademo.common.TemplateConstant;
import com.jana.jpademo.model.TemplateType;
import com.jana.jpademo.repository.TemplateTypeRepository;

/**
 * Created by Jana on 10/14/2019.
 */
@Service
@Transactional
public class TemplateTypeService {

	@Autowired
	private TemplateTypeRepository templateTypeRepository;

	public void saveOrUpdate(TemplateType templateType, MultipartFile[] file) {
		templateTypeRepository.save(templateType);
		fileUpload(file);
	}

	public Optional<TemplateType> getTemplateTypeById(Long id) {
		return templateTypeRepository.findById(id);
	}

	public List<TemplateType> getAllTemplateType() {
		return templateTypeRepository.findAll();
	}

	public void deleteTemplateType(Long id) {
		templateTypeRepository.deleteById(id);
	}

	private ResponseEntity<String> fileUpload(MultipartFile[] file) {
		for (MultipartFile uploadedFile : file) {
			if (uploadedFile.isEmpty()) {
				return ResponseEntity.ok(TemplateConstant.ErrMsg1);
			}
			try {
				byte[] bytes = uploadedFile.getBytes();
				Path path = Paths.get(TemplateConstant.file_location + uploadedFile.getOriginalFilename());
				Files.write(path, bytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ResponseEntity.ok(TemplateConstant.sucMsg);
	}
}
