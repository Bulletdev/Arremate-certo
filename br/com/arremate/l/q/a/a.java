/*    */ package br.com.arremate.l.q.a;
/*    */ 
/*    */ import br.com.arremate.l.m;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class a
/*    */   implements Comparable<a>
/*    */ {
/*    */   private static final int bF = 4;
/*    */   private final m c;
/*    */   
/*    */   public a(m paramm) {
/* 16 */     this.c = paramm;
/*    */   }
/*    */   
/*    */   public Object[] toArray() {
/* 20 */     Object[] arrayOfObject = new Object[4];
/*    */     
/* 22 */     arrayOfObject[0] = this.c.cd();
/* 23 */     arrayOfObject[1] = this.c.bo();
/* 24 */     arrayOfObject[2] = Long.valueOf(this.c.b().getTime());
/* 25 */     arrayOfObject[3] = this.c.j();
/*    */     
/* 27 */     return arrayOfObject;
/*    */   }
/*    */   
/*    */   public m b() {
/* 31 */     return this.c;
/*    */   }
/*    */ 
/*    */   
/*    */   public int a(a parama) {
/* 36 */     return b().b().compareTo(parama.b().b());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */