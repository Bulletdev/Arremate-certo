/*     */ package org.apache.commons.net.ftp;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.Socket;
/*     */ import java.net.SocketException;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.ArrayList;
/*     */ import org.apache.commons.net.util.Base64;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FTPHTTPClient
/*     */   extends FTPClient
/*     */ {
/*     */   private final String proxyHost;
/*     */   private final int proxyPort;
/*     */   private final String proxyUsername;
/*     */   private final String proxyPassword;
/*     */   private final Charset charset;
/*  49 */   private static final byte[] CRLF = new byte[] { 13, 10 };
/*  50 */   private final Base64 base64 = new Base64();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String tunnelHost;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FTPHTTPClient(String paramString1, int paramInt, String paramString2, String paramString3, Charset paramCharset) {
/*  65 */     this.proxyHost = paramString1;
/*  66 */     this.proxyPort = paramInt;
/*  67 */     this.proxyUsername = paramString2;
/*  68 */     this.proxyPassword = paramString3;
/*  69 */     this.tunnelHost = null;
/*  70 */     this.charset = paramCharset;
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
/*     */   public FTPHTTPClient(String paramString1, int paramInt, String paramString2, String paramString3) {
/*  82 */     this(paramString1, paramInt, paramString2, paramString3, StandardCharsets.UTF_8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FTPHTTPClient(String paramString, int paramInt) {
/*  92 */     this(paramString, paramInt, (String)null, (String)null);
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
/*     */   public FTPHTTPClient(String paramString, int paramInt, Charset paramCharset) {
/* 104 */     this(paramString, paramInt, (String)null, (String)null, paramCharset);
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
/*     */   @Deprecated
/*     */   protected Socket _openDataConnection_(int paramInt, String paramString) throws IOException {
/* 120 */     return super._openDataConnection_(paramInt, paramString);
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
/*     */   protected Socket _openDataConnection_(String paramString1, String paramString2) throws IOException {
/* 133 */     if (getDataConnectionMode() != 2) {
/* 134 */       throw new IllegalStateException("Only passive connection mode supported");
/*     */     }
/*     */     
/* 137 */     boolean bool = getRemoteAddress() instanceof java.net.Inet6Address;
/* 138 */     String str = null;
/*     */     
/* 140 */     boolean bool1 = (isUseEPSVwithIPv4() || bool) ? true : false;
/* 141 */     if (bool1 && epsv() == 229) {
/* 142 */       _parseExtendedPassiveModeReply(this._replyLines.get(0));
/* 143 */       str = this.tunnelHost;
/*     */     } else {
/* 145 */       if (bool) {
/* 146 */         return null;
/*     */       }
/*     */       
/* 149 */       if (pasv() != 227) {
/* 150 */         return null;
/*     */       }
/* 152 */       _parsePassiveModeReply(this._replyLines.get(0));
/* 153 */       str = getPassiveHost();
/*     */     } 
/*     */     
/* 156 */     Socket socket = this._socketFactory_.createSocket(this.proxyHost, this.proxyPort);
/* 157 */     InputStream inputStream = socket.getInputStream();
/* 158 */     OutputStream outputStream = socket.getOutputStream();
/* 159 */     tunnelHandshake(str, getPassivePort(), inputStream, outputStream);
/* 160 */     if (getRestartOffset() > 0L && !restart(getRestartOffset())) {
/* 161 */       socket.close();
/* 162 */       return null;
/*     */     } 
/*     */     
/* 165 */     if (!FTPReply.isPositivePreliminary(sendCommand(paramString1, paramString2))) {
/* 166 */       socket.close();
/* 167 */       return null;
/*     */     } 
/*     */     
/* 170 */     return socket;
/*     */   }
/*     */ 
/*     */   
/*     */   public void connect(String paramString, int paramInt) throws SocketException, IOException {
/*     */     BufferedReader bufferedReader;
/* 176 */     this._socket_ = this._socketFactory_.createSocket(this.proxyHost, this.proxyPort);
/* 177 */     this._input_ = this._socket_.getInputStream();
/* 178 */     this._output_ = this._socket_.getOutputStream();
/*     */     
/*     */     try {
/* 181 */       bufferedReader = tunnelHandshake(paramString, paramInt, this._input_, this._output_);
/*     */     }
/* 183 */     catch (Exception exception) {
/* 184 */       IOException iOException = new IOException("Could not connect to " + paramString + " using port " + paramInt);
/* 185 */       iOException.initCause(exception);
/* 186 */       throw iOException;
/*     */     } 
/* 188 */     _connectAction_(bufferedReader);
/*     */   }
/*     */ 
/*     */   
/*     */   private BufferedReader tunnelHandshake(String paramString, int paramInt, InputStream paramInputStream, OutputStream paramOutputStream) throws IOException, UnsupportedEncodingException {
/* 193 */     String str1 = "CONNECT " + paramString + ":" + paramInt + " HTTP/1.1";
/* 194 */     String str2 = "Host: " + paramString + ":" + paramInt;
/*     */     
/* 196 */     this.tunnelHost = paramString;
/* 197 */     paramOutputStream.write(str1.getBytes(this.charset));
/* 198 */     paramOutputStream.write(CRLF);
/* 199 */     paramOutputStream.write(str2.getBytes(this.charset));
/* 200 */     paramOutputStream.write(CRLF);
/*     */     
/* 202 */     if (this.proxyUsername != null && this.proxyPassword != null) {
/* 203 */       String str6 = this.proxyUsername + ":" + this.proxyPassword;
/* 204 */       String str7 = "Proxy-Authorization: Basic " + this.base64.encodeToString(str6.getBytes(this.charset));
/* 205 */       paramOutputStream.write(str7.getBytes(this.charset));
/*     */     } 
/* 207 */     paramOutputStream.write(CRLF);
/*     */     
/* 209 */     ArrayList<String> arrayList = new ArrayList();
/* 210 */     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(paramInputStream, getCharset()));
/*     */     
/* 212 */     for (String str3 = bufferedReader.readLine(); str3 != null && !str3.isEmpty(); str3 = bufferedReader.readLine()) {
/* 213 */       arrayList.add(str3);
/*     */     }
/*     */     
/* 216 */     int i = arrayList.size();
/* 217 */     if (i == 0) {
/* 218 */       throw new IOException("No response from proxy");
/*     */     }
/*     */     
/* 221 */     String str4 = null;
/* 222 */     String str5 = arrayList.get(0);
/* 223 */     if (str5.startsWith("HTTP/") && str5.length() >= 12) {
/* 224 */       str4 = str5.substring(9, 12);
/*     */     } else {
/* 226 */       throw new IOException("Invalid response from proxy: " + str5);
/*     */     } 
/*     */     
/* 229 */     if (!"200".equals(str4)) {
/* 230 */       StringBuilder stringBuilder = new StringBuilder();
/* 231 */       stringBuilder.append("HTTPTunnelConnector: connection failed\r\n");
/* 232 */       stringBuilder.append("Response received from the proxy:\r\n");
/* 233 */       for (String str : arrayList) {
/* 234 */         stringBuilder.append(str);
/* 235 */         stringBuilder.append("\r\n");
/*     */       } 
/* 237 */       throw new IOException(stringBuilder.toString());
/*     */     } 
/* 239 */     return bufferedReader;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\FTPHTTPClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */