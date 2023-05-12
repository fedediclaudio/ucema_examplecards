package ucema.progra3.examplecards.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {

    @GetMapping(path = "/authenticatedinfo")
    public Authentication info() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

}
