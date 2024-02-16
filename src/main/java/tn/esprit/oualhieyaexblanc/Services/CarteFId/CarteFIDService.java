package tn.esprit.oualhieyaexblanc.Services.CarteFId;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.oualhieyaexblanc.DAO.Entities.CarteFId;
import tn.esprit.oualhieyaexblanc.DAO.Repository.CarteFIdRepository;

@Service
@AllArgsConstructor
public class CarteFIDService implements ICarteFIdService {
    CarteFIdRepository carteFIdRepository;
    @Override
    public long effecterOperation(String typeOperation, long numCarte, int montant) {
        CarteFId carteFId = carteFIdRepository.findByNumeroCarte(numCarte);

        if ("+".equals(typeOperation)) {
            carteFId.setSolde(carteFId.getSolde() + montant);
        }else if("-".equals(typeOperation)){
            carteFId.setSolde(carteFId.getSolde() -  montant);
        }else {
            return 0;
        }
        carteFIdRepository.save(carteFId);;
        return carteFId.getSolde();
    }

}
