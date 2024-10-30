/*     */ package oshi.software.os.unix.aix;
/*     */ 
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
/*     */ @ThreadSafe
/*     */ public class AixOSFileStore
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
/*     */   public AixOSFileStore(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {
/*  49 */     super(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
/*  50 */     this.logicalVolume = paramString7;
/*  51 */     this.description = paramString8;
/*  52 */     this.fsType = paramString9;
/*  53 */     this.freeSpace = paramLong1;
/*  54 */     this.usableSpace = paramLong2;
/*  55 */     this.totalSpace = paramLong3;
/*  56 */     this.freeInodes = paramLong4;
/*  57 */     this.totalInodes = paramLong5;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getLogicalVolume() {
/*  62 */     return this.logicalVolume;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  67 */     return this.description;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getType() {
/*  72 */     return this.fsType;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getFreeSpace() {
/*  77 */     return this.freeSpace;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUsableSpace() {
/*  82 */     return this.usableSpace;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTotalSpace() {
/*  87 */     return this.totalSpace;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getFreeInodes() {
/*  92 */     return this.freeInodes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTotalInodes() {
/*  97 */     return this.totalInodes;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 102 */     for (OSFileStore oSFileStore : AixFileSystem.getFileStoreMatching(getName())) {
/* 103 */       if (getVolume().equals(oSFileStore.getVolume()) && getMount().equals(oSFileStore.getMount())) {
/* 104 */         this.logicalVolume = oSFileStore.getLogicalVolume();
/* 105 */         this.description = oSFileStore.getDescription();
/* 106 */         this.fsType = oSFileStore.getType();
/* 107 */         this.freeSpace = oSFileStore.getFreeSpace();
/* 108 */         this.usableSpace = oSFileStore.getUsableSpace();
/* 109 */         this.totalSpace = oSFileStore.getTotalSpace();
/* 110 */         this.freeInodes = oSFileStore.getFreeInodes();
/* 111 */         this.totalInodes = oSFileStore.getTotalInodes();
/* 112 */         return true;
/*     */       } 
/*     */     } 
/* 115 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\o\\unix\aix\AixOSFileStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */