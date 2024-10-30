/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.util.Args;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class Wire
/*     */ {
/*     */   private final Log log;
/*     */   private final String id;
/*     */   
/*     */   public Wire(Log paramLog, String paramString) {
/*  54 */     this.log = paramLog;
/*  55 */     this.id = paramString;
/*     */   }
/*     */   
/*     */   public Wire(Log paramLog) {
/*  59 */     this(paramLog, "");
/*     */   }
/*     */ 
/*     */   
/*     */   private void wire(String paramString, InputStream paramInputStream) throws IOException {
/*  64 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     int i;
/*  66 */     while ((i = paramInputStream.read()) != -1) {
/*  67 */       if (i == 13) {
/*  68 */         stringBuilder.append("[\\r]"); continue;
/*  69 */       }  if (i == 10) {
/*  70 */         stringBuilder.append("[\\n]\"");
/*  71 */         stringBuilder.insert(0, "\"");
/*  72 */         stringBuilder.insert(0, paramString);
/*  73 */         this.log.debug(this.id + " " + stringBuilder.toString());
/*  74 */         stringBuilder.setLength(0); continue;
/*  75 */       }  if (i < 32 || i > 127) {
/*  76 */         stringBuilder.append("[0x");
/*  77 */         stringBuilder.append(Integer.toHexString(i));
/*  78 */         stringBuilder.append("]"); continue;
/*     */       } 
/*  80 */       stringBuilder.append((char)i);
/*     */     } 
/*     */     
/*  83 */     if (stringBuilder.length() > 0) {
/*  84 */       stringBuilder.append('"');
/*  85 */       stringBuilder.insert(0, '"');
/*  86 */       stringBuilder.insert(0, paramString);
/*  87 */       this.log.debug(this.id + " " + stringBuilder.toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean enabled() {
/*  93 */     return this.log.isDebugEnabled();
/*     */   }
/*     */ 
/*     */   
/*     */   public void output(InputStream paramInputStream) throws IOException {
/*  98 */     Args.notNull(paramInputStream, "Output");
/*  99 */     wire(">> ", paramInputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   public void input(InputStream paramInputStream) throws IOException {
/* 104 */     Args.notNull(paramInputStream, "Input");
/* 105 */     wire("<< ", paramInputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   public void output(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 110 */     Args.notNull(paramArrayOfbyte, "Output");
/* 111 */     wire(">> ", new ByteArrayInputStream(paramArrayOfbyte, paramInt1, paramInt2));
/*     */   }
/*     */ 
/*     */   
/*     */   public void input(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 116 */     Args.notNull(paramArrayOfbyte, "Input");
/* 117 */     wire("<< ", new ByteArrayInputStream(paramArrayOfbyte, paramInt1, paramInt2));
/*     */   }
/*     */ 
/*     */   
/*     */   public void output(byte[] paramArrayOfbyte) throws IOException {
/* 122 */     Args.notNull(paramArrayOfbyte, "Output");
/* 123 */     wire(">> ", new ByteArrayInputStream(paramArrayOfbyte));
/*     */   }
/*     */ 
/*     */   
/*     */   public void input(byte[] paramArrayOfbyte) throws IOException {
/* 128 */     Args.notNull(paramArrayOfbyte, "Input");
/* 129 */     wire("<< ", new ByteArrayInputStream(paramArrayOfbyte));
/*     */   }
/*     */ 
/*     */   
/*     */   public void output(int paramInt) throws IOException {
/* 134 */     output(new byte[] { (byte)paramInt });
/*     */   }
/*     */ 
/*     */   
/*     */   public void input(int paramInt) throws IOException {
/* 139 */     input(new byte[] { (byte)paramInt });
/*     */   }
/*     */ 
/*     */   
/*     */   public void output(String paramString) throws IOException {
/* 144 */     Args.notNull(paramString, "Output");
/* 145 */     output(paramString.getBytes());
/*     */   }
/*     */ 
/*     */   
/*     */   public void input(String paramString) throws IOException {
/* 150 */     Args.notNull(paramString, "Input");
/* 151 */     input(paramString.getBytes());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\Wire.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */