/*     */ package org.apache.commons.io;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.lang.ref.PhantomReference;
/*     */ import java.lang.ref.ReferenceQueue;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FileCleaningTracker
/*     */ {
/*  51 */   ReferenceQueue<Object> q = new ReferenceQueue();
/*     */ 
/*     */ 
/*     */   
/*  55 */   final Collection<Tracker> trackers = Collections.synchronizedSet(new HashSet<>());
/*     */ 
/*     */ 
/*     */   
/*  59 */   final List<String> deleteFailures = Collections.synchronizedList(new ArrayList<>());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   volatile boolean exitWhenFinished = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Thread reaper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void track(File paramFile, Object paramObject) {
/*  80 */     track(paramFile, paramObject, (FileDeleteStrategy)null);
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
/*     */   public void track(File paramFile, Object paramObject, FileDeleteStrategy paramFileDeleteStrategy) {
/*  94 */     Objects.requireNonNull(paramFile, "file");
/*  95 */     addTracker(paramFile.getPath(), paramObject, paramFileDeleteStrategy);
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
/*     */   public void track(String paramString, Object paramObject) {
/* 108 */     track(paramString, paramObject, (FileDeleteStrategy)null);
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
/*     */   public void track(String paramString, Object paramObject, FileDeleteStrategy paramFileDeleteStrategy) {
/* 122 */     Objects.requireNonNull(paramString, "path");
/* 123 */     addTracker(paramString, paramObject, paramFileDeleteStrategy);
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
/*     */   private synchronized void addTracker(String paramString, Object paramObject, FileDeleteStrategy paramFileDeleteStrategy) {
/* 136 */     if (this.exitWhenFinished) {
/* 137 */       throw new IllegalStateException("No new trackers can be added once exitWhenFinished() is called");
/*     */     }
/* 139 */     if (this.reaper == null) {
/* 140 */       this.reaper = new Reaper();
/* 141 */       this.reaper.start();
/*     */     } 
/* 143 */     this.trackers.add(new Tracker(paramString, paramFileDeleteStrategy, paramObject, this.q));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTrackCount() {
/* 154 */     return this.trackers.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getDeleteFailures() {
/* 164 */     return this.deleteFailures;
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
/*     */   public synchronized void exitWhenFinished() {
/* 191 */     this.exitWhenFinished = true;
/* 192 */     if (this.reaper != null) {
/* 193 */       synchronized (this.reaper) {
/* 194 */         this.reaper.interrupt();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final class Reaper
/*     */     extends Thread
/*     */   {
/*     */     Reaper() {
/* 206 */       super("File Reaper");
/* 207 */       setPriority(10);
/* 208 */       setDaemon(true);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void run() {
/* 218 */       while (!FileCleaningTracker.this.exitWhenFinished || FileCleaningTracker.this.trackers.size() > 0) {
/*     */         
/*     */         try {
/* 221 */           FileCleaningTracker.Tracker tracker = (FileCleaningTracker.Tracker)FileCleaningTracker.this.q.remove();
/* 222 */           FileCleaningTracker.this.trackers.remove(tracker);
/* 223 */           if (!tracker.delete()) {
/* 224 */             FileCleaningTracker.this.deleteFailures.add(tracker.getPath());
/*     */           }
/* 226 */           tracker.clear();
/* 227 */         } catch (InterruptedException interruptedException) {}
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
/*     */   private static final class Tracker
/*     */     extends PhantomReference<Object>
/*     */   {
/*     */     private final String path;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final FileDeleteStrategy deleteStrategy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Tracker(String param1String, FileDeleteStrategy param1FileDeleteStrategy, Object param1Object, ReferenceQueue<? super Object> param1ReferenceQueue) {
/* 259 */       super(param1Object, param1ReferenceQueue);
/* 260 */       this.path = param1String;
/* 261 */       this.deleteStrategy = (param1FileDeleteStrategy == null) ? FileDeleteStrategy.NORMAL : param1FileDeleteStrategy;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getPath() {
/* 270 */       return this.path;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean delete() {
/* 280 */       return this.deleteStrategy.deleteQuietly(new File(this.path));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\FileCleaningTracker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */