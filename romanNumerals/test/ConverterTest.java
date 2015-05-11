import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

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
    	"9, IX"})
    public void testConvertToRomanOneToNine(Integer arabic, String expectedRoman) {
        String output = Converter.convertToRoman(arabic);
        assertThat(output, equalTo(expectedRoman));
    }

    @Test
    @Parameters({
    	"10, X",
    	"20, XX", 
    	"30, XXX", 
    	"200, CC", 
    	"300, CCC", 
    	"2000, MM", 
    	"3000, MMM"
    	})
    public void testConvertToRomanSimpleRepeats(Integer arabic, String expectedRoman) {
        String output = Converter.convertToRoman(arabic);
        assertThat(output, equalTo(expectedRoman));
    }

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
    	"19, XIX"})
    public void testConvertToRomanSecondDecade(Integer arabic, String expectedRoman) {
        String output = Converter.convertToRoman(arabic);
        assertThat(output, equalTo(expectedRoman));
    }

    @Test
    @Parameters({
    	"1990, MCMXC",
    	"2008, MMVIII",
    	"99, XCIX",
    	"47, XLVII"})
    public void testConvertToRomanDifficult(Integer arabic, String expectedRoman) {
        String output = Converter.convertToRoman(arabic);
        assertThat(output, equalTo(expectedRoman));
    }

    @Test(expected=IllegalArgumentException.class)
    public void negative_arabic_numerals_should_not_be_supported() {
        Converter.convertToRoman(-1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void bigger_arabic_numerals_should_not_be_supported() {
        Converter.convertToRoman(4000);
    }
}
