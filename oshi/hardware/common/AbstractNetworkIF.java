/*     */ package oshi.hardware.common;
/*     */ 
/*     */ import java.net.InetAddress;
/*     */ import java.net.InterfaceAddress;
/*     */ import java.net.NetworkInterface;
/*     */ import java.net.SocketException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Enumeration;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collectors;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.NetworkIF;
/*     */ import oshi.util.FileUtil;
/*     */ import oshi.util.FormatUtil;
/*     */ import oshi.util.Memoizer;
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
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public abstract class AbstractNetworkIF
/*     */   implements NetworkIF
/*     */ {
/*  57 */   private static final Logger LOG = LoggerFactory.getLogger(AbstractNetworkIF.class);
/*     */   
/*     */   private static final String OSHI_VM_MAC_ADDR_PROPERTIES = "oshi.vmmacaddr.properties";
/*     */   
/*     */   private NetworkInterface networkInterface;
/*     */   
/*     */   private String name;
/*     */   private String displayName;
/*     */   private int index;
/*     */   private int mtu;
/*     */   private String mac;
/*     */   private String[] ipv4;
/*     */   private Short[] subnetMasks;
/*     */   private String[] ipv6;
/*     */   private Short[] prefixLengths;
/*  72 */   private final Supplier<Properties> vmMacAddrProps = Memoizer.memoize(AbstractNetworkIF::queryVmMacAddrProps);
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
/*     */   protected AbstractNetworkIF(NetworkInterface paramNetworkInterface) throws InstantiationException {
/*  84 */     this(paramNetworkInterface, paramNetworkInterface.getDisplayName());
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
/*     */   protected AbstractNetworkIF(NetworkInterface paramNetworkInterface, String paramString) throws InstantiationException {
/* 100 */     this.networkInterface = paramNetworkInterface;
/*     */     try {
/* 102 */       this.name = this.networkInterface.getName();
/* 103 */       this.displayName = paramString;
/* 104 */       this.index = this.networkInterface.getIndex();
/*     */       
/* 106 */       this.mtu = this.networkInterface.getMTU();
/*     */       
/* 108 */       byte[] arrayOfByte = this.networkInterface.getHardwareAddress();
/* 109 */       if (arrayOfByte != null) {
/* 110 */         ArrayList<String> arrayList = new ArrayList(6);
/* 111 */         for (byte b : arrayOfByte) {
/* 112 */           arrayList.add(String.format("%02x", new Object[] { Byte.valueOf(b) }));
/*     */         } 
/* 114 */         this.mac = String.join(":", (Iterable)arrayList);
/*     */       } else {
/* 116 */         this.mac = "unknown";
/*     */       } 
/*     */       
/* 119 */       ArrayList<String> arrayList1 = new ArrayList();
/* 120 */       ArrayList<Short> arrayList2 = new ArrayList();
/* 121 */       ArrayList<String> arrayList3 = new ArrayList();
/* 122 */       ArrayList<Short> arrayList4 = new ArrayList();
/*     */       
/* 124 */       for (InterfaceAddress interfaceAddress : this.networkInterface.getInterfaceAddresses()) {
/* 125 */         InetAddress inetAddress = interfaceAddress.getAddress();
/* 126 */         if (inetAddress.getHostAddress().length() > 0) {
/* 127 */           if (inetAddress.getHostAddress().contains(":")) {
/* 128 */             arrayList3.add(inetAddress.getHostAddress().split("%")[0]);
/* 129 */             arrayList4.add(Short.valueOf(interfaceAddress.getNetworkPrefixLength())); continue;
/*     */           } 
/* 131 */           arrayList1.add(inetAddress.getHostAddress());
/* 132 */           arrayList2.add(Short.valueOf(interfaceAddress.getNetworkPrefixLength()));
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 137 */       this.ipv4 = arrayList1.<String>toArray(new String[0]);
/* 138 */       this.subnetMasks = arrayList2.<Short>toArray(new Short[0]);
/* 139 */       this.ipv6 = arrayList3.<String>toArray(new String[0]);
/* 140 */       this.prefixLengths = arrayList4.<Short>toArray(new Short[0]);
/* 141 */     } catch (SocketException socketException) {
/* 142 */       throw new InstantiationException(socketException.getMessage());
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
/*     */   protected static List<NetworkInterface> getNetworkInterfaces(boolean paramBoolean) {
/* 154 */     List<NetworkInterface> list = getAllNetworkInterfaces();
/*     */     
/* 156 */     return paramBoolean ? list : 
/* 157 */       (List<NetworkInterface>)getAllNetworkInterfaces().stream().filter(paramNetworkInterface -> !isLocalInterface(paramNetworkInterface))
/* 158 */       .collect(Collectors.toList());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static List<NetworkInterface> getAllNetworkInterfaces() {
/*     */     try {
/* 168 */       Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
/* 169 */       return (enumeration == null) ? Collections.<NetworkInterface>emptyList() : Collections.<NetworkInterface>list(enumeration);
/* 170 */     } catch (SocketException socketException) {
/* 171 */       LOG.error("Socket exception when retrieving interfaces: {}", socketException.getMessage());
/*     */       
/* 173 */       return Collections.emptyList();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static boolean isLocalInterface(NetworkInterface paramNetworkInterface) {
/*     */     try {
/* 179 */       return (paramNetworkInterface.getHardwareAddress() == null);
/* 180 */     } catch (SocketException socketException) {
/* 181 */       LOG.error("Socket exception when retrieving interface information for {}: {}", paramNetworkInterface, socketException
/* 182 */           .getMessage());
/*     */       
/* 184 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public NetworkInterface queryNetworkInterface() {
/* 189 */     return this.networkInterface;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 194 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getIndex() {
/* 199 */     return this.index;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDisplayName() {
/* 204 */     return this.displayName;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMTU() {
/* 209 */     return this.mtu;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getMacaddr() {
/* 214 */     return this.mac;
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getIPv4addr() {
/* 219 */     return Arrays.<String>copyOf(this.ipv4, this.ipv4.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public Short[] getSubnetMasks() {
/* 224 */     return Arrays.<Short>copyOf(this.subnetMasks, this.subnetMasks.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getIPv6addr() {
/* 229 */     return Arrays.<String>copyOf(this.ipv6, this.ipv6.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public Short[] getPrefixLengths() {
/* 234 */     return Arrays.<Short>copyOf(this.prefixLengths, this.prefixLengths.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isKnownVmMacAddr() {
/* 239 */     String str = (getMacaddr().length() > 7) ? getMacaddr().substring(0, 8) : getMacaddr();
/* 240 */     return ((Properties)this.vmMacAddrProps.get()).containsKey(str.toUpperCase());
/*     */   }
/*     */   
/*     */   private static Properties queryVmMacAddrProps() {
/* 244 */     return FileUtil.readPropertiesFromFilename("oshi.vmmacaddr.properties");
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 249 */     StringBuilder stringBuilder = new StringBuilder();
/* 250 */     stringBuilder.append("Name: ").append(getName());
/* 251 */     if (!getName().equals(getDisplayName())) {
/* 252 */       stringBuilder.append(" (").append(getDisplayName()).append(")");
/*     */     }
/* 254 */     if (!getIfAlias().isEmpty()) {
/* 255 */       stringBuilder.append(" [IfAlias=").append(getIfAlias()).append("]");
/*     */     }
/* 257 */     stringBuilder.append("\n");
/* 258 */     stringBuilder.append("  MAC Address: ").append(getMacaddr()).append("\n");
/* 259 */     stringBuilder.append("  MTU: ").append(ParseUtil.unsignedIntToLong(getMTU())).append(", ").append("Speed: ")
/* 260 */       .append(getSpeed()).append("\n");
/* 261 */     String[] arrayOfString1 = getIPv4addr();
/* 262 */     if (this.ipv4.length == this.subnetMasks.length) {
/* 263 */       for (byte b = 0; b < this.subnetMasks.length; b++) {
/* 264 */         arrayOfString1[b] = arrayOfString1[b] + "/" + this.subnetMasks[b];
/*     */       }
/*     */     }
/* 267 */     stringBuilder.append("  IPv4: ").append(Arrays.toString((Object[])arrayOfString1)).append("\n");
/* 268 */     String[] arrayOfString2 = getIPv6addr();
/* 269 */     if (this.ipv6.length == this.prefixLengths.length) {
/* 270 */       for (byte b = 0; b < this.prefixLengths.length; b++) {
/* 271 */         arrayOfString2[b] = arrayOfString2[b] + "/" + this.prefixLengths[b];
/*     */       }
/*     */     }
/* 274 */     stringBuilder.append("  IPv6: ").append(Arrays.toString((Object[])arrayOfString2)).append("\n");
/* 275 */     stringBuilder.append("  Traffic: received ").append(getPacketsRecv()).append(" packets/")
/* 276 */       .append(FormatUtil.formatBytes(getBytesRecv())).append(" (" + getInErrors() + " err, ")
/* 277 */       .append(getInDrops() + " drop);");
/* 278 */     stringBuilder.append(" transmitted ").append(getPacketsSent()).append(" packets/")
/* 279 */       .append(FormatUtil.formatBytes(getBytesSent())).append(" (" + getOutErrors() + " err, ")
/* 280 */       .append(getCollisions() + " coll);");
/* 281 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\common\AbstractNetworkIF.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */