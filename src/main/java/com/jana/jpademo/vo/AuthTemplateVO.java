package com.jana.jpademo.vo;

import java.util.List;

import com.jana.jpademo.model.ArticleType;
import com.jana.jpademo.model.FileDownload;
import com.jana.jpademo.model.TemplateName;

public class AuthTemplateVO {
	private List<TemplateName> templateName;
	private List<ArticleType> articleType;
	private List<FileDownload> download;
	private ErrMessageVO errMsgDtls;

	public List<TemplateName> getTemplateName() {
		return templateName;
	}

	public void setTemplateName(List<TemplateName> templateName) {
		this.templateName = templateName;
	}

	public List<ArticleType> getArticleType() {
		return articleType;
	}

	public void setArticleType(List<ArticleType> articleType) {
		this.articleType = articleType;
	}

	public List<FileDownload> getDownload() {
		return download;
	}

	public void setDownload(List<FileDownload> download) {
		this.download = download;
	}

	public ErrMessageVO getErrMsgDtls() {
		return errMsgDtls;
	}

	public void setErrMsgDtls(ErrMessageVO errMsgDtls) {
		this.errMsgDtls = errMsgDtls;
	}

}