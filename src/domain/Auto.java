package domain;

public class Auto {
  
    private String marka;
    private String model;
    private int przebieg;
    public int id;

    public Auto(String marka, String model, int przebieg) {
        this.marka = marka;
        this.model = model;
        this.przebieg = przebieg;       
    }
    
    public Auto(){
    }
    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

}
