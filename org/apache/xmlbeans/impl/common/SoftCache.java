/*    */ package org.apache.xmlbeans.impl.common;
/*    */ 
/*    */ import java.lang.ref.SoftReference;
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
/*    */ public class SoftCache
/*    */ {
/* 26 */   private HashMap map = new HashMap();
/*    */ 
/*    */   
/*    */   public Object get(Object paramObject) {
/* 30 */     SoftReference softReference = (SoftReference)this.map.get(paramObject);
/*    */     
/* 32 */     if (softReference == null) {
/* 33 */       return null;
/*    */     }
/* 35 */     return softReference.get();
/*    */   }
/*    */ 
/*    */   
/*    */   public Object put(Object paramObject1, Object paramObject2) {
/* 40 */     SoftReference softReference = this.map.put(paramObject1, new SoftReference(paramObject2));
/*    */     
/* 42 */     if (softReference == null) {
/* 43 */       return null;
/*    */     }
/* 45 */     Object object = softReference.get();
/* 46 */     softReference.clear();
/*    */     
/* 48 */     return object;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object remove(Object paramObject) {
/* 53 */     SoftReference softReference = (SoftReference)this.map.remove(paramObject);
/*    */     
/* 55 */     if (softReference == null) {
/* 56 */       return null;
/*    */     }
/* 58 */     Object object = softReference.get();
/* 59 */     softReference.clear();
/*    */     
/* 61 */     return object;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\SoftCache.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */