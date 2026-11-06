# Laporan Praktikum Pemrograman Berbasis Objek

## Jobsheet 9 - Abstract Class dan Interface

## Identitas Mahasiswa

- Nama : Attaqi Fadhil Arifianto
- NIM : 254107020039
- Kelas : TI - 2G
- Repository : https://github.com/attaqifa/PBO/tree/main/Jobsheet10

## Struktur Source

Jobsheet ini disimpan di folder `Jobsheet10` karena `Jobsheet9` sudah dipakai untuk Polimorfisme.

- `abstractclass` : Percobaan 1
- `interfacelatihan` : Percobaan 2 dan 3
- `tugas` : Tugas hewan

Percobaan 2 dan 3 memakai package yang sama, sehingga main class dipisah menjadi `Program` dan `ProgramMawapres`.

Kompilasi dan jalankan dari folder `Jobsheet10`:

```bash
javac -d out abstractclass/*.java interfacelatihan/*.java tugas/*.java
java -cp out abstractclass.Program
```

## Percobaan

### Percobaan 1: Abstract Class

Output `abstractclass.Program`:

```text
Namaku Ani
Hewan peliharaanku berjalan dengan cara:
Berjalan dengan KAKI, "tap..tap.."
----------------------------------------
Namaku Budi
Hewan peliharaanku berjalan dengan cara:
Berenang dengan SIRIP, "wush..wush.."
----------------------------------------
```

### Percobaan 2: Interface

Output `interfacelatihan.Program`:

```text
Saya REKTOR, memberikan sertifikat cumlaude.
Selamat! Silakan perkenalkan diri Anda..
Aku sudah menyelesaikan SKRIPSI
IPK-ku lebih dari 3,51
----------------------------------------
Saya REKTOR, memberikan sertifikat cumlaude.
Selamat! Silakan perkenalkan diri Anda..
Aku sudah menyelesaikan TESIS
IPK-ku lebih dari 3,71
----------------------------------------
```

### Percobaan 3: Multiple Interface

Output `interfacelatihan.ProgramMawapres`:

```text
Saya REKTOR, memberikan sertifikat MAWAPRES.
Selamat! Bagaimana Anda bisa berprestasi?
Saya telah menjuarai kompetisi NASIONAL
Saya menerbitkan artikel di jurnal NASIONAL
----------------------------------------
Saya REKTOR, memberikan sertifikat MAWAPRES.
Selamat! Bagaimana Anda bisa berprestasi?
Saya telah menjuarai kompetisi INTERNASIONAL
Saya menerbitkan artikel di jurnal INTERNASIONAL
----------------------------------------
```

## Pertanyaan

### Pertanyaan Percobaan 1

1. `Orang` menyimpan hewannya di atribut bertipe `Hewan`. `ani` diisi `Kucing`, `budi` diisi `Ikan`. Waktu `this.hewanPeliharaan.bergerak()` dipanggil, JVM menjalankan `bergerak()` milik objek yang sedang ditunjuk, makanya hasilnya beda.

2. Saya coba tambahkan `Hewan hewan = new Hewan();`, hasilnya:

   ```text
   error: Hewan is abstract; cannot be instantiated
           Hewan hewan = new Hewan();
                         ^
   1 error
   ```

   Abstract class cuma bisa dipakai sebagai tipe referensi atau superclass, tidak bisa dibuat objeknya langsung.

3. Class konkret harus mengisi semua abstract method yang diwarisi. Setelah `bergerak()` saya hapus dari `Ikan`, hasil kompilasinya:

   ```text
   error: Ikan is not abstract and does not override abstract method bergerak() in Hewan
   public class Ikan extends Hewan {
          ^
   1 error
   ```

   Kalau memang tidak mau mengisi, class-nya harus dideklarasikan `abstract` juga.

4. Saya tambahkan `public abstract void bernapas();` ke `Ikan`, hasilnya:

   ```text
   error: Ikan is not abstract and does not override abstract method bernapas() in Ikan
   public class Ikan extends Hewan {
          ^
   1 error
   ```

   Aturan yang dilanggar: class yang punya abstract method wajib dideklarasikan sebagai abstract class. Karena `Ikan` tetap konkret, `bernapas()` tidak boleh dibiarkan tanpa isi.

### Pertanyaan Percobaan 2

1. Error-nya karena `mhsBiasa` bertipe `Mahasiswa`, sedangkan `beriSertifikatCumlaude()` minta `ICumlaude`. `Mahasiswa` tidak implements interface itu.

   ```text
   error: incompatible types: Mahasiswa cannot be converted to ICumlaude
           pakRektor.beriSertifikatCumlaude(mhsBiasa);
                                            ^
   1 error
   ```

   Saya perbaiki dengan menghapus pemanggilan untuk `mhsBiasa`, karena mahasiswa biasa memang tidak memenuhi kontrak cumlaude.

2. Bisa. `sarjanaCumlaude` bertipe `Sarjana`, dan `Sarjana` turunan `Mahasiswa`, jadi `kuliahDiKampus()` ikut diwarisi.

   ```text
   Aku mahasiswa, namaku Dini
   Aku berkuliah di kampus.
   ```

3. Tidak bisa. Di dalam `Rektor`, parameternya bertipe `ICumlaude`, dan interface itu cuma punya `lulus()` dan `meraihIPKTinggi()`. Compiler menolak:

   ```text
   error: cannot find symbol
           mahasiswaCumlaude.kuliahDiKampus();
                            ^
     symbol:   method kuliahDiKampus()
     location: variable mahasiswaCumlaude of type ICumlaude
   1 error
   ```

4. Waktu kata kunci `public` saya hapus dari `lulus()` di `Sarjana`, muncul error:

   ```text
   error: lulus() in Sarjana cannot implement lulus() in ICumlaude
       void lulus() {
            ^
     attempting to assign weaker access privileges; was public
   1 error
   ```

   Method interface itu public, jadi implementasinya tidak boleh menurunkan hak akses jadi package-private.

### Pertanyaan Percobaan 3

1. `protected` memang tidak boleh dipakai di method interface. Kalau `private`, Java menganggap method itu bukan bagian dari kontrak, jadi wajib punya badan.

   ```text
   error: modifier protected not allowed here
       protected void menjuaraiKompetisi();
                      ^
   error: method membuatPublikasiIlmiah() in IBerprestasi is missing a method body, or should be declared abstract
       private void membuatPublikasiIlmiah();
                    ^
   2 errors
   ```

   Setelah dicatat, keduanya saya kembalikan seperti semula.

2. Interface juga tidak bisa diinstansiasi karena method-nya belum ada isinya. Hasilnya:

   ```text
   error: IBerprestasi is abstract; cannot be instantiated
           IBerprestasi prestasi = new IBerprestasi();
                                   ^
   1 error
   ```

3. Saya ubah `Sarjana` supaya implements `IBerprestasi` dengan versi NASIONAL, sedangkan `PascaSarjana` tetap INTERNASIONAL. Outputnya ada di bagian Percobaan 3, dan sekarang keduanya bisa menerima sertifikat mawapres.

## Tugas

### Tugas: Sistem Binatang

Struktur yang dipakai:

- `Binatang` sebagai abstract class dengan atribut nama, jumlah kaki, suara, dan warna bulu.
- `IKarnivora` dan `IHerbivora` sebagai interface dengan method `displayMakan()`.
- `Keledai` mengimplementasikan `IHerbivora`, `Singa` mengimplementasikan `IKarnivora`, dan `Gorilla` mengimplementasikan keduanya.
- `Gorilla` cukup menulis satu `displayMakan()` karena kedua interface memiliki signature yang sama.

Relasi class:

- `Keledai`, `Singa`, dan `Gorilla` meng-extend `Binatang`.
- `Keledai` mengimplementasikan `IHerbivora`.
- `Singa` mengimplementasikan `IKarnivora`.
- `Gorilla` mengimplementasikan `IKarnivora` dan `IHerbivora`.

Output `tugas.MainTugas`:

```text
Jenis: Herbivora
Makanan: Tumbuhan
Nama: Keledai
Jumlah Kaki: 4
Suara: Hehehehe
Warna Bulu: Abu-Abu
Jenis: Karnivora + Herbivora
Makanan: Daging + Tumbuhan
Nama: Gulali
Jumlah Kaki: 4
Suara: Haaum Hauum
Warna Bulu: Hitam Manis
Jenis: Karnivora
Makanan: Daging
Nama: CingaCing
Jumlah Kaki: 4
Suara: Roaar Roaaar
Warna Bulu: Coklat
```
