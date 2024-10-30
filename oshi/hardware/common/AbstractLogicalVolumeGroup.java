/*    */ package oshi.hardware.common;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import oshi.hardware.LogicalVolumeGroup;
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
/*    */ public class AbstractLogicalVolumeGroup
/*    */   implements LogicalVolumeGroup
/*    */ {
/*    */   private final String name;
/*    */   private final Map<String, Set<String>> lvMap;
/*    */   private final Set<String> pvSet;
/*    */   
/*    */   protected AbstractLogicalVolumeGroup(String paramString, Map<String, Set<String>> paramMap, Set<String> paramSet) {
/* 49 */     this.name = paramString;
/* 50 */     for (Map.Entry<String, Set<String>> entry : paramMap.entrySet()) {
/* 51 */       paramMap.put((String)entry.getKey(), Collections.unmodifiableSet((Set<? extends String>)entry.getValue()));
/*    */     }
/* 53 */     this.lvMap = Collections.unmodifiableMap(paramMap);
/* 54 */     this.pvSet = Collections.unmodifiableSet(paramSet);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 59 */     return this.name;
/*    */   }
/*    */ 
/*    */   
/*    */   public Map<String, Set<String>> getLogicalVolumes() {
/* 64 */     return this.lvMap;
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<String> getPhysicalVolumes() {
/* 69 */     return this.pvSet;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder stringBuilder = new StringBuilder("Logical Volume Group: ");
/* 75 */     stringBuilder.append(this.name).append("\n |-- PVs: ");
/* 76 */     stringBuilder.append(this.pvSet.toString());
/* 77 */     for (Map.Entry<String, Set<String>> entry : this.lvMap.entrySet()) {
/* 78 */       stringBuilder.append("\n |-- LV: ").append((String)entry.getKey());
/* 79 */       Set set = (Set)entry.getValue();
/* 80 */       if (!set.isEmpty()) {
/* 81 */         stringBuilder.append(" --> ").append(set);
/*    */       }
/*    */     } 
/* 84 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\common\AbstractLogicalVolumeGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */