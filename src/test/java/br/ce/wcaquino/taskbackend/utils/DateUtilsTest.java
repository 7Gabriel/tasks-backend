package br.ce.wcaquino.taskbackend.utils;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class DateUtilsTest extends TestCase {

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    @Test
    public void testIsFutureDate() {
        // Teste para a data futura
        LocalDate futureDate = LocalDate.of(2023, 6, 1);
        assertTrue(DateUtils.isEqualOrFutureDate(futureDate));

    }

    @Test
    public void testIsEqualDate() {
        // Teste para a data atual
        LocalDate currentDate = LocalDate.now();
        assertTrue(DateUtils.isEqualOrFutureDate(currentDate));

    }

    @Test
    public void testIsPastDate() {
        // Teste para a data passada
        LocalDate pastDate = LocalDate.of(2023, 4, 1);
        assertFalse(DateUtils.isEqualOrFutureDate(pastDate));

    }
}