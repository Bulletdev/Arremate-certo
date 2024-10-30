/*    */ package org.junit.runner.a;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import org.junit.runner.c;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class a
/*    */   extends j
/*    */   implements h.b
/*    */ {
/*    */   public a() {
/* 15 */     super(COMPARATOR);
/*    */   }
/*    */   
/*    */   public h a(h.a parama) {
/* 19 */     return this;
/*    */   }
/*    */   
/* 22 */   private static final Comparator<c> COMPARATOR = new Comparator<c>() {
/*    */       public int a(c param1c1, c param1c2) {
/* 24 */         return param1c1.getDisplayName().compareTo(param1c2.getDisplayName());
/*    */       }
/*    */     };
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\runner\a\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */