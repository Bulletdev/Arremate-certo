/*     */ package com.google.d.a;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.w;
/*     */ import com.google.a.d.bS;
/*     */ import com.google.a.d.bj;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b
/*     */ final class c
/*     */ {
/*  26 */   private static final w e = w.a("");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static bj<String, b> a(CharSequence paramCharSequence) {
/*  33 */     bj.a<String, b> a = bj.a();
/*  34 */     int i = paramCharSequence.length();
/*  35 */     int j = 0;
/*  36 */     while (j < i) {
/*  37 */       j += a(bS.a(), paramCharSequence, j, a);
/*     */     }
/*  39 */     return a.e();
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
/*     */   private static int a(List<CharSequence> paramList, CharSequence paramCharSequence, int paramInt, bj.a<String, b> parama) {
/*  58 */     int i = paramCharSequence.length();
/*  59 */     int j = paramInt;
/*  60 */     char c1 = Character.MIN_VALUE;
/*     */ 
/*     */     
/*  63 */     for (; j < i; j++) {
/*  64 */       c1 = paramCharSequence.charAt(j);
/*  65 */       if (c1 == '&' || c1 == '?' || c1 == '!' || c1 == ':' || c1 == ',') {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/*  70 */     paramList.add(0, b(paramCharSequence.subSequence(paramInt, j)));
/*     */     
/*  72 */     if (c1 == '!' || c1 == '?' || c1 == ':' || c1 == ',') {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  77 */       String str = e.a(paramList);
/*  78 */       if (str.length() > 0) {
/*  79 */         parama.a(str, b.a(c1));
/*     */       }
/*     */     } 
/*  82 */     j++;
/*     */     
/*  84 */     if (c1 != '?' && c1 != ',') {
/*  85 */       while (j < i) {
/*     */         
/*  87 */         j += a(paramList, paramCharSequence, j, parama);
/*  88 */         if (paramCharSequence.charAt(j) == '?' || paramCharSequence.charAt(j) == ',') {
/*     */           
/*  90 */           j++;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/*  95 */     paramList.remove(0);
/*  96 */     return j - paramInt;
/*     */   }
/*     */   
/*     */   private static CharSequence b(CharSequence paramCharSequence) {
/* 100 */     return (new StringBuilder(paramCharSequence)).reverse();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\d\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */