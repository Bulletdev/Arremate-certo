/*     */ package org.h2.store;
/*     */ 
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.channels.FileLock;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.message.TraceSystem;
/*     */ import org.h2.store.fs.FilePath;
/*     */ import org.h2.store.fs.FileUtils;
/*     */ import org.h2.util.New;
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
/*     */ public class FileLister
/*     */ {
/*     */   public static void tryUnlockDatabase(List<String> paramList, String paramString) throws SQLException {
/*  39 */     for (String str : paramList) {
/*  40 */       if (str.endsWith(".lock.db")) {
/*  41 */         FileLock fileLock = new FileLock(new TraceSystem(null), str, 1000);
/*     */         
/*     */         try {
/*  44 */           fileLock.lock(1);
/*  45 */           fileLock.unlock();
/*  46 */         } catch (DbException dbException) {
/*  47 */           throw DbException.get(90133, paramString).getSQLException();
/*     */         } 
/*     */         continue;
/*     */       } 
/*  51 */       if (str.endsWith(".mv.db")) {
/*  52 */         try (FileChannel null = FilePath.get(str).open("r")) {
/*  53 */           FileLock fileLock = fileChannel.tryLock(0L, Long.MAX_VALUE, true);
/*  54 */           fileLock.release();
/*  55 */         } catch (Exception exception) {
/*  56 */           throw DbException.get(90133, exception, new String[] { paramString }).getSQLException();
/*     */         } 
/*     */       }
/*     */     } 
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
/*     */   public static String getDir(String paramString) {
/*  71 */     if (paramString == null || paramString.equals("")) {
/*  72 */       return ".";
/*     */     }
/*  74 */     return FileUtils.toRealPath(paramString);
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
/*     */   public static ArrayList<String> getDatabaseFiles(String paramString1, String paramString2, boolean paramBoolean) {
/*  89 */     ArrayList<String> arrayList = New.arrayList();
/*     */     
/*  91 */     String str = (paramString2 == null) ? null : (FileUtils.toRealPath(paramString1 + "/" + paramString2) + ".");
/*  92 */     for (String str1 : FileUtils.newDirectoryStream(paramString1)) {
/*  93 */       boolean bool = false;
/*  94 */       if (str1.endsWith(".lobs.db")) {
/*  95 */         if (str == null || str1.startsWith(str)) {
/*  96 */           arrayList.addAll(getDatabaseFiles(str1, null, paramBoolean));
/*  97 */           bool = true;
/*     */         } 
/*  99 */       } else if (str1.endsWith(".lob.db")) {
/* 100 */         bool = true;
/* 101 */       } else if (str1.endsWith(".h2.db")) {
/* 102 */         bool = true;
/* 103 */       } else if (str1.endsWith(".mv.db")) {
/* 104 */         bool = true;
/* 105 */       } else if (paramBoolean) {
/* 106 */         if (str1.endsWith(".lock.db")) {
/* 107 */           bool = true;
/* 108 */         } else if (str1.endsWith(".temp.db")) {
/* 109 */           bool = true;
/* 110 */         } else if (str1.endsWith(".trace.db")) {
/* 111 */           bool = true;
/*     */         } 
/*     */       } 
/* 114 */       if (bool && (
/* 115 */         paramString2 == null || str1.startsWith(str))) {
/* 116 */         String str2 = str1;
/* 117 */         arrayList.add(str2);
/*     */       } 
/*     */     } 
/*     */     
/* 121 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\FileLister.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */