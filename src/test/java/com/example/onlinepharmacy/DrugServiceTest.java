package com.example.onlinepharmacy;

import com.example.onlinepharmacy.service.DrugService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DrugServiceTest {

    @Test
    public void testSearch() {
        DrugService service = new DrugService();
        service.init();
        assertEquals(1, service.search("Aspirin").size());
    }

    @Test
    public void testAddAndDelete() {
        DrugService service = new DrugService();
        service.init();
        int initial = service.findAll().size();
        service.add(new com.example.onlinepharmacy.model.Drug(null, "Test", "Desc", 1.0));
        assertEquals(initial + 1, service.findAll().size());
        boolean removed = service.delete(4L);
        assertTrue(removed);
        assertEquals(initial, service.findAll().size());
    }
}
