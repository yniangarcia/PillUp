package edu.upf.pillup.DATABASE;

public class modelPills {
    private int id;
    private String name;
    private String freq;
    private String dur;
    private String time;

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getFreq(){
        return freq;
    }

    public String getDur() { return dur; }

    public String getTime() { return time; }


    public void setId( int id) {
        this.id = id;
    }

    public void setName( String name){
        this.name = name;
    }

    public void setFreq( String freq) { this.freq = freq; }

    public void setDur( String dur ) { this.dur = dur; }

    public void setTime( String time ) { this.time = time; }

}
