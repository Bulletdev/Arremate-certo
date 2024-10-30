/*     */ package oshi.software.os.mac;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.PointerType;
/*     */ import com.sun.jna.platform.mac.CoreFoundation;
/*     */ import com.sun.jna.platform.mac.DiskArbitration;
/*     */ import com.sun.jna.platform.mac.IOKit;
/*     */ import com.sun.jna.platform.mac.IOKitUtil;
/*     */ import com.sun.jna.platform.mac.SystemB;
/*     */ import java.io.File;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.nio.file.PathMatcher;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Pattern;
/*     */ import java.util.stream.Collectors;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.software.common.AbstractFileSystem;
/*     */ import oshi.software.os.OSFileStore;
/*     */ import oshi.util.FileSystemUtil;
/*     */ import oshi.util.platform.mac.CFUtil;
/*     */ import oshi.util.platform.mac.SysctlUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class MacFileSystem
/*     */   extends AbstractFileSystem
/*     */ {
/*  70 */   private static final Logger LOG = LoggerFactory.getLogger(MacFileSystem.class);
/*     */   
/*     */   public static final String OSHI_MAC_FS_PATH_EXCLUDES = "oshi.os.mac.filesystem.path.excludes";
/*     */   
/*     */   public static final String OSHI_MAC_FS_PATH_INCLUDES = "oshi.os.mac.filesystem.path.includes";
/*     */   
/*     */   public static final String OSHI_MAC_FS_VOLUME_EXCLUDES = "oshi.os.mac.filesystem.volume.excludes";
/*     */   public static final String OSHI_MAC_FS_VOLUME_INCLUDES = "oshi.os.mac.filesystem.volume.includes";
/*  78 */   private static final List<PathMatcher> FS_PATH_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.mac.filesystem.path.excludes");
/*     */   
/*  80 */   private static final List<PathMatcher> FS_PATH_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.mac.filesystem.path.includes");
/*     */   
/*  82 */   private static final List<PathMatcher> FS_VOLUME_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.mac.filesystem.volume.excludes");
/*     */   
/*  84 */   private static final List<PathMatcher> FS_VOLUME_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.mac.filesystem.volume.includes");
/*     */ 
/*     */   
/*  87 */   private static final Pattern LOCAL_DISK = Pattern.compile("/dev/disk\\d");
/*     */   
/*     */   private static final int MNT_RDONLY = 1;
/*     */   
/*     */   private static final int MNT_SYNCHRONOUS = 2;
/*     */   
/*     */   private static final int MNT_NOEXEC = 4;
/*     */   private static final int MNT_NOSUID = 8;
/*     */   private static final int MNT_NODEV = 16;
/*     */   private static final int MNT_UNION = 32;
/*     */   private static final int MNT_ASYNC = 64;
/*     */   private static final int MNT_CPROTECT = 128;
/*     */   private static final int MNT_EXPORTED = 256;
/*     */   private static final int MNT_QUARANTINE = 1024;
/*     */   private static final int MNT_LOCAL = 4096;
/*     */   private static final int MNT_QUOTA = 8192;
/*     */   private static final int MNT_ROOTFS = 16384;
/*     */   private static final int MNT_DOVOLFS = 32768;
/*     */   private static final int MNT_DONTBROWSE = 1048576;
/*     */   private static final int MNT_IGNORE_OWNERSHIP = 2097152;
/*     */   private static final int MNT_AUTOMOUNTED = 4194304;
/*     */   private static final int MNT_JOURNALED = 8388608;
/*     */   private static final int MNT_NOUSERXATTR = 16777216;
/*     */   private static final int MNT_DEFWRITE = 33554432;
/*     */   private static final int MNT_MULTILABEL = 67108864;
/*     */   private static final int MNT_NOATIME = 268435456;
/* 113 */   private static final Map<Integer, String> OPTIONS_MAP = new HashMap<>();
/*     */   static {
/* 115 */     OPTIONS_MAP.put(Integer.valueOf(2), "synchronous");
/* 116 */     OPTIONS_MAP.put(Integer.valueOf(4), "noexec");
/* 117 */     OPTIONS_MAP.put(Integer.valueOf(8), "nosuid");
/* 118 */     OPTIONS_MAP.put(Integer.valueOf(16), "nodev");
/* 119 */     OPTIONS_MAP.put(Integer.valueOf(32), "union");
/* 120 */     OPTIONS_MAP.put(Integer.valueOf(64), "asynchronous");
/* 121 */     OPTIONS_MAP.put(Integer.valueOf(128), "content-protection");
/* 122 */     OPTIONS_MAP.put(Integer.valueOf(256), "exported");
/* 123 */     OPTIONS_MAP.put(Integer.valueOf(1024), "quarantined");
/* 124 */     OPTIONS_MAP.put(Integer.valueOf(4096), "local");
/* 125 */     OPTIONS_MAP.put(Integer.valueOf(8192), "quotas");
/* 126 */     OPTIONS_MAP.put(Integer.valueOf(16384), "rootfs");
/* 127 */     OPTIONS_MAP.put(Integer.valueOf(32768), "volfs");
/* 128 */     OPTIONS_MAP.put(Integer.valueOf(1048576), "nobrowse");
/* 129 */     OPTIONS_MAP.put(Integer.valueOf(2097152), "noowners");
/* 130 */     OPTIONS_MAP.put(Integer.valueOf(4194304), "automounted");
/* 131 */     OPTIONS_MAP.put(Integer.valueOf(8388608), "journaled");
/* 132 */     OPTIONS_MAP.put(Integer.valueOf(16777216), "nouserxattr");
/* 133 */     OPTIONS_MAP.put(Integer.valueOf(33554432), "defwrite");
/* 134 */     OPTIONS_MAP.put(Integer.valueOf(67108864), "multilabel");
/* 135 */     OPTIONS_MAP.put(Integer.valueOf(268435456), "noatime");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<OSFileStore> getFileStores(boolean paramBoolean) {
/* 141 */     return getFileStoreMatching((String)null, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   static List<OSFileStore> getFileStoreMatching(String paramString) {
/* 146 */     return getFileStoreMatching(paramString, false);
/*     */   }
/*     */   
/*     */   private static List<OSFileStore> getFileStoreMatching(String paramString, boolean paramBoolean) {
/* 150 */     ArrayList<MacOSFileStore> arrayList = new ArrayList();
/*     */ 
/*     */ 
/*     */     
/* 154 */     int i = SystemB.INSTANCE.getfsstat64(null, 0, 0);
/* 155 */     if (i > 0) {
/*     */ 
/*     */ 
/*     */       
/* 159 */       DiskArbitration.DASessionRef dASessionRef = DiskArbitration.INSTANCE.DASessionCreate(CoreFoundation.INSTANCE.CFAllocatorGetDefault());
/* 160 */       if (dASessionRef == null) {
/* 161 */         LOG.error("Unable to open session to DiskArbitration framework.");
/*     */       } else {
/* 163 */         CoreFoundation.CFStringRef cFStringRef = CoreFoundation.CFStringRef.createCFString("DAVolumeName");
/*     */ 
/*     */         
/* 166 */         SystemB.Statfs[] arrayOfStatfs = new SystemB.Statfs[i];
/*     */         
/* 168 */         i = SystemB.INSTANCE.getfsstat64(arrayOfStatfs, i * (new SystemB.Statfs()).size(), 16);
/* 169 */         for (byte b = 0; b < i; b++) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 175 */           String str1 = Native.toString((arrayOfStatfs[b]).f_mntfromname, StandardCharsets.UTF_8);
/* 176 */           String str2 = Native.toString((arrayOfStatfs[b]).f_mntonname, StandardCharsets.UTF_8);
/* 177 */           String str3 = Native.toString((arrayOfStatfs[b]).f_fstypename, StandardCharsets.UTF_8);
/*     */           
/* 179 */           int j = (arrayOfStatfs[b]).f_flags;
/*     */ 
/*     */           
/* 182 */           if ((!paramBoolean || (j & 0x1000) != 0) && (str2.equals("/") || (
/* 183 */             !PSEUDO_FS_TYPES.contains(str3) && !FileSystemUtil.isFileStoreExcluded(str2, str1, FS_PATH_INCLUDES, FS_PATH_EXCLUDES, FS_VOLUME_INCLUDES, FS_VOLUME_EXCLUDES)))) {
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 188 */             String str4 = "Volume";
/* 189 */             if (LOCAL_DISK.matcher(str1).matches()) {
/* 190 */               str4 = "Local Disk";
/* 191 */             } else if (str1.startsWith("localhost:") || str1.startsWith("//") || str1.startsWith("smb://") || NETWORK_FS_TYPES
/* 192 */               .contains(str3)) {
/* 193 */               str4 = "Network Drive";
/*     */             } 
/* 195 */             String str5 = "";
/* 196 */             File file = new File(str2);
/* 197 */             if (str5.isEmpty()) {
/* 198 */               str5 = file.getName();
/*     */               
/* 200 */               if (str5.isEmpty()) {
/* 201 */                 str5 = file.getPath();
/*     */               }
/*     */             } 
/* 204 */             if (paramString == null || paramString.equals(str5))
/*     */             
/*     */             { 
/*     */               
/* 208 */               StringBuilder stringBuilder = new StringBuilder(((0x1 & j) == 0) ? "rw" : "ro");
/*     */               
/* 210 */               String str6 = OPTIONS_MAP.entrySet().stream().filter(paramEntry -> ((((Integer)paramEntry.getKey()).intValue() & paramInt) > 0)).map(Map.Entry::getValue).collect(Collectors.joining(","));
/* 211 */               if (!str6.isEmpty()) {
/* 212 */                 stringBuilder.append(',').append(str6);
/*     */               }
/*     */               
/* 215 */               String str7 = "";
/*     */ 
/*     */               
/* 218 */               String str8 = str1.replace("/dev/disk", "disk");
/* 219 */               if (str8.startsWith("disk")) {
/*     */ 
/*     */                 
/* 222 */                 DiskArbitration.DADiskRef dADiskRef = DiskArbitration.INSTANCE.DADiskCreateFromBSDName(CoreFoundation.INSTANCE
/* 223 */                     .CFAllocatorGetDefault(), dASessionRef, str1);
/* 224 */                 if (dADiskRef != null) {
/* 225 */                   CoreFoundation.CFDictionaryRef cFDictionaryRef = DiskArbitration.INSTANCE.DADiskCopyDescription(dADiskRef);
/* 226 */                   if (cFDictionaryRef != null) {
/*     */                     
/* 228 */                     Pointer pointer = cFDictionaryRef.getValue((PointerType)cFStringRef);
/* 229 */                     str5 = CFUtil.cfPointerToString(pointer);
/* 230 */                     cFDictionaryRef.release();
/*     */                   } 
/* 232 */                   dADiskRef.release();
/*     */                 } 
/*     */                 
/* 235 */                 CoreFoundation.CFMutableDictionaryRef cFMutableDictionaryRef = IOKitUtil.getBSDNameMatchingDict(str8);
/* 236 */                 if (cFMutableDictionaryRef != null) {
/*     */                   
/* 238 */                   IOKit.IOIterator iOIterator = IOKitUtil.getMatchingServices((CoreFoundation.CFDictionaryRef)cFMutableDictionaryRef);
/* 239 */                   if (iOIterator != null) {
/*     */ 
/*     */                     
/* 242 */                     IOKit.IORegistryEntry iORegistryEntry = iOIterator.next();
/* 243 */                     if (iORegistryEntry != null && iORegistryEntry.conformsTo("IOMedia")) {
/*     */                       
/* 245 */                       str7 = iORegistryEntry.getStringProperty("UUID");
/* 246 */                       if (str7 != null) {
/* 247 */                         str7 = str7.toLowerCase();
/*     */                       }
/* 249 */                       iORegistryEntry.release();
/*     */                     } 
/* 251 */                     iOIterator.release();
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */               
/* 256 */               arrayList.add(new MacOSFileStore(str5, str1, str5, str2, stringBuilder.toString(), 
/* 257 */                     (str7 == null) ? "" : str7, "", str4, str3, file.getFreeSpace(), file.getUsableSpace(), file
/* 258 */                     .getTotalSpace(), (arrayOfStatfs[b]).f_ffree, (arrayOfStatfs[b]).f_files)); } 
/*     */           } 
/* 260 */         }  cFStringRef.release();
/*     */         
/* 262 */         dASessionRef.release();
/*     */       } 
/*     */     } 
/* 265 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getOpenFileDescriptors() {
/* 270 */     return SysctlUtil.sysctl("kern.num_files", 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMaxFileDescriptors() {
/* 275 */     return SysctlUtil.sysctl("kern.maxfiles", 0);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\mac\MacFileSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */