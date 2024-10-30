/*     */ package com.sun.jna.platform;
/*     */ 
/*     */ import com.sun.jna.platform.mac.MacFileUtils;
/*     */ import com.sun.jna.platform.win32.W32FileUtils;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
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
/*     */ public abstract class FileUtils
/*     */ {
/*     */   public boolean hasTrash() {
/*  38 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract void moveToTrash(File... paramVarArgs) throws IOException;
/*     */ 
/*     */   
/*     */   private static class Holder
/*     */   {
/*     */     public static final FileUtils INSTANCE;
/*     */ 
/*     */     
/*     */     static {
/*  51 */       String str = System.getProperty("os.name");
/*  52 */       if (str.startsWith("Windows")) {
/*  53 */         INSTANCE = (FileUtils)new W32FileUtils();
/*     */       }
/*  55 */       else if (str.startsWith("Mac")) {
/*  56 */         INSTANCE = (FileUtils)new MacFileUtils();
/*     */       } else {
/*     */         
/*  59 */         INSTANCE = new FileUtils.DefaultFileUtils();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static FileUtils getInstance() {
/*  65 */     return Holder.INSTANCE;
/*     */   }
/*     */   
/*     */   private static class DefaultFileUtils
/*     */     extends FileUtils {
/*     */     private DefaultFileUtils() {}
/*     */     
/*     */     private File getTrashDirectory() {
/*  73 */       File file1 = new File(System.getProperty("user.home"));
/*  74 */       File file2 = new File(file1, ".Trash");
/*  75 */       if (!file2.exists()) {
/*  76 */         file2 = new File(file1, "Trash");
/*  77 */         if (!file2.exists()) {
/*  78 */           File file = new File(file1, "Desktop");
/*  79 */           if (file.exists()) {
/*  80 */             file2 = new File(file, ".Trash");
/*  81 */             if (!file2.exists()) {
/*  82 */               file2 = new File(file, "Trash");
/*  83 */               if (!file2.exists()) {
/*  84 */                 file2 = new File(System.getProperty("fileutils.trash", "Trash"));
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*  90 */       return file2;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasTrash() {
/*  95 */       return getTrashDirectory().exists();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void moveToTrash(File... param1VarArgs) throws IOException {
/* 103 */       File file = getTrashDirectory();
/* 104 */       if (!file.exists()) {
/* 105 */         throw new IOException("No trash location found (define fileutils.trash to be the path to the trash)");
/*     */       }
/* 107 */       ArrayList<File> arrayList = new ArrayList();
/* 108 */       for (byte b = 0; b < param1VarArgs.length; b++) {
/* 109 */         File file1 = param1VarArgs[b];
/* 110 */         File file2 = new File(file, file1.getName());
/* 111 */         if (!file1.renameTo(file2)) {
/* 112 */           arrayList.add(file1);
/*     */         }
/*     */       } 
/* 115 */       if (arrayList.size() > 0)
/* 116 */         throw new IOException("The following files could not be trashed: " + arrayList); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */