package ep2.teamaufgabe.Test;

public class TestStructurResult implements Comparable<TestStructurResult> {
    private String name;
    private double averageExecutionTime;
    private double initTime;
    private Object[] testResultValues;
    private TestInput[] testInputs;
    private int count;

    public TestStructurResult(String name, int testInputsCount, TestInput[] testInputs) {
        this.name = name;
        this.testResultValues = new Object[testInputsCount];
        this.count = 0;
        this.testInputs = testInputs;
    }

    public void addResultValue(Object testResult) {
        this.testResultValues[this.count++] = testResult;
    }

    public void setInitTime(double initTime) {
        this.initTime = initTime;
    }

    public void setAverageExecutionTime(double averageExecutionTime) {
        this.averageExecutionTime = averageExecutionTime;
    }

    public double getAverageExecutionTime() {
        return averageExecutionTime;
    }


    public boolean compareTestResults(TestStructurResult r) {
        if (r == null) {
            return false;
        }

        if (this.testResultValues.length != r.testResultValues.length) {
            System.out.println("Testresults unterschiedlicher Länge!");
            return false;
        }

        for (int i = 0; i < r.testResultValues.length; i++) {
            boolean isEqual = this.testResultValues[i].toString().equals(r.testResultValues[i].toString());

            if (!isEqual) {

                System.out.println(" \n Unequal at " + i + ". Testinput" + this.name + " compared to " + r.name);
                System.out.println(this.testResultValues[i].toString() + " is not Equal " + r.testResultValues[i].toString());
                System.out.println("Testinput " + this.testInputs[i].toString() + "\n");
                return false;
            }
        }

        return true;
    }

    @Override
    public int compareTo(TestStructurResult o) {
        return (int) (this.averageExecutionTime - o.averageExecutionTime);
    }

    @Override
    public String toString() {
        return this.name + " Averagetime : " + this.averageExecutionTime + " Inittime : " + this.initTime;
    }
}


