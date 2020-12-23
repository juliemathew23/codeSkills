package com.coding;

import com.coding.repository.SupplierARepository;
import com.coding.repository.SupplierBRepository;
import com.coding.service.SupplierService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class SupplierServiceTest {

    @Mock
    private SupplierARepository supplierARepository;

    @Mock
    private SupplierBRepository supplierBRepository;

    @InjectMocks
    private SupplierService supplierService;

    @Before
    public void setUp(){
        supplierARepository = Mockito.mock(SupplierARepository.class);
        supplierBRepository = Mockito.mock(SupplierBRepository.class);
        supplierService = new SupplierService(supplierARepository, supplierBRepository);
    }

    @Test
    public void readSuppliers(){

        assertEquals(0, supplierService.getSuppliers().size());
    }

}
