/*     */ package com.google.a.l;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import java.net.InetAddress;
/*     */ import java.text.ParseException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ @c
/*     */ public final class b
/*     */ {
/*     */   private final String gT;
/*     */   
/*     */   private b(String paramString) {
/*  51 */     this.gT = paramString;
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
/*     */   public static b a(String paramString) {
/*  73 */     a a = a.b(paramString);
/*  74 */     D.checkArgument(!a.dg());
/*  75 */     String str = a.getHost();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  81 */     InetAddress inetAddress = null;
/*     */     try {
/*  83 */       inetAddress = d.a(str);
/*  84 */     } catch (IllegalArgumentException illegalArgumentException) {}
/*     */ 
/*     */ 
/*     */     
/*  88 */     if (inetAddress != null) {
/*  89 */       return new b(d.b(inetAddress));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  95 */     e e = e.a(str);
/*     */     
/*  97 */     if (e.di()) {
/*  98 */       return new b(e.toString());
/*     */     }
/*     */     
/* 101 */     String.valueOf(str); throw new IllegalArgumentException((String.valueOf(str).length() != 0) ? "Domain name does not have a recognized public suffix: ".concat(String.valueOf(str)) : new String("Domain name does not have a recognized public suffix: "));
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
/*     */   public static b b(String paramString) throws ParseException {
/*     */     try {
/* 114 */       return a(paramString);
/* 115 */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 120 */       String.valueOf(paramString); ParseException parseException = new ParseException((String.valueOf(paramString).length() != 0) ? "Invalid host specifier: ".concat(String.valueOf(paramString)) : new String("Invalid host specifier: "), 0);
/* 121 */       parseException.initCause(illegalArgumentException);
/* 122 */       throw parseException;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean u(String paramString) {
/*     */     try {
/* 132 */       a(paramString);
/* 133 */       return true;
/* 134 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 135 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 141 */     if (this == paramObject) {
/* 142 */       return true;
/*     */     }
/*     */     
/* 145 */     if (paramObject instanceof b) {
/* 146 */       b b1 = (b)paramObject;
/* 147 */       return this.gT.equals(b1.gT);
/*     */     } 
/*     */     
/* 150 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 155 */     return this.gT.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 166 */     return this.gT;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\l\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */