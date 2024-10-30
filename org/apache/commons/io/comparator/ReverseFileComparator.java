/*    */ package org.apache.commons.io.comparator;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.Serializable;
/*    */ import java.util.Comparator;
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
/*    */ class ReverseFileComparator
/*    */   extends AbstractFileComparator
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -4808255005272229056L;
/*    */   private final Comparator<File> delegate;
/*    */   
/*    */   public ReverseFileComparator(Comparator<File> paramComparator) {
/* 39 */     if (paramComparator == null) {
/* 40 */       throw new IllegalArgumentException("Delegate comparator is missing");
/*    */     }
/* 42 */     this.delegate = paramComparator;
/*    */   }
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
/*    */   public int compare(File paramFile1, File paramFile2) {
/* 55 */     return this.delegate.compare(paramFile2, paramFile1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 65 */     return super.toString() + "[" + this.delegate.toString() + "]";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\comparator\ReverseFileComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */