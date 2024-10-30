/*     */ package org.h2.util;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.lang.ref.PhantomReference;
/*     */ import java.lang.ref.ReferenceQueue;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
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
/*     */ public class CloseWatcher
/*     */   extends PhantomReference<Object>
/*     */ {
/*  27 */   private static ReferenceQueue<Object> queue = new ReferenceQueue();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  33 */   private static Set<CloseWatcher> refs = createSet();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String openStackTrace;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Closeable closeable;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CloseWatcher(Object paramObject, ReferenceQueue<Object> paramReferenceQueue, Closeable paramCloseable) {
/*  49 */     super(paramObject, paramReferenceQueue);
/*  50 */     this.closeable = paramCloseable;
/*     */   }
/*     */   
/*     */   private static Set<CloseWatcher> createSet() {
/*  54 */     return Collections.synchronizedSet(new HashSet<>());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CloseWatcher pollUnclosed() {
/*  63 */     ReferenceQueue<Object> referenceQueue = queue;
/*  64 */     if (referenceQueue == null) {
/*  65 */       return null;
/*     */     }
/*     */     while (true) {
/*  68 */       CloseWatcher closeWatcher = (CloseWatcher)referenceQueue.poll();
/*  69 */       if (closeWatcher == null) {
/*  70 */         return null;
/*     */       }
/*  72 */       if (refs != null) {
/*  73 */         refs.remove(closeWatcher);
/*     */       }
/*  75 */       if (closeWatcher.closeable != null) {
/*  76 */         return closeWatcher;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static CloseWatcher register(Object paramObject, Closeable paramCloseable, boolean paramBoolean) {
/*  93 */     ReferenceQueue<Object> referenceQueue = queue;
/*  94 */     if (referenceQueue == null) {
/*  95 */       referenceQueue = new ReferenceQueue();
/*  96 */       queue = referenceQueue;
/*     */     } 
/*  98 */     CloseWatcher closeWatcher = new CloseWatcher(paramObject, referenceQueue, paramCloseable);
/*  99 */     if (paramBoolean) {
/* 100 */       Exception exception = new Exception("Open Stack Trace");
/* 101 */       StringWriter stringWriter = new StringWriter();
/* 102 */       exception.printStackTrace(new PrintWriter(stringWriter));
/* 103 */       closeWatcher.openStackTrace = stringWriter.toString();
/*     */     } 
/* 105 */     if (refs == null) {
/* 106 */       refs = createSet();
/*     */     }
/* 108 */     refs.add(closeWatcher);
/* 109 */     return closeWatcher;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void unregister(CloseWatcher paramCloseWatcher) {
/* 118 */     paramCloseWatcher.closeable = null;
/* 119 */     refs.remove(paramCloseWatcher);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOpenStackTrace() {
/* 128 */     return this.openStackTrace;
/*     */   }
/*     */   
/*     */   public Closeable getCloseable() {
/* 132 */     return this.closeable;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\CloseWatcher.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */