package ieee.template.selector.service;

import ieee.template.selector.model.ArticleType;
import ieee.template.selector.repository.ArticleTypeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ArticleTypeServiceUnitTest {

    @Mock
    private ArticleTypeRepository repository;

    @InjectMocks
    private ArticleTypeService mockService;

    @Before
    public void setup() {
        when(repository.getByPublicationTitleId(5L)).thenReturn(constructArticleType());
    }

    @Test
    public void testArticleTypeService() throws Exception {
        mockService.getArticleTypesByPublicationTitleId(5L);
        verify(repository, times(1)).getByPublicationTitleId(5L);
    }

    @Test
    public void testArticleTypeServiceNull() {
        when(repository.getByPublicationTitleId(anyLong())).thenReturn(null);
        mockService.getArticleTypesByPublicationTitleId(5L);
        Mockito.verify(repository, Mockito.times(1)).getByPublicationTitleId(5L);
    }

    private List<ArticleType> constructArticleType() {
        ArticleType articleType = new ArticleType();
        articleType.setId(3L);
        articleType.setName("Original Research");
        articleType.setStatus("Active");

        return Arrays.asList(articleType);
    }
}
