package testsCases.ui_tests;

import infrastructure.utils.ui.BaseTest;
import infrastructure.utils.Groups;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.time.LocalDateTime;
import static org.testng.Assert.assertTrue;


public class LoadTests extends BaseTest {

    private long expectedLoadDurationInMili = 5000;

    @Test(groups =  {Groups.REGRESSION,Groups.ALL})
    public void Test01_LoadTimeGoogleSite() {
        LocalDateTime startTime = getNowTime();
        driver.get(url);  // driver has timout for load page
        LocalDateTime endTime = getNowTime();
        long actualLoadTimeInMili = difBetweenTimesInMili(startTime,endTime);
        assertTrue(actualLoadTimeInMili <= expectedLoadDurationInMili);
    }


    private LocalDateTime getNowTime(){
        return LocalDateTime.now();
    }

    private long difBetweenTimesInMili(LocalDateTime startTime, LocalDateTime endTime){
        return Duration.between(startTime, endTime).toMillis();
    }
}
