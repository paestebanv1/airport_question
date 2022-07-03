package AirportComponents;

public class Runway {

    private String status;
    private String name;
    private Airplane airplane;

    public Runway(String status, String name, Airplane airplane) {
        this.status = status;
        this.name = name;
        this.airplane = airplane;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setFree(){
        this.status = "Available";
        this.airplane = null;
    }

    public void setInUse(){
        this.status = "In Use";
    }

    public void setInMaintenance(){
        this.status = "In Maintenance";
    }
}
