package br.com.teclibrary.model.mail;

import br.com.teclibrary.handler.util.StringUtils;
import br.com.teclibrary.model.data.User;
import lombok.Data;

import java.util.List;

@Data
public class WelcomeUserMail implements MailRequest {

    private final User user;

    @Override
    public String templatePath() {
        return "template/mail/welcome-user.html";
    }

    @Override
    public String subject() {
        return String.format("Welcome, %s!", user.getName());
    }

    @Override
    public String body() {
        return null;
    }

    @Override
    public String htmlBody(StringBuilder body) {
        StringUtils.replaceAll(body, "\\$\\{user.name\\}", user.getName());
        StringUtils.replaceAll(body, "\\$\\{user.activation\\}", user.getActivation());
        return body.toString();
    }

    @Override
    public List<String> to() {
        return List.of(user.getEmail());
    }
}
