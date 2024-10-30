/*     */ package com.google.a.e;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import java.util.HashMap;
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
/*     */ @a
/*     */ @b
/*     */ public final class e
/*     */ {
/*     */   private final Map<Character, String> map;
/*     */   
/*     */   private static class a
/*     */     extends d
/*     */   {
/*     */     private final char[][] a;
/*     */     private final int fm;
/*     */     
/*     */     a(char[][] param1ArrayOfchar) {
/*  47 */       this.a = param1ArrayOfchar;
/*  48 */       this.fm = param1ArrayOfchar.length;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String escape(String param1String) {
/*  57 */       int i = param1String.length();
/*  58 */       for (byte b = 0; b < i; b++) {
/*  59 */         char c = param1String.charAt(b);
/*  60 */         if (c < this.a.length && this.a[c] != null) {
/*  61 */           return h(param1String, b);
/*     */         }
/*     */       } 
/*  64 */       return param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     protected char[] a(char param1Char) {
/*  69 */       return (param1Char < this.fm) ? this.a[param1Char] : null;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  77 */   private int max = -1;
/*     */ 
/*     */   
/*     */   public e() {
/*  81 */     this.map = new HashMap<>();
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public e a(char paramChar, String paramString) {
/*  87 */     this.map.put(Character.valueOf(paramChar), (String)D.checkNotNull(paramString));
/*  88 */     if (paramChar > this.max) {
/*  89 */       this.max = paramChar;
/*     */     }
/*  91 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public e a(char[] paramArrayOfchar, String paramString) {
/*  97 */     D.checkNotNull(paramString);
/*  98 */     for (char c : paramArrayOfchar) {
/*  99 */       a(c, paramString);
/*     */     }
/* 101 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char[][] b() {
/* 112 */     char[][] arrayOfChar = new char[this.max + 1][];
/* 113 */     for (Map.Entry<Character, String> entry : this.map.entrySet()) {
/* 114 */       arrayOfChar[((Character)entry.getKey()).charValue()] = ((String)entry.getValue()).toCharArray();
/*     */     }
/* 116 */     return arrayOfChar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public f a() {
/* 126 */     return new a(b());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\e\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */