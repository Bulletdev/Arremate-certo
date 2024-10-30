/*    */ package org.apache.poi.hpsf;
/*    */ 
/*    */ import org.apache.poi.util.Internal;
/*    */ import org.apache.poi.util.LittleEndian;
/*    */ import org.apache.poi.util.POILogFactory;
/*    */ import org.apache.poi.util.POILogger;
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
/*    */ @Internal
/*    */ class VariantBool
/*    */ {
/* 26 */   private static final POILogger logger = POILogFactory.getLogger(VariantBool.class);
/*    */   
/*    */   static final int SIZE = 2;
/*    */   
/*    */   private boolean _value;
/*    */   
/*    */   VariantBool(byte[] paramArrayOfbyte, int paramInt) {
/* 33 */     short s = LittleEndian.getShort(paramArrayOfbyte, paramInt);
/* 34 */     switch (s) {
/*    */       case 0:
/* 36 */         this._value = false;
/*    */         return;
/*    */       case -1:
/* 39 */         this._value = true;
/*    */         return;
/*    */     } 
/* 42 */     logger.log(5, new Object[] { "VARIANT_BOOL value '" + s + "' is incorrect" });
/* 43 */     this._value = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   boolean getValue() {
/* 49 */     return this._value;
/*    */   }
/*    */   
/*    */   void setValue(boolean paramBoolean) {
/* 53 */     this._value = paramBoolean;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\VariantBool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */