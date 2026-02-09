package com.vinayGahane.airBnbApp.service;

import com.vinayGahane.airBnbApp.entity.Room;

public interface InventoryService {
    void initializeRoomForAYear(Room room);

    void deleteFutureInventories(Room room);
}
