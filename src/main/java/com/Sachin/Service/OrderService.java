package com.Sachin.Service;

import com.Sachin.Model.*;

import java.util.Date;
import java.util.List;

public class OrderService {
    public boolean checkIfCanBeFulfilled(OrderRequest orderRequest, Warehouse warehouse) {

        String warehouseId = orderRequest.getWarehouseId();

        Date date = orderRequest.getDeliveryDate();
        List<WarehouseItem> everyDayItemList = warehouse.getEveryDayItemList().get(date);
        List<CategoryLimit> everyDayCategoryLimitList = warehouse.getEveryDayCategoryLimitList().get(date);
        for(ItemRequest item : orderRequest.getItems()) {
            int availability = 0;
            for(int i = 0; i < everyDayItemList.size(); i++) {
                if(everyDayItemList.get(i).getItem() == item.getItemId()) {
                    availability = everyDayItemList.get(i).getUnits();
                }
            }
            if(availability < item.getQuantity()) {
                return false;
            }

//                int catLimit = 0;
//                String cat = item.getCategory();
//                for(int i = 0; i < everyDayCategoryLimitList.size(); i++) {
//                    if(everyDayCategoryLimitList.get(i).getCategory().equalsIgnoreCase(cat)) {
//                        catLimit = everyDayCategoryLimitList.get(i).getLimit();
//                    }
//                }
//
//            }
        }
        return true;
    }

    public Data getReservedDetails(OrderRequest orderRequest, Warehouse warehouse) {

        Data data = new Data();
        Date date = orderRequest.getDeliveryDate();
        List<WarehouseItem> everyDayItemList = warehouse.getEveryDayItemList().get(date);
        List<CategoryLimit> everyDayCategoryLimitList = warehouse.getEveryDayCategoryLimitList().get(date);
        for (ItemRequest item : orderRequest.getItems()) {
            int availability = 0;
            for (int i = 0; i < everyDayItemList.size(); i++) {
                if (everyDayItemList.get(i).getItem() == item.getItemId()) {
                    availability = everyDayItemList.get(i).getUnits();
                    everyDayItemList.get(i).setUnits(everyDayItemList.get(i).getUnits() - availability);
                }
            }

        }
        data.setMessage("Success");
        data.setReserve(true);
        return data;
    }

    public Warehouse findWarehouse(OrderRequest orderRequest, Model.Restaurant restaurant) {
        int index = 0;
        Warehouse warehouse = null;
        List<Warehouse> warehouseList = restaurant.getWarehouses();
        for(int i=0;i<warehouseList.size();i++)
        {
            if(warehouseList.get(i).getWarehouseId() == orderRequest.getWarehouseId())
            {
                warehouse = warehouseList.get(i);
                break;
            }
        }
        return warehouse;
    }
}
