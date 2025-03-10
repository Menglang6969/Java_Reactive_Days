package com.java.reactive.exercise;

import com.java.reactive.service.InventoryService;
import com.java.reactive.service.PurchaseOrderService;
import com.java.reactive.service.RevenueService;
import com.java.reactive.utils.PurchaseOrder;
import com.java.reactive.utils.Singleton;
import com.java.reactive.utils.Utils;

public class HotColdExercise {

    public static void main(String[] args) {
        PurchaseOrderService order = new PurchaseOrderService();
        RevenueService revenueService = new RevenueService();
        InventoryService inventoryService = new InventoryService();

        order.getPurchaseOrders().subscribe(revenueService.consumeOrderStreaming());

        order.getPurchaseOrders().subscribe(inventoryService.consumeOrderStreaming());

        revenueService.getRevenue().subscribe(Singleton.subscriber("Revenue"));
        inventoryService.getInventory().subscribe(Singleton.subscriber("Inventory"));

        Utils.delay(60);

    }
}
