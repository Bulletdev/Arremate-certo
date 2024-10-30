/*     */ package org.apache.commons.net.imap;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ public class IMAP
/*     */   extends SocketClient
/*     */ {
/*     */   public static final int DEFAULT_PORT = 143;
/*     */   protected static final String __DEFAULT_ENCODING = "ISO-8859-1";
/*     */   private IMAPState state;
/*     */   protected BufferedWriter __writer;
/*     */   protected BufferedReader _reader;
/*     */   private int replyCode;
/*     */   private final List<String> replyLines;
/*     */   
/*     */   public static interface IMAPChunkListener
/*     */   {
/*     */     boolean chunkReceived(IMAP param1IMAP);
/*     */   }
/*     */   
/*     */   public enum IMAPState
/*     */   {
/*  46 */     DISCONNECTED_STATE,
/*     */     
/*  48 */     NOT_AUTH_STATE,
/*     */     
/*  50 */     AUTH_STATE,
/*     */     
/*  52 */     LOGOUT_STATE;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 104 */   public static final IMAPChunkListener TRUE_CHUNK_LISTENER = new IMAPChunkListener()
/*     */     {
/*     */       public boolean chunkReceived(IMAP param1IMAP) {
/* 107 */         return true;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   private volatile IMAPChunkListener chunkListener;
/* 113 */   private final char[] initialID = new char[] { 'A', 'A', 'A', 'A' };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IMAP() {
/* 121 */     setDefaultPort(143);
/* 122 */     this.state = IMAPState.DISCONNECTED_STATE;
/* 123 */     this._reader = null;
/* 124 */     this.__writer = null;
/* 125 */     this.replyLines = new ArrayList<>();
/* 126 */     createCommandSupport();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void getReply() throws IOException {
/* 136 */     getReply(true);
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
/*     */   private void getReply(boolean paramBoolean) throws IOException {
/* 148 */     this.replyLines.clear();
/* 149 */     String str = this._reader.readLine();
/*     */     
/* 151 */     if (str == null) {
/* 152 */       throw new EOFException("Connection closed without indication.");
/*     */     }
/*     */     
/* 155 */     this.replyLines.add(str);
/*     */     
/* 157 */     if (paramBoolean) {
/* 158 */       while (IMAPReply.isUntagged(str)) {
/* 159 */         int i = IMAPReply.literalCount(str);
/* 160 */         boolean bool = (i >= 0) ? true : false;
/* 161 */         while (i >= 0) {
/* 162 */           str = this._reader.readLine();
/* 163 */           if (str == null) {
/* 164 */             throw new EOFException("Connection closed without indication.");
/*     */           }
/* 166 */           this.replyLines.add(str);
/* 167 */           i -= str.length() + 2;
/*     */         } 
/* 169 */         if (bool) {
/* 170 */           IMAPChunkListener iMAPChunkListener = this.chunkListener;
/* 171 */           if (iMAPChunkListener != null) {
/* 172 */             boolean bool1 = iMAPChunkListener.chunkReceived(this);
/* 173 */             if (bool1) {
/* 174 */               fireReplyReceived(3, getReplyString());
/* 175 */               this.replyLines.clear();
/*     */             } 
/*     */           } 
/*     */         } 
/* 179 */         str = this._reader.readLine();
/* 180 */         if (str == null) {
/* 181 */           throw new EOFException("Connection closed without indication.");
/*     */         }
/* 183 */         this.replyLines.add(str);
/*     */       } 
/*     */       
/* 186 */       this.replyCode = IMAPReply.getReplyCode(str);
/*     */     } else {
/* 188 */       this.replyCode = IMAPReply.getUntaggedReplyCode(str);
/*     */     } 
/*     */     
/* 191 */     fireReplyReceived(this.replyCode, getReplyString());
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
/*     */   protected void fireReplyReceived(int paramInt, String paramString) {
/* 205 */     if (getCommandSupport().getListenerCount() > 0) {
/* 206 */       getCommandSupport().fireReplyReceived(paramInt, getReplyString());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void _connectAction_() throws IOException {
/* 217 */     super._connectAction_();
/* 218 */     this._reader = (BufferedReader)new CRLFLineReader(new InputStreamReader(this._input_, "ISO-8859-1"));
/*     */ 
/*     */     
/* 221 */     this.__writer = new BufferedWriter(new OutputStreamWriter(this._output_, "ISO-8859-1"));
/*     */ 
/*     */     
/* 224 */     int i = getSoTimeout();
/* 225 */     if (i <= 0) {
/* 226 */       setSoTimeout(this.connectTimeout);
/*     */     }
/* 228 */     getReply(false);
/* 229 */     if (i <= 0) {
/* 230 */       setSoTimeout(i);
/*     */     }
/* 232 */     setState(IMAPState.NOT_AUTH_STATE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setState(IMAPState paramIMAPState) {
/* 243 */     this.state = paramIMAPState;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IMAPState getState() {
/* 254 */     return this.state;
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
/*     */   public void disconnect() throws IOException {
/* 268 */     super.disconnect();
/* 269 */     this._reader = null;
/* 270 */     this.__writer = null;
/* 271 */     this.replyLines.clear();
/* 272 */     setState(IMAPState.DISCONNECTED_STATE);
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
/*     */   private int sendCommandWithID(String paramString1, String paramString2, String paramString3) throws IOException {
/* 286 */     StringBuilder stringBuilder = new StringBuilder();
/* 287 */     if (paramString1 != null) {
/*     */       
/* 289 */       stringBuilder.append(paramString1);
/* 290 */       stringBuilder.append(' ');
/*     */     } 
/* 292 */     stringBuilder.append(paramString2);
/*     */     
/* 294 */     if (paramString3 != null) {
/*     */       
/* 296 */       stringBuilder.append(' ');
/* 297 */       stringBuilder.append(paramString3);
/*     */     } 
/* 299 */     stringBuilder.append("\r\n");
/*     */     
/* 301 */     String str = stringBuilder.toString();
/* 302 */     this.__writer.write(str);
/* 303 */     this.__writer.flush();
/*     */     
/* 305 */     fireCommandSent(paramString2, str);
/*     */     
/* 307 */     getReply();
/* 308 */     return this.replyCode;
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
/*     */   public int sendCommand(String paramString1, String paramString2) throws IOException {
/* 321 */     return sendCommandWithID(generateCommandID(), paramString1, paramString2);
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
/* 334 */     return sendCommand(paramString, (String)null);
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
/*     */   public int sendCommand(IMAPCommand paramIMAPCommand, String paramString) throws IOException {
/* 348 */     return sendCommand(paramIMAPCommand.getIMAPCommand(), paramString);
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
/*     */   public boolean doCommand(IMAPCommand paramIMAPCommand, String paramString) throws IOException {
/* 362 */     return IMAPReply.isSuccess(sendCommand(paramIMAPCommand, paramString));
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
/*     */   public int sendCommand(IMAPCommand paramIMAPCommand) throws IOException {
/* 376 */     return sendCommand(paramIMAPCommand, (String)null);
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
/*     */   public boolean doCommand(IMAPCommand paramIMAPCommand) throws IOException {
/* 389 */     return IMAPReply.isSuccess(sendCommand(paramIMAPCommand));
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
/*     */   public int sendData(String paramString) throws IOException {
/* 401 */     return sendCommandWithID((String)null, paramString, (String)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getReplyStrings() {
/* 411 */     return this.replyLines.<String>toArray(NetConstants.EMPTY_STRING_ARRAY);
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
/*     */   public String getReplyString() {
/* 423 */     StringBuilder stringBuilder = new StringBuilder(256);
/* 424 */     for (String str : this.replyLines) {
/*     */       
/* 426 */       stringBuilder.append(str);
/* 427 */       stringBuilder.append("\r\n");
/*     */     } 
/*     */     
/* 430 */     return stringBuilder.toString();
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
/*     */   public void setChunkListener(IMAPChunkListener paramIMAPChunkListener) {
/* 445 */     this.chunkListener = paramIMAPChunkListener;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String generateCommandID() {
/* 454 */     String str = new String(this.initialID);
/*     */     
/* 456 */     boolean bool = true;
/* 457 */     for (int i = this.initialID.length - 1; bool && i >= 0; i--) {
/*     */       
/* 459 */       if (this.initialID[i] == 'Z') {
/*     */         
/* 461 */         this.initialID[i] = 'A';
/*     */       }
/*     */       else {
/*     */         
/* 465 */         this.initialID[i] = (char)(this.initialID[i] + 1);
/* 466 */         bool = false;
/*     */       } 
/*     */     } 
/* 469 */     return str;
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
/*     */   static String quoteMailboxName(String paramString) {
/* 485 */     if (paramString == null) {
/* 486 */       return null;
/*     */     }
/* 488 */     if (paramString.isEmpty()) {
/* 489 */       return "\"\"";
/*     */     }
/*     */     
/* 492 */     if (paramString.length() > 1 && paramString.startsWith("\"") && paramString.endsWith("\"")) {
/* 493 */       return paramString;
/*     */     }
/* 495 */     if (paramString.contains(" "))
/*     */     {
/* 497 */       return "\"" + paramString.replaceAll("([\\\\\"])", "\\\\$1") + "\"";
/*     */     }
/* 499 */     return paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\imap\IMAP.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */