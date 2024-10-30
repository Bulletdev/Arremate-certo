/*     */ package org.h2.util;
/*     */ 
/*     */ import java.lang.ref.PhantomReference;
/*     */ import java.lang.ref.Reference;
/*     */ import java.lang.ref.ReferenceQueue;
/*     */ import java.util.HashMap;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.store.fs.FileUtils;
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
/*     */ public class TempFileDeleter
/*     */ {
/*  22 */   private final ReferenceQueue<Object> queue = new ReferenceQueue();
/*  23 */   private final HashMap<PhantomReference<?>, String> refMap = New.hashMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TempFileDeleter getInstance() {
/*  30 */     return new TempFileDeleter();
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
/*     */   public synchronized Reference<?> addFile(String paramString, Object paramObject) {
/*  42 */     IOUtils.trace("TempFileDeleter.addFile", paramString, paramObject);
/*  43 */     PhantomReference<?> phantomReference = new PhantomReference(paramObject, this.queue);
/*  44 */     this.refMap.put(phantomReference, paramString);
/*  45 */     deleteUnused();
/*  46 */     return phantomReference;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void deleteFile(Reference<?> paramReference, String paramString) {
/*  56 */     if (paramReference != null) {
/*  57 */       String str = this.refMap.remove(paramReference);
/*  58 */       if (str != null) {
/*  59 */         if (SysProperties.CHECK && 
/*  60 */           paramString != null && !str.equals(paramString)) {
/*  61 */           DbException.throwInternalError("f2:" + str + " f:" + paramString);
/*     */         }
/*     */         
/*  64 */         paramString = str;
/*     */       } 
/*     */     } 
/*  67 */     if (paramString != null && FileUtils.exists(paramString)) {
/*     */       try {
/*  69 */         IOUtils.trace("TempFileDeleter.deleteFile", paramString, null);
/*  70 */         FileUtils.tryDelete(paramString);
/*  71 */       } catch (Exception exception) {}
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void deleteAll() {
/*  81 */     for (String str : New.arrayList(this.refMap.values())) {
/*  82 */       deleteFile(null, str);
/*     */     }
/*  84 */     deleteUnused();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void deleteUnused() {
/*  91 */     while (this.queue != null) {
/*  92 */       Reference<?> reference = this.queue.poll();
/*  93 */       if (reference == null) {
/*     */         break;
/*     */       }
/*  96 */       deleteFile(reference, null);
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
/*     */   public void stopAutoDelete(Reference<?> paramReference, String paramString) {
/* 108 */     IOUtils.trace("TempFileDeleter.stopAutoDelete", paramString, paramReference);
/* 109 */     if (paramReference != null) {
/* 110 */       String str = this.refMap.remove(paramReference);
/* 111 */       if (SysProperties.CHECK && (
/* 112 */         str == null || !str.equals(paramString))) {
/* 113 */         DbException.throwInternalError("f2:" + str + " " + ((str == null) ? "" : str) + " f:" + paramString);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 118 */     deleteUnused();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\TempFileDeleter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */