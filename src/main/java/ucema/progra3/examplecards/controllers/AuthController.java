package ucema.progra3.examplecards.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;
import ucema.progra3.examplecards.dto.LoginDTO;
import ucema.progra3.examplecards.model.Role;
import ucema.progra3.examplecards.model.User;
import ucema.progra3.examplecards.services.interfaces.IUserService;

@RestController
@RequestMapping(value = "/api/auth")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AuthController {

    @Autowired
    private IUserService userService;

    @PostMapping(path = "/login")
    public String authenticate(@RequestBody LoginDTO loginDTO) {
        return this.userService.authenticate(loginDTO.getUsername(), loginDTO.getPassword());
    }
}


