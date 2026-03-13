package com.example.tugas4.controller;



import com.example.tugas4.dto.KtpDto;
import com.example.tugas4.entity.KtpEntity;
import com.example.tugas4.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ktp")
@CrossOrigin(origins = "*") // Supaya bisa diakses dari file HTML (Frontend)
public class KtpController {

    @Autowired
    private KtpService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody KtpDto dto) {
        try {
            return ResponseEntity.ok(service.create(dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<KtpEntity> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public KtpEntity getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public KtpEntity update(@PathVariable Integer id, @RequestBody KtpDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "Data berhasil dihapus";
    }
}