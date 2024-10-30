/*     */ package org.apache.poi.hpsf;
/*     */ 
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Internal
/*     */ class Array
/*     */ {
/*     */   private ArrayHeader _header;
/*     */   private TypedPropertyValue[] _values;
/*     */   
/*     */   static class ArrayDimension
/*     */   {
/*     */     static final int SIZE = 8;
/*     */     private int _indexOffset;
/*     */     private long _size;
/*     */     
/*     */     ArrayDimension(byte[] param1ArrayOfbyte, int param1Int) {
/*  34 */       this._size = LittleEndian.getUInt(param1ArrayOfbyte, param1Int);
/*  35 */       this._indexOffset = LittleEndian.getInt(param1ArrayOfbyte, param1Int + 4);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class ArrayHeader
/*     */   {
/*     */     private Array.ArrayDimension[] _dimensions;
/*     */     
/*     */     private int _type;
/*     */     
/*     */     ArrayHeader(byte[] param1ArrayOfbyte, int param1Int) {
/*  47 */       int i = param1Int;
/*     */       
/*  49 */       this._type = LittleEndian.getInt(param1ArrayOfbyte, i);
/*  50 */       i += 4;
/*     */       
/*  52 */       long l = LittleEndian.getUInt(param1ArrayOfbyte, i);
/*  53 */       i += 4;
/*     */       
/*  55 */       if (1L > l || l > 31L) {
/*  56 */         throw new IllegalPropertySetDataException("Array dimension number " + l + " is not in [1; 31] range");
/*     */       }
/*     */       
/*  59 */       int j = (int)l;
/*     */       
/*  61 */       this._dimensions = new Array.ArrayDimension[j];
/*  62 */       for (byte b = 0; b < j; b++) {
/*     */         
/*  64 */         this._dimensions[b] = new Array.ArrayDimension(param1ArrayOfbyte, i);
/*  65 */         i += 8;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     long getNumberOfScalarValues() {
/*  71 */       long l = 1L;
/*  72 */       for (Array.ArrayDimension arrayDimension : this._dimensions)
/*  73 */         l *= arrayDimension._size; 
/*  74 */       return l;
/*     */     }
/*     */ 
/*     */     
/*     */     int getSize() {
/*  79 */       return 8 + this._dimensions.length * 8;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     int getType() {
/*  85 */       return this._type;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Array() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Array(byte[] paramArrayOfbyte, int paramInt) {
/*  98 */     read(paramArrayOfbyte, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   int read(byte[] paramArrayOfbyte, int paramInt) {
/* 103 */     int i = paramInt;
/*     */     
/* 105 */     this._header = new ArrayHeader(paramArrayOfbyte, i);
/* 106 */     i += this._header.getSize();
/*     */     
/* 108 */     long l = this._header.getNumberOfScalarValues();
/* 109 */     if (l > 2147483647L) {
/* 110 */       throw new UnsupportedOperationException("Sorry, but POI can't store array of properties with size of " + l + " in memory");
/*     */     }
/*     */     
/* 113 */     int j = (int)l;
/*     */     
/* 115 */     this._values = new TypedPropertyValue[j];
/* 116 */     int k = this._header._type;
/* 117 */     if (k == 12) {
/*     */       
/* 119 */       for (byte b = 0; b < j; b++)
/*     */       {
/* 121 */         TypedPropertyValue typedPropertyValue = new TypedPropertyValue();
/* 122 */         i += typedPropertyValue.read(paramArrayOfbyte, i);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 127 */       for (byte b = 0; b < j; b++) {
/*     */         
/* 129 */         TypedPropertyValue typedPropertyValue = new TypedPropertyValue(k, null);
/*     */         
/* 131 */         i += typedPropertyValue.readValuePadded(paramArrayOfbyte, i);
/*     */       } 
/*     */     } 
/*     */     
/* 135 */     return i - paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\Array.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */