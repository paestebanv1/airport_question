package mediator;

import AirportComponents.Airplane;
import AirportComponents.Runway;

import java.util.ArrayList;

public class ControlTower implements Mediator{

    ArrayList<Airplane> landingQueue;
    ArrayList<Airplane> takingOffQueue;
    Runway landingRunway;
    Runway takingOffRunway;

    public ControlTower() {
        this.landingQueue = new ArrayList<Airplane>();
        this.takingOffQueue = new ArrayList<Airplane>();
        this.landingRunway = new Runway("Available", "Landing Runway", null);
        this.takingOffRunway = new Runway("Available", "Taking Off Runway", null);
    }

    public ArrayList<Airplane> getLandingQueue() {
        return landingQueue;
    }

    public void setLandingQueue(ArrayList<Airplane> landingQueue) {
        this.landingQueue = landingQueue;
    }

    public ArrayList<Airplane> getTakingOffQueue() {
        return takingOffQueue;
    }

    public void setTakingOffQueue(ArrayList<Airplane> takingOffQueue) {
        this.takingOffQueue = takingOffQueue;
    }

    public Runway getLandingRunway() {
        return landingRunway;
    }

    public void setLandingRunway(Runway landingRunway) {
        this.landingRunway = landingRunway;
    }

    public Runway getTakingOffRunway() {
        return takingOffRunway;
    }

    public void setTakingOffRunway(Runway takingOffRunway) {
        this.takingOffRunway = takingOffRunway;
    }

    @Override
    public void assignLandingRunway(Airplane airplane) {
        airplane.setStatus("At the runway arriving");
        this.landingRunway.setAirplane(airplane);
        this.landingRunway.setInUse();
        System.out.println("the plane " + airplane.getReference() + " is " + airplane.getStatus());
        System.out.println("the departing runway is " + this.landingRunway.getStatus());
    }

    @Override
    public void assignTakeOffRunway(Airplane airplane) {
        airplane.setStatus("At the runway leaving");
        this.takingOffRunway.setAirplane(airplane);
        this.takingOffRunway.setInUse();
        System.out.println("the plane " + airplane.getReference() + " is " + airplane.getStatus());
        System.out.println("the departing runway is " + this.takingOffRunway.getStatus());
    }

    @Override
    public void clearTakingOffRunway() {
        this.takingOffRunway.getAirplane().setStatus("Flying");
        System.out.println("the plane " + this.takingOffRunway.getAirplane().getReference() + " is " + this.takingOffRunway.getAirplane().getStatus());
        this.takingOffRunway.setFree();
        System.out.println("the departing runway is " + this.takingOffRunway.getStatus());
    }

    @Override
    public void clearLandingRunway() {
        this.landingRunway.getAirplane().setStatus("Stopped");
        System.out.println("the plane " + this.landingRunway.getAirplane().getReference() + " is " + this.landingRunway.getAirplane().getStatus());
        this.landingRunway.setFree();
        System.out.println("the departing runway is " + this.landingRunway.getStatus());
    }

    @Override
    public Airplane verifyLandingPlanesQueue() {
        if (this.landingQueue.size() > 0){
            Airplane airplaneReadyLand = this.landingQueue.get(0);
            try {
                this.landingQueue.remove(0);
                return airplaneReadyLand;
            } catch(Exception e){
                return null;
            }
        }
        return null;
    }

    @Override
    public Airplane verifyTakingOffPlanesQueue() {
        if (this.takingOffQueue.size() > 0){
            Airplane airplaneReadyTakeOff = this.takingOffQueue.get(0);
            try {
                this.takingOffQueue.remove(0);
                return airplaneReadyTakeOff;
            } catch(Exception e){
                return null;
            }
        }
        return null;
    }

    @Override
    public boolean verifyLandingRunway() {
        if(this.landingRunway.getStatus() == "Available"){
            return true;
        }
        return false;
    }

    @Override
    public boolean verifyTakeOffRunway() {
        if(this.takingOffRunway.getStatus() == "Available"){
            return true;
        }
        return false;
    }

    @Override
    public void addPlaneLandingQueue(Airplane airplane) {
        this.landingQueue.add(airplane);
    }

    @Override
    public void addPlaneTakingOffQueue(Airplane airplane) {
        this.takingOffQueue.add(airplane);
    }

    @Override
    public boolean isLandingQueue() {
        if (this.landingQueue.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isTakingOffQueue() {
        if (this.takingOffQueue.size() > 0){
            return true;
        }
        return false;
    }
}
