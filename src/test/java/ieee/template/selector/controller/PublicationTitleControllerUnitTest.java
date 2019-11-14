package ieee.template.selector.controller;

import ieee.template.selector.model.PublicationTitle;
import ieee.template.selector.service.PublicationTitleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class PublicationTitleControllerUnitTest {

    @Mock
    private PublicationTitleService mockPublicationTitleService;

    @InjectMocks
    private PublicationTitleController mockController;

    @Before
    public void setup() {
        Mockito.when(mockPublicationTitleService.getPublicationTitlesByPublicationTypeId(anyLong()))
                .thenReturn(constructPublicationTitle());
    }

    @Test
    public void testPublicationTitle() throws Exception {
        mockController.getPublicationTitlesByPublicationTypeId(5L);
        verify(mockPublicationTitleService, times(1)).getPublicationTitlesByPublicationTypeId(5L);
    }

    @Test
    public void testPublicationTitleNull() {
        when(mockPublicationTitleService.getPublicationTitlesByPublicationTypeId(anyLong())).thenReturn(null);
        mockController.getPublicationTitlesByPublicationTypeId(5L);
        verify(mockPublicationTitleService, times(1)).getPublicationTitlesByPublicationTypeId(5L);
    }

    private List<PublicationTitle> constructPublicationTitle() {
        PublicationTitle publicationTitle = new PublicationTitle();
        publicationTitle.setId(5L);
        publicationTitle.setName("IEEE Journal of Quantum Electronics");
        publicationTitle.setDescription("Template type to publish new Journal");
        return Arrays.asList(publicationTitle);
    }
}
