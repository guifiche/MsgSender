package br.com.primarr.msg;

import junit.framework.JUnit4TestAdapter;

import org.junit.Assert;
import org.junit.Test;

import br.com.primarr.msg.MessagingManager;
import br.com.primarr.msg.body.HtmlBody;
import br.com.primarr.msg.body.TextBody;
import br.com.primarr.msg.body.builder.PostBuilder;
import br.com.primarr.msg.email.ApacheCommonsMailService;
import br.com.primarr.msg.email.EmailAddress;
import br.com.primarr.msg.email.EmailBody;
import br.com.primarr.msg.email.EmailTemplate;
import br.com.primarr.msg.email.MailService;
import br.com.primarr.msg.email.SmtpServer;
import br.com.primarr.msg.mock.ApacheCommonsMockMailService;

/*
 * <?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN"
                       "http://www.springframework.org/dtd/spring-beans.dtd">
<beans>
 <bean class="comticket.model.business.logic.ComTicketMailService" id="mailService">
  <property name="srvSmtp">
   <value>${mail.smtp}</value>
  </property>
  <property name="user">
   <value>${mail.username}</value>
  </property>
  <property name="passwd">
   <value>${mail.password}</value>
  </property>
  <property name="tpEmail">
   <value>${mail.tipo}</value>
  </property>
 </bean>
 
 <!-- Definição do gerenciador de e-mail -->
 <bean class="comticket.utils.email.PostEmailSender" id="emailSender">
  <property name="mailService">
   <ref bean="mailService"/>
  </property>
 </bean>
 
 <bean class="comticket.utils.email.EmailManager" id="emailManagerDef">
  <property name="emailSender">
   <ref bean="emailSender"/>
  </property>
  <property name="mailAddressTestList">
  	<list>
  		<value>gfiche@ig.com.br</value>  		
  	</list>
  </property>
  <property name="mapaEmailPadrao">
   <map>    
    <entry key="EmailTemplate">
     <ref bean="emailTemplate"/>
    </entry>
    <entry key="EmailVerifyEmail">
     <ref bean="emailVerifyEmail"/>
    </entry>
    <entry key="EmailService">
     <ref bean="emailService"/>
    </entry>
    <entry key="EmailPayment">
     <ref bean="emailPayment"/>
    </entry>
    <entry key="EmailRegister">
     <ref bean="emailRegister"/>
    </entry>
    <entry key="EmailRegisterVerified">
     <ref bean="emailRegisterVerified"/>
    </entry>
    <entry key="EmailInvitation">
     <ref bean="emailInvitation"/>
    </entry>
    <entry key="EmailNewPassword">
     <ref bean="emailNewPassword"/>
    </entry>
    <entry key="EmailMemberReceivedRequest">
     <ref bean="emailMemberReceivedRequest"/>
    </entry>
    <entry key="EmailNotMemberReceivedRequest">
     <ref bean="emailNotMemberReceivedRequest"/>
    </entry>
    <entry key="EmailMemberReceivedPayment">
     <ref bean="emailMemberReceivedPayment"/>
    </entry>
    <entry key="EmailNotMemberReceivedPayment">
     <ref bean="emailNotMemberReceivedPayment"/>
    </entry>
    <entry key="EmailResendTransferWarn">
     <ref bean="emailResendTransferWarn"/>
    </entry>
    <entry key="EmailNotificationFailure">
     <ref bean="emailNotificationFailure"/>
    </entry>
    <entry key="EmailChangeStatus">
     <ref bean="emailChangeStatus"/>
    </entry>
    <entry key="EmailChargebackPayor">
     <ref bean="emailChargebackPayor"/>
    </entry>
    <entry key="EmailChargebackPayee">
     <ref bean="emailChargebackPayee"/>
    </entry>
    <entry key="EmailInAnalysis">
     <ref bean="emailInAnalysis"/>
    </entry>
   </map>
  </property>
 </bean>
 
 
 <!-- Definição dos e-mails -->
  <bean class="comticket.utils.email.EmailInformation" id="emailTemplate">
  <property name="from">
   <value>moip@moip.com.br</value>
  </property>
  <property name="subject">
   <value>Informativo MoIP</value>
  </property>
  <property name="replaceHtmlCharacters">
   <value>true</value>
  </property>
  <property name="body">
   <value>
#{recipient},
#{BR}
#{BR}
#{bodyEmail}
#{BR}
#{BR}
Av. Afonso Pena, 4000 - 3º andar - Cruzeiro.#{BR}
Belo Horizonte - MG#{BR}
   </value>
  </property>
  <property name="postUrl">
   <value>${mail.baseUrl}/email/emailTemplate.jsp</value>
  </property>
 </bean>
 
  <bean class="comticket.utils.email.EmailInformation" id="emailVerifyEmail">
  <property name="from">
   <value>moip@moip.com.br</value>
  </property>
  <property name="subject">
   <value>Verificar e-mail</value>
  </property>
  <property name="replaceHtmlCharacters">
   <value>true</value>
  </property>
  <property name="body">
   <value>
#{recipient},
#{BR}
#{BR}
#{bodyEmail}
#{BR}
#{BR}
Av. Afonso Pena, 4000 - 3º andar - Cruzeiro.#{BR}
Belo Horizonte - MG#{BR}
   </value>
  </property>
  <property name="postUrl">
   <value>${mail.baseUrl}/email/emailVerifyEmail.jsp</value>
  </property>
 </bean>
 
  <bean class="comticket.utils.email.EmailInformation" id="emailService">
  <property name="from">
   <value>moip@moip.com.br</value>
  </property>
  <property name="subject">
   <value>Transacao MoIP Realizada</value>
  </property>
  <property name="replaceHtmlCharacters">
   <value>true</value>
  </property>
  <property name="body">
   <value>
#{recipient},
#{BR}
#{BR}
#{bodyEmail}
#{BR}
#{BR}
Av. Afonso Pena, 4000 - 3º andar - Cruzeiro.#{BR}
Belo Horizonte - MG#{BR}
   </value>
  </property>
  <property name="postUrl">
   <value>${mail.baseUrl}/email/emailService.jsp</value>
  </property>
 </bean>
 
  <bean class="comticket.utils.email.EmailInformation" id="emailPayment">
  <property name="from">
   <value>moip@moip.com.br</value>
  </property>
  <property name="subject">
   <value>Pagamento realizado</value>
  </property>
  <property name="replaceHtmlCharacters">
   <value>true</value>
  </property>
  <property name="body">
   <value>
#{recipient},
#{BR}
#{BR}
#{bodyEmail}
#{BR}
#{BR}
Av. Afonso Pena, 4000 - 3º andar - Cruzeiro.#{BR}
Belo Horizonte - MG#{BR}
   </value>
  </property>
  <property name="postUrl">
   <value>${mail.baseUrl}/email/emailPayment.jsp</value>
  </property>
 </bean>
 
  <bean class="comticket.utils.email.EmailInformation" id="emailRegister">
  <property name="from">
   <value>moip@moip.com.br</value>
  </property>
  <property name="subject">
   <value>Sua Carteira MoIP foi criada</value>
  </property>
  <property name="replaceHtmlCharacters">
   <value>true</value>
  </property>
  <property name="body">
   <value>
#{recipientName}, #{BR}
seja bem vindo ao mundo MoIP. Sua #{accountType} foi criada com sucesso.#{BR}
#{BR}
Antes de começar a enviar e receber dinheiro, clique aqui para verificar o seu endereço de e-mail.*#{BR}
#{BR}
* Se o link não funcionar, copie e cole o endereço abaixo na barra do seu navegador #{BR}
#{BR}
#{url}#{BR}
#{BR}
Atenciosamente, #{BR}
Equipe MoIP#{BR}
#{BR}
********************************************************************************************#{BR}
Em caso de dúvidas, contate-nos pelo e-mail suporte@moip.com.br#{BR}
Estamos à sua disposição#{BR}
Nossa sede está situada na Avenida Afonso Pena, 4000 3º andar - Cruzeiro#{BR}
Belo Horizonte - MG - Brasil#{BR}
CEP: 30130-009#{BR}
#{BR}
   </value>
  </property>
  <property name="postUrl">
   <value>${mail.baseUrl}/email/emailRegister.jsp</value>
  </property>
 </bean>
 
  <bean class="comticket.utils.email.EmailInformation" id="emailRegisterVerified">
  <property name="from">
   <value>moip@moip.com.br</value>
  </property>
  <property name="subject">
   <value>Sua Carteira MoIP foi criada</value>
  </property>
  <property name="replaceHtmlCharacters">
   <value>true</value>
  </property>
  <property name="body">
   <value>
#{recipientName}, #{BR}
seja bem vindo ao mundo MoIP. Sua #{accountType} foi criada com sucesso.#{BR}
#{BR}
Atenciosamente, #{BR}
Equipe MoIP#{BR}
#{BR}
********************************************************************************************#{BR}
Em caso de dúvidas, contate-nos pelo e-mail suporte@moip.com.br#{BR}
Estamos à sua disposição#{BR}
Nossa sede está situada na Avenida Afonso Pena, 4000 3º andar - Cruzeiro#{BR}
Belo Horizonte - MG - Brasil#{BR}
CEP: 30130-009#{BR}
#{BR}
   </value>
  </property>
  <property name="postUrl">
   <value>${mail.baseUrl}/email/emailRegisterVerified.jsp</value>
  </property>
 </bean>
 
 
  <bean class="comticket.utils.email.EmailInformation" id="emailInvitation">
  <property name="from">
   <value>moip@moip.com.br</value>
  </property>
  <property name="subject">
   <value>Convite para criar uma Carteira MoIP</value>
  </property>
  <property name="replaceHtmlCharacters">
   <value>true</value>
  </property>
  <property name="body">
   <value>
#{personalMessage}					
				
#{sender} [#{EmailSender}] te enviou um convite para voce criar, gratuitamente, sua Carteira MoIP.

Para criar sua Carteira, visite www.moip.com.br e clique em CRIE SUA CARTEIRA no canto superior a direita da tela. Siga os passos e, quando perguntado sobre o codigo do convite, informe #{invitationCode}

Atencao, para o codigo funcionar voce deve usar o mesmo endereco de e-mail onde recebeu o convite.

O MoIP e a sua Carteira Virtual. Enviar e receber dinheiro sera tao facil quanto enviar um e-mail para um amigo e mais seguro do que ir ao caixa eletronico.

Voce se lembra daquela divida antiga que achou que nunca mais iria receber? O MoIP vai te ajudar.

Equipe MoIP

********************************************************************************************

Em caso de dúvidas, contate-nos pelo e-mail suporte@moip.com.br#{BR}
Estamos à sua disposição#{BR}
Nossa sede está situada na Avenida Afonso Pena, 4000 3º andar - Cruzeiro#{BR}
Belo Horizonte - MG - Brasil#{BR}
CEP: 30130-009#{BR}
#{BR}
   </value>
  </property>
  <property name="postUrl">
   <value>${mail.baseUrl}/email/emailInvitation.jsp</value>
  </property>
 </bean>
 
 
  <bean class="comticket.utils.email.EmailInformation" id="emailNewPassword">
  <property name="from">
   <value>moip@moip.com.br</value>
  </property>
  <property name="subject">
   <value>Procedimento para obter nova senha</value>
  </property>
  <property name="replaceHtmlCharacters">
   <value>true</value>
  </property>
  <property name="body">
   <value>
#{recipient},
#{BR}
#{BR}
#{bodyEmail}
#{BR}
#{BR}
Av. Afonso Pena, 4000 - 3º andar - Cruzeiro.#{BR}
Belo Horizonte - MG#{BR}
   </value>
  </property>
  <property name="postUrl">
   <value>${mail.baseUrl}/email/emailNewPassword.jsp</value>
  </property>
 </bean>
 
 
  <bean class="comticket.utils.email.EmailInformation" id="emailMemberReceivedRequest">
  <property name="from">
   <value>moip@moip.com.br</value>
  </property>
  <property name="subject">
   <value>Recebimento de uma cobranca pelo MoIP</value>
  </property>
  <property name="replaceHtmlCharacters">
   <value>true</value>
  </property>
  <property name="body">
   <value>
#{recipient},
#{BR}
#{BR}
#{bodyEmail}
#{BR}
#{BR}
Av. Afonso Pena, 4000 - 3º andar - Cruzeiro.#{BR}
Belo Horizonte - MG#{BR}
   </value>
  </property>
  <property name="postUrl">
   <value>${mail.baseUrl}/email/emailMemberReceivedRequest.jsp</value>
  </property>
 </bean>
 
  <bean class="comticket.utils.email.EmailInformation" id="emailNotMemberReceivedRequest">
  <property name="from">
   <value>moip@moip.com.br</value>
  </property>
  <property name="subject">
   <value>Recebimento de uma cobranca pelo MoIP</value>
  </property>
  <property name="replaceHtmlCharacters">
   <value>true</value>
  </property>
  <property name="body">
   <value>
#{recipient},
#{BR}
#{BR}
#{bodyEmail}
#{BR}
#{BR}
Av. Afonso Pena, 4000 - 3º andar - Cruzeiro.#{BR}
Belo Horizonte - MG#{BR}
   </value>
  </property>
  <property name="postUrl">
   <value>${mail.baseUrl}/email/emailNotMemberReceivedRequest.jsp</value>
  </property>
 </bean>
 
  <bean class="comticket.utils.email.EmailInformation" id="emailMemberReceivedPayment">
  <property name="from">
   <value>moip@moip.com.br</value>
  </property>
  <property name="subject">
   <value>Recebimento de um pagamento pelo MoIP</value>
  </property>
  <property name="replaceHtmlCharacters">
   <value>true</value>
  </property>
  <property name="body">
   <value>
#{recipient},
#{BR}
#{BR}
#{bodyEmail}
#{BR}
#{BR}
Av. Afonso Pena, 4000 - 3º andar - Cruzeiro.#{BR}
Belo Horizonte - MG#{BR}
   </value>
  </property>
  <property name="postUrl">
   <value>${mail.baseUrl}/email/emailMemberReceivedPayment.jsp</value>
  </property>
 </bean>
 
  <bean class="comticket.utils.email.EmailInformation" id="emailResendTransferWarn">
  <property name="from">
   <value>moip@moip.com.br</value>
  </property>
  <property name="subject">
   <value>Reenvio de mensagem sobre pagamento</value>
  </property>
  <property name="replaceHtmlCharacters">
   <value>true</value>
  </property>
  <property name="body">
   <value>
#{recipient},
#{BR}
#{BR}
#{bodyEmail}
#{BR}
#{BR}
Av. Afonso Pena, 4000 - 3º andar - Cruzeiro.#{BR}
Belo Horizonte - MG#{BR}
   </value>
  </property>
  <property name="postUrl">
   <value>${mail.baseUrl}/email/emailResendTransferWarn.jsp</value>
  </property>
 </bean>
 
  <bean class="comticket.utils.email.EmailInformation" id="emailNotMemberReceivedPayment">
  <property name="from">
   <value>moip@moip.com.br</value>
  </property>
  <property name="subject">
   <value>Recebimento de um pagamento pelo MoIP</value>
  </property>
  <property name="replaceHtmlCharacters">
   <value>true</value>
  </property>
  <property name="body">
   <value>
#{recipient},
#{BR}
#{BR}
#{bodyEmail}
#{BR}
#{BR}
Av. Afonso Pena, 4000 - 3º andar - Cruzeiro.#{BR}
Belo Horizonte - MG#{BR}
   </value>
  </property>
  <property name="postUrl">
   <value>${mail.baseUrl}/email/emailNotMemberReceivedPayment.jsp</value>
  </property>
 </bean>
 
  <bean class="comticket.utils.email.EmailInformation" id="emailNotificationFailure">
  <property name="from">
   <value>moip@moip.com.br</value>
  </property>
  <property name="subject">
   <value>Falha na notificao instantanea</value>
  </property>
  <property name="replaceHtmlCharacters">
   <value>true</value>
  </property>
  <property name="body">
   <value>
#{recipientName}, #{BR}
Esse e-mail tem o objetivo de te avisar sobre as falhas sucessivas nas tentativas de aviso sobre a mudança de status da transação #{transactionId}. A partir de agora, o MoIP não mais te enviará notificações sobre essa transação específica.#{BR}
#{BR}
Confira se o status do registro dessa transação em seu sistema confere com o mostrado em sua Carteira MoIP.#{BR}
#{BR}
Para configurar as notificações das transações, entre na sua Carteira MoIP e vá em Meus Dados > Notificação das transações#{BR}
#{BR}
Atenciosamente, #{BR}
Equipe MoIP#{BR}
#{BR}
********************************************************************************************#{BR}
Em caso de dúvidas, contate-nos pelo e-mail suporte@moip.com.br#{BR}
Estamos à sua disposição#{BR}
Nossa sede está situada na Avenida Afonso Pena, 4000 3º andar - Cruzeiro#{BR}
Belo Horizonte - MG - Brasil#{BR}
CEP: 30130-009#{BR}
#{BR}
   </value>
  </property>
  <property name="postUrl">
   <value>${mail.baseUrl}/email/emailNotificationFailure.jsp</value>
  </property>
 </bean>
 <bean class="comticket.utils.email.EmailInformation" id="emailChangeStatus">
  <property name="from">
   <value>moip@moip.com.br</value>
  </property>
  <property name="subject">
   <value>Mudanca no status de um pagamento</value>
  </property>
  <property name="replaceHtmlCharacters">
   <value>true</value>
  </property>
  <property name="body">
   <value>
#{recipient},
#{BR}
#{BR}
#{bodyEmail}
#{BR}
#{BR}
Av. Afonso Pena, 4000 - 3º andar - Cruzeiro.#{BR}
Belo Horizonte - MG#{BR}
   </value>
  </property>
  <property name="postUrl">
   <value>${mail.baseUrl}/email/emailChangeStatus.jsp</value>
  </property>
 </bean>
 <bean class="comticket.utils.email.EmailInformation" id="emailChargebackPayor">
  <property name="from">
   <value>moip@moip.com.br</value>
  </property>
  <property name="subject">
   <value>Notificacao de Estorno de Pagamento</value>
  </property>
  <property name="replaceHtmlCharacters">
   <value>true</value>
  </property>
  <property name="body">
   <value>
#{recipient},
#{BR}
#{BR}
#{bodyEmail}
#{BR}
#{BR}
Av. Afonso Pena, 4000 - 3º andar - Cruzeiro.#{BR}
Belo Horizonte - MG#{BR}
   </value>
  </property>
  <property name="postUrl">
   <value>${mail.baseUrl}/email/emailChargebackPayor.jsp</value>
  </property>
 </bean>
 <bean class="comticket.utils.email.EmailInformation" id="emailChargebackPayee">
  <property name="from">
   <value>moip@moip.com.br</value>
  </property>
  <property name="subject">
   <value>Notificacao de Estorno de Pagamento</value>
  </property>
  <property name="replaceHtmlCharacters">
   <value>true</value>
  </property>
  <property name="body">
   <value>
#{recipient},
#{BR}
#{BR}
#{bodyEmail}
#{BR}
#{BR}
Av. Afonso Pena, 4000 - 3º andar - Cruzeiro.#{BR}
Belo Horizonte - MG#{BR}
   </value>
  </property>
  <property name="postUrl">
   <value>${mail.baseUrl}/email/emailChargebackPayee.jsp</value>
  </property>
 </bean>
 
 <bean class="comticket.utils.email.EmailInformation" id="emailInAnalysis">
  <property name="from">
   <value>moip@moip.com.br</value>
  </property>
  <property name="subject">
   <value>Pagamento em analise</value>
  </property>
  <property name="replaceHtmlCharacters">
   <value>true</value>
  </property>
  <property name="body">
   <value>
#{recipient},
#{BR}
#{BR}
#{bodyEmail}
#{BR}
#{BR}
Av. Afonso Pena, 4000 - 3º andar - Cruzeiro.#{BR}
Belo Horizonte - MG#{BR}
   </value>
  </property>
  <property name="postUrl">
   <value>${mail.baseUrl}/email/emailInAnalysis.jsp</value>
  </property>
 </bean>
 
</beans>

 */

public class SendEmailTest {

	public static String SMTP_ADDRESS = "216.154.222.142";
	public static String SMTP_USERNAME = "meusingressos";
	public static String SMTP_PWD = "1ngresso$";
	public static String FROM = "meusingressos@meusingressos.com.br";
	
	public SendEmailTest() {
		
	}
	
	public static junit.framework.Test suite() { 
	    return new JUnit4TestAdapter(SendEmailTest.class); 
	}

	MessagingManager messageManager;
	MailService mailService;
	
	@Test
	public void sendTestEmail()
	{
		try
		{
			initMail();
			
			EmailTemplate emailTemplate = new EmailTemplate();
			emailTemplate.setFromAddress(FROM);			
			emailTemplate.setAddTo("guifiche@gmail.com");
			emailTemplate.setSubject("Teste de e-mail");			
			emailTemplate.setBody("Este é um e-mail de teste.");
			//emailTemplate.setReplaceHtmlCharacters(false);
			
			String p_ChaveEmailPreCadastrado = "testMail";
			messageManager.getEmailTemplates().put(p_ChaveEmailPreCadastrado, emailTemplate);
			
			Assert.assertTrue(send(p_ChaveEmailPreCadastrado));
			
		}
		catch (Exception e){
			
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}
	
	
	protected void initMail()
	{
		mailService = new ApacheCommonsMailService();
		SmtpServer smtpServer = new SmtpServer(SMTP_ADDRESS,SMTP_USERNAME,SMTP_PWD);
		mailService.setSmtpServer(smtpServer);		
		messageManager = new MessagingManager();		
		messageManager.addDeliveryServices(mailService);
		messageManager.setSendMessageSynchronously(true);
	}
	
	protected boolean send(String p_ChaveEmailPreCadastrado)
	{
		Message message = messageManager.getMessageTemplate(p_ChaveEmailPreCadastrado);
		return messageManager.sendMessage(message);
	}
	
	
	protected EmailTemplate getSimpleTextEmail()
	{
		EmailTemplate emailTemplate = new EmailTemplate();
		emailTemplate.setAddTo(new EmailAddress("guifiche@gmail.com","Fiche"));
		emailTemplate.setFromAddress(new EmailAddress(FROM,"Guilherme Fiche - MoIP"));		
		emailTemplate.setSubject("Teste br.com.primarr.msg");		
		EmailBody body = new TextBody("Este é o corpo de texto puro do teste br.com.primarr.msg.");		
		emailTemplate.setBody(body);		
		return emailTemplate;
	}
	
	protected EmailTemplate getSimpleHtmlEmail()
	{
		EmailTemplate emailTemplate = new EmailTemplate();
		emailTemplate.setAddTo(new EmailAddress("guifiche@yahoo.com.br","Fiche"));
		emailTemplate.setFromAddress(new EmailAddress(FROM,"Guilherme Fiche - MoIP"));		
		emailTemplate.setSubject("Teste br.com.primarr.msg");		
		EmailBody body = new HtmlBody("Este é o corpo de texto puro do teste br.com.primarr.msg.","<html><body><h2>Este é o corpo de <b>HTML</b> do teste br.com.primarr.msg.</h2></body></html>");		
		emailTemplate.setBody(body);		
		return emailTemplate;
	}
	
	protected EmailTemplate getPostHtmlEmail()
	{
		EmailTemplate emailTemplate = new EmailTemplate();
		emailTemplate.setAddTo(new EmailAddress("guifiche@gmail.com","Fiche"));
		emailTemplate.setFromAddress(new EmailAddress(FROM,"Guilherme Fiche - MoIP"));		
		emailTemplate.setSubject("Teste br.com.primarr.msg");
		HtmlBody htmlBody = new HtmlBody();
		
		PostBuilder postBuilder= new PostBuilder("http://www.fiche.com.br");
		
		htmlBody.setHtml(postBuilder);
		
		br.com.primarr.msg.body.builder.StringBuilder stringBuilder = new br.com.primarr.msg.body.builder.StringBuilder("Seu cliente de e-mail nao suporta HTML.");
		htmlBody.setText(stringBuilder);
		
		emailTemplate.setBody(htmlBody);		
		
		return emailTemplate;
	}
	
	
	public void sendSimpleTextEmail()
	{
		try{
		MailService mailService = new ApacheCommonsMockMailService();
		SmtpServer smtpServer = new SmtpServer(SMTP_ADDRESS,SMTP_USERNAME,SMTP_PWD);
		mailService.setSmtpServer(smtpServer);
		
		mailService.sendMessage(getSimpleTextEmail());
		Assert.assertTrue(true);
		}
		catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	
	public void sendSimpleHtmlEmail()
	{
		try{
		MailService mailService = new ApacheCommonsMockMailService();
		SmtpServer smtpServer = new SmtpServer(SMTP_ADDRESS,SMTP_USERNAME,SMTP_PWD);
		mailService.setSmtpServer(smtpServer);
		
		mailService.sendMessage(getSimpleHtmlEmail());
		Assert.assertTrue(true);
		}
		catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	
	public void sendPostHtmlEmail()
	{
		try{
			MailService mailService = new ApacheCommonsMailService();
			SmtpServer smtpServer = new SmtpServer(SMTP_ADDRESS,SMTP_USERNAME,SMTP_PWD);
			mailService.setSmtpServer(smtpServer);
			
			mailService.sendMessage((getPostHtmlEmail()));
			Assert.assertTrue(true);
			}
			catch (Exception e) {
				e.printStackTrace();
				Assert.assertTrue(false);
			}
	}
	
//	@Test
//	public void test()
//	{
//		Assert.assertTrue(true);
//	}

}