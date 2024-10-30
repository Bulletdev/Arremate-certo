/*    */ package ch.qos.logback.classic.util;
/*    */ 
/*    */ import java.util.HashMap;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CopyOnInheritThreadLocal
/*    */   extends InheritableThreadLocal<HashMap<String, String>>
/*    */ {
/*    */   protected HashMap<String, String> childValue(HashMap<String, String> paramHashMap) {
/* 31 */     if (paramHashMap == null) {
/* 32 */       return null;
/*    */     }
/* 34 */     return new HashMap<String, String>(paramHashMap);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classi\\util\CopyOnInheritThreadLocal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */