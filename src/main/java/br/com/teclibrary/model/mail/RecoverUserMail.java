package br.com.teclibrary.model.mail;

import br.com.teclibrary.handler.util.StringUtils;
import br.com.teclibrary.model.data.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RecoverUserMail implements MailRequest {

    private final User user;

    @Override
    public String templatePath() {
        return "template/mail/recover-user.html";
    }

    @Override
    public String subject() {
        return "Password Recovery";
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
        return List.of(this.getUser().getEmail());
    }
}
