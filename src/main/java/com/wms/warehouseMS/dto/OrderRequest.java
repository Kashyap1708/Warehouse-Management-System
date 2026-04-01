package com.wms.warehouseMS.dto;
import java.util.List;
public class OrderRequest {

    private String status;
    private List<OrderItemRequest> items;



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public List<OrderItemRequest> getItems() {
        return items;
    }
    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }
}


