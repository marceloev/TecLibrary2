package br.com.teclibrary.handler.mail;

import br.com.teclibrary.model.mail.MailRequest;

public interface MailHandler {
    void send(MailRequest request);
}
