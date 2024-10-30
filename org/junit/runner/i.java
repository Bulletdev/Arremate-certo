/*    */ package org.junit.runner;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import org.junit.f.a.m;
/*    */ import org.junit.g.a;
/*    */ import org.junit.j;
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
/*    */ public final class i
/*    */   extends a
/*    */ {
/*    */   public List<Exception> a(m paramm) {
/* 32 */     if (paramm.getAnnotation(j.class) != null) {
/* 33 */       return Collections.singletonList(new Exception("@FixMethodOrder cannot be combined with @OrderWith"));
/*    */     }
/*    */     
/* 36 */     return Collections.emptyList();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\runner\i.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */