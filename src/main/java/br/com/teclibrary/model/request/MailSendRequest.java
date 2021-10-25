package br.com.teclibrary.model.request;

import io.quarkus.mailer.Attachment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MailSendRequest {
    private String from = "TecLibrary App";
    private String subject;
    private String body;
    private List<String> to;
    private List<String> reply;
    private List<Attachment> attachment;
}
