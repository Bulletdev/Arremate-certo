/*     */ package com.google.a.j;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.Writer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @c
/*     */ public abstract class f
/*     */ {
/*     */   public j a(Charset paramCharset) {
/*  59 */     return new a(paramCharset);
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
/*     */   public abstract OutputStream a() throws IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OutputStream b() throws IOException {
/*  85 */     OutputStream outputStream = a();
/*  86 */     return (outputStream instanceof BufferedOutputStream) ? 
/*  87 */       outputStream : 
/*  88 */       new BufferedOutputStream(outputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte) throws IOException {
/*  97 */     D.checkNotNull(paramArrayOfbyte);
/*     */     
/*  99 */     n n = n.a();
/*     */     try {
/* 101 */       OutputStream outputStream = n.<OutputStream>a(a());
/* 102 */       outputStream.write(paramArrayOfbyte);
/* 103 */       outputStream.flush();
/* 104 */     } catch (Throwable throwable) {
/* 105 */       throw n.rethrow(throwable);
/*     */     } finally {
/* 107 */       n.close();
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
/*     */   @com.google.b.a.a
/*     */   public long a(InputStream paramInputStream) throws IOException {
/* 120 */     D.checkNotNull(paramInputStream);
/*     */     
/* 122 */     n n = n.a();
/*     */     try {
/* 124 */       OutputStream outputStream = n.<OutputStream>a(a());
/* 125 */       long l = h.copy(paramInputStream, outputStream);
/* 126 */       outputStream.flush();
/* 127 */       return l;
/* 128 */     } catch (Throwable throwable) {
/* 129 */       throw n.rethrow(throwable);
/*     */     } finally {
/* 131 */       n.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final class a
/*     */     extends j
/*     */   {
/*     */     private final Charset charset;
/*     */ 
/*     */     
/*     */     private a(f this$0, Charset param1Charset) {
/* 144 */       this.charset = (Charset)D.checkNotNull(param1Charset);
/*     */     }
/*     */ 
/*     */     
/*     */     public Writer a() throws IOException {
/* 149 */       return new OutputStreamWriter(this.a.a(), this.charset);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 154 */       String str1 = this.a.toString(), str2 = String.valueOf(this.charset); return (new StringBuilder(13 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(".asCharSink(").append(str2).append(")").toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\j\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */