/*     */ package ch.qos.logback.core.spi;
/*     */ 
/*     */ import ch.qos.logback.core.Appender;
/*     */ import ch.qos.logback.core.util.COWArrayList;
/*     */ import java.util.Iterator;
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
/*     */ public class AppenderAttachableImpl<E>
/*     */   implements AppenderAttachable<E>
/*     */ {
/*  29 */   private final COWArrayList<Appender<E>> appenderList = new COWArrayList((Object[])new Appender[0]);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addAppender(Appender<E> paramAppender) {
/*  37 */     if (paramAppender == null) {
/*  38 */       throw new IllegalArgumentException("Null argument disallowed");
/*     */     }
/*  40 */     this.appenderList.addIfAbsent(paramAppender);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int appendLoopOnAppenders(E paramE) {
/*  47 */     byte b1 = 0;
/*  48 */     Appender[] arrayOfAppender = (Appender[])this.appenderList.asTypedArray();
/*  49 */     int i = arrayOfAppender.length;
/*  50 */     for (byte b2 = 0; b2 < i; b2++) {
/*  51 */       arrayOfAppender[b2].doAppend(paramE);
/*  52 */       b1++;
/*     */     } 
/*  54 */     return b1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<Appender<E>> iteratorForAppenders() {
/*  64 */     return this.appenderList.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Appender<E> getAppender(String paramString) {
/*  74 */     if (paramString == null) {
/*  75 */       return null;
/*     */     }
/*  77 */     for (Appender<E> appender : this.appenderList) {
/*  78 */       if (paramString.equals(appender.getName())) {
/*  79 */         return appender;
/*     */       }
/*     */     } 
/*  82 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAttached(Appender<E> paramAppender) {
/*  92 */     if (paramAppender == null) {
/*  93 */       return false;
/*     */     }
/*  95 */     for (Appender<E> appender : this.appenderList) {
/*  96 */       if (appender == paramAppender)
/*  97 */         return true; 
/*     */     } 
/*  99 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void detachAndStopAllAppenders() {
/* 106 */     for (Appender<E> appender : this.appenderList) {
/* 107 */       appender.stop();
/*     */     }
/* 109 */     this.appenderList.clear();
/*     */   }
/*     */   
/* 112 */   static final long START = System.currentTimeMillis();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean detachAppender(Appender<E> paramAppender) {
/* 119 */     if (paramAppender == null) {
/* 120 */       return false;
/*     */     }
/*     */     
/* 123 */     return this.appenderList.remove(paramAppender);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean detachAppender(String paramString) {
/* 132 */     if (paramString == null) {
/* 133 */       return false;
/*     */     }
/* 135 */     boolean bool = false;
/* 136 */     for (Appender<E> appender : this.appenderList) {
/* 137 */       if (paramString.equals(appender.getName())) {
/* 138 */         bool = this.appenderList.remove(appender);
/*     */         break;
/*     */       } 
/*     */     } 
/* 142 */     return bool;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\spi\AppenderAttachableImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */