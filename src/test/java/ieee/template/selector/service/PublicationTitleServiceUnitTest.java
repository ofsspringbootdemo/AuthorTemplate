package ieee.template.selector.service;

import ieee.template.selector.model.PublicationTitle;
import ieee.template.selector.repository.PublicationTitleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class PublicationTitleServiceUnitTest {

    @Mock
    private PublicationTitleRepository mockRepository;

    @InjectMocks
    private PublicationTitleService mockService;

    @Before
    public void setup() {
        when(mockRepository.getByPublicationTypeId(anyLong())).thenReturn(constructPublicationTitle());
    }

    @Test
    public void testPublicationTitle() throws Exception {
        mockService.getPublicationTitlesByPublicationTypeId(5L);
        verify(mockRepository, times(1)).getByPublicationTypeId(5L);
    }

    @Test
    public void testPublicationTitleNull() {
        when(mockRepository.getByPublicationTypeId(anyLong())).thenReturn(null);
        mockService.getPublicationTitlesByPublicationTypeId(5L);
        verify(mockRepository, times(1)).getByPublicationTypeId(5L);
    }

    private List<PublicationTitle> constructPublicationTitle() {
        PublicationTitle publicationTitle = new PublicationTitle();
        publicationTitle.setId(5L);
        publicationTitle.setName("IEEE Journal of Quantum Electronics");
        publicationTitle.setDescription("Template type to publish new Journal");
        return Arrays.asList(publicationTitle);
    }
}
