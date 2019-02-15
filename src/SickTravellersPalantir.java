//A group of independent travelers are traveling around the world. Each day they travel to a new location as per their travel schedule. At the end of their travel schedule, they travel again using the same schedule from the beginning. Some of the travelers are diseased. If a healthy traveler is at the same location as a diseased traveler, they become sick.
//
//        Each traveler has a name, health condition (one of HEALTHY, SICK, or RECOVERING), and a travel schedule (order of locations they are visiting).
//
//        The objective is to trace the health of the travelers until they are all healthy. If all the travelers do not become healthy within a year (365 days), then stop tracing. The travelers transition through their sickness as follows:
//        HEALTHY: if exposed to a SICK/RECOVERING traveler, become SICK; otherwise stay HEALTHY
//        SICK: after one day of staying SICK, a traveler enters RECOVERING stage
//        RECOVERING: after one day of RECOVERING, a traveler becomes HEALTHY
//
//        Input
//        4
//        John HEALTHY Seattle London Seattle Berlin
//        Lily RECOVERING Seattle Berlin
//        Joanna SICK Berlin Berlin London Tokyo
//        Tim RECOVERING Berlin London London Seattle
//        The first line of the input is the number of travelers. Each of the following lines correspond to a single traveler. Each line has the traveler's name, health and the travel locations separated by a space. The travel locations make up the traveler's schedule in order.
//
//        Output
//        John Lily Joanna Tim
//        HEALTHY RECOVERING SICK RECOVERING
//        SICK HEALTHY RECOVERING HEALTHY
//        RECOVERING SICK HEALTHY HEALTHY
//        HEALTHY RECOVERING HEALTHY HEALTHY
//        SICK HEALTHY HEALTHY SICK
//        RECOVERING HEALTHY SICK RECOVERING
//        HEALTHY SICK RECOVERING HEALTHY
//        SICK RECOVERING HEALTHY HEALTHY
//        RECOVERING HEALTHY HEALTHY SICK
//        HEALTHY HEALTHY SICK RECOVERING
//        SICK SICK RECOVERING HEALTHY
//        RECOVERING RECOVERING HEALTHY HEALTHY
//        HEALTHY HEALTHY HEALTHY HEALTHY
//        13
//        The first line of the output is the name of the travelers separated by a space. The following lines print the health condition of the day for each of the corresponding travelers above. For example, on the first day, John is HEALTHY, Lily is RECOVERING, Joanna is SICK, and Tim is RECOVERING. The last line is the number of days for all the travelers to become healthy or 365 if at least one of the travelers is still SICK or RECOVERING after one year.


import tree.Tree;

import java.util.*;

public class SickTravellersPalantir {
    public static void main(String [] args){
        SickTravellersPalantir sickTravellersPalantir = new SickTravellersPalantir();
        String [] initialStates = {"John HEALTHY Seattle London Seattle Berlin",
                                   "Lily RECOVERING Seattle Berlin",
                                   "Joanna SICK Berlin Berlin London Tokyo",
                                   "Tim RECOVERING Berlin London London Seattle"
                                  };
//        String [] initialStates = {"Wilson SICK PaloAlto DC London PaloAlto",
//                "Yun HEALTHY PaloAlto",
//                "Ali RECOVERING DC DC DC London",
//                "Jasmine HEALTHY London"
//        };

        for(String out : sickTravellersPalantir.traceDiseases(initialStates))
        System.out.println(out);
    }
    public String [] traceDiseases(String [] initialStates){
        List<String> finalStates = new ArrayList<>();
        Supervisor supervisor  =  new Supervisor();
        int MAX_DAYS = 365;
        for(String row : initialStates){
            String [] details = row.split(" ");
            Traveller traveller = new Traveller(details[0], details[1],
                    Arrays.copyOfRange(details, 2, details.length));
            supervisor.addTraveller(traveller);
        }
        finalStates.add(supervisor.getTravellersName());
        finalStates.add(supervisor.getTravellersStatus());
        while(!supervisor.checkIfAllTravellerHealthy() && finalStates.size()-1 < MAX_DAYS){
            supervisor.updateTravellerStatuses();
            finalStates.add(supervisor.getTravellersStatus());
        }
        finalStates.add(String.valueOf(finalStates.size()-1));
    return finalStates.toArray((new String[finalStates.size()]));
    }
    static class Traveller{
        private String name;
        private String healthStatus;
        private String [] locations;
        private int locationIndex=0;
        private String previousHealth;

        public Traveller(String name, String healthStatus, String [] locations) {
            this.name = name;
            this.healthStatus = healthStatus;
            this.locations = locations;
            previousHealth = healthStatus;
        }

        public void nextHeathState(boolean isLocationCompromised){
            previousHealth = healthStatus;
            if(getHealthStatus().equals("HEALTHY")){
                setHealthStatus(isLocationCompromised ? "SICK" : healthStatus);
            }
            else if(getHealthStatus().equals("RECOVERING")){
                setHealthStatus("HEALTHY");
            }
            else if(getHealthStatus().equals("SICK"))
            {
                setHealthStatus("RECOVERING");
            }
            locationIndex = (locationIndex+1) % locations.length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHealthStatus() {
            return healthStatus;
        }

        public void setHealthStatus(String healthStatus) {
            this.healthStatus = healthStatus;
        }

        public String[] getLocations() {
            return locations;
        }

        public String getLocation(){
            return locations[locationIndex];
        }

        public void setLocations(String[] locations) {
            this.locations = locations;
        }

        public String getPreviousHealth() {
            return previousHealth;
        }

        public void setPreviousHealth(String previousHealth) {
            this.previousHealth = previousHealth;
        }
    }

    static class Supervisor{
        private List<Traveller> travellers;
        public Supervisor(){
            travellers = new ArrayList<>();
        }

        public List<Traveller> getTravellers() {
            return travellers;
        }

        public void addTraveller(Traveller traveller){
            travellers.add(traveller);
        }
        public int getTotalTravellers(){
            return travellers.size();
        }

        public String getTravellersName(){
            StringBuilder stringBuilder = new StringBuilder();
            for (Traveller traveller : getTravellers()){
                stringBuilder.append(traveller.getName() + " ");
            }
            stringBuilder.setLength(stringBuilder.length()-1);
            return stringBuilder.toString();
        }

        public String getTravellersStatus(){
            StringBuilder stringBuilder = new StringBuilder();
            for (Traveller traveller : travellers){
                stringBuilder.append(traveller.getHealthStatus() + " ");
            }
            stringBuilder.setLength(stringBuilder.length()-1);
            return stringBuilder.toString();
        }

        public boolean checkIfAllTravellerHealthy(){
            for(Traveller traveller : getTravellers()){
                if(!traveller.getHealthStatus().equals("HEALTHY")){
                    return false;
                }
            }
            return true;
        }

        public Map<String, List<Traveller>> getLocationTravellersMap(){
            Map<String, List<Traveller>> map = new HashMap<>();
            for(Traveller traveller : travellers){
                if(!map.containsKey(traveller.getLocation())){
                    map.put(traveller.getLocation(), new ArrayList<>());
                }
                map.get(traveller.getLocation()).add(traveller);
            }
            return map;
        }
        public Map<String, String> getPersonStatus(){
            Map<String, String> map = new HashMap<>();
            for(Traveller traveller : travellers){
                map.put(traveller.getName(), traveller.healthStatus);
            }
            return map;
        }
        public void updateTravellerStatuses(){
            Map<String, List<Traveller>> locationTravellersMap = getLocationTravellersMap();
            Map<String, String> personHealth = getPersonStatus();
            for(Traveller traveller : travellers){
                traveller.nextHeathState(checkIfTravellersLocationIsCompromised(traveller, locationTravellersMap, personHealth));
            }
        }
        public boolean checkIfTravellersLocationIsCompromised(Traveller traveller, Map<String, List<Traveller>> locationTravellersMap, Map<String, String> personHealth){
            List<Traveller> travellersAtLocation = locationTravellersMap.get(traveller.getLocation());
            for(Traveller person : travellersAtLocation){
                if(person.equals(traveller)){
                    continue;
                }
                if(!personHealth.get(person.getName()).equals("HEALTHY")){
                    return true;
                }
            }
            return false;
        }
    }

}
