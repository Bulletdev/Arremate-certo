/*    */ package org.h2.value;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import org.h2.util.StringUtils;
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
/*    */ public class CaseInsensitiveMap<V>
/*    */   extends HashMap<String, V>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public V get(Object paramObject) {
/* 22 */     return super.get(toUpper(paramObject));
/*    */   }
/*    */ 
/*    */   
/*    */   public V put(String paramString, V paramV) {
/* 27 */     return super.put(toUpper(paramString), paramV);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean containsKey(Object paramObject) {
/* 32 */     return super.containsKey(toUpper(paramObject));
/*    */   }
/*    */ 
/*    */   
/*    */   public V remove(Object paramObject) {
/* 37 */     return super.remove(toUpper(paramObject));
/*    */   }
/*    */   
/*    */   private static String toUpper(Object paramObject) {
/* 41 */     return (paramObject == null) ? null : StringUtils.toUpperEnglish(paramObject.toString());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\CaseInsensitiveMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */