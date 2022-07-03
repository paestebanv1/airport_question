package mediator;

import AirportComponents.Airplane;
import AirportComponents.Runway;

public interface Mediator {
    void assignLandingRunway(Airplane airplane);
    void assignTakeOffRunway(Airplane airplane);
    void clearTakingOffRunway();
    void clearLandingRunway();
    Airplane verifyLandingPlanesQueue();
    Airplane verifyTakingOffPlanesQueue();
    boolean verifyLandingRunway();
    boolean verifyTakeOffRunway();
    void addPlaneLandingQueue(Airplane airplane);
    void addPlaneTakingOffQueue(Airplane airplane);
    boolean isLandingQueue();
    boolean isTakingOffQueue();
}
