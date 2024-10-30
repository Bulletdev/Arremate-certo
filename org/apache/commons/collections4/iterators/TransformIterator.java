/*     */ package org.apache.commons.collections4.iterators;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import org.apache.commons.collections4.Transformer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TransformIterator<I, O>
/*     */   implements Iterator<O>
/*     */ {
/*     */   private Iterator<? extends I> iterator;
/*     */   private Transformer<? super I, ? extends O> transformer;
/*     */   
/*     */   public TransformIterator() {}
/*     */   
/*     */   public TransformIterator(Iterator<? extends I> paramIterator) {
/*  54 */     this.iterator = paramIterator;
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
/*     */   public TransformIterator(Iterator<? extends I> paramIterator, Transformer<? super I, ? extends O> paramTransformer) {
/*  68 */     this.iterator = paramIterator;
/*  69 */     this.transformer = paramTransformer;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/*  74 */     return this.iterator.hasNext();
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
/*     */   public O next() {
/*  86 */     return transform(this.iterator.next());
/*     */   }
/*     */   
/*     */   public void remove() {
/*  90 */     this.iterator.remove();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<? extends I> getIterator() {
/* 100 */     return this.iterator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIterator(Iterator<? extends I> paramIterator) {
/* 110 */     this.iterator = paramIterator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Transformer<? super I, ? extends O> getTransformer() {
/* 120 */     return this.transformer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransformer(Transformer<? super I, ? extends O> paramTransformer) {
/* 130 */     this.transformer = paramTransformer;
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
/*     */   protected O transform(I paramI) {
/* 142 */     return (O)this.transformer.transform(paramI);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\TransformIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */