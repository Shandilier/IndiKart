package com.Sachin.Model;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Warehouse {
    private String warehouseId;

    private Map<Date, List<WarehouseItem>> everyDayItemList;
    private Map<Date, List<CategoryLimit>> everyDayCategoryLimitList;

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Map<Date, List<WarehouseItem>> getEveryDayItemList() {
        return everyDayItemList;
    }

    public void setEveryDayItemList(Map<Date, List<WarehouseItem>> everyDayItemList) {
        this.everyDayItemList = everyDayItemList;
    }

    public Map<Date, List<CategoryLimit>> getEveryDayCategoryLimitList() {
        return everyDayCategoryLimitList;
    }

    public void setEveryDayCategoryLimitList(Map<Date, List<CategoryLimit>> everyDayCategoryLimitList) {
        this.everyDayCategoryLimitList = everyDayCategoryLimitList;
    }
}