package tn.esprit.oualhieyaexblanc.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.oualhieyaexblanc.Services.CarteFId.CarteFIDService;

@RestController
@AllArgsConstructor
@RequestMapping("/cartes")
public class CarteFIdController {

    CarteFIDService carteFIDService;

    @PostMapping("/{numCarte}/operations")
    public long effectuerOperation(@PathVariable long numCarte, @RequestParam String typeOperation, @RequestParam int montant) {
        return carteFIDService.effecterOperation(typeOperation, numCarte, montant);
    }
}
