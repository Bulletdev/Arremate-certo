/*     */ package org.apache.poi.hpsf;
/*     */ 
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.util.StringUtil;
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
/*     */ class UnicodeString
/*     */ {
/*  27 */   private static final POILogger logger = POILogFactory.getLogger(UnicodeString.class);
/*     */   
/*     */   private byte[] _value;
/*     */ 
/*     */   
/*     */   UnicodeString(byte[] paramArrayOfbyte, int paramInt) {
/*  33 */     int i = LittleEndian.getInt(paramArrayOfbyte, paramInt);
/*  34 */     int j = paramInt + 4;
/*     */     
/*  36 */     if (!validLength(i, paramArrayOfbyte, j)) {
/*     */ 
/*     */ 
/*     */       
/*  40 */       boolean bool = false;
/*  41 */       int k = paramInt % 4;
/*  42 */       if (k != 0) {
/*  43 */         paramInt += k;
/*  44 */         i = LittleEndian.getInt(paramArrayOfbyte, paramInt);
/*  45 */         j = paramInt + 4;
/*     */         
/*  47 */         bool = validLength(i, paramArrayOfbyte, j);
/*     */       } 
/*     */       
/*  50 */       if (!bool) {
/*  51 */         throw new IllegalPropertySetDataException("UnicodeString started at offset #" + paramInt + " is not NULL-terminated");
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  57 */     if (i == 0) {
/*     */       
/*  59 */       this._value = new byte[0];
/*     */       
/*     */       return;
/*     */     } 
/*  63 */     this._value = LittleEndian.getByteArray(paramArrayOfbyte, j, i * 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean validLength(int paramInt1, byte[] paramArrayOfbyte, int paramInt2) {
/*  72 */     if (paramInt1 == 0) {
/*  73 */       return true;
/*     */     }
/*     */     
/*  76 */     int i = paramInt2 + paramInt1 * 2;
/*  77 */     if (i <= paramArrayOfbyte.length)
/*     */     {
/*  79 */       if (paramArrayOfbyte[i - 1] == 0 && paramArrayOfbyte[i - 2] == 0)
/*     */       {
/*  81 */         return true;
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*  86 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   int getSize() {
/*  91 */     return 4 + this._value.length;
/*     */   }
/*     */ 
/*     */   
/*     */   byte[] getValue() {
/*  96 */     return this._value;
/*     */   }
/*     */ 
/*     */   
/*     */   String toJavaString() {
/* 101 */     if (this._value.length == 0) {
/* 102 */       return null;
/*     */     }
/* 104 */     String str = StringUtil.getFromUnicodeLE(this._value, 0, this._value.length >> 1);
/*     */ 
/*     */     
/* 107 */     int i = str.indexOf(false);
/* 108 */     if (i == -1) {
/*     */       
/* 110 */       logger.log(5, new Object[] { "String terminator (\\0) for UnicodeString property value not found.Continue without trimming and hope for the best." });
/*     */ 
/*     */ 
/*     */       
/* 114 */       return str;
/*     */     } 
/* 116 */     if (i != str.length() - 1)
/*     */     {
/* 118 */       logger.log(5, new Object[] { "String terminator (\\0) for UnicodeString property value occured before the end of string. Trimming and hope for the best." });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 123 */     return str.substring(0, i);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\UnicodeString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */