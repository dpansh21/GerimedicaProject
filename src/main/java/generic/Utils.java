package generic;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Utils {
	
	public byte[] takeScreenshot(WebDriver driver,String fileName) throws IOException {
		String filePath = System.getProperty("user.dir")+"\\results\\screenshot\\"+fileName+".png";
		Screenshot screenshot = new AShot().takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "PNG", new File(filePath));
		byte[] fileContent = FileUtils.readFileToByteArray(new File(filePath));
		return fileContent;
	}
}
