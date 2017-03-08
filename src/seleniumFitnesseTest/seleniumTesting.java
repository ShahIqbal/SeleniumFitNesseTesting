package seleniumFitnesseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class seleniumTesting {
		
		
		public String URL;
		
		public void setURL(String URL){
			this.URL = URL;
		}
		
		public String getURL(){
			return this.URL;
		}
		

	    
	    public boolean canLinkOpen(){
	    	WebDriver x = new ChromeDriver();
	    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
	    	
	    	x.get("http://" + getURL());
	    	
	    	x.close();
	    	
	    	return true;
	    }
		    
		   
		

		
		
		
		//Method to check if item has been added to the amazon cart
		public boolean hasItemBeenAdded() throws InterruptedException{
			
			String os = System.getProperty("os.name").toLowerCase();
			
			
			
			
			
			
			//download chromedriver for macbook
			
			if(os.contains("mac")) System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
			
			//Download chromedriver.exe for windows
			
			else System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
			
			//Create Google Chrome Driver to drive the browser
			
			WebDriver driver = new ChromeDriver();
			
			//Open Amazon Home Page
			
			
			
			driver.manage().window().maximize();
			
			
			
			driver.get("http://" + getURL());
			
			
			//Clicks add to cart
			
			String cartItemTotalBefore = driver.findElement(By.id("nav-cart-count")).getText();
			int beforeItemAdd = Integer.parseInt(cartItemTotalBefore);
			
			Thread.sleep(2000);
			driver.findElement(By.id("add-to-cart-button")).click();
			
			
			
			
			
			String cartItemTotalAfter = driver.findElement(By.id("nav-cart-count")).getText();
			//System.out.println(cartItemTotal);
			
			int afterItemAdd = Integer.parseInt(cartItemTotalAfter);
			
			Thread.sleep(2000);
			
			driver.close();
			
			if(afterItemAdd > beforeItemAdd){
				return true;
			} else {
				return false;
			}
		}
		
		
		public boolean hasItemAddedForUserSizeSelection() throws InterruptedException{
			
			String os = System.getProperty("os.name").toLowerCase();
			
			
			
			
			
			
			//download chromedriver for macbook
			
			if(os.contains("mac")) System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
			
			//Download chromedriver.exe for windows
			
			else System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
			
			//Create Google Chrome Driver to drive the browser
			
			WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.get("http://" + getURL());
			
			Select select = new Select(driver.findElement(By.id("native_dropdown_selected_size_name")));
	        select.selectByIndex(1);
	        
	        while(select.getFirstSelectedOption().equals("Select")) {
	            //wait until elements load
	        }
	        
	        
	        String cartItemTotalBefore = driver.findElement(By.id("nav-cart-count")).getText();
			int beforeItemAdd = Integer.parseInt(cartItemTotalBefore);
			
			Thread.sleep(2000);
			driver.findElement(By.id("add-to-cart-button")).click();
			
			
			
			
			
			String cartItemTotalAfter = driver.findElement(By.id("nav-cart-count")).getText();
			//System.out.println(cartItemTotal);
			
			int afterItemAdd = Integer.parseInt(cartItemTotalAfter);
			
			Thread.sleep(2000);
			driver.close();
			
			if(afterItemAdd > beforeItemAdd){
				return true;
			} else {
				return false;
			}
	        
			
		}
		
		public boolean itemNotAdded() throws InterruptedException{
			
			String os = System.getProperty("os.name").toLowerCase();
			
			//download chromedriver for macbook
			
			if(os.contains("mac")) System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
			
			//Download chromedriver.exe for windows
			
			else System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
			
			//Create Google Chrome Driver to drive the browser
			
			WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.get("http://" + getURL());
			
			
			
			String currentURL = driver.getCurrentUrl().toString();
			
			Thread.sleep(2000);
			driver.close();
			
			if(currentURL.equals("https://" + getURL())){
				return true;
			} else {
				return false;
			}
			
			
			
			
		}
		
		
}

