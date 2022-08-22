package com.learning.spring.transaction.repository;

import com.learning.spring.transaction.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo,Long> {
}
