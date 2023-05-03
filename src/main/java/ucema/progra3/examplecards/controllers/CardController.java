package ucema.progra3.examplecards.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/bank")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CardController {
}
