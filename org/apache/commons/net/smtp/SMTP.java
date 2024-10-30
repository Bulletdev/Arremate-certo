/*     */ package org.apache.commons.net.smtp;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.util.ArrayList;
/*     */ import org.apache.commons.net.MalformedServerReplyException;
/*     */ import org.apache.commons.net.ProtocolCommandListener;
/*     */ import org.apache.commons.net.ProtocolCommandSupport;
/*     */ import org.apache.commons.net.SocketClient;
/*     */ import org.apache.commons.net.io.CRLFLineReader;
/*     */ import org.apache.commons.net.util.NetConstants;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SMTP
/*     */   extends SocketClient
/*     */ {
/*     */   public static final int DEFAULT_PORT = 25;
/*     */   private static final String DEFAULT_ENCODING = "ISO-8859-1";
/*     */   protected final String encoding;
/*     */   protected ProtocolCommandSupport _commandSupport_;
/*     */   BufferedReader reader;
/*     */   BufferedWriter writer;
/*     */   private int replyCode;
/*     */   private final ArrayList<String> replyLines;
/*     */   private boolean newReplyString;
/*     */   private String replyString;
/*     */   
/*     */   public SMTP() {
/* 123 */     this("ISO-8859-1");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SMTP(String paramString) {
/* 132 */     setDefaultPort(25);
/* 133 */     this.replyLines = new ArrayList<>();
/* 134 */     this.newReplyString = false;
/* 135 */     this.replyString = null;
/* 136 */     this._commandSupport_ = new ProtocolCommandSupport(this);
/* 137 */     this.encoding = paramString;
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
/*     */   
/*     */   private int sendCommand(String paramString1, String paramString2, boolean paramBoolean) throws IOException {
/* 152 */     StringBuilder stringBuilder = new StringBuilder();
/* 153 */     stringBuilder.append(paramString1);
/*     */     
/* 155 */     if (paramString2 != null) {
/*     */       
/* 157 */       if (paramBoolean) {
/* 158 */         stringBuilder.append(' ');
/*     */       }
/* 160 */       stringBuilder.append(paramString2);
/*     */     } 
/*     */     
/* 163 */     stringBuilder.append("\r\n");
/*     */     
/* 165 */     String str = stringBuilder.toString();
/* 166 */     this.writer.write(str);
/* 167 */     this.writer.flush();
/*     */     
/* 169 */     fireCommandSent(paramString1, str);
/*     */     
/* 171 */     return getReply();
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
/*     */   private int sendCommand(int paramInt, String paramString, boolean paramBoolean) throws IOException {
/* 185 */     return sendCommand(SMTPCommand.getCommand(paramInt), paramString, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void _connectAction_() throws IOException {
/* 192 */     super._connectAction_();
/* 193 */     this.reader = (BufferedReader)new CRLFLineReader(new InputStreamReader(this._input_, this.encoding));
/*     */ 
/*     */     
/* 196 */     this.writer = new BufferedWriter(new OutputStreamWriter(this._output_, this.encoding));
/*     */ 
/*     */     
/* 199 */     getReply();
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
/*     */   
/*     */   public void disconnect() throws IOException {
/* 214 */     super.disconnect();
/* 215 */     this.reader = null;
/* 216 */     this.writer = null;
/* 217 */     this.replyString = null;
/* 218 */     this.replyLines.clear();
/* 219 */     this.newReplyString = false;
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
/*     */   public int sendCommand(String paramString1, String paramString2) throws IOException {
/* 245 */     return sendCommand(paramString1, paramString2, true);
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
/*     */   public int sendCommand(int paramInt, String paramString) throws IOException {
/* 272 */     return sendCommand(SMTPCommand.getCommand(paramInt), paramString);
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
/*     */   public int sendCommand(String paramString) throws IOException {
/* 296 */     return sendCommand(paramString, (String)null);
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
/*     */   public int sendCommand(int paramInt) throws IOException {
/* 321 */     return sendCommand(paramInt, (String)null);
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
/*     */   public int getReplyCode() {
/* 335 */     return this.replyCode;
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
/*     */   public int getReply() throws IOException {
/* 359 */     this.newReplyString = true;
/* 360 */     this.replyLines.clear();
/*     */     
/* 362 */     String str = this.reader.readLine();
/*     */     
/* 364 */     if (str == null) {
/* 365 */       throw new SMTPConnectionClosedException("Connection closed without indication.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 371 */     int i = str.length();
/* 372 */     if (i < 3) {
/* 373 */       throw new MalformedServerReplyException("Truncated server reply: " + str);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 379 */       String str1 = str.substring(0, 3);
/* 380 */       this.replyCode = Integer.parseInt(str1);
/*     */     }
/* 382 */     catch (NumberFormatException numberFormatException) {
/*     */       
/* 384 */       throw new MalformedServerReplyException("Could not parse response code.\nServer Reply: " + str);
/*     */     } 
/*     */ 
/*     */     
/* 388 */     this.replyLines.add(str);
/*     */ 
/*     */     
/* 391 */     if (i > 3 && str.charAt(3) == '-') {
/*     */       do
/*     */       {
/*     */         
/* 395 */         str = this.reader.readLine();
/*     */         
/* 397 */         if (str == null) {
/* 398 */           throw new SMTPConnectionClosedException("Connection closed without indication.");
/*     */         }
/*     */ 
/*     */         
/* 402 */         this.replyLines.add(str);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 408 */       while (str.length() < 4 || str.charAt(3) == '-' || 
/* 409 */         !Character.isDigit(str.charAt(0)));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 415 */     fireReplyReceived(this.replyCode, getReplyString());
/*     */     
/* 417 */     if (this.replyCode == 421) {
/* 418 */       throw new SMTPConnectionClosedException("SMTP response 421 received.  Server closed connection.");
/*     */     }
/*     */     
/* 421 */     return this.replyCode;
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
/*     */   public String[] getReplyStrings() {
/* 434 */     return this.replyLines.<String>toArray(NetConstants.EMPTY_STRING_ARRAY);
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
/*     */   public String getReplyString() {
/* 448 */     if (!this.newReplyString) {
/* 449 */       return this.replyString;
/*     */     }
/*     */     
/* 452 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 454 */     for (String str : this.replyLines) {
/*     */       
/* 456 */       stringBuilder.append(str);
/* 457 */       stringBuilder.append("\r\n");
/*     */     } 
/*     */     
/* 460 */     this.newReplyString = false;
/*     */     
/* 462 */     this.replyString = stringBuilder.toString();
/* 463 */     return this.replyString;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int helo(String paramString) throws IOException {
/* 483 */     return sendCommand(0, paramString);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int mail(String paramString) throws IOException {
/* 503 */     return sendCommand(1, paramString, false);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int rcpt(String paramString) throws IOException {
/* 523 */     return sendCommand(2, paramString, false);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int data() throws IOException {
/* 542 */     return sendCommand(3);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int send(String paramString) throws IOException {
/* 562 */     return sendCommand(4, paramString);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int soml(String paramString) throws IOException {
/* 582 */     return sendCommand(5, paramString);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int saml(String paramString) throws IOException {
/* 602 */     return sendCommand(6, paramString);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int rset() throws IOException {
/* 621 */     return sendCommand(7);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int vrfy(String paramString) throws IOException {
/* 641 */     return sendCommand(8, paramString);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int expn(String paramString) throws IOException {
/* 661 */     return sendCommand(9, paramString);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int help() throws IOException {
/* 679 */     return sendCommand(10);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int help(String paramString) throws IOException {
/* 698 */     return sendCommand(10, paramString);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int noop() throws IOException {
/* 716 */     return sendCommand(11);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int turn() throws IOException {
/* 735 */     return sendCommand(12);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int quit() throws IOException {
/* 754 */     return sendCommand(13);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeProtocolCommandistener(ProtocolCommandListener paramProtocolCommandListener) {
/* 765 */     removeProtocolCommandListener(paramProtocolCommandListener);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ProtocolCommandSupport getCommandSupport() {
/* 773 */     return this._commandSupport_;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\smtp\SMTP.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */