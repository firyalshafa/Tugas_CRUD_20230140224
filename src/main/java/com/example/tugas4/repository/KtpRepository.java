package com.example.tugas4.repository;


import com.example.tugas4.entity.KtpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KtpRepository extends JpaRepository<KtpEntity, Integer> {
    boolean existsByNomorKtp(String nomorKtp);
}