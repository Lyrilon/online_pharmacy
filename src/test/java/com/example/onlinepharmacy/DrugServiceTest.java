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
}
