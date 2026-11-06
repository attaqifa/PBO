# Laporan Praktikum Pemrograman Berbasis Objek

## Pertemuan 11 - SOLID Principle dan Collections

## Identitas Mahasiswa

- Nama : Attaqi Fadhil Arifianto
- NIM : 254107020039
- Kelas : TI - 2G
- Repository : https://github.com/attaqifa/PBO/tree/main/Jobsheet11

## Struktur Source

Semua class berada di folder `Jobsheet11`:

- `Customer`, `InsufficientBalanceException`, `Account`
- `SavingsAccount`, `CheckingAccount`, `BusinessAccount`, `InterestBearing`
- `Transaction`, `TransactionType`
- `AccountRepository`, `InMemoryAccountRepository`, `Bank`
- `Main`

Kompilasi dan jalankan dari folder `Jobsheet11`:

```bash
javac -d out *.java
java -cp out Main
```

## Output per Langkah

### Langkah 3: Bank Berbasis Array

Tujuh baris pertama output final sama dengan checkpoint Langkah 3:

```text
Withdrawal failed: A003: insufficient balance for a withdrawal of 70000.0
Withdrawal succeeded, new balance: 70000.0
A001 interest applied, new balance: 505000.0
A001 monthly fee: 0.0
A002 monthly fee: 15000.0
A003 interest applied, new balance: 71400.0
A003 monthly fee: 0.0
```

### Langkah 4: Bank Beralih ke Map

Perilaku tidak berubah karena yang diganti hanya cara penyimpanan. Tujuh baris output tetap sama seperti Langkah 3. `LinkedHashMap` menjaga urutan A001, A002, lalu A003.

### Langkah 5: Transaction dan SRP

Riwayat rekening A003 muncul setelah tujuh baris sebelumnya:

```text
A003 WITHDRAW 30000.0
A003 DEPOSIT 1400.0
```

### Langkah 6: AccountRepository dan DIP

Output tetap sembilan baris, sama seperti Langkah 5. `Bank` sekarang memanggil `repository.findAll()` dan `repository.findByNumber(...)`.

### Tugas Mandiri: BusinessAccount

Output lengkap setelah `BusinessAccount` ditambahkan:

```text
Withdrawal failed: A003: insufficient balance for a withdrawal of 70000.0
Withdrawal succeeded, new balance: 70000.0
A001 interest applied, new balance: 505000.0
A001 monthly fee: 0.0
A002 monthly fee: 15000.0
A003 interest applied, new balance: 71400.0
A003 monthly fee: 0.0
A003 WITHDRAW 30000.0
A003 DEPOSIT 1400.0
A001 interest applied, new balance: 510050.0
A001 monthly fee: 0.0
A002 monthly fee: 15000.0
A003 interest applied, new balance: 72828.0
A003 monthly fee: 0.0
A004 monthly fee: 0.0
A001 - Nadia - balance: 510050.0
Account type: Savings, interest rate: 0.01
A002 - Sari - balance: 200000.0
Account type: Checking, overdraft limit: 50000.0
A003 - Rian - balance: 72828.0
Account type: Savings, interest rate: 0.02
A004 - Budi - balance: 2000000.0
Account type: Business
```

`processMonthEnd()` dipanggil dua kali sesuai alur jobsheet, sekali sebelum bagian tugas dan sekali setelah `BusinessAccount` didaftarkan. Karena itu A001 dan A003 mendapat bunga lagi.

## Bukti OCP, LSP, dan ISP

### Open/Closed Principle dan Liskov Substitution

Pada output Tugas, baris `A004 monthly fee: 0.0` muncul di antara baris `processMonthEnd()` yang lain. Di `printAllAccounts()`, A004 juga tampil sebagai:

```text
A004 - Budi - balance: 2000000.0
Account type: Business
```

Artinya `BusinessAccount` diperlakukan sama seperti rekening lain oleh `Bank`. Pencarian nama `SavingsAccount`, `CheckingAccount`, dan `BusinessAccount` di `Account.java` dan `Bank.java` tidak menemukan hasil. Kedua file itu tidak perlu diubah saat subclass baru ditambahkan.

### Interface Segregation Principle

`InterestBearing` hanya berisi satu method, yaitu `applyInterest()`. Pencarian nama interface itu hanya menemukan `Bank.java`, `InterestBearing.java`, dan `SavingsAccount.java`. `CheckingAccount` dan `BusinessAccount` tidak dipaksa mengimplementasikan bunga yang tidak relevan.

Pada output Tugas tidak ada baris `A004 interest applied`, karena `BusinessAccount` tidak mengimplementasikan `InterestBearing`.

## Jawaban Pertanyaan

a. `Account.java` dan `Bank.java` tidak berubah setelah `BusinessAccount` ditambahkan. Itu bukti Open/Closed Principle: `Account` terbuka untuk diperluas lewat subclass, tapi tertutup untuk diubah. `BusinessAccount` cukup override `canWithdraw()`, `monthlyFee()`, dan `printInfo()`, sementara `Bank` tetap bekerja lewat tipe `Account`.

b. `processMonthEnd()` memeriksa `instanceof InterestBearing`, bukan `instanceof SavingsAccount`. Pertanyaannya cuma apakah objek ini bisa menerima bunga. `BusinessAccount` tidak implements `InterestBearing`, jadi blok bunga dilewati dan yang dipanggil hanya `monthlyFee()`. `Bank` tidak perlu tahu `BusinessAccount` ada, karena yang ditanya kemampuan, bukan class.

c. `Bank` bergantung pada interface `AccountRepository`, bukan `InMemoryAccountRepository`. Kalau nanti mau dibuat repository berbasis database, tinggal buat class baru yang implements `save()`, `findByNumber()`, dan `findAll()`, lalu `Main` yang memilih. Ini Dependency Inversion Principle, dan `Bank.java` tidak perlu diubah.

## Penerapan SOLID

Penerapan kelima prinsip:

- Single Responsibility Principle: `Account` mengurus saldo dan aturan rekening, `Transaction` mewakili satu transaksi, `Bank` mengatur alur, dan repository menyimpan data.
- Open/Closed Principle: `BusinessAccount` ditambahkan tanpa mengubah `Account` dan `Bank`.
- Liskov Substitution Principle: semua rekening diproses lewat tipe `Account`, dan tiap subclass menjawab dengan aturannya sendiri.
- Interface Segregation Principle: `InterestBearing` kecil dan hanya dipakai rekening yang memang berbunga.
- Dependency Inversion Principle: `Bank` bergantung pada `AccountRepository`, bukan pada implementasi penyimpanan.
