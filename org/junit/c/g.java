/*    */ package org.junit.c;
/*    */ 
/*    */ import org.junit.c;
/*    */ 
/*    */ public class g extends e {
/*    */   public Object aF;
/*    */   
/*    */   public g(double paramDouble) {
/*  9 */     this.aF = Double.valueOf(paramDouble);
/*    */   }
/*    */   
/*    */   public g(float paramFloat) {
/* 13 */     this.aF = Float.valueOf(paramFloat);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void l(Object paramObject1, Object paramObject2) {
/* 18 */     if (paramObject1 instanceof Double) {
/* 19 */       c.b(((Double)paramObject1).doubleValue(), ((Double)paramObject2).doubleValue(), ((Double)this.aF).doubleValue());
/*    */     } else {
/* 21 */       c.a(((Float)paramObject1).floatValue(), ((Float)paramObject2).floatValue(), ((Float)this.aF).floatValue());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\g.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */