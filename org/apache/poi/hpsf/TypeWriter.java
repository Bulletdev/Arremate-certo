/*     */ package org.apache.poi.hpsf;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
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
/*     */ public class TypeWriter
/*     */ {
/*     */   public static int writeToStream(OutputStream paramOutputStream, short paramShort) throws IOException {
/*  42 */     LittleEndian.putShort(paramOutputStream, paramShort);
/*  43 */     return 2;
/*     */   }
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
/*     */   public static int writeToStream(OutputStream paramOutputStream, int paramInt) throws IOException {
/*  57 */     LittleEndian.putInt(paramInt, paramOutputStream);
/*  58 */     return 4;
/*     */   }
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
/*     */   public static int writeToStream(OutputStream paramOutputStream, long paramLong) throws IOException {
/*  72 */     LittleEndian.putLong(paramLong, paramOutputStream);
/*  73 */     return 8;
/*     */   }
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
/*     */   public static void writeUShortToStream(OutputStream paramOutputStream, int paramInt) throws IOException {
/*  86 */     int i = paramInt & 0xFFFF0000;
/*  87 */     if (i != 0) {
/*  88 */       throw new IllegalPropertySetDataException("Value " + paramInt + " cannot be represented by 2 bytes.");
/*     */     }
/*  90 */     LittleEndian.putUShort(paramInt, paramOutputStream);
/*     */   }
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
/*     */   public static int writeUIntToStream(OutputStream paramOutputStream, long paramLong) throws IOException {
/* 104 */     long l = paramLong & 0xFFFFFFFF00000000L;
/* 105 */     if (l != 0L && l != -4294967296L) {
/* 106 */       throw new IllegalPropertySetDataException("Value " + paramLong + " cannot be represented by 4 bytes.");
/*     */     }
/* 108 */     LittleEndian.putUInt(paramLong, paramOutputStream);
/* 109 */     return 4;
/*     */   }
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
/*     */   public static int writeToStream(OutputStream paramOutputStream, ClassID paramClassID) throws IOException {
/* 123 */     byte[] arrayOfByte = new byte[16];
/* 124 */     paramClassID.write(arrayOfByte, 0);
/* 125 */     paramOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
/* 126 */     return arrayOfByte.length;
/*     */   }
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
/*     */   public static void writeToStream(OutputStream paramOutputStream, Property[] paramArrayOfProperty, int paramInt) throws IOException, UnsupportedVariantTypeException {
/* 148 */     if (paramArrayOfProperty == null) {
/*     */       return;
/*     */     }
/*     */     
/*     */     byte b;
/* 153 */     for (b = 0; b < paramArrayOfProperty.length; b++) {
/*     */       
/* 155 */       Property property = paramArrayOfProperty[b];
/* 156 */       writeUIntToStream(paramOutputStream, property.getID());
/* 157 */       writeUIntToStream(paramOutputStream, property.getSize());
/*     */     } 
/*     */ 
/*     */     
/* 161 */     for (b = 0; b < paramArrayOfProperty.length; b++) {
/*     */       
/* 163 */       Property property = paramArrayOfProperty[b];
/* 164 */       long l = property.getType();
/* 165 */       writeUIntToStream(paramOutputStream, l);
/* 166 */       VariantSupport.write(paramOutputStream, (int)l, property.getValue(), paramInt);
/*     */     } 
/*     */   }
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
/*     */   public static int writeToStream(OutputStream paramOutputStream, double paramDouble) throws IOException {
/* 183 */     LittleEndian.putDouble(paramDouble, paramOutputStream);
/* 184 */     return 8;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\TypeWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */