package com.bassem.java_assignment_02;

public class ElevatorWeightChecker {
    public static String checkWeightLimit(double weightLimit,double[] passengerW){
                  // Count all weight of passenger and report in result by cases
        double totalWeight = 0;
        String res ="";

        for(int i= 0; i< passengerW.length; i++){

            totalWeight += passengerW[i];
            // if reach to Limit weight or more add to result and send msg then exit
            if(totalWeight >= weightLimit){

                res = "Passenger " + (i+1) + ": "+ "Weight Exceed ..overload by Total weight point at: "
                        + totalWeight + "lbs";
                break;

            }
        }
        // total wight safe that why result still empty case is safe
        if (res.isEmpty()){
            res ="All passengers boarded safely. total Weight:"
                    +totalWeight + "lbs";
        }
        return res;

    }
}
