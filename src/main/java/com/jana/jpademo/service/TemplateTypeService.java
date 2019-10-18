package com.jana.jpademo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jana.jpademo.common.TemplateConstant;
import com.jana.jpademo.model.FileDownload;
import com.jana.jpademo.model.TemplateType;
import com.jana.jpademo.repository.TemplateTypeRepository;
import com.jana.jpademo.vo.AuthTemplateVO;
import com.jana.jpademo.vo.ErrMessageVO;

/**
 * Created by Jana on 10/14/2019.
 */
@Service
public class TemplateTypeService {

	@Autowired
	private TemplateNameService templateNameService;

	@Autowired
	private ArticleTypeService articleTypeService;

	@Autowired
	private TemplateTypeRepository templateTypeRepository;

	@Autowired
	private FileDownloadService fileDownloadService;

	public void saveOrUpdate(TemplateType templateType) {
		templateTypeRepository.save(templateType);
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

	public AuthTemplateVO getAuthTemplate(String templateTypeID, String templateNameID, String articleTypeID) {
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
	}

}
