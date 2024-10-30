/*     */ package org.c.a.b.n.b;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.Reader;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.URL;
/*     */ import java.net.URLDecoder;
/*     */ import java.nio.charset.Charset;
/*     */ import org.c.a.a.b;
/*     */ import org.c.a.b.j.b;
/*     */ import org.c.a.b.j.d;
/*     */ import org.c.a.b.n.a;
/*     */ import org.c.a.b.r.c;
/*     */ import org.c.a.b.r.h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends a
/*     */   implements Comparable<a>
/*     */ {
/*     */   private final String lD;
/*     */   private final String lE;
/*     */   private final ClassLoader classLoader;
/*     */   private final Charset encoding;
/*     */   
/*     */   public a(b paramb, String paramString, ClassLoader paramClassLoader, Charset paramCharset) {
/*  59 */     this.lD = paramString;
/*  60 */     this
/*     */       
/*  62 */       .lE = (paramb == null || paramb.getPath().isEmpty()) ? paramString : paramString.substring(paramb.getPath().length() + 1);
/*  63 */     this.classLoader = paramClassLoader;
/*  64 */     this.encoding = paramCharset;
/*     */   }
/*     */ 
/*     */   
/*     */   public String eK() {
/*  69 */     return this.lE;
/*     */   }
/*     */ 
/*     */   
/*     */   public String eI() {
/*  74 */     return this.lD;
/*     */   }
/*     */ 
/*     */   
/*     */   public String eJ() {
/*  79 */     URL uRL = b();
/*  80 */     if (uRL == null) {
/*  81 */       throw new org.c.a.a.a("Unable to fileNameWithAbsolutePath resource on disk: " + this.lD);
/*     */     }
/*     */     try {
/*  84 */       return (new File(URLDecoder.decode(uRL.getPath(), "UTF-8"))).getAbsolutePath();
/*  85 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*  86 */       throw new org.c.a.a.a("Unknown encoding: UTF-8", unsupportedEncodingException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private URL b() {
/*  94 */     return this.classLoader.getResource(this.lD);
/*     */   }
/*     */ 
/*     */   
/*     */   public d a() {
/*     */     try {
/* 100 */       InputStream inputStream = this.classLoader.getResourceAsStream(this.lD);
/* 101 */       if (inputStream == null) {
/* 102 */         throw new org.c.a.a.a("Unable to obtain inputstream for resource: " + this.lD);
/*     */       }
/* 104 */       return (d)new b((Reader)new c(new InputStreamReader(inputStream, this.encoding)));
/* 105 */     } catch (IOException iOException) {
/* 106 */       throw new org.c.a.a.a("Unable to load resource: " + this.lD + " (encoding: " + this.encoding + ")", iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] r() {
/*     */     try {
/* 113 */       InputStream inputStream = this.classLoader.getResourceAsStream(this.lD);
/* 114 */       if (inputStream == null) {
/* 115 */         throw new org.c.a.a.a("Unable to obtain inputstream for resource: " + this.lD);
/*     */       }
/* 117 */       return h.a(inputStream);
/* 118 */     } catch (IOException iOException) {
/* 119 */       throw new org.c.a.a.a("Unable to load resource: " + this.lD, iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getFilename() {
/* 125 */     return this.lD.substring(this.lD.lastIndexOf("/") + 1);
/*     */   }
/*     */   
/*     */   public boolean exists() {
/* 129 */     return (b() != null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 135 */     if (this == paramObject) return true; 
/* 136 */     if (paramObject == null || getClass() != paramObject.getClass()) return false;
/*     */     
/* 138 */     a a1 = (a)paramObject;
/*     */     
/* 140 */     if (!this.lD.equals(a1.lD)) return false;
/*     */     
/* 142 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 147 */     return this.lD.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int a(a parama) {
/* 153 */     return this.lD.compareTo(parama.lD);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\n\b\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */