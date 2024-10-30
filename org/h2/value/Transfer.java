/*     */ package org.h2.value;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.math.BigDecimal;
/*     */ import java.net.InetAddress;
/*     */ import java.net.Socket;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Timestamp;
/*     */ import org.h2.engine.Constants;
/*     */ import org.h2.engine.SessionInterface;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.mvstore.DataUtils;
/*     */ import org.h2.security.SHA256;
/*     */ import org.h2.store.Data;
/*     */ import org.h2.store.DataReader;
/*     */ import org.h2.tools.SimpleResultSet;
/*     */ import org.h2.util.DateTimeUtils;
/*     */ import org.h2.util.IOUtils;
/*     */ import org.h2.util.JdbcUtils;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.util.NetUtils;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.util.Utils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Transfer
/*     */ {
/*     */   private static final int BUFFER_SIZE = 65536;
/*     */   private static final int LOB_MAGIC = 4660;
/*     */   private static final int LOB_MAC_SALT_LENGTH = 16;
/*     */   private Socket socket;
/*     */   private DataInputStream in;
/*     */   private DataOutputStream out;
/*     */   private SessionInterface session;
/*     */   private boolean ssl;
/*     */   private int version;
/*     */   private byte[] lobMacSalt;
/*     */   
/*     */   public Transfer(SessionInterface paramSessionInterface) {
/*  62 */     this.session = paramSessionInterface;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSocket(Socket paramSocket) {
/*  71 */     this.socket = paramSocket;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void init() throws IOException {
/*  79 */     if (this.socket != null) {
/*  80 */       this.in = new DataInputStream(new BufferedInputStream(this.socket.getInputStream(), 65536));
/*     */ 
/*     */       
/*  83 */       this.out = new DataOutputStream(new BufferedOutputStream(this.socket.getOutputStream(), 65536));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {
/*  93 */     this.out.flush();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Transfer writeBoolean(boolean paramBoolean) throws IOException {
/* 103 */     this.out.writeByte((byte)(paramBoolean ? 1 : 0));
/* 104 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean readBoolean() throws IOException {
/* 113 */     return (this.in.readByte() == 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Transfer writeByte(byte paramByte) throws IOException {
/* 123 */     this.out.writeByte(paramByte);
/* 124 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private byte readByte() throws IOException {
/* 133 */     return this.in.readByte();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Transfer writeInt(int paramInt) throws IOException {
/* 143 */     this.out.writeInt(paramInt);
/* 144 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int readInt() throws IOException {
/* 153 */     return this.in.readInt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Transfer writeLong(long paramLong) throws IOException {
/* 163 */     this.out.writeLong(paramLong);
/* 164 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long readLong() throws IOException {
/* 173 */     return this.in.readLong();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Transfer writeDouble(double paramDouble) throws IOException {
/* 183 */     this.out.writeDouble(paramDouble);
/* 184 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Transfer writeFloat(float paramFloat) throws IOException {
/* 194 */     this.out.writeFloat(paramFloat);
/* 195 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double readDouble() throws IOException {
/* 204 */     return this.in.readDouble();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private float readFloat() throws IOException {
/* 213 */     return this.in.readFloat();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Transfer writeString(String paramString) throws IOException {
/* 223 */     if (paramString == null) {
/* 224 */       this.out.writeInt(-1);
/*     */     } else {
/* 226 */       int i = paramString.length();
/* 227 */       this.out.writeInt(i);
/* 228 */       for (byte b = 0; b < i; b++) {
/* 229 */         this.out.writeChar(paramString.charAt(b));
/*     */       }
/*     */     } 
/* 232 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String readString() throws IOException {
/* 241 */     int i = this.in.readInt();
/* 242 */     if (i == -1) {
/* 243 */       return null;
/*     */     }
/* 245 */     StringBuilder stringBuilder = new StringBuilder(i);
/* 246 */     for (byte b = 0; b < i; b++) {
/* 247 */       stringBuilder.append(this.in.readChar());
/*     */     }
/* 249 */     String str = stringBuilder.toString();
/* 250 */     str = StringUtils.cache(str);
/* 251 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Transfer writeBytes(byte[] paramArrayOfbyte) throws IOException {
/* 261 */     if (paramArrayOfbyte == null) {
/* 262 */       writeInt(-1);
/*     */     } else {
/* 264 */       writeInt(paramArrayOfbyte.length);
/* 265 */       this.out.write(paramArrayOfbyte);
/*     */     } 
/* 267 */     return this;
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
/*     */   public Transfer writeBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 279 */     this.out.write(paramArrayOfbyte, paramInt1, paramInt2);
/* 280 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] readBytes() throws IOException {
/* 289 */     int i = readInt();
/* 290 */     if (i == -1) {
/* 291 */       return null;
/*     */     }
/* 293 */     byte[] arrayOfByte = DataUtils.newBytes(i);
/* 294 */     this.in.readFully(arrayOfByte);
/* 295 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 306 */     this.in.readFully(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void close() {
/* 313 */     if (this.socket != null)
/*     */       try {
/* 315 */         if (this.out != null) {
/* 316 */           this.out.flush();
/*     */         }
/* 318 */         if (this.socket != null) {
/* 319 */           this.socket.close();
/*     */         }
/* 321 */       } catch (IOException iOException) {
/* 322 */         DbException.traceThrowable(iOException);
/*     */       } finally {
/* 324 */         this.socket = null;
/*     */       }   } public void writeValue(Value paramValue) throws IOException {
/*     */     ValueUuid valueUuid;
/*     */     ValueTimestampTimeZone valueTimestampTimeZone;
/*     */     long l1;
/*     */     ValueArray valueArray;
/*     */     Value[] arrayOfValue;
/*     */     long l2;
/*     */     Reader reader;
/*     */     int j;
/*     */     Class<?> clazz;
/* 335 */     int i = paramValue.getType();
/* 336 */     writeInt(i);
/* 337 */     switch (i) {
/*     */       case 0:
/*     */         return;
/*     */       case 12:
/*     */       case 19:
/* 342 */         writeBytes(paramValue.getBytesNoCopy());
/*     */       
/*     */       case 20:
/* 345 */         valueUuid = (ValueUuid)paramValue;
/* 346 */         writeLong(valueUuid.getHigh());
/* 347 */         writeLong(valueUuid.getLow());
/*     */ 
/*     */       
/*     */       case 1:
/* 351 */         writeBoolean(paramValue.getBoolean().booleanValue());
/*     */       
/*     */       case 2:
/* 354 */         writeByte(paramValue.getByte());
/*     */       
/*     */       case 9:
/* 357 */         if (this.version >= 9) {
/* 358 */           writeLong(((ValueTime)paramValue).getNanos());
/* 359 */         } else if (this.version >= 7) {
/* 360 */           writeLong(DateTimeUtils.getTimeLocalWithoutDst(paramValue.getTime()));
/*     */         } else {
/* 362 */           writeLong(paramValue.getTime().getTime());
/*     */         } 
/*     */       
/*     */       case 10:
/* 366 */         if (this.version >= 9) {
/* 367 */           writeLong(((ValueDate)paramValue).getDateValue());
/* 368 */         } else if (this.version >= 7) {
/* 369 */           writeLong(DateTimeUtils.getTimeLocalWithoutDst(paramValue.getDate()));
/*     */         } else {
/* 371 */           writeLong(paramValue.getDate().getTime());
/*     */         } 
/*     */       
/*     */       case 11:
/* 375 */         if (this.version >= 9) {
/* 376 */           ValueTimestamp valueTimestamp = (ValueTimestamp)paramValue;
/* 377 */           writeLong(valueTimestamp.getDateValue());
/* 378 */           writeLong(valueTimestamp.getTimeNanos());
/* 379 */         } else if (this.version >= 7) {
/* 380 */           Timestamp timestamp = paramValue.getTimestamp();
/* 381 */           writeLong(DateTimeUtils.getTimeLocalWithoutDst(timestamp));
/* 382 */           writeInt(timestamp.getNanos() % 1000000);
/*     */         } else {
/* 384 */           Timestamp timestamp = paramValue.getTimestamp();
/* 385 */           writeLong(timestamp.getTime());
/* 386 */           writeInt(timestamp.getNanos() % 1000000);
/*     */         } 
/*     */ 
/*     */       
/*     */       case 24:
/* 391 */         valueTimestampTimeZone = (ValueTimestampTimeZone)paramValue;
/* 392 */         writeLong(valueTimestampTimeZone.getDateValue());
/* 393 */         writeLong(valueTimestampTimeZone.getTimeNanos());
/* 394 */         writeInt(valueTimestampTimeZone.getTimeZoneOffsetMins());
/*     */ 
/*     */       
/*     */       case 6:
/* 398 */         writeString(paramValue.getString());
/*     */       
/*     */       case 7:
/* 401 */         writeDouble(paramValue.getDouble());
/*     */       
/*     */       case 8:
/* 404 */         writeFloat(paramValue.getFloat());
/*     */       
/*     */       case 4:
/* 407 */         writeInt(paramValue.getInt());
/*     */       
/*     */       case 5:
/* 410 */         writeLong(paramValue.getLong());
/*     */       
/*     */       case 3:
/* 413 */         writeInt(paramValue.getShort());
/*     */       
/*     */       case 13:
/*     */       case 14:
/*     */       case 21:
/* 418 */         writeString(paramValue.getString());
/*     */       
/*     */       case 15:
/* 421 */         if (this.version >= 11 && 
/* 422 */           paramValue instanceof ValueLobDb) {
/* 423 */           ValueLobDb valueLobDb = (ValueLobDb)paramValue;
/* 424 */           if (valueLobDb.isStored()) {
/* 425 */             writeLong(-1L);
/* 426 */             writeInt(valueLobDb.getTableId());
/* 427 */             writeLong(valueLobDb.getLobId());
/* 428 */             if (this.version >= 12) {
/* 429 */               writeBytes(calculateLobMac(valueLobDb.getLobId()));
/*     */             }
/* 431 */             writeLong(valueLobDb.getPrecision());
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 436 */         l1 = paramValue.getPrecision();
/* 437 */         if (l1 < 0L) {
/* 438 */           throw DbException.get(90067, "length=" + l1);
/*     */         }
/*     */         
/* 441 */         writeLong(l1);
/* 442 */         l2 = IOUtils.copyAndCloseInput(paramValue.getInputStream(), this.out);
/* 443 */         if (l2 != l1) {
/* 444 */           throw DbException.get(90067, "length:" + l1 + " written:" + l2);
/*     */         }
/*     */         
/* 447 */         writeInt(4660);
/*     */ 
/*     */       
/*     */       case 16:
/* 451 */         if (this.version >= 11 && 
/* 452 */           paramValue instanceof ValueLobDb) {
/* 453 */           ValueLobDb valueLobDb = (ValueLobDb)paramValue;
/* 454 */           if (valueLobDb.isStored()) {
/* 455 */             writeLong(-1L);
/* 456 */             writeInt(valueLobDb.getTableId());
/* 457 */             writeLong(valueLobDb.getLobId());
/* 458 */             if (this.version >= 12) {
/* 459 */               writeBytes(calculateLobMac(valueLobDb.getLobId()));
/*     */             }
/* 461 */             writeLong(valueLobDb.getPrecision());
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 466 */         l1 = paramValue.getPrecision();
/* 467 */         if (l1 < 0L) {
/* 468 */           throw DbException.get(90067, "length=" + l1);
/*     */         }
/*     */         
/* 471 */         if (l1 > 2147483647L) {
/* 472 */           throw DbException.get(90067, "length=" + l1);
/*     */         }
/*     */         
/* 475 */         writeLong(l1);
/* 476 */         reader = paramValue.getReader();
/* 477 */         Data.copyString(reader, this.out);
/* 478 */         writeInt(4660);
/*     */ 
/*     */       
/*     */       case 17:
/* 482 */         valueArray = (ValueArray)paramValue;
/* 483 */         arrayOfValue = valueArray.getList();
/* 484 */         j = arrayOfValue.length;
/* 485 */         clazz = valueArray.getComponentType();
/* 486 */         if (clazz == Object.class) {
/* 487 */           writeInt(j);
/*     */         } else {
/* 489 */           writeInt(-(j + 1));
/* 490 */           writeString(clazz.getName());
/*     */         } 
/* 492 */         for (Value value : arrayOfValue) {
/* 493 */           writeValue(value);
/*     */         }
/*     */ 
/*     */       
/*     */       case 18:
/*     */         try {
/* 499 */           ResultSet resultSet = ((ValueResultSet)paramValue).getResultSet();
/* 500 */           resultSet.beforeFirst();
/* 501 */           ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
/* 502 */           j = resultSetMetaData.getColumnCount();
/* 503 */           writeInt(j); byte b;
/* 504 */           for (b = 0; b < j; b++) {
/* 505 */             writeString(resultSetMetaData.getColumnName(b + 1));
/* 506 */             writeInt(resultSetMetaData.getColumnType(b + 1));
/* 507 */             writeInt(resultSetMetaData.getPrecision(b + 1));
/* 508 */             writeInt(resultSetMetaData.getScale(b + 1));
/*     */           } 
/* 510 */           while (resultSet.next()) {
/* 511 */             writeBoolean(true);
/* 512 */             for (b = 0; b < j; b++) {
/* 513 */               int k = DataType.getValueTypeFromResultSet(resultSetMetaData, b + 1);
/* 514 */               Value value = DataType.readValue(this.session, resultSet, b + 1, k);
/* 515 */               writeValue(value);
/*     */             } 
/*     */           } 
/* 518 */           writeBoolean(false);
/* 519 */           resultSet.beforeFirst();
/* 520 */         } catch (SQLException sQLException) {
/* 521 */           throw DbException.convertToIOException(sQLException);
/*     */         } 
/*     */ 
/*     */       
/*     */       case 22:
/* 526 */         if (this.version >= 14) {
/* 527 */           writeBytes(paramValue.getBytesNoCopy());
/*     */         } else {
/* 529 */           writeString(paramValue.getString());
/*     */         } 
/*     */     } 
/*     */     
/* 533 */     throw DbException.get(90067, "type=" + i);
/*     */   }
/*     */   public Value readValue() throws IOException {
/*     */     long l;
/*     */     int j;
/*     */     SimpleResultSet simpleResultSet;
/*     */     Class<Object> clazz;
/*     */     int k;
/*     */     Value value, arrayOfValue[];
/*     */     byte b;
/* 543 */     int m, i = readInt();
/* 544 */     switch (i) {
/*     */       case 0:
/* 546 */         return ValueNull.INSTANCE;
/*     */       case 12:
/* 548 */         return ValueBytes.getNoCopy(readBytes());
/*     */       case 20:
/* 550 */         return ValueUuid.get(readLong(), readLong());
/*     */       case 19:
/* 552 */         return ValueJavaObject.getNoCopy(null, readBytes(), this.session.getDataHandler());
/*     */       case 1:
/* 554 */         return ValueBoolean.get(readBoolean());
/*     */       case 2:
/* 556 */         return ValueByte.get(readByte());
/*     */       case 10:
/* 558 */         if (this.version >= 9)
/* 559 */           return ValueDate.fromDateValue(readLong()); 
/* 560 */         if (this.version >= 7) {
/* 561 */           return ValueDate.fromMillis(DateTimeUtils.getTimeUTCWithoutDst(readLong()));
/*     */         }
/* 563 */         return ValueDate.fromMillis(readLong());
/*     */       case 9:
/* 565 */         if (this.version >= 9)
/* 566 */           return ValueTime.fromNanos(readLong()); 
/* 567 */         if (this.version >= 7) {
/* 568 */           return ValueTime.fromMillis(DateTimeUtils.getTimeUTCWithoutDst(readLong()));
/*     */         }
/* 570 */         return ValueTime.fromMillis(readLong());
/*     */       case 11:
/* 572 */         if (this.version >= 9) {
/* 573 */           return ValueTimestamp.fromDateValueAndNanos(readLong(), readLong());
/*     */         }
/* 575 */         if (this.version >= 7) {
/* 576 */           return ValueTimestamp.fromMillisNanos(DateTimeUtils.getTimeUTCWithoutDst(readLong()), readInt() % 1000000);
/*     */         }
/*     */ 
/*     */         
/* 580 */         return ValueTimestamp.fromMillisNanos(readLong(), readInt() % 1000000);
/*     */ 
/*     */       
/*     */       case 24:
/* 584 */         return ValueTimestampTimeZone.fromDateValueAndNanos(readLong(), readLong(), (short)readInt());
/*     */ 
/*     */       
/*     */       case 6:
/* 588 */         return ValueDecimal.get(new BigDecimal(readString()));
/*     */       case 7:
/* 590 */         return ValueDouble.get(readDouble());
/*     */       case 8:
/* 592 */         return ValueFloat.get(readFloat());
/*     */       case 4:
/* 594 */         return ValueInt.get(readInt());
/*     */       case 5:
/* 596 */         return ValueLong.get(readLong());
/*     */       case 3:
/* 598 */         return ValueShort.get((short)readInt());
/*     */       case 13:
/* 600 */         return ValueString.get(readString());
/*     */       case 14:
/* 602 */         return ValueStringIgnoreCase.get(readString());
/*     */       case 21:
/* 604 */         return ValueStringFixed.get(readString());
/*     */       case 15:
/* 606 */         l = readLong();
/* 607 */         if (this.version >= 11 && 
/* 608 */           l == -1L) {
/* 609 */           byte[] arrayOfByte; int n = readInt();
/* 610 */           long l1 = readLong();
/*     */           
/* 612 */           if (this.version >= 12) {
/* 613 */             arrayOfByte = readBytes();
/*     */           } else {
/* 615 */             arrayOfByte = null;
/*     */           } 
/* 617 */           long l2 = readLong();
/* 618 */           return ValueLobDb.create(15, this.session.getDataHandler(), n, l1, arrayOfByte, l2);
/*     */         } 
/*     */ 
/*     */         
/* 622 */         value = this.session.getDataHandler().getLobStorage().createBlob(this.in, l);
/* 623 */         m = readInt();
/* 624 */         if (m != 4660) {
/* 625 */           throw DbException.get(90067, "magic=" + m);
/*     */         }
/*     */         
/* 628 */         return value;
/*     */       
/*     */       case 16:
/* 631 */         l = readLong();
/* 632 */         if (this.version >= 11) {
/* 633 */           if (l == -1L) {
/* 634 */             byte[] arrayOfByte1; int i1 = readInt();
/* 635 */             long l1 = readLong();
/*     */             
/* 637 */             if (this.version >= 12) {
/* 638 */               arrayOfByte1 = readBytes();
/*     */             } else {
/* 640 */               arrayOfByte1 = null;
/*     */             } 
/* 642 */             long l2 = readLong();
/* 643 */             return ValueLobDb.create(16, this.session.getDataHandler(), i1, l1, arrayOfByte1, l2);
/*     */           } 
/*     */           
/* 646 */           if (l < 0L || l > 2147483647L) {
/* 647 */             throw DbException.get(90067, "length=" + l);
/*     */           }
/*     */           
/* 650 */           DataReader dataReader = new DataReader(this.in);
/* 651 */           m = (int)l;
/* 652 */           char[] arrayOfChar = new char[m];
/* 653 */           IOUtils.readFully((Reader)dataReader, arrayOfChar, m);
/* 654 */           int n = readInt();
/* 655 */           if (n != 4660) {
/* 656 */             throw DbException.get(90067, "magic=" + n);
/*     */           }
/*     */           
/* 659 */           byte[] arrayOfByte = (new String(arrayOfChar)).getBytes(Constants.UTF8);
/* 660 */           return ValueLobDb.createSmallLob(16, arrayOfByte, l);
/*     */         } 
/* 662 */         value = this.session.getDataHandler().getLobStorage().createClob((Reader)new DataReader(this.in), l);
/*     */         
/* 664 */         m = readInt();
/* 665 */         if (m != 4660) {
/* 666 */           throw DbException.get(90067, "magic=" + m);
/*     */         }
/*     */         
/* 669 */         return value;
/*     */       
/*     */       case 17:
/* 672 */         j = readInt();
/* 673 */         clazz = Object.class;
/* 674 */         if (j < 0) {
/* 675 */           j = -(j + 1);
/* 676 */           clazz = JdbcUtils.loadUserClass(readString());
/*     */         } 
/* 678 */         arrayOfValue = new Value[j];
/* 679 */         for (m = 0; m < j; m++) {
/* 680 */           arrayOfValue[m] = readValue();
/*     */         }
/* 682 */         return ValueArray.get(clazz, arrayOfValue);
/*     */       
/*     */       case 18:
/* 685 */         simpleResultSet = new SimpleResultSet();
/* 686 */         simpleResultSet.setAutoClose(false);
/* 687 */         k = readInt();
/* 688 */         for (b = 0; b < k; b++) {
/* 689 */           simpleResultSet.addColumn(readString(), readInt(), readInt(), readInt());
/*     */         }
/*     */         
/* 692 */         while (readBoolean()) {
/*     */ 
/*     */           
/* 695 */           Object[] arrayOfObject = new Object[k];
/* 696 */           for (m = 0; m < k; m++) {
/* 697 */             arrayOfObject[m] = readValue().getObject();
/*     */           }
/* 699 */           simpleResultSet.addRow(arrayOfObject);
/*     */         } 
/* 701 */         return ValueResultSet.get((ResultSet)simpleResultSet);
/*     */       
/*     */       case 22:
/* 704 */         if (this.version >= 14) {
/* 705 */           return ValueGeometry.get(readBytes());
/*     */         }
/* 707 */         return ValueGeometry.get(readString());
/*     */     } 
/* 709 */     throw DbException.get(90067, "type=" + i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Socket getSocket() {
/* 719 */     return this.socket;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSession(SessionInterface paramSessionInterface) {
/* 728 */     this.session = paramSessionInterface;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSSL(boolean paramBoolean) {
/* 737 */     this.ssl = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Transfer openNewConnection() throws IOException {
/* 746 */     InetAddress inetAddress = this.socket.getInetAddress();
/* 747 */     int i = this.socket.getPort();
/* 748 */     Socket socket = NetUtils.createSocket(inetAddress, i, this.ssl);
/* 749 */     Transfer transfer = new Transfer(null);
/* 750 */     transfer.setSocket(socket);
/* 751 */     transfer.setSSL(this.ssl);
/* 752 */     return transfer;
/*     */   }
/*     */   
/*     */   public void setVersion(int paramInt) {
/* 756 */     this.version = paramInt;
/*     */   }
/*     */   
/*     */   public synchronized boolean isClosed() {
/* 760 */     return (this.socket == null || this.socket.isClosed());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void verifyLobMac(byte[] paramArrayOfbyte, long paramLong) {
/* 771 */     byte[] arrayOfByte = calculateLobMac(paramLong);
/* 772 */     if (!Utils.compareSecure(paramArrayOfbyte, arrayOfByte)) {
/* 773 */       throw DbException.get(90067, "Invalid lob hmac; possibly the connection was re-opened internally");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private byte[] calculateLobMac(long paramLong) {
/* 779 */     if (this.lobMacSalt == null) {
/* 780 */       this.lobMacSalt = MathUtils.secureRandomBytes(16);
/*     */     }
/* 782 */     byte[] arrayOfByte = new byte[8];
/* 783 */     Utils.writeLong(arrayOfByte, 0, paramLong);
/* 784 */     return SHA256.getHashWithSalt(arrayOfByte, this.lobMacSalt);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\Transfer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */