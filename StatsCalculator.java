import java.util.Arrays;
/**
 * @file StatsCalculator.java
 * @Date 3/17/23
 * @Author Sneha Amudhan
 *
 * @Description Identifies and sorts wanted array then finds minimum, maximum, median, mean first quartile, and third quartile
 *
 */
public class StatsCalculator {
    /**
     * @description creates double array of values
     */
    private double[] values;
    /**
     * @description creates double array of sorted values
     */
    private double[] sortedValues;
    /**
     * @description creates array size of 20 full of zeros
     */
    public StatsCalculator() {
        double values[] = new double[20];

    }
    /**
     * @description sets instance variable to the parameter
     */
    public StatsCalculator(double[] values) {
        this.values = values;
    }
    /**
     * @description Sorts the given data
     */
    public void sortData() {
        sortedValues = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            sortedValues[i] = values[i];
        }
    }
    /**
     * @description finds the maximum value in array
     * @returns maximum value of the array
     */
    public double calculateMax() {
        double max = sortedValues[0];
    for(int i = 0; i < sortedValues.length; i++){
        if(sortedValues[i] > sortedValues[i+1]){
            max = sortedValues[i];
        }
        else{
            i++;
        }
    }
    return max;
    }
    /**
     * @description finds the minimum value in array
     * @return minimum value of the array
     */
    public double calculateMin(){
        double min = sortedValues[0];
        for(int i = 0; i < sortedValues.length; i++){
            if(sortedValues[i] < sortedValues[i+1]){
                min = sortedValues[i];
            }
            else{
                i++;
            }
        }
        return min;
    }
    /**
     * @description finds the first quartile of the sorted array
     * @return first quartile
     */
    public double calculateFirstQuartile(){
        double fQuartile;
        int divFour = sortedValues.length / 4;
        if(sortedValues.length % 4 == 0) {
            fQuartile = (sortedValues[divFour - 1] + sortedValues[divFour])/2;
        }
        else if(sortedValues.length % 2 == 0) {
            fQuartile = (sortedValues[divFour]);
        }

        else{
            fQuartile = (sortedValues[divFour]);
        }
        return fQuartile;
    }
    /**
     * @description finds the third quartile of the sorted array
     * @return third quartile
     */
    public double calculateThirdQuartile() {
        double tQuartile;
        int divFour = sortedValues.length / 4;
        int divTwo = sortedValues.length / 2;

        if (sortedValues.length % 4 == 0) {
            tQuartile = (sortedValues[(divFour) + (divTwo) - 1] + sortedValues[(divFour) + (divTwo)]) / 2;
        } else if (sortedValues.length % 2 == 0) {
            tQuartile = sortedValues[(divFour) + (divTwo)];
        } else {
            tQuartile = sortedValues[(divFour) + (divTwo) + 1];
        }

        return tQuartile;
    }
    /**
     * @description finds the median of the sorted array
     * @return median
     */
    public double calculateMedian(){
        double median = 0;

        if(sortedValues.length % 2 == 0){

            int mid = sortedValues.length / 2;

            median = ((sortedValues[mid] + sortedValues[ mid - 1]) / 2.0);
        }
        else{
            median =  sortedValues[sortedValues.length / 2];
        }
        return median;
    }
    /**
     * @description calculates the sum of the array
     * @return sum
     */
    public double calculateSum(){
    double sum = 0.0;
    for(int i = 0; i < sortedValues.length; i++){
        sum += sortedValues[i];
    }
    return sum;
}
    /**
     * @description calculates the mean of the array
     * @return mean
     */
    public double calculateMean(){
            int sum = 0;
            double ave = 0;
            for( double num: sortedValues){
                sum += num;
            }
            ave = (double) sum / values.length;
            return ave;
        }

    /**
     * @description prints the call and return of the array with comma in between
     */
    public void print() {
        for (double val : values) {
            System.out.println(val + ", ");
        }
    }
    /**
     * @description prints the call and return of the sorted array with comma in between
     */
        public void printSorted(){
            Arrays.sort(sortedValues);

            for (double val : values) {
                System.out.println(val + ", ");
            }
        }
    /**
     * @description prints out five number summary which include Minimum, First Quartile, Median, Third Quartile, and Maximum
     */
        public void printFiveNumberSummary(){
            System.out.println("Minimum: " + calculateMin());
            System.out.println("First Quartile: " + calculateFirstQuartile());
            System.out.println("Median: " + calculateMedian());
            System.out.println("Third Quartile: " + calculateThirdQuartile());
            System.out.println("Max: " + calculateMax());
        }
    }