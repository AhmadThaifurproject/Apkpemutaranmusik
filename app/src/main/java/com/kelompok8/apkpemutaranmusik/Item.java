package com.kelompok8.apkpemutaranmusik;

public class Item {
    String name;
    String deskripsi;
    int image;

    public Item(String name, String deskripsi, int image) {
        this.name = name;
        this.deskripsi = deskripsi;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
