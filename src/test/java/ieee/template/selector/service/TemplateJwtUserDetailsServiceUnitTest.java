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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import ieee.template.selector.controller.ArticleTypeController;
import ieee.template.selector.model.ArticleType;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
@Service
@SpringBootTest
@RunWith(SpringRunner.class)
public class TemplateJwtUserDetailsServiceUnitTest implements UserDetailsService {

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
		Assert.assertEquals(list, articleTypes);
		Mockito.verify(mockArticleTypeService, Mockito.times(1)).getArticleTypesByPublicationTitleId(5L);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
