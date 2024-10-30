/*    */ package com.google.a.b;
/*    */ 
/*    */ import com.google.a.a.c;
/*    */ import java.io.Serializable;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
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
/*    */ @c
/*    */ final class v
/*    */   extends h
/*    */   implements Serializable
/*    */ {
/*    */   private final Pattern pattern;
/*    */   private static final long serialVersionUID = 0L;
/*    */   
/*    */   v(Pattern paramPattern) {
/* 28 */     this.pattern = D.<Pattern>checkNotNull(paramPattern);
/*    */   }
/*    */ 
/*    */   
/*    */   public g a(CharSequence paramCharSequence) {
/* 33 */     return new a(this.pattern.matcher(paramCharSequence));
/*    */   }
/*    */ 
/*    */   
/*    */   public String dg() {
/* 38 */     return this.pattern.pattern();
/*    */   }
/*    */ 
/*    */   
/*    */   public int ac() {
/* 43 */     return this.pattern.flags();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 48 */     return this.pattern.toString();
/*    */   }
/*    */   
/*    */   private static final class a extends g {
/*    */     final Matcher a;
/*    */     
/*    */     a(Matcher param1Matcher) {
/* 55 */       this.a = D.<Matcher>checkNotNull(param1Matcher);
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean co() {
/* 60 */       return this.a.matches();
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean cp() {
/* 65 */       return this.a.find();
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean k(int param1Int) {
/* 70 */       return this.a.find(param1Int);
/*    */     }
/*    */ 
/*    */     
/*    */     public String ao(String param1String) {
/* 75 */       return this.a.replaceAll(param1String);
/*    */     }
/*    */ 
/*    */     
/*    */     public int end() {
/* 80 */       return this.a.end();
/*    */     }
/*    */ 
/*    */     
/*    */     public int start() {
/* 85 */       return this.a.start();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\b\v.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */