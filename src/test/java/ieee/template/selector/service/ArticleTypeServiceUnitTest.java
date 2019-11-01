package ieee.template.selector.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import ieee.template.selector.TemplateSelectorApplicationTests;
import ieee.template.selector.model.ArticleType;
import ieee.template.selector.repository.ArticleTypeRepository;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
@Service
@SpringBootTest
@RunWith(SpringRunner.class)
public class ArticleTypeServiceUnitTest extends TemplateSelectorApplicationTests {

	@Mock
	private ArticleTypeRepository repository;

	@InjectMocks
	private ArticleTypeService mockService;

	List<ArticleType> list = new ArrayList<>();
	ArticleType articleType = new ArticleType();

	@Before
	public void setup() {
		articleType.setId(3L);
		articleType.setName("Original Research");
		list.add(articleType);
		Mockito.when(repository.getByPublicationTitleId(5L)).thenReturn(list);
	}

	@Test
	public void testArticleType() throws Exception {
		List<ArticleType> articleTypes = mockService.getArticleTypesByPublicationTitleId(5L);
		System.out.println("articleTypes" + articleTypes);
		Assert.assertEquals(list, articleTypes);
		Mockito.verify(repository, Mockito.times(1)).getByPublicationTitleId(5L);
	}
}
