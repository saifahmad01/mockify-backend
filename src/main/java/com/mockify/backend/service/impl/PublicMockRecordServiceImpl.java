package com.mockify.backend.service.impl;

import com.mockify.backend.dto.response.record.MockRecordResponse;
import com.mockify.backend.model.MockRecord;
import com.mockify.backend.repository.MockRecordRepository;
import com.mockify.backend.service.PublicMockRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublicMockRecordServiceImpl implements PublicMockRecordService {

    private final MockRecordRepository mockRecordRepository;

    @Override
    public MockRecordResponse getRecordById(Long schemaId, Long recordId) {
        MockRecord record = mockRecordRepository
                .findByIdAndMockSchema_Id(recordId, schemaId)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        return convertToResponse(record);
    }

    @Override
    public List<MockRecordResponse> getRecordsBySchemaId(Long schemaId) {
        List<MockRecord> records =
                mockRecordRepository.findByMockSchema_IdAndExpiresAtAfter(
                        schemaId,
                        LocalDateTime.now()
                );

        return records.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    // Convert Entity → DTO
    private MockRecordResponse convertToResponse(MockRecord record) {
        return new MockRecordResponse(
                record.getId(),
                record.getMockSchema().getId(),
                record.getData(),
                record.getCreatedAt(),
                record.getExpiresAt()
        );
    }
}
