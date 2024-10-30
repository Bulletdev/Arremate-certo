/*    */ package br.com.arremate.l.q.c;
/*    */ 
/*    */ import br.com.arremate.f.s;
/*    */ import br.com.arremate.l.h;
/*    */ import br.com.arremate.l.q.b.e;
/*    */ import br.com.arremate.m.n;
/*    */ import br.com.arremate.m.y;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class g
/*    */   extends j
/*    */ {
/*    */   private h c;
/*    */   
/*    */   public g(e parame, h paramh) {
/* 19 */     super(parame);
/* 20 */     R(false);
/* 21 */     this.c = paramh;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object[] toArray() {
/* 26 */     Object[] arrayOfObject = super.toArray();
/* 27 */     arrayOfObject[1] = s.d;
/* 28 */     arrayOfObject[2] = this.c.j() + "º";
/* 29 */     arrayOfObject[3] = "";
/* 30 */     arrayOfObject[4] = "";
/* 31 */     arrayOfObject[5] = Double.valueOf(this.c.m());
/*    */ 
/*    */     
/* 34 */     if (n.bQ()) {
/* 35 */       arrayOfObject[6] = this.c.av();
/* 36 */       arrayOfObject[7] = this.c.ay();
/* 37 */       arrayOfObject[8] = this.c.bL();
/* 38 */       arrayOfObject[9] = this.c.bK();
/* 39 */       arrayOfObject[10] = this.c.bH();
/* 40 */       arrayOfObject[11] = this.c.bI();
/*    */     } else {
/* 42 */       arrayOfObject[6] = "";
/* 43 */       arrayOfObject[7] = "";
/* 44 */       arrayOfObject[8] = "";
/* 45 */       arrayOfObject[9] = "";
/* 46 */       arrayOfObject[10] = "";
/* 47 */       arrayOfObject[11] = "";
/*    */     } 
/* 49 */     return arrayOfObject;
/*    */   }
/*    */ 
/*    */   
/*    */   public String ck() {
/* 54 */     return super.ck() + " " + y.h(8, Integer.toString(this.c.j()));
/*    */   }
/*    */   
/*    */   public h g() {
/* 58 */     return this.c;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\c\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */