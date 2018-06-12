package edu.upf.pillup.DATABASE;

public class modelPills {
    private int id;
    private String name;
    private String quant;

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getQuant(){
        return quant;
    }

    public void setId( int id) {
        this.id = id;
    }

    public void setName( String name){
        this.name = name;
    }

    public void setQuant( String quant){
        this.quant = quant;
    }
}
