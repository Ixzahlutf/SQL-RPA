package com.izzah.app;

import java.util.ArrayList;
import java.util.Scanner;;

public class App {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Film> daftarFilms = new ArrayList<>();

    public static void main(String[] args) {
        daftarFilms.add(new Film("Alice in Borderland", "Thriller", 50, 8.0));
        daftarFilms.add(new Film("Enigma", "Mystery", 120, 8.5));
        daftarFilms.add(new Film("500 Days of Summer", "Romance", 95, 7.7));

        if (login()) {
            boolean pilihMenu = true;
            while (pilihMenu) {
                // Menampilkan menu utama dan pilih menu
                tampilkanMenu();
                int pilih = input.nextInt();
                input.nextLine();

                switch (pilih) {
                    case 1:
                        tampilkanFilm();
                        break;
                    case 2:
                        inputFilm();
                        break;
                    case 3:
                        cariFilm();
                        break;
                    case 4:
                        pilihMenu = false;
                        System.out.println("Berhasil keluar");
                    default:
                        break;
                }
            }
        }
    }

    // Method-method
    public static boolean login() {
        boolean loginValidation = true;
        // Login Sistem. User diminta melakukan input username dan password yang valid
        System.out.println("=== Login ===");
        while (loginValidation) {
            System.out.print("Masukkan Username: ");
            String username = input.next();

            System.out.print("Masukkan Password: ");
            String password = input.next();

            // Validasi username dan password
            if (username.equals("admin") && password.equals("12345")) {
                System.out.println("Login berhasil!");
                loginValidation = false;
            } else {
                System.out.println("Username atau Password salah. Silahkan coba lagi!");
            }
        }
        return true;
    }

    // method untuk menampilkan menu utama
    public static void tampilkanMenu() {
        System.out.print(
                "=== Menu Utama ===\n1. Tampilkan Daftar Film\n2. Input Data Film\n3. Cari Film\n4. Keluar\nPilih menu: ");
    }

    // method untuk pilihan menu no 1 yaitu tampilkan daftar film
    public static void tampilkanFilm() {
        int i = 1;
        if (daftarFilms.size() > 0) {
            for (Film film : daftarFilms) {
                System.out.println("Film ke-" + i);
                System.out.println("Judul: " + film.getJudul());
                System.out.println("Genre: " + film.getGenre());
                System.out.println("Durasi: " + film.getDurasi() + " menit");
                System.out.println("Rating: " + film.getRating() + "\n");
                i++;
            }
        } else {
            System.out.println("Belum ada film yang tersedia, silahkan input data pada menu no 2 ");
        }

    }

    // method untuk pilihan no 2 yaitu input data film
    public static void inputFilm() {
        System.out.println("Maksimal jumlah film yang dapat didaftarkan adalah " + (10-daftarFilms.size()));
        System.out.print("Masukkan jumlah film yang ingin didaftarkan: ");
        int addFilm = input.nextInt();
        input.nextLine();

        if (addFilm <= (10 - daftarFilms.size())) {
            for (int i = 1; i <= addFilm; i++) {
                System.out.println("Film ke-" + i);

                System.out.print("Judul: ");
                String judul = input.nextLine();

                System.out.print(("Genre: "));
                String genre = input.nextLine();

                System.out.print("Durasi: ");
                int durasi = input.nextInt();
                input.nextLine();

                System.out.print("Rating: ");
                double rating = input.nextDouble();
                input.nextLine();

                // menambahkan film ke arrayList daftarFilms
                Film film = new Film(judul, genre, durasi, rating);
                daftarFilms.add(film);
            }
        }else{
            System.out.println("Jumlah yang anda masukkan melebihi kuota maksimal penyimpanan film. Jumlah film yang tersedia saat ini adalah " + daftarFilms.size() + " Maksimal jumlah yang dapat ditambahkan saat ini adalah " + (10-daftarFilms.size()));
            System.out.println("Kembali ke menu utama");
        }

    }

    // method untuk pilihan no 3 yaitu cari film
    public static void cariFilm() {
        System.out.print("Masukkan judul: ");
        String cariJudul = input.nextLine();
        boolean ditemukan = false;

        for (Film film : daftarFilms) {
            if (film.judul.equalsIgnoreCase(cariJudul)) {
                System.out.println("Judul tersedia pada daftar film. Berikut detail film tersebut:");
                System.out.println("Judul: " + film.getJudul());
                System.out.println("Genre: " + film.getGenre());
                System.out.println("Durasi: " + film.getDurasi() + " menit");
                System.out.println("Rating: " + film.getRating() + "\n");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Film tidak tersedia. Silahkan cek daftar film pada menu nomor 1");
        }
    }
}
