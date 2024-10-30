/*     */ package oshi.hardware.platform.unix;
/*     */ 
/*     */ import java.net.NetworkInterface;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.NetworkIF;
/*     */ import oshi.hardware.common.AbstractNetworkIF;
/*     */ import oshi.util.ExecutingCommand;
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
/*     */ @ThreadSafe
/*     */ public final class BsdNetworkIF
/*     */   extends AbstractNetworkIF
/*     */ {
/*  45 */   private static final Logger LOG = LoggerFactory.getLogger(BsdNetworkIF.class);
/*     */   
/*     */   private long bytesRecv;
/*     */   private long bytesSent;
/*     */   private long packetsRecv;
/*     */   private long packetsSent;
/*     */   private long inErrors;
/*     */   private long outErrors;
/*     */   private long inDrops;
/*     */   private long collisions;
/*     */   private long timeStamp;
/*     */   
/*     */   public BsdNetworkIF(NetworkInterface paramNetworkInterface) throws InstantiationException {
/*  58 */     super(paramNetworkInterface);
/*  59 */     updateAttributes();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<NetworkIF> getNetworks(boolean paramBoolean) {
/*  70 */     ArrayList<BsdNetworkIF> arrayList = new ArrayList();
/*  71 */     for (NetworkInterface networkInterface : getNetworkInterfaces(paramBoolean)) {
/*     */       try {
/*  73 */         arrayList.add(new BsdNetworkIF(networkInterface));
/*  74 */       } catch (InstantiationException instantiationException) {
/*  75 */         LOG.debug("Network Interface Instantiation failed: {}", instantiationException.getMessage());
/*     */       } 
/*     */     } 
/*  78 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesRecv() {
/*  83 */     return this.bytesRecv;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesSent() {
/*  88 */     return this.bytesSent;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPacketsRecv() {
/*  93 */     return this.packetsRecv;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPacketsSent() {
/*  98 */     return this.packetsSent;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getInErrors() {
/* 103 */     return this.inErrors;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getOutErrors() {
/* 108 */     return this.outErrors;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getInDrops() {
/* 113 */     return this.inDrops;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getCollisions() {
/* 118 */     return this.collisions;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSpeed() {
/* 123 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTimeStamp() {
/* 128 */     return this.timeStamp;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 133 */     String str = ExecutingCommand.getAnswerAt("netstat -bI " + getName(), 1);
/* 134 */     this.timeStamp = System.currentTimeMillis();
/* 135 */     String[] arrayOfString = ParseUtil.whitespaces.split(str);
/* 136 */     if (arrayOfString.length < 12)
/*     */     {
/* 138 */       return false;
/*     */     }
/* 140 */     this.bytesSent = ParseUtil.parseUnsignedLongOrDefault(arrayOfString[10], 0L);
/* 141 */     this.bytesRecv = ParseUtil.parseUnsignedLongOrDefault(arrayOfString[7], 0L);
/* 142 */     this.packetsSent = ParseUtil.parseUnsignedLongOrDefault(arrayOfString[8], 0L);
/* 143 */     this.packetsRecv = ParseUtil.parseUnsignedLongOrDefault(arrayOfString[4], 0L);
/* 144 */     this.outErrors = ParseUtil.parseUnsignedLongOrDefault(arrayOfString[9], 0L);
/* 145 */     this.inErrors = ParseUtil.parseUnsignedLongOrDefault(arrayOfString[5], 0L);
/* 146 */     this.collisions = ParseUtil.parseUnsignedLongOrDefault(arrayOfString[11], 0L);
/* 147 */     this.inDrops = ParseUtil.parseUnsignedLongOrDefault(arrayOfString[6], 0L);
/* 148 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\BsdNetworkIF.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */