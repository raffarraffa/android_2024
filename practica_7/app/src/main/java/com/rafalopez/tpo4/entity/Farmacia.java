package com.rafalopez.tpo4.entity;

import java.io.Serializable;

public class Farmacia implements Serializable {
    private String title;
    private String dir;
    private double lat;
    private double lon;

    private String horario;
    private Integer img;

    public Farmacia(String title, String dir, double lat, double lon, String horario, Integer img) {
        this.title = title;
        this.dir = dir;
        this.lat = lat;
        this.lon = lon;
        this.horario = horario;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }
}
