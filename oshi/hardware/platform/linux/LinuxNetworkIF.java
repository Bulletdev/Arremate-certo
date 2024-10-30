/*     */ package oshi.hardware.platform.linux;
/*     */ 
/*     */ import com.sun.jna.platform.linux.Udev;
/*     */ import java.io.File;
/*     */ import java.net.NetworkInterface;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.NetworkIF;
/*     */ import oshi.hardware.common.AbstractNetworkIF;
/*     */ import oshi.util.FileUtil;
/*     */ import oshi.util.Util;
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
/*     */ public final class LinuxNetworkIF
/*     */   extends AbstractNetworkIF
/*     */ {
/*  50 */   private static final Logger LOG = LoggerFactory.getLogger(LinuxNetworkIF.class);
/*     */   
/*     */   private int ifType;
/*     */   private boolean connectorPresent;
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
/*     */   private String ifAlias;
/*     */   private NetworkIF.IfOperStatus ifOperStatus;
/*     */   
/*     */   public LinuxNetworkIF(NetworkInterface paramNetworkInterface) throws InstantiationException {
/*  68 */     super(paramNetworkInterface, queryIfModel(paramNetworkInterface));
/*  69 */     updateAttributes();
/*     */   }
/*     */   
/*     */   private static String queryIfModel(NetworkInterface paramNetworkInterface) {
/*  73 */     String str = paramNetworkInterface.getName();
/*  74 */     Udev.UdevContext udevContext = Udev.INSTANCE.udev_new();
/*  75 */     if (udevContext != null) {
/*     */       try {
/*  77 */         Udev.UdevDevice udevDevice = udevContext.deviceNewFromSyspath("/sys/class/net/" + str);
/*  78 */         if (udevDevice != null) {
/*     */           try {
/*  80 */             String str1 = udevDevice.getPropertyValue("ID_VENDOR_FROM_DATABASE");
/*  81 */             String str2 = udevDevice.getPropertyValue("ID_MODEL_FROM_DATABASE");
/*  82 */             if (!Util.isBlank(str2)) {
/*  83 */               if (!Util.isBlank(str1)) {
/*  84 */                 return str1 + " " + str2;
/*     */               }
/*  86 */               return str2;
/*     */             } 
/*     */           } finally {
/*  89 */             udevDevice.unref();
/*     */           } 
/*     */         }
/*     */       } finally {
/*  93 */         udevContext.unref();
/*     */       } 
/*     */     }
/*  96 */     return str;
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
/* 107 */     ArrayList<LinuxNetworkIF> arrayList = new ArrayList();
/* 108 */     for (NetworkInterface networkInterface : getNetworkInterfaces(paramBoolean)) {
/*     */       try {
/* 110 */         arrayList.add(new LinuxNetworkIF(networkInterface));
/* 111 */       } catch (InstantiationException instantiationException) {
/* 112 */         LOG.debug("Network Interface Instantiation failed: {}", instantiationException.getMessage());
/*     */       } 
/*     */     } 
/* 115 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getIfType() {
/* 120 */     return this.ifType;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isConnectorPresent() {
/* 125 */     return this.connectorPresent;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesRecv() {
/* 130 */     return this.bytesRecv;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesSent() {
/* 135 */     return this.bytesSent;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPacketsRecv() {
/* 140 */     return this.packetsRecv;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPacketsSent() {
/* 145 */     return this.packetsSent;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getInErrors() {
/* 150 */     return this.inErrors;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getOutErrors() {
/* 155 */     return this.outErrors;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getInDrops() {
/* 160 */     return this.inDrops;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getCollisions() {
/* 165 */     return this.collisions;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSpeed() {
/* 170 */     return this.speed;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTimeStamp() {
/* 175 */     return this.timeStamp;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getIfAlias() {
/* 180 */     return this.ifAlias;
/*     */   }
/*     */ 
/*     */   
/*     */   public NetworkIF.IfOperStatus getIfOperStatus() {
/* 185 */     return this.ifOperStatus;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/*     */     try {
/* 191 */       File file = new File(String.format("/sys/class/net/%s/statistics", new Object[] { getName() }));
/* 192 */       if (!file.isDirectory()) {
/* 193 */         return false;
/*     */       }
/* 195 */     } catch (SecurityException securityException) {
/* 196 */       return false;
/*     */     } 
/* 198 */     String str1 = String.format("/sys/class/net/%s/type", new Object[] { getName() });
/* 199 */     String str2 = String.format("/sys/class/net/%s/carrier", new Object[] { getName() });
/* 200 */     String str3 = String.format("/sys/class/net/%s/statistics/tx_bytes", new Object[] { getName() });
/* 201 */     String str4 = String.format("/sys/class/net/%s/statistics/rx_bytes", new Object[] { getName() });
/* 202 */     String str5 = String.format("/sys/class/net/%s/statistics/tx_packets", new Object[] { getName() });
/* 203 */     String str6 = String.format("/sys/class/net/%s/statistics/rx_packets", new Object[] { getName() });
/* 204 */     String str7 = String.format("/sys/class/net/%s/statistics/tx_errors", new Object[] { getName() });
/* 205 */     String str8 = String.format("/sys/class/net/%s/statistics/rx_errors", new Object[] { getName() });
/* 206 */     String str9 = String.format("/sys/class/net/%s/statistics/collisions", new Object[] { getName() });
/* 207 */     String str10 = String.format("/sys/class/net/%s/statistics/rx_dropped", new Object[] { getName() });
/* 208 */     String str11 = String.format("/sys/class/net/%s/speed", new Object[] { getName() });
/* 209 */     String str12 = String.format("/sys/class/net/%s/ifalias", new Object[] { getName() });
/* 210 */     String str13 = String.format("/sys/class/net/%s/operstate", new Object[] { getName() });
/*     */     
/* 212 */     this.timeStamp = System.currentTimeMillis();
/* 213 */     this.ifType = FileUtil.getIntFromFile(str1);
/* 214 */     this.connectorPresent = (FileUtil.getIntFromFile(str2) > 0);
/* 215 */     this.bytesSent = FileUtil.getUnsignedLongFromFile(str3);
/* 216 */     this.bytesRecv = FileUtil.getUnsignedLongFromFile(str4);
/* 217 */     this.packetsSent = FileUtil.getUnsignedLongFromFile(str5);
/* 218 */     this.packetsRecv = FileUtil.getUnsignedLongFromFile(str6);
/* 219 */     this.outErrors = FileUtil.getUnsignedLongFromFile(str7);
/* 220 */     this.inErrors = FileUtil.getUnsignedLongFromFile(str8);
/* 221 */     this.collisions = FileUtil.getUnsignedLongFromFile(str9);
/* 222 */     this.inDrops = FileUtil.getUnsignedLongFromFile(str10);
/* 223 */     long l = FileUtil.getUnsignedLongFromFile(str11);
/*     */     
/* 225 */     this.speed = (l < 0L) ? 0L : (l << 20L);
/* 226 */     this.ifAlias = FileUtil.getStringFromFile(str12);
/* 227 */     this.ifOperStatus = parseIfOperStatus(FileUtil.getStringFromFile(str13));
/*     */     
/* 229 */     return true;
/*     */   }
/*     */   
/*     */   private static NetworkIF.IfOperStatus parseIfOperStatus(String paramString) {
/* 233 */     switch (paramString) {
/*     */       case "up":
/* 235 */         return NetworkIF.IfOperStatus.UP;
/*     */       case "down":
/* 237 */         return NetworkIF.IfOperStatus.DOWN;
/*     */       case "testing":
/* 239 */         return NetworkIF.IfOperStatus.TESTING;
/*     */       case "dormant":
/* 241 */         return NetworkIF.IfOperStatus.DORMANT;
/*     */       case "notpresent":
/* 243 */         return NetworkIF.IfOperStatus.NOT_PRESENT;
/*     */       case "lowerlayerdown":
/* 245 */         return NetworkIF.IfOperStatus.LOWER_LAYER_DOWN;
/*     */     } 
/*     */     
/* 248 */     return NetworkIF.IfOperStatus.UNKNOWN;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\linux\LinuxNetworkIF.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */