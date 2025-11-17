package com.mockify.backend.repository;

import com.mockify.backend.model.MockRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MockRecordRepository extends JpaRepository<MockRecord, Long> {

    List<MockRecord> findByMockSchema_Id(Long schemaId);

    List<MockRecord> findByMockSchema_IdAndExpiresAtAfter(Long schemaId, LocalDateTime now);

    Optional<MockRecord> findByIdAndMockSchema_Id(Long id, Long schemaId);

    void deleteByExpiresAtBefore(LocalDateTime now);

    void deleteByMockSchema_Id(Long schemaId);

    long count();
}
