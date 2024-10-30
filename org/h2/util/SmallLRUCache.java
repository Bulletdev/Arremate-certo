/*    */ package org.h2.util;
/*    */ 
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.Map;
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
/*    */ public class SmallLRUCache<K, V>
/*    */   extends LinkedHashMap<K, V>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private int size;
/*    */   
/*    */   private SmallLRUCache(int paramInt) {
/* 23 */     super(paramInt, 0.75F, true);
/* 24 */     this.size = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <K, V> SmallLRUCache<K, V> newInstance(int paramInt) {
/* 36 */     return new SmallLRUCache<>(paramInt);
/*    */   }
/*    */   
/*    */   public void setMaxSize(int paramInt) {
/* 40 */     this.size = paramInt;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry) {
/* 45 */     return (size() > this.size);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\SmallLRUCache.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */