package ieee.template.selector.controller;

import ieee.template.selector.model.PublicationType;
import ieee.template.selector.service.PublicationTypeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PublicationTypeControllerUnitTest {

    @Mock
    private PublicationTypeService publicationTypeService;

    @InjectMocks
    private PublicationTypeController mockController;

    @Before
    public void setup() {
        Mockito.when(publicationTypeService.getAllPublicationType()).thenReturn(constructpublicationType());
    }

    @Test
    public void testPublicationType() throws Exception {
        mockController.getPublicationTypes();
        verify(publicationTypeService, times(1)).getAllPublicationType();
    }

    private List<PublicationType> constructpublicationType() {
        PublicationType publicationType = new PublicationType();
        publicationType.setId(3L);
        publicationType.setName("Transactions, Journals and Letters");
        publicationType.setDescription("Template type to publish new Journal");
        return Arrays.asList(publicationType);
    }
}
