package com.learning.spring.transaction.repository;

import com.learning.spring.transaction.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {
}
