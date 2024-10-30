/*      */ package org.apache.commons.net.nntp;
/*      */ 
/*      */ import java.io.BufferedReader;
/*      */ import java.io.BufferedWriter;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStreamReader;
/*      */ import java.io.OutputStreamWriter;
/*      */ import java.nio.charset.Charset;
/*      */ import java.nio.charset.StandardCharsets;
/*      */ import org.apache.commons.net.MalformedServerReplyException;
/*      */ import org.apache.commons.net.ProtocolCommandSupport;
/*      */ import org.apache.commons.net.SocketClient;
/*      */ import org.apache.commons.net.io.CRLFLineReader;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class NNTP
/*      */   extends SocketClient
/*      */ {
/*      */   public static final int DEFAULT_PORT = 119;
/*   90 */   private static final Charset DEFAULT_ENCODING = StandardCharsets.ISO_8859_1;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean _isAllowedToPost;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int replyCode;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String replyString;
/*      */ 
/*      */ 
/*      */   
/*      */   protected BufferedReader _reader_;
/*      */ 
/*      */ 
/*      */   
/*      */   protected BufferedWriter _writer_;
/*      */ 
/*      */ 
/*      */   
/*      */   protected ProtocolCommandSupport _commandSupport_;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NNTP() {
/*  123 */     setDefaultPort(119);
/*  124 */     this.replyString = null;
/*  125 */     this._reader_ = null;
/*  126 */     this._writer_ = null;
/*  127 */     this._isAllowedToPost = false;
/*  128 */     this._commandSupport_ = new ProtocolCommandSupport(this);
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
/*      */   protected void _connectAction_() throws IOException {
/*  140 */     super._connectAction_();
/*  141 */     this._reader_ = (BufferedReader)new CRLFLineReader(new InputStreamReader(this._input_, DEFAULT_ENCODING));
/*      */ 
/*      */     
/*  144 */     this._writer_ = new BufferedWriter(new OutputStreamWriter(this._output_, DEFAULT_ENCODING));
/*      */ 
/*      */     
/*  147 */     getReply();
/*      */     
/*  149 */     this._isAllowedToPost = (this.replyCode == 200);
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
/*      */   public void disconnect() throws IOException {
/*  163 */     super.disconnect();
/*  164 */     this._reader_ = null;
/*  165 */     this._writer_ = null;
/*  166 */     this.replyString = null;
/*  167 */     this._isAllowedToPost = false;
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
/*      */   public boolean isAllowedToPost() {
/*  180 */     return this._isAllowedToPost;
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
/*      */   public int sendCommand(String paramString1, String paramString2) throws IOException {
/*  205 */     StringBuilder stringBuilder = new StringBuilder();
/*  206 */     stringBuilder.append(paramString1);
/*      */     
/*  208 */     if (paramString2 != null) {
/*      */       
/*  210 */       stringBuilder.append(' ');
/*  211 */       stringBuilder.append(paramString2);
/*      */     } 
/*  213 */     stringBuilder.append("\r\n");
/*      */     
/*      */     String str;
/*  216 */     this._writer_.write(str = stringBuilder.toString());
/*  217 */     this._writer_.flush();
/*      */     
/*  219 */     fireCommandSent(paramString1, str);
/*      */     
/*  221 */     return getReply();
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
/*      */   public int sendCommand(int paramInt, String paramString) throws IOException {
/*  248 */     return sendCommand(NNTPCommand.getCommand(paramInt), paramString);
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
/*      */   public int sendCommand(String paramString) throws IOException {
/*  272 */     return sendCommand(paramString, (String)null);
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
/*  297 */     return sendCommand(paramInt, (String)null);
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
/*  311 */     return this.replyCode;
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
/*  333 */     this.replyString = this._reader_.readLine();
/*      */     
/*  335 */     if (this.replyString == null) {
/*  336 */       throw new NNTPConnectionClosedException("Connection closed without indication.");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  342 */     if (this.replyString.length() < 3) {
/*  343 */       throw new MalformedServerReplyException("Truncated server reply: " + this.replyString);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/*  349 */       this.replyCode = Integer.parseInt(this.replyString.substring(0, 3));
/*      */     }
/*  351 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  353 */       throw new MalformedServerReplyException("Could not parse response code.\nServer Reply: " + this.replyString);
/*      */     } 
/*      */ 
/*      */     
/*  357 */     fireReplyReceived(this.replyCode, this.replyString + "\r\n");
/*      */     
/*  359 */     if (this.replyCode == 400) {
/*  360 */       throw new NNTPConnectionClosedException("NNTP response 400 received.  Server closed connection.");
/*      */     }
/*      */     
/*  363 */     return this.replyCode;
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
/*      */   public String getReplyString() {
/*  375 */     return this.replyString;
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
/*      */   public int article(String paramString) throws IOException {
/*  396 */     return sendCommand(0, paramString);
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
/*      */   public int article(long paramLong) throws IOException {
/*  416 */     return sendCommand(0, Long.toString(paramLong));
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
/*      */   public int article() throws IOException {
/*  434 */     return sendCommand(0);
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
/*      */   public int body(String paramString) throws IOException {
/*  456 */     return sendCommand(1, paramString);
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
/*      */   public int body(long paramLong) throws IOException {
/*  476 */     return sendCommand(1, Long.toString(paramLong));
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
/*      */   public int body() throws IOException {
/*  494 */     return sendCommand(1);
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
/*      */   public int head(String paramString) throws IOException {
/*  516 */     return sendCommand(3, paramString);
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
/*      */   public int head(long paramLong) throws IOException {
/*  536 */     return sendCommand(3, Long.toString(paramLong));
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
/*      */   public int head() throws IOException {
/*  554 */     return sendCommand(3);
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
/*      */   public int stat(String paramString) throws IOException {
/*  576 */     return sendCommand(14, paramString);
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
/*      */   public int stat(long paramLong) throws IOException {
/*  596 */     return sendCommand(14, Long.toString(paramLong));
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
/*  614 */     return sendCommand(14);
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
/*      */   public int group(String paramString) throws IOException {
/*  634 */     return sendCommand(2, paramString);
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
/*      */   public int help() throws IOException {
/*  653 */     return sendCommand(4);
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
/*      */   public int ihave(String paramString) throws IOException {
/*  674 */     return sendCommand(5, paramString);
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
/*      */   public int last() throws IOException {
/*  693 */     return sendCommand(6);
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
/*      */   public int list() throws IOException {
/*  713 */     return sendCommand(7);
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
/*      */   public int next() throws IOException {
/*  733 */     return sendCommand(10);
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
/*      */   public int newgroups(String paramString1, String paramString2, boolean paramBoolean, String paramString3) throws IOException {
/*  760 */     StringBuilder stringBuilder = new StringBuilder();
/*      */     
/*  762 */     stringBuilder.append(paramString1);
/*  763 */     stringBuilder.append(' ');
/*  764 */     stringBuilder.append(paramString2);
/*      */     
/*  766 */     if (paramBoolean) {
/*      */       
/*  768 */       stringBuilder.append(' ');
/*  769 */       stringBuilder.append("GMT");
/*      */     } 
/*      */     
/*  772 */     if (paramString3 != null) {
/*      */       
/*  774 */       stringBuilder.append(" <");
/*  775 */       stringBuilder.append(paramString3);
/*  776 */       stringBuilder.append('>');
/*      */     } 
/*      */     
/*  779 */     return sendCommand(8, stringBuilder.toString());
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
/*      */   public int newnews(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4) throws IOException {
/*  808 */     StringBuilder stringBuilder = new StringBuilder();
/*      */     
/*  810 */     stringBuilder.append(paramString1);
/*  811 */     stringBuilder.append(' ');
/*  812 */     stringBuilder.append(paramString2);
/*  813 */     stringBuilder.append(' ');
/*  814 */     stringBuilder.append(paramString3);
/*      */     
/*  816 */     if (paramBoolean) {
/*      */       
/*  818 */       stringBuilder.append(' ');
/*  819 */       stringBuilder.append("GMT");
/*      */     } 
/*      */     
/*  822 */     if (paramString4 != null) {
/*      */       
/*  824 */       stringBuilder.append(" <");
/*  825 */       stringBuilder.append(paramString4);
/*  826 */       stringBuilder.append('>');
/*      */     } 
/*      */     
/*  829 */     return sendCommand(9, stringBuilder.toString());
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
/*      */   public int post() throws IOException {
/*  849 */     return sendCommand(11);
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
/*      */   public int quit() throws IOException {
/*  869 */     return sendCommand(12);
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
/*      */   public int authinfoUser(String paramString) throws IOException {
/*  888 */     String str = "USER " + paramString;
/*  889 */     return sendCommand(15, str);
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
/*      */   public int authinfoPass(String paramString) throws IOException {
/*  910 */     String str = "PASS " + paramString;
/*  911 */     return sendCommand(15, str);
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
/*      */   public int xover(String paramString) throws IOException {
/*  935 */     return sendCommand(16, paramString);
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
/*      */   public int xhdr(String paramString1, String paramString2) throws IOException {
/*  961 */     StringBuilder stringBuilder = new StringBuilder(paramString1);
/*  962 */     stringBuilder.append(" ");
/*  963 */     stringBuilder.append(paramString2);
/*  964 */     return sendCommand(17, stringBuilder.toString());
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
/*      */   public int listActive(String paramString) throws IOException {
/*  977 */     StringBuilder stringBuilder = new StringBuilder("ACTIVE ");
/*  978 */     stringBuilder.append(paramString);
/*  979 */     return sendCommand(7, stringBuilder.toString());
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
/*      */   @Deprecated
/*      */   public int article(int paramInt) throws IOException {
/*  993 */     return article(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public int body(int paramInt) throws IOException {
/* 1005 */     return body(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public int head(int paramInt) throws IOException {
/* 1017 */     return head(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public int stat(int paramInt) throws IOException {
/* 1029 */     return stat(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected ProtocolCommandSupport getCommandSupport() {
/* 1037 */     return this._commandSupport_;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\nntp\NNTP.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */