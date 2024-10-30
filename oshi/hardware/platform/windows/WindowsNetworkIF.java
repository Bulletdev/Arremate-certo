/*     */ package oshi.hardware.platform.windows;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.platform.win32.IPHlpAPI;
/*     */ import com.sun.jna.platform.win32.VersionHelpers;
/*     */ import java.net.NetworkInterface;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.NetworkIF;
/*     */ import oshi.hardware.common.AbstractNetworkIF;
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
/*     */ 
/*     */ @ThreadSafe
/*     */ public final class WindowsNetworkIF
/*     */   extends AbstractNetworkIF
/*     */ {
/*  50 */   private static final Logger LOG = LoggerFactory.getLogger(WindowsNetworkIF.class);
/*     */   
/*  52 */   private static final boolean IS_VISTA_OR_GREATER = VersionHelpers.IsWindowsVistaOrGreater();
/*     */   
/*     */   private static final byte CONNECTOR_PRESENT_BIT = 4;
/*     */   private int ifType;
/*     */   private int ndisPhysicalMediumType;
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
/*     */   public WindowsNetworkIF(NetworkInterface paramNetworkInterface) throws InstantiationException {
/*  72 */     super(paramNetworkInterface);
/*  73 */     updateAttributes();
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
/*  84 */     ArrayList<WindowsNetworkIF> arrayList = new ArrayList();
/*  85 */     for (NetworkInterface networkInterface : getNetworkInterfaces(paramBoolean)) {
/*     */       try {
/*  87 */         arrayList.add(new WindowsNetworkIF(networkInterface));
/*  88 */       } catch (InstantiationException instantiationException) {
/*  89 */         LOG.debug("Network Interface Instantiation failed: {}", instantiationException.getMessage());
/*     */       } 
/*     */     } 
/*  92 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getIfType() {
/*  97 */     return this.ifType;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNdisPhysicalMediumType() {
/* 102 */     return this.ndisPhysicalMediumType;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isConnectorPresent() {
/* 107 */     return this.connectorPresent;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesRecv() {
/* 112 */     return this.bytesRecv;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesSent() {
/* 117 */     return this.bytesSent;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPacketsRecv() {
/* 122 */     return this.packetsRecv;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPacketsSent() {
/* 127 */     return this.packetsSent;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getInErrors() {
/* 132 */     return this.inErrors;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getOutErrors() {
/* 137 */     return this.outErrors;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getInDrops() {
/* 142 */     return this.inDrops;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getCollisions() {
/* 147 */     return this.collisions;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSpeed() {
/* 152 */     return this.speed;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTimeStamp() {
/* 157 */     return this.timeStamp;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getIfAlias() {
/* 162 */     return this.ifAlias;
/*     */   }
/*     */ 
/*     */   
/*     */   public NetworkIF.IfOperStatus getIfOperStatus() {
/* 167 */     return this.ifOperStatus;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 173 */     if (IS_VISTA_OR_GREATER) {
/*     */       
/* 175 */       IPHlpAPI.MIB_IF_ROW2 mIB_IF_ROW2 = new IPHlpAPI.MIB_IF_ROW2();
/* 176 */       mIB_IF_ROW2.InterfaceIndex = queryNetworkInterface().getIndex();
/* 177 */       if (0 != IPHlpAPI.INSTANCE.GetIfEntry2(mIB_IF_ROW2)) {
/*     */         
/* 179 */         LOG.error("Failed to retrieve data for interface {}, {}", Integer.valueOf(queryNetworkInterface().getIndex()), 
/* 180 */             getName());
/* 181 */         return false;
/*     */       } 
/* 183 */       this.ifType = mIB_IF_ROW2.Type;
/* 184 */       this.ndisPhysicalMediumType = mIB_IF_ROW2.PhysicalMediumType;
/* 185 */       this.connectorPresent = ((mIB_IF_ROW2.InterfaceAndOperStatusFlags & 0x4) > 0);
/* 186 */       this.bytesSent = mIB_IF_ROW2.OutOctets;
/* 187 */       this.bytesRecv = mIB_IF_ROW2.InOctets;
/* 188 */       this.packetsSent = mIB_IF_ROW2.OutUcastPkts;
/* 189 */       this.packetsRecv = mIB_IF_ROW2.InUcastPkts;
/* 190 */       this.outErrors = mIB_IF_ROW2.OutErrors;
/* 191 */       this.inErrors = mIB_IF_ROW2.InErrors;
/* 192 */       this.collisions = mIB_IF_ROW2.OutDiscards;
/* 193 */       this.inDrops = mIB_IF_ROW2.InDiscards;
/* 194 */       this.speed = mIB_IF_ROW2.ReceiveLinkSpeed;
/* 195 */       this.ifAlias = Native.toString(mIB_IF_ROW2.Alias);
/* 196 */       this.ifOperStatus = NetworkIF.IfOperStatus.byValue(mIB_IF_ROW2.OperStatus);
/*     */     } else {
/*     */       
/* 199 */       IPHlpAPI.MIB_IFROW mIB_IFROW = new IPHlpAPI.MIB_IFROW();
/* 200 */       mIB_IFROW.dwIndex = queryNetworkInterface().getIndex();
/* 201 */       if (0 != IPHlpAPI.INSTANCE.GetIfEntry(mIB_IFROW)) {
/*     */         
/* 203 */         LOG.error("Failed to retrieve data for interface {}, {}", Integer.valueOf(queryNetworkInterface().getIndex()), 
/* 204 */             getName());
/* 205 */         return false;
/*     */       } 
/* 207 */       this.ifType = mIB_IFROW.dwType;
/*     */       
/* 209 */       this.bytesSent = ParseUtil.unsignedIntToLong(mIB_IFROW.dwOutOctets);
/* 210 */       this.bytesRecv = ParseUtil.unsignedIntToLong(mIB_IFROW.dwInOctets);
/* 211 */       this.packetsSent = ParseUtil.unsignedIntToLong(mIB_IFROW.dwOutUcastPkts);
/* 212 */       this.packetsRecv = ParseUtil.unsignedIntToLong(mIB_IFROW.dwInUcastPkts);
/* 213 */       this.outErrors = ParseUtil.unsignedIntToLong(mIB_IFROW.dwOutErrors);
/* 214 */       this.inErrors = ParseUtil.unsignedIntToLong(mIB_IFROW.dwInErrors);
/* 215 */       this.collisions = ParseUtil.unsignedIntToLong(mIB_IFROW.dwOutDiscards);
/* 216 */       this.inDrops = ParseUtil.unsignedIntToLong(mIB_IFROW.dwInDiscards);
/* 217 */       this.speed = ParseUtil.unsignedIntToLong(mIB_IFROW.dwSpeed);
/* 218 */       this.ifAlias = "";
/* 219 */       this.ifOperStatus = NetworkIF.IfOperStatus.UNKNOWN;
/*     */     } 
/* 221 */     this.timeStamp = System.currentTimeMillis();
/* 222 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\windows\WindowsNetworkIF.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */