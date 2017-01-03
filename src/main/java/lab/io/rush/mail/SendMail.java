package lab.io.rush.mail;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Properties;

/***
 * 
 * @author jd.zeng
 * @create date 2016年12月29日
 *
 */
@Component
public class SendMail {
	@Value("#{sys.emailaccount}")
    private String emailAccount;
	
	@Value("#{sys.emailpassword}")
    private String emailPassword;
	
	@Value("#{sys.emailsmtphost}")
    private String emailSMTPHost;
	
    /***
     *
     * @param session 和服务器交互的会话
     * @param sendMail 发件人邮箱
     * @param receiveMail 收件人邮箱
     * @return
     * @throws Exception
     */
    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(sendMail, "moana", "UTF-8"));
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "XX用户", "UTF-8"));
        message.setSubject("测试专用", "UTF-8");
        message.setContent("亲爱的用户你好, 你已购买电影票一张，感谢你的惠顾。", "text/html;charset=UTF-8");
        message.setSentDate(new Date());
        message.saveChanges();

        return message;
    }
    
    public  int sendMail(String mailAdress){

    	Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp"); 
        props.setProperty("mail.host", emailSMTPHost);     
        props.setProperty("mail.smtp.auth", "true");     

        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);                           

        try {
        	MimeMessage message = createMimeMessage(session, emailAccount, mailAdress);
        	Transport transport = session.getTransport();
            transport.connect(emailAccount, emailPassword);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            
            return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
           
    }

}
