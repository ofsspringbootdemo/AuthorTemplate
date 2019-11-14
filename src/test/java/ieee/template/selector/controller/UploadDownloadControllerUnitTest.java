package ieee.template.selector.controller;

import ieee.template.selector.service.UploadDownloadService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;


@RunWith(MockitoJUnitRunner.class)
public class UploadDownloadControllerUnitTest {

    @Mock
    private UploadDownloadService mockService;

    @InjectMocks
    private UploadDownloadController mockUploadDownload;

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Before
    public void setup() throws IOException {
        ResponseEntity response = new ResponseEntity(HttpStatus.ACCEPTED);
        Mockito.when(mockService.fileDownload(5L)).thenReturn(response);
    }

    @Test
    public void testDownloadService() throws Exception {
        mockUploadDownload.downloadTemplate(5L);
        Mockito.verify(mockService, Mockito.times(1)).fileDownload(5L);
    }

}
