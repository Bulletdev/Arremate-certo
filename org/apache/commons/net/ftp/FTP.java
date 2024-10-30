/*      */ package org.apache.commons.net.ftp;
/*      */ 
/*      */ import java.io.BufferedReader;
/*      */ import java.io.BufferedWriter;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStreamReader;
/*      */ import java.io.OutputStreamWriter;
/*      */ import java.io.Reader;
/*      */ import java.net.InetAddress;
/*      */ import java.net.SocketException;
/*      */ import java.net.SocketTimeoutException;
/*      */ import java.util.ArrayList;
/*      */ import org.apache.commons.net.MalformedServerReplyException;
/*      */ import org.apache.commons.net.ProtocolCommandSupport;
/*      */ import org.apache.commons.net.SocketClient;
/*      */ import org.apache.commons.net.io.CRLFLineReader;
/*      */ import org.apache.commons.net.util.NetConstants;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class FTP
/*      */   extends SocketClient
/*      */ {
/*      */   public static final int DEFAULT_DATA_PORT = 20;
/*      */   public static final int DEFAULT_PORT = 21;
/*      */   public static final int ASCII_FILE_TYPE = 0;
/*      */   public static final int EBCDIC_FILE_TYPE = 1;
/*      */   public static final int BINARY_FILE_TYPE = 2;
/*      */   public static final int LOCAL_FILE_TYPE = 3;
/*      */   public static final int NON_PRINT_TEXT_FORMAT = 4;
/*      */   public static final int TELNET_TEXT_FORMAT = 5;
/*      */   public static final int CARRIAGE_CONTROL_TEXT_FORMAT = 6;
/*      */   public static final int FILE_STRUCTURE = 7;
/*      */   public static final int RECORD_STRUCTURE = 8;
/*      */   public static final int PAGE_STRUCTURE = 9;
/*      */   public static final int STREAM_TRANSFER_MODE = 10;
/*      */   public static final int BLOCK_TRANSFER_MODE = 11;
/*      */   public static final int COMPRESSED_TRANSFER_MODE = 12;
/*      */   public static final String DEFAULT_CONTROL_ENCODING = "ISO-8859-1";
/*      */   public static final int REPLY_CODE_LEN = 3;
/*      */   private static final String modes = "AEILNTCFRPSBC";
/*      */   protected int _replyCode;
/*      */   protected ArrayList<String> _replyLines;
/*      */   protected boolean _newReplyString;
/*      */   protected String _replyString;
/*      */   protected String _controlEncoding;
/*      */   protected ProtocolCommandSupport _commandSupport_;
/*      */   protected boolean strictMultilineParsing;
/*      */   private boolean strictReplyParsing = true;
/*      */   protected BufferedReader _controlInput_;
/*      */   protected BufferedWriter _controlOutput_;
/*      */   
/*      */   public FTP() {
/*  270 */     setDefaultPort(21);
/*  271 */     this._replyLines = new ArrayList<>();
/*  272 */     this._newReplyString = false;
/*  273 */     this._replyString = null;
/*  274 */     this._controlEncoding = "ISO-8859-1";
/*  275 */     this._commandSupport_ = new ProtocolCommandSupport(this);
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean strictCheck(String paramString1, String paramString2) {
/*  280 */     return (!paramString1.startsWith(paramString2) || paramString1.charAt(3) != ' ');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean lenientCheck(String paramString) {
/*  289 */     return (paramString.length() <= 3 || paramString.charAt(3) == '-' || 
/*  290 */       !Character.isDigit(paramString.charAt(0)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void __getReplyNoReport() throws IOException {
/*  301 */     getReply(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int getReply(boolean paramBoolean) throws IOException {
/*  308 */     this._newReplyString = true;
/*  309 */     this._replyLines.clear();
/*      */     
/*  311 */     String str1 = this._controlInput_.readLine();
/*      */     
/*  313 */     if (str1 == null) {
/*  314 */       throw new FTPConnectionClosedException("Connection closed without indication.");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  320 */     int i = str1.length();
/*  321 */     if (i < 3) {
/*  322 */       throw new MalformedServerReplyException("Truncated server reply: " + str1);
/*      */     }
/*      */ 
/*      */     
/*  326 */     String str2 = null;
/*      */     
/*      */     try {
/*  329 */       str2 = str1.substring(0, 3);
/*  330 */       this._replyCode = Integer.parseInt(str2);
/*      */     }
/*  332 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  334 */       throw new MalformedServerReplyException("Could not parse response code.\nServer Reply: " + str1);
/*      */     } 
/*      */ 
/*      */     
/*  338 */     this._replyLines.add(str1);
/*      */ 
/*      */     
/*  341 */     if (i > 3) {
/*  342 */       char c = str1.charAt(3);
/*      */       
/*  344 */       if (c == '-') {
/*      */         
/*      */         while (true)
/*  347 */         { str1 = this._controlInput_.readLine();
/*      */           
/*  349 */           if (str1 == null) {
/*  350 */             throw new FTPConnectionClosedException("Connection closed without indication.");
/*      */           }
/*      */ 
/*      */           
/*  354 */           this._replyLines.add(str1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  360 */           if (isStrictMultilineParsing() ? strictCheck(str1, str2) : lenientCheck(str1))
/*      */             continue;  break; } 
/*  362 */       } else if (isStrictReplyParsing()) {
/*  363 */         if (i == 4)
/*  364 */           throw new MalformedServerReplyException("Truncated server reply: '" + str1 + "'"); 
/*  365 */         if (c != ' ') {
/*  366 */           throw new MalformedServerReplyException("Invalid server reply: '" + str1 + "'");
/*      */         }
/*      */       } 
/*  369 */     } else if (isStrictReplyParsing()) {
/*  370 */       throw new MalformedServerReplyException("Truncated server reply: '" + str1 + "'");
/*      */     } 
/*      */     
/*  373 */     if (paramBoolean) {
/*  374 */       fireReplyReceived(this._replyCode, getReplyString());
/*      */     }
/*      */     
/*  377 */     if (this._replyCode == 421) {
/*  378 */       throw new FTPConnectionClosedException("FTP response 421 received.  Server closed connection.");
/*      */     }
/*  380 */     return this._replyCode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void _connectAction_() throws IOException {
/*  390 */     _connectAction_((Reader)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void _connectAction_(Reader paramReader) throws IOException {
/*  403 */     super._connectAction_();
/*  404 */     if (paramReader == null) {
/*  405 */       this
/*  406 */         ._controlInput_ = (BufferedReader)new CRLFLineReader(new InputStreamReader(this._input_, getControlEncoding()));
/*      */     } else {
/*  408 */       this._controlInput_ = (BufferedReader)new CRLFLineReader(paramReader);
/*      */     } 
/*  410 */     this
/*  411 */       ._controlOutput_ = new BufferedWriter(new OutputStreamWriter(this._output_, getControlEncoding()));
/*  412 */     if (this.connectTimeout > 0) {
/*  413 */       int i = this._socket_.getSoTimeout();
/*  414 */       this._socket_.setSoTimeout(this.connectTimeout);
/*      */       try {
/*  416 */         getReply();
/*      */         
/*  418 */         if (FTPReply.isPositivePreliminary(this._replyCode)) {
/*  419 */           getReply();
/*      */         }
/*  421 */       } catch (SocketTimeoutException socketTimeoutException) {
/*  422 */         IOException iOException = new IOException("Timed out waiting for initial connect reply");
/*  423 */         iOException.initCause(socketTimeoutException);
/*  424 */         throw iOException;
/*      */       } finally {
/*  426 */         this._socket_.setSoTimeout(i);
/*      */       } 
/*      */     } else {
/*  429 */       getReply();
/*      */       
/*  431 */       if (FTPReply.isPositivePreliminary(this._replyCode)) {
/*  432 */         getReply();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setControlEncoding(String paramString) {
/*  449 */     this._controlEncoding = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getControlEncoding() {
/*  458 */     return this._controlEncoding;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void disconnect() throws IOException {
/*  474 */     super.disconnect();
/*  475 */     this._controlInput_ = null;
/*  476 */     this._controlOutput_ = null;
/*  477 */     this._newReplyString = false;
/*  478 */     this._replyString = null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sendCommand(String paramString1, String paramString2) throws IOException {
/*  504 */     if (this._controlOutput_ == null) {
/*  505 */       throw new IOException("Connection is not open");
/*      */     }
/*      */     
/*  508 */     String str = buildMessage(paramString1, paramString2);
/*      */     
/*  510 */     send(str);
/*      */     
/*  512 */     fireCommandSent(paramString1, str);
/*      */     
/*  514 */     return getReply();
/*      */   }
/*      */   
/*      */   private String buildMessage(String paramString1, String paramString2) {
/*  518 */     StringBuilder stringBuilder = new StringBuilder();
/*      */     
/*  520 */     stringBuilder.append(paramString1);
/*      */     
/*  522 */     if (paramString2 != null) {
/*      */       
/*  524 */       stringBuilder.append(' ');
/*  525 */       stringBuilder.append(paramString2);
/*      */     } 
/*  527 */     stringBuilder.append("\r\n");
/*  528 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   private void send(String paramString) throws IOException, FTPConnectionClosedException, SocketException {
/*      */     try {
/*  534 */       this._controlOutput_.write(paramString);
/*  535 */       this._controlOutput_.flush();
/*      */     }
/*  537 */     catch (SocketException socketException) {
/*      */       
/*  539 */       if (!isConnected())
/*      */       {
/*  541 */         throw new FTPConnectionClosedException("Connection unexpectedly closed.");
/*      */       }
/*  543 */       throw socketException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void __noop() throws IOException {
/*  555 */     String str = buildMessage(FTPCmd.NOOP.getCommand(), (String)null);
/*  556 */     send(str);
/*  557 */     __getReplyNoReport();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public int sendCommand(int paramInt, String paramString) throws IOException {
/*  585 */     return sendCommand(FTPCommand.getCommand(paramInt), paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sendCommand(FTPCmd paramFTPCmd) throws IOException {
/*  609 */     return sendCommand(paramFTPCmd, (String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sendCommand(FTPCmd paramFTPCmd, String paramString) throws IOException {
/*  635 */     return sendCommand(paramFTPCmd.getCommand(), paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sendCommand(String paramString) throws IOException {
/*  658 */     return sendCommand(paramString, (String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sendCommand(int paramInt) throws IOException {
/*  683 */     return sendCommand(paramInt, (String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getReplyCode() {
/*  697 */     return this._replyCode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getReply() throws IOException {
/*  719 */     return getReply(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] getReplyStrings() {
/*  732 */     return this._replyLines.<String>toArray(NetConstants.EMPTY_STRING_ARRAY);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   String getReplyString(int paramInt) {
/*  745 */     return this._replyLines.get(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getReplyString() {
/*  759 */     if (!this._newReplyString) {
/*  760 */       return this._replyString;
/*      */     }
/*      */     
/*  763 */     StringBuilder stringBuilder = new StringBuilder(256);
/*      */     
/*  765 */     for (String str : this._replyLines) {
/*  766 */       stringBuilder.append(str);
/*  767 */       stringBuilder.append("\r\n");
/*      */     } 
/*      */     
/*  770 */     this._newReplyString = false;
/*      */     
/*  772 */     return this._replyString = stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int user(String paramString) throws IOException {
/*  792 */     return sendCommand(FTPCmd.USER, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int pass(String paramString) throws IOException {
/*  810 */     return sendCommand(FTPCmd.PASS, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int acct(String paramString) throws IOException {
/*  829 */     return sendCommand(FTPCmd.ACCT, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int abor() throws IOException {
/*  848 */     return sendCommand(FTPCmd.ABOR);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int cwd(String paramString) throws IOException {
/*  867 */     return sendCommand(FTPCmd.CWD, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int cdup() throws IOException {
/*  885 */     return sendCommand(FTPCmd.CDUP);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int quit() throws IOException {
/*  903 */     return sendCommand(FTPCmd.QUIT);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int rein() throws IOException {
/*  921 */     return sendCommand(FTPCmd.REIN);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int smnt(String paramString) throws IOException {
/*  940 */     return sendCommand(FTPCmd.SMNT, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int port(InetAddress paramInetAddress, int paramInt) throws IOException {
/*  961 */     StringBuilder stringBuilder = new StringBuilder(24);
/*      */     
/*  963 */     stringBuilder.append(paramInetAddress.getHostAddress().replace('.', ','));
/*  964 */     int i = paramInt >>> 8;
/*  965 */     stringBuilder.append(',');
/*  966 */     stringBuilder.append(i);
/*  967 */     stringBuilder.append(',');
/*  968 */     i = paramInt & 0xFF;
/*  969 */     stringBuilder.append(i);
/*      */     
/*  971 */     return sendCommand(FTPCmd.PORT, stringBuilder.toString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int eprt(InetAddress paramInetAddress, int paramInt) throws IOException {
/* 1001 */     StringBuilder stringBuilder = new StringBuilder();
/*      */ 
/*      */ 
/*      */     
/* 1005 */     String str = paramInetAddress.getHostAddress();
/* 1006 */     int i = str.indexOf('%');
/* 1007 */     if (i > 0) {
/* 1008 */       str = str.substring(0, i);
/*      */     }
/*      */     
/* 1011 */     stringBuilder.append("|");
/*      */     
/* 1013 */     if (paramInetAddress instanceof java.net.Inet4Address) {
/* 1014 */       stringBuilder.append("1");
/* 1015 */     } else if (paramInetAddress instanceof java.net.Inet6Address) {
/* 1016 */       stringBuilder.append("2");
/*      */     } 
/* 1018 */     stringBuilder.append("|");
/* 1019 */     stringBuilder.append(str);
/* 1020 */     stringBuilder.append("|");
/* 1021 */     stringBuilder.append(paramInt);
/* 1022 */     stringBuilder.append("|");
/*      */     
/* 1024 */     return sendCommand(FTPCmd.EPRT, stringBuilder.toString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int pasv() throws IOException {
/* 1044 */     return sendCommand(FTPCmd.PASV);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int epsv() throws IOException {
/* 1065 */     return sendCommand(FTPCmd.EPSV);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int type(int paramInt1, int paramInt2) throws IOException {
/* 1087 */     StringBuilder stringBuilder = new StringBuilder();
/*      */     
/* 1089 */     stringBuilder.append("AEILNTCFRPSBC".charAt(paramInt1));
/* 1090 */     stringBuilder.append(' ');
/* 1091 */     if (paramInt1 == 3) {
/* 1092 */       stringBuilder.append(paramInt2);
/*      */     } else {
/* 1094 */       stringBuilder.append("AEILNTCFRPSBC".charAt(paramInt2));
/*      */     } 
/*      */     
/* 1097 */     return sendCommand(FTPCmd.TYPE, stringBuilder.toString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int type(int paramInt) throws IOException {
/* 1118 */     return sendCommand(FTPCmd.TYPE, "AEILNTCFRPSBC"
/* 1119 */         .substring(paramInt, paramInt + 1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int stru(int paramInt) throws IOException {
/* 1139 */     return sendCommand(FTPCmd.STRU, "AEILNTCFRPSBC"
/* 1140 */         .substring(paramInt, paramInt + 1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int mode(int paramInt) throws IOException {
/* 1160 */     return sendCommand(FTPCmd.MODE, "AEILNTCFRPSBC"
/* 1161 */         .substring(paramInt, paramInt + 1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int retr(String paramString) throws IOException {
/* 1183 */     return sendCommand(FTPCmd.RETR, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int stor(String paramString) throws IOException {
/* 1206 */     return sendCommand(FTPCmd.STOR, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int stou() throws IOException {
/* 1227 */     return sendCommand(FTPCmd.STOU);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int stou(String paramString) throws IOException {
/* 1250 */     return sendCommand(FTPCmd.STOU, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int appe(String paramString) throws IOException {
/* 1273 */     return sendCommand(FTPCmd.APPE, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int allo(int paramInt) throws IOException {
/* 1292 */     return sendCommand(FTPCmd.ALLO, Integer.toString(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int allo(long paramLong) throws IOException {
/* 1311 */     return sendCommand(FTPCmd.ALLO, Long.toString(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int feat() throws IOException {
/* 1324 */     return sendCommand(FTPCmd.FEAT);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int allo(int paramInt1, int paramInt2) throws IOException {
/* 1344 */     return sendCommand(FTPCmd.ALLO, Integer.toString(paramInt1) + " R " + 
/* 1345 */         Integer.toString(paramInt2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int allo(long paramLong, int paramInt) throws IOException {
/* 1365 */     return sendCommand(FTPCmd.ALLO, Long.toString(paramLong) + " R " + 
/* 1366 */         Integer.toString(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int rest(String paramString) throws IOException {
/* 1385 */     return sendCommand(FTPCmd.REST, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int mdtm(String paramString) throws IOException {
/* 1399 */     return sendCommand(FTPCmd.MDTM, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int mfmt(String paramString1, String paramString2) throws IOException {
/* 1422 */     return sendCommand(FTPCmd.MFMT, paramString2 + " " + paramString1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int rnfr(String paramString) throws IOException {
/* 1442 */     return sendCommand(FTPCmd.RNFR, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int rnto(String paramString) throws IOException {
/* 1461 */     return sendCommand(FTPCmd.RNTO, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int dele(String paramString) throws IOException {
/* 1480 */     return sendCommand(FTPCmd.DELE, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int rmd(String paramString) throws IOException {
/* 1499 */     return sendCommand(FTPCmd.RMD, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int mkd(String paramString) throws IOException {
/* 1518 */     return sendCommand(FTPCmd.MKD, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int pwd() throws IOException {
/* 1536 */     return sendCommand(FTPCmd.PWD);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int list() throws IOException {
/* 1557 */     return sendCommand(FTPCmd.LIST);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int list(String paramString) throws IOException {
/* 1580 */     return sendCommand(FTPCmd.LIST, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int mlsd() throws IOException {
/* 1602 */     return sendCommand(FTPCmd.MLSD);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int mlsd(String paramString) throws IOException {
/* 1626 */     return sendCommand(FTPCmd.MLSD, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int mlst() throws IOException {
/* 1648 */     return sendCommand(FTPCmd.MLST);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int mlst(String paramString) throws IOException {
/* 1672 */     return sendCommand(FTPCmd.MLST, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int nlst() throws IOException {
/* 1693 */     return sendCommand(FTPCmd.NLST);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int nlst(String paramString) throws IOException {
/* 1716 */     return sendCommand(FTPCmd.NLST, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int site(String paramString) throws IOException {
/* 1735 */     return sendCommand(FTPCmd.SITE, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int size(String paramString) throws IOException {
/* 1755 */     return sendCommand(FTPCmd.SIZE, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int syst() throws IOException {
/* 1773 */     return sendCommand(FTPCmd.SYST);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int stat() throws IOException {
/* 1791 */     return sendCommand(FTPCmd.STAT);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int stat(String paramString) throws IOException {
/* 1810 */     return sendCommand(FTPCmd.STAT, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int help() throws IOException {
/* 1828 */     return sendCommand(FTPCmd.HELP);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int help(String paramString) throws IOException {
/* 1847 */     return sendCommand(FTPCmd.HELP, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int noop() throws IOException {
/* 1865 */     return sendCommand(FTPCmd.NOOP);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isStrictMultilineParsing() {
/* 1874 */     return this.strictMultilineParsing;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStrictMultilineParsing(boolean paramBoolean) {
/* 1883 */     this.strictMultilineParsing = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isStrictReplyParsing() {
/* 1897 */     return this.strictReplyParsing;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStrictReplyParsing(boolean paramBoolean) {
/* 1913 */     this.strictReplyParsing = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected ProtocolCommandSupport getCommandSupport() {
/* 1921 */     return this._commandSupport_;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\FTP.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */