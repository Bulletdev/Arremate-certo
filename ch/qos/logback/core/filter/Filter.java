/*    */ package ch.qos.logback.core.filter;
/*    */ 
/*    */ import ch.qos.logback.core.spi.ContextAwareBase;
/*    */ import ch.qos.logback.core.spi.FilterReply;
/*    */ import ch.qos.logback.core.spi.LifeCycle;
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
/*    */ public abstract class Filter<E>
/*    */   extends ContextAwareBase
/*    */   implements LifeCycle
/*    */ {
/*    */   private String name;
/*    */   boolean start = false;
/*    */   
/*    */   public void start() {
/* 38 */     this.start = true;
/*    */   }
/*    */   
/*    */   public boolean isStarted() {
/* 42 */     return this.start;
/*    */   }
/*    */   
/*    */   public void stop() {
/* 46 */     this.start = false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract FilterReply decide(E paramE);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 62 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String paramString) {
/* 66 */     this.name = paramString;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\filter\Filter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */