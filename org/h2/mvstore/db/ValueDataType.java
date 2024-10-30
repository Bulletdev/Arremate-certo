/*     */ package org.h2.mvstore.db;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Arrays;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.mvstore.DataUtils;
/*     */ import org.h2.mvstore.WriteBuffer;
/*     */ import org.h2.mvstore.rtree.SpatialDataType;
/*     */ import org.h2.mvstore.type.DataType;
/*     */ import org.h2.result.SortOrder;
/*     */ import org.h2.store.DataHandler;
/*     */ import org.h2.tools.SimpleResultSet;
/*     */ import org.h2.value.CompareMode;
/*     */ import org.h2.value.DataType;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueArray;
/*     */ import org.h2.value.ValueBoolean;
/*     */ import org.h2.value.ValueByte;
/*     */ import org.h2.value.ValueBytes;
/*     */ import org.h2.value.ValueDate;
/*     */ import org.h2.value.ValueDecimal;
/*     */ import org.h2.value.ValueDouble;
/*     */ import org.h2.value.ValueFloat;
/*     */ import org.h2.value.ValueGeometry;
/*     */ import org.h2.value.ValueInt;
/*     */ import org.h2.value.ValueJavaObject;
/*     */ import org.h2.value.ValueLobDb;
/*     */ import org.h2.value.ValueLong;
/*     */ import org.h2.value.ValueNull;
/*     */ import org.h2.value.ValueResultSet;
/*     */ import org.h2.value.ValueShort;
/*     */ import org.h2.value.ValueString;
/*     */ import org.h2.value.ValueStringFixed;
/*     */ import org.h2.value.ValueStringIgnoreCase;
/*     */ import org.h2.value.ValueTime;
/*     */ import org.h2.value.ValueTimestamp;
/*     */ import org.h2.value.ValueTimestampTimeZone;
/*     */ import org.h2.value.ValueUuid;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ValueDataType
/*     */   implements DataType
/*     */ {
/*     */   private static final int INT_0_15 = 32;
/*     */   private static final int LONG_0_7 = 48;
/*     */   private static final int DECIMAL_0_1 = 56;
/*     */   private static final int DECIMAL_SMALL_0 = 58;
/*     */   private static final int DECIMAL_SMALL = 59;
/*     */   private static final int DOUBLE_0_1 = 60;
/*     */   private static final int FLOAT_0_1 = 62;
/*     */   private static final int BOOLEAN_FALSE = 64;
/*     */   private static final int BOOLEAN_TRUE = 65;
/*     */   private static final int INT_NEG = 66;
/*     */   private static final int LONG_NEG = 67;
/*     */   private static final int STRING_0_31 = 68;
/*     */   private static final int BYTES_0_31 = 100;
/*     */   private static final int SPATIAL_KEY_2D = 132;
/*     */   final DataHandler handler;
/*     */   final CompareMode compareMode;
/*     */   final int[] sortTypes;
/*     */   SpatialDataType spatialType;
/*     */   
/*     */   public ValueDataType(CompareMode paramCompareMode, DataHandler paramDataHandler, int[] paramArrayOfint) {
/*  78 */     this.compareMode = paramCompareMode;
/*  79 */     this.handler = paramDataHandler;
/*  80 */     this.sortTypes = paramArrayOfint;
/*     */   }
/*     */   
/*     */   private SpatialDataType getSpatialDataType() {
/*  84 */     if (this.spatialType == null) {
/*  85 */       this.spatialType = new SpatialDataType(2);
/*     */     }
/*  87 */     return this.spatialType;
/*     */   }
/*     */ 
/*     */   
/*     */   public int compare(Object paramObject1, Object paramObject2) {
/*  92 */     if (paramObject1 == paramObject2) {
/*  93 */       return 0;
/*     */     }
/*  95 */     if (paramObject1 instanceof ValueArray && paramObject2 instanceof ValueArray) {
/*  96 */       Value[] arrayOfValue1 = ((ValueArray)paramObject1).getList();
/*  97 */       Value[] arrayOfValue2 = ((ValueArray)paramObject2).getList();
/*  98 */       int i = arrayOfValue1.length;
/*  99 */       int j = arrayOfValue2.length;
/* 100 */       int k = Math.min(i, j);
/* 101 */       for (byte b = 0; b < k; b++) {
/* 102 */         int m = this.sortTypes[b];
/* 103 */         int n = compareValues(arrayOfValue1[b], arrayOfValue2[b], m);
/* 104 */         if (n != 0) {
/* 105 */           return n;
/*     */         }
/*     */       } 
/* 108 */       if (k < i)
/* 109 */         return -1; 
/* 110 */       if (k < j) {
/* 111 */         return 1;
/*     */       }
/* 113 */       return 0;
/*     */     } 
/* 115 */     return compareValues((Value)paramObject1, (Value)paramObject2, 0);
/*     */   }
/*     */   
/*     */   private int compareValues(Value paramValue1, Value paramValue2, int paramInt) {
/* 119 */     if (paramValue1 == paramValue2) {
/* 120 */       return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 126 */     if (paramValue1 == null)
/* 127 */       return -1; 
/* 128 */     if (paramValue2 == null) {
/* 129 */       return 1;
/*     */     }
/* 131 */     boolean bool1 = (paramValue1 == ValueNull.INSTANCE) ? true : false;
/* 132 */     boolean bool2 = (paramValue2 == ValueNull.INSTANCE) ? true : false;
/* 133 */     if (bool1 || bool2) {
/* 134 */       return SortOrder.compareNull(bool1, paramInt);
/*     */     }
/* 136 */     int i = paramValue1.compareTypeSafe(paramValue2, this.compareMode);
/* 137 */     if ((paramInt & 0x1) != 0) {
/* 138 */       i = -i;
/*     */     }
/* 140 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMemory(Object paramObject) {
/* 145 */     if (paramObject instanceof org.h2.mvstore.rtree.SpatialKey) {
/* 146 */       return getSpatialDataType().getMemory(paramObject);
/*     */     }
/* 148 */     return getMemory((Value)paramObject);
/*     */   }
/*     */   
/*     */   private static int getMemory(Value paramValue) {
/* 152 */     return (paramValue == null) ? 0 : paramValue.getMemory();
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(ByteBuffer paramByteBuffer, Object[] paramArrayOfObject, int paramInt, boolean paramBoolean) {
/* 157 */     for (byte b = 0; b < paramInt; b++) {
/* 158 */       paramArrayOfObject[b] = read(paramByteBuffer);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(WriteBuffer paramWriteBuffer, Object[] paramArrayOfObject, int paramInt, boolean paramBoolean) {
/* 164 */     for (byte b = 0; b < paramInt; b++) {
/* 165 */       write(paramWriteBuffer, paramArrayOfObject[b]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Object read(ByteBuffer paramByteBuffer) {
/* 171 */     return readValue(paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(WriteBuffer paramWriteBuffer, Object paramObject) {
/* 176 */     if (paramObject instanceof org.h2.mvstore.rtree.SpatialKey) {
/* 177 */       paramWriteBuffer.put((byte)-124);
/* 178 */       getSpatialDataType().write(paramWriteBuffer, paramObject);
/*     */       return;
/*     */     } 
/* 181 */     Value value = (Value)paramObject;
/* 182 */     writeValue(paramWriteBuffer, value); } private void writeValue(WriteBuffer paramWriteBuffer, Value paramValue) { int j; long l2; BigDecimal bigDecimal; ValueTime valueTime; long l1; ValueTimestamp valueTimestamp; ValueTimestampTimeZone valueTimestampTimeZone; byte[] arrayOfByte2; ValueUuid valueUuid; String str; double d; float f; ValueLobDb valueLobDb; Value[] arrayOfValue; byte[] arrayOfByte1; long l3; int m;
/*     */     byte[] arrayOfByte3;
/*     */     int k;
/*     */     long l4, l5;
/* 186 */     if (paramValue == ValueNull.INSTANCE) {
/* 187 */       paramWriteBuffer.put((byte)0);
/*     */       return;
/*     */     } 
/* 190 */     int i = paramValue.getType();
/* 191 */     switch (i) {
/*     */       case 1:
/* 193 */         paramWriteBuffer.put((byte)(paramValue.getBoolean().booleanValue() ? 65 : 64));
/*     */         return;
/*     */       
/*     */       case 2:
/* 197 */         paramWriteBuffer.put((byte)i).put(paramValue.getByte());
/*     */         return;
/*     */       case 3:
/* 200 */         paramWriteBuffer.put((byte)i).putShort(paramValue.getShort());
/*     */         return;
/*     */       case 4:
/* 203 */         j = paramValue.getInt();
/* 204 */         if (j < 0) {
/* 205 */           paramWriteBuffer.put((byte)66).putVarInt(-j);
/* 206 */         } else if (j < 16) {
/* 207 */           paramWriteBuffer.put((byte)(32 + j));
/*     */         } else {
/* 209 */           paramWriteBuffer.put((byte)i).putVarInt(j);
/*     */         } 
/*     */         return;
/*     */       
/*     */       case 5:
/* 214 */         l2 = paramValue.getLong();
/* 215 */         if (l2 < 0L) {
/* 216 */           paramWriteBuffer.put((byte)67).putVarLong(-l2);
/* 217 */         } else if (l2 < 8L) {
/* 218 */           paramWriteBuffer.put((byte)(int)(48L + l2));
/*     */         } else {
/* 220 */           paramWriteBuffer.put((byte)i).putVarLong(l2);
/*     */         } 
/*     */         return;
/*     */       
/*     */       case 6:
/* 225 */         bigDecimal = paramValue.getBigDecimal();
/* 226 */         if (BigDecimal.ZERO.equals(bigDecimal)) {
/* 227 */           paramWriteBuffer.put((byte)56);
/* 228 */         } else if (BigDecimal.ONE.equals(bigDecimal)) {
/* 229 */           paramWriteBuffer.put((byte)57);
/*     */         } else {
/* 231 */           int n = bigDecimal.scale();
/* 232 */           BigInteger bigInteger = bigDecimal.unscaledValue();
/* 233 */           int i1 = bigInteger.bitLength();
/* 234 */           if (i1 <= 63) {
/* 235 */             if (n == 0) {
/* 236 */               paramWriteBuffer.put((byte)58).putVarLong(bigInteger.longValue());
/*     */             } else {
/*     */               
/* 239 */               paramWriteBuffer.put((byte)59).putVarInt(n).putVarLong(bigInteger.longValue());
/*     */             }
/*     */           
/*     */           } else {
/*     */             
/* 244 */             byte[] arrayOfByte = bigInteger.toByteArray();
/* 245 */             paramWriteBuffer.put((byte)i).putVarInt(n).putVarInt(arrayOfByte.length).put(arrayOfByte);
/*     */           } 
/*     */         } 
/*     */         return;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 9:
/* 254 */         valueTime = (ValueTime)paramValue;
/* 255 */         l3 = valueTime.getNanos();
/* 256 */         l4 = l3 / 1000000L;
/* 257 */         l3 -= l4 * 1000000L;
/* 258 */         paramWriteBuffer.put((byte)i).putVarLong(l4).putVarLong(l3);
/*     */         return;
/*     */ 
/*     */ 
/*     */       
/*     */       case 10:
/* 264 */         l1 = ((ValueDate)paramValue).getDateValue();
/* 265 */         paramWriteBuffer.put((byte)i).putVarLong(l1);
/*     */         return;
/*     */       
/*     */       case 11:
/* 269 */         valueTimestamp = (ValueTimestamp)paramValue;
/* 270 */         l3 = valueTimestamp.getDateValue();
/* 271 */         l4 = valueTimestamp.getTimeNanos();
/* 272 */         l5 = l4 / 1000000L;
/* 273 */         l4 -= l5 * 1000000L;
/* 274 */         paramWriteBuffer.put((byte)i).putVarLong(l3).putVarLong(l5).putVarLong(l4);
/*     */         return;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 24:
/* 281 */         valueTimestampTimeZone = (ValueTimestampTimeZone)paramValue;
/* 282 */         l3 = valueTimestampTimeZone.getDateValue();
/* 283 */         l4 = valueTimestampTimeZone.getTimeNanos();
/* 284 */         l5 = l4 / 1000000L;
/* 285 */         l4 -= l5 * 1000000L;
/* 286 */         paramWriteBuffer.put((byte)i).putVarLong(l3).putVarLong(l5).putVarLong(l4).putVarInt(valueTimestampTimeZone.getTimeZoneOffsetMins());
/*     */         return;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 19:
/* 294 */         arrayOfByte2 = paramValue.getBytesNoCopy();
/* 295 */         paramWriteBuffer.put((byte)i).putVarInt(arrayOfByte2.length).put(arrayOfByte2);
/*     */         return;
/*     */ 
/*     */ 
/*     */       
/*     */       case 12:
/* 301 */         arrayOfByte2 = paramValue.getBytesNoCopy();
/* 302 */         m = arrayOfByte2.length;
/* 303 */         if (m < 32) {
/* 304 */           paramWriteBuffer.put((byte)(100 + m)).put(arrayOfByte2);
/*     */         } else {
/*     */           
/* 307 */           paramWriteBuffer.put((byte)i).putVarInt(arrayOfByte2.length).put(arrayOfByte2);
/*     */         } 
/*     */         return;
/*     */ 
/*     */ 
/*     */       
/*     */       case 20:
/* 314 */         valueUuid = (ValueUuid)paramValue;
/* 315 */         paramWriteBuffer.put((byte)i).putLong(valueUuid.getHigh()).putLong(valueUuid.getLow());
/*     */         return;
/*     */ 
/*     */ 
/*     */       
/*     */       case 13:
/* 321 */         str = paramValue.getString();
/* 322 */         m = str.length();
/* 323 */         if (m < 32) {
/* 324 */           paramWriteBuffer.put((byte)(68 + m)).putStringData(str, m);
/*     */         } else {
/*     */           
/* 327 */           paramWriteBuffer.put((byte)i);
/* 328 */           writeString(paramWriteBuffer, str);
/*     */         } 
/*     */         return;
/*     */       
/*     */       case 14:
/*     */       case 21:
/* 334 */         paramWriteBuffer.put((byte)i);
/* 335 */         writeString(paramWriteBuffer, paramValue.getString());
/*     */         return;
/*     */       case 7:
/* 338 */         d = paramValue.getDouble();
/* 339 */         if (d == 1.0D) {
/* 340 */           paramWriteBuffer.put((byte)61);
/*     */         } else {
/* 342 */           long l = Double.doubleToLongBits(d);
/* 343 */           if (l == ValueDouble.ZERO_BITS) {
/* 344 */             paramWriteBuffer.put((byte)60);
/*     */           } else {
/* 346 */             paramWriteBuffer.put((byte)i).putVarLong(Long.reverse(l));
/*     */           } 
/*     */         } 
/*     */         return;
/*     */ 
/*     */       
/*     */       case 8:
/* 353 */         f = paramValue.getFloat();
/* 354 */         if (f == 1.0F) {
/* 355 */           paramWriteBuffer.put((byte)63);
/*     */         } else {
/* 357 */           m = Float.floatToIntBits(f);
/* 358 */           if (m == ValueFloat.ZERO_BITS) {
/* 359 */             paramWriteBuffer.put((byte)62);
/*     */           } else {
/* 361 */             paramWriteBuffer.put((byte)i).putVarInt(Integer.reverse(m));
/*     */           } 
/*     */         } 
/*     */         return;
/*     */ 
/*     */       
/*     */       case 15:
/*     */       case 16:
/* 369 */         paramWriteBuffer.put((byte)i);
/* 370 */         valueLobDb = (ValueLobDb)paramValue;
/* 371 */         arrayOfByte3 = valueLobDb.getSmall();
/* 372 */         if (arrayOfByte3 == null) {
/* 373 */           paramWriteBuffer.putVarInt(-3).putVarInt(valueLobDb.getTableId()).putVarLong(valueLobDb.getLobId()).putVarLong(valueLobDb.getPrecision());
/*     */         
/*     */         }
/*     */         else {
/*     */           
/* 378 */           paramWriteBuffer.putVarInt(arrayOfByte3.length).put(arrayOfByte3);
/*     */         } 
/*     */         return;
/*     */ 
/*     */       
/*     */       case 17:
/* 384 */         arrayOfValue = ((ValueArray)paramValue).getList();
/* 385 */         paramWriteBuffer.put((byte)i).putVarInt(arrayOfValue.length);
/* 386 */         for (Value value : arrayOfValue) {
/* 387 */           writeValue(paramWriteBuffer, value);
/*     */         }
/*     */         return;
/*     */       
/*     */       case 18:
/* 392 */         paramWriteBuffer.put((byte)i);
/*     */         try {
/* 394 */           ResultSet resultSet = ((ValueResultSet)paramValue).getResultSet();
/* 395 */           resultSet.beforeFirst();
/* 396 */           ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
/* 397 */           int n = resultSetMetaData.getColumnCount();
/* 398 */           paramWriteBuffer.putVarInt(n); byte b;
/* 399 */           for (b = 0; b < n; b++) {
/* 400 */             writeString(paramWriteBuffer, resultSetMetaData.getColumnName(b + 1));
/* 401 */             paramWriteBuffer.putVarInt(resultSetMetaData.getColumnType(b + 1)).putVarInt(resultSetMetaData.getPrecision(b + 1)).putVarInt(resultSetMetaData.getScale(b + 1));
/*     */           } 
/*     */ 
/*     */           
/* 405 */           while (resultSet.next()) {
/* 406 */             paramWriteBuffer.put((byte)1);
/* 407 */             for (b = 0; b < n; b++) {
/* 408 */               int i1 = DataType.getValueTypeFromResultSet(resultSetMetaData, b + 1);
/*     */               
/* 410 */               Value value = DataType.readValue(null, resultSet, b + 1, i1);
/*     */               
/* 412 */               writeValue(paramWriteBuffer, value);
/*     */             } 
/*     */           } 
/* 415 */           paramWriteBuffer.put((byte)0);
/* 416 */           resultSet.beforeFirst();
/* 417 */         } catch (SQLException sQLException) {
/* 418 */           throw DbException.convert(sQLException);
/*     */         } 
/*     */         return;
/*     */       
/*     */       case 22:
/* 423 */         arrayOfByte1 = paramValue.getBytes();
/* 424 */         k = arrayOfByte1.length;
/* 425 */         paramWriteBuffer.put((byte)i).putVarInt(k).put(arrayOfByte1);
/*     */         return;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 431 */     DbException.throwInternalError("type=" + paramValue.getType()); }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void writeString(WriteBuffer paramWriteBuffer, String paramString) {
/* 436 */     int i = paramString.length();
/* 437 */     paramWriteBuffer.putVarInt(i).putStringData(paramString, i); } private Object readValue(ByteBuffer paramByteBuffer) { int m; long l1; int k; SimpleResultSet simpleResultSet; int j, i1;
/*     */     byte[] arrayOfByte2;
/*     */     Value[] arrayOfValue;
/*     */     int n;
/*     */     byte[] arrayOfByte1, arrayOfByte3;
/*     */     long l2;
/*     */     byte b;
/*     */     BigInteger bigInteger;
/*     */     short s;
/* 446 */     int i = paramByteBuffer.get() & 0xFF;
/* 447 */     switch (i) {
/*     */       case 0:
/* 449 */         return ValueNull.INSTANCE;
/*     */       case 65:
/* 451 */         return ValueBoolean.get(true);
/*     */       case 64:
/* 453 */         return ValueBoolean.get(false);
/*     */       case 66:
/* 455 */         return ValueInt.get(-readVarInt(paramByteBuffer));
/*     */       case 4:
/* 457 */         return ValueInt.get(readVarInt(paramByteBuffer));
/*     */       case 67:
/* 459 */         return ValueLong.get(-readVarLong(paramByteBuffer));
/*     */       case 5:
/* 461 */         return ValueLong.get(readVarLong(paramByteBuffer));
/*     */       case 2:
/* 463 */         return ValueByte.get(paramByteBuffer.get());
/*     */       case 3:
/* 465 */         return ValueShort.get(paramByteBuffer.getShort());
/*     */       case 56:
/* 467 */         return ValueDecimal.ZERO;
/*     */       case 57:
/* 469 */         return ValueDecimal.ONE;
/*     */       case 58:
/* 471 */         return ValueDecimal.get(BigDecimal.valueOf(readVarLong(paramByteBuffer)));
/*     */       
/*     */       case 59:
/* 474 */         m = readVarInt(paramByteBuffer);
/* 475 */         return ValueDecimal.get(BigDecimal.valueOf(readVarLong(paramByteBuffer), m));
/*     */ 
/*     */       
/*     */       case 6:
/* 479 */         m = readVarInt(paramByteBuffer);
/* 480 */         i1 = readVarInt(paramByteBuffer);
/* 481 */         arrayOfByte3 = DataUtils.newBytes(i1);
/* 482 */         paramByteBuffer.get(arrayOfByte3, 0, i1);
/* 483 */         bigInteger = new BigInteger(arrayOfByte3);
/* 484 */         return ValueDecimal.get(new BigDecimal(bigInteger, m));
/*     */       
/*     */       case 10:
/* 487 */         return ValueDate.fromDateValue(readVarLong(paramByteBuffer));
/*     */       
/*     */       case 9:
/* 490 */         l1 = readVarLong(paramByteBuffer) * 1000000L + readVarLong(paramByteBuffer);
/* 491 */         return ValueTime.fromNanos(l1);
/*     */       
/*     */       case 11:
/* 494 */         l1 = readVarLong(paramByteBuffer);
/* 495 */         l2 = readVarLong(paramByteBuffer) * 1000000L + readVarLong(paramByteBuffer);
/* 496 */         return ValueTimestamp.fromDateValueAndNanos(l1, l2);
/*     */       
/*     */       case 24:
/* 499 */         l1 = readVarLong(paramByteBuffer);
/* 500 */         l2 = readVarLong(paramByteBuffer) * 1000000L + readVarLong(paramByteBuffer);
/* 501 */         s = (short)readVarInt(paramByteBuffer);
/* 502 */         return ValueTimestampTimeZone.fromDateValueAndNanos(l1, l2, s);
/*     */       
/*     */       case 12:
/* 505 */         k = readVarInt(paramByteBuffer);
/* 506 */         arrayOfByte2 = DataUtils.newBytes(k);
/* 507 */         paramByteBuffer.get(arrayOfByte2, 0, k);
/* 508 */         return ValueBytes.getNoCopy(arrayOfByte2);
/*     */       
/*     */       case 19:
/* 511 */         k = readVarInt(paramByteBuffer);
/* 512 */         arrayOfByte2 = DataUtils.newBytes(k);
/* 513 */         paramByteBuffer.get(arrayOfByte2, 0, k);
/* 514 */         return ValueJavaObject.getNoCopy(null, arrayOfByte2, this.handler);
/*     */       
/*     */       case 20:
/* 517 */         return ValueUuid.get(paramByteBuffer.getLong(), paramByteBuffer.getLong());
/*     */       case 13:
/* 519 */         return ValueString.get(readString(paramByteBuffer));
/*     */       case 14:
/* 521 */         return ValueStringIgnoreCase.get(readString(paramByteBuffer));
/*     */       case 21:
/* 523 */         return ValueStringFixed.get(readString(paramByteBuffer));
/*     */       case 62:
/* 525 */         return ValueFloat.get(0.0F);
/*     */       case 63:
/* 527 */         return ValueFloat.get(1.0F);
/*     */       case 60:
/* 529 */         return ValueDouble.get(0.0D);
/*     */       case 61:
/* 531 */         return ValueDouble.get(1.0D);
/*     */       case 7:
/* 533 */         return ValueDouble.get(Double.longBitsToDouble(Long.reverse(readVarLong(paramByteBuffer))));
/*     */       
/*     */       case 8:
/* 536 */         return ValueFloat.get(Float.intBitsToFloat(Integer.reverse(readVarInt(paramByteBuffer))));
/*     */       
/*     */       case 15:
/*     */       case 16:
/* 540 */         k = readVarInt(paramByteBuffer);
/* 541 */         if (k >= 0) {
/* 542 */           arrayOfByte2 = DataUtils.newBytes(k);
/* 543 */           paramByteBuffer.get(arrayOfByte2, 0, k);
/* 544 */           return ValueLobDb.createSmallLob(i, arrayOfByte2);
/* 545 */         }  if (k == -3) {
/* 546 */           int i2 = readVarInt(paramByteBuffer);
/* 547 */           l2 = readVarLong(paramByteBuffer);
/* 548 */           long l = readVarLong(paramByteBuffer);
/* 549 */           return ValueLobDb.create(i, this.handler, i2, l2, null, l);
/*     */         } 
/*     */ 
/*     */         
/* 553 */         throw DbException.get(90030, "lob type: " + k);
/*     */ 
/*     */ 
/*     */       
/*     */       case 17:
/* 558 */         k = readVarInt(paramByteBuffer);
/* 559 */         arrayOfValue = new Value[k];
/* 560 */         for (b = 0; b < k; b++) {
/* 561 */           arrayOfValue[b] = (Value)readValue(paramByteBuffer);
/*     */         }
/* 563 */         return ValueArray.get(arrayOfValue);
/*     */       
/*     */       case 18:
/* 566 */         simpleResultSet = new SimpleResultSet();
/* 567 */         simpleResultSet.setAutoClose(false);
/* 568 */         n = readVarInt(paramByteBuffer);
/* 569 */         for (b = 0; b < n; b++) {
/* 570 */           simpleResultSet.addColumn(readString(paramByteBuffer), readVarInt(paramByteBuffer), readVarInt(paramByteBuffer), readVarInt(paramByteBuffer));
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 576 */         while (paramByteBuffer.get() != 0) {
/*     */ 
/*     */           
/* 579 */           Object[] arrayOfObject = new Object[n];
/* 580 */           for (byte b1 = 0; b1 < n; b1++) {
/* 581 */             arrayOfObject[b1] = ((Value)readValue(paramByteBuffer)).getObject();
/*     */           }
/* 583 */           simpleResultSet.addRow(arrayOfObject);
/*     */         } 
/* 585 */         return ValueResultSet.get((ResultSet)simpleResultSet);
/*     */       
/*     */       case 22:
/* 588 */         j = readVarInt(paramByteBuffer);
/* 589 */         arrayOfByte1 = DataUtils.newBytes(j);
/* 590 */         paramByteBuffer.get(arrayOfByte1, 0, j);
/* 591 */         return ValueGeometry.get(arrayOfByte1);
/*     */       
/*     */       case 132:
/* 594 */         return getSpatialDataType().read(paramByteBuffer);
/*     */     } 
/* 596 */     if (i >= 32 && i < 48)
/* 597 */       return ValueInt.get(i - 32); 
/* 598 */     if (i >= 48 && i < 56)
/* 599 */       return ValueLong.get((i - 48)); 
/* 600 */     if (i >= 100 && i < 132) {
/* 601 */       j = i - 100;
/* 602 */       arrayOfByte1 = DataUtils.newBytes(j);
/* 603 */       paramByteBuffer.get(arrayOfByte1, 0, j);
/* 604 */       return ValueBytes.getNoCopy(arrayOfByte1);
/* 605 */     }  if (i >= 68 && i < 100) {
/* 606 */       return ValueString.get(readString(paramByteBuffer, i - 68));
/*     */     }
/* 608 */     throw DbException.get(90030, "type: " + i); }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int readVarInt(ByteBuffer paramByteBuffer) {
/* 613 */     return DataUtils.readVarInt(paramByteBuffer);
/*     */   }
/*     */   
/*     */   private static long readVarLong(ByteBuffer paramByteBuffer) {
/* 617 */     return DataUtils.readVarLong(paramByteBuffer);
/*     */   }
/*     */   
/*     */   private static String readString(ByteBuffer paramByteBuffer, int paramInt) {
/* 621 */     return DataUtils.readString(paramByteBuffer, paramInt);
/*     */   }
/*     */   
/*     */   private static String readString(ByteBuffer paramByteBuffer) {
/* 625 */     int i = readVarInt(paramByteBuffer);
/* 626 */     return DataUtils.readString(paramByteBuffer, i);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 631 */     return this.compareMode.hashCode() ^ Arrays.hashCode(this.sortTypes);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 636 */     if (paramObject == this)
/* 637 */       return true; 
/* 638 */     if (!(paramObject instanceof ValueDataType)) {
/* 639 */       return false;
/*     */     }
/* 641 */     ValueDataType valueDataType = (ValueDataType)paramObject;
/* 642 */     if (!this.compareMode.equals(valueDataType.compareMode)) {
/* 643 */       return false;
/*     */     }
/* 645 */     return Arrays.equals(this.sortTypes, valueDataType.sortTypes);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\db\ValueDataType.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */