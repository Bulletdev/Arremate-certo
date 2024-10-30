/*    */ package org.junit.a.e.b;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.junit.a.e.d;
/*    */ import org.junit.a.e.e;
/*    */ import org.junit.a.e.g;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class b
/*    */   extends e
/*    */ {
/*    */   public List<g> a(d paramd) {
/* 17 */     ArrayList<g> arrayList = new ArrayList();
/* 18 */     a a = (a)paramd.getAnnotation(a.class);
/* 19 */     int[] arrayOfInt = a.h();
/* 20 */     for (int i : arrayOfInt) {
/* 21 */       arrayList.add(g.a("ints", Integer.valueOf(i)));
/*    */     }
/* 23 */     return arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\a\e\b\b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */