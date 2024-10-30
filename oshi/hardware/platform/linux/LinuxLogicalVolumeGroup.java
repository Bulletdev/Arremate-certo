/*     */ package oshi.hardware.platform.linux;
/*     */ 
/*     */ import com.sun.jna.platform.linux.Udev;
/*     */ import java.io.File;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.stream.Collectors;
/*     */ import oshi.hardware.LogicalVolumeGroup;
/*     */ import oshi.hardware.common.AbstractLogicalVolumeGroup;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.ParseUtil;
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
/*     */ final class LinuxLogicalVolumeGroup
/*     */   extends AbstractLogicalVolumeGroup
/*     */ {
/*     */   private static final String BLOCK = "block";
/*     */   private static final String DM_UUID = "DM_UUID";
/*     */   private static final String DM_VG_NAME = "DM_VG_NAME";
/*     */   private static final String DM_LV_NAME = "DM_LV_NAME";
/*     */   private static final String DEV_LOCATION = "/dev/";
/*     */   
/*     */   LinuxLogicalVolumeGroup(String paramString, Map<String, Set<String>> paramMap, Set<String> paramSet) {
/*  51 */     super(paramString, paramMap, paramSet);
/*     */   }
/*     */   
/*     */   static List<LogicalVolumeGroup> getLogicalVolumeGroups() {
/*  55 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/*  56 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/*     */ 
/*     */ 
/*     */     
/*  60 */     for (String str : ExecutingCommand.runNative("pvs -o vg_name,pv_name")) {
/*  61 */       String[] arrayOfString = ParseUtil.whitespaces.split(str.trim());
/*  62 */       if (arrayOfString.length == 2 && arrayOfString[1].startsWith("/dev/")) {
/*  63 */         ((Set<String>)hashMap2.computeIfAbsent(arrayOfString[0], paramString -> new HashSet())).add(arrayOfString[1]);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  68 */     Udev.UdevContext udevContext = Udev.INSTANCE.udev_new();
/*     */     try {
/*  70 */       Udev.UdevEnumerate udevEnumerate = udevContext.enumerateNew();
/*     */       try {
/*  72 */         udevEnumerate.addMatchSubsystem("block");
/*  73 */         udevEnumerate.scanDevices();
/*  74 */         for (Udev.UdevListEntry udevListEntry = udevEnumerate.getListEntry(); udevListEntry != null; udevListEntry = udevListEntry.getNext()) {
/*  75 */           String str = udevListEntry.getName();
/*  76 */           Udev.UdevDevice udevDevice = udevContext.deviceNewFromSyspath(str);
/*  77 */           if (udevDevice != null) {
/*     */             
/*  79 */             try { String str1 = udevDevice.getDevnode();
/*  80 */               if (str1 != null && str1.startsWith("/dev/dm")) {
/*  81 */                 String str2 = udevDevice.getPropertyValue("DM_UUID");
/*  82 */                 if (str2 != null && str2.startsWith("LVM-")) {
/*  83 */                   String str3 = udevDevice.getPropertyValue("DM_VG_NAME");
/*  84 */                   String str4 = udevDevice.getPropertyValue("DM_LV_NAME");
/*  85 */                   if (!Util.isBlank(str3) && !Util.isBlank(str4)) {
/*  86 */                     hashMap1.computeIfAbsent(str3, paramString -> new HashMap<>());
/*  87 */                     Map<String, Set<String>> map = (Map)hashMap1.get(str3);
/*     */                     
/*  89 */                     hashMap2.computeIfAbsent(str3, paramString -> new HashSet());
/*  90 */                     Set<String> set = (Set)hashMap2.get(str3);
/*     */                     
/*  92 */                     File file = new File(str + "/slaves");
/*  93 */                     File[] arrayOfFile = file.listFiles();
/*  94 */                     if (arrayOfFile != null) {
/*  95 */                       for (File file1 : arrayOfFile) {
/*  96 */                         String str5 = file1.getName();
/*  97 */                         ((Set<String>)map.computeIfAbsent(str4, paramString -> new HashSet()))
/*  98 */                           .add("/dev/" + str5);
/*     */ 
/*     */                         
/* 101 */                         set.add("/dev/" + str5);
/*     */                       } 
/*     */                     }
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */               
/* 108 */               udevDevice.unref(); } finally { udevDevice.unref(); }
/*     */           
/*     */           }
/*     */         } 
/*     */       } finally {
/* 113 */         udevEnumerate.unref();
/*     */       } 
/*     */     } finally {
/* 116 */       udevContext.unref();
/*     */     } 
/* 118 */     return (List<LogicalVolumeGroup>)hashMap1.entrySet().stream()
/* 119 */       .map(paramEntry -> new LinuxLogicalVolumeGroup((String)paramEntry.getKey(), (Map<String, Set<String>>)paramEntry.getValue(), (Set<String>)paramMap.get(paramEntry.getKey())))
/* 120 */       .collect(Collectors.toList());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\linux\LinuxLogicalVolumeGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */