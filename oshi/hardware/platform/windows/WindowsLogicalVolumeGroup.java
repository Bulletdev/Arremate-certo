/*     */ package oshi.hardware.platform.windows;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.COMException;
/*     */ import com.sun.jna.platform.win32.COM.WbemcliUtil;
/*     */ import com.sun.jna.platform.win32.VersionHelpers;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.driver.windows.wmi.MSFTStorage;
/*     */ import oshi.hardware.LogicalVolumeGroup;
/*     */ import oshi.hardware.common.AbstractLogicalVolumeGroup;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.windows.WmiQueryHandler;
/*     */ import oshi.util.platform.windows.WmiUtil;
/*     */ import oshi.util.tuples.Pair;
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
/*     */ final class WindowsLogicalVolumeGroup
/*     */   extends AbstractLogicalVolumeGroup
/*     */ {
/*  58 */   private static final Logger LOG = LoggerFactory.getLogger(WindowsLogicalVolumeGroup.class);
/*     */   
/*  60 */   private static final Pattern SP_OBJECT_ID = Pattern.compile(".*ObjectId=.*SP:(\\{.*\\}).*");
/*  61 */   private static final Pattern PD_OBJECT_ID = Pattern.compile(".*ObjectId=.*PD:(\\{.*\\}).*");
/*  62 */   private static final Pattern VD_OBJECT_ID = Pattern.compile(".*ObjectId=.*VD:(\\{.*\\})(\\{.*\\}).*");
/*     */   
/*  64 */   private static final boolean IS_WINDOWS8_OR_GREATER = VersionHelpers.IsWindows8OrGreater();
/*     */   
/*     */   WindowsLogicalVolumeGroup(String paramString, Map<String, Set<String>> paramMap, Set<String> paramSet) {
/*  67 */     super(paramString, paramMap, paramSet);
/*     */   }
/*     */ 
/*     */   
/*     */   static List<LogicalVolumeGroup> getLogicalVolumeGroups() {
/*  72 */     if (!IS_WINDOWS8_OR_GREATER) {
/*  73 */       return Collections.emptyList();
/*     */     }
/*  75 */     WmiQueryHandler wmiQueryHandler = WmiQueryHandler.createInstance();
/*  76 */     boolean bool = false;
/*     */     try {
/*  78 */       bool = wmiQueryHandler.initCOM();
/*     */       
/*  80 */       WbemcliUtil.WmiResult wmiResult1 = MSFTStorage.queryStoragePools(wmiQueryHandler);
/*  81 */       int i = wmiResult1.getResultCount();
/*  82 */       if (i == 0) {
/*  83 */         return (List)Collections.emptyList();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  88 */       HashMap<Object, Object> hashMap1 = new HashMap<>();
/*  89 */       WbemcliUtil.WmiResult wmiResult2 = MSFTStorage.queryVirtualDisks(wmiQueryHandler);
/*  90 */       i = wmiResult2.getResultCount();
/*  91 */       for (byte b1 = 0; b1 < i; b1++) {
/*  92 */         String str = WmiUtil.getString(wmiResult2, (Enum)MSFTStorage.VirtualDiskProperty.OBJECTID, b1);
/*  93 */         Matcher matcher = VD_OBJECT_ID.matcher(str);
/*  94 */         if (matcher.matches()) {
/*  95 */           str = matcher.group(2) + " " + matcher.group(1);
/*     */         }
/*     */         
/*  98 */         hashMap1.put(str, WmiUtil.getString(wmiResult2, (Enum)MSFTStorage.VirtualDiskProperty.FRIENDLYNAME, b1));
/*     */       } 
/*     */ 
/*     */       
/* 102 */       HashMap<Object, Object> hashMap2 = new HashMap<>();
/* 103 */       WbemcliUtil.WmiResult wmiResult3 = MSFTStorage.queryPhysicalDisks(wmiQueryHandler);
/* 104 */       i = wmiResult3.getResultCount();
/* 105 */       for (byte b2 = 0; b2 < i; b2++) {
/* 106 */         String str = WmiUtil.getString(wmiResult3, (Enum)MSFTStorage.PhysicalDiskProperty.OBJECTID, b2);
/* 107 */         Matcher matcher = PD_OBJECT_ID.matcher(str);
/* 108 */         if (matcher.matches()) {
/* 109 */           str = matcher.group(1);
/*     */         }
/*     */         
/* 112 */         hashMap2.put(str, new Pair(WmiUtil.getString(wmiResult3, (Enum)MSFTStorage.PhysicalDiskProperty.FRIENDLYNAME, b2), 
/* 113 */               WmiUtil.getString(wmiResult3, (Enum)MSFTStorage.PhysicalDiskProperty.PHYSICALLOCATION, b2)));
/*     */       } 
/*     */ 
/*     */       
/* 117 */       HashMap<Object, Object> hashMap3 = new HashMap<>();
/* 118 */       WbemcliUtil.WmiResult wmiResult4 = MSFTStorage.queryStoragePoolPhysicalDisks(wmiQueryHandler);
/* 119 */       i = wmiResult4.getResultCount();
/* 120 */       for (byte b3 = 0; b3 < i; b3++) {
/*     */         
/* 122 */         String str1 = WmiUtil.getRefString(wmiResult4, (Enum)MSFTStorage.StoragePoolToPhysicalDiskProperty.STORAGEPOOL, b3);
/* 123 */         Matcher matcher = SP_OBJECT_ID.matcher(str1);
/* 124 */         if (matcher.matches()) {
/* 125 */           str1 = matcher.group(1);
/*     */         }
/* 127 */         String str2 = WmiUtil.getRefString(wmiResult4, (Enum)MSFTStorage.StoragePoolToPhysicalDiskProperty.PHYSICALDISK, b3);
/* 128 */         matcher = PD_OBJECT_ID.matcher(str2);
/* 129 */         if (matcher.matches()) {
/* 130 */           str2 = matcher.group(1);
/*     */         }
/* 132 */         hashMap3.put(str1 + " " + str2, str2);
/*     */       } 
/*     */ 
/*     */       
/* 136 */       ArrayList<WindowsLogicalVolumeGroup> arrayList = new ArrayList();
/* 137 */       i = wmiResult1.getResultCount();
/* 138 */       for (byte b4 = 0; b4 < i; b4++) {
/*     */         
/* 140 */         String str1 = WmiUtil.getString(wmiResult1, (Enum)MSFTStorage.StoragePoolProperty.FRIENDLYNAME, b4);
/*     */         
/* 142 */         String str2 = WmiUtil.getString(wmiResult1, (Enum)MSFTStorage.StoragePoolProperty.OBJECTID, b4);
/* 143 */         Matcher matcher = SP_OBJECT_ID.matcher(str2);
/* 144 */         if (matcher.matches()) {
/* 145 */           str2 = matcher.group(1);
/*     */         }
/*     */         
/* 148 */         HashSet<String> hashSet = new HashSet();
/* 149 */         for (Map.Entry<Object, Object> entry : hashMap3.entrySet()) {
/* 150 */           if (((String)entry.getKey()).contains(str2)) {
/* 151 */             String str = (String)entry.getValue();
/* 152 */             Pair pair = (Pair)hashMap2.get(str);
/* 153 */             if (pair != null) {
/* 154 */               hashSet.add((String)pair.getA() + " @ " + (String)pair.getB());
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 159 */         HashMap<Object, Object> hashMap = new HashMap<>();
/* 160 */         for (Map.Entry<Object, Object> entry : hashMap1.entrySet()) {
/* 161 */           if (((String)entry.getKey()).contains(str2)) {
/* 162 */             String str = ParseUtil.whitespaces.split((CharSequence)entry.getKey())[0];
/* 163 */             hashMap.put((String)entry.getValue() + " " + str, hashSet);
/*     */           } 
/*     */         } 
/*     */         
/* 167 */         arrayList.add(new WindowsLogicalVolumeGroup(str1, (Map)hashMap, hashSet));
/*     */       } 
/*     */       
/* 170 */       return (List)arrayList;
/* 171 */     } catch (COMException cOMException) {
/* 172 */       LOG.warn("COM exception: {}", cOMException.getMessage());
/* 173 */       return (List)Collections.emptyList();
/*     */     } finally {
/* 175 */       if (bool)
/* 176 */         wmiQueryHandler.unInitCOM(); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\windows\WindowsLogicalVolumeGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */