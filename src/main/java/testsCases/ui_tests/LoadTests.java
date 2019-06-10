package testsCases.ui_tests;

import infrastructure.utils.ui.BaseTest;
import infrastructure.utils.ui.Groups;
import org.testng.annotations.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.testng.Assert.assertTrue;

public class LoadTests extends BaseTest {

    @Test(groups =  {Groups.BROWSER_FIREFOX})
    public void test01_LoadTimeGoogleSite() throws ParseException {
        startTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        driver.get(url);
        endTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        long diffInMillies = Math.abs(format.parse(endTime).getTime() - format.parse(startTime).getTime());
        assertTrue(diffInMillies<=1000);
    }
}
