/*     */ package oshi.util.platform.mac;
/*     */ 
/*     */ import com.sun.jna.NativeLong;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.Structure.FieldOrder;
/*     */ import com.sun.jna.platform.mac.IOKit;
/*     */ import com.sun.jna.platform.mac.IOKitUtil;
/*     */ import com.sun.jna.ptr.NativeLongByReference;
/*     */ import com.sun.jna.ptr.PointerByReference;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.jna.platform.mac.IOKit;
/*     */ import oshi.jna.platform.mac.SystemB;
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
/*     */ public final class SmcUtil
/*     */ {
/*  55 */   private static final Logger LOG = LoggerFactory.getLogger(SmcUtil.class);
/*     */   
/*  57 */   private static final IOKit IO = IOKit.INSTANCE;
/*     */ 
/*     */   
/*     */   @FieldOrder({"major", "minor", "build", "reserved", "release"})
/*     */   public static class SMCKeyDataVers
/*     */     extends Structure
/*     */   {
/*     */     public byte major;
/*     */     
/*     */     public byte minor;
/*     */     
/*     */     public byte build;
/*     */     
/*     */     public byte reserved;
/*     */     
/*     */     public short release;
/*     */   }
/*     */   
/*     */   @FieldOrder({"version", "length", "cpuPLimit", "gpuPLimit", "memPLimit"})
/*     */   public static class SMCKeyDataPLimitData
/*     */     extends Structure
/*     */   {
/*     */     public short version;
/*     */     public short length;
/*     */     public int cpuPLimit;
/*     */     public int gpuPLimit;
/*     */     public int memPLimit;
/*     */   }
/*     */   
/*     */   @FieldOrder({"dataSize", "dataType", "dataAttributes"})
/*     */   public static class SMCKeyDataKeyInfo
/*     */     extends Structure
/*     */   {
/*     */     public int dataSize;
/*     */     public int dataType;
/*     */     public byte dataAttributes;
/*     */   }
/*     */   
/*     */   @FieldOrder({"key", "vers", "pLimitData", "keyInfo", "result", "status", "data8", "data32", "bytes"})
/*     */   public static class SMCKeyData
/*     */     extends Structure
/*     */   {
/*     */     public int key;
/*     */     public SmcUtil.SMCKeyDataVers vers;
/*     */     public SmcUtil.SMCKeyDataPLimitData pLimitData;
/*     */     public SmcUtil.SMCKeyDataKeyInfo keyInfo;
/*     */     public byte result;
/*     */     public byte status;
/*     */     public byte data8;
/*     */     public int data32;
/* 107 */     public byte[] bytes = new byte[32];
/*     */   }
/*     */ 
/*     */   
/*     */   @FieldOrder({"key", "dataSize", "dataType", "bytes"})
/*     */   public static class SMCVal
/*     */     extends Structure
/*     */   {
/* 115 */     public byte[] key = new byte[5];
/*     */     public int dataSize;
/* 117 */     public byte[] dataType = new byte[5];
/* 118 */     public byte[] bytes = new byte[32];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 125 */   private static Map<Integer, SMCKeyDataKeyInfo> keyInfoCache = new ConcurrentHashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 130 */   private static final byte[] DATATYPE_SP78 = ParseUtil.asciiStringToByteArray("sp78", 5);
/* 131 */   private static final byte[] DATATYPE_FPE2 = ParseUtil.asciiStringToByteArray("fpe2", 5);
/* 132 */   private static final byte[] DATATYPE_FLT = ParseUtil.asciiStringToByteArray("flt ", 5);
/*     */ 
/*     */   
/*     */   public static final String SMC_KEY_FAN_NUM = "FNum";
/*     */ 
/*     */   
/*     */   public static final String SMC_KEY_FAN_SPEED = "F%dAc";
/*     */   
/*     */   public static final String SMC_KEY_CPU_TEMP = "TC0P";
/*     */   
/*     */   public static final String SMC_KEY_CPU_VOLTAGE = "VC0C";
/*     */   
/*     */   public static final byte SMC_CMD_READ_BYTES = 5;
/*     */   
/*     */   public static final byte SMC_CMD_READ_KEYINFO = 9;
/*     */   
/*     */   public static final int KERNEL_INDEX_SMC = 2;
/*     */ 
/*     */   
/*     */   public static IOKit.IOConnect smcOpen() {
/* 152 */     IOKit.IOService iOService = IOKitUtil.getMatchingService("AppleSMC");
/* 153 */     if (iOService != null) {
/* 154 */       PointerByReference pointerByReference = new PointerByReference();
/* 155 */       int i = IO.IOServiceOpen(iOService, SystemB.INSTANCE.mach_task_self(), 0, pointerByReference);
/* 156 */       iOService.release();
/* 157 */       if (i == 0)
/* 158 */         return new IOKit.IOConnect(pointerByReference.getValue()); 
/* 159 */       if (LOG.isErrorEnabled()) {
/* 160 */         LOG.error(String.format("Unable to open connection to AppleSMC service. Error: 0x%08x", new Object[] { Integer.valueOf(i) }));
/*     */       }
/*     */     } else {
/* 163 */       LOG.error("Unable to locate AppleSMC service");
/*     */     } 
/* 165 */     return null;
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
/*     */   public static int smcClose(IOKit.IOConnect paramIOConnect) {
/* 177 */     return IO.IOServiceClose(paramIOConnect);
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
/*     */   public static double smcGetFloat(IOKit.IOConnect paramIOConnect, String paramString) {
/* 190 */     SMCVal sMCVal = new SMCVal();
/* 191 */     int i = smcReadKey(paramIOConnect, paramString, sMCVal);
/* 192 */     if (i == 0 && sMCVal.dataSize > 0) {
/* 193 */       if (Arrays.equals(sMCVal.dataType, DATATYPE_SP78) && sMCVal.dataSize == 2)
/*     */       {
/*     */         
/* 196 */         return sMCVal.bytes[0] + sMCVal.bytes[1] / 256.0D; } 
/* 197 */       if (Arrays.equals(sMCVal.dataType, DATATYPE_FPE2) && sMCVal.dataSize == 2)
/*     */       {
/* 199 */         return ParseUtil.byteArrayToFloat(sMCVal.bytes, sMCVal.dataSize, 2); } 
/* 200 */       if (Arrays.equals(sMCVal.dataType, DATATYPE_FLT) && sMCVal.dataSize == 4)
/*     */       {
/* 202 */         return ByteBuffer.wrap(sMCVal.bytes).order(ByteOrder.LITTLE_ENDIAN).getFloat();
/*     */       }
/*     */     } 
/*     */     
/* 206 */     return 0.0D;
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
/*     */   public static long smcGetLong(IOKit.IOConnect paramIOConnect, String paramString) {
/* 219 */     SMCVal sMCVal = new SMCVal();
/* 220 */     int i = smcReadKey(paramIOConnect, paramString, sMCVal);
/* 221 */     if (i == 0) {
/* 222 */       return ParseUtil.byteArrayToLong(sMCVal.bytes, sMCVal.dataSize);
/*     */     }
/*     */     
/* 225 */     return 0L;
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
/*     */   public static int smcGetKeyInfo(IOKit.IOConnect paramIOConnect, SMCKeyData paramSMCKeyData1, SMCKeyData paramSMCKeyData2) {
/* 240 */     if (keyInfoCache.containsKey(Integer.valueOf(paramSMCKeyData1.key))) {
/* 241 */       SMCKeyDataKeyInfo sMCKeyDataKeyInfo = keyInfoCache.get(Integer.valueOf(paramSMCKeyData1.key));
/* 242 */       paramSMCKeyData2.keyInfo.dataSize = sMCKeyDataKeyInfo.dataSize;
/* 243 */       paramSMCKeyData2.keyInfo.dataType = sMCKeyDataKeyInfo.dataType;
/* 244 */       paramSMCKeyData2.keyInfo.dataAttributes = sMCKeyDataKeyInfo.dataAttributes;
/*     */     } else {
/* 246 */       paramSMCKeyData1.data8 = 9;
/* 247 */       int i = smcCall(paramIOConnect, 2, paramSMCKeyData1, paramSMCKeyData2);
/* 248 */       if (i != 0) {
/* 249 */         return i;
/*     */       }
/* 251 */       SMCKeyDataKeyInfo sMCKeyDataKeyInfo = new SMCKeyDataKeyInfo();
/* 252 */       sMCKeyDataKeyInfo.dataSize = paramSMCKeyData2.keyInfo.dataSize;
/* 253 */       sMCKeyDataKeyInfo.dataType = paramSMCKeyData2.keyInfo.dataType;
/* 254 */       sMCKeyDataKeyInfo.dataAttributes = paramSMCKeyData2.keyInfo.dataAttributes;
/* 255 */       keyInfoCache.put(Integer.valueOf(paramSMCKeyData1.key), sMCKeyDataKeyInfo);
/*     */     } 
/* 257 */     return 0;
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
/*     */   public static int smcReadKey(IOKit.IOConnect paramIOConnect, String paramString, SMCVal paramSMCVal) {
/* 272 */     SMCKeyData sMCKeyData1 = new SMCKeyData();
/* 273 */     SMCKeyData sMCKeyData2 = new SMCKeyData();
/*     */     
/* 275 */     sMCKeyData1.key = (int)ParseUtil.strToLong(paramString, 4);
/* 276 */     int i = smcGetKeyInfo(paramIOConnect, sMCKeyData1, sMCKeyData2);
/* 277 */     if (i == 0) {
/* 278 */       paramSMCVal.dataSize = sMCKeyData2.keyInfo.dataSize;
/* 279 */       paramSMCVal.dataType = ParseUtil.longToByteArray(sMCKeyData2.keyInfo.dataType, 4, 5);
/*     */       
/* 281 */       sMCKeyData1.keyInfo.dataSize = paramSMCVal.dataSize;
/* 282 */       sMCKeyData1.data8 = 5;
/*     */       
/* 284 */       i = smcCall(paramIOConnect, 2, sMCKeyData1, sMCKeyData2);
/* 285 */       if (i == 0) {
/* 286 */         System.arraycopy(sMCKeyData2.bytes, 0, paramSMCVal.bytes, 0, paramSMCVal.bytes.length);
/* 287 */         return 0;
/*     */       } 
/*     */     } 
/* 290 */     return i;
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
/*     */   public static int smcCall(IOKit.IOConnect paramIOConnect, int paramInt, SMCKeyData paramSMCKeyData1, SMCKeyData paramSMCKeyData2) {
/* 307 */     return IO.IOConnectCallStructMethod(paramIOConnect, paramInt, paramSMCKeyData1, new NativeLong(paramSMCKeyData1.size()), paramSMCKeyData2, new NativeLongByReference(new NativeLong(paramSMCKeyData2
/* 308 */             .size())));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\platform\mac\SmcUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */