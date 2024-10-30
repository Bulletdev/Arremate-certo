/*    */ package br.com.arremate.l.q.c;
/*    */ 
/*    */ import br.com.arremate.k.a.g;
/*    */ import br.com.arremate.l.q.b.e;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class i
/*    */   extends j
/*    */ {
/*    */   private String es;
/*    */   private g a;
/* 16 */   private int aO = 0;
/*    */ 
/*    */   
/*    */   protected i(e parame, g paramg, boolean paramBoolean) {
/* 20 */     super(parame, paramBoolean);
/* 21 */     R(true);
/* 22 */     this.es = "/img/mais.png";
/* 23 */     this.a = paramg;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object[] toArray() {
/* 28 */     Object[] arrayOfObject = super.toArray();
/* 29 */     arrayOfObject[0] = cq();
/*    */     
/* 31 */     if (cq().equals("/img/menos.png")) {
/* 32 */       arrayOfObject[2] = "";
/* 33 */       arrayOfObject[5] = "";
/* 34 */       arrayOfObject[6] = "";
/* 35 */       arrayOfObject[7] = "";
/* 36 */       arrayOfObject[8] = "";
/* 37 */       arrayOfObject[9] = "";
/* 38 */       arrayOfObject[10] = "";
/* 39 */       arrayOfObject[11] = "";
/* 40 */     } else if (this.aO != 0) {
/* 41 */       arrayOfObject[2] = this.aO + "º";
/*    */     } 
/*    */     
/* 44 */     return arrayOfObject;
/*    */   }
/*    */   
/*    */   public String cq() {
/* 48 */     return this.es;
/*    */   }
/*    */   
/*    */   public void aG(String paramString) {
/* 52 */     this.es = paramString;
/*    */   }
/*    */   
/*    */   public g a() {
/* 56 */     return this.a;
/*    */   }
/*    */   
/*    */   public void a(g paramg) {
/* 60 */     this.a = paramg;
/*    */   }
/*    */   
/*    */   public int j() {
/* 64 */     return this.aO;
/*    */   }
/*    */   
/*    */   public void l(int paramInt) {
/* 68 */     this.aO = paramInt;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\c\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */