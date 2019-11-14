package ieee.template.selector.service;

import ieee.template.selector.model.ArticleType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class UploadDownloadServiceUnitTest {

    @Mock
    private ArticleTypeService mockArticleTypeService;

    @InjectMocks
    private TemplateFileService templateFileService;

    List<ArticleType> list = new ArrayList<>();
    ArticleType articleType = new ArticleType();

    @Before
    public void setup() {
    }

    @Test
    public void testArticleType() throws Exception {
    }
}
