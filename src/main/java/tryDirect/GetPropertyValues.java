package tryDirect;

// import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class GetPropertyValues {
    String result = "";
    InputStream inputStream;

    public String getLogin() throws IOException {
        return getValues("login");
    }

    String getPassword() throws IOException {
        return getValues("password");
    }

    String getUrl() throws IOException {
        return getValues("url");
    }

    public String getLogPath() throws IOException {
        return getValues("logPath");
    }

    public String getLogAddresse()throws IOException{
        return getValues("logAddresse");
    }

    public String getGitLogin() throws IOException{
        return getValues("gitLogin");
    }

    public String getGitPassword() throws IOException{
        return getValues("gitPassword");
    }
//    void copyWebDriver() throws IOException {
//        ClassLoader classLoader = getClass().getClassLoader();
//        URL resource = classLoader.getResource("chromedriver");
////        File f = new File("Driver");
////        if (!f.exists()) {
////            f.mkdirs();
////        }
////        File chromeDriver = new File("Driver" + File.separator + "chromedriver");
//        File chromeDriver = new File("chromedriver");
//        if (!chromeDriver.exists()) {
//            chromeDriver.createNewFile();
//            assert resource != null;
//            //FileUtils.copyURLToFile(resource, chromeDriver);
//        }
 //   }

    private String getValues(String propertyName) throws IOException {
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            result = prop.getProperty(propertyName);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            assert inputStream != null;
            inputStream.close();
        }
        return result;
    }
}