package ieee.template.selector.controller;

import ieee.template.selector.model.TemplateFile;
import ieee.template.selector.service.TemplateFileService;
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
public class TemplateFileControllerUnitTest {

    @Mock
    private TemplateFileService templateFileService;

    @InjectMocks
    private TemplateFileController mockController;

    @Before
    public void setup() {
        Mockito.when(templateFileService.getTemplateFilesByArticleTypeId(5L)).thenReturn(constructTemplateFile());
        Mockito.when(templateFileService.getTemplateFilesByPublicationTitleId(5L)).thenReturn(constructTemplateFile());
        Mockito.when(templateFileService.getTemplateFilesByPublicationTypeId(5L)).thenReturn(constructTemplateFile());
    }

    @Test
    public void testTemplateFileByArticleType() throws Exception {
        mockController.getTemplateFiles(1L, 2L, 5L);
        verify(templateFileService, times(1)).getTemplateFilesByArticleTypeId(5L);
    }

    @Test
    public void testTemplateFileByArticleTypeNull() {
        Mockito.when(templateFileService.getTemplateFilesByArticleTypeId(5L)).thenReturn(null);
        mockController.getTemplateFiles(1L, 2L, 5L);
        verify(templateFileService, times(1)).getTemplateFilesByArticleTypeId(5L);
    }

    @Test
    public void testTemplateFileByPublicationTitle() throws Exception {
        mockController.getTemplateFiles(1L, 5L);
        verify(templateFileService, times(1)).getTemplateFilesByPublicationTitleId(5L);
    }

    @Test
    public void testTemplateFileByPublicationTitleNull() {
        Mockito.when(templateFileService.getTemplateFilesByPublicationTitleId(5L)).thenReturn(null);
        mockController.getTemplateFiles(1L, 5L);
        verify(templateFileService, times(1)).getTemplateFilesByPublicationTitleId(5L);
    }

    @Test
    public void testTemplateFileByPublicationType() throws Exception {
        mockController.getTemplateFiles(5L);
        verify(templateFileService, times(1)).getTemplateFilesByPublicationTypeId(5L);
    }

    @Test
    public void testTemplateFileByPublicationTypeNull() {
        Mockito.when(templateFileService.getTemplateFilesByPublicationTypeId(5L)).thenReturn(null);
        mockController.getTemplateFiles(5L);
        verify(templateFileService, times(1)).getTemplateFilesByPublicationTypeId(5L);
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
