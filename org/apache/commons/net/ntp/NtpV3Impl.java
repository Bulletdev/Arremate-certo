/*     */ package org.apache.commons.net.ntp;
/*     */ 
/*     */ import java.net.DatagramPacket;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NtpV3Impl
/*     */   implements NtpV3Packet
/*     */ {
/*     */   private static final int MODE_INDEX = 0;
/*     */   private static final int MODE_SHIFT = 0;
/*     */   private static final int VERSION_INDEX = 0;
/*     */   private static final int VERSION_SHIFT = 3;
/*     */   private static final int LI_INDEX = 0;
/*     */   private static final int LI_SHIFT = 6;
/*     */   private static final int STRATUM_INDEX = 1;
/*     */   private static final int POLL_INDEX = 2;
/*     */   private static final int PRECISION_INDEX = 3;
/*     */   private static final int ROOT_DELAY_INDEX = 4;
/*     */   private static final int ROOT_DISPERSION_INDEX = 8;
/*     */   private static final int REFERENCE_ID_INDEX = 12;
/*     */   private static final int REFERENCE_TIMESTAMP_INDEX = 16;
/*     */   private static final int ORIGINATE_TIMESTAMP_INDEX = 24;
/*     */   private static final int RECEIVE_TIMESTAMP_INDEX = 32;
/*     */   private static final int TRANSMIT_TIMESTAMP_INDEX = 40;
/*  54 */   private final byte[] buf = new byte[48];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private volatile DatagramPacket dp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMode() {
/*  72 */     return ui(this.buf[0]) >> 0 & 0x7;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getModeName() {
/*  83 */     return NtpUtils.getModeName(getMode());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMode(int paramInt) {
/*  94 */     this.buf[0] = (byte)(this.buf[0] & 0xF8 | paramInt & 0x7);
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
/*     */   public int getLeapIndicator() {
/* 109 */     return ui(this.buf[0]) >> 6 & 0x3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLeapIndicator(int paramInt) {
/* 120 */     this.buf[0] = (byte)(this.buf[0] & 0x3F | (paramInt & 0x3) << 6);
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
/*     */   public int getPoll() {
/* 135 */     return this.buf[2];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPoll(int paramInt) {
/* 146 */     this.buf[2] = (byte)(paramInt & 0xFF);
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
/*     */   public int getPrecision() {
/* 159 */     return this.buf[3];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrecision(int paramInt) {
/* 170 */     this.buf[3] = (byte)(paramInt & 0xFF);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getVersion() {
/* 181 */     return ui(this.buf[0]) >> 3 & 0x7;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVersion(int paramInt) {
/* 192 */     this.buf[0] = (byte)(this.buf[0] & 0xC7 | (paramInt & 0x7) << 3);
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
/*     */   public int getStratum() {
/* 205 */     return ui(this.buf[1]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStratum(int paramInt) {
/* 216 */     this.buf[1] = (byte)(paramInt & 0xFF);
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
/*     */   public int getRootDelay() {
/* 229 */     return getInt(4);
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
/*     */   public void setRootDelay(int paramInt) {
/* 241 */     setInt(4, paramInt);
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
/*     */   public double getRootDelayInMillisDouble() {
/* 255 */     double d = getRootDelay();
/* 256 */     return d / 65.536D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRootDispersion() {
/* 266 */     return getInt(8);
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
/*     */   public void setRootDispersion(int paramInt) {
/* 278 */     setInt(8, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRootDispersionInMillis() {
/* 289 */     long l = getRootDispersion();
/* 290 */     return l * 1000L / 65536L;
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
/*     */   public double getRootDispersionInMillisDouble() {
/* 302 */     double d = getRootDispersion();
/* 303 */     return d / 65.536D;
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
/*     */   public void setReferenceId(int paramInt) {
/* 315 */     setInt(12, paramInt);
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
/*     */   public int getReferenceId() {
/* 327 */     return getInt(12);
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
/*     */   public String getReferenceIdString() {
/* 341 */     int i = getVersion();
/* 342 */     int j = getStratum();
/* 343 */     if (i == 3 || i == 4) {
/* 344 */       if (j == 0 || j == 1) {
/* 345 */         return idAsString();
/*     */       }
/*     */       
/* 348 */       if (i == 4) {
/* 349 */         return idAsHex();
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 355 */     if (j >= 2) {
/* 356 */       return idAsIPAddress();
/*     */     }
/* 358 */     return idAsHex();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String idAsIPAddress() {
/* 367 */     return ui(this.buf[12]) + "." + 
/* 368 */       ui(this.buf[13]) + "." + 
/* 369 */       ui(this.buf[14]) + "." + 
/* 370 */       ui(this.buf[15]);
/*     */   }
/*     */ 
/*     */   
/*     */   private String idAsString() {
/* 375 */     StringBuilder stringBuilder = new StringBuilder();
/* 376 */     for (byte b = 0; b <= 3; b++) {
/* 377 */       char c = (char)this.buf[12 + b];
/* 378 */       if (c == '\000') {
/*     */         break;
/*     */       }
/* 381 */       stringBuilder.append(c);
/*     */     } 
/* 383 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private String idAsHex() {
/* 388 */     return Integer.toHexString(getReferenceId());
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
/*     */   public TimeStamp getTransmitTimeStamp() {
/* 400 */     return getTimestamp(40);
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
/*     */   public void setTransmitTime(TimeStamp paramTimeStamp) {
/* 412 */     setTimestamp(40, paramTimeStamp);
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
/*     */   public void setOriginateTimeStamp(TimeStamp paramTimeStamp) {
/* 424 */     setTimestamp(24, paramTimeStamp);
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
/*     */   public TimeStamp getOriginateTimeStamp() {
/* 436 */     return getTimestamp(24);
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
/*     */   public TimeStamp getReferenceTimeStamp() {
/* 448 */     return getTimestamp(16);
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
/*     */   public void setReferenceTime(TimeStamp paramTimeStamp) {
/* 460 */     setTimestamp(16, paramTimeStamp);
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
/*     */   public TimeStamp getReceiveTimeStamp() {
/* 472 */     return getTimestamp(32);
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
/*     */   public void setReceiveTimeStamp(TimeStamp paramTimeStamp) {
/* 484 */     setTimestamp(32, paramTimeStamp);
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
/*     */   public String getType() {
/* 496 */     return "NTP";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int getInt(int paramInt) {
/* 507 */     return ui(this.buf[paramInt]) << 24 | ui(this.buf[paramInt + 1]) << 16 | ui(this.buf[paramInt + 2]) << 8 | ui(this.buf[paramInt + 3]);
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
/*     */   private void setInt(int paramInt1, int paramInt2) {
/* 520 */     for (byte b = 3; b >= 0; b--) {
/* 521 */       this.buf[paramInt1 + b] = (byte)(paramInt2 & 0xFF);
/* 522 */       paramInt2 >>>= 8;
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
/*     */   private TimeStamp getTimestamp(int paramInt) {
/* 534 */     return new TimeStamp(getLong(paramInt));
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
/*     */   private long getLong(int paramInt) {
/* 551 */     return ul(this.buf[paramInt]) << 56L | ul(this.buf[paramInt + 1]) << 48L | ul(this.buf[paramInt + 2]) << 40L | ul(this.buf[paramInt + 3]) << 32L | ul(this.buf[paramInt + 4]) << 24L | ul(this.buf[paramInt + 5]) << 16L | ul(this.buf[paramInt + 6]) << 8L | ul(this.buf[paramInt + 7]);
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
/*     */   private void setTimestamp(int paramInt, TimeStamp paramTimeStamp) {
/* 563 */     long l = (paramTimeStamp == null) ? 0L : paramTimeStamp.ntpValue();
/*     */ 
/*     */     
/* 566 */     for (byte b = 7; b >= 0; b--) {
/* 567 */       this.buf[paramInt + b] = (byte)(int)(l & 0xFFL);
/* 568 */       l >>>= 8L;
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
/*     */   public synchronized DatagramPacket getDatagramPacket() {
/* 581 */     if (this.dp == null) {
/* 582 */       this.dp = new DatagramPacket(this.buf, this.buf.length);
/* 583 */       this.dp.setPort(123);
/*     */     } 
/* 585 */     return this.dp;
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
/*     */   public void setDatagramPacket(DatagramPacket paramDatagramPacket) {
/* 597 */     if (paramDatagramPacket == null || paramDatagramPacket.getLength() < this.buf.length) {
/* 598 */       throw new IllegalArgumentException();
/*     */     }
/* 600 */     byte[] arrayOfByte = paramDatagramPacket.getData();
/* 601 */     int i = paramDatagramPacket.getLength();
/* 602 */     if (i > this.buf.length) {
/* 603 */       i = this.buf.length;
/*     */     }
/* 605 */     System.arraycopy(arrayOfByte, 0, this.buf, 0, i);
/* 606 */     DatagramPacket datagramPacket = getDatagramPacket();
/* 607 */     datagramPacket.setAddress(paramDatagramPacket.getAddress());
/* 608 */     int j = paramDatagramPacket.getPort();
/* 609 */     datagramPacket.setPort((j > 0) ? j : 123);
/* 610 */     datagramPacket.setData(this.buf);
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
/*     */   public boolean equals(Object paramObject) {
/* 627 */     if (this == paramObject) {
/* 628 */       return true;
/*     */     }
/* 630 */     if (paramObject == null || getClass() != paramObject.getClass()) {
/* 631 */       return false;
/*     */     }
/* 633 */     NtpV3Impl ntpV3Impl = (NtpV3Impl)paramObject;
/* 634 */     return Arrays.equals(this.buf, ntpV3Impl.buf);
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
/*     */   public int hashCode() {
/* 647 */     return Arrays.hashCode(this.buf);
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
/*     */   protected static final int ui(byte paramByte) {
/* 660 */     return paramByte & 0xFF;
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
/*     */   protected static final long ul(byte paramByte) {
/* 674 */     return (paramByte & 0xFF);
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
/* 686 */     return "[version:" + 
/* 687 */       getVersion() + ", mode:" + 
/* 688 */       getMode() + ", poll:" + 
/* 689 */       getPoll() + ", precision:" + 
/* 690 */       getPrecision() + ", delay:" + 
/* 691 */       getRootDelay() + ", dispersion(ms):" + 
/* 692 */       getRootDispersionInMillisDouble() + ", id:" + 
/* 693 */       getReferenceIdString() + ", xmitTime:" + 
/* 694 */       getTransmitTimeStamp().toDateString() + " ]";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ntp\NtpV3Impl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */