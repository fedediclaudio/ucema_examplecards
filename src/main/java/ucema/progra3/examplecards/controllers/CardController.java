package ucema.progra3.examplecards.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ucema.progra3.examplecards.model.Card;
import ucema.progra3.examplecards.services.interfaces.ICardService;
import ucema.progra3.examplecards.services.interfaces.IUserService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/card")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CardController {

    @Autowired
    private ICardService cardService;

    @GetMapping(path = "")
    public List<Card> getMyCards() {
        return this.cardService.getCardOfUser();
    }

}
