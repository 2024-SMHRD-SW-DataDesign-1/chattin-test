package com.smhrd.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MavenMember;
import com.smhrd.model.MavenMemberDAO;
import com.smhrd.util.Gmail;
import com.smhrd.util.SHA256;

public class FindIDController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String emailHash = SHA256.getSHA256(email);

		MavenMember member = new MavenMember(name, email, emailHash);

		MavenMemberDAO dao = new MavenMemberDAO();
		int res = dao.FindID(member);

		if (res == 1) {
			String host = "http://localhost:8081/mavensample/";
			String from = "worhks0413@gmail.com";
			String to = email;
			String subject = "아이디 찾기를 위한 이메일 확인 메일입니다. ";
			String content = "다음 링크에 접속하여 이메일 확인을 진행하세요." + "<a href='" + host + "emailCheckAction.jsp?code="
					+ new SHA256().getSHA256(to) + "'>이메일 인증하기</a>";

			Properties p = new Properties();
			p.put("mail.smtp.user", from);
			p.put("mail.smtp.host", "smtp.gmail.com");
			p.put("mail.smtp.port", "587");
			p.put("mail.smtp.starttls.enable", "true");
			p.put("mail.smtp.auth", "true");
			p.put("mail.smtp.ssl.protocols", "TLSv1.2");
			p.put("mail.smtp.debug", "true");

			final String username = "worhks0413@gmail.com";
            final String password = "wosf tshq fhma jaof";
			
			try {
				Authenticator auth = new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                };
				Session ses = Session.getInstance(p, auth);
				ses.setDebug(true);
				MimeMessage msg = new MimeMessage(ses);
				msg.setSubject(subject);
				Address fromAddr = new InternetAddress(from);
				msg.setFrom(fromAddr);
				Address toAddr = new InternetAddress(to);
				msg.addRecipient(Message.RecipientType.TO, toAddr);
				msg.setContent(content, "text/html;charset=UTF-8");
				Transport.send(msg);
				session.setAttribute("message", "success");
			} catch (Exception e) {
				e.printStackTrace();
				session.setAttribute("message", "fail");
				return;
			}
		}else {
			session.setAttribute("message", "fail");
		}
		response.sendRedirect("FindID.jsp");
	}

}
