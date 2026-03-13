package com.example.tugas4.service.impl;

import com.example.tugas4.dto.KtpDto;
import com.example.tugas4.entity.KtpEntity;
import com.example.tugas4.repository.KtpRepository;
import com.example.tugas4.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class KtpServiceImpl implements KtpService {

    @Autowired
    private KtpRepository repository;

    @Override
    public KtpEntity create(KtpDto dto) {

        // Validasi field kosong
        if(dto.getNomorKtp() == null || dto.getNomorKtp().isEmpty()) {
            throw new RuntimeException("Nomor KTP tidak boleh kosong");
        }

        if(dto.getNamaLengkap() == null || dto.getNamaLengkap().isEmpty()) {
            throw new RuntimeException("Nama lengkap tidak boleh kosong");
        }

        if(dto.getAlamat() == null || dto.getAlamat().isEmpty()) {
            throw new RuntimeException("Alamat tidak boleh kosong");
        }

        if(dto.getTanggalLahir() == null || dto.getTanggalLahir().isEmpty()) {
            throw new RuntimeException("Tanggal lahir tidak boleh kosong");
        }

        if(dto.getJenisKelamin() == null || dto.getJenisKelamin().isEmpty()) {
            throw new RuntimeException("Jenis kelamin tidak boleh kosong");
        }

        // Validasi nomor KTP unik
        if(repository.existsByNomorKtp(dto.getNomorKtp())) {
            throw new RuntimeException("Nomor KTP sudah terdaftar!");
        }

        KtpEntity entity = new KtpEntity();

        entity.setNomorKtp(dto.getNomorKtp());
        entity.setNamaLengkap(dto.getNamaLengkap());
        entity.setAlamat(dto.getAlamat());

        // Validasi format tanggal
        try {
            entity.setTanggalLahir(LocalDate.parse(dto.getTanggalLahir()));
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Format tanggal salah. Gunakan format YYYY-MM-DD");
        }

        entity.setJenisKelamin(dto.getJenisKelamin());

        return repository.save(entity);
    }

    @Override
    public List<KtpEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public KtpEntity getById(Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data KTP dengan ID " + id + " tidak ditemukan"));
    }

    @Override
    public KtpEntity update(Integer id, KtpDto dto) {

        KtpEntity existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data yang akan diupdate tidak ditemukan"));

        existing.setNamaLengkap(dto.getNamaLengkap());
        existing.setAlamat(dto.getAlamat());

        try {
            existing.setTanggalLahir(LocalDate.parse(dto.getTanggalLahir()));
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Format tanggal salah. Gunakan YYYY-MM-DD");
        }

        existing.setJenisKelamin(dto.getJenisKelamin());

        return repository.save(existing);
    }

    @Override
    public void delete(Integer id) {

        if(!repository.existsById(id)) {
            throw new RuntimeException("Data yang akan dihapus tidak ditemukan");
        }

        repository.deleteById(id);
    }
}