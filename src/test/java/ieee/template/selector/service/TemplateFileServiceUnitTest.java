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
import ieee.template.selector.model.TemplateFile;
import ieee.template.selector.repository.TemplateFileRepository;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
@Service
@SpringBootTest
@RunWith(SpringRunner.class)
public class TemplateFileServiceUnitTest extends TemplateSelectorApplicationTests {

	@Mock
	private TemplateFileRepository mockRepository;

	@InjectMocks
	private TemplateFileService mockService;

	List<TemplateFile> list = new ArrayList<>();
	TemplateFile templateFile = new TemplateFile();

	@Before
	public void setup() {
		templateFile.setId(3L);
		templateFile.setFormat("Latex");
		templateFile.setName("Template for Conference.zip");
		templateFile.setStatus("Active");
		list.add(templateFile);
		Mockito.when(mockRepository.getByPublicationTypeId(3L)).thenReturn(list);
	}

	@Test
	public void testArticleType() throws Exception {
		List<TemplateFile> templateFiles = mockService.getTemplateFilesByPublicationTypeId(3L);
		System.out.println("articleTypes" + templateFiles);
		Assert.assertEquals(list, templateFiles);
		Mockito.verify(mockRepository, Mockito.times(1)).getByPublicationTypeId(3L);
	}
}
