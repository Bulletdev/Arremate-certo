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
/*    */ class ArticleIterator
/*    */   implements Iterable<Article>, Iterator<Article>
/*    */ {
/*    */   private final Iterator<String> stringIterator;
/*    */   
/*    */   public ArticleIterator(Iterable<String> paramIterable) {
/* 32 */     this.stringIterator = paramIterable.iterator();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hasNext() {
/* 37 */     return this.stringIterator.hasNext();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Article next() {
/* 47 */     String str = this.stringIterator.next();
/* 48 */     return NNTPClient.parseArticleEntry(str);
/*    */   }
/*    */ 
/*    */   
/*    */   public void remove() {
/* 53 */     this.stringIterator.remove();
/*    */   }
/*    */ 
/*    */   
/*    */   public Iterator<Article> iterator() {
/* 58 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\nntp\ArticleIterator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */