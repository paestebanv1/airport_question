package AirportComponents;

public class Airplane {

    private String model;
    private String reference;
    private String status;

    public Airplane(String model, String reference, String status) {
        this.model = model;
        this.reference = reference;
        this.status = status;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String validateStatus(){
        return this.status;
    }

    public void startFlying(){
        this.status = "Flying";
    }

    public void startTakingOff(){
        this.status = "Flying";
    }

    public void requestRunwayToLand(){
        this.status = "Requesting Runway to Landing";
    }

    public void requestRunwayToTakeOff(){
        this.status = "Requesting Runway to Take Off";
    }

    public void startLanding(){
        this.status = "Landing";
    }

    public void endLanding(){
        this.status = "Landed";
    }
}
