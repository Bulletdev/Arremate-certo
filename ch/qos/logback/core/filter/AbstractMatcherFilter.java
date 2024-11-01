/*    */ package ch.qos.logback.core.filter;
/*    */ 
/*    */ import ch.qos.logback.core.spi.FilterReply;
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
/*    */ public abstract class AbstractMatcherFilter<E>
/*    */   extends Filter<E>
/*    */ {
/* 20 */   protected FilterReply onMatch = FilterReply.NEUTRAL;
/* 21 */   protected FilterReply onMismatch = FilterReply.NEUTRAL;
/*    */   
/*    */   public final void setOnMatch(FilterReply paramFilterReply) {
/* 24 */     this.onMatch = paramFilterReply;
/*    */   }
/*    */   
/*    */   public final void setOnMismatch(FilterReply paramFilterReply) {
/* 28 */     this.onMismatch = paramFilterReply;
/*    */   }
/*    */   
/*    */   public final FilterReply getOnMatch() {
/* 32 */     return this.onMatch;
/*    */   }
/*    */   
/*    */   public final FilterReply getOnMismatch() {
/* 36 */     return this.onMismatch;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\filter\AbstractMatcherFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */