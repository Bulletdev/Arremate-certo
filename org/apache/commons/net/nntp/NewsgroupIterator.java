/*    */ package org.apache.commons.net.nntp;
/*    */ 
/*    */ import java.util.Iterator;
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
/*    */ class NewsgroupIterator
/*    */   implements Iterable<NewsgroupInfo>, Iterator<NewsgroupInfo>
/*    */ {
/*    */   private final Iterator<String> stringIterator;
/*    */   
/*    */   public NewsgroupIterator(Iterable<String> paramIterable) {
/* 32 */     this.stringIterator = paramIterable.iterator();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hasNext() {
/* 37 */     return this.stringIterator.hasNext();
/*    */   }
/*    */ 
/*    */   
/*    */   public NewsgroupInfo next() {
/* 42 */     String str = this.stringIterator.next();
/* 43 */     return NNTPClient.parseNewsgroupListEntry(str);
/*    */   }
/*    */ 
/*    */   
/*    */   public void remove() {
/* 48 */     this.stringIterator.remove();
/*    */   }
/*    */ 
/*    */   
/*    */   public Iterator<NewsgroupInfo> iterator() {
/* 53 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\nntp\NewsgroupIterator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */