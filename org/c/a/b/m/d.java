/*    */ package org.c.a.b.m;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import org.c.a.a.h.d;
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
/*    */ public class d
/*    */   implements Comparator<d>
/*    */ {
/*    */   public int a(d paramd1, d paramd2) {
/* 28 */     if (paramd1.c() != null && paramd2.c() != null) {
/* 29 */       return paramd1.c().a(paramd2.c());
/*    */     }
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
/* 45 */     if (paramd1.c() != null) {
/* 46 */       return Integer.MIN_VALUE;
/*    */     }
/* 48 */     if (paramd2.c() != null) {
/* 49 */       return Integer.MAX_VALUE;
/*    */     }
/* 51 */     return paramd1.getDescription().compareTo(paramd2.getDescription());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\m\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */