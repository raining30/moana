package lab.io.rush.test;

import lab.io.rush.base.SpringTestCase;
import lab.io.rush.mail.SendMail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ComponentTest extends SpringTestCase{
	@Value("#{sys.emailaccount}")
    private String emailAccount;
	
	@Value("#{sys.emailpassword}")
    private String emailPassword;
	
	@Value("#{sys.emailsmtphost}")
    private String emailSMTPHost;
	
	@Autowired
	private SendMail sendMail;
	
	//@Test
	public void test(){
		System.out.println(emailAccount);
		System.out.println(emailPassword);
		System.out.println(emailSMTPHost);
	}
	
	@Test
	public void sendEmail(){
		//SendMail sendMail = new SendMail();
		try {
			sendMail.sendMail("jdzeng@qq.com");
			System.out.println("success!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
