//Marco Rosin 1120673
package it.unipd.tos.business;

import java.util.List;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.itemType;

public class Bill implements TakeAwayBill {

    public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException {
        // TODO Auto-generated method stub
        
        //Controllo numero elementi nell'ordine
        if(itemsOrdered.size()>30) {
            throw new TakeAwayBillException("Numero di ordinazioni > 30");
        }
        double totPrice = 0;
        

        //Sconto se costo panini + fritti > 50
        if(totPrice > 50) {
            totPrice -= totPrice*0.1;
        }
        
        //Sovrapprezzo per ordini < 10€
        if(totPrice < 10) {
            totPrice += 0.5;
        }
    }
}
