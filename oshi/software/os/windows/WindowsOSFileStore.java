/*     */ package oshi.software.os.windows;
/*     */ 
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.software.common.AbstractOSFileStore;
/*     */ import oshi.software.os.OSFileStore;
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
/*     */ public class WindowsOSFileStore
/*     */   extends AbstractOSFileStore
/*     */ {
/*     */   private String logicalVolume;
/*     */   private String description;
/*     */   private String fsType;
/*     */   private long freeSpace;
/*     */   private long usableSpace;
/*     */   private long totalSpace;
/*     */   private long freeInodes;
/*     */   private long totalInodes;
/*     */   
/*     */   public WindowsOSFileStore(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {
/*  51 */     super(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
/*  52 */     this.logicalVolume = paramString7;
/*  53 */     this.description = paramString8;
/*  54 */     this.fsType = paramString9;
/*  55 */     this.freeSpace = paramLong1;
/*  56 */     this.usableSpace = paramLong2;
/*  57 */     this.totalSpace = paramLong3;
/*  58 */     this.freeInodes = paramLong4;
/*  59 */     this.totalInodes = paramLong5;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getLogicalVolume() {
/*  64 */     return this.logicalVolume;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  69 */     return this.description;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getType() {
/*  74 */     return this.fsType;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getFreeSpace() {
/*  79 */     return this.freeSpace;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUsableSpace() {
/*  84 */     return this.usableSpace;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTotalSpace() {
/*  89 */     return this.totalSpace;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getFreeInodes() {
/*  94 */     return this.freeInodes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTotalInodes() {
/*  99 */     return this.totalInodes;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 105 */     List<OSFileStore> list = WindowsFileSystem.getLocalVolumes(getVolume());
/* 106 */     if (list.isEmpty()) {
/*     */       
/* 108 */       String str = (getMount().length() < 2) ? null : getMount().substring(0, 2);
/* 109 */       list = WindowsFileSystem.getWmiVolumes(str, false);
/*     */     } 
/* 111 */     for (OSFileStore oSFileStore : list) {
/* 112 */       if (getVolume().equals(oSFileStore.getVolume()) && getMount().equals(oSFileStore.getMount())) {
/* 113 */         this.logicalVolume = oSFileStore.getLogicalVolume();
/* 114 */         this.description = oSFileStore.getDescription();
/* 115 */         this.fsType = oSFileStore.getType();
/* 116 */         this.freeSpace = oSFileStore.getFreeSpace();
/* 117 */         this.usableSpace = oSFileStore.getUsableSpace();
/* 118 */         this.totalSpace = oSFileStore.getTotalSpace();
/* 119 */         this.freeInodes = oSFileStore.getFreeInodes();
/* 120 */         this.totalInodes = oSFileStore.getTotalInodes();
/* 121 */         return true;
/*     */       } 
/*     */     } 
/* 124 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\windows\WindowsOSFileStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */