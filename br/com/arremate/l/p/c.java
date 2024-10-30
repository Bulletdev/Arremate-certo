/*    */ package br.com.arremate.l.p;
/*    */ 
/*    */ import br.com.arremate.m.y;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class c
/*    */   extends h
/*    */ {
/*    */   private h b;
/*    */   
/*    */   public c(int paramInt) {
/* 14 */     super(paramInt, false);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void f(String paramString) {
/* 24 */     super.f(encode(paramString));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String encode(String paramString) {
/*    */     try {
/* 34 */       return y.R(paramString);
/* 35 */     } catch (Exception exception) {
/* 36 */       return paramString;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void b(h paramh) {
/* 45 */     this.b = paramh;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public h a() {
/* 53 */     return this.b;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\p\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */