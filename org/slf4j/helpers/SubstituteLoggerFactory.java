/*    */ package org.slf4j.helpers;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.LinkedBlockingQueue;
/*    */ import org.slf4j.ILoggerFactory;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.event.SubstituteLoggingEvent;
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
/*    */ public class SubstituteLoggerFactory
/*    */   implements ILoggerFactory
/*    */ {
/*    */   boolean postInitialization = false;
/* 47 */   final Map<String, SubstituteLogger> loggers = new HashMap<String, SubstituteLogger>();
/*    */   
/* 49 */   final LinkedBlockingQueue<SubstituteLoggingEvent> eventQueue = new LinkedBlockingQueue<SubstituteLoggingEvent>();
/*    */   
/*    */   public synchronized Logger getLogger(String paramString) {
/* 52 */     SubstituteLogger substituteLogger = this.loggers.get(paramString);
/* 53 */     if (substituteLogger == null) {
/* 54 */       substituteLogger = new SubstituteLogger(paramString, this.eventQueue, this.postInitialization);
/* 55 */       this.loggers.put(paramString, substituteLogger);
/*    */     } 
/* 57 */     return substituteLogger;
/*    */   }
/*    */   
/*    */   public List<String> getLoggerNames() {
/* 61 */     return new ArrayList<String>(this.loggers.keySet());
/*    */   }
/*    */   
/*    */   public List<SubstituteLogger> getLoggers() {
/* 65 */     return new ArrayList<SubstituteLogger>(this.loggers.values());
/*    */   }
/*    */   
/*    */   public LinkedBlockingQueue<SubstituteLoggingEvent> getEventQueue() {
/* 69 */     return this.eventQueue;
/*    */   }
/*    */   
/*    */   public void postInitialization() {
/* 73 */     this.postInitialization = true;
/*    */   }
/*    */   
/*    */   public void clear() {
/* 77 */     this.loggers.clear();
/* 78 */     this.eventQueue.clear();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\slf4j\helpers\SubstituteLoggerFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */