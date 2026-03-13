package com.example.tugas4.service;



import com.example.tugas4.dto.KtpDto;
import com.example.tugas4.entity.KtpEntity;
import java.util.List;

public interface KtpService {
    KtpEntity create(KtpDto dto);
    List<KtpEntity> getAll();
    KtpEntity getById(Integer id);
    KtpEntity update(Integer id, KtpDto dto);
    void delete(Integer id);
}