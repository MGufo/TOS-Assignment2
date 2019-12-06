//Marco Rosin 1120673
package it.unipd.tos;

import it.unipd.tos.business.Bill;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BillTest {
    @Test
    public void testBillSum() {
        List<MenuItem> tester_bill = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tester_bill.add(new MenuItem(MenuItem.itemType.Panino, "Vegetariano", 6));
        }
        tester_bill.add(new MenuItem(MenuItem.itemType.Fritto, "Arancini", 10));
        Bill tot_bill = new Bill();
        double tot_price = 0;
        try {
            tot_price = tot_bill.getOrderPrice(tester_bill);
        } catch (TakeAwayBillException error) {
            System.out.println("Errore sul calcolo del prezzo");
        }
        assertEquals(40, tot_price, 1E-100);
    }

    @Test(expected = TakeAwayBillException.class)
    public void testNumItemsException() throws TakeAwayBillException {
        List<MenuItem> tester_bill = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            tester_bill.add(new MenuItem(MenuItem.itemType.Fritto, "Primavera", 6));
        }
        Bill tot_bill = new Bill();
        tot_bill.getOrderPrice(tester_bill);
    }

    @Test
    public void testBillDiscount_MoreThan5Panino() {
        List<MenuItem> tester_bill = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            tester_bill.add(new MenuItem(MenuItem.itemType.Panino, "Fantasia", 6));
        }
        tester_bill.add(new MenuItem(MenuItem.itemType.Panino, "Panino meno caro", 3));
        Bill tot_bill = new Bill();
        double tot_price = 0;
        try {
            tot_price = tot_bill.getOrderPrice(tester_bill);
        } catch (TakeAwayBillException error) {
            System.out.println("Errore sul calcolo del prezzo");
        }
        assertEquals(tot_price, 43.5, 1E-100);
    }

    @Test
    public void testBillDiscount_TotalMoreThan50() {
        List<MenuItem> tester_bill = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tester_bill.add(new MenuItem(MenuItem.itemType.Fritto, "Mozzarelline", 4.5));
        }
        for (int i = 0; i < 5; i++) {
            tester_bill.add(new MenuItem(MenuItem.itemType.Panino, "Maxi", 7));
        }
        Bill tot_bill = new Bill();
        double tot_price = 0;
        try {
            tot_price = tot_bill.getOrderPrice(tester_bill);
        } catch (TakeAwayBillException error) {
            System.out.println("Errore sul calcolo del prezzo");    
        }
        assertEquals(72, tot_price, 1E-100);
    }

    @Test
    public void testCommission() {
        List<MenuItem> tester_bill = new ArrayList<>();
        tester_bill.add(new MenuItem(MenuItem.itemType.Panino, "Panino", 6));
        tester_bill.add(new MenuItem(MenuItem.itemType.Fritto, "Fritto", 1));
        tester_bill.add(new MenuItem(MenuItem.itemType.Bevanda, "Bevanda", 1));

        Bill tot_bill = new Bill();
        double tot_price = 0;
        try {
            tot_price = tot_bill.getOrderPrice(tester_bill);
        } catch (TakeAwayBillException error) {
            System.out.println("Errore sul calcolo del prezzo");
        }
        assertEquals(tot_price, 8.5, 1E-100);
    }

}
