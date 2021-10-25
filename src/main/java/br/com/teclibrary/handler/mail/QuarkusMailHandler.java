package br.com.teclibrary.handler.mail;

import br.com.teclibrary.handler.storage.StorageHandler;
import br.com.teclibrary.handler.util.StringUtils;
import br.com.teclibrary.model.mail.MailRequest;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.Objects;

@Dependent
public class QuarkusMailHandler implements MailHandler {

    @Inject
    Mailer mailer;

    @Inject
    StorageHandler storageHandler;

    @Override
    public void send(final MailRequest request) {
        Mail mail = new Mail();
        mail.setSubject(request.subject());
        mail.setTo(request.to());

        if (Objects.nonNull(request.templatePath())) { //TODO: Add locale
            String htmlTemplate = StringUtils.buildOf(storageHandler.retrieve(request.templatePath()));
            mail.setHtml(request.htmlBody(new StringBuilder(htmlTemplate)));
        } else {
            mail.setHtml(request.body());
        }

        if (Objects.nonNull(request.reply())) {
            request.reply().forEach(mail::addReplyTo);
        }

        if (Objects.nonNull(request.attachment())) {
            mail.setAttachments(request.attachment());
        }

        mailer.send(mail);
    }
}
