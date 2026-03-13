

## Tugas: Sistem Manajemen Data KTP (CRUD)

**NIM:** 20230140224

**Framework:** Spring Boot & MySQL

**Frontend:** HTML, CSS, JavaScript (JQuery Ajax)

---

## 1. Deskripsi Proyek

Proyek ini adalah aplikasi Full-stack sederhana untuk mengelola data KTP. Sistem ini memungkinkan pengguna untuk menambah, melihat, memperbarui, dan menghapus data KTP tanpa perlu melakukan refresh halaman (Single Page Application feel) menggunakan Ajax.

---

## 2. Struktur Package (Backend)

Proyek ini mengikuti standar penamaan package yang lengkap untuk memastikan kode terorganisir dengan baik:

* `controller`: Menangani request REST API.
* `entity`: Representasi tabel database MySQL.
* `dto`: Objek untuk transfer data antara Client dan Server.
* `repository`: Interface untuk akses database menggunakan Spring Data JPA.
* `service`: Interface untuk logika bisnis.
* `service.impl`: Implementasi dari logika bisnis dan validasi.
* `util`: Utility class (seperti custom error handler).
* `mapper`: Untuk pemetaan data (Entity ke DTO).

---

## 3. Dokumentasi REST API (Endpoint)

### A. POST - Tambah Data KTP

Digunakan untuk memasukkan data KTP baru ke database.

* **URL:** `http://localhost:8080/ktp`
* **Request Body (JSON):**

```json
{
  "nomorKtp": "1234567890123456",
  "namaLengkap": "Firyal Shafa",
  "alamat": "Denpasar",
  "tanggalLahir": "2004-01-01",
  "jenisKelamin": "Perempuan"
}

```

> *<img width="1450" height="860" alt="Screenshot 2026-03-13 130356" src="https://github.com/user-attachments/assets/d4666d59-45a3-4962-9474-665639cd0b6b" />
*

### B. GET - Ambil Semua Data

Digunakan untuk menampilkan seluruh daftar KTP yang terdaftar.

* **URL:** `http://localhost:8080/ktp`
* **Response:** List of JSON Objects.

> *<img width="1460" height="892" alt="Screenshot 2026-03-13 130543" src="https://github.com/user-attachments/assets/f0f78aa2-e9a1-4368-878e-36ffcf7e0de8" />
*

### C. GET - Ambil Data Berdasarkan ID

Digunakan untuk mengambil satu data spesifik untuk keperluan pencarian atau editing.

* **URL:** `http://localhost:8080/ktp/1`

> *<img width="1438" height="890" alt="Screenshot 2026-03-13 130628" src="https://github.com/user-attachments/assets/d0044f86-0262-4164-ba48-6679b1c8dff0" />
*

### D. PUT - Perbarui Data KTP

Digunakan untuk mengubah data yang sudah ada berdasarkan ID.

* **URL:** `http://localhost:8080/ktp/1`
* **Request Body (JSON):**

```json
{
  "namaLengkap": "Firyal Shafa Updated",
  "alamat": "Bali",
  "tanggalLahir": "2004-01-01",
  "jenisKelamin": "Perempuan"
}

```

> *<img width="1439" height="895" alt="Screenshot 2026-03-13 130710" src="https://github.com/user-attachments/assets/f16551c6-021f-479c-bd8f-c873b25d2c46" />
*

### E. DELETE - Hapus Data

Digunakan untuk menghapus data berdasarkan ID.

* **URL:** `http://localhost:8080/ktp/2`
* **Response:** "Data berhasil dihapus"

> *<img width="1452" height="602" alt="Screenshot 2026-03-13 130804" src="https://github.com/user-attachments/assets/9e38227d-463d-4300-b573-6262d1bd2ce8" />
*

---

## 4. Tampilan Client-side (Frontend)

Halaman web dibangun menggunakan JQuery Ajax agar operasional CRUD berjalan secara *real-time* tanpa refresh halaman.

* **Fitur Utama:**
* Tampilan Utama.
 <img width="1916" height="966" alt="Screenshot 2026-03-13 133542" src="https://github.com/user-attachments/assets/2ba46d48-cdb8-4ad6-8e81-48a95fe132ae" />
* Fitur Tambah Data (Create)
  <img width="1919" height="957" alt="Screenshot 2026-03-13 133749" src="https://github.com/user-attachments/assets/4a60772a-ca13-40bb-b688-67cf961e6603" />
* Fitur Perbarui Data (Update)
  <img width="1919" height="956" alt="Screenshot 2026-03-13 133852" src="https://github.com/user-attachments/assets/c4adc85e-3b43-4bfe-9248-89924cbb0219" />
* Fitur Hapus Data (Delete)
  <img width="1919" height="967" alt="Screenshot 2026-03-13 133909" src="https://github.com/user-attachments/assets/392bb110-0e1f-40db-9ce4-12e611ecdabe" />
* Kondisi Akhir Tabel
  <img width="1919" height="844" alt="Screenshot 2026-03-13 133921" src="https://github.com/user-attachments/assets/ba6759d7-60a5-41a3-977d-8c4e55b10426" />

---

## 5. Konfigurasi Database

**Schema:** `spring`

**Table:** `ktp`

```sql
CREATE TABLE ktp (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nomor_ktp VARCHAR(255) UNIQUE,
    nama_lengkap VARCHAR(255),
    alamat VARCHAR(255),
    tanggal_lahir DATE,
    jenis_kelamin VARCHAR(255)
);

```
* data base
  <img width="1919" height="996" alt="Screenshot 2026-03-13 134015" src="https://github.com/user-attachments/assets/b628dcd1-4e24-43bb-b24b-917f9b048374" />

---
