package Assignment;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class validateFileUpload {
WebDriver driver;
	
	@BeforeTest
	public void visitOnWebsite()throws InterruptedException {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String url="https://the-internet.herokuapp.com/upload";
		driver.get(url);
		driver.manage().window().maximize();
		
		
	}
	@Test
    public void testFileUpload() {
        String filePath = "C:\\Users\\krish\\Downloads\\SDET ASSIGNMENT _ Hack2skill.pdf"; // Replace this with the actual file path you want to upload
        File file = new File(filePath);
        String absolutePath = file.getAbsolutePath();

        WebElement fileInput = driver.findElement(By.id("file-upload"));
        fileInput.sendKeys(absolutePath);

        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement uploadSuccessMessage = driver.findElement(By.id("uploaded-files"));
        String uploadedFileName = uploadSuccessMessage.getText();
        System.out.println("File uploaded successfully: " + uploadedFileName);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
