package ieee.template.selector.vo;

import ieee.template.selector.model.ArticleType;
import ieee.template.selector.model.PublicationTitle;
import ieee.template.selector.model.TemplateFile;

import java.util.List;

public class AuthTemplateVO {
    private List<PublicationTitle> templateName;
    private List<ArticleType> articleType;
    private List<TemplateFile> download;
    private ErrMessageVO errMsgDtls;
    private String previousPageUrl;

    public String getPreviousPageUrl() {
        return previousPageUrl;
    }

    public void setPreviousPageUrl(String previousPageUrl) {
        this.previousPageUrl = previousPageUrl;
    }

    public List<PublicationTitle> getTemplateName() {
        return templateName;
    }

    public void setTemplateName(List<PublicationTitle> templateName) {
        this.templateName = templateName;
    }

    public List<ArticleType> getArticleType() {
        return articleType;
    }

    public void setArticleType(List<ArticleType> articleType) {
        this.articleType = articleType;
    }

    public List<TemplateFile> getDownload() {
        return download;
    }

    public void setDownload(List<TemplateFile> download) {
        this.download = download;
    }

    public ErrMessageVO getErrMsgDtls() {
        return errMsgDtls;
    }

    public void setErrMsgDtls(ErrMessageVO errMsgDtls) {
        this.errMsgDtls = errMsgDtls;
    }

}
