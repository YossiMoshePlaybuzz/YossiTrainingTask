package testsCases.ui_tests;

import infrastructure.utils.MyListener;
import infrastructure.utils.ui.BaseTest;
import infrastructure.utils.Groups;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.testng.Assert.assertTrue;

@Listeners(MyListener.class)
public class LoadTests extends BaseTest {

    private static SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    private static String startTime;
    private static String endTime;

    @Test(groups =  {Groups.REGRESSION})
    public void test01_LoadTimeGoogleSite() throws ParseException {
        startTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        driver.get(url);
        endTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        long diffInMillies = Math.abs(format.parse(endTime).getTime() - format.parse(startTime).getTime());
        assertTrue(diffInMillies<=2000);
    }
}
