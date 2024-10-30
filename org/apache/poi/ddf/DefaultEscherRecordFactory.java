/*     */ package org.apache.poi.ddf;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ public class DefaultEscherRecordFactory
/*     */   implements EscherRecordFactory
/*     */ {
/*  32 */   private static Class<?>[] escherRecordClasses = new Class[] { EscherBSERecord.class, EscherOptRecord.class, EscherTertiaryOptRecord.class, EscherClientAnchorRecord.class, EscherDgRecord.class, EscherSpgrRecord.class, EscherSpRecord.class, EscherClientDataRecord.class, EscherDggRecord.class, EscherSplitMenuColorsRecord.class, EscherChildAnchorRecord.class, EscherTextboxRecord.class };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  39 */   private static Map<Short, Constructor<? extends EscherRecord>> recordsMap = recordsToMap(escherRecordClasses);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EscherRecord createRecord(byte[] paramArrayOfbyte, int paramInt) {
/*     */     EscherRecord escherRecord;
/*  50 */     short s1 = LittleEndian.getShort(paramArrayOfbyte, paramInt);
/*  51 */     short s2 = LittleEndian.getShort(paramArrayOfbyte, paramInt + 2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  58 */     if (isContainer(s1, s2)) {
/*  59 */       EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
/*  60 */       escherContainerRecord.setRecordId(s2);
/*  61 */       escherContainerRecord.setOptions(s1);
/*  62 */       return escherContainerRecord;
/*     */     } 
/*     */     
/*  65 */     if (s2 >= -4072 && s2 <= -3817) {
/*     */       EscherBlipRecord escherBlipRecord;
/*     */       
/*  68 */       if (s2 == -4065 || s2 == -4067 || s2 == -4066) {
/*     */ 
/*     */ 
/*     */         
/*  72 */         escherBlipRecord = new EscherBitmapBlip();
/*     */       }
/*  74 */       else if (s2 == -4070 || s2 == -4069 || s2 == -4068) {
/*     */ 
/*     */ 
/*     */         
/*  78 */         escherBlipRecord = new EscherMetafileBlip();
/*     */       } else {
/*  80 */         escherBlipRecord = new EscherBlipRecord();
/*     */       } 
/*  82 */       escherBlipRecord.setRecordId(s2);
/*  83 */       escherBlipRecord.setOptions(s1);
/*  84 */       return escherBlipRecord;
/*     */     } 
/*     */     
/*  87 */     Constructor<EscherRecord> constructor = (Constructor)recordsMap.get(Short.valueOf(s2));
/*     */     
/*  89 */     if (constructor == null) {
/*  90 */       return new UnknownEscherRecord();
/*     */     }
/*     */     try {
/*  93 */       escherRecord = constructor.newInstance(new Object[0]);
/*  94 */     } catch (Exception exception) {
/*  95 */       return new UnknownEscherRecord();
/*     */     } 
/*  97 */     escherRecord.setRecordId(s2);
/*  98 */     escherRecord.setOptions(s1);
/*  99 */     return escherRecord;
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
/*     */   protected static Map<Short, Constructor<? extends EscherRecord>> recordsToMap(Class<?>[] paramArrayOfClass) {
/* 111 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 112 */     Class[] arrayOfClass = new Class[0];
/*     */     
/* 114 */     for (Class<?> clazz1 : paramArrayOfClass) {
/*     */       short s; Constructor<?> constructor;
/* 116 */       Class<?> clazz2 = clazz1;
/*     */       
/*     */       try {
/* 119 */         s = clazz2.getField("RECORD_ID").getShort(null);
/* 120 */       } catch (IllegalArgumentException illegalArgumentException) {
/* 121 */         throw new RuntimeException(illegalArgumentException);
/* 122 */       } catch (IllegalAccessException illegalAccessException) {
/* 123 */         throw new RuntimeException(illegalAccessException);
/* 124 */       } catch (NoSuchFieldException noSuchFieldException) {
/* 125 */         throw new RuntimeException(noSuchFieldException);
/*     */       } 
/*     */       
/*     */       try {
/* 129 */         constructor = clazz2.getConstructor(arrayOfClass);
/* 130 */       } catch (NoSuchMethodException noSuchMethodException) {
/* 131 */         throw new RuntimeException(noSuchMethodException);
/*     */       } 
/* 133 */       hashMap.put(Short.valueOf(s), constructor);
/*     */     } 
/* 135 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   public static boolean isContainer(short paramShort1, short paramShort2) {
/* 139 */     if (paramShort2 >= -4096 && paramShort2 <= -4091)
/*     */     {
/* 141 */       return true;
/*     */     }
/* 143 */     if (paramShort2 == -4083) {
/* 144 */       return false;
/*     */     }
/* 146 */     return ((paramShort1 & 0xF) == 15);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\DefaultEscherRecordFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */