package com.tarea.services;

import com.tarea.model.DB;
import com.tarea.model.Usuario;
import java.util.Collection;
import com.tarea.exception.LoginException;
import javax.servlet.http.HttpSession;

public class LoginService {

    public void login(String email, String password, HttpSession session) throws LoginException {

        Collection<Usuario> usuario = DB.getUsuario();
        Usuario userFound = null;
        for (Usuario u : usuario) {
            if (u.getEmail().equals(email)) {
                userFound = u;
                break;
            }
        }

        if (userFound == null) {
            throw new LoginException("The user not exist. Please register");
        } else {
            if (userFound.getPassword().equals(password)) {
                session.setAttribute("user", userFound);
            } else {
                throw new LoginException("Wrong password");
            }
        }

    }//fin login

    public void logout(HttpSession session) {
        session.invalidate();
    }

    public void setAttribute() {
    }

}
