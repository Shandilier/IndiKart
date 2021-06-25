package Model;

import com.Sachin.Model.Warehouse;

import java.util.List;

public class Restaurant {
    private List<Warehouse> warehouses;

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }
}
