/*    */ package org.apache.poi.xdgf.geom;
/*    */ 
/*    */ import com.a.a.f;
/*    */ import com.a.a.j;
/*    */ import com.a.a.l;
/*    */ import com.a.a.m;
/*    */ import com.a.a.r;
/*    */ import com.a.a.t;
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
/*    */ public class SplineRenderer
/*    */ {
/*    */   public static r createNurbsSpline(f paramf, t paramt1, t paramt2, int paramInt) {
/* 32 */     double d1 = paramt1.a(0);
/* 33 */     int i = paramt1.size();
/* 34 */     double d2 = paramt1.a(i - 1);
/*    */     
/*    */     int j;
/* 37 */     for (j = 0; j < i; j++) {
/* 38 */       paramt1.a((paramt1.a(j) - d1) / d2, j);
/*    */     }
/*    */ 
/*    */     
/* 42 */     j = paramf.aE() + paramInt + 1;
/* 43 */     for (int k = i; k < j; k++) {
/* 44 */       paramt1.add(1.0D);
/*    */     }
/*    */     
/* 47 */     j j1 = new j("0:n-1", paramf.aE());
/*    */     
/* 49 */     m m = new m(paramf, j1);
/*    */     
/* 51 */     m.aI(paramInt);
/* 52 */     m.aJ(2);
/* 53 */     m.a(paramt1);
/*    */     
/* 55 */     if (paramt2 == null) {
/* 56 */       m.am(false);
/*    */     } else {
/* 58 */       m.b(paramt2);
/*    */     } 
/*    */ 
/*    */     
/* 62 */     r r = new r();
/* 63 */     r.w(0.01D);
/*    */     
/* 65 */     m.a((l)r);
/* 66 */     return r;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdgf\geom\SplineRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */