    public static String maxWeightLimit(int weightLimit, int[]passengerWeight){
        if(passengerWeight==null||passengerWeight.length==0){
            return "Elevator is empty";
        }
        int weightSum =0;
        int count =0;
        for(int number:passengerWeight){
            count++;
            weightSum +=number;
            if(weightSum>=weightLimit){
                return "Passenger "+count+" caused an overload. Total weight at that point:"
                        +weightSum+" No further loading";
            }
        }
        return"All passengers boarded safely. Total weight:"+weightSum+" lbs.";
    }

    public static String maxPassengerLimit(int weightLimit, int[]passengerWeight){
        if(passengerWeight==null||passengerWeight.length==0){
            return "Elevator is empty";
        }
        Arrays.sort(passengerWeight);
        int weightSum =0;
        int count =0;
        for(int number:passengerWeight){
            count++;
            weightSum +=number;
            if(weightSum>=weightLimit){
                int safeCount = count -1;
                int safeWeight = weightSum - number;
                return "Max safe passenger count: "+safeCount+" Total weight: "+safeWeight+" lbs.";
            }
        }
        return"All passengers boarded safely. Total weight:"+weightSum+" lbs.";
    }

    public static String HeaviestAndLightestPassengers(int weightLimit, int[]passengerWeight){
        if(passengerWeight==null||passengerWeight.length==0){
            return "Elevator is empty";
        }
        int lightestPassengerWeight = passengerWeight[0];
        int heaviestPassengerWeight = passengerWeight[0];
        int weightSum =0;
        int count =0;
        for(int number:passengerWeight){
            count++;
            weightSum +=number;
            if(number<lightestPassengerWeight){
                lightestPassengerWeight=number;
            }
            if(number>heaviestPassengerWeight){
                heaviestPassengerWeight=number;
            }
            if(weightSum>=weightLimit){
                return "Passenger " + count + " caused an overload. Total weight at that point: " + weightSum + " lbs. No further loading. "
                        + "Lightest passenger: " + lightestPassengerWeight + " lbs. Heaviest passenger: " + heaviestPassengerWeight + " lbs.";
            }
        }
        return "All passengers boarded safely. Total weight: " + weightSum + " lbs. "
                + "Lightest passenger: " + lightestPassengerWeight + " lbs. Heaviest passenger:" +
                " " + heaviestPassengerWeight + " lbs.";
    }

    public static String multipleElevatorTrips(int weightLimit, int[]passengers) {
        if (passengers.length == 0) {
            return "Elevator is empty";
        }
        int weightSum =0;
        int count =0;
        int tripCount =0;
        for(int number:passengers){
            count++;
            weightSum +=number;
           if(weightSum>=weightLimit){
                tripCount++;
                weightSum = number;
            }
        }
        if(weightSum>0){
            tripCount++;
        }
        String result ="Trip count:"+tripCount+" Passengers on Trip"+count;
        return result;
    }