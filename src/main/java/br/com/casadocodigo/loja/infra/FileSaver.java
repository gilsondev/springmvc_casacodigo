package br.com.casadocodigo.loja.infra;

import com.amazonaws.AmazonClientException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.lambda.model.Runtime;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.sun.org.apache.xpath.internal.operations.Mult;
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
        AmazonS3Client s3 = client();
        try {
            s3.putObject("casadocodigo", file.getOriginalFilename(), file.getInputStream(), new ObjectMetadata());
            return "https://s3.amazonaws.com/casadocodigo/" + file.getOriginalFilename();
        } catch (AmazonClientException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private AmazonS3Client client() {
        // Usando S3 Ninja
        AWSCredentials credentials = new BasicAWSCredentials("AKIAIOSFODNN7EXAMPLE", "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY");
        AmazonS3Client newClient = new AmazonS3Client(credentials, new ClientConfiguration());
        newClient.setS3ClientOptions(new S3ClientOptions().withPathStyleAccess(true));

        // Definindo o host do S3 Ninja
        newClient.setEndpoint("http://localhost:9444/s3");
        return newClient;
    }
}
