/*    */ package org.apache.poi.hpsf;
/*    */ 
/*    */ import org.apache.poi.util.Internal;
/*    */ import org.apache.poi.util.LittleEndian;
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
/*    */ @Internal
/*    */ class Vector
/*    */ {
/*    */   private final short _type;
/*    */   private TypedPropertyValue[] _values;
/*    */   
/*    */   Vector(byte[] paramArrayOfbyte, int paramInt, short paramShort) {
/* 36 */     this._type = paramShort;
/* 37 */     read(paramArrayOfbyte, paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   Vector(short paramShort) {
/* 42 */     this._type = paramShort;
/*    */   }
/*    */ 
/*    */   
/*    */   int read(byte[] paramArrayOfbyte, int paramInt) {
/* 47 */     int i = paramInt;
/*    */     
/* 49 */     long l = LittleEndian.getUInt(paramArrayOfbyte, i);
/* 50 */     i += 4;
/*    */     
/* 52 */     if (l > 2147483647L) {
/* 53 */       throw new UnsupportedOperationException("Vector is too long -- " + l);
/*    */     }
/* 55 */     int j = (int)l;
/*    */     
/* 57 */     this._values = new TypedPropertyValue[j];
/*    */     
/* 59 */     if (this._type == 12) {
/*    */       
/* 61 */       for (byte b = 0; b < j; b++)
/*    */       {
/* 63 */         TypedPropertyValue typedPropertyValue = new TypedPropertyValue();
/* 64 */         i += typedPropertyValue.read(paramArrayOfbyte, i);
/* 65 */         this._values[b] = typedPropertyValue;
/*    */       }
/*    */     
/*    */     } else {
/*    */       
/* 70 */       for (byte b = 0; b < j; b++) {
/*    */         
/* 72 */         TypedPropertyValue typedPropertyValue = new TypedPropertyValue(this._type, null);
/*    */         
/* 74 */         i += typedPropertyValue.readValue(paramArrayOfbyte, i);
/* 75 */         this._values[b] = typedPropertyValue;
/*    */       } 
/*    */     } 
/* 78 */     return i - paramInt;
/*    */   }
/*    */   
/*    */   TypedPropertyValue[] getValues() {
/* 82 */     return this._values;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\Vector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */