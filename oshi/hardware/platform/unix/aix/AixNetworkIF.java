/*     */ package oshi.hardware.platform.unix.aix;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.platform.unix.aix.Perfstat;
/*     */ import java.net.NetworkInterface;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.function.Supplier;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.unix.aix.perfstat.PerfstatNetInterface;
/*     */ import oshi.hardware.NetworkIF;
/*     */ import oshi.hardware.common.AbstractNetworkIF;
/*     */ import oshi.util.Memoizer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class AixNetworkIF
/*     */   extends AbstractNetworkIF
/*     */ {
/*  51 */   private static final Logger LOG = LoggerFactory.getLogger(AixNetworkIF.class);
/*     */   
/*     */   private long bytesRecv;
/*     */   
/*     */   private long bytesSent;
/*     */   
/*     */   private long packetsRecv;
/*     */   private long packetsSent;
/*     */   private long inErrors;
/*     */   private long outErrors;
/*     */   private long inDrops;
/*     */   private long collisions;
/*     */   private long speed;
/*     */   private long timeStamp;
/*     */   private Supplier<Perfstat.perfstat_netinterface_t[]> netstats;
/*     */   
/*     */   public AixNetworkIF(NetworkInterface paramNetworkInterface, Supplier<Perfstat.perfstat_netinterface_t[]> paramSupplier) throws InstantiationException {
/*  68 */     super(paramNetworkInterface);
/*  69 */     this.netstats = paramSupplier;
/*  70 */     updateAttributes();
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
/*  81 */     Supplier<Perfstat.perfstat_netinterface_t[]> supplier = Memoizer.memoize(PerfstatNetInterface::queryNetInterfaces, 
/*  82 */         Memoizer.defaultExpiration());
/*  83 */     ArrayList<AixNetworkIF> arrayList = new ArrayList();
/*  84 */     for (NetworkInterface networkInterface : getNetworkInterfaces(paramBoolean)) {
/*     */       try {
/*  86 */         arrayList.add(new AixNetworkIF(networkInterface, supplier));
/*  87 */       } catch (InstantiationException instantiationException) {
/*  88 */         LOG.debug("Network Interface Instantiation failed: {}", instantiationException.getMessage());
/*     */       } 
/*     */     } 
/*  91 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesRecv() {
/*  96 */     return this.bytesRecv;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesSent() {
/* 101 */     return this.bytesSent;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPacketsRecv() {
/* 106 */     return this.packetsRecv;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPacketsSent() {
/* 111 */     return this.packetsSent;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getInErrors() {
/* 116 */     return this.inErrors;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getOutErrors() {
/* 121 */     return this.outErrors;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getInDrops() {
/* 126 */     return this.inDrops;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getCollisions() {
/* 131 */     return this.collisions;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSpeed() {
/* 136 */     return this.speed;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTimeStamp() {
/* 141 */     return this.timeStamp;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 146 */     Perfstat.perfstat_netinterface_t[] arrayOfPerfstat_netinterface_t = this.netstats.get();
/* 147 */     long l = System.currentTimeMillis();
/* 148 */     for (Perfstat.perfstat_netinterface_t perfstat_netinterface_t : arrayOfPerfstat_netinterface_t) {
/* 149 */       String str = Native.toString(perfstat_netinterface_t.name);
/* 150 */       if (str.equals(getName())) {
/* 151 */         this.bytesSent = perfstat_netinterface_t.obytes;
/* 152 */         this.bytesRecv = perfstat_netinterface_t.ibytes;
/* 153 */         this.packetsSent = perfstat_netinterface_t.opackets;
/* 154 */         this.packetsRecv = perfstat_netinterface_t.ipackets;
/* 155 */         this.outErrors = perfstat_netinterface_t.oerrors;
/* 156 */         this.inErrors = perfstat_netinterface_t.ierrors;
/* 157 */         this.collisions = perfstat_netinterface_t.collisions;
/* 158 */         this.inDrops = perfstat_netinterface_t.if_iqdrops;
/* 159 */         this.speed = perfstat_netinterface_t.bitrate;
/* 160 */         this.timeStamp = l;
/* 161 */         return true;
/*     */       } 
/*     */     } 
/* 164 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\aix\AixNetworkIF.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */