package ieee.template.selector.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import ieee.template.selector.controller.ArticleTypeController;
import ieee.template.selector.model.ArticleType;

@Service
@SpringBootTest
@RunWith(SpringRunner.class)
public class UploadDownloadServiceUnitTest {

	@Mock
	private ArticleTypeService mockArticleTypeService;

	@InjectMocks
	private ArticleTypeController mockController;

	List<ArticleType> list = new ArrayList<>();
	ArticleType articleType = new ArticleType();

	@Before
	public void setup() {
	}

	@Test
	public void testArticleType() throws Exception {
	}
}
