package com.jana.jpademo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jana.jpademo.common.CommonUtils;
import com.jana.jpademo.model.TemplateType;
import com.jana.jpademo.repository.ArticleTypeRepository;
import com.jana.jpademo.repository.TemplateNameRepository;
import com.jana.jpademo.repository.TemplateTypeRepository;
import com.jana.jpademo.vo.AuthTemplateVO;

/**
 * Created by Jana on 10/14/2019.
 */
@Service
public class TemplateTypeService {

	@Autowired
	TemplateTypeRepository templateTypeRepository;

	@Autowired
	TemplateNameRepository templateNameRepository;

	@Autowired
	ArticleTypeRepository articleTypeRepository;

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

	public AuthTemplateVO getAuthTemplate(String publicationTypeID, String publicationNameID, String articleTypeID) {
		AuthTemplateVO authTemplateVO = new AuthTemplateVO();
		if (!CommonUtils.isNullOrEmpty(publicationTypeID) && CommonUtils.isNullOrEmpty(publicationNameID)
				&& CommonUtils.isNullOrEmpty(articleTypeID)) {
			if (templateTypeRepository.findById(CommonUtils.convertoLong(publicationTypeID)).get()
					.getTemplateNameList() != null) {
				authTemplateVO.setPublicationName(templateTypeRepository
						.findById(CommonUtils.convertoLong(publicationTypeID)).get().getTemplateNameList());
			}
			authTemplateVO.setDownload(templateTypeRepository.findById(CommonUtils.convertoLong(publicationTypeID))
					.get().getFileDownloadList());
		} else if (!CommonUtils.isNullOrEmpty(publicationTypeID) && !CommonUtils.isNullOrEmpty(publicationNameID)
				&& CommonUtils.isNullOrEmpty(articleTypeID)) {
			if (templateNameRepository.findById(CommonUtils.convertoLong(publicationNameID)).get()
					.getArticleTypeList() != null) {
				authTemplateVO.setArticleType(templateNameRepository
						.findById(CommonUtils.convertoLong(publicationNameID)).get().getArticleTypeList());
			}
			authTemplateVO.setDownload(templateNameRepository.findById(CommonUtils.convertoLong(publicationNameID))
					.get().getFileDownloadList());
		} else if (!CommonUtils.isNullOrEmpty(publicationTypeID) && !CommonUtils.isNullOrEmpty(publicationNameID)
				&& !CommonUtils.isNullOrEmpty(articleTypeID)) {
			authTemplateVO.setDownload(articleTypeRepository.findById(CommonUtils.convertoLong(articleTypeID)).get()
					.getFileDownloadList());
		}
		return authTemplateVO;
	}
}
