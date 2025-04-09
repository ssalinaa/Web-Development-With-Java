import java.time.LocalDate;
import java.util.*;

class FlightLeg {
    private String fromAirport;
    private String toAirport;
    private LocalDate date;

    public FlightLeg(String fromAirport, String toAirport, LocalDate date) {
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.date = date;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "From: " + fromAirport + " To: " + toAirport + " Date: " + date;
    }
}

class Aircraft {
    private String tailNumber;
    private List<FlightLeg> flightLegs;

    public Aircraft(String tailNumber) {
        this.tailNumber = tailNumber;
        this.flightLegs = new ArrayList<>();
    }

    public void addFlightLeg(FlightLeg flightLeg) {
        flightLegs.add(flightLeg);
    }

    public List<FlightLeg> getFlightLegs() {
        return flightLegs;
    }

    public List<FlightLeg> filterLegsByAirport(String airportCode) {
        List<FlightLeg> filteredLegs = new ArrayList<>();
        for(FlightLeg leg : flightLegs) {
            if(leg.getFromAirport().equals(airportCode) || leg.getToAirport().equals(airportCode)) {
                filteredLegs.add(leg);
            }
        }
        return filteredLegs;
    }

    public String getTailNumber() {
        return tailNumber;
    }
}

public class AircraftFlightTracker {
    public static void main(String[] args) {
        FlightLeg leg1 = new FlightLeg("LBSF", "EBBR", LocalDate.of(2025, 2, 26));
        FlightLeg leg2 = new FlightLeg("EBBR", "LBSF", LocalDate.of(2025, 2, 27));
        FlightLeg leg3 = new FlightLeg("LBSF", "EGLL", LocalDate.of(2025, 3, 1));
        FlightLeg leg4 = new FlightLeg("EGLL", "EBBR", LocalDate.of(2025, 3, 2));

        Aircraft aircraft = new Aircraft("9H-VCA");
        aircraft.addFlightLeg(leg1);
        aircraft.addFlightLeg(leg2);
        aircraft.addFlightLeg(leg3);
        aircraft.addFlightLeg(leg4);

        Map<String, List<FlightLeg>> aircraftData = new HashMap<>();
        aircraftData.put(aircraft.getTailNumber(), aircraft.getFlightLegs());

        System.out.println("~~~ Flight Legs for Aircraft " + aircraft.getTailNumber() + " ~~~");
        for(FlightLeg flightLeg : aircraftData.get("9H-VCA")) {
            System.out.println(flightLeg);
        }

        System.out.println("\n~~~ Flight Legs Involving LBSF Airport ~~~");
        List<FlightLeg> filteredLegs = aircraft.filterLegsByAirport("LBSF");
        for(FlightLeg flightLeg : filteredLegs) {
            System.out.println(flightLeg);
        }
    }
}
