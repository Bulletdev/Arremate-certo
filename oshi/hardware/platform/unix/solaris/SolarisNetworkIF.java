/*     */ package oshi.hardware.platform.unix.solaris;
/*     */ 
/*     */ import com.sun.jna.platform.unix.solaris.LibKstat;
/*     */ import java.net.NetworkInterface;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.NetworkIF;
/*     */ import oshi.hardware.common.AbstractNetworkIF;
/*     */ import oshi.util.platform.unix.solaris.KstatUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class SolarisNetworkIF
/*     */   extends AbstractNetworkIF
/*     */ {
/*  47 */   private static final Logger LOG = LoggerFactory.getLogger(SolarisNetworkIF.class);
/*     */   
/*     */   private long bytesRecv;
/*     */   private long bytesSent;
/*     */   private long packetsRecv;
/*     */   private long packetsSent;
/*     */   private long inErrors;
/*     */   private long outErrors;
/*     */   private long inDrops;
/*     */   private long collisions;
/*     */   private long speed;
/*     */   private long timeStamp;
/*     */   
/*     */   public SolarisNetworkIF(NetworkInterface paramNetworkInterface) throws InstantiationException {
/*  61 */     super(paramNetworkInterface);
/*  62 */     updateAttributes();
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
/*  73 */     ArrayList<SolarisNetworkIF> arrayList = new ArrayList();
/*  74 */     for (NetworkInterface networkInterface : getNetworkInterfaces(paramBoolean)) {
/*     */       try {
/*  76 */         arrayList.add(new SolarisNetworkIF(networkInterface));
/*  77 */       } catch (InstantiationException instantiationException) {
/*  78 */         LOG.debug("Network Interface Instantiation failed: {}", instantiationException.getMessage());
/*     */       } 
/*     */     } 
/*  81 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesRecv() {
/*  86 */     return this.bytesRecv;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesSent() {
/*  91 */     return this.bytesSent;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPacketsRecv() {
/*  96 */     return this.packetsRecv;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPacketsSent() {
/* 101 */     return this.packetsSent;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getInErrors() {
/* 106 */     return this.inErrors;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getOutErrors() {
/* 111 */     return this.outErrors;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getInDrops() {
/* 116 */     return this.inDrops;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getCollisions() {
/* 121 */     return this.collisions;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSpeed() {
/* 126 */     return this.speed;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTimeStamp() {
/* 131 */     return this.timeStamp;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 136 */     KstatUtil.KstatChain kstatChain = KstatUtil.openChain(); 
/* 137 */     try { LibKstat.Kstat kstat = KstatUtil.KstatChain.lookup("link", -1, getName());
/* 138 */       if (kstat == null) {
/* 139 */         kstat = KstatUtil.KstatChain.lookup(null, -1, getName());
/*     */       }
/* 141 */       if (kstat != null && KstatUtil.KstatChain.read(kstat))
/* 142 */       { this.bytesSent = KstatUtil.dataLookupLong(kstat, "obytes64");
/* 143 */         this.bytesRecv = KstatUtil.dataLookupLong(kstat, "rbytes64");
/* 144 */         this.packetsSent = KstatUtil.dataLookupLong(kstat, "opackets64");
/* 145 */         this.packetsRecv = KstatUtil.dataLookupLong(kstat, "ipackets64");
/* 146 */         this.outErrors = KstatUtil.dataLookupLong(kstat, "oerrors");
/* 147 */         this.inErrors = KstatUtil.dataLookupLong(kstat, "ierrors");
/* 148 */         this.collisions = KstatUtil.dataLookupLong(kstat, "collisions");
/* 149 */         this.inDrops = KstatUtil.dataLookupLong(kstat, "dl_idrops");
/* 150 */         this.speed = KstatUtil.dataLookupLong(kstat, "ifspeed");
/*     */         
/* 152 */         this.timeStamp = kstat.ks_snaptime / 1000000L;
/* 153 */         boolean bool = true;
/*     */         
/* 155 */         if (kstatChain != null) kstatChain.close();  return bool; }  if (kstatChain != null) kstatChain.close();  } catch (Throwable throwable) { if (kstatChain != null)
/* 156 */         try { kstatChain.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\solaris\SolarisNetworkIF.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */