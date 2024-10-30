/*     */ package org.apache.poi.hpsf;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.Date;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.util.CodePageUtil;
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
/*     */ public class VariantSupport
/*     */   extends Variant
/*     */ {
/*  49 */   private static final POILogger logger = POILogFactory.getLogger(VariantSupport.class);
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean logUnsupportedTypes = false;
/*     */ 
/*     */   
/*     */   protected static List<Long> unsupportedMessage;
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setLogUnsupportedTypes(boolean paramBoolean) {
/*  61 */     logUnsupportedTypes = paramBoolean;
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
/*     */   public static boolean isLogUnsupportedTypes() {
/*  73 */     return logUnsupportedTypes;
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
/*     */   protected static void writeUnsupportedTypeMessage(UnsupportedVariantTypeException paramUnsupportedVariantTypeException) {
/*  94 */     if (isLogUnsupportedTypes()) {
/*     */       
/*  96 */       if (unsupportedMessage == null)
/*  97 */         unsupportedMessage = new LinkedList<Long>(); 
/*  98 */       Long long_ = Long.valueOf(paramUnsupportedVariantTypeException.getVariantType());
/*  99 */       if (!unsupportedMessage.contains(long_)) {
/*     */         
/* 101 */         logger.log(7, new Object[] { paramUnsupportedVariantTypeException.getMessage() });
/* 102 */         unsupportedMessage.add(long_);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 111 */   public static final int[] SUPPORTED_TYPES = new int[] { 0, 2, 3, 20, 5, 64, 30, 31, 71, 11 };
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
/*     */   public boolean isSupportedType(int paramInt) {
/* 130 */     for (byte b = 0; b < SUPPORTED_TYPES.length; b++) {
/* 131 */       if (paramInt == SUPPORTED_TYPES[b])
/* 132 */         return true; 
/* 133 */     }  return false;
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
/*     */   public static Object read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, long paramLong, int paramInt3) throws ReadingNotSupportedException, UnsupportedEncodingException {
/*     */     int i;
/*     */     Filetime filetime;
/*     */     CodePageString codePageString;
/*     */     UnicodeString unicodeString;
/*     */     ClipboardData clipboardData;
/*     */     VariantBool variantBool;
/* 159 */     TypedPropertyValue typedPropertyValue = new TypedPropertyValue((int)paramLong, null);
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 164 */       i = typedPropertyValue.readValue(paramArrayOfbyte, paramInt1);
/*     */     }
/* 166 */     catch (UnsupportedOperationException unsupportedOperationException) {
/*     */       
/* 168 */       int j = Math.min(paramInt2, paramArrayOfbyte.length - paramInt1);
/* 169 */       byte[] arrayOfByte1 = new byte[j];
/* 170 */       System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte1, 0, j);
/* 171 */       throw new ReadingNotSupportedException(paramLong, arrayOfByte1);
/*     */     } 
/*     */     
/* 174 */     switch ((int)paramLong) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 0:
/*     */       case 3:
/*     */       case 5:
/*     */       case 20:
/* 186 */         return typedPropertyValue.getValue();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 2:
/* 194 */         return Integer.valueOf(((Short)typedPropertyValue.getValue()).intValue());
/*     */ 
/*     */ 
/*     */       
/*     */       case 64:
/* 199 */         filetime = (Filetime)typedPropertyValue.getValue();
/* 200 */         return Util.filetimeToDate((int)filetime.getHigh(), (int)filetime.getLow());
/*     */ 
/*     */ 
/*     */       
/*     */       case 30:
/* 205 */         codePageString = (CodePageString)typedPropertyValue.getValue();
/*     */         
/* 207 */         return codePageString.getJavaValue(paramInt3);
/*     */ 
/*     */       
/*     */       case 31:
/* 211 */         unicodeString = (UnicodeString)typedPropertyValue.getValue();
/*     */         
/* 213 */         return unicodeString.toJavaString();
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
/*     */       case 71:
/* 235 */         clipboardData = (ClipboardData)typedPropertyValue.getValue();
/*     */         
/* 237 */         return clipboardData.toByteArray();
/*     */ 
/*     */ 
/*     */       
/*     */       case 11:
/* 242 */         variantBool = (VariantBool)typedPropertyValue.getValue();
/* 243 */         return Boolean.valueOf(variantBool.getValue());
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 252 */     byte[] arrayOfByte = new byte[i];
/* 253 */     System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte, 0, i);
/* 254 */     throw new ReadingNotSupportedException(paramLong, arrayOfByte);
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
/*     */   public static String codepageToEncoding(int paramInt) throws UnsupportedEncodingException {
/* 276 */     return CodePageUtil.codepageToEncoding(paramInt);
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
/*     */   public static int write(OutputStream paramOutputStream, long paramLong, Object paramObject, int paramInt) throws IOException, WritingNotSupportedException {
/*     */     CodePageString codePageString;
/*     */     int j;
/*     */     byte[] arrayOfByte;
/*     */     long l;
/*     */     char[] arrayOfChar;
/*     */     int k, m;
/*     */     Filetime filetime;
/* 303 */     int i = 0;
/* 304 */     switch ((int)paramLong) {
/*     */ 
/*     */       
/*     */       case 11:
/* 308 */         if (((Boolean)paramObject).booleanValue()) {
/*     */           
/* 310 */           paramOutputStream.write(255);
/* 311 */           paramOutputStream.write(255);
/*     */         }
/*     */         else {
/*     */           
/* 315 */           paramOutputStream.write(0);
/* 316 */           paramOutputStream.write(0);
/*     */         } 
/* 318 */         i += true;
/*     */         break;
/*     */ 
/*     */       
/*     */       case 30:
/* 323 */         codePageString = new CodePageString((String)paramObject, paramInt);
/*     */         
/* 325 */         i += codePageString.write(paramOutputStream);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 31:
/* 330 */         j = ((String)paramObject).length() + 1;
/* 331 */         i += TypeWriter.writeUIntToStream(paramOutputStream, j);
/* 332 */         arrayOfChar = ((String)paramObject).toCharArray();
/* 333 */         for (k = 0; k < arrayOfChar.length; k++) {
/*     */           
/* 335 */           int n = (arrayOfChar[k] & 0xFF00) >> 8;
/* 336 */           int i1 = arrayOfChar[k] & 0xFF;
/* 337 */           byte b1 = (byte)n;
/* 338 */           byte b2 = (byte)i1;
/* 339 */           paramOutputStream.write(b2);
/* 340 */           paramOutputStream.write(b1);
/* 341 */           i += 2;
/*     */         } 
/*     */         
/* 344 */         paramOutputStream.write(0);
/* 345 */         paramOutputStream.write(0);
/* 346 */         i += 2;
/*     */         break;
/*     */ 
/*     */       
/*     */       case 71:
/* 351 */         arrayOfByte = (byte[])paramObject;
/* 352 */         paramOutputStream.write(arrayOfByte);
/* 353 */         i = arrayOfByte.length;
/*     */         break;
/*     */ 
/*     */       
/*     */       case 0:
/* 358 */         i += TypeWriter.writeUIntToStream(paramOutputStream, 0L);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 2:
/* 363 */         i += TypeWriter.writeToStream(paramOutputStream, ((Integer)paramObject).shortValue());
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case 3:
/* 369 */         if (!(paramObject instanceof Integer))
/*     */         {
/* 371 */           throw new ClassCastException("Could not cast an object to " + Integer.class.toString() + ": " + paramObject.getClass().toString() + ", " + paramObject.toString());
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 376 */         i += TypeWriter.writeToStream(paramOutputStream, ((Integer)paramObject).intValue());
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case 20:
/* 382 */         i += TypeWriter.writeToStream(paramOutputStream, ((Long)paramObject).longValue());
/*     */         break;
/*     */ 
/*     */       
/*     */       case 5:
/* 387 */         i += TypeWriter.writeToStream(paramOutputStream, ((Double)paramObject).doubleValue());
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case 64:
/* 393 */         l = Util.dateToFileTime((Date)paramObject);
/* 394 */         k = (int)(l >> 32L & 0xFFFFFFFFL);
/* 395 */         m = (int)(l & 0xFFFFFFFFL);
/* 396 */         filetime = new Filetime(m, k);
/* 397 */         i += filetime.write(paramOutputStream);
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 404 */         if (paramObject instanceof byte[]) {
/*     */           
/* 406 */           byte[] arrayOfByte1 = (byte[])paramObject;
/* 407 */           paramOutputStream.write(arrayOfByte1);
/* 408 */           i = arrayOfByte1.length;
/* 409 */           writeUnsupportedTypeMessage(new WritingNotSupportedException(paramLong, paramObject));
/*     */           
/*     */           break;
/*     */         } 
/* 413 */         throw new WritingNotSupportedException(paramLong, paramObject);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 419 */     while ((i & 0x3) != 0) {
/*     */       
/* 421 */       paramOutputStream.write(0);
/* 422 */       i++;
/*     */     } 
/*     */     
/* 425 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\VariantSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */