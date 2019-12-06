//Marco Rosin 1120673
package it.unipd.tos;

import org.junit.Test;
import static org.junit.Assert.*;
import it.unipd.tos.model.MenuItem;

public class MenuItemTest {
    @Test
    public void testGetType() {
        MenuItem item = new MenuItem(MenuItem.itemType.Panino, "Vegetariano", 7.50);
        assertEquals(item.getType(), MenuItem.itemType.Panino);
    }

    @Test
    public void testGetName() {
        MenuItem item = new MenuItem(MenuItem.itemType.Fritto, "Arancini", 5.50);
        assertEquals(item.getName(), "Arancini");
    }

    @Test
    public void testGetPrice() {
        MenuItem item = new MenuItem(MenuItem.itemType.Bevanda, "Fanta", 2.50);
        assertEquals(item.getPrice(), 2.50, 1E-10);
    }
}