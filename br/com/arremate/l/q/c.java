/*    */ package br.com.arremate.l.q;
/*    */ 
/*    */ import br.com.arremate.l.h;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class c
/*    */ {
/*    */   private final h c;
/*    */   
/*    */   public c(h paramh) {
/* 16 */     this.c = paramh;
/*    */   }
/*    */   
/*    */   public Object[] toArray() {
/* 20 */     Object[] arrayOfObject = new Object[3];
/*    */     
/* 22 */     arrayOfObject[0] = Integer.valueOf(this.c.j());
/* 23 */     arrayOfObject[1] = this.c.b();
/* 24 */     arrayOfObject[2] = Double.valueOf(this.c.m());
/*    */     
/* 26 */     return arrayOfObject;
/*    */   }
/*    */   
/*    */   public h g() {
/* 30 */     return this.c;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */