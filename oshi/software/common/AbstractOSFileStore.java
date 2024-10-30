/*    */ package oshi.software.common;
/*    */ 
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.software.os.OSFileStore;
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
/*    */ @ThreadSafe
/*    */ public abstract class AbstractOSFileStore
/*    */   implements OSFileStore
/*    */ {
/*    */   private String name;
/*    */   private String volume;
/*    */   private String label;
/*    */   private String mount;
/*    */   private String options;
/*    */   private String uuid;
/*    */   
/*    */   protected AbstractOSFileStore(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
/* 43 */     this.name = paramString1;
/* 44 */     this.volume = paramString2;
/* 45 */     this.label = paramString3;
/* 46 */     this.mount = paramString4;
/* 47 */     this.options = paramString5;
/* 48 */     this.uuid = paramString6;
/*    */   }
/*    */ 
/*    */   
/*    */   protected AbstractOSFileStore() {}
/*    */ 
/*    */   
/*    */   public String getName() {
/* 56 */     return this.name;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getVolume() {
/* 61 */     return this.volume;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getLabel() {
/* 66 */     return this.label;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getMount() {
/* 71 */     return this.mount;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getOptions() {
/* 76 */     return this.options;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUUID() {
/* 81 */     return this.uuid;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 86 */     return "OSFileStore [name=" + getName() + ", volume=" + getVolume() + ", label=" + getLabel() + ", logicalVolume=" + 
/* 87 */       getLogicalVolume() + ", mount=" + getMount() + ", description=" + 
/* 88 */       getDescription() + ", fsType=" + getType() + ", options=\"" + getOptions() + "\", uuid=" + getUUID() + ", freeSpace=" + 
/* 89 */       getFreeSpace() + ", usableSpace=" + getUsableSpace() + ", totalSpace=" + 
/* 90 */       getTotalSpace() + ", freeInodes=" + getFreeInodes() + ", totalInodes=" + getTotalInodes() + "]";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\common\AbstractOSFileStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */