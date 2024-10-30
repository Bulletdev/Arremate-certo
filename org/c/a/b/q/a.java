/*     */ package org.c.a.b.q;
/*     */ 
/*     */ import java.lang.ref.SoftReference;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import org.c.a.b.j.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class a
/*     */   implements i
/*     */ {
/*     */   protected final List<c> lines;
/*     */   private final d d;
/*     */   private SoftReference<String> a;
/*     */   
/*     */   public a(List<c> paramList, d paramd) {
/*  52 */     this.lines = paramList;
/*  53 */     this.d = paramd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getLineNumber() {
/*  61 */     return ((c)this.lines.get(0)).getLineNumber();
/*     */   }
/*     */ 
/*     */   
/*     */   public final String ev() {
/*  66 */     String str = (this.a == null) ? null : this.a.get();
/*  67 */     if (str == null) {
/*  68 */       StringBuilder stringBuilder = new StringBuilder();
/*  69 */       for (c c : this.lines) {
/*  70 */         stringBuilder.append(a(c));
/*     */       }
/*  72 */       a(stringBuilder, this.d);
/*     */       
/*  74 */       str = stringBuilder.toString();
/*  75 */       this.a = new SoftReference<>(str);
/*     */     } 
/*  77 */     return str;
/*     */   }
/*     */   
/*     */   protected String a(c paramc) {
/*  81 */     return paramc.eG();
/*     */   }
/*     */ 
/*     */   
/*     */   public String eL() {
/*  86 */     return this.d.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(StringBuilder paramStringBuilder, d paramd) {
/*  96 */     k(paramStringBuilder);
/*     */     
/*  98 */     int j = paramd.eL().length();
/*  99 */     if (j > paramStringBuilder.length()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 104 */     String str = paramStringBuilder.substring(paramStringBuilder.length() - j, paramStringBuilder.length());
/* 105 */     if (str.toUpperCase(Locale.ENGLISH).equals(paramd.eL().toUpperCase(Locale.ENGLISH))) {
/* 106 */       paramStringBuilder.delete(paramStringBuilder.length() - j, paramStringBuilder.length());
/*     */     }
/*     */   }
/*     */   
/*     */   protected void k(StringBuilder paramStringBuilder) {
/* 111 */     while (Character.isWhitespace(paramStringBuilder.charAt(paramStringBuilder.length() - 1)))
/* 112 */       paramStringBuilder.delete(paramStringBuilder.length() - 1, paramStringBuilder.length()); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\q\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */