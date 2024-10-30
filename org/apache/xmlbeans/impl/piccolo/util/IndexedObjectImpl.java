/*    */ package org.apache.xmlbeans.impl.piccolo.util;
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
/*    */ public final class IndexedObjectImpl
/*    */   implements IndexedObject
/*    */ {
/*    */   private int index;
/*    */   private Object object;
/*    */   
/*    */   public IndexedObjectImpl(int paramInt, Object paramObject) {
/* 27 */     this.index = paramInt;
/* 28 */     this.object = paramObject;
/*    */   }
/*    */   
/* 31 */   public final int getIndex() { return this.index; } public final void setIndex(int paramInt) {
/* 32 */     this.index = paramInt;
/*    */   }
/* 34 */   public final Object getObject() { return this.object; } public final void setObject(Object paramObject) {
/* 35 */     this.object = paramObject;
/*    */   }
/*    */   public final Object clone() {
/* 38 */     return new IndexedObjectImpl(this.index, this.object);
/*    */   }
/*    */   
/*    */   public final boolean equals(Object paramObject) {
/* 42 */     if (paramObject instanceof IndexedObject) {
/* 43 */       IndexedObject indexedObject = (IndexedObject)paramObject;
/* 44 */       return (this.index == indexedObject.getIndex() && this.object.equals(indexedObject.getObject()));
/*    */     } 
/*    */     
/* 47 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccol\\util\IndexedObjectImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */