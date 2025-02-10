package com.agus.ramdan.cdm.core.repository;

import com.agus.ramdan.cdm.core.domain.TrxDeposit;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.Optional;
import java.util.UUID;

public interface TrxDepositRepository extends JpaRepositoryImplementation<TrxDeposit, UUID> {
    Optional<TrxDeposit> findByTokenAndSignature(String token, String signature);
}