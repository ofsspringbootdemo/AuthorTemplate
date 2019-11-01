package ieee.template.selector.controller;

import ieee.template.selector.service.UploadDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/publication/download")
public class UploadDownloadController {

    @Autowired
    private UploadDownloadService downloadService;

    @GetMapping("/{fileId}")
    public ResponseEntity<?> downloadTemplate(@PathVariable("fileId") Long fileId) throws IOException {
        return downloadService.fileDownload(fileId);
    }
}
