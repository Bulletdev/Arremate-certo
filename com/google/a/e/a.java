/*     */ package com.google.a.e;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ @b
/*     */ public abstract class a
/*     */   extends d
/*     */ {
/*     */   private final char[][] a;
/*     */   private final int fi;
/*     */   private final char j;
/*     */   private final char k;
/*     */   
/*     */   protected a(Map<Character, String> paramMap, char paramChar1, char paramChar2) {
/*  69 */     this(b.a(paramMap), paramChar1, paramChar2);
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
/*     */   protected a(b paramb, char paramChar1, char paramChar2) {
/*  87 */     D.checkNotNull(paramb);
/*  88 */     this.a = paramb.a();
/*  89 */     this.fi = this.a.length;
/*  90 */     if (paramChar2 < paramChar1) {
/*     */ 
/*     */       
/*  93 */       paramChar2 = Character.MIN_VALUE;
/*  94 */       paramChar1 = Character.MAX_VALUE;
/*     */     } 
/*  96 */     this.j = paramChar1;
/*  97 */     this.k = paramChar2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String escape(String paramString) {
/* 106 */     D.checkNotNull(paramString);
/* 107 */     for (byte b = 0; b < paramString.length(); b++) {
/* 108 */       char c = paramString.charAt(b);
/* 109 */       if ((c < this.fi && this.a[c] != null) || c > this.k || c < this.j) {
/* 110 */         return h(paramString, b);
/*     */       }
/*     */     } 
/* 113 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final char[] a(char paramChar) {
/* 123 */     if (paramChar < this.fi) {
/* 124 */       char[] arrayOfChar = this.a[paramChar];
/* 125 */       if (arrayOfChar != null) {
/* 126 */         return arrayOfChar;
/*     */       }
/*     */     } 
/* 129 */     if (paramChar >= this.j && paramChar <= this.k) {
/* 130 */       return null;
/*     */     }
/* 132 */     return b(paramChar);
/*     */   }
/*     */   
/*     */   protected abstract char[] b(char paramChar);
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\e\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */