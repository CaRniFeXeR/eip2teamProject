package ep2.teamaufgabe.Test;

import ep2.teamaufgabe.DataReader;
import ep2.teamaufgabe.Datastructure;

import java.util.ArrayList;

public class Tester {
    private double lastStartTime;

    //region [Public Methods]

    public void testAndComparePerofrmance(ArrayList<Datastructure> testStructures, String dataInputFile, boolean checkResultIsEqual) {
        this.testAndComparePerformance(testStructures, Tester.generateTestinput(), dataInputFile, checkResultIsEqual);
    }

    private void testAndComparePerformance(ArrayList<Datastructure> testStructures, ArrayList<TestInput> testInstructions, String dataInputFile, boolean checkResultIsEqual) {
        int allStructCount = testStructures.size();
        int allTestInputsCount = testInstructions.size();
        ArrayList<TestStructurResult> structurResults = new ArrayList<TestStructurResult>();

        System.out.println("**Testing Datastructure perfomance**");
        System.out.println("Testing " + allStructCount + "Datastrutures with " + allTestInputsCount + " Testinputs");

        int structCount = 0;

        for (Datastructure struct : testStructures) {

            TestStructurResult currenResult = new TestStructurResult(struct.getName(), allTestInputsCount);

            System.out.println("Testing " + struct.getName());

            this.startTimeMessure();
            DataReader.ReadData(struct, dataInputFile);

            double readingExetime = this.getExecutionTime();
            currenResult.setInitTime(readingExetime);
            System.out.println("Reading Executiontime : " + readingExetime);

            double[] executionTimes = new double[allTestInputsCount];

            int testInputCount = 0;

            for (TestInput input : testInstructions) {
                this.startTimeMessure();
                currenResult.addResultValue(input.runMethod(struct));
                executionTimes[testInputCount++] = this.getExecutionTime();
            }

            currenResult.setAverageExecutionTime(averageExecutionTime(executionTimes));
            structurResults.add(currenResult);
            System.out.println("AverageExecutionTime " + currenResult.getAverageExecutionTime());
        }

        if (checkResultIsEqual) {

        }

        structurResults.sort(new TestStrucuturResultComperator());

        System.out.println("*****RESULTS******");

        for (int i = 0; i < allStructCount; i++) {
            System.out.println("" + (i + 1) + "." + structurResults.get(i));

            if (checkResultIsEqual && i + 1 < allStructCount) {
                if (!structurResults.get(i).compareTestResults(structurResults.get(i + 1))) {
                    System.out.println("Testresults of " + structurResults.get(i) + " not equal " + structurResults.get(i + 1));
                }
            }
        }
    }

    public static ArrayList<TestInput> generateTestinput() {
        ArrayList<TestInput> testInputs = new ArrayList<TestInput>();

        for (int i = 1; i < 100; i++) {
            double r = (i * Math.random() * 200 + 1) % 50;
            int n = (int) (i * Math.random() * 50) % 20;

            testInputs.add(new TestInput(r, n));
        }

        return testInputs;
    }

    //endregion


    //region [private Helper]

    private static double averageExecutionTime(double[] executionTimes) {
        int count = executionTimes.length;

        if (count == 0) {
            return 0.0;
        }

        double sum = 0.0;

        for (double exeTime : executionTimes) {
            sum += exeTime;
        }

        return sum / count;

    }

    private void startTimeMessure() {
        this.lastStartTime = System.currentTimeMillis();
    }

    private double getExecutionTime() {
        double time = System.currentTimeMillis() - this.lastStartTime;

        this.lastStartTime = 0;

        return time;
    }

    //endregion
}
