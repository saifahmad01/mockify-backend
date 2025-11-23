package com.mockify.backend.service.impl;

import com.mockify.backend.dto.response.record.MockRecordResponse;
import com.mockify.backend.model.MockRecord;
import com.mockify.backend.repository.MockRecordRepository;
import com.mockify.backend.service.PublicMockRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublicMockRecordServiceImpl implements PublicMockRecordService {

    private final MockRecordRepository mockRecordRepository;

    @Override
    public MockRecordResponse getRecordById(Long schemaId, Long recordId) {

    }

    @Override
    public List<MockRecordResponse> getRecordsBySchemaId(Long schemaId) {

        }

    }
}
