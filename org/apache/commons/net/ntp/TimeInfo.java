/*     */ package org.apache.commons.net.ntp;
/*     */ 
/*     */ import java.net.DatagramPacket;
/*     */ import java.net.InetAddress;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TimeInfo
/*     */ {
/*     */   private final NtpV3Packet message;
/*     */   private List<String> comments;
/*     */   private Long delayMillis;
/*     */   private Long offsetMillis;
/*     */   private final long returnTimeMillis;
/*     */   private boolean detailsComputed;
/*     */   
/*     */   public TimeInfo(NtpV3Packet paramNtpV3Packet, long paramLong) {
/*  54 */     this(paramNtpV3Packet, paramLong, null, true);
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
/*     */   public TimeInfo(NtpV3Packet paramNtpV3Packet, long paramLong, List<String> paramList) {
/*  67 */     this(paramNtpV3Packet, paramLong, paramList, true);
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
/*     */   public TimeInfo(NtpV3Packet paramNtpV3Packet, long paramLong, boolean paramBoolean) {
/*  83 */     this(paramNtpV3Packet, paramLong, null, paramBoolean);
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
/*     */   public TimeInfo(NtpV3Packet paramNtpV3Packet, long paramLong, List<String> paramList, boolean paramBoolean) {
/* 101 */     if (paramNtpV3Packet == null) {
/* 102 */       throw new IllegalArgumentException("message cannot be null");
/*     */     }
/* 104 */     this.returnTimeMillis = paramLong;
/* 105 */     this.message = paramNtpV3Packet;
/* 106 */     this.comments = paramList;
/* 107 */     if (paramBoolean) {
/* 108 */       computeDetails();
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
/*     */   public void addComment(String paramString) {
/* 121 */     if (this.comments == null) {
/* 122 */       this.comments = new ArrayList<>();
/*     */     }
/* 124 */     this.comments.add(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void computeDetails() {
/* 133 */     if (this.detailsComputed) {
/*     */       return;
/*     */     }
/* 136 */     this.detailsComputed = true;
/* 137 */     if (this.comments == null) {
/* 138 */       this.comments = new ArrayList<>();
/*     */     }
/*     */     
/* 141 */     TimeStamp timeStamp1 = this.message.getOriginateTimeStamp();
/* 142 */     long l1 = timeStamp1.getTime();
/*     */ 
/*     */     
/* 145 */     TimeStamp timeStamp2 = this.message.getReceiveTimeStamp();
/* 146 */     long l2 = timeStamp2.getTime();
/*     */ 
/*     */     
/* 149 */     TimeStamp timeStamp3 = this.message.getTransmitTimeStamp();
/* 150 */     long l3 = timeStamp3.getTime();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 168 */     if (timeStamp1.ntpValue() == 0L) {
/*     */ 
/*     */ 
/*     */       
/* 172 */       if (timeStamp3.ntpValue() != 0L) {
/*     */         
/* 174 */         this.offsetMillis = Long.valueOf(l3 - this.returnTimeMillis);
/* 175 */         this.comments.add("Error: zero orig time -- cannot compute delay");
/*     */       } else {
/* 177 */         this.comments.add("Error: zero orig time -- cannot compute delay/offset");
/*     */       } 
/* 179 */     } else if (timeStamp2.ntpValue() == 0L || timeStamp3.ntpValue() == 0L) {
/* 180 */       this.comments.add("Warning: zero rcvNtpTime or xmitNtpTime");
/*     */       
/* 182 */       if (l1 > this.returnTimeMillis) {
/* 183 */         this.comments.add("Error: OrigTime > DestRcvTime");
/*     */       }
/*     */       else {
/*     */         
/* 187 */         this.delayMillis = Long.valueOf(this.returnTimeMillis - l1);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 193 */       if (timeStamp2.ntpValue() != 0L) {
/*     */ 
/*     */         
/* 196 */         this.offsetMillis = Long.valueOf(l2 - l1);
/* 197 */       } else if (timeStamp3.ntpValue() != 0L) {
/*     */ 
/*     */         
/* 200 */         this.offsetMillis = Long.valueOf(l3 - this.returnTimeMillis);
/*     */       } 
/*     */     } else {
/*     */       
/* 204 */       long l = this.returnTimeMillis - l1;
/*     */       
/* 206 */       if (l3 < l2) {
/*     */ 
/*     */         
/* 209 */         this.comments.add("Error: xmitTime < rcvTime");
/*     */       }
/*     */       else {
/*     */         
/* 213 */         long l4 = l3 - l2;
/*     */ 
/*     */         
/* 216 */         if (l4 <= l) {
/*     */           
/* 218 */           l -= l4;
/*     */ 
/*     */ 
/*     */         
/*     */         }
/* 223 */         else if (l4 - l == 1L) {
/*     */ 
/*     */           
/* 226 */           if (l != 0L) {
/*     */             
/* 228 */             this.comments.add("Info: processing time > total network time by 1 ms -> assume zero delay");
/* 229 */             l = 0L;
/*     */           } 
/*     */         } else {
/* 232 */           this.comments.add("Warning: processing time > total network time");
/*     */         } 
/*     */       } 
/*     */       
/* 236 */       this.delayMillis = Long.valueOf(l);
/* 237 */       if (l1 > this.returnTimeMillis) {
/* 238 */         this.comments.add("Error: OrigTime > DestRcvTime");
/*     */       }
/*     */       
/* 241 */       this.offsetMillis = Long.valueOf((l2 - l1 + l3 - this.returnTimeMillis) / 2L);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getComments() {
/* 252 */     return this.comments;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getDelay() {
/* 262 */     return this.delayMillis;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getOffset() {
/* 273 */     return this.offsetMillis;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NtpV3Packet getMessage() {
/* 283 */     return this.message;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InetAddress getAddress() {
/* 292 */     DatagramPacket datagramPacket = this.message.getDatagramPacket();
/* 293 */     return (datagramPacket == null) ? null : datagramPacket.getAddress();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getReturnTime() {
/* 303 */     return this.returnTimeMillis;
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
/* 320 */     if (this == paramObject) {
/* 321 */       return true;
/*     */     }
/* 323 */     if (paramObject == null || getClass() != paramObject.getClass()) {
/* 324 */       return false;
/*     */     }
/* 326 */     TimeInfo timeInfo = (TimeInfo)paramObject;
/* 327 */     return (this.returnTimeMillis == timeInfo.returnTimeMillis && this.message.equals(timeInfo.message));
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
/* 340 */     byte b = 31;
/* 341 */     int i = (int)this.returnTimeMillis;
/* 342 */     i = 31 * i + this.message.hashCode();
/* 343 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ntp\TimeInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */