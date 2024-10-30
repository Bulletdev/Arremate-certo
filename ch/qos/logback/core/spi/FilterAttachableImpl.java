/*    */ package ch.qos.logback.core.spi;
/*    */ 
/*    */ import ch.qos.logback.core.filter.Filter;
/*    */ import ch.qos.logback.core.util.COWArrayList;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
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
/*    */ public final class FilterAttachableImpl<E>
/*    */   implements FilterAttachable<E>
/*    */ {
/* 29 */   COWArrayList<Filter<E>> filterList = new COWArrayList((Object[])new Filter[0]);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void addFilter(Filter<E> paramFilter) {
/* 36 */     this.filterList.add(paramFilter);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void clearAllFilters() {
/* 43 */     this.filterList.clear();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public FilterReply getFilterChainDecision(E paramE) {
/* 53 */     Filter[] arrayOfFilter = (Filter[])this.filterList.asTypedArray();
/* 54 */     int i = arrayOfFilter.length;
/*    */     
/* 56 */     for (byte b = 0; b < i; b++) {
/* 57 */       FilterReply filterReply = arrayOfFilter[b].decide(paramE);
/* 58 */       if (filterReply == FilterReply.DENY || filterReply == FilterReply.ACCEPT) {
/* 59 */         return filterReply;
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 64 */     return FilterReply.NEUTRAL;
/*    */   }
/*    */   
/*    */   public List<Filter<E>> getCopyOfAttachedFiltersList() {
/* 68 */     return new ArrayList<Filter<E>>((Collection<? extends Filter<E>>)this.filterList);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\spi\FilterAttachableImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */