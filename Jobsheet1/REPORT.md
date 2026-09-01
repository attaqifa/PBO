# Laporan Praktikum Pemrograman Berbasis Objek

## Jobsheet 1 - Pengantar Pemrograman Berorientasi Objek

## Identitas Mahasiswa

- Nama : Attaqi Fadhil Arifianto
- NIM : 254107020039
- Kelas : TI - 2G
- Repository : https://github.com/attaqifa/PBO/blob/main/TugasPraktikum1

---

## 3. Percobaan

### 3.1 Percobaan 1
Output:  
![alt text](Image/image1.png)

### 3.2 Percobaan 2
Output:  
![alt text](Image/image2.png)

---

## 5. Pertanyaan

1. Jelaskan perbedaan antara object dengan class!  
Jawab: Class adalah blueprint atau cetakan yang mendefinisikan struktur, atribut, dan method dari suatu objek. Sedangkan Object adalah bentuk atau hasil dari class yang memiliki nilai atribut dan dapat menjalankan method yang didefinisikan dalam class.

2. Jelaskan alasan gear dan brand dapat menjadi atribut dari object Bike!  
Jawab: Karena gear dan brand merupakan karakteristik dimiliki oleh objek Bike.

3. Sebutkan salah satu kelebihan utama dari pemrograman berorientasi objek dibandingkan dengan pemrograman prosedural!  
Jawab: Program lebih fleksibel. Jika terjadi perubahan atau penambahan fitur pada suatu bagian program, perubahan tersebut tidak langsung mengganggu keseluruhan sistem. Kode juga menjadi lebih terstruktur dan efisien.

4. Apakah diperbolehkan melakukan pendefinisian dua buah atribut dalam satu baris kode seperti "public String nama, alamat;"?  
Jawab: Ya, diperbolehkan dalam bahasa Java selama kedua atribut memiliki tipe data dan akses modifier yang sama.

5. Pada class RoadBike, jelaskan alasan atribut brand, speed, dan gear tidak lagi ditulis di dalam class tersebut!  
Jawab: Karena class RoadBike menggunakan konsep inheritance dengan extends Bike, sehingga otomatis mewarisi struktur dari class Bike. Khusus atribut dengan private pada class Bike, pengaksesannya dilakukan melalui method dari class induk seperti super.printInfo().

---

## 6. Tugas Praktikum

### 6.1 Identifikasi Objek dan Struktur Class

1. Kendaraan (Superclass)
- Atribut: merk, kecepatan
- Method: setMerk(), tambahKecepatan(), cetakInformasi()

2. Mobil (Subclass dari Kendaraan)
- Atribut: jumlahPintu, tipeTransmisi
- Method: setJumlahPintu(), setTipeTransmisi(), cetakInformasi()

3. Motor (Subclass dari Kendaraan)
- Atribut: kapasitasBagasi, tipeKopling
- Method: setKapasitasBagasi(), setTipeKopling(), cetakInformasi()

4. Laptop  
- Atribut: merk, ramSize
- Method: setMerk(), upgradeRAM(), cetakInformasi()

5. LampuMeja  
- Atribut: warnaLampu, tingkatKecerahan
- Method: setWarna(), aturKecerahan(), cetakInformasi()

### 6.2 Bukti Objek

- Laptop  
![Laptop](Image/Laptop.jpeg)  

- Lampu Meja  
![Lampu Belajar](Image/LampuBelajar.jpg)  

- Motor  
![Motor](Image/Motor.jpg)  

- Mobil  
![Mobil](Image/Mobil.jpg)  

### 6.3 Output Program (MainDemo)

Output:  
![Output MainDemo](Image/image3.png)