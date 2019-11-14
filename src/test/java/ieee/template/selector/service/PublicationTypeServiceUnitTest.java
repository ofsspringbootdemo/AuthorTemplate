package ieee.template.selector.service;

import ieee.template.selector.model.PublicationType;
import ieee.template.selector.repository.PublicationTypeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RunWith(MockitoJUnitRunner.class)
public class PublicationTypeServiceUnitTest {

    @Mock
    private PublicationTypeRepository mockRepository;

    @InjectMocks
    private PublicationTypeService mockService;

    @Before
    public void setup() {
        Mockito.when(mockRepository.findAll()).thenReturn(constructpublicationType());
    }

    @Test
    public void testPublicationTypeFindAll() throws Exception {
        mockService.getAllPublicationType().stream().filter(p -> p.getStatus().equals("Active"))
                .collect(Collectors.toList());
        Mockito.verify(mockRepository, Mockito.times(1)).findAll();
    }

    private List<PublicationType> constructpublicationType() {
        PublicationType publicationType = new PublicationType();
        publicationType.setId(3L);
        publicationType.setName("Transactions, Journals and Letters");
        publicationType.setStatus("Active");
        publicationType.setDescription("Template type to publish new Journal");
        return Arrays.asList(publicationType);
    }

}
