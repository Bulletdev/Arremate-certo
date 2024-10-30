/*    */ package ch.qos.logback.core;
/*    */ 
/*    */ import ch.qos.logback.core.spi.LifeCycle;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
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
/*    */ public class LifeCycleManager
/*    */ {
/* 30 */   private final Set<LifeCycle> components = new HashSet<LifeCycle>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void register(LifeCycle paramLifeCycle) {
/* 38 */     this.components.add(paramLifeCycle);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void reset() {
/* 47 */     for (LifeCycle lifeCycle : this.components) {
/* 48 */       if (lifeCycle.isStarted()) {
/* 49 */         lifeCycle.stop();
/*    */       }
/*    */     } 
/* 52 */     this.components.clear();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\LifeCycleManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */