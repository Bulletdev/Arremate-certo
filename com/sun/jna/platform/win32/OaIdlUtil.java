/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import java.lang.reflect.Array;
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
/*     */ public abstract class OaIdlUtil
/*     */ {
/*     */   public static Object toPrimitiveArray(OaIdl.SAFEARRAY paramSAFEARRAY, boolean paramBoolean) {
/* 105 */     Pointer pointer = paramSAFEARRAY.accessData(); try {
/*     */       byte[] arrayOfByte; short[] arrayOfShort; int[] arrayOfInt3; float[] arrayOfFloat; double[] arrayOfDouble; Pointer[] arrayOfPointer; Structure[] arrayOfStructure; Variant.VARIANT vARIANT;
/* 107 */       int i = paramSAFEARRAY.getDimensionCount();
/* 108 */       int[] arrayOfInt1 = new int[i];
/* 109 */       int[] arrayOfInt2 = new int[i];
/* 110 */       int j = paramSAFEARRAY.getVarType().intValue();
/*     */       int k;
/* 112 */       for (k = 0; k < i; k++) {
/* 113 */         arrayOfInt1[k] = paramSAFEARRAY.getUBound(k) - paramSAFEARRAY.getLBound(k) + 1;
/*     */       }
/*     */       
/* 116 */       for (k = i - 1; k >= 0; k--) {
/* 117 */         if (k == i - 1) {
/* 118 */           arrayOfInt2[k] = 1;
/*     */         } else {
/* 120 */           arrayOfInt2[k] = arrayOfInt2[k + 1] * arrayOfInt1[k + 1];
/*     */         } 
/*     */       } 
/*     */       
/* 124 */       if (i == 0) {
/* 125 */         throw new IllegalArgumentException("Supplied Array has no dimensions.");
/*     */       }
/*     */       
/* 128 */       k = arrayOfInt2[0] * arrayOfInt1[0];
/*     */ 
/*     */       
/* 131 */       switch (j) {
/*     */         case 16:
/*     */         case 17:
/* 134 */           arrayOfByte = pointer.getByteArray(0L, k);
/*     */           break;
/*     */         case 2:
/*     */         case 11:
/*     */         case 18:
/* 139 */           arrayOfShort = pointer.getShortArray(0L, k);
/*     */           break;
/*     */         case 3:
/*     */         case 10:
/*     */         case 19:
/*     */         case 22:
/*     */         case 23:
/* 146 */           arrayOfInt3 = pointer.getIntArray(0L, k);
/*     */           break;
/*     */         case 4:
/* 149 */           arrayOfFloat = pointer.getFloatArray(0L, k);
/*     */           break;
/*     */         case 5:
/*     */         case 7:
/* 153 */           arrayOfDouble = pointer.getDoubleArray(0L, k);
/*     */           break;
/*     */         case 8:
/* 156 */           arrayOfPointer = pointer.getPointerArray(0L, k);
/*     */           break;
/*     */         case 12:
/* 159 */           vARIANT = new Variant.VARIANT(pointer);
/* 160 */           arrayOfStructure = vARIANT.toArray(k);
/*     */           break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         default:
/* 168 */           throw new IllegalStateException("Type not supported: " + j);
/*     */       } 
/*     */       
/* 171 */       Object object = Array.newInstance(Object.class, arrayOfInt1);
/* 172 */       toPrimitiveArray(arrayOfStructure, object, arrayOfInt1, arrayOfInt2, j, new int[0]);
/* 173 */       return object;
/*     */     } finally {
/* 175 */       paramSAFEARRAY.unaccessData();
/* 176 */       if (paramBoolean) {
/* 177 */         paramSAFEARRAY.destroy();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void toPrimitiveArray(Object paramObject1, Object paramObject2, int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt, int[] paramArrayOfint3) {
/* 183 */     int i = paramArrayOfint3.length;
/* 184 */     int[] arrayOfInt = new int[paramArrayOfint3.length + 1];
/* 185 */     System.arraycopy(paramArrayOfint3, 0, arrayOfInt, 0, i);
/* 186 */     for (byte b = 0; b < paramArrayOfint1[i]; b++) {
/* 187 */       arrayOfInt[i] = b;
/* 188 */       if (i == paramArrayOfint1.length - 1) {
/* 189 */         Variant.VARIANT vARIANT; int j = 0; int k;
/* 190 */         for (k = 0; k < i; k++) {
/* 191 */           j += paramArrayOfint2[k] * paramArrayOfint3[k];
/*     */         }
/* 193 */         j += arrayOfInt[i];
/* 194 */         k = arrayOfInt[i];
/* 195 */         switch (paramInt) {
/*     */           case 11:
/* 197 */             Array.set(paramObject2, k, Boolean.valueOf((Array.getShort(paramObject1, j) != 0)));
/*     */             break;
/*     */           case 16:
/*     */           case 17:
/* 201 */             Array.set(paramObject2, k, Byte.valueOf(Array.getByte(paramObject1, j)));
/*     */             break;
/*     */           case 2:
/*     */           case 18:
/* 205 */             Array.set(paramObject2, k, Short.valueOf(Array.getShort(paramObject1, j)));
/*     */             break;
/*     */           case 3:
/*     */           case 19:
/*     */           case 22:
/*     */           case 23:
/* 211 */             Array.set(paramObject2, k, Integer.valueOf(Array.getInt(paramObject1, j)));
/*     */             break;
/*     */           case 10:
/* 214 */             Array.set(paramObject2, k, new WinDef.SCODE(Array.getInt(paramObject1, j)));
/*     */             break;
/*     */           case 4:
/* 217 */             Array.set(paramObject2, k, Float.valueOf(Array.getFloat(paramObject1, j)));
/*     */             break;
/*     */           case 5:
/* 220 */             Array.set(paramObject2, k, Double.valueOf(Array.getDouble(paramObject1, j)));
/*     */             break;
/*     */           case 7:
/* 223 */             Array.set(paramObject2, k, (new OaIdl.DATE(Array.getDouble(paramObject1, j))).getAsJavaDate());
/*     */             break;
/*     */           case 8:
/* 226 */             Array.set(paramObject2, k, (new WTypes.BSTR((Pointer)Array.get(paramObject1, j))).getValue());
/*     */             break;
/*     */           case 12:
/* 229 */             vARIANT = (Variant.VARIANT)Array.get(paramObject1, j);
/* 230 */             switch (vARIANT.getVarType().intValue()) {
/*     */               case 0:
/*     */               case 1:
/* 233 */                 Array.set(paramObject2, k, null);
/*     */                 break;
/*     */               case 11:
/* 236 */                 Array.set(paramObject2, k, Boolean.valueOf(vARIANT.booleanValue()));
/*     */                 break;
/*     */               case 16:
/*     */               case 17:
/* 240 */                 Array.set(paramObject2, k, Byte.valueOf(vARIANT.byteValue()));
/*     */                 break;
/*     */               case 2:
/*     */               case 18:
/* 244 */                 Array.set(paramObject2, k, Short.valueOf(vARIANT.shortValue()));
/*     */                 break;
/*     */               case 3:
/*     */               case 19:
/*     */               case 22:
/*     */               case 23:
/* 250 */                 Array.set(paramObject2, k, Integer.valueOf(vARIANT.intValue()));
/*     */                 break;
/*     */               case 10:
/* 253 */                 Array.set(paramObject2, k, new WinDef.SCODE(vARIANT.intValue()));
/*     */                 break;
/*     */               case 4:
/* 256 */                 Array.set(paramObject2, k, Float.valueOf(vARIANT.floatValue()));
/*     */                 break;
/*     */               case 5:
/* 259 */                 Array.set(paramObject2, k, Double.valueOf(vARIANT.doubleValue()));
/*     */                 break;
/*     */               case 7:
/* 262 */                 Array.set(paramObject2, k, vARIANT.dateValue());
/*     */                 break;
/*     */               case 8:
/* 265 */                 Array.set(paramObject2, k, vARIANT.stringValue());
/*     */                 break;
/*     */             } 
/* 268 */             throw new IllegalStateException("Type not supported: " + vARIANT.getVarType().intValue());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           default:
/* 277 */             throw new IllegalStateException("Type not supported: " + paramInt);
/*     */         } 
/*     */       } else {
/* 280 */         toPrimitiveArray(paramObject1, Array.get(paramObject2, b), paramArrayOfint1, paramArrayOfint2, paramInt, arrayOfInt);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\OaIdlUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */