package br.com.teclibrary.handler.authentication;

import br.com.teclibrary.model.data.User;
import br.com.teclibrary.model.data.enums.UserRole;

import java.util.HashSet;
import java.util.Set;

public interface AuthenticationHandler {
    Object authenticate(User user);
    User getCurrentUser();

    default Set<String> getRoleHierarchy(UserRole role) {
        Set<String> roles = new HashSet();

        switch (role) {
            case OWNER:
                roles.add(UserRole.OWNER.name());
            case MANAGER:
                roles.add(UserRole.MANAGER.name());
            case EMPLOYEE:
                roles.add(UserRole.EMPLOYEE.name());
            case CUSTOMER:
                roles.add(UserRole.CUSTOMER.name());
            default:
                break;
        }

        return roles;
    }
}
