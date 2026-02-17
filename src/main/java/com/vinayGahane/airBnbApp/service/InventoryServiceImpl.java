package com.vinayGahane.airBnbApp.service;


import com.vinayGahane.airBnbApp.dto.HotelDto;
import com.vinayGahane.airBnbApp.dto.HotelPriceDto;
import com.vinayGahane.airBnbApp.dto.HotelSearchRequest;
import com.vinayGahane.airBnbApp.entity.Hotel;
import com.vinayGahane.airBnbApp.entity.Inventory;
import com.vinayGahane.airBnbApp.entity.Room;
import com.vinayGahane.airBnbApp.repository.HotelMinPriceRepository;
import com.vinayGahane.airBnbApp.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService{

    private final InventoryRepository inventoryRepository;
    private final ModelMapper modelMapper;
    private final HotelMinPriceRepository hotelMinPriceRepository;

    @Override
    public void initializeRoomForAYear(Room room) {
        LocalDate today = LocalDate.now();
        LocalDate endDate = today.plusYears(1);

        for(; !today.isAfter(endDate);today = today.plusDays(1)){
            Inventory inventory = Inventory.builder()
                    .hotel(room.getHotel())
                    .room(room)
                    .bookedCount(0)
                    .reservedCount(0)
                    .city(room.getHotel().getCity())
                    .date(today)
                    .price(room.getBasePrice())
                    .surgeFactor(BigDecimal.ONE)
                    .totalCount(room.getTotalCount())
                    .closed(false)
                    .build();
            inventoryRepository.save(inventory);
        }

    }

    @Override
    public void deleteAllInventories(Room room) {
        LocalDate today = LocalDate.now();
        inventoryRepository.deleteByRoom(room);
    }

    @Override
    public Page<HotelPriceDto> searchHotels(HotelSearchRequest request) {

        Pageable pageable = PageRequest.of(request.getPage(),request.getSize());

        long dateCount =
                ChronoUnit.DAYS.between(request.getStartDate(), request.getEndDate()) + 1;

        Page<HotelPriceDto> hotelPage = hotelMinPriceRepository.findHotelsWithAvailableInventory(request.getCity(),
                request.getStartDate(),request.getEndDate(),request.getRoomsCount(),dateCount,pageable);

        return hotelPage;
    }
}
