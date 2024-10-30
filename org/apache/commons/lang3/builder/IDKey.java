/*    */ package org.apache.commons.lang3.builder;
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
/*    */ final class IDKey
/*    */ {
/*    */   private final Object value;
/*    */   private final int id;
/*    */   
/*    */   IDKey(Object paramObject) {
/* 39 */     this.id = System.identityHashCode(paramObject);
/*    */ 
/*    */ 
/*    */     
/* 43 */     this.value = paramObject;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 52 */     return this.id;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 62 */     if (!(paramObject instanceof IDKey)) {
/* 63 */       return false;
/*    */     }
/* 65 */     IDKey iDKey = (IDKey)paramObject;
/* 66 */     if (this.id != iDKey.id) {
/* 67 */       return false;
/*    */     }
/*    */     
/* 70 */     return (this.value == iDKey.value);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\builder\IDKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */