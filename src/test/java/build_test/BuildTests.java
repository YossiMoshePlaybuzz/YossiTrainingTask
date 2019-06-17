package build_test;

import infrastructure.utils.MyListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListener.class)
public class BuildTests {
    @Test
    public void Test07_Build() {
        Assert.assertTrue(false);
    }
}
