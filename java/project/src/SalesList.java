import Pets.*;

import java.util.ArrayList;
import java.util.List;

class SalesList {
    private List<Sale> allSales = new ArrayList<>();

    public void addSale(Sale sale) {
        allSales.add(sale);
    }

    public Sale getSale(int index) {
        return allSales.get(index);
    }

    public List<Sale> getAllSales() {
        return allSales;
    }

    @Override
    public String toString() {
        return "SalesList{" + "allSales=" + allSales + '}';
    }
}