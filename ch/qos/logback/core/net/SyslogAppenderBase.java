/*     */ package ch.qos.logback.core.net;
/*     */ 
/*     */ import ch.qos.logback.core.AppenderBase;
/*     */ import ch.qos.logback.core.Layout;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.net.SocketException;
/*     */ import java.net.UnknownHostException;
/*     */ import java.nio.charset.Charset;
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
/*     */ public abstract class SyslogAppenderBase<E>
/*     */   extends AppenderBase<E>
/*     */ {
/*     */   static final String SYSLOG_LAYOUT_URL = "http://logback.qos.ch/codes.html#syslog_layout";
/*     */   static final int MAX_MESSAGE_SIZE_LIMIT = 65000;
/*     */   Layout<E> layout;
/*     */   String facilityStr;
/*     */   String syslogHost;
/*     */   protected String suffixPattern;
/*     */   SyslogOutputStream sos;
/*  43 */   int port = 514;
/*     */   int maxMessageSize;
/*     */   Charset charset;
/*     */   
/*     */   public void start() {
/*  48 */     byte b = 0;
/*  49 */     if (this.facilityStr == null) {
/*  50 */       addError("The Facility option is mandatory");
/*  51 */       b++;
/*     */     } 
/*     */     
/*  54 */     if (this.charset == null)
/*     */     {
/*     */       
/*  57 */       this.charset = Charset.defaultCharset();
/*     */     }
/*     */     
/*     */     try {
/*  61 */       this.sos = createOutputStream();
/*     */       
/*  63 */       int i = this.sos.getSendBufferSize();
/*  64 */       if (this.maxMessageSize == 0) {
/*  65 */         this.maxMessageSize = Math.min(i, 65000);
/*  66 */         addInfo("Defaulting maxMessageSize to [" + this.maxMessageSize + "]");
/*  67 */       } else if (this.maxMessageSize > i) {
/*  68 */         addWarn("maxMessageSize of [" + this.maxMessageSize + "] is larger than the system defined datagram size of [" + i + "].");
/*  69 */         addWarn("This may result in dropped logs.");
/*     */       } 
/*  71 */     } catch (UnknownHostException unknownHostException) {
/*  72 */       addError("Could not create SyslogWriter", unknownHostException);
/*  73 */       b++;
/*  74 */     } catch (SocketException socketException) {
/*  75 */       addWarn("Failed to bind to a random datagram socket. Will try to reconnect later.", socketException);
/*     */     } 
/*     */     
/*  78 */     if (this.layout == null) {
/*  79 */       this.layout = buildLayout();
/*     */     }
/*     */     
/*  82 */     if (b == 0) {
/*  83 */       super.start();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract SyslogOutputStream createOutputStream() throws UnknownHostException, SocketException;
/*     */   
/*     */   public abstract Layout<E> buildLayout();
/*     */   
/*     */   public abstract int getSeverityForEvent(Object paramObject);
/*     */   
/*     */   protected void append(E paramE) {
/*  95 */     if (!isStarted()) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/* 100 */       String str = this.layout.doLayout(paramE);
/* 101 */       if (str == null) {
/*     */         return;
/*     */       }
/* 104 */       if (str.length() > this.maxMessageSize) {
/* 105 */         str = str.substring(0, this.maxMessageSize);
/*     */       }
/* 107 */       this.sos.write(str.getBytes(this.charset));
/* 108 */       this.sos.flush();
/* 109 */       postProcess(paramE, this.sos);
/* 110 */     } catch (IOException iOException) {
/* 111 */       addError("Failed to send diagram to " + this.syslogHost, iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void postProcess(Object paramObject, OutputStream paramOutputStream) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int facilityStringToint(String paramString) {
/* 126 */     if ("KERN".equalsIgnoreCase(paramString))
/* 127 */       return 0; 
/* 128 */     if ("USER".equalsIgnoreCase(paramString))
/* 129 */       return 8; 
/* 130 */     if ("MAIL".equalsIgnoreCase(paramString))
/* 131 */       return 16; 
/* 132 */     if ("DAEMON".equalsIgnoreCase(paramString))
/* 133 */       return 24; 
/* 134 */     if ("AUTH".equalsIgnoreCase(paramString))
/* 135 */       return 32; 
/* 136 */     if ("SYSLOG".equalsIgnoreCase(paramString))
/* 137 */       return 40; 
/* 138 */     if ("LPR".equalsIgnoreCase(paramString))
/* 139 */       return 48; 
/* 140 */     if ("NEWS".equalsIgnoreCase(paramString))
/* 141 */       return 56; 
/* 142 */     if ("UUCP".equalsIgnoreCase(paramString))
/* 143 */       return 64; 
/* 144 */     if ("CRON".equalsIgnoreCase(paramString))
/* 145 */       return 72; 
/* 146 */     if ("AUTHPRIV".equalsIgnoreCase(paramString))
/* 147 */       return 80; 
/* 148 */     if ("FTP".equalsIgnoreCase(paramString))
/* 149 */       return 88; 
/* 150 */     if ("NTP".equalsIgnoreCase(paramString))
/* 151 */       return 96; 
/* 152 */     if ("AUDIT".equalsIgnoreCase(paramString))
/* 153 */       return 104; 
/* 154 */     if ("ALERT".equalsIgnoreCase(paramString))
/* 155 */       return 112; 
/* 156 */     if ("CLOCK".equalsIgnoreCase(paramString))
/* 157 */       return 120; 
/* 158 */     if ("LOCAL0".equalsIgnoreCase(paramString))
/* 159 */       return 128; 
/* 160 */     if ("LOCAL1".equalsIgnoreCase(paramString))
/* 161 */       return 136; 
/* 162 */     if ("LOCAL2".equalsIgnoreCase(paramString))
/* 163 */       return 144; 
/* 164 */     if ("LOCAL3".equalsIgnoreCase(paramString))
/* 165 */       return 152; 
/* 166 */     if ("LOCAL4".equalsIgnoreCase(paramString))
/* 167 */       return 160; 
/* 168 */     if ("LOCAL5".equalsIgnoreCase(paramString))
/* 169 */       return 168; 
/* 170 */     if ("LOCAL6".equalsIgnoreCase(paramString))
/* 171 */       return 176; 
/* 172 */     if ("LOCAL7".equalsIgnoreCase(paramString)) {
/* 173 */       return 184;
/*     */     }
/* 175 */     throw new IllegalArgumentException(paramString + " is not a valid syslog facility string");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSyslogHost() {
/* 183 */     return this.syslogHost;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSyslogHost(String paramString) {
/* 193 */     this.syslogHost = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFacility() {
/* 202 */     return this.facilityStr;
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
/*     */   public void setFacility(String paramString) {
/* 216 */     if (paramString != null) {
/* 217 */       paramString = paramString.trim();
/*     */     }
/* 219 */     this.facilityStr = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPort() {
/* 227 */     return this.port;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPort(int paramInt) {
/* 235 */     this.port = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxMessageSize() {
/* 243 */     return this.maxMessageSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxMessageSize(int paramInt) {
/* 254 */     this.maxMessageSize = paramInt;
/*     */   }
/*     */   
/*     */   public Layout<E> getLayout() {
/* 258 */     return this.layout;
/*     */   }
/*     */   
/*     */   public void setLayout(Layout<E> paramLayout) {
/* 262 */     addWarn("The layout of a SyslogAppender cannot be set directly. See also http://logback.qos.ch/codes.html#syslog_layout");
/*     */   }
/*     */ 
/*     */   
/*     */   public void stop() {
/* 267 */     if (this.sos != null) {
/* 268 */       this.sos.close();
/*     */     }
/* 270 */     super.stop();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSuffixPattern() {
/* 279 */     return this.suffixPattern;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSuffixPattern(String paramString) {
/* 289 */     this.suffixPattern = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Charset getCharset() {
/* 297 */     return this.charset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCharset(Charset paramCharset) {
/* 306 */     this.charset = paramCharset;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\net\SyslogAppenderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */