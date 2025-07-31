TUGAS MINGGU 2_Nurul Izzah Luthfiah Nur

TUJUAN
Melakukan riset sederhana tentang tingkat pararel pada test automation

DESKRIPSI TEST
- Test Case 1
  Thread.sleep() selama 5 detik.
  ![alt text](<assets/Test case 1.png>)
- Test Case 2
  Thread.sleep() selama 7 detik.
  ![alt text](<assets/Test case 2.png>)

HASIL PENGUJIAN
- Sekuensial
  Diperoleh total waktu 15.750s untuk menyelesaikan 2 test case menggunakan sekuensial.
  ![alt text](<assets/Hasil pengujian sekuensial.png>)
- Paralel
  Diperoleh total waktu 10.807s untuk menyelesaikan 2 test case menggunakan pararel.
  ![alt text](<assets/Hasil pengujian pararel.png>)

ANALISIS HASIL/INSIGHT YG DIDAPATKAN
Dari hasil test diperoleh bahwa total waktu yang dibutuhkan untuk test
menggunakan pararel yaitu 10.807s lebih cepat dibandingkan dengan test
menggunakan sekuensial yaitu 15.750s. hal ini membuktikan bahwa pararel
dapat meningkatkan efisiensi waktu karena test dijalankan secara bersamaan
sedangkan sekuensial dilakukan test satu per satu.