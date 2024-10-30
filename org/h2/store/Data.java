/*      */ package org.h2.store;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.OutputStream;
/*      */ import java.io.Reader;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.ResultSetMetaData;
/*      */ import java.sql.SQLException;
/*      */ import java.sql.Timestamp;
/*      */ import org.h2.engine.SysProperties;
/*      */ import org.h2.message.DbException;
/*      */ import org.h2.mvstore.DataUtils;
/*      */ import org.h2.tools.SimpleResultSet;
/*      */ import org.h2.util.DateTimeUtils;
/*      */ import org.h2.util.MathUtils;
/*      */ import org.h2.value.DataType;
/*      */ import org.h2.value.Value;
/*      */ import org.h2.value.ValueArray;
/*      */ import org.h2.value.ValueBoolean;
/*      */ import org.h2.value.ValueByte;
/*      */ import org.h2.value.ValueBytes;
/*      */ import org.h2.value.ValueDate;
/*      */ import org.h2.value.ValueDecimal;
/*      */ import org.h2.value.ValueDouble;
/*      */ import org.h2.value.ValueFloat;
/*      */ import org.h2.value.ValueGeometry;
/*      */ import org.h2.value.ValueInt;
/*      */ import org.h2.value.ValueJavaObject;
/*      */ import org.h2.value.ValueLob;
/*      */ import org.h2.value.ValueLobDb;
/*      */ import org.h2.value.ValueLong;
/*      */ import org.h2.value.ValueNull;
/*      */ import org.h2.value.ValueResultSet;
/*      */ import org.h2.value.ValueShort;
/*      */ import org.h2.value.ValueString;
/*      */ import org.h2.value.ValueStringFixed;
/*      */ import org.h2.value.ValueStringIgnoreCase;
/*      */ import org.h2.value.ValueTime;
/*      */ import org.h2.value.ValueTimestamp;
/*      */ import org.h2.value.ValueTimestampTimeZone;
/*      */ import org.h2.value.ValueUuid;
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
/*      */ public class Data
/*      */ {
/*      */   public static final int LENGTH_INT = 4;
/*      */   private static final int LENGTH_LONG = 8;
/*      */   private static final int INT_0_15 = 32;
/*      */   private static final int LONG_0_7 = 48;
/*      */   private static final int DECIMAL_0_1 = 56;
/*      */   private static final int DECIMAL_SMALL_0 = 58;
/*      */   private static final int DECIMAL_SMALL = 59;
/*      */   private static final int DOUBLE_0_1 = 60;
/*      */   private static final int FLOAT_0_1 = 62;
/*      */   private static final int BOOLEAN_FALSE = 64;
/*      */   private static final int BOOLEAN_TRUE = 65;
/*      */   private static final int INT_NEG = 66;
/*      */   private static final int LONG_NEG = 67;
/*      */   private static final int STRING_0_31 = 68;
/*      */   private static final int BYTES_0_31 = 100;
/*      */   private static final int LOCAL_TIME = 132;
/*      */   private static final int LOCAL_DATE = 133;
/*      */   private static final int LOCAL_TIMESTAMP = 134;
/*      */   private static final long MILLIS_PER_MINUTE = 60000L;
/*      */   private static final boolean STORE_LOCAL_TIME = false;
/*      */   private byte[] data;
/*      */   private int pos;
/*      */   private final DataHandler handler;
/*      */   
/*      */   private Data(DataHandler paramDataHandler, byte[] paramArrayOfbyte) {
/*  118 */     this.handler = paramDataHandler;
/*  119 */     this.data = paramArrayOfbyte;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInt(int paramInt1, int paramInt2) {
/*  130 */     byte[] arrayOfByte = this.data;
/*  131 */     arrayOfByte[paramInt1] = (byte)(paramInt2 >> 24);
/*  132 */     arrayOfByte[paramInt1 + 1] = (byte)(paramInt2 >> 16);
/*  133 */     arrayOfByte[paramInt1 + 2] = (byte)(paramInt2 >> 8);
/*  134 */     arrayOfByte[paramInt1 + 3] = (byte)paramInt2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeInt(int paramInt) {
/*  144 */     byte[] arrayOfByte = this.data;
/*  145 */     arrayOfByte[this.pos] = (byte)(paramInt >> 24);
/*  146 */     arrayOfByte[this.pos + 1] = (byte)(paramInt >> 16);
/*  147 */     arrayOfByte[this.pos + 2] = (byte)(paramInt >> 8);
/*  148 */     arrayOfByte[this.pos + 3] = (byte)paramInt;
/*  149 */     this.pos += 4;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int readInt() {
/*  159 */     byte[] arrayOfByte = this.data;
/*  160 */     int i = (arrayOfByte[this.pos] << 24) + ((arrayOfByte[this.pos + 1] & 0xFF) << 16) + ((arrayOfByte[this.pos + 2] & 0xFF) << 8) + (arrayOfByte[this.pos + 3] & 0xFF);
/*      */ 
/*      */ 
/*      */     
/*  164 */     this.pos += 4;
/*  165 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getStringLen(String paramString) {
/*  176 */     int i = paramString.length();
/*  177 */     return getStringWithoutLengthLen(paramString, i) + getVarIntLen(i);
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
/*      */   
/*      */   private static int getStringWithoutLengthLen(String paramString, int paramInt) {
/*  192 */     byte b1 = 0;
/*  193 */     for (byte b2 = 0; b2 < paramInt; b2++) {
/*  194 */       char c = paramString.charAt(b2);
/*  195 */       if (c >= 'ࠀ') {
/*  196 */         b1 += true;
/*  197 */       } else if (c >= '') {
/*  198 */         b1++;
/*      */       } 
/*      */     } 
/*  201 */     return paramInt + b1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String readString() {
/*  211 */     int i = readVarInt();
/*  212 */     return readString(i);
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
/*      */   private String readString(int paramInt) {
/*  225 */     byte[] arrayOfByte = this.data;
/*  226 */     int i = this.pos;
/*  227 */     char[] arrayOfChar = new char[paramInt];
/*  228 */     for (byte b = 0; b < paramInt; b++) {
/*  229 */       int j = arrayOfByte[i++] & 0xFF;
/*  230 */       if (j < 128) {
/*  231 */         arrayOfChar[b] = (char)j;
/*  232 */       } else if (j >= 224) {
/*  233 */         arrayOfChar[b] = (char)(((j & 0xF) << 12) + ((arrayOfByte[i++] & 0x3F) << 6) + (arrayOfByte[i++] & 0x3F));
/*      */       }
/*      */       else {
/*      */         
/*  237 */         arrayOfChar[b] = (char)(((j & 0x1F) << 6) + (arrayOfByte[i++] & 0x3F));
/*      */       } 
/*      */     } 
/*      */     
/*  241 */     this.pos = i;
/*  242 */     return new String(arrayOfChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeString(String paramString) {
/*  252 */     int i = paramString.length();
/*  253 */     writeVarInt(i);
/*  254 */     writeStringWithoutLength(paramString, i);
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
/*      */   private void writeStringWithoutLength(String paramString, int paramInt) {
/*  267 */     int i = this.pos;
/*  268 */     byte[] arrayOfByte = this.data;
/*  269 */     for (byte b = 0; b < paramInt; b++) {
/*  270 */       char c = paramString.charAt(b);
/*  271 */       if (c < '') {
/*  272 */         arrayOfByte[i++] = (byte)c;
/*  273 */       } else if (c >= 'ࠀ') {
/*  274 */         arrayOfByte[i++] = (byte)(0xE0 | c >> 12);
/*  275 */         arrayOfByte[i++] = (byte)(c >> 6 & 0x3F);
/*  276 */         arrayOfByte[i++] = (byte)(c & 0x3F);
/*      */       } else {
/*  278 */         arrayOfByte[i++] = (byte)(0xC0 | c >> 6);
/*  279 */         arrayOfByte[i++] = (byte)(c & 0x3F);
/*      */       } 
/*      */     } 
/*  282 */     this.pos = i;
/*      */   }
/*      */   
/*      */   private void writeStringWithoutLength(char[] paramArrayOfchar, int paramInt) {
/*  286 */     int i = this.pos;
/*  287 */     byte[] arrayOfByte = this.data;
/*  288 */     for (byte b = 0; b < paramInt; b++) {
/*  289 */       char c = paramArrayOfchar[b];
/*  290 */       if (c < '') {
/*  291 */         arrayOfByte[i++] = (byte)c;
/*  292 */       } else if (c >= 'ࠀ') {
/*  293 */         arrayOfByte[i++] = (byte)(0xE0 | c >> 12);
/*  294 */         arrayOfByte[i++] = (byte)(c >> 6 & 0x3F);
/*  295 */         arrayOfByte[i++] = (byte)(c & 0x3F);
/*      */       } else {
/*  297 */         arrayOfByte[i++] = (byte)(0xC0 | c >> 6);
/*  298 */         arrayOfByte[i++] = (byte)(c & 0x3F);
/*      */       } 
/*      */     } 
/*  301 */     this.pos = i;
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
/*      */   public static Data create(DataHandler paramDataHandler, int paramInt) {
/*  313 */     return new Data(paramDataHandler, new byte[paramInt]);
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
/*      */   public static Data create(DataHandler paramDataHandler, byte[] paramArrayOfbyte) {
/*  325 */     return new Data(paramDataHandler, paramArrayOfbyte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int length() {
/*  335 */     return this.pos;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] getBytes() {
/*  344 */     return this.data;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void reset() {
/*  351 */     this.pos = 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  362 */     System.arraycopy(paramArrayOfbyte, paramInt1, this.data, this.pos, paramInt2);
/*  363 */     this.pos += paramInt2;
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
/*      */   public void read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  375 */     System.arraycopy(this.data, this.pos, paramArrayOfbyte, paramInt1, paramInt2);
/*  376 */     this.pos += paramInt2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeByte(byte paramByte) {
/*  385 */     this.data[this.pos++] = paramByte;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte readByte() {
/*  394 */     return this.data[this.pos++];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long readLong() {
/*  403 */     return (readInt() << 32L) + (readInt() & 0xFFFFFFFFL);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeLong(long paramLong) {
/*  412 */     writeInt((int)(paramLong >>> 32L));
/*  413 */     writeInt((int)paramLong); } public void writeValue(Value paramValue) { int k; long l2; BigDecimal bigDecimal; long l1; Timestamp timestamp; ValueTimestampTimeZone valueTimestampTimeZone; byte[] arrayOfByte1; ValueUuid valueUuid; String str; double d;
/*      */     float f;
/*      */     ValueLobDb valueLobDb;
/*      */     Value[] arrayOfValue;
/*      */     int m;
/*      */     byte[] arrayOfByte2;
/*      */     BigInteger bigInteger;
/*      */     long l3;
/*      */     byte[] arrayOfByte3;
/*  422 */     int i = this.pos;
/*  423 */     if (paramValue == ValueNull.INSTANCE) {
/*  424 */       this.data[this.pos++] = 0;
/*      */       return;
/*      */     } 
/*  427 */     int j = paramValue.getType();
/*  428 */     switch (j) {
/*      */       case 1:
/*  430 */         writeByte((byte)(paramValue.getBoolean().booleanValue() ? 65 : 64));
/*      */         break;
/*      */       
/*      */       case 2:
/*  434 */         writeByte((byte)j);
/*  435 */         writeByte(paramValue.getByte());
/*      */         break;
/*      */       case 3:
/*  438 */         writeByte((byte)j);
/*  439 */         writeShortInt(paramValue.getShort());
/*      */         break;
/*      */       case 4:
/*  442 */         k = paramValue.getInt();
/*  443 */         if (k < 0) {
/*  444 */           writeByte((byte)66);
/*  445 */           writeVarInt(-k); break;
/*  446 */         }  if (k < 16) {
/*  447 */           writeByte((byte)(32 + k)); break;
/*      */         } 
/*  449 */         writeByte((byte)j);
/*  450 */         writeVarInt(k);
/*      */         break;
/*      */ 
/*      */       
/*      */       case 5:
/*  455 */         l2 = paramValue.getLong();
/*  456 */         if (l2 < 0L) {
/*  457 */           writeByte((byte)67);
/*  458 */           writeVarLong(-l2); break;
/*  459 */         }  if (l2 < 8L) {
/*  460 */           writeByte((byte)(int)(48L + l2)); break;
/*      */         } 
/*  462 */         writeByte((byte)j);
/*  463 */         writeVarLong(l2);
/*      */         break;
/*      */ 
/*      */       
/*      */       case 6:
/*  468 */         bigDecimal = paramValue.getBigDecimal();
/*  469 */         if (BigDecimal.ZERO.equals(bigDecimal)) {
/*  470 */           writeByte((byte)56); break;
/*  471 */         }  if (BigDecimal.ONE.equals(bigDecimal)) {
/*  472 */           writeByte((byte)57); break;
/*      */         } 
/*  474 */         m = bigDecimal.scale();
/*  475 */         bigInteger = bigDecimal.unscaledValue();
/*  476 */         null = bigInteger.bitLength();
/*  477 */         if (null <= 63) {
/*  478 */           if (m == 0) {
/*  479 */             writeByte((byte)58);
/*  480 */             writeVarLong(bigInteger.longValue()); break;
/*      */           } 
/*  482 */           writeByte((byte)59);
/*  483 */           writeVarInt(m);
/*  484 */           writeVarLong(bigInteger.longValue());
/*      */           break;
/*      */         } 
/*  487 */         writeByte((byte)j);
/*  488 */         writeVarInt(m);
/*  489 */         arrayOfByte3 = bigInteger.toByteArray();
/*  490 */         writeVarInt(arrayOfByte3.length);
/*  491 */         write(arrayOfByte3, 0, arrayOfByte3.length);
/*      */         break;
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
/*      */       case 9:
/*  506 */         writeByte((byte)j);
/*  507 */         writeVarLong(DateTimeUtils.getTimeLocalWithoutDst(paramValue.getTime()));
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 10:
/*  516 */         writeByte((byte)j);
/*  517 */         l1 = DateTimeUtils.getTimeLocalWithoutDst(paramValue.getDate());
/*  518 */         writeVarLong(l1 / 60000L);
/*      */         break;
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
/*      */       case 11:
/*  534 */         timestamp = paramValue.getTimestamp();
/*  535 */         writeByte((byte)j);
/*  536 */         writeVarLong(DateTimeUtils.getTimeLocalWithoutDst(timestamp));
/*  537 */         writeVarInt(timestamp.getNanos() % 1000000);
/*      */         break;
/*      */ 
/*      */       
/*      */       case 24:
/*  542 */         valueTimestampTimeZone = (ValueTimestampTimeZone)paramValue;
/*  543 */         writeByte((byte)j);
/*  544 */         writeVarLong(valueTimestampTimeZone.getDateValue());
/*  545 */         writeVarLong(valueTimestampTimeZone.getTimeNanos());
/*  546 */         writeVarInt(valueTimestampTimeZone.getTimeZoneOffsetMins());
/*      */ 
/*      */       
/*      */       case 19:
/*      */       case 22:
/*  551 */         writeByte((byte)j);
/*  552 */         arrayOfByte1 = paramValue.getBytesNoCopy();
/*  553 */         m = arrayOfByte1.length;
/*  554 */         writeVarInt(m);
/*  555 */         write(arrayOfByte1, 0, m);
/*      */         break;
/*      */       
/*      */       case 12:
/*  559 */         arrayOfByte1 = paramValue.getBytesNoCopy();
/*  560 */         m = arrayOfByte1.length;
/*  561 */         if (m < 32) {
/*  562 */           writeByte((byte)(100 + m));
/*  563 */           write(arrayOfByte1, 0, m); break;
/*      */         } 
/*  565 */         writeByte((byte)j);
/*  566 */         writeVarInt(m);
/*  567 */         write(arrayOfByte1, 0, m);
/*      */         break;
/*      */ 
/*      */       
/*      */       case 20:
/*  572 */         writeByte((byte)j);
/*  573 */         valueUuid = (ValueUuid)paramValue;
/*  574 */         writeLong(valueUuid.getHigh());
/*  575 */         writeLong(valueUuid.getLow());
/*      */         break;
/*      */       
/*      */       case 13:
/*  579 */         str = paramValue.getString();
/*  580 */         m = str.length();
/*  581 */         if (m < 32) {
/*  582 */           writeByte((byte)(68 + m));
/*  583 */           writeStringWithoutLength(str, m); break;
/*      */         } 
/*  585 */         writeByte((byte)j);
/*  586 */         writeString(str);
/*      */         break;
/*      */ 
/*      */       
/*      */       case 14:
/*      */       case 21:
/*  592 */         writeByte((byte)j);
/*  593 */         writeString(paramValue.getString());
/*      */         break;
/*      */       case 7:
/*  596 */         d = paramValue.getDouble();
/*  597 */         if (d == 1.0D) {
/*  598 */           writeByte((byte)61); break;
/*      */         } 
/*  600 */         l3 = Double.doubleToLongBits(d);
/*  601 */         if (l3 == ValueDouble.ZERO_BITS) {
/*  602 */           writeByte((byte)60); break;
/*      */         } 
/*  604 */         writeByte((byte)j);
/*  605 */         writeVarLong(Long.reverse(l3));
/*      */         break;
/*      */ 
/*      */ 
/*      */       
/*      */       case 8:
/*  611 */         f = paramValue.getFloat();
/*  612 */         if (f == 1.0F) {
/*  613 */           writeByte((byte)63); break;
/*      */         } 
/*  615 */         m = Float.floatToIntBits(f);
/*  616 */         if (m == ValueFloat.ZERO_BITS) {
/*  617 */           writeByte((byte)62); break;
/*      */         } 
/*  619 */         writeByte((byte)j);
/*  620 */         writeVarInt(Integer.reverse(m));
/*      */         break;
/*      */ 
/*      */ 
/*      */       
/*      */       case 15:
/*      */       case 16:
/*  627 */         writeByte((byte)j);
/*  628 */         if (paramValue instanceof ValueLob) {
/*  629 */           ValueLob valueLob = (ValueLob)paramValue;
/*  630 */           valueLob.convertToFileIfRequired(this.handler);
/*  631 */           byte[] arrayOfByte = valueLob.getSmall();
/*  632 */           if (arrayOfByte == null) {
/*  633 */             byte b = -1;
/*  634 */             if (!valueLob.isLinkedToTable()) {
/*  635 */               b = -2;
/*      */             }
/*  637 */             writeVarInt(b);
/*  638 */             writeVarInt(valueLob.getTableId());
/*  639 */             writeVarInt(valueLob.getObjectId());
/*  640 */             writeVarLong(valueLob.getPrecision());
/*  641 */             writeByte((byte)(valueLob.isCompressed() ? 1 : 0));
/*  642 */             if (b == -2)
/*  643 */               writeString(valueLob.getFileName()); 
/*      */             break;
/*      */           } 
/*  646 */           writeVarInt(arrayOfByte.length);
/*  647 */           write(arrayOfByte, 0, arrayOfByte.length);
/*      */           break;
/*      */         } 
/*  650 */         valueLobDb = (ValueLobDb)paramValue;
/*  651 */         arrayOfByte2 = valueLobDb.getSmall();
/*  652 */         if (arrayOfByte2 == null) {
/*  653 */           writeVarInt(-3);
/*  654 */           writeVarInt(valueLobDb.getTableId());
/*  655 */           writeVarLong(valueLobDb.getLobId());
/*  656 */           writeVarLong(valueLobDb.getPrecision()); break;
/*      */         } 
/*  658 */         writeVarInt(arrayOfByte2.length);
/*  659 */         write(arrayOfByte2, 0, arrayOfByte2.length);
/*      */         break;
/*      */ 
/*      */ 
/*      */       
/*      */       case 17:
/*  665 */         writeByte((byte)j);
/*  666 */         arrayOfValue = ((ValueArray)paramValue).getList();
/*  667 */         writeVarInt(arrayOfValue.length);
/*  668 */         for (Value value : arrayOfValue) {
/*  669 */           writeValue(value);
/*      */         }
/*      */         break;
/*      */       
/*      */       case 18:
/*  674 */         writeByte((byte)j);
/*      */         try {
/*  676 */           ResultSet resultSet = ((ValueResultSet)paramValue).getResultSet();
/*  677 */           resultSet.beforeFirst();
/*  678 */           ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
/*  679 */           int n = resultSetMetaData.getColumnCount();
/*  680 */           writeVarInt(n); byte b;
/*  681 */           for (b = 0; b < n; b++) {
/*  682 */             writeString(resultSetMetaData.getColumnName(b + 1));
/*  683 */             writeVarInt(resultSetMetaData.getColumnType(b + 1));
/*  684 */             writeVarInt(resultSetMetaData.getPrecision(b + 1));
/*  685 */             writeVarInt(resultSetMetaData.getScale(b + 1));
/*      */           } 
/*  687 */           while (resultSet.next()) {
/*  688 */             writeByte((byte)1);
/*  689 */             for (b = 0; b < n; b++) {
/*  690 */               int i1 = DataType.getValueTypeFromResultSet(resultSetMetaData, b + 1);
/*  691 */               Value value = DataType.readValue(null, resultSet, b + 1, i1);
/*  692 */               writeValue(value);
/*      */             } 
/*      */           } 
/*  695 */           writeByte((byte)0);
/*  696 */           resultSet.beforeFirst();
/*  697 */         } catch (SQLException sQLException) {
/*  698 */           throw DbException.convert(sQLException);
/*      */         } 
/*      */         break;
/*      */       
/*      */       default:
/*  703 */         DbException.throwInternalError("type=" + paramValue.getType()); break;
/*      */     } 
/*  705 */     if (SysProperties.CHECK2 && 
/*  706 */       this.pos - i != getValueLen(paramValue, this.handler))
/*  707 */       throw DbException.throwInternalError("value size error: got " + (this.pos - i) + " expected " + getValueLen(paramValue, this.handler));  } public Value readValue() { int k; long l1; int j; SimpleResultSet simpleResultSet;
/*      */     int i1;
/*      */     byte[] arrayOfByte1;
/*      */     int n;
/*      */     Value[] arrayOfValue;
/*      */     int m;
/*      */     byte[] arrayOfByte2;
/*      */     long l2;
/*      */     int i2;
/*      */     BigInteger bigInteger;
/*      */     long l3;
/*      */     short s;
/*      */     boolean bool;
/*  720 */     int i = this.data[this.pos++] & 0xFF;
/*  721 */     switch (i) {
/*      */       case 0:
/*  723 */         return (Value)ValueNull.INSTANCE;
/*      */       case 65:
/*  725 */         return (Value)ValueBoolean.get(true);
/*      */       case 64:
/*  727 */         return (Value)ValueBoolean.get(false);
/*      */       case 66:
/*  729 */         return (Value)ValueInt.get(-readVarInt());
/*      */       case 4:
/*  731 */         return (Value)ValueInt.get(readVarInt());
/*      */       case 67:
/*  733 */         return (Value)ValueLong.get(-readVarLong());
/*      */       case 5:
/*  735 */         return (Value)ValueLong.get(readVarLong());
/*      */       case 2:
/*  737 */         return (Value)ValueByte.get(readByte());
/*      */       case 3:
/*  739 */         return (Value)ValueShort.get(readShortInt());
/*      */       case 56:
/*  741 */         return (Value)ValueDecimal.ZERO;
/*      */       case 57:
/*  743 */         return (Value)ValueDecimal.ONE;
/*      */       case 58:
/*  745 */         return (Value)ValueDecimal.get(BigDecimal.valueOf(readVarLong()));
/*      */       case 59:
/*  747 */         k = readVarInt();
/*  748 */         return (Value)ValueDecimal.get(BigDecimal.valueOf(readVarLong(), k));
/*      */       
/*      */       case 6:
/*  751 */         k = readVarInt();
/*  752 */         i1 = readVarInt();
/*  753 */         arrayOfByte2 = DataUtils.newBytes(i1);
/*  754 */         read(arrayOfByte2, 0, i1);
/*  755 */         bigInteger = new BigInteger(arrayOfByte2);
/*  756 */         return (Value)ValueDecimal.get(new BigDecimal(bigInteger, k));
/*      */       
/*      */       case 133:
/*  759 */         return (Value)ValueDate.fromDateValue(readVarLong());
/*      */       
/*      */       case 10:
/*  762 */         l1 = readVarLong() * 60000L;
/*  763 */         return (Value)ValueDate.fromMillis(DateTimeUtils.getTimeUTCWithoutDst(l1));
/*      */       
/*      */       case 132:
/*  766 */         l1 = readVarLong() * 1000000L + readVarLong();
/*  767 */         return (Value)ValueTime.fromNanos(l1);
/*      */ 
/*      */       
/*      */       case 9:
/*  771 */         return (Value)ValueTime.fromMillis(DateTimeUtils.getTimeUTCWithoutDst(readVarLong()));
/*      */       
/*      */       case 134:
/*  774 */         l1 = readVarLong();
/*  775 */         l2 = readVarLong() * 1000000L + readVarLong();
/*  776 */         return (Value)ValueTimestamp.fromDateValueAndNanos(l1, l2);
/*      */       
/*      */       case 11:
/*  779 */         return (Value)ValueTimestamp.fromMillisNanos(DateTimeUtils.getTimeUTCWithoutDst(readVarLong()), readVarInt());
/*      */ 
/*      */ 
/*      */       
/*      */       case 24:
/*  784 */         l1 = readVarLong();
/*  785 */         l2 = readVarLong();
/*  786 */         s = (short)readVarInt();
/*  787 */         return (Value)ValueTimestampTimeZone.fromDateValueAndNanos(l1, l2, s);
/*      */       
/*      */       case 12:
/*  790 */         j = readVarInt();
/*  791 */         arrayOfByte1 = DataUtils.newBytes(j);
/*  792 */         read(arrayOfByte1, 0, j);
/*  793 */         return (Value)ValueBytes.getNoCopy(arrayOfByte1);
/*      */       
/*      */       case 22:
/*  796 */         j = readVarInt();
/*  797 */         arrayOfByte1 = DataUtils.newBytes(j);
/*  798 */         read(arrayOfByte1, 0, j);
/*  799 */         return (Value)ValueGeometry.get(arrayOfByte1);
/*      */       
/*      */       case 19:
/*  802 */         j = readVarInt();
/*  803 */         arrayOfByte1 = DataUtils.newBytes(j);
/*  804 */         read(arrayOfByte1, 0, j);
/*  805 */         return (Value)ValueJavaObject.getNoCopy(null, arrayOfByte1, this.handler);
/*      */       
/*      */       case 20:
/*  808 */         return (Value)ValueUuid.get(readLong(), readLong());
/*      */       case 13:
/*  810 */         return ValueString.get(readString());
/*      */       case 14:
/*  812 */         return (Value)ValueStringIgnoreCase.get(readString());
/*      */       case 21:
/*  814 */         return (Value)ValueStringFixed.get(readString());
/*      */       case 62:
/*  816 */         return (Value)ValueFloat.get(0.0F);
/*      */       case 63:
/*  818 */         return (Value)ValueFloat.get(1.0F);
/*      */       case 60:
/*  820 */         return (Value)ValueDouble.get(0.0D);
/*      */       case 61:
/*  822 */         return (Value)ValueDouble.get(1.0D);
/*      */       case 7:
/*  824 */         return (Value)ValueDouble.get(Double.longBitsToDouble(Long.reverse(readVarLong())));
/*      */       
/*      */       case 8:
/*  827 */         return (Value)ValueFloat.get(Float.intBitsToFloat(Integer.reverse(readVarInt())));
/*      */       
/*      */       case 15:
/*      */       case 16:
/*  831 */         j = readVarInt();
/*  832 */         if (j >= 0) {
/*  833 */           arrayOfByte1 = DataUtils.newBytes(j);
/*  834 */           read(arrayOfByte1, 0, j);
/*  835 */           return ValueLobDb.createSmallLob(i, arrayOfByte1);
/*  836 */         }  if (j == -3) {
/*  837 */           int i3 = readVarInt();
/*  838 */           l2 = readVarLong();
/*  839 */           long l = readVarLong();
/*  840 */           return (Value)ValueLobDb.create(i, this.handler, i3, l2, null, l);
/*      */         } 
/*      */ 
/*      */         
/*  844 */         n = readVarInt();
/*  845 */         i2 = readVarInt();
/*  846 */         l3 = 0L;
/*  847 */         bool = false;
/*      */ 
/*      */         
/*  850 */         if (j == -1 || j == -2) {
/*  851 */           l3 = readVarLong();
/*  852 */           bool = (readByte() == 1) ? true : false;
/*      */         } 
/*  854 */         if (j == -2) {
/*  855 */           String str = readString();
/*  856 */           return (Value)ValueLob.openUnlinked(i, this.handler, n, i2, l3, bool, str);
/*      */         } 
/*      */         
/*  859 */         return (Value)ValueLob.openLinked(i, this.handler, n, i2, l3, bool);
/*      */ 
/*      */ 
/*      */       
/*      */       case 17:
/*  864 */         j = readVarInt();
/*  865 */         arrayOfValue = new Value[j];
/*  866 */         for (i2 = 0; i2 < j; i2++) {
/*  867 */           arrayOfValue[i2] = readValue();
/*      */         }
/*  869 */         return (Value)ValueArray.get(arrayOfValue);
/*      */       
/*      */       case 18:
/*  872 */         simpleResultSet = new SimpleResultSet();
/*  873 */         simpleResultSet.setAutoClose(false);
/*  874 */         m = readVarInt();
/*  875 */         for (i2 = 0; i2 < m; i2++) {
/*  876 */           simpleResultSet.addColumn(readString(), readVarInt(), readVarInt(), readVarInt());
/*      */         }
/*      */         
/*  879 */         while (readByte() != 0) {
/*      */ 
/*      */           
/*  882 */           Object[] arrayOfObject = new Object[m];
/*  883 */           for (byte b = 0; b < m; b++) {
/*  884 */             arrayOfObject[b] = readValue().getObject();
/*      */           }
/*  886 */           simpleResultSet.addRow(arrayOfObject);
/*      */         } 
/*  888 */         return (Value)ValueResultSet.get((ResultSet)simpleResultSet);
/*      */     } 
/*      */     
/*  891 */     if (i >= 32 && i < 48)
/*  892 */       return (Value)ValueInt.get(i - 32); 
/*  893 */     if (i >= 48 && i < 56)
/*  894 */       return (Value)ValueLong.get((i - 48)); 
/*  895 */     if (i >= 100 && i < 132) {
/*  896 */       int i3 = i - 100;
/*  897 */       byte[] arrayOfByte = DataUtils.newBytes(i3);
/*  898 */       read(arrayOfByte, 0, i3);
/*  899 */       return (Value)ValueBytes.getNoCopy(arrayOfByte);
/*  900 */     }  if (i >= 68 && i < 100) {
/*  901 */       return ValueString.get(readString(i - 68));
/*      */     }
/*  903 */     throw DbException.get(90030, "type: " + i); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getValueLen(Value paramValue) {
/*  914 */     return getValueLen(paramValue, this.handler); } public static int getValueLen(Value paramValue, DataHandler paramDataHandler) { int k; long l2; double d; float f; String str; BigDecimal bigDecimal; long l1; Timestamp timestamp; ValueTimestampTimeZone valueTimestampTimeZone; byte[] arrayOfByte1; int j; Value[] arrayOfValue;
/*      */     int i;
/*      */     int n;
/*      */     long l3;
/*      */     int m;
/*      */     long l4;
/*      */     BigInteger bigInteger;
/*      */     int i1;
/*      */     long l5;
/*      */     byte[] arrayOfByte2;
/*      */     short s;
/*  925 */     if (paramValue == ValueNull.INSTANCE) {
/*  926 */       return 1;
/*      */     }
/*  928 */     switch (paramValue.getType()) {
/*      */       case 1:
/*  930 */         return 1;
/*      */       case 2:
/*  932 */         return 2;
/*      */       case 3:
/*  934 */         return 3;
/*      */       case 4:
/*  936 */         k = paramValue.getInt();
/*  937 */         if (k < 0)
/*  938 */           return 1 + getVarIntLen(-k); 
/*  939 */         if (k < 16) {
/*  940 */           return 1;
/*      */         }
/*  942 */         return 1 + getVarIntLen(k);
/*      */ 
/*      */       
/*      */       case 5:
/*  946 */         l2 = paramValue.getLong();
/*  947 */         if (l2 < 0L)
/*  948 */           return 1 + getVarLongLen(-l2); 
/*  949 */         if (l2 < 8L) {
/*  950 */           return 1;
/*      */         }
/*  952 */         return 1 + getVarLongLen(l2);
/*      */ 
/*      */       
/*      */       case 7:
/*  956 */         d = paramValue.getDouble();
/*  957 */         if (d == 1.0D) {
/*  958 */           return 1;
/*      */         }
/*  960 */         l4 = Double.doubleToLongBits(d);
/*  961 */         if (l4 == ValueDouble.ZERO_BITS) {
/*  962 */           return 1;
/*      */         }
/*  964 */         return 1 + getVarLongLen(Long.reverse(l4));
/*      */       
/*      */       case 8:
/*  967 */         f = paramValue.getFloat();
/*  968 */         if (f == 1.0F) {
/*  969 */           return 1;
/*      */         }
/*  971 */         n = Float.floatToIntBits(f);
/*  972 */         if (n == ValueFloat.ZERO_BITS) {
/*  973 */           return 1;
/*      */         }
/*  975 */         return 1 + getVarIntLen(Integer.reverse(n));
/*      */       
/*      */       case 13:
/*  978 */         str = paramValue.getString();
/*  979 */         n = str.length();
/*  980 */         if (n < 32) {
/*  981 */           return 1 + getStringWithoutLengthLen(str, n);
/*      */         }
/*  983 */         return 1 + getStringLen(str);
/*      */       
/*      */       case 14:
/*      */       case 21:
/*  987 */         return 1 + getStringLen(paramValue.getString());
/*      */       case 6:
/*  989 */         bigDecimal = paramValue.getBigDecimal();
/*  990 */         if (BigDecimal.ZERO.equals(bigDecimal))
/*  991 */           return 1; 
/*  992 */         if (BigDecimal.ONE.equals(bigDecimal)) {
/*  993 */           return 1;
/*      */         }
/*  995 */         n = bigDecimal.scale();
/*  996 */         bigInteger = bigDecimal.unscaledValue();
/*  997 */         i1 = bigInteger.bitLength();
/*  998 */         if (i1 <= 63) {
/*  999 */           if (n == 0) {
/* 1000 */             return 1 + getVarLongLen(bigInteger.longValue());
/*      */           }
/* 1002 */           return 1 + getVarIntLen(n) + getVarLongLen(bigInteger.longValue());
/*      */         } 
/* 1004 */         arrayOfByte2 = bigInteger.toByteArray();
/* 1005 */         return 1 + getVarIntLen(n) + getVarIntLen(arrayOfByte2.length) + arrayOfByte2.length;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 9:
/* 1014 */         return 1 + getVarLongLen(DateTimeUtils.getTimeLocalWithoutDst(paramValue.getTime()));
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 10:
/* 1020 */         l1 = DateTimeUtils.getTimeLocalWithoutDst(paramValue.getDate());
/* 1021 */         return 1 + getVarLongLen(l1 / 60000L);
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
/*      */       case 11:
/* 1033 */         timestamp = paramValue.getTimestamp();
/* 1034 */         return 1 + getVarLongLen(DateTimeUtils.getTimeLocalWithoutDst(timestamp)) + getVarIntLen(timestamp.getNanos() % 1000000);
/*      */ 
/*      */       
/*      */       case 24:
/* 1038 */         valueTimestampTimeZone = (ValueTimestampTimeZone)paramValue;
/* 1039 */         l3 = valueTimestampTimeZone.getDateValue();
/* 1040 */         l5 = valueTimestampTimeZone.getTimeNanos();
/* 1041 */         s = valueTimestampTimeZone.getTimeZoneOffsetMins();
/* 1042 */         return 1 + getVarLongLen(l3) + getVarLongLen(l5) + getVarIntLen(s);
/*      */ 
/*      */       
/*      */       case 19:
/*      */       case 22:
/* 1047 */         arrayOfByte1 = paramValue.getBytesNoCopy();
/* 1048 */         return 1 + getVarIntLen(arrayOfByte1.length) + arrayOfByte1.length;
/*      */       
/*      */       case 12:
/* 1051 */         arrayOfByte1 = paramValue.getBytesNoCopy();
/* 1052 */         m = arrayOfByte1.length;
/* 1053 */         if (m < 32) {
/* 1054 */           return 1 + arrayOfByte1.length;
/*      */         }
/* 1056 */         return 1 + getVarIntLen(arrayOfByte1.length) + arrayOfByte1.length;
/*      */       
/*      */       case 20:
/* 1059 */         return 17;
/*      */       case 15:
/*      */       case 16:
/* 1062 */         j = 1;
/* 1063 */         if (paramValue instanceof ValueLob) {
/* 1064 */           ValueLob valueLob = (ValueLob)paramValue;
/* 1065 */           valueLob.convertToFileIfRequired(paramDataHandler);
/* 1066 */           byte[] arrayOfByte = valueLob.getSmall();
/* 1067 */           if (arrayOfByte == null) {
/* 1068 */             byte b = -1;
/* 1069 */             if (!valueLob.isLinkedToTable()) {
/* 1070 */               b = -2;
/*      */             }
/* 1072 */             j += getVarIntLen(b);
/* 1073 */             j += getVarIntLen(valueLob.getTableId());
/* 1074 */             j += getVarIntLen(valueLob.getObjectId());
/* 1075 */             j += getVarLongLen(valueLob.getPrecision());
/* 1076 */             j++;
/* 1077 */             if (b == -2) {
/* 1078 */               j += getStringLen(valueLob.getFileName());
/*      */             }
/*      */           } else {
/* 1081 */             j += getVarIntLen(arrayOfByte.length);
/* 1082 */             j += arrayOfByte.length;
/*      */           } 
/*      */         } else {
/* 1085 */           ValueLobDb valueLobDb = (ValueLobDb)paramValue;
/* 1086 */           byte[] arrayOfByte = valueLobDb.getSmall();
/* 1087 */           if (arrayOfByte == null) {
/* 1088 */             j += getVarIntLen(-3);
/* 1089 */             j += getVarIntLen(valueLobDb.getTableId());
/* 1090 */             j += getVarLongLen(valueLobDb.getLobId());
/* 1091 */             j += getVarLongLen(valueLobDb.getPrecision());
/*      */           } else {
/* 1093 */             j += getVarIntLen(arrayOfByte.length);
/* 1094 */             j += arrayOfByte.length;
/*      */           } 
/*      */         } 
/* 1097 */         return j;
/*      */       
/*      */       case 17:
/* 1100 */         arrayOfValue = ((ValueArray)paramValue).getList();
/* 1101 */         m = 1 + getVarIntLen(arrayOfValue.length);
/* 1102 */         for (Value value : arrayOfValue) {
/* 1103 */           m += getValueLen(value, paramDataHandler);
/*      */         }
/* 1105 */         return m;
/*      */       
/*      */       case 18:
/* 1108 */         i = 1;
/*      */         try {
/* 1110 */           ResultSet resultSet = ((ValueResultSet)paramValue).getResultSet();
/* 1111 */           resultSet.beforeFirst();
/* 1112 */           ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
/* 1113 */           int i2 = resultSetMetaData.getColumnCount();
/* 1114 */           i += getVarIntLen(i2); byte b;
/* 1115 */           for (b = 0; b < i2; b++) {
/* 1116 */             i += getStringLen(resultSetMetaData.getColumnName(b + 1));
/* 1117 */             i += getVarIntLen(resultSetMetaData.getColumnType(b + 1));
/* 1118 */             i += getVarIntLen(resultSetMetaData.getPrecision(b + 1));
/* 1119 */             i += getVarIntLen(resultSetMetaData.getScale(b + 1));
/*      */           } 
/* 1121 */           while (resultSet.next()) {
/* 1122 */             i++;
/* 1123 */             for (b = 0; b < i2; b++) {
/* 1124 */               int i3 = DataType.getValueTypeFromResultSet(resultSetMetaData, b + 1);
/* 1125 */               Value value = DataType.readValue(null, resultSet, b + 1, i3);
/* 1126 */               i += getValueLen(value, paramDataHandler);
/*      */             } 
/*      */           } 
/* 1129 */           i++;
/* 1130 */           resultSet.beforeFirst();
/* 1131 */         } catch (SQLException sQLException) {
/* 1132 */           throw DbException.convert(sQLException);
/*      */         } 
/* 1134 */         return i;
/*      */     } 
/*      */     
/* 1137 */     throw DbException.throwInternalError("type=" + paramValue.getType()); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPos(int paramInt) {
/* 1147 */     this.pos = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeShortInt(int paramInt) {
/* 1157 */     byte[] arrayOfByte = this.data;
/* 1158 */     arrayOfByte[this.pos++] = (byte)(paramInt >> 8);
/* 1159 */     arrayOfByte[this.pos++] = (byte)paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short readShortInt() {
/* 1169 */     byte[] arrayOfByte = this.data;
/* 1170 */     return (short)(((arrayOfByte[this.pos++] & 0xFF) << 8) + (arrayOfByte[this.pos++] & 0xFF));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void truncate(int paramInt) {
/* 1179 */     if (this.pos > paramInt) {
/* 1180 */       byte[] arrayOfByte = new byte[paramInt];
/* 1181 */       System.arraycopy(this.data, 0, arrayOfByte, 0, paramInt);
/* 1182 */       this.pos = paramInt;
/* 1183 */       this.data = arrayOfByte;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int getVarIntLen(int paramInt) {
/* 1194 */     if ((paramInt & 0xFFFFFF80) == 0)
/* 1195 */       return 1; 
/* 1196 */     if ((paramInt & 0xFFFFC000) == 0)
/* 1197 */       return 2; 
/* 1198 */     if ((paramInt & 0xFFE00000) == 0)
/* 1199 */       return 3; 
/* 1200 */     if ((paramInt & 0xF0000000) == 0) {
/* 1201 */       return 4;
/*      */     }
/* 1203 */     return 5;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeVarInt(int paramInt) {
/* 1212 */     while ((paramInt & 0xFFFFFF80) != 0) {
/* 1213 */       this.data[this.pos++] = (byte)(0x80 | paramInt & 0x7F);
/* 1214 */       paramInt >>>= 7;
/*      */     } 
/* 1216 */     this.data[this.pos++] = (byte)paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int readVarInt() {
/* 1225 */     byte b = this.data[this.pos];
/* 1226 */     if (b >= 0) {
/* 1227 */       this.pos++;
/* 1228 */       return b;
/*      */     } 
/*      */     
/* 1231 */     return readVarIntRest(b);
/*      */   }
/*      */   
/*      */   private int readVarIntRest(int paramInt) {
/* 1235 */     int i = paramInt & 0x7F;
/* 1236 */     paramInt = this.data[this.pos + 1];
/* 1237 */     if (paramInt >= 0) {
/* 1238 */       this.pos += 2;
/* 1239 */       return i | paramInt << 7;
/*      */     } 
/* 1241 */     i |= (paramInt & 0x7F) << 7;
/* 1242 */     paramInt = this.data[this.pos + 2];
/* 1243 */     if (paramInt >= 0) {
/* 1244 */       this.pos += 3;
/* 1245 */       return i | paramInt << 14;
/*      */     } 
/* 1247 */     i |= (paramInt & 0x7F) << 14;
/* 1248 */     paramInt = this.data[this.pos + 3];
/* 1249 */     if (paramInt >= 0) {
/* 1250 */       this.pos += 4;
/* 1251 */       return i | paramInt << 21;
/*      */     } 
/* 1253 */     i |= (paramInt & 0x7F) << 21 | this.data[this.pos + 4] << 28;
/* 1254 */     this.pos += 5;
/* 1255 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getVarLongLen(long paramLong) {
/* 1265 */     byte b = 1;
/*      */     while (true) {
/* 1267 */       paramLong >>>= 7L;
/* 1268 */       if (paramLong == 0L) {
/* 1269 */         return b;
/*      */       }
/* 1271 */       b++;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeVarLong(long paramLong) {
/* 1281 */     while ((paramLong & 0xFFFFFFFFFFFFFF80L) != 0L) {
/* 1282 */       this.data[this.pos++] = (byte)(int)(paramLong & 0x7FL | 0x80L);
/* 1283 */       paramLong >>>= 7L;
/*      */     } 
/* 1285 */     this.data[this.pos++] = (byte)(int)paramLong;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long readVarLong() {
/* 1294 */     long l = this.data[this.pos++];
/* 1295 */     if (l >= 0L) {
/* 1296 */       return l;
/*      */     }
/* 1298 */     l &= 0x7FL;
/* 1299 */     for (byte b = 7;; b += 7) {
/* 1300 */       long l1 = this.data[this.pos++];
/* 1301 */       l |= (l1 & 0x7FL) << b;
/* 1302 */       if (l1 >= 0L) {
/* 1303 */         return l;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void checkCapacity(int paramInt) {
/* 1315 */     if (this.pos + paramInt >= this.data.length)
/*      */     {
/* 1317 */       expand(paramInt);
/*      */     }
/*      */   }
/*      */   
/*      */   private void expand(int paramInt) {
/* 1322 */     byte[] arrayOfByte = DataUtils.newBytes((this.data.length + paramInt) * 2);
/*      */ 
/*      */     
/* 1325 */     System.arraycopy(this.data, 0, arrayOfByte, 0, this.data.length);
/* 1326 */     this.data = arrayOfByte;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void fillAligned() {
/* 1335 */     int i = MathUtils.roundUpInt(this.pos + 2, 16);
/* 1336 */     this.pos = i;
/* 1337 */     if (this.data.length < i) {
/* 1338 */       checkCapacity(i - this.data.length);
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
/*      */   public static void copyString(Reader paramReader, OutputStream paramOutputStream) throws IOException {
/* 1350 */     char[] arrayOfChar = new char[4096];
/* 1351 */     Data data = new Data(null, new byte[12288]);
/*      */     while (true) {
/* 1353 */       int i = paramReader.read(arrayOfChar);
/* 1354 */       if (i < 0) {
/*      */         break;
/*      */       }
/* 1357 */       data.writeStringWithoutLength(arrayOfChar, i);
/* 1358 */       paramOutputStream.write(data.data, 0, data.pos);
/* 1359 */       data.reset();
/*      */     } 
/*      */   }
/*      */   
/*      */   public DataHandler getHandler() {
/* 1364 */     return this.handler;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\Data.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */