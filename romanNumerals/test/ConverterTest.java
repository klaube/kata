import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author egga, Katharina Laube
 */
@RunWith(JUnitParamsRunner.class)
public class ConverterTest {

    @Test
    @Parameters({
    	"1, I", 
    	"2, II", 
    	"3, III", 
    	"4, IV", 
    	"5, V", 
    	"6, VI", 
    	"7, VII",
    	"8, VIII",
    	"9, IX",
    	"10, X"})
    public void testConvertToRoman(Integer arabic, String expectedRoman) {
        String output = Converter.convertToRoman(arabic);
        assertThat(output, equalTo(expectedRoman));
    }

    @Ignore
    @Test
    @Parameters({
    	"11, XI", 
    	"12, XII", 
    	"13, XIII", 
    	"14, XIV", 
    	"15, XV", 
    	"16, XVI", 
    	"17, XVII",
    	"18, XVIII",
    	"19, XIX",
    	"20, XX"})
    public void testConvertToRomanFirstDecade(Integer arabic, String expectedRoman) {
        String output = Converter.convertToRoman(arabic);
        assertThat(output, equalTo(expectedRoman));
    }
}
