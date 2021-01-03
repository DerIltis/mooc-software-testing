package tudelft.discount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tudelft.invoicemocked.InvoiceDao;

import java.util.ArrayList;
import java.util.List;

public class DiscountApplierTest {

    @Test
    public void SimpleTest()
    {
        ProductDao dao = Mockito.mock(ProductDao.class);

        List<Product> products = new ArrayList<>();
        products.add(new Product("Foo", 1, "HOME"));
        products.add(new Product("Bar", 1, "BUSINESS"));
        Mockito.when(dao.all()).thenReturn(products);

        DiscountApplier applier = new DiscountApplier(dao);
        applier.setNewPrices();

        Assertions.assertEquals(0.9, products.get(0).getPrice());
        Assertions.assertEquals(1.1, products.get(1).getPrice());
    }

}
