import AirportComponents.Airplane;
import mediator.ControlTower;
import mediator.Mediator;

import javax.naming.ldap.Control;

public class Main {
    public static void main(String[] args) {
        Mediator controlTower = new ControlTower();

        Airplane airplane = new Airplane("Airbus", "ABC123", "Waiting to Land");
        controlTower.addPlaneLandingQueue(airplane);
        Airplane airplane2 = new Airplane("Airbus", "ABC1234", "Waiting to Land");
        controlTower.addPlaneLandingQueue(airplane2);
        Airplane airplane3 = new Airplane("Airbus", "ABC12345", "Waiting to Land");
        controlTower.addPlaneLandingQueue(airplane3);
        Airplane airplane4 = new Airplane("Charter", "XYZ123", "Waiting to Depart");
        controlTower.addPlaneTakingOffQueue(airplane4);
        Airplane airplane5 = new Airplane("Charter", "XYZ1234", "Waiting to Depart");
        controlTower.addPlaneTakingOffQueue(airplane5);
        Airplane airplane6 = new Airplane("Charter", "XYZ1235", "Waiting to Depart");
        controlTower.addPlaneTakingOffQueue(airplane6);

        while(controlTower.isTakingOffQueue()){
            Airplane departingAirpleane = controlTower.verifyTakingOffPlanesQueue();
            System.out.println("The plane " + departingAirpleane.getReference() + " is " + departingAirpleane.getStatus());
            if(departingAirpleane != null){
                if(departingAirpleane.getStatus() == "Waiting to Depart" && controlTower.verifyTakeOffRunway()){
                    controlTower.assignTakeOffRunway(departingAirpleane);
                }
                if(!controlTower.verifyTakeOffRunway()){
                    try{
                        controlTower.clearTakingOffRunway();
                    } catch (Exception ex){
                        System.out.println("Something went wrong with the taking off runway");
                    }
                }
            }
        }

        while(controlTower.isLandingQueue()){
            Airplane arrivingAirpleane = controlTower.verifyLandingPlanesQueue();
            System.out.println("The plane " + arrivingAirpleane.getReference() + " is " + arrivingAirpleane.getStatus());
            if(arrivingAirpleane != null){
                if(arrivingAirpleane.getStatus() == "Waiting to Land" && controlTower.verifyLandingRunway()){
                    controlTower.assignLandingRunway(arrivingAirpleane);
                }
                if(!controlTower.verifyLandingRunway()){
                    try{
                        controlTower.clearLandingRunway();
                    } catch (Exception ex){
                        System.out.println("Something went wrong with the taking off runway");
                    }
                }
            }
        }
    }
}