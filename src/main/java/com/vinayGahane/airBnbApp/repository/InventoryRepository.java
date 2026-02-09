package com.vinayGahane.airBnbApp.repository;

import com.vinayGahane.airBnbApp.entity.Inventory;
import com.vinayGahane.airBnbApp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    void deleteByDateAfterAndRoom(LocalDate today, Room room);
}
