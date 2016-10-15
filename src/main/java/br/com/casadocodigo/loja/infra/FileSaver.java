package br.com.casadocodigo.loja.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Responsavel pela persistencia de arquivos
 * no filesystem do servidor.
 */
@Component
public class FileSaver {
    @Autowired
    private HttpServletRequest request;

    public String write(String baseFolder, MultipartFile file) {
        String realPath = request.getServletContext().getRealPath("/" + baseFolder);

        try {
            String path = realPath + "/" + file.getOriginalFilename();
            File filePath = new File(path);
            filePath.mkdir();
            file.transferTo(filePath);
            return baseFolder + "/" + file.getOriginalFilename();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
