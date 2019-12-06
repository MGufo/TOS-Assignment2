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
        
    }
}
