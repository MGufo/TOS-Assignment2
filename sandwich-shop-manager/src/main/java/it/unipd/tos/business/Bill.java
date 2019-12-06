//Marco Rosin 1120673
package it.unipd.tos.business;

import java.util.List;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.itemType;

public class Bill implements TakeAwayBill {

    public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException {
        // TODO Auto-generated method stub

        // Controllo numero elementi nell'ordine
        if (itemsOrdered.size() > 30) {
            throw new TakeAwayBillException("Numero di ordinazioni > 30");
        }
        double totPrice = 0;
        int numPanini = 0;
        double lowestPaninoPrice = Double.MAX_VALUE;

        // Sconto sul prezzo del panino meno caro
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getType() == MenuItem.itemType.Panino) {
                numPanini++;
                if (itemsOrdered.get(i).getPrice() < lowestPaninoPrice) {
                    lowestPaninoPrice = itemsOrdered.get(i).getPrice();
                }
            }
        }

        // Calcolo subtotale Panini
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getType() == MenuItem.itemType.Panino) {
                totPrice += itemsOrdered.get(i).getPrice();
            }
        }
        if(numPanini > 5) {
            totPrice -= lowestPaninoPrice*0.5;
        }
        
        // Aggiunta subtotale Fritti
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getType() == MenuItem.itemType.Fritto) {
                totPrice += itemsOrdered.get(i).getPrice();
            }
        }
        
        // Sconto se costo panini + fritti > 50
        if (totPrice > 50) {
            totPrice -= totPrice * 0.1;
        }
        
        // Aggiunta subtotale bevande
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getType() == MenuItem.itemType.Bevanda) {
                totPrice += itemsOrdered.get(i).getPrice();
            }
        }

        // Sovrapprezzo per ordini < 10€
        if (totPrice < 10) {
            totPrice += 0.5;
        }
    }
}
