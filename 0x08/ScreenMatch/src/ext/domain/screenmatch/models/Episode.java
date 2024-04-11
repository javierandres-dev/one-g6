package ext.domain.screenmatch.models;

import ext.domain.screenmatch.calculations.Classification;

public class Episode implements Classification {
    
    private int number;
    private String name;
    private Serie serie;
    private int views;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
    
    @Override
    public int getClassification() {
        if(views >= 500){
            return 5;
        } else if(views >= 400){
            return 4;
        } else if(views >= 300){
            return 3;
        } else if(views >= 200){
            return 2;
        } else if(views >= 100){
            return 1;
        } else {
            return 0;
        }
    }
}
