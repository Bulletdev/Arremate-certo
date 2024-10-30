/*     */ package org.apache.poi.ss.formula.constant;
/*     */ 
/*     */ import org.apache.poi.util.LittleEndianInput;
/*     */ import org.apache.poi.util.LittleEndianOutput;
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
/*     */ public final class ConstantValueParser
/*     */ {
/*     */   private static final int TYPE_EMPTY = 0;
/*     */   private static final int TYPE_NUMBER = 1;
/*     */   private static final int TYPE_STRING = 2;
/*     */   private static final int TYPE_BOOLEAN = 4;
/*     */   private static final int TYPE_ERROR_CODE = 16;
/*     */   private static final int TRUE_ENCODING = 1;
/*     */   private static final int FALSE_ENCODING = 0;
/*  43 */   private static final Object EMPTY_REPRESENTATION = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object[] parse(LittleEndianInput paramLittleEndianInput, int paramInt) {
/*  50 */     Object[] arrayOfObject = new Object[paramInt];
/*  51 */     for (byte b = 0; b < arrayOfObject.length; b++) {
/*  52 */       arrayOfObject[b] = readAConstantValue(paramLittleEndianInput);
/*     */     }
/*  54 */     return arrayOfObject;
/*     */   }
/*     */   private static Object readAConstantValue(LittleEndianInput paramLittleEndianInput) {
/*     */     int i;
/*  58 */     byte b = paramLittleEndianInput.readByte();
/*  59 */     switch (b) {
/*     */       case 0:
/*  61 */         paramLittleEndianInput.readLong();
/*  62 */         return EMPTY_REPRESENTATION;
/*     */       case 1:
/*  64 */         return new Double(paramLittleEndianInput.readDouble());
/*     */       case 2:
/*  66 */         return StringUtil.readUnicodeString(paramLittleEndianInput);
/*     */       case 4:
/*  68 */         return readBoolean(paramLittleEndianInput);
/*     */       case 16:
/*  70 */         i = paramLittleEndianInput.readUShort();
/*     */         
/*  72 */         paramLittleEndianInput.readUShort();
/*  73 */         paramLittleEndianInput.readInt();
/*  74 */         return ErrorConstant.valueOf(i);
/*     */     } 
/*  76 */     throw new RuntimeException("Unknown grbit value (" + b + ")");
/*     */   }
/*     */   
/*     */   private static Object readBoolean(LittleEndianInput paramLittleEndianInput) {
/*  80 */     byte b = (byte)(int)paramLittleEndianInput.readLong();
/*  81 */     switch (b) {
/*     */       case 0:
/*  83 */         return Boolean.FALSE;
/*     */       case 1:
/*  85 */         return Boolean.TRUE;
/*     */     } 
/*     */     
/*  88 */     throw new RuntimeException("unexpected boolean encoding (" + b + ")");
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getEncodedSize(Object[] paramArrayOfObject) {
/*  93 */     int i = paramArrayOfObject.length * 1;
/*  94 */     for (byte b = 0; b < paramArrayOfObject.length; b++) {
/*  95 */       i += getEncodedSize(paramArrayOfObject[b]);
/*     */     }
/*  97 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int getEncodedSize(Object paramObject) {
/* 104 */     if (paramObject == EMPTY_REPRESENTATION) {
/* 105 */       return 8;
/*     */     }
/* 107 */     Class<?> clazz = paramObject.getClass();
/*     */     
/* 109 */     if (clazz == Boolean.class || clazz == Double.class || clazz == ErrorConstant.class) {
/* 110 */       return 8;
/*     */     }
/* 112 */     String str = (String)paramObject;
/* 113 */     return StringUtil.getEncodedSize(str);
/*     */   }
/*     */   
/*     */   public static void encode(LittleEndianOutput paramLittleEndianOutput, Object[] paramArrayOfObject) {
/* 117 */     for (byte b = 0; b < paramArrayOfObject.length; b++) {
/* 118 */       encodeSingleValue(paramLittleEndianOutput, paramArrayOfObject[b]);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void encodeSingleValue(LittleEndianOutput paramLittleEndianOutput, Object paramObject) {
/* 123 */     if (paramObject == EMPTY_REPRESENTATION) {
/* 124 */       paramLittleEndianOutput.writeByte(0);
/* 125 */       paramLittleEndianOutput.writeLong(0L);
/*     */       return;
/*     */     } 
/* 128 */     if (paramObject instanceof Boolean) {
/* 129 */       Boolean bool = (Boolean)paramObject;
/* 130 */       paramLittleEndianOutput.writeByte(4);
/* 131 */       long l = bool.booleanValue() ? 1L : 0L;
/* 132 */       paramLittleEndianOutput.writeLong(l);
/*     */       return;
/*     */     } 
/* 135 */     if (paramObject instanceof Double) {
/* 136 */       Double double_ = (Double)paramObject;
/* 137 */       paramLittleEndianOutput.writeByte(1);
/* 138 */       paramLittleEndianOutput.writeDouble(double_.doubleValue());
/*     */       return;
/*     */     } 
/* 141 */     if (paramObject instanceof String) {
/* 142 */       String str = (String)paramObject;
/* 143 */       paramLittleEndianOutput.writeByte(2);
/* 144 */       StringUtil.writeUnicodeString(paramLittleEndianOutput, str);
/*     */       return;
/*     */     } 
/* 147 */     if (paramObject instanceof ErrorConstant) {
/* 148 */       ErrorConstant errorConstant = (ErrorConstant)paramObject;
/* 149 */       paramLittleEndianOutput.writeByte(16);
/* 150 */       long l = errorConstant.getErrorCode();
/* 151 */       paramLittleEndianOutput.writeLong(l);
/*     */       
/*     */       return;
/*     */     } 
/* 155 */     throw new IllegalStateException("Unexpected value type (" + paramObject.getClass().getName() + "'");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\constant\ConstantValueParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */