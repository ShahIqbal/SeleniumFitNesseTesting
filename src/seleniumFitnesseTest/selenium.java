package seleniumFitnesseTest;

public class selenium {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		seleniumTesting test = new seleniumTesting();
		test.setURL("www.amazon.ca/Russell-Athletic-T-Shirt-Heather-Medium/dp/B0071A05UC/ref=sr_1_10?ie=UTF8&qid=1488570199&sr=8-10&keywords=tshirts");
		System.out.println(test.hasItemAddedForUserSizeSelection());
	}

}
