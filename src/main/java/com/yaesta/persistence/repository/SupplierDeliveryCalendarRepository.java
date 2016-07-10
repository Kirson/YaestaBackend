package com.yaesta.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.persistence.entity.Supplier;
import com.yaesta.persistence.entity.SupplierDeliveryCalendar;

public interface SupplierDeliveryCalendarRepository extends JpaRepository<SupplierDeliveryCalendar, Long>{

	public List<SupplierDeliveryCalendar> findBySupplier(Supplier supplier);
}
