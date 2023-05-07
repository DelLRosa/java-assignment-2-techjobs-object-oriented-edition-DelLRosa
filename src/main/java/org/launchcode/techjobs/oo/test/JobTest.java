package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertNotEquals(jobOne, jobTwo);
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob=new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertEquals("ACME",testJob.getEmployer().getValue());
//
        assertTrue(testJob.getLocation() instanceof Location);
        assertEquals("Desert", testJob.getLocation().getValue());

        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertEquals("Quality control", testJob.getPositionType().getValue());

        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());

        assertTrue(testJob.getName() instanceof String);
        assertEquals("Product tester", testJob.getName());
    }
    @Test
    public void testJobsForEquality(){
        Job testJobOne=new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJobTwo=new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(testJobOne.equals(testJobTwo));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job testJob=new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testToString=testJob.toString();
        int stringLength=testToString.length();
        assertEquals('\n',testToString.charAt(0));
        assertEquals('\n',testToString.charAt(stringLength-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testJob=new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testToString=testJob.toString();
        String expectedString="\n" +
                "ID: "+testJob.getId()+"\n" +
                "Name: "+testJob.getName()+"\n"+
                "Employer: "+testJob.getEmployer()+"\n" +
                "Location: "+testJob.getLocation()+"\n"+
                "Position Type: "+testJob.getPositionType()+"\n"+
                "Core Competency: "+testJob.getCoreCompetency()+"\n";
        assertEquals(expectedString,testToString);
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job testJob=new Job("", new Employer(""), new Location(""),
                new PositionType(""), new CoreCompetency(""));

        String testString=testJob.toString();
        String expectedString="\n" +
                "ID: "+testJob.getId()+"\n" +
                "Name: Data not available\n"+
                "Employer: Data not available\n" +
                "Location: Data not available\n"+
                "Position Type: Data not available\n"+
                "Core Competency: Data not available\n";
        assertEquals(expectedString,testString);


    };

}
