/*     */ package org.c.a.b.n.c;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.Reader;
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
/*     */ 
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
/*     */   private final File file;
/*     */   private final String lF;
/*     */   private final Charset encoding;
/*     */   
/*     */   public a(b paramb, String paramString, Charset paramCharset) {
/*  65 */     this.file = new File((new File(paramString)).getPath());
/*  66 */     this
/*     */ 
/*     */       
/*  69 */       .lF = ((paramb == null || paramb.getPath().isEmpty()) ? this.file.getPath() : this.file.getAbsolutePath().substring((new File(paramb.getPath())).getAbsolutePath().length() + 1)).replace("\\", "/");
/*  70 */     this.encoding = paramCharset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String eI() {
/*  81 */     return this.file.getPath();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String eJ() {
/*  91 */     return this.file.getAbsolutePath();
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
/*     */   public d a() {
/*     */     try {
/* 107 */       return (d)new b((Reader)new c(new InputStreamReader(new FileInputStream(this.file), this.encoding)));
/* 108 */     } catch (IOException iOException) {
/* 109 */       throw new org.c.a.a.a("Unable to load filesystem resource: " + this.file.getPath() + " (encoding: " + this.encoding + ")", iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] r() {
/*     */     try {
/* 121 */       FileInputStream fileInputStream = new FileInputStream(this.file);
/* 122 */       return h.a(fileInputStream);
/* 123 */     } catch (IOException iOException) {
/* 124 */       throw new org.c.a.a.a("Unable to load filesystem resource: " + this.file.getPath(), iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFilename() {
/* 133 */     return this.file.getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public String eK() {
/* 138 */     return this.lF;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int a(a parama) {
/* 144 */     return this.file.compareTo(parama.file);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\n\c\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */