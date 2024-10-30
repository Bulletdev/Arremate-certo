/*     */ package org.apache.poi.hpsf;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.util.CodePageUtil;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
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
/*     */ public class Property
/*     */ {
/*     */   protected long id;
/*     */   protected long type;
/*     */   protected Object value;
/*     */   
/*     */   public long getID() {
/*  73 */     return this.id;
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
/*     */   public long getType() {
/*  89 */     return this.type;
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
/*     */   public Object getValue() {
/* 105 */     return this.value;
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
/*     */   public Property(long paramLong1, long paramLong2, Object paramObject) {
/* 120 */     this.id = paramLong1;
/* 121 */     this.type = paramLong2;
/* 122 */     this.value = paramObject;
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
/*     */   
/*     */   public Property(long paramLong1, byte[] paramArrayOfbyte, long paramLong2, int paramInt1, int paramInt2) throws UnsupportedEncodingException {
/* 145 */     this.id = paramLong1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 151 */     if (paramLong1 == 0L) {
/*     */       
/* 153 */       this.value = readDictionary(paramArrayOfbyte, paramLong2, paramInt1, paramInt2);
/*     */       
/*     */       return;
/*     */     } 
/* 157 */     int i = (int)paramLong2;
/* 158 */     this.type = LittleEndian.getUInt(paramArrayOfbyte, i);
/* 159 */     i += 4;
/*     */ 
/*     */     
/*     */     try {
/* 163 */       this.value = VariantSupport.read(paramArrayOfbyte, i, paramInt1, (int)this.type, paramInt2);
/*     */     }
/* 165 */     catch (UnsupportedVariantTypeException unsupportedVariantTypeException) {
/*     */       
/* 167 */       VariantSupport.writeUnsupportedTypeMessage(unsupportedVariantTypeException);
/* 168 */       this.value = unsupportedVariantTypeException.getValue();
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
/*     */   
/*     */   protected Property() {}
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
/*     */   protected Map<?, ?> readDictionary(byte[] paramArrayOfbyte, long paramLong, int paramInt1, int paramInt2) throws UnsupportedEncodingException {
/* 200 */     if (paramLong < 0L || paramLong > paramArrayOfbyte.length) {
/* 201 */       throw new HPSFRuntimeException("Illegal offset " + paramLong + " while HPSF stream contains " + paramInt1 + " bytes.");
/*     */     }
/*     */     
/* 204 */     int i = (int)paramLong;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 209 */     long l = LittleEndian.getUInt(paramArrayOfbyte, i);
/* 210 */     i += 4;
/*     */     
/* 212 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>((int)l, 1.0F);
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 217 */       for (byte b = 0; b < l; b++) {
/*     */         int j; byte[] arrayOfByte;
/*     */         byte b1;
/* 220 */         Long long_ = Long.valueOf(LittleEndian.getUInt(paramArrayOfbyte, i));
/* 221 */         i += 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 228 */         long l1 = LittleEndian.getUInt(paramArrayOfbyte, i);
/* 229 */         i += 4;
/*     */ 
/*     */         
/* 232 */         StringBuffer stringBuffer = new StringBuffer();
/* 233 */         switch (paramInt2) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case -1:
/* 239 */             stringBuffer.append(new String(paramArrayOfbyte, i, (int)l1, Charset.forName("ASCII")));
/*     */             break;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case 1200:
/* 246 */             j = (int)(l1 * 2L);
/* 247 */             arrayOfByte = new byte[j];
/* 248 */             for (b1 = 0; b1 < j; b1 += 2) {
/*     */               
/* 250 */               arrayOfByte[b1] = paramArrayOfbyte[i + b1 + 1];
/* 251 */               arrayOfByte[b1 + 1] = paramArrayOfbyte[i + b1];
/*     */             } 
/* 253 */             stringBuffer.append(new String(arrayOfByte, 0, j, CodePageUtil.codepageToEncoding(paramInt2)));
/*     */             break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           default:
/* 261 */             stringBuffer.append(new String(paramArrayOfbyte, i, (int)l1, VariantSupport.codepageToEncoding(paramInt2)));
/*     */             break;
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 268 */         while (stringBuffer.length() > 0 && stringBuffer.charAt(stringBuffer.length() - 1) == '\000')
/* 269 */           stringBuffer.setLength(stringBuffer.length() - 1); 
/* 270 */         if (paramInt2 == 1200) {
/*     */           
/* 272 */           if (l1 % 2L == 1L)
/* 273 */             l1++; 
/* 274 */           i = (int)(i + l1 + l1);
/*     */         } else {
/*     */           
/* 277 */           i = (int)(i + l1);
/* 278 */         }  linkedHashMap.put(long_, stringBuffer.toString());
/*     */       }
/*     */     
/* 281 */     } catch (RuntimeException runtimeException) {
/*     */       
/* 283 */       POILogger pOILogger = POILogFactory.getLogger(getClass());
/* 284 */       pOILogger.log(5, new Object[] { "The property set's dictionary contains bogus data. All dictionary entries starting with the one with ID " + this.id + " will be ignored.", runtimeException });
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 289 */     return linkedHashMap;
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
/*     */   protected int getSize() throws WritingNotSupportedException {
/* 305 */     int j, k, i = VariantSupport.getVariantLength(this.type);
/* 306 */     if (i >= 0)
/* 307 */       return i; 
/* 308 */     if (i == -2)
/*     */     {
/* 310 */       throw new WritingNotSupportedException(this.type, null);
/*     */     }
/*     */     
/* 313 */     byte b = 4;
/* 314 */     switch ((int)this.type) {
/*     */ 
/*     */       
/*     */       case 30:
/* 318 */         j = ((String)this.value).length() + 1;
/* 319 */         k = j % 4;
/* 320 */         if (k > 0)
/* 321 */           j += 4 - k; 
/* 322 */         i += j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 0:
/* 330 */         return i;
/*     */     } 
/*     */     throw new WritingNotSupportedException(this.type, this.value);
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
/*     */   public boolean equals(Object paramObject) {
/* 345 */     if (!(paramObject instanceof Property)) {
/* 346 */       return false;
/*     */     }
/* 348 */     Property property = (Property)paramObject;
/* 349 */     Object object = property.getValue();
/* 350 */     long l = property.getID();
/* 351 */     if (this.id != l || (this.id != 0L && !typesAreEqual(this.type, property.getType())))
/* 352 */       return false; 
/* 353 */     if (this.value == null && object == null)
/* 354 */       return true; 
/* 355 */     if (this.value == null || object == null) {
/* 356 */       return false;
/*     */     }
/*     */     
/* 359 */     Class<?> clazz1 = this.value.getClass();
/* 360 */     Class<?> clazz2 = object.getClass();
/* 361 */     if (!clazz1.isAssignableFrom(clazz2) && !clazz2.isAssignableFrom(clazz1))
/*     */     {
/* 363 */       return false;
/*     */     }
/* 365 */     if (this.value instanceof byte[]) {
/* 366 */       return Util.equal((byte[])this.value, (byte[])object);
/*     */     }
/* 368 */     return this.value.equals(object);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean typesAreEqual(long paramLong1, long paramLong2) {
/* 375 */     if (paramLong1 == paramLong2 || (paramLong1 == 30L && paramLong2 == 31L) || (paramLong2 == 30L && paramLong1 == 31L))
/*     */     {
/*     */       
/* 378 */       return true;
/*     */     }
/* 380 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 390 */     long l = 0L;
/* 391 */     l += this.id;
/* 392 */     l += this.type;
/* 393 */     if (this.value != null)
/* 394 */       l += this.value.hashCode(); 
/* 395 */     return (int)(l & 0xFFFFFFFFL);
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
/*     */   public String toString() {
/* 407 */     StringBuffer stringBuffer = new StringBuffer();
/* 408 */     stringBuffer.append(getClass().getName());
/* 409 */     stringBuffer.append('[');
/* 410 */     stringBuffer.append("id: ");
/* 411 */     stringBuffer.append(getID());
/* 412 */     stringBuffer.append(", type: ");
/* 413 */     stringBuffer.append(getType());
/* 414 */     Object object = getValue();
/* 415 */     stringBuffer.append(", value: ");
/* 416 */     if (object instanceof String) {
/*     */       
/* 418 */       stringBuffer.append(object.toString());
/* 419 */       String str = (String)object;
/* 420 */       int i = str.length();
/* 421 */       byte[] arrayOfByte = new byte[i * 2];
/* 422 */       for (byte b = 0; b < i; b++) {
/*     */         
/* 424 */         char c = str.charAt(b);
/* 425 */         byte b1 = (byte)((c & 0xFF00) >> 8);
/* 426 */         byte b2 = (byte)((c & 0xFF) >> 0);
/* 427 */         arrayOfByte[b * 2] = b1;
/* 428 */         arrayOfByte[b * 2 + 1] = b2;
/*     */       } 
/* 430 */       stringBuffer.append(" [");
/* 431 */       if (arrayOfByte.length > 0) {
/* 432 */         String str1 = HexDump.dump(arrayOfByte, 0L, 0);
/* 433 */         stringBuffer.append(str1);
/*     */       } 
/* 435 */       stringBuffer.append("]");
/*     */     }
/* 437 */     else if (object instanceof byte[]) {
/*     */       
/* 439 */       byte[] arrayOfByte = (byte[])object;
/* 440 */       if (arrayOfByte.length > 0) {
/* 441 */         String str = HexDump.dump(arrayOfByte, 0L, 0);
/* 442 */         stringBuffer.append(str);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 447 */       stringBuffer.append(object.toString());
/*     */     } 
/* 449 */     stringBuffer.append(']');
/* 450 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\Property.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */