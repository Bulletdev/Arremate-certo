/*    */ package org.h2.value;
/*    */ 
/*    */ import java.util.concurrent.ConcurrentHashMap;
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
/*    */ public class CaseInsensitiveConcurrentMap<V>
/*    */   extends ConcurrentHashMap<String, V>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 20 */   private static final String NULL = new String(new byte[0]);
/*    */ 
/*    */   
/*    */   public V get(Object paramObject) {
/* 24 */     return super.get(toUpper(paramObject));
/*    */   }
/*    */ 
/*    */   
/*    */   public V put(String paramString, V paramV) {
/* 29 */     return super.put(toUpper(paramString), paramV);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean containsKey(Object paramObject) {
/* 34 */     return super.containsKey(toUpper(paramObject));
/*    */   }
/*    */ 
/*    */   
/*    */   public V remove(Object paramObject) {
/* 39 */     return super.remove(toUpper(paramObject));
/*    */   }
/*    */   
/*    */   private static String toUpper(Object paramObject) {
/* 43 */     return (paramObject == null) ? NULL : StringUtils.toUpperEnglish(paramObject.toString());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\CaseInsensitiveConcurrentMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */