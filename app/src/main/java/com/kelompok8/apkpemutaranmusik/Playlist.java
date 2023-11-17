package com.kelompok8.apkpemutaranmusik;

public class Playlist {
    private String title;
    private int thumbnail; // Gunakan integer untuk menyimpan referensi gambar (contoh: R.drawable.image)

    public Playlist(String title, int thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public int getThumbnail() {
        return thumbnail;
    }
}
