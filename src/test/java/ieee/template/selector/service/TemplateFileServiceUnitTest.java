package ieee.template.selector.service;

import ieee.template.selector.model.TemplateFile;
import ieee.template.selector.repository.TemplateFileRepository;
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
public class TemplateFileServiceUnitTest {

    @Mock
    private TemplateFileRepository mockRepository;

    @InjectMocks
    private TemplateFileService mockService;

    @Before
    public void setup() {
        Mockito.when(mockRepository.getByPublicationTypeId(5L)).thenReturn(constructTemplateFile());
        Mockito.when(mockRepository.getByArticleTypeId(5L)).thenReturn(constructTemplateFile());
        Mockito.when(mockRepository.getByPublicationTitleId(5L)).thenReturn(constructTemplateFile());
    }

    @Test
    public void testTemplateFileByArticleType() throws Exception {
        mockService.getTemplateFilesByArticleTypeId(5L);
        verify(mockRepository, times(1)).getByArticleTypeId(5L);
    }

    @Test
    public void testTemplateFileByArticleTypeNull() {
        Mockito.when(mockRepository.getByArticleTypeId(5L)).thenReturn(null);
        mockService.getTemplateFilesByArticleTypeId(5L);
        verify(mockRepository, times(1)).getByArticleTypeId(5L);
    }

    @Test
    public void testTemplateFileByPublicationTitle() throws Exception {
        mockService.getTemplateFilesByPublicationTitleId(5L);
        verify(mockRepository, times(1)).getByPublicationTitleId(5L);
    }

    @Test
    public void testTemplateFileByPublicationTitleNull() {
        Mockito.when(mockRepository.getByPublicationTitleId(5L)).thenReturn(null);
        mockService.getTemplateFilesByPublicationTitleId(5L);
        verify(mockRepository, times(1)).getByPublicationTitleId(5L);
    }

    @Test
    public void testTemplateFileByPublicationType() throws Exception {
        mockService.getTemplateFilesByPublicationTypeId(5L);
        verify(mockRepository, times(1)).getByPublicationTypeId(5L);
    }

    @Test
    public void testTemplateFileByPublicationTypeNull() {
        Mockito.when(mockRepository.getByPublicationTypeId(5L)).thenReturn(null);
        mockService.getTemplateFilesByPublicationTypeId(5L);
        verify(mockRepository, times(1)).getByPublicationTypeId(5L);
    }

    private List<TemplateFile> constructTemplateFile() {
        TemplateFile templateFile = new TemplateFile();
        templateFile.setId(3L);
        templateFile.setFormat("Latex");
        templateFile.setName("Template for Conference.zip");
        templateFile.setStatus("Active");
        return Arrays.asList(templateFile);
    }
}
