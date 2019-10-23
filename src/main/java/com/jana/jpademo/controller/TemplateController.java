package com.jana.jpademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jana.jpademo.common.TemplateConstant;
import com.jana.jpademo.model.FileDownload;
import com.jana.jpademo.model.TemplateName;
import com.jana.jpademo.service.ArticleTypeService;
import com.jana.jpademo.service.FileDownloadService;
import com.jana.jpademo.service.TemplateNameService;
import com.jana.jpademo.vo.AuthTemplateVO;
import com.jana.jpademo.vo.ErrMessageVO;

@RestController
@RequestMapping("/template")
public class TemplateController {

	@Autowired
	private TemplateNameService templateNameService;

	@Autowired
	private ArticleTypeService articleTypeService;

	@Autowired
	private FileDownloadService fileDownloadService;

	@PutMapping
	public void updateTemplateName(@RequestBody TemplateName templateName) {
		templateNameService.updateTemplateName(templateName);
	}

	@GetMapping
	public AuthTemplateVO getTemplateDetails(@RequestParam(required = false) String templateTypeID,
			@RequestParam(required = false) String templateNameID,
			@RequestParam(required = false) String articleTypeID) {
		AuthTemplateVO authTemplateVO = new AuthTemplateVO();
		if (!StringUtils.isEmpty(articleTypeID)) {
			authTemplateVO
					.setDownload(fileDownloadService.getFileDownloadsByArticleTypeId(Long.valueOf(articleTypeID)));
		} else if (!StringUtils.isEmpty(templateNameID)) {

			List<FileDownload> fileDownloadaByTemplateName = fileDownloadService
					.getFileDownloadsByTemplateNameId(Long.valueOf(templateNameID));
			if (!fileDownloadaByTemplateName.isEmpty()) {
				authTemplateVO.setDownload(fileDownloadaByTemplateName);
			} else {
				authTemplateVO.setArticleType(
						articleTypeService.getArticleTypesByTemplateNameId(Long.valueOf(templateNameID)));
			}
		} else if (!StringUtils.isEmpty(templateTypeID)) {
			List<FileDownload> fileDownloadaByTemplateType = fileDownloadService
					.getFileDownloadsByTemplateTypeId(Long.valueOf(templateTypeID));
			if (!fileDownloadaByTemplateType.isEmpty()) {
				authTemplateVO.setDownload(fileDownloadaByTemplateType);
			} else {
				authTemplateVO.setTemplateName(
						templateNameService.getTemplateNamesByTemplateTypeId(Long.valueOf(templateTypeID)));
			}
		} else {
			System.out.println(TemplateConstant.ErrMsg1);
			ErrMessageVO errMsg = new ErrMessageVO();
			errMsg.setErrMsg(TemplateConstant.ErrMsg1);
			authTemplateVO.setErrMsgDtls(errMsg);
		}
		return authTemplateVO;
		// return templateTypeService.getAuthTemplate(templateTypeID, templateNameID,
		// articleTypeID);
	}
}
