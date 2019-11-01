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
import ieee.template.selector.model.PublicationTitle;
import ieee.template.selector.repository.PublicationTitleRepository;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
@Service
@SpringBootTest
@RunWith(SpringRunner.class)
public class PublicationTitleServiceUnitTest extends TemplateSelectorApplicationTests {

	@Mock
	private PublicationTitleRepository mockRepository;

	@InjectMocks
	private PublicationTitleService mockService;

	List<PublicationTitle> list = new ArrayList<>();
	PublicationTitle publicationTitle = new PublicationTitle();

	@Before
	public void setup() {
		publicationTitle.setId(3L);
		publicationTitle.setName("IEEE Journal of Quantum Electronics");
		publicationTitle.setDescription("Template type to publish new Journal");
		list.add(publicationTitle);
		Mockito.when(mockRepository.getByPublicationTypeId(3L)).thenReturn(list);
	}

	@Test
	public void testArticleType() throws Exception {
		List<PublicationTitle> publicationTitles = mockService.getPublicationTitlesByPublicationTypeId(3L);
		System.out.println("publicationTitles" + publicationTitles);
		Assert.assertEquals(list, publicationTitles);
		Mockito.verify(mockRepository, Mockito.times(1)).getByPublicationTypeId(3L);
	}
}
