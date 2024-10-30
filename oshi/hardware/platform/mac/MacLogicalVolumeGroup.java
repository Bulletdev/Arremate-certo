/*    */ package oshi.hardware.platform.mac;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import java.util.stream.Collectors;
/*    */ import oshi.hardware.LogicalVolumeGroup;
/*    */ import oshi.hardware.common.AbstractLogicalVolumeGroup;
/*    */ import oshi.util.ExecutingCommand;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class MacLogicalVolumeGroup
/*    */   extends AbstractLogicalVolumeGroup
/*    */ {
/*    */   private static final String DISKUTIL_CS_LIST = "diskutil cs list";
/*    */   private static final String LOGICAL_VOLUME_GROUP = "Logical Volume Group";
/*    */   private static final String PHYSICAL_VOLUME = "Physical Volume";
/*    */   private static final String LOGICAL_VOLUME = "Logical Volume";
/*    */   
/*    */   MacLogicalVolumeGroup(String paramString, Map<String, Set<String>> paramMap, Set<String> paramSet) {
/* 46 */     super(paramString, paramMap, paramSet);
/*    */   }
/*    */   
/*    */   static List<LogicalVolumeGroup> getLogicalVolumeGroups() {
/* 50 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/* 51 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/*    */     
/* 53 */     String str = null;
/* 54 */     boolean bool1 = false;
/* 55 */     boolean bool2 = false;
/*    */ 
/*    */     
/* 58 */     for (String str1 : ExecutingCommand.runNative("diskutil cs list")) {
/* 59 */       if (str1.contains("Logical Volume Group")) {
/*    */         
/* 61 */         bool1 = true; continue;
/* 62 */       }  if (bool1) {
/* 63 */         int j = str1.indexOf("Name:");
/* 64 */         if (j >= 0) {
/* 65 */           str = str1.substring(j + 5).trim();
/* 66 */           bool1 = false;
/*    */         }  continue;
/* 68 */       }  if (str1.contains("Physical Volume")) {
/* 69 */         bool2 = true; continue;
/* 70 */       }  if (str1.contains("Logical Volume")) {
/* 71 */         bool2 = false; continue;
/*    */       } 
/* 73 */       int i = str1.indexOf("Disk:");
/* 74 */       if (i >= 0) {
/* 75 */         if (bool2) {
/* 76 */           ((Set<String>)hashMap2.computeIfAbsent(str, paramString -> new HashSet()))
/* 77 */             .add(str1.substring(i + 5).trim()); continue;
/*    */         } 
/* 79 */         ((Map)hashMap1.computeIfAbsent(str, paramString -> new HashMap<>()))
/* 80 */           .put(str1.substring(i + 5).trim(), Collections.emptySet());
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 85 */     return (List<LogicalVolumeGroup>)hashMap1.entrySet().stream()
/* 86 */       .map(paramEntry -> new MacLogicalVolumeGroup((String)paramEntry.getKey(), (Map<String, Set<String>>)paramEntry.getValue(), (Set<String>)paramMap.get(paramEntry.getKey())))
/* 87 */       .collect(Collectors.toList());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\mac\MacLogicalVolumeGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */