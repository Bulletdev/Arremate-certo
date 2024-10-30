/*     */ package oshi.util.platform.windows;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.WbemcliUtil;
/*     */ import java.time.OffsetDateTime;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.util.Constants;
/*     */ import oshi.util.ParseUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public final class WmiUtil
/*     */ {
/*     */   public static final String OHM_NAMESPACE = "ROOT\\OpenHardwareMonitor";
/*     */   private static final String CLASS_CAST_MSG = "%s is not a %s type. CIM Type is %d and VT type is %d";
/*     */   
/*     */   public static <T extends Enum<T>> String queryToString(WbemcliUtil.WmiQuery<T> paramWmiQuery) {
/*  67 */     Enum[] arrayOfEnum = paramWmiQuery.getPropertyEnum().getEnumConstants();
/*  68 */     StringBuilder stringBuilder = new StringBuilder("SELECT ");
/*  69 */     stringBuilder.append(arrayOfEnum[0].name());
/*  70 */     for (byte b = 1; b < arrayOfEnum.length; b++) {
/*  71 */       stringBuilder.append(',').append(arrayOfEnum[b].name());
/*     */     }
/*  73 */     stringBuilder.append(" FROM ").append(paramWmiQuery.getWmiClassName());
/*  74 */     return stringBuilder.toString();
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
/*     */   public static <T extends Enum<T>> String getString(WbemcliUtil.WmiResult<T> paramWmiResult, T paramT, int paramInt) {
/*  92 */     if (paramWmiResult.getCIMType((Enum)paramT) == 8) {
/*  93 */       return getStr(paramWmiResult, paramT, paramInt);
/*     */     }
/*  95 */     throw new ClassCastException(String.format("%s is not a %s type. CIM Type is %d and VT type is %d", new Object[] { paramT.name(), "String", 
/*  96 */             Integer.valueOf(paramWmiResult.getCIMType(paramT)), Integer.valueOf(paramWmiResult.getVtType(paramT)) }));
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
/*     */   public static <T extends Enum<T>> String getDateString(WbemcliUtil.WmiResult<T> paramWmiResult, T paramT, int paramInt) {
/* 114 */     OffsetDateTime offsetDateTime = getDateTime(paramWmiResult, paramT, paramInt);
/*     */     
/* 116 */     if (offsetDateTime.equals(Constants.UNIX_EPOCH)) {
/* 117 */       return "";
/*     */     }
/* 119 */     return offsetDateTime.toLocalDate().toString();
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
/*     */   public static <T extends Enum<T>> OffsetDateTime getDateTime(WbemcliUtil.WmiResult<T> paramWmiResult, T paramT, int paramInt) {
/* 138 */     if (paramWmiResult.getCIMType((Enum)paramT) == 101) {
/* 139 */       return ParseUtil.parseCimDateTimeToOffset(getStr(paramWmiResult, paramT, paramInt));
/*     */     }
/* 141 */     throw new ClassCastException(String.format("%s is not a %s type. CIM Type is %d and VT type is %d", new Object[] { paramT.name(), "DateTime", 
/* 142 */             Integer.valueOf(paramWmiResult.getCIMType(paramT)), Integer.valueOf(paramWmiResult.getVtType(paramT)) }));
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
/*     */   public static <T extends Enum<T>> String getRefString(WbemcliUtil.WmiResult<T> paramWmiResult, T paramT, int paramInt) {
/* 160 */     if (paramWmiResult.getCIMType((Enum)paramT) == 102) {
/* 161 */       return getStr(paramWmiResult, paramT, paramInt);
/*     */     }
/* 163 */     throw new ClassCastException(String.format("%s is not a %s type. CIM Type is %d and VT type is %d", new Object[] { paramT.name(), "Reference", 
/* 164 */             Integer.valueOf(paramWmiResult.getCIMType(paramT)), Integer.valueOf(paramWmiResult.getVtType(paramT)) }));
/*     */   }
/*     */   
/*     */   private static <T extends Enum<T>> String getStr(WbemcliUtil.WmiResult<T> paramWmiResult, T paramT, int paramInt) {
/* 168 */     Object object = paramWmiResult.getValue((Enum)paramT, paramInt);
/* 169 */     if (object == null)
/* 170 */       return ""; 
/* 171 */     if (paramWmiResult.getVtType((Enum)paramT) == 8) {
/* 172 */       return (String)object;
/*     */     }
/* 174 */     throw new ClassCastException(String.format("%s is not a %s type. CIM Type is %d and VT type is %d", new Object[] { paramT.name(), "String-mapped", 
/* 175 */             Integer.valueOf(paramWmiResult.getCIMType(paramT)), Integer.valueOf(paramWmiResult.getVtType(paramT)) }));
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
/*     */   public static <T extends Enum<T>> long getUint64(WbemcliUtil.WmiResult<T> paramWmiResult, T paramT, int paramInt) {
/* 195 */     Object object = paramWmiResult.getValue((Enum)paramT, paramInt);
/* 196 */     if (object == null)
/* 197 */       return 0L; 
/* 198 */     if (paramWmiResult.getCIMType((Enum)paramT) == 21 && paramWmiResult.getVtType((Enum)paramT) == 8) {
/* 199 */       return ParseUtil.parseLongOrDefault((String)object, 0L);
/*     */     }
/* 201 */     throw new ClassCastException(String.format("%s is not a %s type. CIM Type is %d and VT type is %d", new Object[] { paramT.name(), "UINT64", 
/* 202 */             Integer.valueOf(paramWmiResult.getCIMType(paramT)), Integer.valueOf(paramWmiResult.getVtType(paramT)) }));
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
/*     */   public static <T extends Enum<T>> int getUint32(WbemcliUtil.WmiResult<T> paramWmiResult, T paramT, int paramInt) {
/* 222 */     if (paramWmiResult.getCIMType((Enum)paramT) == 19) {
/* 223 */       return getInt(paramWmiResult, paramT, paramInt);
/*     */     }
/* 225 */     throw new ClassCastException(String.format("%s is not a %s type. CIM Type is %d and VT type is %d", new Object[] { paramT.name(), "UINT32", 
/* 226 */             Integer.valueOf(paramWmiResult.getCIMType(paramT)), Integer.valueOf(paramWmiResult.getVtType(paramT)) }));
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
/*     */   public static <T extends Enum<T>> long getUint32asLong(WbemcliUtil.WmiResult<T> paramWmiResult, T paramT, int paramInt) {
/* 244 */     if (paramWmiResult.getCIMType((Enum)paramT) == 19) {
/* 245 */       return getInt(paramWmiResult, paramT, paramInt) & 0xFFFFFFFFL;
/*     */     }
/* 247 */     throw new ClassCastException(String.format("%s is not a %s type. CIM Type is %d and VT type is %d", new Object[] { paramT.name(), "UINT32", 
/* 248 */             Integer.valueOf(paramWmiResult.getCIMType(paramT)), Integer.valueOf(paramWmiResult.getVtType(paramT)) }));
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
/*     */   public static <T extends Enum<T>> int getSint32(WbemcliUtil.WmiResult<T> paramWmiResult, T paramT, int paramInt) {
/* 268 */     if (paramWmiResult.getCIMType((Enum)paramT) == 3) {
/* 269 */       return getInt(paramWmiResult, paramT, paramInt);
/*     */     }
/* 271 */     throw new ClassCastException(String.format("%s is not a %s type. CIM Type is %d and VT type is %d", new Object[] { paramT.name(), "SINT32", 
/* 272 */             Integer.valueOf(paramWmiResult.getCIMType(paramT)), Integer.valueOf(paramWmiResult.getVtType(paramT)) }));
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
/*     */   public static <T extends Enum<T>> int getUint16(WbemcliUtil.WmiResult<T> paramWmiResult, T paramT, int paramInt) {
/* 292 */     if (paramWmiResult.getCIMType((Enum)paramT) == 18) {
/* 293 */       return getInt(paramWmiResult, paramT, paramInt);
/*     */     }
/* 295 */     throw new ClassCastException(String.format("%s is not a %s type. CIM Type is %d and VT type is %d", new Object[] { paramT.name(), "UINT16", 
/* 296 */             Integer.valueOf(paramWmiResult.getCIMType(paramT)), Integer.valueOf(paramWmiResult.getVtType(paramT)) }));
/*     */   }
/*     */   
/*     */   private static <T extends Enum<T>> int getInt(WbemcliUtil.WmiResult<T> paramWmiResult, T paramT, int paramInt) {
/* 300 */     Object object = paramWmiResult.getValue((Enum)paramT, paramInt);
/* 301 */     if (object == null)
/* 302 */       return 0; 
/* 303 */     if (paramWmiResult.getVtType((Enum)paramT) == 3) {
/* 304 */       return ((Integer)object).intValue();
/*     */     }
/* 306 */     throw new ClassCastException(String.format("%s is not a %s type. CIM Type is %d and VT type is %d", new Object[] { paramT.name(), "32-bit integer", 
/* 307 */             Integer.valueOf(paramWmiResult.getCIMType(paramT)), Integer.valueOf(paramWmiResult.getVtType(paramT)) }));
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
/*     */   public static <T extends Enum<T>> float getFloat(WbemcliUtil.WmiResult<T> paramWmiResult, T paramT, int paramInt) {
/* 325 */     Object object = paramWmiResult.getValue((Enum)paramT, paramInt);
/* 326 */     if (object == null)
/* 327 */       return 0.0F; 
/* 328 */     if (paramWmiResult.getCIMType((Enum)paramT) == 4 && paramWmiResult.getVtType((Enum)paramT) == 4) {
/* 329 */       return ((Float)object).floatValue();
/*     */     }
/* 331 */     throw new ClassCastException(String.format("%s is not a %s type. CIM Type is %d and VT type is %d", new Object[] { paramT.name(), "Float", 
/* 332 */             Integer.valueOf(paramWmiResult.getCIMType(paramT)), Integer.valueOf(paramWmiResult.getVtType(paramT)) }));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\platform\windows\WmiUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */