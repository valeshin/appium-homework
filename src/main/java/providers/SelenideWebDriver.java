package providers;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class SelenideWebDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        String appPath;

        if (Boolean.parseBoolean(System.getProperty("apk.remote"))) {
            appPath = downloadApk().getAbsolutePath();
        } else {
            appPath = SelenideWebDriver.class.getClassLoader().getResource(System.getProperty("app.name")).getPath();
        }

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName("Android");
        options.setDeviceName(System.getProperty("device.name", "otus"));
        options.setPlatformVersion(System.getProperty("platform.version", "5.1"));
        options.setApp(appPath);

        try {
            return new AndroidDriver(new URL(System.getProperty("driver.remote.url", "http://127.0.0.1:4723/wd/hub")), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    private File downloadApk() {
        File apk = new File("build/ApiDemos-debug.apk");
        if (!apk.exists()) {
            String url = System.getProperty("apk.link");
            try (InputStream in = new URL(url).openStream()) {
                copyInputStreamToFile(in, apk);
            }
            catch (IOException e) {
                throw new AssertionError("Failed to download apk", e);
            }
        }
        return apk;
    }
}
