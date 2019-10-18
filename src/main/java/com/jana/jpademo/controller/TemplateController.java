package com.jana.jpademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jana.jpademo.model.ArticleType;
import com.jana.jpademo.model.FileDownload;
import com.jana.jpademo.model.TemplateName;
import com.jana.jpademo.service.ArticleTypeService;
import com.jana.jpademo.service.FileDownloadService;
import com.jana.jpademo.service.TemplateNameService;
import com.jana.jpademo.service.TemplateTypeService;
import com.jana.jpademo.vo.AuthTemplateVO;

@RestController
@RequestMapping("/template")
public class TemplateController {

	@Autowired
	private TemplateTypeService templateTypeService;

	@Autowired
	private TemplateNameService templateNameService;

	@Autowired
	private ArticleTypeService articleTypeService;

	@Autowired
	private FileDownloadService fileDownloadService;

	@GetMapping
	public AuthTemplateVO getTemplateDetails(@RequestParam(required = false) String templateTypeID,
			@RequestParam(required = false) String templateNameID,
			@RequestParam(required = false) String articleTypeID) {
		return templateTypeService.getAuthTemplate(templateTypeID, templateNameID, articleTypeID);

	}

	// These needs to be remove
	@GetMapping("/getTemplateByTemplateType")
	public List<TemplateName> getTemplateNamesByTemplateTypeId(@RequestParam("templateTypeID") String templateTypeID) {
		return templateNameService.getTemplateNamesByTemplateTypeId(Long.valueOf(templateTypeID));
	}

	@GetMapping("/getTemplateByTemplateName")
	public List<ArticleType> getArticleTypesByTemplateNameId(@RequestParam("templateNameID") String templateNameID) {
		return articleTypeService.getArticleTypesByTemplateNameId(Long.valueOf(templateNameID));
	}

	@GetMapping("/getFileDownloadByTemplateType")
	public List<FileDownload> getFileDownloadsByTemplateTypeId(@RequestParam("id") String id) {
		return fileDownloadService.getFileDownloadsByTemplateTypeId(Long.valueOf(id));
	}

	@GetMapping("/getFileDownloadByTemplateName")
	public List<FileDownload> getFileDownloadsByTemplateNameId(@RequestParam("id") String id) {
		return fileDownloadService.getFileDownloadsByTemplateNameId(Long.valueOf(id));
	}

	@GetMapping("/getFileDownloadByArticleType")
	public List<FileDownload> getFileDownloadsByArticleTypeId(@RequestParam("id") String id) {
		return fileDownloadService.getFileDownloadsByArticleTypeId(Long.valueOf(id));
	}
	// These needs to be remove
}
