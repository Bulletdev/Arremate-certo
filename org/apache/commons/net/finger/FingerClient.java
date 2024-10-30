/*     */ package org.apache.commons.net.finger;
/*     */ 
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import org.apache.commons.net.SocketClient;
/*     */ import org.apache.commons.net.util.Charsets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FingerClient
/*     */   extends SocketClient
/*     */ {
/*     */   public static final int DEFAULT_PORT = 79;
/*     */   private static final String LONG_FLAG = "/W ";
/*  62 */   private final transient char[] buffer = new char[1024];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FingerClient() {
/*  70 */     setDefaultPort(79);
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
/*     */   public String query(boolean paramBoolean, String paramString) throws IOException {
/*  87 */     StringBuilder stringBuilder = new StringBuilder(this.buffer.length);
/*     */     
/*  89 */     try (BufferedReader null = new BufferedReader(new InputStreamReader(
/*  90 */             getInputStream(paramBoolean, paramString), getCharset()))) {
/*     */       while (true) {
/*  92 */         int i = bufferedReader.read(this.buffer, 0, this.buffer.length);
/*  93 */         if (i <= 0) {
/*     */           break;
/*     */         }
/*  96 */         stringBuilder.append(this.buffer, 0, i);
/*     */       } 
/*     */     } 
/*     */     
/* 100 */     return stringBuilder.toString();
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
/*     */   public String query(boolean paramBoolean) throws IOException {
/* 116 */     return query(paramBoolean, "");
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
/*     */   public InputStream getInputStream(boolean paramBoolean, String paramString) throws IOException {
/* 135 */     return getInputStream(paramBoolean, paramString, (String)null);
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
/*     */   public InputStream getInputStream(boolean paramBoolean, String paramString1, String paramString2) throws IOException {
/* 155 */     StringBuilder stringBuilder = new StringBuilder(64);
/* 156 */     if (paramBoolean) {
/* 157 */       stringBuilder.append("/W ");
/*     */     }
/* 159 */     stringBuilder.append(paramString1);
/* 160 */     stringBuilder.append("\r\n");
/*     */ 
/*     */     
/* 163 */     byte[] arrayOfByte = stringBuilder.toString().getBytes(Charsets.toCharset(paramString2).name());
/*     */ 
/*     */     
/* 166 */     DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(this._output_, 1024));
/* 167 */     dataOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
/* 168 */     dataOutputStream.flush();
/*     */     
/* 170 */     return this._input_;
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
/*     */   public InputStream getInputStream(boolean paramBoolean) throws IOException {
/* 187 */     return getInputStream(paramBoolean, "");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\finger\FingerClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */