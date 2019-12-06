//Marco Rosin 1120673
package it.unipd.tos;

import static org.junit.Assert.*;
import it.unipd.tos.business.exception.TakeAwayBillException;

import org.junit.Test;

public class TakeAwayBillExceptionTest {

    @Test
    public void testGetMsg(){
        TakeAwayBillException exception = new TakeAwayBillException("Test");
        assertEquals(exception.getMessage(), "Test");
    }

}
