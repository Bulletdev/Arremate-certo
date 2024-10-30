/*     */ package ch.qos.logback.core.net;
/*     */ 
/*     */ import ch.qos.logback.core.AppenderBase;
/*     */ import ch.qos.logback.core.Layout;
/*     */ import ch.qos.logback.core.boolex.EvaluationException;
/*     */ import ch.qos.logback.core.boolex.EventEvaluator;
/*     */ import ch.qos.logback.core.helpers.CyclicBuffer;
/*     */ import ch.qos.logback.core.pattern.PatternLayoutBase;
/*     */ import ch.qos.logback.core.sift.DefaultDiscriminator;
/*     */ import ch.qos.logback.core.sift.Discriminator;
/*     */ import ch.qos.logback.core.spi.CyclicBufferTracker;
/*     */ import ch.qos.logback.core.util.ContentTypeUtil;
/*     */ import ch.qos.logback.core.util.JNDIUtil;
/*     */ import ch.qos.logback.core.util.OptionHelper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import javax.mail.Address;
/*     */ import javax.mail.BodyPart;
/*     */ import javax.mail.Message;
/*     */ import javax.mail.Multipart;
/*     */ import javax.mail.Session;
/*     */ import javax.mail.Transport;
/*     */ import javax.mail.internet.AddressException;
/*     */ import javax.mail.internet.InternetAddress;
/*     */ import javax.mail.internet.MimeBodyPart;
/*     */ import javax.mail.internet.MimeMessage;
/*     */ import javax.mail.internet.MimeMultipart;
/*     */ import javax.naming.Context;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class SMTPAppenderBase<E>
/*     */   extends AppenderBase<E>
/*     */ {
/*  63 */   static InternetAddress[] EMPTY_IA_ARRAY = new InternetAddress[0];
/*     */   
/*     */   static final long MAX_DELAY_BETWEEN_STATUS_MESSAGES = 1228800000L;
/*     */   
/*  67 */   long lastTrackerStatusPrint = 0L;
/*  68 */   long delayBetweenStatusMessages = 300000L;
/*     */   
/*     */   protected Layout<E> subjectLayout;
/*     */   
/*     */   protected Layout<E> layout;
/*  73 */   private List<PatternLayoutBase<E>> toPatternLayoutList = new ArrayList<PatternLayoutBase<E>>();
/*     */   private String from;
/*  75 */   private String subjectStr = null;
/*     */   private String smtpHost;
/*  77 */   private int smtpPort = 25;
/*     */   private boolean starttls = false;
/*     */   private boolean ssl = false;
/*     */   private boolean sessionViaJNDI = false;
/*  81 */   private String jndiLocation = "java:comp/env/mail/Session";
/*     */   
/*     */   String username;
/*     */   
/*     */   String password;
/*     */   
/*     */   String localhost;
/*     */   boolean asynchronousSending = true;
/*  89 */   private String charsetEncoding = "UTF-8";
/*     */   
/*     */   protected Session session;
/*     */   
/*     */   protected EventEvaluator<E> eventEvaluator;
/*     */   
/*  95 */   protected Discriminator<E> discriminator = (Discriminator<E>)new DefaultDiscriminator();
/*     */   
/*     */   protected CyclicBufferTracker<E> cbTracker;
/*  98 */   private int errorCount = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract Layout<E> makeSubjectLayout(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/* 115 */     if (this.cbTracker == null) {
/* 116 */       this.cbTracker = new CyclicBufferTracker();
/*     */     }
/*     */     
/* 119 */     if (this.sessionViaJNDI) {
/* 120 */       this.session = lookupSessionInJNDI();
/*     */     } else {
/* 122 */       this.session = buildSessionFromProperties();
/*     */     } 
/* 124 */     if (this.session == null) {
/* 125 */       addError("Failed to obtain javax.mail.Session. Cannot start.");
/*     */       
/*     */       return;
/*     */     } 
/* 129 */     this.subjectLayout = makeSubjectLayout(this.subjectStr);
/*     */     
/* 131 */     this.started = true;
/*     */   }
/*     */   
/*     */   private Session lookupSessionInJNDI() {
/* 135 */     addInfo("Looking up javax.mail.Session at JNDI location [" + this.jndiLocation + "]");
/*     */     try {
/* 137 */       Context context = JNDIUtil.getInitialContext();
/* 138 */       Object object = JNDIUtil.lookupObject(context, this.jndiLocation);
/* 139 */       return (Session)object;
/* 140 */     } catch (Exception exception) {
/* 141 */       addError("Failed to obtain javax.mail.Session from JNDI location [" + this.jndiLocation + "]");
/* 142 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private Session buildSessionFromProperties() {
/* 147 */     Properties properties = new Properties(OptionHelper.getSystemProperties());
/* 148 */     if (this.smtpHost != null) {
/* 149 */       properties.put("mail.smtp.host", this.smtpHost);
/*     */     }
/* 151 */     properties.put("mail.smtp.port", Integer.toString(this.smtpPort));
/*     */     
/* 153 */     if (this.localhost != null) {
/* 154 */       properties.put("mail.smtp.localhost", this.localhost);
/*     */     }
/*     */     
/* 157 */     LoginAuthenticator loginAuthenticator = null;
/*     */     
/* 159 */     if (!OptionHelper.isEmpty(this.username)) {
/* 160 */       loginAuthenticator = new LoginAuthenticator(this.username, this.password);
/* 161 */       properties.put("mail.smtp.auth", "true");
/*     */     } 
/*     */     
/* 164 */     if (isSTARTTLS() && isSSL()) {
/* 165 */       addError("Both SSL and StartTLS cannot be enabled simultaneously");
/*     */     } else {
/* 167 */       if (isSTARTTLS())
/*     */       {
/* 169 */         properties.put("mail.smtp.starttls.enable", "true");
/*     */       }
/* 171 */       if (isSSL()) {
/* 172 */         String str = "javax.net.ssl.SSLSocketFactory";
/* 173 */         properties.put("mail.smtp.socketFactory.port", Integer.toString(this.smtpPort));
/* 174 */         properties.put("mail.smtp.socketFactory.class", str);
/* 175 */         properties.put("mail.smtp.socketFactory.fallback", "true");
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 181 */     return Session.getInstance(properties, loginAuthenticator);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void append(E paramE) {
/* 190 */     if (!checkEntryConditions()) {
/*     */       return;
/*     */     }
/*     */     
/* 194 */     String str = this.discriminator.getDiscriminatingValue(paramE);
/* 195 */     long l = System.currentTimeMillis();
/* 196 */     CyclicBuffer<E> cyclicBuffer = (CyclicBuffer)this.cbTracker.getOrCreate(str, l);
/* 197 */     subAppend(cyclicBuffer, paramE);
/*     */     
/*     */     try {
/* 200 */       if (this.eventEvaluator.evaluate(paramE)) {
/*     */         
/* 202 */         CyclicBuffer<E> cyclicBuffer1 = new CyclicBuffer(cyclicBuffer);
/*     */         
/* 204 */         cyclicBuffer.clear();
/*     */         
/* 206 */         if (this.asynchronousSending) {
/*     */           
/* 208 */           a a = new a(this, cyclicBuffer1, paramE);
/* 209 */           this.context.getScheduledExecutorService().execute(a);
/*     */         } else {
/*     */           
/* 212 */           sendBuffer(cyclicBuffer1, paramE);
/*     */         } 
/*     */       } 
/* 215 */     } catch (EvaluationException evaluationException) {
/* 216 */       this.errorCount++;
/* 217 */       if (this.errorCount < 4) {
/* 218 */         addError("SMTPAppender's EventEvaluator threw an Exception-", (Throwable)evaluationException);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 223 */     if (eventMarksEndOfLife(paramE)) {
/* 224 */       this.cbTracker.endOfLife(str);
/*     */     }
/*     */     
/* 227 */     this.cbTracker.removeStaleComponents(l);
/*     */     
/* 229 */     if (this.lastTrackerStatusPrint + this.delayBetweenStatusMessages < l) {
/* 230 */       addInfo("SMTPAppender [" + this.name + "] is tracking [" + this.cbTracker.getComponentCount() + "] buffers");
/* 231 */       this.lastTrackerStatusPrint = l;
/*     */       
/* 233 */       if (this.delayBetweenStatusMessages < 1228800000L) {
/* 234 */         this.delayBetweenStatusMessages *= 4L;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract boolean eventMarksEndOfLife(E paramE);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void subAppend(CyclicBuffer<E> paramCyclicBuffer, E paramE);
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkEntryConditions() {
/* 252 */     if (!this.started) {
/* 253 */       addError("Attempting to append to a non-started appender: " + getName());
/* 254 */       return false;
/*     */     } 
/*     */     
/* 257 */     if (this.eventEvaluator == null) {
/* 258 */       addError("No EventEvaluator is set for appender [" + this.name + "].");
/* 259 */       return false;
/*     */     } 
/*     */     
/* 262 */     if (this.layout == null) {
/* 263 */       addError("No layout set for appender named [" + this.name + "]. For more information, please visit http://logback.qos.ch/codes.html#smtp_no_layout");
/* 264 */       return false;
/*     */     } 
/* 266 */     return true;
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 270 */     this.started = false;
/*     */   }
/*     */   
/*     */   InternetAddress getAddress(String paramString) {
/*     */     try {
/* 275 */       return new InternetAddress(paramString);
/* 276 */     } catch (AddressException addressException) {
/* 277 */       addError("Could not parse address [" + paramString + "].", (Throwable)addressException);
/* 278 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private List<InternetAddress> parseAddress(E paramE) {
/* 283 */     int i = this.toPatternLayoutList.size();
/*     */     
/* 285 */     ArrayList<InternetAddress> arrayList = new ArrayList();
/*     */     
/* 287 */     for (byte b = 0; b < i; b++) {
/*     */       try {
/* 289 */         PatternLayoutBase patternLayoutBase = this.toPatternLayoutList.get(b);
/* 290 */         String str = patternLayoutBase.doLayout(paramE);
/* 291 */         if (str != null && str.length() != 0)
/*     */         
/*     */         { 
/* 294 */           InternetAddress[] arrayOfInternetAddress = InternetAddress.parse(str, true);
/* 295 */           arrayList.addAll(Arrays.asList(arrayOfInternetAddress)); } 
/* 296 */       } catch (AddressException addressException) {
/* 297 */         addError("Could not parse email address for [" + this.toPatternLayoutList.get(b) + "] for event [" + paramE + "]", (Throwable)addressException);
/* 298 */         return arrayList;
/*     */       } 
/*     */     } 
/*     */     
/* 302 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<PatternLayoutBase<E>> getToList() {
/* 309 */     return this.toPatternLayoutList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void sendBuffer(CyclicBuffer<E> paramCyclicBuffer, E paramE) {
/*     */     try {
/* 320 */       MimeBodyPart mimeBodyPart = new MimeBodyPart();
/*     */       
/* 322 */       StringBuffer stringBuffer = new StringBuffer();
/*     */       
/* 324 */       String str1 = this.layout.getFileHeader();
/* 325 */       if (str1 != null) {
/* 326 */         stringBuffer.append(str1);
/*     */       }
/* 328 */       String str2 = this.layout.getPresentationHeader();
/* 329 */       if (str2 != null) {
/* 330 */         stringBuffer.append(str2);
/*     */       }
/* 332 */       fillBuffer(paramCyclicBuffer, stringBuffer);
/* 333 */       String str3 = this.layout.getPresentationFooter();
/* 334 */       if (str3 != null) {
/* 335 */         stringBuffer.append(str3);
/*     */       }
/* 337 */       String str4 = this.layout.getFileFooter();
/* 338 */       if (str4 != null) {
/* 339 */         stringBuffer.append(str4);
/*     */       }
/*     */       
/* 342 */       String str5 = "Undefined subject";
/* 343 */       if (this.subjectLayout != null) {
/* 344 */         str5 = this.subjectLayout.doLayout(paramE);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 349 */         byte b = (str5 != null) ? str5.indexOf('\n') : -1;
/* 350 */         if (b > -1) {
/* 351 */           str5 = str5.substring(0, b);
/*     */         }
/*     */       } 
/*     */       
/* 355 */       MimeMessage mimeMessage = new MimeMessage(this.session);
/*     */       
/* 357 */       if (this.from != null) {
/* 358 */         mimeMessage.setFrom((Address)getAddress(this.from));
/*     */       } else {
/* 360 */         mimeMessage.setFrom();
/*     */       } 
/*     */       
/* 363 */       mimeMessage.setSubject(str5, this.charsetEncoding);
/*     */       
/* 365 */       List<InternetAddress> list = parseAddress(paramE);
/* 366 */       if (list.isEmpty()) {
/* 367 */         addInfo("Empty destination address. Aborting email transmission");
/*     */         
/*     */         return;
/*     */       } 
/* 371 */       InternetAddress[] arrayOfInternetAddress = list.<InternetAddress>toArray(EMPTY_IA_ARRAY);
/* 372 */       mimeMessage.setRecipients(Message.RecipientType.TO, (Address[])arrayOfInternetAddress);
/*     */       
/* 374 */       String str6 = this.layout.getContentType();
/*     */       
/* 376 */       if (ContentTypeUtil.isTextual(str6)) {
/* 377 */         mimeBodyPart.setText(stringBuffer.toString(), this.charsetEncoding, ContentTypeUtil.getSubType(str6));
/*     */       } else {
/* 379 */         mimeBodyPart.setContent(stringBuffer.toString(), this.layout.getContentType());
/*     */       } 
/*     */       
/* 382 */       MimeMultipart mimeMultipart = new MimeMultipart();
/* 383 */       mimeMultipart.addBodyPart((BodyPart)mimeBodyPart);
/* 384 */       mimeMessage.setContent((Multipart)mimeMultipart);
/*     */       
/* 386 */       mimeMessage.setSentDate(new Date());
/* 387 */       addInfo("About to send out SMTP message \"" + str5 + "\" to " + Arrays.toString((Object[])arrayOfInternetAddress));
/* 388 */       Transport.send((Message)mimeMessage);
/* 389 */     } catch (Exception exception) {
/* 390 */       addError("Error occurred while sending e-mail notification.", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void fillBuffer(CyclicBuffer<E> paramCyclicBuffer, StringBuffer paramStringBuffer);
/*     */ 
/*     */   
/*     */   public String getFrom() {
/* 400 */     return this.from;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSubject() {
/* 407 */     return this.subjectStr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFrom(String paramString) {
/* 415 */     this.from = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSubject(String paramString) {
/* 423 */     this.subjectStr = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSMTPHost(String paramString) {
/* 432 */     setSmtpHost(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSmtpHost(String paramString) {
/* 440 */     this.smtpHost = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSMTPHost() {
/* 447 */     return getSmtpHost();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSmtpHost() {
/* 454 */     return this.smtpHost;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSMTPPort(int paramInt) {
/* 463 */     setSmtpPort(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSmtpPort(int paramInt) {
/* 472 */     this.smtpPort = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSMTPPort() {
/* 481 */     return getSmtpPort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSmtpPort() {
/* 490 */     return this.smtpPort;
/*     */   }
/*     */   
/*     */   public String getLocalhost() {
/* 494 */     return this.localhost;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocalhost(String paramString) {
/* 508 */     this.localhost = paramString;
/*     */   }
/*     */   
/*     */   public CyclicBufferTracker<E> getCyclicBufferTracker() {
/* 512 */     return this.cbTracker;
/*     */   }
/*     */   
/*     */   public void setCyclicBufferTracker(CyclicBufferTracker<E> paramCyclicBufferTracker) {
/* 516 */     this.cbTracker = paramCyclicBufferTracker;
/*     */   }
/*     */   
/*     */   public Discriminator<E> getDiscriminator() {
/* 520 */     return this.discriminator;
/*     */   }
/*     */   
/*     */   public void setDiscriminator(Discriminator<E> paramDiscriminator) {
/* 524 */     this.discriminator = paramDiscriminator;
/*     */   }
/*     */   
/*     */   public boolean isAsynchronousSending() {
/* 528 */     return this.asynchronousSending;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAsynchronousSending(boolean paramBoolean) {
/* 539 */     this.asynchronousSending = paramBoolean;
/*     */   }
/*     */   
/*     */   public void addTo(String paramString) {
/* 543 */     if (paramString == null || paramString.length() == 0) {
/* 544 */       throw new IllegalArgumentException("Null or empty <to> property");
/*     */     }
/* 546 */     PatternLayoutBase<E> patternLayoutBase = makeNewToPatternLayout(paramString.trim());
/* 547 */     patternLayoutBase.setContext(this.context);
/* 548 */     patternLayoutBase.start();
/* 549 */     this.toPatternLayoutList.add(patternLayoutBase);
/*     */   }
/*     */   
/*     */   protected abstract PatternLayoutBase<E> makeNewToPatternLayout(String paramString);
/*     */   
/*     */   public List<String> getToAsListOfString() {
/* 555 */     ArrayList<String> arrayList = new ArrayList();
/* 556 */     for (PatternLayoutBase<E> patternLayoutBase : this.toPatternLayoutList) {
/* 557 */       arrayList.add(patternLayoutBase.getPattern());
/*     */     }
/* 559 */     return arrayList;
/*     */   }
/*     */   
/*     */   public boolean isSTARTTLS() {
/* 563 */     return this.starttls;
/*     */   }
/*     */   
/*     */   public void setSTARTTLS(boolean paramBoolean) {
/* 567 */     this.starttls = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isSSL() {
/* 571 */     return this.ssl;
/*     */   }
/*     */   
/*     */   public void setSSL(boolean paramBoolean) {
/* 575 */     this.ssl = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEvaluator(EventEvaluator<E> paramEventEvaluator) {
/* 585 */     this.eventEvaluator = paramEventEvaluator;
/*     */   }
/*     */   
/*     */   public String getUsername() {
/* 589 */     return this.username;
/*     */   }
/*     */   
/*     */   public void setUsername(String paramString) {
/* 593 */     this.username = paramString;
/*     */   }
/*     */   
/*     */   public String getPassword() {
/* 597 */     return this.password;
/*     */   }
/*     */   
/*     */   public void setPassword(String paramString) {
/* 601 */     this.password = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCharsetEncoding() {
/* 609 */     return this.charsetEncoding;
/*     */   }
/*     */   
/*     */   public String getJndiLocation() {
/* 613 */     return this.jndiLocation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setJndiLocation(String paramString) {
/* 624 */     this.jndiLocation = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSessionViaJNDI() {
/* 628 */     return this.sessionViaJNDI;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSessionViaJNDI(boolean paramBoolean) {
/* 638 */     this.sessionViaJNDI = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCharsetEncoding(String paramString) {
/* 648 */     this.charsetEncoding = paramString;
/*     */   }
/*     */   
/*     */   public Layout<E> getLayout() {
/* 652 */     return this.layout;
/*     */   }
/*     */   
/*     */   public void setLayout(Layout<E> paramLayout) {
/* 656 */     this.layout = paramLayout;
/*     */   }
/*     */   
/*     */   class a
/*     */     implements Runnable {
/*     */     final CyclicBuffer<E> a;
/*     */     final E e;
/*     */     
/*     */     a(SMTPAppenderBase this$0, CyclicBuffer<E> param1CyclicBuffer, E param1E) {
/* 665 */       this.a = (SMTPAppenderBase)param1CyclicBuffer;
/* 666 */       this.e = param1E;
/*     */     }
/*     */     
/*     */     public void run() {
/* 670 */       this.a.sendBuffer((CyclicBuffer<E>)this.a, this.e);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\net\SMTPAppenderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */