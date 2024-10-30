/*    */ package org.h2.util;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import org.h2.message.DbException;
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
/*    */ public class SmallMap
/*    */ {
/* 19 */   private final HashMap<Integer, Object> map = New.hashMap();
/*    */   
/*    */   private Object cache;
/*    */   
/*    */   private int cacheId;
/*    */   
/*    */   private int lastId;
/*    */   
/*    */   private final int maxElements;
/*    */ 
/*    */   
/*    */   public SmallMap(int paramInt) {
/* 31 */     this.maxElements = paramInt;
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
/*    */   public int addObject(int paramInt, Object paramObject) {
/* 43 */     if (this.map.size() > this.maxElements * 2) {
/* 44 */       Iterator<Integer> iterator = this.map.keySet().iterator();
/* 45 */       while (iterator.hasNext()) {
/* 46 */         Integer integer = iterator.next();
/* 47 */         if (integer.intValue() + this.maxElements < this.lastId) {
/* 48 */           iterator.remove();
/*    */         }
/*    */       } 
/*    */     } 
/* 52 */     if (paramInt > this.lastId) {
/* 53 */       this.lastId = paramInt;
/*    */     }
/* 55 */     this.map.put(Integer.valueOf(paramInt), paramObject);
/* 56 */     this.cacheId = paramInt;
/* 57 */     this.cache = paramObject;
/* 58 */     return paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void freeObject(int paramInt) {
/* 67 */     if (this.cacheId == paramInt) {
/* 68 */       this.cacheId = -1;
/* 69 */       this.cache = null;
/*    */     } 
/* 71 */     this.map.remove(Integer.valueOf(paramInt));
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
/*    */   
/*    */   public Object getObject(int paramInt, boolean paramBoolean) {
/* 84 */     if (paramInt == this.cacheId) {
/* 85 */       return this.cache;
/*    */     }
/* 87 */     Object object = this.map.get(Integer.valueOf(paramInt));
/* 88 */     if (object == null && !paramBoolean) {
/* 89 */       throw DbException.get(90007);
/*    */     }
/* 91 */     return object;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\SmallMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */