package com.jana.jpademo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jana.jpademo.common.CommonUtils;
import com.jana.jpademo.common.TemplateConstant;
import com.jana.jpademo.model.FileDownload;
import com.jana.jpademo.model.TemplateType;
import com.jana.jpademo.repository.ArticleTypeRepository;
import com.jana.jpademo.repository.FileDownloadRepository;
import com.jana.jpademo.repository.TemplateNameRepository;
import com.jana.jpademo.repository.TemplateTypeRepository;
import com.jana.jpademo.vo.AuthTemplateVO;
import com.jana.jpademo.vo.ErrMessageVO;

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

	@Autowired
	FileDownloadRepository fileDownloadRepository;

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
		/*
		 * if (!CommonUtils.isNullOrEmpty(publicationTypeID) &&
		 * CommonUtils.isNullOrEmpty(publicationNameID) &&
		 * CommonUtils.isNullOrEmpty(articleTypeID)) { if
		 * (templateTypeRepository.findById(CommonUtils.convertoLong(publicationTypeID))
		 * .get() .getTemplateNameList() != null) {
		 * authTemplateVO.setPublicationName(templateTypeRepository
		 * .findById(CommonUtils.convertoLong(publicationTypeID)).get().
		 * getTemplateNameList()); }
		 * authTemplateVO.setDownload(templateTypeRepository.findById(CommonUtils.
		 * convertoLong(publicationTypeID)) .get().getFileDownloadList()); } else if
		 * (!CommonUtils.isNullOrEmpty(publicationTypeID) &&
		 * !CommonUtils.isNullOrEmpty(publicationNameID) &&
		 * CommonUtils.isNullOrEmpty(articleTypeID)) { if
		 * (templateNameRepository.findById(CommonUtils.convertoLong(publicationNameID))
		 * .get() .getArticleTypeList() != null) {
		 * authTemplateVO.setArticleType(templateNameRepository
		 * .findById(CommonUtils.convertoLong(publicationNameID)).get().
		 * getArticleTypeList()); }
		 * authTemplateVO.setDownload(templateNameRepository.findById(CommonUtils.
		 * convertoLong(publicationNameID)) .get().getFileDownloadList()); } else if
		 * (!CommonUtils.isNullOrEmpty(publicationTypeID) &&
		 * !CommonUtils.isNullOrEmpty(publicationNameID) &&
		 * !CommonUtils.isNullOrEmpty(articleTypeID)) {
		 * authTemplateVO.setDownload(articleTypeRepository.findById(CommonUtils.
		 * convertoLong(articleTypeID)).get() .getFileDownloadList()); }
		 */

		if (!CommonUtils.isNullOrEmpty(templateTypeID)) {
			if (Objects.nonNull(fileDownloadRepository.findByTemplateTypeID(new Long(templateTypeID)))) {
				authTemplateVO.setDownload(getDownloadList(templateTypeID));
			} else {
				authTemplateVO.setTemplateName(
						templateTypeRepository.findById(new Long(templateTypeID)).get().getTemplateNameList());
			}
		} else if (!CommonUtils.isNullOrEmpty(templateNameID)) {
			if (Objects.nonNull(fileDownloadRepository.findByTemplateNameID(new Long(templateNameID)))) {
				authTemplateVO.setDownload(getDownloadList(templateNameID));
			} else {
				authTemplateVO.setArticleType(
						templateNameRepository.findById(new Long(templateNameID)).get().getArticleTypeList());
			}
		} else if (!CommonUtils.isNullOrEmpty(articleTypeID)) {
			if (Objects.nonNull(fileDownloadRepository.findByArticleTypeID(new Long(articleTypeID)))) {
				authTemplateVO.setDownload(getDownloadList(articleTypeID));
			}
		} else {
			System.out.println(TemplateConstant.ErrMsg1);
			ErrMessageVO errMsg = new ErrMessageVO();
			errMsg.setErrMsg(TemplateConstant.ErrMsg1);
			authTemplateVO.setErrMsgDtls(errMsg);
		}
		return authTemplateVO;
	}

	public List<FileDownload> getDownloadList(String id) {
		return templateTypeRepository.findById(new Long(id)).get().getFileDownloadList();
	}

}
