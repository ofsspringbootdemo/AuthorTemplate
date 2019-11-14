package ieee.template.selector.service;

import ieee.template.selector.controller.ArticleTypeController;
import ieee.template.selector.model.ArticleType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class TemplateJwtUserDetailsServiceUnitTest {

    @Mock
    private ArticleTypeService mockArticleTypeService;

    @InjectMocks
    private ArticleTypeController mockController;

    List<ArticleType> list = new ArrayList<>();
    ArticleType articleType = new ArticleType();

    @Before
    public void setup() {
        articleType.setId(3L);
        articleType.setName("Original Research");
        list.add(articleType);
        Mockito.when(mockArticleTypeService.getArticleTypesByPublicationTitleId(5L)).thenReturn(list);
    }

    @Test
    public void testArticleType() throws Exception {
        List<ArticleType> articleTypes = mockController.getArticleTypesByPublicationTitleId(5L);
        System.out.println("articleTypes" + articleTypes);
        Mockito.verify(mockArticleTypeService, Mockito.times(1)).getArticleTypesByPublicationTitleId(5L);
    }

}
