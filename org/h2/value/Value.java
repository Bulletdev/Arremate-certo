/*      */ package org.h2.value;
/*      */ 
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.InputStream;
/*      */ import java.io.Reader;
/*      */ import java.io.StringReader;
/*      */ import java.lang.ref.SoftReference;
/*      */ import java.math.BigDecimal;
/*      */ import java.sql.Date;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.sql.Time;
/*      */ import java.sql.Timestamp;
/*      */ import java.util.UUID;
/*      */ import org.h2.engine.Constants;
/*      */ import org.h2.engine.SysProperties;
/*      */ import org.h2.message.DbException;
/*      */ import org.h2.store.DataHandler;
/*      */ import org.h2.tools.SimpleResultSet;
/*      */ import org.h2.util.DateTimeUtils;
/*      */ import org.h2.util.JdbcUtils;
/*      */ import org.h2.util.MathUtils;
/*      */ import org.h2.util.StringUtils;
/*      */ import org.h2.util.Utils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class Value
/*      */ {
/*      */   public static final int UNKNOWN = -1;
/*      */   public static final int NULL = 0;
/*      */   public static final int BOOLEAN = 1;
/*      */   public static final int BYTE = 2;
/*      */   public static final int SHORT = 3;
/*      */   public static final int INT = 4;
/*      */   public static final int LONG = 5;
/*      */   public static final int DECIMAL = 6;
/*      */   public static final int DOUBLE = 7;
/*      */   public static final int FLOAT = 8;
/*      */   public static final int TIME = 9;
/*      */   public static final int DATE = 10;
/*      */   public static final int TIMESTAMP = 11;
/*      */   public static final int BYTES = 12;
/*      */   public static final int STRING = 13;
/*      */   public static final int STRING_IGNORECASE = 14;
/*      */   public static final int BLOB = 15;
/*      */   public static final int CLOB = 16;
/*      */   public static final int ARRAY = 17;
/*      */   public static final int RESULT_SET = 18;
/*      */   public static final int JAVA_OBJECT = 19;
/*      */   public static final int UUID = 20;
/*      */   public static final int STRING_FIXED = 21;
/*      */   public static final int GEOMETRY = 22;
/*      */   public static final int TIMESTAMP_TZ = 24;
/*      */   public static final int TYPE_COUNT = 24;
/*  174 */   private static SoftReference<Value[]> softCache = (SoftReference)new SoftReference<>(null);
/*      */   
/*  176 */   private static final BigDecimal MAX_LONG_DECIMAL = BigDecimal.valueOf(Long.MAX_VALUE);
/*      */   
/*  178 */   private static final BigDecimal MIN_LONG_DECIMAL = BigDecimal.valueOf(Long.MIN_VALUE);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract String getSQL();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract int getType();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract long getPrecision();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract int getDisplaySize();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMemory() {
/*  215 */     return (DataType.getDataType(getType())).memory;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract String getString();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract Object getObject();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract void set(PreparedStatement paramPreparedStatement, int paramInt) throws SQLException;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected abstract int compareSecure(Value paramValue, CompareMode paramCompareMode);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract int hashCode();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract boolean equals(Object paramObject);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static int getOrder(int paramInt) {
/*  273 */     switch (paramInt) {
/*      */       case -1:
/*  275 */         return 1;
/*      */       case 0:
/*  277 */         return 2;
/*      */       case 13:
/*  279 */         return 10;
/*      */       case 16:
/*  281 */         return 11;
/*      */       case 21:
/*  283 */         return 12;
/*      */       case 14:
/*  285 */         return 13;
/*      */       case 1:
/*  287 */         return 20;
/*      */       case 2:
/*  289 */         return 21;
/*      */       case 3:
/*  291 */         return 22;
/*      */       case 4:
/*  293 */         return 23;
/*      */       case 5:
/*  295 */         return 24;
/*      */       case 6:
/*  297 */         return 25;
/*      */       case 8:
/*  299 */         return 26;
/*      */       case 7:
/*  301 */         return 27;
/*      */       case 9:
/*  303 */         return 30;
/*      */       case 10:
/*  305 */         return 31;
/*      */       case 11:
/*  307 */         return 32;
/*      */       case 24:
/*  309 */         return 34;
/*      */       case 12:
/*  311 */         return 40;
/*      */       case 15:
/*  313 */         return 41;
/*      */       case 19:
/*  315 */         return 42;
/*      */       case 20:
/*  317 */         return 43;
/*      */       case 22:
/*  319 */         return 44;
/*      */       case 17:
/*  321 */         return 50;
/*      */       case 18:
/*  323 */         return 51;
/*      */     } 
/*  325 */     throw DbException.throwInternalError("type:" + paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getHigherOrder(int paramInt1, int paramInt2) {
/*  339 */     if (paramInt1 == -1 || paramInt2 == -1) {
/*  340 */       if (paramInt1 == paramInt2) {
/*  341 */         throw DbException.get(50004, "?, ?");
/*      */       }
/*  343 */       if (paramInt1 == 0) {
/*  344 */         throw DbException.get(50004, "NULL, ?");
/*      */       }
/*  346 */       if (paramInt2 == 0) {
/*  347 */         throw DbException.get(50004, "?, NULL");
/*      */       }
/*      */     } 
/*      */     
/*  351 */     if (paramInt1 == paramInt2) {
/*  352 */       return paramInt1;
/*      */     }
/*  354 */     int i = getOrder(paramInt1);
/*  355 */     int j = getOrder(paramInt2);
/*  356 */     return (i > j) ? paramInt1 : paramInt2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static Value cache(Value paramValue) {
/*  368 */     if (SysProperties.OBJECT_CACHE) {
/*  369 */       int i = paramValue.hashCode();
/*  370 */       if (softCache == null) {
/*  371 */         softCache = (SoftReference)new SoftReference<>(null);
/*      */       }
/*  373 */       Value[] arrayOfValue = softCache.get();
/*  374 */       if (arrayOfValue == null) {
/*  375 */         arrayOfValue = new Value[SysProperties.OBJECT_CACHE_SIZE];
/*  376 */         softCache = (SoftReference)new SoftReference<>(arrayOfValue);
/*      */       } 
/*  378 */       int j = i & SysProperties.OBJECT_CACHE_SIZE - 1;
/*  379 */       Value value = arrayOfValue[j];
/*  380 */       if (value != null && 
/*  381 */         value.getType() == paramValue.getType() && paramValue.equals(value))
/*      */       {
/*  383 */         return value;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  390 */       arrayOfValue[j] = paramValue;
/*      */     } 
/*  392 */     return paramValue;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void clearCache() {
/*  399 */     softCache = null;
/*      */   }
/*      */   
/*      */   public Boolean getBoolean() {
/*  403 */     return ((ValueBoolean)convertTo(1)).getBoolean();
/*      */   }
/*      */   
/*      */   public Date getDate() {
/*  407 */     return ((ValueDate)convertTo(10)).getDate();
/*      */   }
/*      */   
/*      */   public Time getTime() {
/*  411 */     return ((ValueTime)convertTo(9)).getTime();
/*      */   }
/*      */   
/*      */   public Timestamp getTimestamp() {
/*  415 */     return ((ValueTimestamp)convertTo(11)).getTimestamp();
/*      */   }
/*      */   
/*      */   public byte[] getBytes() {
/*  419 */     return ((ValueBytes)convertTo(12)).getBytes();
/*      */   }
/*      */   
/*      */   public byte[] getBytesNoCopy() {
/*  423 */     return ((ValueBytes)convertTo(12)).getBytesNoCopy();
/*      */   }
/*      */   
/*      */   public byte getByte() {
/*  427 */     return ((ValueByte)convertTo(2)).getByte();
/*      */   }
/*      */   
/*      */   public short getShort() {
/*  431 */     return ((ValueShort)convertTo(3)).getShort();
/*      */   }
/*      */   
/*      */   public BigDecimal getBigDecimal() {
/*  435 */     return ((ValueDecimal)convertTo(6)).getBigDecimal();
/*      */   }
/*      */   
/*      */   public double getDouble() {
/*  439 */     return ((ValueDouble)convertTo(7)).getDouble();
/*      */   }
/*      */   
/*      */   public float getFloat() {
/*  443 */     return ((ValueFloat)convertTo(8)).getFloat();
/*      */   }
/*      */   
/*      */   public int getInt() {
/*  447 */     return ((ValueInt)convertTo(4)).getInt();
/*      */   }
/*      */   
/*      */   public long getLong() {
/*  451 */     return ((ValueLong)convertTo(5)).getLong();
/*      */   }
/*      */   
/*      */   public InputStream getInputStream() {
/*  455 */     return new ByteArrayInputStream(getBytesNoCopy());
/*      */   }
/*      */   
/*      */   public Reader getReader() {
/*  459 */     return new StringReader(getString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Value add(Value paramValue) {
/*  469 */     throw throwUnsupportedExceptionForType("+");
/*      */   }
/*      */   
/*      */   public int getSignum() {
/*  473 */     throw throwUnsupportedExceptionForType("SIGNUM");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Value negate() {
/*  482 */     throw throwUnsupportedExceptionForType("NEG");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Value subtract(Value paramValue) {
/*  492 */     throw throwUnsupportedExceptionForType("-");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Value divide(Value paramValue) {
/*  502 */     throw throwUnsupportedExceptionForType("/");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Value multiply(Value paramValue) {
/*  512 */     throw throwUnsupportedExceptionForType("*");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Value modulus(Value paramValue) {
/*  522 */     throw throwUnsupportedExceptionForType("%");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Value convertTo(int paramInt) {
/*  534 */     if (getType() == paramInt)
/*  535 */       return this;  try {
/*      */       byte[] arrayOfByte; double d; float f; short s; int i;
/*      */       long l;
/*      */       SimpleResultSet simpleResultSet;
/*  539 */       switch (paramInt) {
/*      */         case 1:
/*  541 */           switch (getType()) {
/*      */             case 2:
/*      */             case 3:
/*      */             case 4:
/*      */             case 5:
/*      */             case 6:
/*      */             case 7:
/*      */             case 8:
/*  549 */               return ValueBoolean.get((getSignum() != 0));
/*      */             case 9:
/*      */             case 10:
/*      */             case 11:
/*      */             case 12:
/*      */             case 19:
/*      */             case 20:
/*      */             case 24:
/*  557 */               throw DbException.get(22018, getString());
/*      */           } 
/*      */           
/*      */           break;
/*      */         
/*      */         case 2:
/*  563 */           switch (getType()) {
/*      */             case 1:
/*  565 */               return ValueByte.get(getBoolean().booleanValue() ? 1 : 0);
/*      */             case 3:
/*  567 */               return ValueByte.get(convertToByte(getShort()));
/*      */             case 4:
/*  569 */               return ValueByte.get(convertToByte(getInt()));
/*      */             case 5:
/*  571 */               return ValueByte.get(convertToByte(getLong()));
/*      */             case 6:
/*  573 */               return ValueByte.get(convertToByte(convertToLong(getBigDecimal())));
/*      */             case 7:
/*  575 */               return ValueByte.get(convertToByte(convertToLong(getDouble())));
/*      */             case 8:
/*  577 */               return ValueByte.get(convertToByte(convertToLong(getFloat())));
/*      */             case 12:
/*  579 */               return ValueByte.get((byte)Integer.parseInt(getString(), 16));
/*      */             case 24:
/*  581 */               throw DbException.get(22018, getString());
/*      */           } 
/*      */           
/*      */           break;
/*      */         
/*      */         case 3:
/*  587 */           switch (getType()) {
/*      */             case 1:
/*  589 */               return ValueShort.get(getBoolean().booleanValue() ? 1 : 0);
/*      */             case 2:
/*  591 */               return ValueShort.get((short)getByte());
/*      */             case 4:
/*  593 */               return ValueShort.get(convertToShort(getInt()));
/*      */             case 5:
/*  595 */               return ValueShort.get(convertToShort(getLong()));
/*      */             case 6:
/*  597 */               return ValueShort.get(convertToShort(convertToLong(getBigDecimal())));
/*      */             case 7:
/*  599 */               return ValueShort.get(convertToShort(convertToLong(getDouble())));
/*      */             case 8:
/*  601 */               return ValueShort.get(convertToShort(convertToLong(getFloat())));
/*      */             case 12:
/*  603 */               return ValueShort.get((short)Integer.parseInt(getString(), 16));
/*      */             case 24:
/*  605 */               throw DbException.get(22018, getString());
/*      */           } 
/*      */           
/*      */           break;
/*      */         
/*      */         case 4:
/*  611 */           switch (getType()) {
/*      */             case 1:
/*  613 */               return ValueInt.get(getBoolean().booleanValue() ? 1 : 0);
/*      */             case 2:
/*  615 */               return ValueInt.get(getByte());
/*      */             case 3:
/*  617 */               return ValueInt.get(getShort());
/*      */             case 5:
/*  619 */               return ValueInt.get(convertToInt(getLong()));
/*      */             case 6:
/*  621 */               return ValueInt.get(convertToInt(convertToLong(getBigDecimal())));
/*      */             case 7:
/*  623 */               return ValueInt.get(convertToInt(convertToLong(getDouble())));
/*      */             case 8:
/*  625 */               return ValueInt.get(convertToInt(convertToLong(getFloat())));
/*      */             case 12:
/*  627 */               return ValueInt.get((int)Long.parseLong(getString(), 16));
/*      */             case 24:
/*  629 */               throw DbException.get(22018, getString());
/*      */           } 
/*      */           
/*      */           break;
/*      */         
/*      */         case 5:
/*  635 */           switch (getType()) {
/*      */             case 1:
/*  637 */               return ValueLong.get(getBoolean().booleanValue() ? 1L : 0L);
/*      */             case 2:
/*  639 */               return ValueLong.get(getByte());
/*      */             case 3:
/*  641 */               return ValueLong.get(getShort());
/*      */             case 4:
/*  643 */               return ValueLong.get(getInt());
/*      */             case 6:
/*  645 */               return ValueLong.get(convertToLong(getBigDecimal()));
/*      */             case 7:
/*  647 */               return ValueLong.get(convertToLong(getDouble()));
/*      */             case 8:
/*  649 */               return ValueLong.get(convertToLong(getFloat()));
/*      */             
/*      */             case 12:
/*  652 */               arrayOfByte = getBytes();
/*  653 */               if (arrayOfByte.length == 8) {
/*  654 */                 return ValueLong.get(Utils.readLong(arrayOfByte, 0));
/*      */               }
/*  656 */               return ValueLong.get(Long.parseLong(getString(), 16));
/*      */             
/*      */             case 24:
/*  659 */               throw DbException.get(22018, getString());
/*      */           } 
/*      */           
/*      */           break;
/*      */         
/*      */         case 6:
/*  665 */           switch (getType()) {
/*      */             case 1:
/*  667 */               return ValueDecimal.get(BigDecimal.valueOf(getBoolean().booleanValue() ? 1L : 0L));
/*      */             
/*      */             case 2:
/*  670 */               return ValueDecimal.get(BigDecimal.valueOf(getByte()));
/*      */             case 3:
/*  672 */               return ValueDecimal.get(BigDecimal.valueOf(getShort()));
/*      */             case 4:
/*  674 */               return ValueDecimal.get(BigDecimal.valueOf(getInt()));
/*      */             case 5:
/*  676 */               return ValueDecimal.get(BigDecimal.valueOf(getLong()));
/*      */             case 7:
/*  678 */               d = getDouble();
/*  679 */               if (Double.isInfinite(d) || Double.isNaN(d)) {
/*  680 */                 throw DbException.get(22018, "" + d);
/*      */               }
/*      */               
/*  683 */               return ValueDecimal.get(BigDecimal.valueOf(d));
/*      */             
/*      */             case 8:
/*  686 */               f = getFloat();
/*  687 */               if (Float.isInfinite(f) || Float.isNaN(f)) {
/*  688 */                 throw DbException.get(22018, "" + f);
/*      */               }
/*      */ 
/*      */               
/*  692 */               return ValueDecimal.get(new BigDecimal(Float.toString(f)));
/*      */             
/*      */             case 24:
/*  695 */               throw DbException.get(22018, getString());
/*      */           } 
/*      */           
/*      */           break;
/*      */         
/*      */         case 7:
/*  701 */           switch (getType()) {
/*      */             case 1:
/*  703 */               return ValueDouble.get(getBoolean().booleanValue() ? 1.0D : 0.0D);
/*      */             case 2:
/*  705 */               return ValueDouble.get(getByte());
/*      */             case 3:
/*  707 */               return ValueDouble.get(getShort());
/*      */             case 4:
/*  709 */               return ValueDouble.get(getInt());
/*      */             case 5:
/*  711 */               return ValueDouble.get(getLong());
/*      */             case 6:
/*  713 */               return ValueDouble.get(getBigDecimal().doubleValue());
/*      */             case 8:
/*  715 */               return ValueDouble.get(getFloat());
/*      */             case 24:
/*  717 */               throw DbException.get(22018, getString());
/*      */           } 
/*      */           
/*      */           break;
/*      */         
/*      */         case 8:
/*  723 */           switch (getType()) {
/*      */             case 1:
/*  725 */               return ValueFloat.get(getBoolean().booleanValue() ? 1.0F : 0.0F);
/*      */             case 2:
/*  727 */               return ValueFloat.get(getByte());
/*      */             case 3:
/*  729 */               return ValueFloat.get(getShort());
/*      */             case 4:
/*  731 */               return ValueFloat.get(getInt());
/*      */             case 5:
/*  733 */               return ValueFloat.get((float)getLong());
/*      */             case 6:
/*  735 */               return ValueFloat.get(getBigDecimal().floatValue());
/*      */             case 7:
/*  737 */               return ValueFloat.get((float)getDouble());
/*      */             case 24:
/*  739 */               throw DbException.get(22018, getString());
/*      */           } 
/*      */           
/*      */           break;
/*      */         
/*      */         case 10:
/*  745 */           switch (getType()) {
/*      */ 
/*      */             
/*      */             case 9:
/*  749 */               return ValueDate.fromDateValue(DateTimeUtils.dateValue(1970L, 1, 1));
/*      */             
/*      */             case 11:
/*  752 */               return ValueDate.fromDateValue(((ValueTimestamp)this).getDateValue());
/*      */             
/*      */             case 24:
/*  755 */               return ValueDate.fromDateValue(((ValueTimestampTimeZone)this).getDateValue());
/*      */           } 
/*      */           
/*      */           break;
/*      */         
/*      */         case 9:
/*  761 */           switch (getType()) {
/*      */ 
/*      */             
/*      */             case 10:
/*  765 */               return ValueTime.fromNanos(0L);
/*      */             case 11:
/*  767 */               return ValueTime.fromNanos(((ValueTimestamp)this).getTimeNanos());
/*      */             
/*      */             case 24:
/*  770 */               return ValueTime.fromNanos(((ValueTimestampTimeZone)this).getTimeNanos());
/*      */           } 
/*      */           
/*      */           break;
/*      */         
/*      */         case 11:
/*  776 */           switch (getType()) {
/*      */             case 9:
/*  778 */               return DateTimeUtils.normalizeTimestamp(0L, ((ValueTime)this).getNanos());
/*      */             
/*      */             case 10:
/*  781 */               return ValueTimestamp.fromDateValueAndNanos(((ValueDate)this).getDateValue(), 0L);
/*      */             
/*      */             case 24:
/*  784 */               return ValueTimestamp.fromDateValueAndNanos(((ValueTimestampTimeZone)this).getDateValue(), ((ValueTimestampTimeZone)this).getTimeNanos());
/*      */           } 
/*      */ 
/*      */           
/*      */           break;
/*      */         
/*      */         case 12:
/*  791 */           switch (getType()) {
/*      */             case 15:
/*      */             case 19:
/*  794 */               return ValueBytes.getNoCopy(getBytesNoCopy());
/*      */             case 20:
/*      */             case 22:
/*  797 */               return ValueBytes.getNoCopy(getBytes());
/*      */             case 2:
/*  799 */               return ValueBytes.getNoCopy(new byte[] { getByte() });
/*      */             case 3:
/*  801 */               s = getShort();
/*  802 */               return ValueBytes.getNoCopy(new byte[] { (byte)(s >> 8), (byte)s });
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             case 4:
/*  808 */               i = getInt();
/*  809 */               return ValueBytes.getNoCopy(new byte[] { (byte)(i >> 24), (byte)(i >> 16), (byte)(i >> 8), (byte)i });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             case 5:
/*  817 */               l = getLong();
/*  818 */               return ValueBytes.getNoCopy(new byte[] { (byte)(int)(l >> 56L), (byte)(int)(l >> 48L), (byte)(int)(l >> 40L), (byte)(int)(l >> 32L), (byte)(int)(l >> 24L), (byte)(int)(l >> 16L), (byte)(int)(l >> 8L), (byte)(int)l });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             case 24:
/*  830 */               throw DbException.get(22018, getString());
/*      */           } 
/*      */           
/*      */           break;
/*      */         
/*      */         case 19:
/*  836 */           switch (getType()) {
/*      */             case 12:
/*      */             case 15:
/*  839 */               return ValueJavaObject.getNoCopy(null, getBytesNoCopy(), getDataHandler());
/*      */             
/*      */             case 24:
/*  842 */               throw DbException.get(22018, getString());
/*      */           } 
/*      */           
/*      */           break;
/*      */         
/*      */         case 15:
/*  848 */           switch (getType()) {
/*      */             case 12:
/*  850 */               return ValueLobDb.createSmallLob(15, getBytesNoCopy());
/*      */             
/*      */             case 24:
/*  853 */               throw DbException.get(22018, getString());
/*      */           } 
/*      */           
/*      */           break;
/*      */         
/*      */         case 20:
/*  859 */           switch (getType()) {
/*      */             case 12:
/*  861 */               return ValueUuid.get(getBytesNoCopy());
/*      */             case 19:
/*  863 */               object = JdbcUtils.deserialize(getBytesNoCopy(), getDataHandler());
/*      */               
/*  865 */               if (object instanceof UUID) {
/*  866 */                 UUID uUID = (UUID)object;
/*  867 */                 return ValueUuid.get(uUID.getMostSignificantBits(), uUID.getLeastSignificantBits());
/*      */               } 
/*      */               
/*  870 */               throw DbException.get(22018, getString());
/*      */             
/*      */             case 24:
/*  873 */               throw DbException.get(22018, getString());
/*      */           } 
/*      */           
/*      */           break;
/*      */         
/*      */         case 22:
/*  879 */           switch (getType()) {
/*      */             case 12:
/*  881 */               return ValueGeometry.get(getBytesNoCopy());
/*      */             case 19:
/*  883 */               object = JdbcUtils.deserialize(getBytesNoCopy(), getDataHandler());
/*  884 */               if (DataType.isGeometry(object)) {
/*  885 */                 return ValueGeometry.getFromGeometry(object);
/*      */               }
/*      */             case 24:
/*  888 */               throw DbException.get(22018, getString());
/*      */           } 
/*      */ 
/*      */           
/*      */           break;
/*      */       } 
/*      */       
/*  895 */       Object object = getString();
/*  896 */       switch (paramInt) {
/*      */         case 0:
/*  898 */           return ValueNull.INSTANCE;
/*      */         case 1:
/*  900 */           if (object.equalsIgnoreCase("true") || object.equalsIgnoreCase("t") || object.equalsIgnoreCase("yes") || object.equalsIgnoreCase("y"))
/*      */           {
/*      */ 
/*      */             
/*  904 */             return ValueBoolean.get(true); } 
/*  905 */           if (object.equalsIgnoreCase("false") || object.equalsIgnoreCase("f") || object.equalsIgnoreCase("no") || object.equalsIgnoreCase("n"))
/*      */           {
/*      */ 
/*      */             
/*  909 */             return ValueBoolean.get(false);
/*      */           }
/*      */           
/*  912 */           return ValueBoolean.get(((new BigDecimal((String)object)).signum() != 0));
/*      */ 
/*      */         
/*      */         case 2:
/*  916 */           return ValueByte.get(Byte.parseByte(object.trim()));
/*      */         case 3:
/*  918 */           return ValueShort.get(Short.parseShort(object.trim()));
/*      */         case 4:
/*  920 */           return ValueInt.get(Integer.parseInt(object.trim()));
/*      */         case 5:
/*  922 */           return ValueLong.get(Long.parseLong(object.trim()));
/*      */         case 6:
/*  924 */           return ValueDecimal.get(new BigDecimal(object.trim()));
/*      */         case 9:
/*  926 */           return ValueTime.parse(object.trim());
/*      */         case 10:
/*  928 */           return ValueDate.parse(object.trim());
/*      */         case 11:
/*  930 */           return ValueTimestamp.parse(object.trim());
/*      */         case 24:
/*  932 */           return ValueTimestampTimeZone.parse(object.trim());
/*      */         case 12:
/*  934 */           return ValueBytes.getNoCopy(StringUtils.convertHexToBytes(object.trim()));
/*      */         
/*      */         case 19:
/*  937 */           return ValueJavaObject.getNoCopy(null, StringUtils.convertHexToBytes(object.trim()), getDataHandler());
/*      */         
/*      */         case 13:
/*  940 */           return ValueString.get((String)object);
/*      */         case 14:
/*  942 */           return ValueStringIgnoreCase.get((String)object);
/*      */         case 21:
/*  944 */           return ValueStringFixed.get((String)object);
/*      */         case 7:
/*  946 */           return ValueDouble.get(Double.parseDouble(object.trim()));
/*      */         case 8:
/*  948 */           return ValueFloat.get(Float.parseFloat(object.trim()));
/*      */         case 16:
/*  950 */           return ValueLobDb.createSmallLob(16, object.getBytes(Constants.UTF8));
/*      */         
/*      */         case 15:
/*  953 */           return ValueLobDb.createSmallLob(15, StringUtils.convertHexToBytes(object.trim()));
/*      */         
/*      */         case 17:
/*  956 */           return ValueArray.get(new Value[] { ValueString.get((String)object) });
/*      */         case 18:
/*  958 */           simpleResultSet = new SimpleResultSet();
/*  959 */           simpleResultSet.setAutoClose(false);
/*  960 */           simpleResultSet.addColumn("X", 12, object.length(), 0);
/*  961 */           simpleResultSet.addRow(new Object[] { object });
/*  962 */           return ValueResultSet.get((ResultSet)simpleResultSet);
/*      */         
/*      */         case 20:
/*  965 */           return ValueUuid.get((String)object);
/*      */         case 22:
/*  967 */           return ValueGeometry.get((String)object);
/*      */       } 
/*  969 */       throw DbException.throwInternalError("type=" + paramInt);
/*      */     }
/*  971 */     catch (NumberFormatException numberFormatException) {
/*  972 */       throw DbException.get(22018, numberFormatException, new String[] { getString() });
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int compareTypeSafe(Value paramValue, CompareMode paramCompareMode) {
/*  987 */     if (this == paramValue)
/*  988 */       return 0; 
/*  989 */     if (this == ValueNull.INSTANCE)
/*  990 */       return -1; 
/*  991 */     if (paramValue == ValueNull.INSTANCE) {
/*  992 */       return 1;
/*      */     }
/*  994 */     return compareSecure(paramValue, paramCompareMode);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int compareTo(Value paramValue, CompareMode paramCompareMode) {
/* 1007 */     if (this == paramValue) {
/* 1008 */       return 0;
/*      */     }
/* 1010 */     if (this == ValueNull.INSTANCE)
/* 1011 */       return (paramValue == ValueNull.INSTANCE) ? 0 : -1; 
/* 1012 */     if (paramValue == ValueNull.INSTANCE) {
/* 1013 */       return 1;
/*      */     }
/* 1015 */     if (getType() == paramValue.getType()) {
/* 1016 */       return compareSecure(paramValue, paramCompareMode);
/*      */     }
/* 1018 */     int i = getHigherOrder(getType(), paramValue.getType());
/* 1019 */     return convertTo(i).compareSecure(paramValue.convertTo(i), paramCompareMode);
/*      */   }
/*      */   
/*      */   public int getScale() {
/* 1023 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Value convertScale(boolean paramBoolean, int paramInt) {
/* 1034 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Value convertPrecision(long paramLong, boolean paramBoolean) {
/* 1047 */     return this;
/*      */   }
/*      */   
/*      */   private static byte convertToByte(long paramLong) {
/* 1051 */     if (paramLong > 127L || paramLong < -128L) {
/* 1052 */       throw DbException.get(22003, Long.toString(paramLong));
/*      */     }
/*      */     
/* 1055 */     return (byte)(int)paramLong;
/*      */   }
/*      */   
/*      */   private static short convertToShort(long paramLong) {
/* 1059 */     if (paramLong > 32767L || paramLong < -32768L) {
/* 1060 */       throw DbException.get(22003, Long.toString(paramLong));
/*      */     }
/*      */     
/* 1063 */     return (short)(int)paramLong;
/*      */   }
/*      */   
/*      */   private static int convertToInt(long paramLong) {
/* 1067 */     if (paramLong > 2147483647L || paramLong < -2147483648L) {
/* 1068 */       throw DbException.get(22003, Long.toString(paramLong));
/*      */     }
/*      */     
/* 1071 */     return (int)paramLong;
/*      */   }
/*      */   
/*      */   private static long convertToLong(double paramDouble) {
/* 1075 */     if (paramDouble > 9.223372036854776E18D || paramDouble < -9.223372036854776E18D)
/*      */     {
/*      */       
/* 1078 */       throw DbException.get(22003, Double.toString(paramDouble));
/*      */     }
/*      */     
/* 1081 */     return Math.round(paramDouble);
/*      */   }
/*      */   
/*      */   private static long convertToLong(BigDecimal paramBigDecimal) {
/* 1085 */     if (paramBigDecimal.compareTo(MAX_LONG_DECIMAL) > 0 || paramBigDecimal.compareTo(MIN_LONG_DECIMAL) < 0)
/*      */     {
/* 1087 */       throw DbException.get(22003, paramBigDecimal.toString());
/*      */     }
/*      */     
/* 1090 */     return paramBigDecimal.setScale(0, 4).longValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Value copy(DataHandler paramDataHandler, int paramInt) {
/* 1102 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isLinkedToTable() {
/* 1112 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void remove() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean checkPrecision(long paramLong) {
/* 1131 */     return (getPrecision() <= paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTraceSQL() {
/* 1141 */     return getSQL();
/*      */   }
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1146 */     return getTraceSQL();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected DbException throwUnsupportedExceptionForType(String paramString) {
/* 1158 */     throw DbException.getUnsupportedException((DataType.getDataType(getType())).name + " " + paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTableId() {
/* 1168 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] getSmall() {
/* 1177 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Value copyToTemp() {
/* 1186 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Value copyToResult() {
/* 1196 */     return this;
/*      */   }
/*      */   
/*      */   public ResultSet getResultSet() {
/* 1200 */     SimpleResultSet simpleResultSet = new SimpleResultSet();
/* 1201 */     simpleResultSet.setAutoClose(false);
/* 1202 */     simpleResultSet.addColumn("X", DataType.convertTypeToSQLType(getType()), MathUtils.convertLongToInt(getPrecision()), getScale());
/*      */     
/* 1204 */     simpleResultSet.addRow(new Object[] { getObject() });
/* 1205 */     return (ResultSet)simpleResultSet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected DataHandler getDataHandler() {
/* 1214 */     return null;
/*      */   }
/*      */   
/*      */   public static interface ValueBlob {}
/*      */   
/*      */   public static interface ValueClob {}
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\Value.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */