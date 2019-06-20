package main;

import org.testng.TestNG;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private  static TestNG runner = new TestNG();

    public static void main(String[] args) {
        System.setProperty("url",args[0]);
        String testSuite = args[1];

        //System.setProperty("url","https://www.google.com/");
        //String testSuite = "smoke";

        List<String> suitefiles = new ArrayList<String>();
        suitefiles.add("C:\\YossiTrainingTask\\testng\\" + testSuite + ".xml");

        runner.setTestSuites(suitefiles);
        runner.run();
    }
}
