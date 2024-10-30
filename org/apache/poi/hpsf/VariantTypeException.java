/*    */ package org.apache.poi.hpsf;
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
/*    */ public abstract class VariantTypeException
/*    */   extends HPSFException
/*    */ {
/*    */   private Object value;
/*    */   private long variantType;
/*    */   
/*    */   public VariantTypeException(long paramLong, Object paramObject, String paramString) {
/* 43 */     super(paramString);
/* 44 */     this.variantType = paramLong;
/* 45 */     this.value = paramObject;
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
/*    */   public long getVariantType() {
/* 57 */     return this.variantType;
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
/*    */   public Object getValue() {
/* 69 */     return this.value;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\VariantTypeException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */