/*     */ package org.apache.commons.net.pop3;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ public class POP3
/*     */   extends SocketClient
/*     */ {
/*     */   public static final int DEFAULT_PORT = 110;
/*     */   public static final int DISCONNECTED_STATE = -1;
/*     */   public static final int AUTHORIZATION_STATE = 0;
/*     */   public static final int TRANSACTION_STATE = 1;
/*     */   public static final int UPDATE_STATE = 2;
/*     */   static final String OK = "+OK";
/*     */   static final String OK_INT = "+ ";
/*     */   static final String ERROR = "-ERR";
/*  82 */   static final Charset DEFAULT_ENCODING = StandardCharsets.ISO_8859_1;
/*     */ 
/*     */   
/*     */   private int popState;
/*     */ 
/*     */   
/*     */   BufferedWriter writer;
/*     */ 
/*     */   
/*     */   BufferedReader reader;
/*     */ 
/*     */   
/*     */   int replyCode;
/*     */   
/*     */   String lastReplyLine;
/*     */   
/*     */   List<String> replyLines;
/*     */   
/*     */   protected ProtocolCommandSupport _commandSupport_;
/*     */ 
/*     */   
/*     */   public POP3() {
/* 104 */     setDefaultPort(110);
/* 105 */     this.popState = -1;
/* 106 */     this.reader = null;
/* 107 */     this.writer = null;
/* 108 */     this.replyLines = new ArrayList<>();
/* 109 */     this._commandSupport_ = new ProtocolCommandSupport(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void getReply() throws IOException {
/* 116 */     this.replyLines.clear();
/* 117 */     String str = this.reader.readLine();
/*     */     
/* 119 */     if (str == null) {
/* 120 */       throw new EOFException("Connection closed without indication.");
/*     */     }
/*     */     
/* 123 */     if (str.startsWith("+OK")) {
/* 124 */       this.replyCode = 0;
/* 125 */     } else if (str.startsWith("-ERR")) {
/* 126 */       this.replyCode = 1;
/* 127 */     } else if (str.startsWith("+ ")) {
/* 128 */       this.replyCode = 2;
/*     */     } else {
/* 130 */       throw new MalformedServerReplyException("Received invalid POP3 protocol response from server." + str);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 135 */     this.replyLines.add(str);
/* 136 */     this.lastReplyLine = str;
/*     */     
/* 138 */     fireReplyReceived(this.replyCode, getReplyString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void _connectAction_() throws IOException {
/* 149 */     super._connectAction_();
/* 150 */     this.reader = (BufferedReader)new CRLFLineReader(new InputStreamReader(this._input_, DEFAULT_ENCODING));
/*     */ 
/*     */     
/* 153 */     this.writer = new BufferedWriter(new OutputStreamWriter(this._output_, DEFAULT_ENCODING));
/*     */ 
/*     */     
/* 156 */     getReply();
/* 157 */     setState(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setState(int paramInt) {
/* 167 */     this.popState = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getState() {
/* 178 */     return this.popState;
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
/*     */   public void getAdditionalReply() throws IOException {
/* 190 */     String str = this.reader.readLine();
/* 191 */     while (str != null) {
/*     */       
/* 193 */       this.replyLines.add(str);
/* 194 */       if (str.equals(".")) {
/*     */         break;
/*     */       }
/* 197 */       str = this.reader.readLine();
/*     */     } 
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
/* 213 */     super.disconnect();
/* 214 */     this.reader = null;
/* 215 */     this.writer = null;
/* 216 */     this.lastReplyLine = null;
/* 217 */     this.replyLines.clear();
/* 218 */     setState(-1);
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
/*     */   public int sendCommand(String paramString1, String paramString2) throws IOException {
/* 232 */     if (this.writer == null) {
/* 233 */       throw new IllegalStateException("Socket is not connected");
/*     */     }
/* 235 */     StringBuilder stringBuilder = new StringBuilder();
/* 236 */     stringBuilder.append(paramString1);
/*     */     
/* 238 */     if (paramString2 != null) {
/*     */       
/* 240 */       stringBuilder.append(' ');
/* 241 */       stringBuilder.append(paramString2);
/*     */     } 
/* 243 */     stringBuilder.append("\r\n");
/*     */     
/* 245 */     String str = stringBuilder.toString();
/* 246 */     this.writer.write(str);
/* 247 */     this.writer.flush();
/*     */     
/* 249 */     fireCommandSent(paramString1, str);
/*     */     
/* 251 */     getReply();
/* 252 */     return this.replyCode;
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
/*     */   public int sendCommand(String paramString) throws IOException {
/* 265 */     return sendCommand(paramString, (String)null);
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
/*     */   public int sendCommand(int paramInt, String paramString) throws IOException {
/* 279 */     return sendCommand(POP3Command.commands[paramInt], paramString);
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
/*     */   public int sendCommand(int paramInt) throws IOException {
/* 293 */     return sendCommand(POP3Command.commands[paramInt], (String)null);
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
/*     */   public String[] getReplyStrings() {
/* 311 */     return this.replyLines.<String>toArray(NetConstants.EMPTY_STRING_ARRAY);
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
/*     */   public String getReplyString() {
/* 328 */     StringBuilder stringBuilder = new StringBuilder(256);
/*     */     
/* 330 */     for (String str : this.replyLines) {
/*     */       
/* 332 */       stringBuilder.append(str);
/* 333 */       stringBuilder.append("\r\n");
/*     */     } 
/*     */     
/* 336 */     return stringBuilder.toString();
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
/* 347 */     removeProtocolCommandListener(paramProtocolCommandListener);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ProtocolCommandSupport getCommandSupport() {
/* 355 */     return this._commandSupport_;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\pop3\POP3.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */