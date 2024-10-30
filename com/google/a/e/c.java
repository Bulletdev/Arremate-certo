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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ @b
/*     */ public abstract class c
/*     */   extends i
/*     */ {
/*     */   private final char[][] a;
/*     */   private final int fi;
/*     */   private final int fj;
/*     */   private final int fk;
/*     */   private final char l;
/*     */   private final char m;
/*     */   
/*     */   protected c(Map<Character, String> paramMap, int paramInt1, int paramInt2, String paramString) {
/*  77 */     this(b.a(paramMap), paramInt1, paramInt2, paramString);
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
/*     */   
/*     */   protected c(b paramb, int paramInt1, int paramInt2, String paramString) {
/* 100 */     D.checkNotNull(paramb);
/* 101 */     this.a = paramb.a();
/* 102 */     this.fi = this.a.length;
/* 103 */     if (paramInt2 < paramInt1) {
/*     */ 
/*     */       
/* 106 */       paramInt2 = -1;
/* 107 */       paramInt1 = Integer.MAX_VALUE;
/*     */     } 
/* 109 */     this.fj = paramInt1;
/* 110 */     this.fk = paramInt2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 125 */     if (paramInt1 >= 55296) {
/*     */ 
/*     */       
/* 128 */       this.l = Character.MAX_VALUE;
/* 129 */       this.m = Character.MIN_VALUE;
/*     */     }
/*     */     else {
/*     */       
/* 133 */       this.l = (char)paramInt1;
/* 134 */       this.m = (char)Math.min(paramInt2, 55295);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String escape(String paramString) {
/* 144 */     D.checkNotNull(paramString);
/* 145 */     for (byte b = 0; b < paramString.length(); b++) {
/* 146 */       char c1 = paramString.charAt(b);
/* 147 */       if ((c1 < this.fi && this.a[c1] != null) || c1 > this.m || c1 < this.l)
/*     */       {
/*     */         
/* 150 */         return h(paramString, b);
/*     */       }
/*     */     } 
/* 153 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final char[] a(int paramInt) {
/* 163 */     if (paramInt < this.fi) {
/* 164 */       char[] arrayOfChar = this.a[paramInt];
/* 165 */       if (arrayOfChar != null) {
/* 166 */         return arrayOfChar;
/*     */       }
/*     */     } 
/* 169 */     if (paramInt >= this.fj && paramInt <= this.fk) {
/* 170 */       return null;
/*     */     }
/* 172 */     return b(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final int a(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 178 */     while (paramInt1 < paramInt2) {
/* 179 */       char c1 = paramCharSequence.charAt(paramInt1);
/* 180 */       if ((c1 < this.fi && this.a[c1] != null) || c1 > this.m || c1 < this.l) {
/*     */         break;
/*     */       }
/*     */ 
/*     */       
/* 185 */       paramInt1++;
/*     */     } 
/* 187 */     return paramInt1;
/*     */   }
/*     */   
/*     */   protected abstract char[] b(int paramInt);
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\e\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */