/*    */ package com.google.d.a;
/*    */ 
/*    */ import com.google.a.a.a;
/*    */ import com.google.a.a.b;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @a
/*    */ @b
/*    */ public enum b
/*    */ {
/* 33 */   a(':', ','),
/*    */   
/* 35 */   b('!', '?');
/*    */ 
/*    */   
/*    */   private final char r;
/*    */   
/*    */   private final char s;
/*    */ 
/*    */   
/*    */   b(char paramChar1, char paramChar2) {
/* 44 */     this.r = paramChar1;
/* 45 */     this.s = paramChar2;
/*    */   }
/*    */   
/*    */   char b() {
/* 49 */     return this.s;
/*    */   }
/*    */   
/*    */   char c() {
/* 53 */     return this.r;
/*    */   }
/*    */ 
/*    */   
/*    */   static b a(char paramChar) {
/* 58 */     for (b b1 : values()) {
/* 59 */       if (b1.c() == paramChar || b1.b() == paramChar) {
/* 60 */         return b1;
/*    */       }
/*    */     } 
/* 63 */     throw new IllegalArgumentException((new StringBuilder(38)).append("No enum corresponding to given code: ").append(paramChar).toString());
/*    */   }
/*    */   
/*    */   static b a(boolean paramBoolean) {
/* 67 */     return paramBoolean ? (b)a : b;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\d\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */