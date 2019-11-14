package ieee.template.selector.service;

import ieee.template.selector.common.TemplateConstant;
import ieee.template.selector.model.TemplateFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class UploadDownloadService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadDownloadService.class);

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private TemplateFileService templateFileService;

    /**
     * Methods to upload the template file.
     *
     * @param files file list to upload
     * @return response as success
     */
    public static ResponseEntity<String> fileUpload(MultipartFile[] files) {
        for (MultipartFile uploadedFile : files) {
            if (uploadedFile.isEmpty()) {
                return ResponseEntity.ok(TemplateConstant.ErrMsg1);
            }
            try {
                byte[] bytes = uploadedFile.getBytes();
                Path path = Paths.get(TemplateConstant.upload_location + uploadedFile.getOriginalFilename());
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ResponseEntity.ok(TemplateConstant.sucMsg);
    }

    /**
     * Methods to download the template files.
     *
     * @param fileId file id to download
     * @return files
     * @throws IOException throws exception if file not available
     */
    public ResponseEntity<?> fileDownload(Long fileId) throws IOException {

        Optional<TemplateFile> templateFile = templateFileService.getTemplateFileById(fileId);
        if (!templateFile.isPresent()) {
            LOGGER.error("Invalid File Id={}", fileId);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request");
        }

        String fileName = templateFile.get().getName();
        MediaType mediaType = getMediaTypeForFileName(this.servletContext, fileName);
        Path path = Paths.get(TemplateConstant.download_location + fileName);
        try {
            byte[] data = Files.readAllBytes(path);
            ByteArrayResource resource = new ByteArrayResource(data);
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
                    .contentType(mediaType).contentLength(data.length).body(resource);
        } catch (IOException e) {
            LOGGER.error("Template File Not found ", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found");
        }
    }

    private MediaType getMediaTypeForFileName(ServletContext servletContext, String fileName) {
        String mineType = servletContext.getMimeType(fileName);
        try {
            MediaType mediaType = MediaType.parseMediaType(mineType);
            return mediaType;
        } catch (Exception e) {
            return MediaType.APPLICATION_OCTET_STREAM;
        }
    }
}
