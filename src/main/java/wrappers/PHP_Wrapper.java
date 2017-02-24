package wrappers;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.monte.media.Format;
import org.monte.screenrecorder.ScreenRecorder;

import org.monte.media.math.Rational;

import static org.monte.media.VideoFormatKeys.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;



import basket.DataInputProvider;



public class PHP_Wrapper extends GenericWrappers {
	
	public String browserName;
	public String dataSheetName,LoginAS;
	boolean bRemote;
	public String mail;
	public static int index, number;
	private ScreenRecorder screenRecorder;
	Random ran = new Random();
	int randomNumber = ran.nextInt(20) + 1;
	
	DateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
	Date date = new Date();
	String currentdate = dateformat.format(date);
	


	@BeforeSuite
	public void beforeSuite() throws Exception{
		startRecording();
		startResult();
	}

	
	
	@BeforeMethod
	public void beforeMethod(){
		test = startTestCase(testCaseName, testDescription);
		test.assignCategory(category);
		test.assignAuthor(authors);
		invokeApp(browserName,LoginAS);
	}
		
	@AfterSuite
	public void afterSuite() throws Exception{
		stopRecording();
		reportSending();
		endResult();
	}

	
	
	@AfterMethod
	public void afterMethod(){
		endTestcase();
		quitBrowser();
		
	}
	
	@DataProvider(name="fetchData")
	public Object[][] getData(){
		return DataInputProvider.getSheet(dataSheetName);		
	}	
	public String generateUniqueMailIDs()
	{
	
		int size = 20;
        ArrayList<Integer> list = new ArrayList<Integer>(size);
        for(int i = 1; i <= size; i++) {
            list.add(i);
        }

        Random rand = new Random();
        while(list.size() > 0) {
            index = rand.nextInt(list.size());
            number=list.remove(index);
        }
        
        mail="userRole"+number+"@phptravel.com";
        //System.out.println("Mail id:"+mail);
        return mail;
	}
	
	public void startRecording() throws Exception
	{
	    GraphicsConfiguration gc = 
	    		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

	    screenRecorder = new ScreenRecorder(gc,
	            gc.getBounds(),
	            new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
	            new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
	                    CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
	                    DepthKey, 24, FrameRateKey, Rational.valueOf(15),
	                    QualityKey, 1.0f,
	                    KeyFrameIntervalKey, 15 * 60),
	            new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
	            null,
	            new File("./PHP_Videos"));
	    screenRecorder.start();
	}

	public void stopRecording() throws Exception
	{
	    this.screenRecorder.stop();
	}
	
	public void reportSending ()
	{
		 final String EmailUser = "vigneshmohan718@gmail.com";
		    final String EmailPassword = "vendantamil";

		    Properties props =  new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.connectiontimeout", "10000");

			

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
					  protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
							EmailUser,EmailPassword);
					     }
				   });

		// Recipient Email ID
		String to =    "Vignesh.Mohan@gsr-inc.com";
		           //"Satheeshkanth.Paramasivam@gsr-inc.com";
		
		// Recipient CC Email ID
				String CC = "Vignesh.Mohan@gsr-inc.com";
				
		
		// Sender Email ID
		String from = "vigneshmohan718@gmail.com";
		
		//Sending Email from local host
		
		
		
		try {
			session.setDebug(true);	
			// To create a default MIME message 
			MimeMessage message = new MimeMessage(session);
			
			// Set From: Message field of the header
			message.setFrom(new InternetAddress(from));
			
			// Set To: Message field of the header
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			// Set To: Message field of the header
						message.addRecipient(Message.RecipientType.CC, new InternetAddress(CC));
			// Set Subject: header field
			message.setSubject("PHP Travels  Report for Test Run #"+randomNumber+", dated on "+currentdate);
			
			 // Create the message part 
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Fill the message
	         messageBodyPart.setText("Hi Satheesh," +"\n\n"+ "Please find the attached report of PHP Travels for Test Run #"+randomNumber+", dated on "+currentdate+"." +"\n\n\n\n"+"Thanks!");

	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	         String filename = "./reports/result.html";
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         message.setContent(multipart );

	         // Send message
	       //  Transport.send(message);
	         
	         
	         Transport transport = session.getTransport("smtp");
	     	transport.connect();
	     	transport.sendMessage(message, message.getAllRecipients());
	     	System.out.println("Message sent successfully....");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}







