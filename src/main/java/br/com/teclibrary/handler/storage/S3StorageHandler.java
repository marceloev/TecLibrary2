package br.com.teclibrary.handler.storage;

import br.com.teclibrary.model.data.enums.FileType;
import br.com.teclibrary.model.data.enums.StorageType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Dependent
public class S3StorageHandler implements StorageHandler {

    @Inject
    S3Client s3Client;

    @ConfigProperty(name = "bucket.name")
    String bucketName;

    @Override
    public StorageType getType() {
        return StorageType.S3;
    }

    @Override
    public byte[] retrieve(final String key) {
        GetObjectRequest request = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        ResponseBytes response = s3Client.getObjectAsBytes(request);
        return Objects.nonNull(response.response()) ? response.asByteArray() : null;
    }

    @Override
    public byte[] save(final String key, final FileType type, final byte[] data) {
        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .contentType(type.getValue())
                .build();

        s3Client.putObject(request, RequestBody.fromFile(uploadToTemp(new ByteArrayInputStream(data))));
        return data;
    }

    @Override
    public byte[] update(final String key, final FileType type, final byte[] data) {
        return null;
    }

    @Override
    public void remove(final String key) {
        DeleteObjectRequest request = DeleteObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        s3Client.deleteObject(request);
    }

    private File uploadToTemp(final InputStream data) {
        File tempPath;
        try {
            tempPath = File.createTempFile("uploadS3Tmp", ".tmp");
            Files.copy(data, tempPath.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return tempPath;
    }
}
