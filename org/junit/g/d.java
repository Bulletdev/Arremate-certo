/*    */ package org.junit.g;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import org.junit.f.a.m;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class d
/*    */   implements e
/*    */ {
/* 16 */   private static final List<Exception> aW = Collections.emptyList();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<Exception> b(m paramm) {
/* 26 */     if (paramm.isPublic()) {
/* 27 */       return aW;
/*    */     }
/* 29 */     return Collections.singletonList(new Exception("The class " + paramm.getName() + " is not public."));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\g\d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */