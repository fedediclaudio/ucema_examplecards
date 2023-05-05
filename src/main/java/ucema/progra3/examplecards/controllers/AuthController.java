package ucema.progra3.examplecards.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;
import ucema.progra3.examplecards.model.Role;
import ucema.progra3.examplecards.model.User;
import ucema.progra3.examplecards.services.interfaces.IUserService;

@RestController
@RequestMapping(value = "/api/auth")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AuthController {

    @Autowired
    private IUserService userService;

    @GetMapping(path = "/init")
    public String init() {
        try {
            Role admin = new Role("ADMIN");
            Role other = new Role("USER");
            this.userService.createRole(admin);
            this.userService.createRole(other);
            this.userService.createUser(new User("useradmin", "pass123", admin));
            this.userService.createUser(new User("userother", "pass123", other));

        } catch (Exception e) {
            return e.getMessage();
        }
        return "OK";
    }
}
