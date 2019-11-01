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
import ieee.template.selector.model.TemplateFile;
import ieee.template.selector.service.TemplateFileService;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
@SpringBootTest
@RunWith(SpringRunner.class)
public class TemplateFileControllerUnitTest extends TemplateSelectorApplicationTests {

	@Mock
	private TemplateFileService templateFileService;

	@InjectMocks
	private TemplateFileController mockController;

	List<TemplateFile> list = new ArrayList<>();
	TemplateFile templateFile = new TemplateFile();

	@Before
	public void setup() {
		templateFile.setId(3L);
		templateFile.setFormat("Latex");
		templateFile.setName("Template for Conference.zip");
		templateFile.setStatus("Active");
		list.add(templateFile);
		Mockito.when(templateFileService.getTemplateFilesByPublicationTypeId(2L)).thenReturn(list);
	}

	@Test
	public void testArticleType() throws Exception {
		List<TemplateFile> templateFiles = mockController.getTemplateFiles(2L);
		System.out.println("articleTypes" + templateFiles);
		Assert.assertEquals(list, templateFiles);
		Mockito.verify(templateFileService, Mockito.times(1)).getTemplateFilesByPublicationTypeId(2L);
	}
}
