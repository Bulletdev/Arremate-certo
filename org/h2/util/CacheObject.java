/*    */ package org.h2.util;
/*    */ 
/*    */ import org.h2.engine.SysProperties;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class CacheObject
/*    */   implements Comparable<CacheObject>
/*    */ {
/*    */   public CacheObject cachePrevious;
/*    */   public CacheObject cacheNext;
/*    */   public CacheObject cacheChained;
/*    */   private int pos;
/*    */   private boolean changed;
/*    */   
/*    */   public void setPos(int paramInt) {
/* 52 */     if (SysProperties.CHECK && (
/* 53 */       this.cachePrevious != null || this.cacheNext != null || this.cacheChained != null)) {
/* 54 */       DbException.throwInternalError("setPos too late");
/*    */     }
/*    */     
/* 57 */     this.pos = paramInt;
/*    */   }
/*    */   
/*    */   public int getPos() {
/* 61 */     return this.pos;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isChanged() {
/* 71 */     return this.changed;
/*    */   }
/*    */   
/*    */   public void setChanged(boolean paramBoolean) {
/* 75 */     this.changed = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareTo(CacheObject paramCacheObject) {
/* 80 */     return MathUtils.compareInt(getPos(), paramCacheObject.getPos());
/*    */   }
/*    */   
/*    */   public boolean isStream() {
/* 84 */     return false;
/*    */   }
/*    */   
/*    */   public abstract boolean canRemove();
/*    */   
/*    */   public abstract int getMemory();
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\CacheObject.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */