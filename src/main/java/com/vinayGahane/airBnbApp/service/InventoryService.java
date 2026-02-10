package com.vinayGahane.airBnbApp.service;

import com.vinayGahane.airBnbApp.dto.HotelDto;
import com.vinayGahane.airBnbApp.dto.HotelSearchRequest;
import com.vinayGahane.airBnbApp.entity.Room;
import org.jspecify.annotations.Nullable;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InventoryService {
    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelDto> searchHotels(HotelSearchRequest request);
}
