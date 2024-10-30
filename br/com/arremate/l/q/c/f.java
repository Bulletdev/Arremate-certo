/*    */ package br.com.arremate.l.q.c;
/*    */ 
/*    */ import br.com.arremate.l.h;
/*    */ import br.com.arremate.l.q.b.e;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class f
/*    */ {
/*    */   private final e d;
/*    */   private boolean al;
/*    */   
/*    */   protected f(e parame, boolean paramBoolean) {
/* 16 */     this.d = parame;
/* 17 */     this.al = paramBoolean;
/*    */   }
/*    */   
/*    */   public abstract Object[] toArray();
/*    */   
/*    */   public e b() {
/* 23 */     return this.d;
/*    */   }
/*    */   
/*    */   public boolean bA() {
/* 27 */     return this.al;
/*    */   }
/*    */   
/*    */   public void S(boolean paramBoolean) {
/* 31 */     this.al = paramBoolean;
/*    */   }
/*    */   
/*    */   public h h() {
/* 35 */     return b().f();
/*    */   }
/*    */   
/*    */   public void i(h paramh) {
/* 39 */     b().f().i(paramh);
/* 40 */     S(false);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\c\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */