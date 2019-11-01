package ieee.template.selector.controller;

import ieee.template.selector.TemplateSelectorApplicationTests;
import ieee.template.selector.model.ArticleType;
import ieee.template.selector.service.ArticleTypeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ArticleTypeControllerUnitTest extends TemplateSelectorApplicationTests {

    @Mock
    private ArticleTypeService mockArticleTypeService;

    @InjectMocks
    private ArticleTypeController mockController;

    @Before
    public void setup() {
        when(mockArticleTypeService.getArticleTypesByPublicationTitleId(anyLong())).thenReturn(constructArticleType());
    }

    @Test
    public void testArticleType() throws Exception {
        mockController.getArticleTypesByPublicationTitleId(5L);
        verify(mockArticleTypeService, times(1)).getArticleTypesByPublicationTitleId(5L);
    }

    @Test
    public void testArticleTypeNull() {
        when(mockArticleTypeService.getArticleTypesByPublicationTitleId(anyLong())).thenReturn(null);
        mockController.getArticleTypesByPublicationTitleId(5L);
        verify(mockArticleTypeService, times(1)).getArticleTypesByPublicationTitleId(5L);
    }

    private List<ArticleType> constructArticleType() {
        ArticleType articleType = new ArticleType();
        articleType.setId(3L);
        articleType.setName("Original Research");
        articleType.setStatus("Active");

        return Arrays.asList(articleType);
    }
}
