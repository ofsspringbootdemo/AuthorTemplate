package ieee.template.selector.controller;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import ieee.template.selector.TemplateSelectorApplicationTests;
import ieee.template.selector.service.UploadDownloadService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UploadDownloadControllerUnitTest extends TemplateSelectorApplicationTests {

	@Mock
	private UploadDownloadService mockArticleTypeService;

	@InjectMocks
	private UploadDownloadController mockController;

	@Before
	public void setup() throws IOException {
		ResponseEntity response = new ResponseEntity(HttpStatus.ACCEPTED);
		response.ok();
		Mockito.when(mockArticleTypeService.fileDownload(2L)).thenReturn(response);
	}

	@Test
	public void testArticleType() throws Exception {
		ResponseEntity response = mockController.downloadTemplate(2L);
		Mockito.verify(mockArticleTypeService, Mockito.times(1)).fileDownload(2L);
	}
}
