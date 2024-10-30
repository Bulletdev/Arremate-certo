/*    */ package junit.a;
/*    */ 
/*    */ import junit.b.i;
/*    */ import junit.b.m;
/*    */ 
/*    */ 
/*    */ public class b
/*    */   extends c
/*    */ {
/*    */   private int hN;
/*    */   
/*    */   public b(i parami, int paramInt) {
/* 13 */     super(parami);
/* 14 */     if (paramInt < 0) {
/* 15 */       throw new IllegalArgumentException("Repetition count must be >= 0");
/*    */     }
/* 17 */     this.hN = paramInt;
/*    */   }
/*    */ 
/*    */   
/*    */   public int bc() {
/* 22 */     return super.bc() * this.hN;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(m paramm) {
/* 27 */     for (byte b1 = 0; b1 < this.hN && 
/* 28 */       !paramm.eq(); b1++)
/*    */     {
/*    */       
/* 31 */       super.a(paramm);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 37 */     return super.toString() + "(repeated)";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\junit\a\b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */