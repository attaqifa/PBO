# Laporan Praktikum Pemrograman Berbasis Objek

## Jobsheet 9 - Polimorfisme

## Identitas Mahasiswa

- Nama : Attaqi Fadhil Arifianto
- NIM : 254107020039
- Kelas : TI - 2G
- Repository : https://github.com/attaqifa/PBO/tree/main/Jobsheet9

## Struktur Source

- `gambaran` : GambaranDasar
- `pegawai` : Percobaan 1 sampai 4
- `zombie` : Tugas mandiri

Kompilasi dan jalankan dari folder `Jobsheet9`:

```bash
javac -d out gambaran/*.java pegawai/*.java zombie/*.java
java -cp out gambaran.GambaranDasar
```

## Percobaan

### Percobaan 1: Bentuk Dasar Polimorfisme

Output `GambaranDasar`:

```text
a menunjuk objek Deer
a2 menunjuk objek Lion
v menunjuk objek Deer
```

Eksperimen mengaktifkan baris `Vegetarian v2 = l;`:

```text
GambaranDasar.java:19: error: incompatible types: Lion cannot be converted to Vegetarian
        Vegetarian v2 = l;
                        ^
1 error
```

Output `MainPercobaan1`:

```text
e menunjuk objek PermanentEmployee
e menunjuk objek InternshipEmployee
p menunjuk objek PermanentEmployee
p menunjuk objek ElectricityBill
```

Eksperimen `p = iEmp;` dan `e = eBill;`:

```text
error: incompatible types: InternshipEmployee cannot be converted to Payable
        p = iEmp;
            ^
error: incompatible types: ElectricityBill cannot be converted to Employee
        e = eBill;
            ^
2 errors
```

### Percobaan 2: Virtual Method Invocation

Output `MainPercobaan2`:

```text
Name = Dedik
Registered as permanent employee with salary 500

------------------
Name = Dedik
Registered as permanent employee with salary 500

------------------
Name = Sunarto
Registered as internship employee for 5 month/s
```

Eksperimen `e.getSalary();` ketika `e` bertipe `Employee`:

```text
error: cannot find symbol
        System.out.println(e.getSalary());
                            ^
  symbol:   method getSalary()
  location: variable e of type Employee
1 error
```

### Percobaan 3: Heterogeneous Collection

Output `MainPercobaan3`:

```text
Name = Dedik
Registered as permanent employee with salary 500

Name = Sunarto
Registered as internship employee for 5 month/s

Total tagihan bulan ini = 1025
```

Eksperimen mengaktifkan `Employee[] e2 = {pEmp, iEmp, eBill};`:

```text
error: incompatible types: ElectricityBill cannot be converted to Employee
        Employee[] e2 = {pEmp, iEmp, eBill};
                                     ^
1 error
```

### Percobaan 4: Polymorphic Argument, instanceof, dan Casting

Output `MainPercobaan4`:

```text
Total payment = 500
kWH = 5
Category = R-1 (100 per kWH)

------------------------------
Total payment = 525
Name = Dedik
Registered as permanent employee with salary 500

------------------------------
Name = Dedik
Registered as permanent employee with salary 500

You have to pay her/him monthly!!!
------------------------------
Name = Sunarto
Registered as internship employee for 5 month/s

No need to pay him/her :)
```

Eksperimen `ow.pay(iEmp);`:

```text
error: incompatible types: InternshipEmployee cannot be converted to Payable
        ow.pay(iEmp);
               ^
1 error
```

Eksperimen downcasting `InternshipEmployee` ke `PermanentEmployee`:

```text
Sebelum casting
Exception in thread "main" java.lang.ClassCastException:
class pegawai.InternshipEmployee cannot be cast to
class pegawai.PermanentEmployee
```

## Pertanyaan

### Pertanyaan Percobaan 1

1. Yang termasuk turunan `Employee` ada dua, yaitu `InternshipEmployee` dan `PermanentEmployee`.
2. Yang mengimplementasikan `Payable` juga dua: `PermanentEmployee` dan `ElectricityBill`.
3. `e` bisa diisi `pEmp` dan `iEmp` karena `Employee` adalah induk keduanya. Selama hubungan is-a terpenuhi, assignment-nya sah.
4. Sama seperti tadi, `p` bertipe `Payable`. `PermanentEmployee` dan `ElectricityBill` sama-sama implements interface itu, jadi keduanya boleh masuk.
5. `p = iEmp` gagal karena `InternshipEmployee` tidak implements `Payable`. `e = eBill` gagal karena `ElectricityBill` bukan turunan `Employee`. Kasusnya sama dengan `Vegetarian v2 = l` tadi: compiler menolak assignment yang tidak punya hubungan tipe sama sekali.
6. Tipe referensi adalah tipe yang saya tulis saat deklarasi, di sini `Animal`. Tipe objek adalah class yang benar-benar dibuat pakai `new`, yaitu `Deer`. `getClass()` membaca tipe objek, sedangkan compiler hanya melihat tipe referensi.
7. Polimorfisme membuat satu variabel bertipe induk atau interface bisa menunjuk objek dari berbagai subclass. Yang boleh ditunjuk ditentukan compiler lewat relasi is-a, tetapi method yang jalan tetap mengikuti objek aslinya.

### Pertanyaan Percobaan 2

1. Karena `e` dan `pEmp` menunjuk objek `PermanentEmployee` yang sama. Mau lewat referensi apa pun, method yang dijalankan tetap versi `PermanentEmployee`.
2. `e.getEmployeeInfo()` disebut virtual karena dipanggil lewat referensi `Employee`, jadi versi method-nya baru ditentukan saat program berjalan. Kalau `pEmp.getEmployeeInfo()`, tipenya sudah konkret `PermanentEmployee`, tidak ada pemilihan lagi.
3. Virtual method invocation adalah pemanggilan method hasil override lewat referensi superclass atau interface. Disebut virtual karena method yang dikenali compiler bisa berbeda dengan method yang dijalankan JVM.
4. Pernyataannya sama, tetapi isi `e` sudah saya ganti ke `InternshipEmployee`. JVM lalu memilih `getEmployeeInfo()` milik `InternshipEmployee` lewat dynamic method dispatch.
5. Compiler menolak karena tipe referensi `e` adalah `Employee`, dan `Employee` tidak punya `getSalary()`. Compiler hanya mengenal anggota yang ada di tipe referensi, bukan di subclass.

### Pertanyaan Percobaan 3

1. Array `e` bertipe `Employee`, dan kedua objek itu turunan `Employee`.
2. Array `p` bertipe `Payable`, dan `PermanentEmployee` serta `ElectricityBill` sama-sama implements `Payable`.
3. `ElectricityBill` bukan turunan `Employee`, jadi tidak cocok dengan tipe array.
4. Tiap elemen memanggil `getEmployeeInfo()` versi class-nya sendiri. Sama seperti Percobaan 2, bedanya sekarang pemanggilannya di dalam loop.

### Pertanyaan Percobaan 4

1. Karena `ElectricityBill` dan `PermanentEmployee` sama-sama implements `Payable`, keduanya cocok dengan parameter `pay(Payable p)`.
2. Dengan parameter `Payable`, `pay()` tidak perlu tahu class konkretnya. Method cukup memanggil `getPaymentAmount()` yang sudah dijamin ada di interface.
3. `ow.pay(iEmp)` gagal karena `InternshipEmployee` tidak implements `Payable`.
4. `instanceof` dipakai untuk memastikan objeknya benar-benar `ElectricityBill` sebelum di-downcast. Kalau tidak dicek, casting bisa gagal saat program berjalan.
5. Karena dari tipe `Payable` saya hanya bisa memanggil `getPaymentAmount()`. `getBillInfo()` baru terlihat setelah referensinya diubah ke `ElectricityBill`.
6. Kompilasi lolos karena `PermanentEmployee` masih subclass `Employee`, jadi downcast-nya masuk akal secara tipe. Tetapi objek aslinya `InternshipEmployee`, makanya JVM melempar `ClassCastException`. Di sinilah `instanceof` berguna.

## Tugas Mandiri

### Tugas 1: Permainan Zombie, Barrier, dan Plant

Output `MainTugas1`:

```text
Walking Zombie Data =
Health = 100
Level = 1

Jumping Zombie Data =
Health = 100
Level = 2

Barrier Strength = 100

----------------------
Walking Zombie Data =
Health = 42
Level = 1

Jumping Zombie Data =
Health = 66
Level = 2

Barrier Strength = 64
```

Pertanyaan analisis:

a. `Plant.doDestroy()` bisa menerima ketiganya karena parameternya bertipe `Destroyable`. `WalkingZombie` dan `JumpingZombie` menjadi `Destroyable` lewat abstract class `Zombie`, sedangkan `Barrier` implements langsung. Ketiganya tidak perlu berada dalam satu hierarki class.

b. Di dalam `Plant`, tipe referensinya `Destroyable`, tetapi objek yang ditunjuk bergantian. `destroyed()` yang dijalankan adalah versi milik objek yang sedang ditunjuk. Urutannya selalu `WalkingZombie`, `JumpingZombie`, lalu `Barrier`.

c. `new Zombie(100, 1)` menghasilkan error kompilasi `Zombie is abstract; cannot be instantiated`. Abstract class memang tidak bisa dibuat objeknya secara langsung.

### Tugas 2: Heterogeneous Collection, instanceof, dan Casting

Output `MainTugas2`:

```text
Walking Zombie Data =
Health = 46
Level = 1

Jumping Zombie Data =
Health = 92
Level = 2

Barrier Strength = 64
```

Pertanyaan analisis:

a. Array-nya harus bertipe `Destroyable` karena isinya campuran dari dua hierarki, yaitu `Zombie` dan `Barrier`. `Destroyable` satu-satunya tipe yang menyatukan keduanya.

b. Casting ke `Zombie` perlu sebelum memanggil `heal()` karena `Destroyable` hanya punya `destroyed()`. `heal()` baru terlihat setelah referensinya diubah.

c. Tanpa `instanceof`, casting `Barrier` ke `Zombie` masih lolos kompilasi karena keduanya terhubung lewat `Destroyable`. Begitu dijalankan, JVM melempar `ClassCastException` karena objeknya bukan `Zombie`.

### Tugas 3: Prediksi Hasil Kompilasi

1. `Zombie z = new WalkingZombie(100, 1);` OK, karena `WalkingZombie` turunan `Zombie`.
2. `Destroyable d = z;` OK, upcasting ke interface yang diimplementasikan `Zombie`.
3. `Zombie z2 = d;` error kompilasi, karena `Destroyable` tidak otomatis menjadi `Zombie` dan perlu cast eksplisit.
4. `Zombie z3 = (Zombie) d;` OK, karena objek aslinya `WalkingZombie`.
5. `Zombie z4 = new Zombie(100, 1);` error kompilasi, karena `Zombie` abstract.
6. `Destroyable d2 = new Plant();` error kompilasi, karena `Plant` tidak mengimplementasikan `Destroyable`.
7. `Zombie z5 = new JumpingZombie(100, 2);` lalu `WalkingZombie w = (WalkingZombie) z5;` error saat dijalankan, karena objek aslinya `JumpingZombie`.

Pesan compiler yang terbukti:

```text
error: incompatible types: Destroyable cannot be converted to Zombie
        Zombie z2 = d;
                    ^
error: Zombie is abstract; cannot be instantiated
        Zombie z4 = new Zombie(100, 1);
                    ^
error: incompatible types: Plant cannot be converted to Destroyable
        Destroyable d2 = new Plant();
                         ^
3 errors
```

Bukti runtime untuk baris terakhir ada di `MainTugas3`:

```text
Walking Zombie Data =
Health = 100
Level = 1

ClassCastException: class zombie.JumpingZombie cannot be cast to class zombie.WalkingZombie
```
