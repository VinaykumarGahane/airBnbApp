package com.vinayGahane.airBnbApp.controller;

import com.vinayGahane.airBnbApp.dto.HotelDto;
import com.vinayGahane.airBnbApp.dto.HotelInfoDto;
import com.vinayGahane.airBnbApp.dto.HotelSearchRequest;
import com.vinayGahane.airBnbApp.service.HotelService;
import com.vinayGahane.airBnbApp.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/hotels")
public class HotelBrowseController {

    private final InventoryService inventoryService;

    private final HotelService hotelService;

    @GetMapping("/search")
    public ResponseEntity<Page<HotelDto>> searchHotels(@RequestBody HotelSearchRequest request){
        return ResponseEntity.ok(inventoryService.searchHotels(request));
    }

    @GetMapping("/{hotelId}/info")
    public  ResponseEntity<HotelInfoDto> getHotelInfo(@PathVariable Long hotelId){
        return ResponseEntity.ok(hotelService.getHotelInfoById(hotelId));

    }


}
