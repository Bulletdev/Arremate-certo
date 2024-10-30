/*     */ package oshi.driver.mac.net;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.platform.mac.SystemB;
/*     */ import com.sun.jna.platform.unix.LibCAPI;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class NetStat
/*     */ {
/*  48 */   private static final Logger LOG = LoggerFactory.getLogger(NetStat.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int CTL_NET = 4;
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int PF_ROUTE = 17;
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int NET_RT_IFLIST2 = 6;
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int RTM_IFINFO2 = 18;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Map<Integer, IFdata> queryIFdata(int paramInt) {
/*  71 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/*  73 */     int[] arrayOfInt = { 4, 17, 0, 0, 6, 0 };
/*  74 */     LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference();
/*  75 */     if (0 != SystemB.INSTANCE.sysctl(arrayOfInt, 6, null, byReference, null, LibCAPI.size_t.ZERO)) {
/*  76 */       LOG.error("Didn't get buffer length for IFLIST2");
/*  77 */       return (Map)hashMap;
/*     */     } 
/*  79 */     Memory memory = new Memory(byReference.longValue());
/*  80 */     if (0 != SystemB.INSTANCE.sysctl(arrayOfInt, 6, (Pointer)memory, byReference, null, LibCAPI.size_t.ZERO)) {
/*  81 */       LOG.error("Didn't get buffer for IFLIST2");
/*  82 */       return (Map)hashMap;
/*     */     } 
/*  84 */     long l = System.currentTimeMillis();
/*     */ 
/*     */     
/*  87 */     int i = (int)(memory.size() - (new SystemB.IFmsgHdr()).size());
/*  88 */     int j = 0;
/*  89 */     while (j < i) {
/*     */       
/*  91 */       Pointer pointer = memory.share(j);
/*     */       
/*  93 */       SystemB.IFmsgHdr iFmsgHdr = new SystemB.IFmsgHdr(pointer);
/*  94 */       iFmsgHdr.read();
/*     */       
/*  96 */       j += iFmsgHdr.ifm_msglen;
/*     */       
/*  98 */       if (iFmsgHdr.ifm_type == 18) {
/*     */         
/* 100 */         SystemB.IFmsgHdr2 iFmsgHdr2 = new SystemB.IFmsgHdr2(pointer);
/* 101 */         iFmsgHdr2.read();
/* 102 */         if (paramInt < 0 || paramInt == iFmsgHdr2.ifm_index) {
/* 103 */           hashMap.put(Integer.valueOf(iFmsgHdr2.ifm_index), new IFdata(0xFF & iFmsgHdr2.ifm_data.ifi_type, iFmsgHdr2.ifm_data.ifi_opackets, iFmsgHdr2.ifm_data.ifi_ipackets, iFmsgHdr2.ifm_data.ifi_obytes, iFmsgHdr2.ifm_data.ifi_ibytes, iFmsgHdr2.ifm_data.ifi_oerrors, iFmsgHdr2.ifm_data.ifi_ierrors, iFmsgHdr2.ifm_data.ifi_collisions, iFmsgHdr2.ifm_data.ifi_iqdrops, iFmsgHdr2.ifm_data.ifi_baudrate, l));
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 108 */           if (paramInt >= 0) {
/* 109 */             return (Map)hashMap;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 114 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */   
/*     */   @Immutable
/*     */   public static class IFdata
/*     */   {
/*     */     private final int ifType;
/*     */     
/*     */     private final long oPackets;
/*     */     
/*     */     private final long iPackets;
/*     */     
/*     */     private final long oBytes;
/*     */     private final long iBytes;
/*     */     private final long oErrors;
/*     */     private final long iErrors;
/*     */     private final long collisions;
/*     */     private final long iDrops;
/*     */     private final long speed;
/*     */     private final long timeStamp;
/*     */     
/*     */     IFdata(int param1Int, long param1Long1, long param1Long2, long param1Long3, long param1Long4, long param1Long5, long param1Long6, long param1Long7, long param1Long8, long param1Long9, long param1Long10) {
/* 137 */       this.ifType = param1Int;
/* 138 */       this.oPackets = param1Long1 & 0xFFFFFFFFL;
/* 139 */       this.iPackets = param1Long2 & 0xFFFFFFFFL;
/* 140 */       this.oBytes = param1Long3 & 0xFFFFFFFFL;
/* 141 */       this.iBytes = param1Long4 & 0xFFFFFFFFL;
/* 142 */       this.oErrors = param1Long5 & 0xFFFFFFFFL;
/* 143 */       this.iErrors = param1Long6 & 0xFFFFFFFFL;
/* 144 */       this.collisions = param1Long7 & 0xFFFFFFFFL;
/* 145 */       this.iDrops = param1Long8 & 0xFFFFFFFFL;
/* 146 */       this.speed = param1Long9 & 0xFFFFFFFFL;
/* 147 */       this.timeStamp = param1Long10;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getIfType() {
/* 154 */       return this.ifType;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getOPackets() {
/* 161 */       return this.oPackets;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getIPackets() {
/* 168 */       return this.iPackets;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getOBytes() {
/* 175 */       return this.oBytes;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getIBytes() {
/* 182 */       return this.iBytes;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getOErrors() {
/* 189 */       return this.oErrors;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getIErrors() {
/* 196 */       return this.iErrors;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getCollisions() {
/* 203 */       return this.collisions;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getIDrops() {
/* 210 */       return this.iDrops;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getSpeed() {
/* 217 */       return this.speed;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getTimeStamp() {
/* 224 */       return this.timeStamp;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\mac\net\NetStat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */