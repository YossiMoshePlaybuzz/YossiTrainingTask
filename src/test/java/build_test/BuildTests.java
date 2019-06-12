package build_test;

import infrastructure.utils.MyListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;

@Listeners(MyListener.class)
public class BuildTests {
    public void Test07_Build() {
        Assert.assertTrue(false);
    }
}
