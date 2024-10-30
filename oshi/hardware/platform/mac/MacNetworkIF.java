/*     */ package oshi.hardware.platform.mac;
/*     */ 
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.platform.mac.CoreFoundation;
/*     */ import java.net.NetworkInterface;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.mac.net.NetStat;
/*     */ import oshi.hardware.NetworkIF;
/*     */ import oshi.hardware.common.AbstractNetworkIF;
/*     */ import oshi.jna.platform.mac.SystemConfiguration;
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
/*     */ public final class MacNetworkIF
/*     */   extends AbstractNetworkIF
/*     */ {
/*  52 */   private static final Logger LOG = LoggerFactory.getLogger(MacNetworkIF.class);
/*     */   
/*     */   private int ifType;
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
/*     */   public MacNetworkIF(NetworkInterface paramNetworkInterface, Map<Integer, NetStat.IFdata> paramMap) throws InstantiationException {
/*  67 */     super(paramNetworkInterface, queryIfDisplayName(paramNetworkInterface));
/*  68 */     updateNetworkStats(paramMap);
/*     */   }
/*     */   
/*     */   private static String queryIfDisplayName(NetworkInterface paramNetworkInterface) {
/*  72 */     String str = paramNetworkInterface.getName();
/*  73 */     CoreFoundation.CFArrayRef cFArrayRef = SystemConfiguration.INSTANCE.SCNetworkInterfaceCopyAll();
/*  74 */     if (cFArrayRef != null) {
/*     */       try {
/*  76 */         int i = cFArrayRef.getCount();
/*  77 */         for (byte b = 0; b < i; b++) {
/*  78 */           Pointer pointer = cFArrayRef.getValueAtIndex(b);
/*  79 */           SystemConfiguration.SCNetworkInterfaceRef sCNetworkInterfaceRef = new SystemConfiguration.SCNetworkInterfaceRef(pointer);
/*  80 */           CoreFoundation.CFStringRef cFStringRef = SystemConfiguration.INSTANCE.SCNetworkInterfaceGetBSDName(sCNetworkInterfaceRef);
/*  81 */           if (cFStringRef != null && str.equals(cFStringRef.stringValue())) {
/*     */             
/*  83 */             CoreFoundation.CFStringRef cFStringRef1 = SystemConfiguration.INSTANCE.SCNetworkInterfaceGetLocalizedDisplayName(sCNetworkInterfaceRef);
/*  84 */             return cFStringRef1.stringValue();
/*     */           } 
/*     */         } 
/*     */       } finally {
/*  88 */         cFArrayRef.release();
/*     */       } 
/*     */     }
/*  91 */     return str;
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
/*     */   public static List<NetworkIF> getNetworks(boolean paramBoolean) {
/* 103 */     Map<Integer, NetStat.IFdata> map = NetStat.queryIFdata(-1);
/* 104 */     ArrayList<MacNetworkIF> arrayList = new ArrayList();
/* 105 */     for (NetworkInterface networkInterface : getNetworkInterfaces(paramBoolean)) {
/*     */       try {
/* 107 */         arrayList.add(new MacNetworkIF(networkInterface, map));
/* 108 */       } catch (InstantiationException instantiationException) {
/* 109 */         LOG.debug("Network Interface Instantiation failed: {}", instantiationException.getMessage());
/*     */       } 
/*     */     } 
/* 112 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getIfType() {
/* 117 */     return this.ifType;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesRecv() {
/* 122 */     return this.bytesRecv;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesSent() {
/* 127 */     return this.bytesSent;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPacketsRecv() {
/* 132 */     return this.packetsRecv;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPacketsSent() {
/* 137 */     return this.packetsSent;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getInErrors() {
/* 142 */     return this.inErrors;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getOutErrors() {
/* 147 */     return this.outErrors;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getInDrops() {
/* 152 */     return this.inDrops;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getCollisions() {
/* 157 */     return this.collisions;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSpeed() {
/* 162 */     return this.speed;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTimeStamp() {
/* 167 */     return this.timeStamp;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 172 */     int i = queryNetworkInterface().getIndex();
/* 173 */     return updateNetworkStats(NetStat.queryIFdata(i));
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
/*     */   private boolean updateNetworkStats(Map<Integer, NetStat.IFdata> paramMap) {
/* 185 */     int i = queryNetworkInterface().getIndex();
/* 186 */     if (paramMap.containsKey(Integer.valueOf(i))) {
/* 187 */       NetStat.IFdata iFdata = paramMap.get(Integer.valueOf(i));
/*     */       
/* 189 */       this.ifType = iFdata.getIfType();
/* 190 */       this.bytesSent = iFdata.getOBytes();
/* 191 */       this.bytesRecv = iFdata.getIBytes();
/* 192 */       this.packetsSent = iFdata.getOPackets();
/* 193 */       this.packetsRecv = iFdata.getIPackets();
/* 194 */       this.outErrors = iFdata.getOErrors();
/* 195 */       this.inErrors = iFdata.getIErrors();
/* 196 */       this.collisions = iFdata.getCollisions();
/* 197 */       this.inDrops = iFdata.getIDrops();
/* 198 */       this.speed = iFdata.getSpeed();
/* 199 */       this.timeStamp = iFdata.getTimeStamp();
/* 200 */       return true;
/*     */     } 
/* 202 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\mac\MacNetworkIF.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */