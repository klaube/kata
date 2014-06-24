package pinetree;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import static junit.framework.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testHoeheSollteGespeichertWerden()
    {
    	App.tannenbaum(5);
    	
        assertEquals(5, App.getHoehe());
    }
    
    public void testSternSollteGespeichertWerden()
    {
    	App.tannenbaum(5, true);
    	
    	assertEquals(true, App.hasStern());
    }
    
    public void testZeichneZweiX()
    {
    	App.tannenbaum(2);
    	String printOut = App.getPrintOut();
    	System.out.println(printOut);
    	assertEquals(" X\nXXX\n H", printOut);
    }
    
    public void testZeichneFuenfReihenOhneStern()
    {
    	App.tannenbaum(5);
    	String printOut = App.getPrintOut();
    	System.out.println(printOut);
    	assertEquals("    X\n   XXX\n  XXXXX\n XXXXXXX\nXXXXXXXXX\n    H", App.getPrintOut());
    }
    
    public void testZeichneFuenfReihenMitStern()
    {
    	App.tannenbaum(5, true);
    	String printOut = App.getPrintOut();
    	System.out.println(printOut);
    	assertEquals("    *\n    X\n   XXX\n  XXXXX\n XXXXXXX\nXXXXXXXXX\n    H", App.getPrintOut());
    }
}
