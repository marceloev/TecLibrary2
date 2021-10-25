package br.com.teclibrary.model.mail;

import io.quarkus.mailer.Attachment;

import java.util.List;

public interface MailRequest { //TODO: Refactor with clean code.
    String templatePath();
    String subject();
    String body();
    String htmlBody(StringBuilder body);
    List<String> to();

    default List<String> reply() {
        return null;
    }

    default List<Attachment> attachment() {
        return null;
    }

}
