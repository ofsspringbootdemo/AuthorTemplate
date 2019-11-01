package ieee.template.selector.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ieee.template.selector.TemplateSelectorApplicationTests;
import ieee.template.selector.model.PublicationTitle;
import ieee.template.selector.service.PublicationTitleService;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
@SpringBootTest
@RunWith(SpringRunner.class)
public class PublicationTitleControllerUnitTest extends TemplateSelectorApplicationTests {

	@Mock
	private PublicationTitleService mockPublicationTitleService;

	@InjectMocks
	private PublicationTitleController mockController;

	List<PublicationTitle> list = new ArrayList<>();
	PublicationTitle publicationTitle = new PublicationTitle();

	@Before
	public void setup() {
		publicationTitle.setId(3L);
		publicationTitle.setName("IEEE Journal of Quantum Electronics");
		publicationTitle.setDescription("Template type to publish new Journal");
		list.add(publicationTitle);
		Mockito.when(mockPublicationTitleService.getPublicationTitlesByPublicationTypeId(3L)).thenReturn(list);
	}

	@Test
	public void testArticleType() throws Exception {
		List<PublicationTitle> publicationTitles = mockController.getPublicationTitlesByPublicationTypeId(3L);
		System.out.println("publicationTitles" + publicationTitles);
		Assert.assertEquals(list, publicationTitles);
		Mockito.verify(mockPublicationTitleService, Mockito.times(1)).getPublicationTitlesByPublicationTypeId(3L);
	}
}
