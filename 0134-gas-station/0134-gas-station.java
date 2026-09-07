class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;
        int totalCost = 0;

        for(int i = 0; i < gas.length; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }

        // impossible
        if(totalGas < totalCost)
            return -1;


        int start = 0;
        int fuel = 0;

        for(int i = 0; i < gas.length; i++){

            fuel += gas[i] - cost[i];

            // cannot start from this station
            if(fuel < 0){
                start = i + 1;
                fuel = 0;
            }
        }

        return start;
    }
}