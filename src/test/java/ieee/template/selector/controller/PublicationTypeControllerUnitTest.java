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
import ieee.template.selector.model.PublicationType;
import ieee.template.selector.service.PublicationTypeService;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
@SpringBootTest
@RunWith(SpringRunner.class)
public class PublicationTypeControllerUnitTest extends TemplateSelectorApplicationTests {

	@Mock
	private PublicationTypeService publicationTypeService;

	@InjectMocks
	private PublicationTypeController mockController;

	List<PublicationType> list = new ArrayList<>();
	PublicationType publicationType = new PublicationType();

	@Before
	public void setup() {
		publicationType.setId(3L);
		publicationType.setName("Transactions, Journals and Letters");
		publicationType.setDescription("Template type to publish new Journal");
		list.add(publicationType);
		Mockito.when(publicationTypeService.getAllPublicationType()).thenReturn(list);
	}

	@Test
	public void testArticleType() throws Exception {
		List<PublicationType> publicationTypes = mockController.getPublicationTypes();
		System.out.println("publicationTypes" + publicationTypes);
		Assert.assertEquals(list, publicationTypes);
		Mockito.verify(publicationTypeService, Mockito.times(1)).getAllPublicationType();
	}
}
