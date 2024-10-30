/*     */ package org.apache.commons.io.comparator;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
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
/*     */ public class CompositeFileComparator
/*     */   extends AbstractFileComparator
/*     */   implements Serializable
/*     */ {
/*  46 */   private static final Comparator<?>[] EMPTY_COMPARATOR_ARRAY = (Comparator<?>[])new Comparator[0];
/*     */   private static final long serialVersionUID = -2224170307287243428L;
/*  48 */   private static final Comparator<?>[] NO_COMPARATORS = (Comparator<?>[])new Comparator[0];
/*     */ 
/*     */ 
/*     */   
/*     */   private final Comparator<File>[] delegates;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CompositeFileComparator(Comparator<File>... paramVarArgs) {
/*  58 */     if (paramVarArgs == null) {
/*  59 */       this.delegates = (Comparator<File>[])NO_COMPARATORS;
/*     */     } else {
/*  61 */       this.delegates = (Comparator<File>[])new Comparator[paramVarArgs.length];
/*  62 */       System.arraycopy(paramVarArgs, 0, this.delegates, 0, paramVarArgs.length);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CompositeFileComparator(Iterable<Comparator<File>> paramIterable) {
/*  73 */     if (paramIterable == null) {
/*  74 */       this.delegates = (Comparator<File>[])NO_COMPARATORS;
/*     */     } else {
/*  76 */       ArrayList<Comparator> arrayList = new ArrayList();
/*  77 */       for (Comparator<File> comparator : paramIterable) {
/*  78 */         arrayList.add(comparator);
/*     */       }
/*  80 */       this.delegates = (Comparator<File>[])arrayList.<Comparator<?>>toArray(EMPTY_COMPARATOR_ARRAY);
/*     */     } 
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
/*     */   public int compare(File paramFile1, File paramFile2) {
/*  94 */     int i = 0;
/*  95 */     for (Comparator<File> comparator : this.delegates) {
/*  96 */       i = comparator.compare(paramFile1, paramFile2);
/*  97 */       if (i != 0) {
/*     */         break;
/*     */       }
/*     */     } 
/* 101 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 111 */     StringBuilder stringBuilder = new StringBuilder();
/* 112 */     stringBuilder.append(super.toString());
/* 113 */     stringBuilder.append('{');
/* 114 */     for (byte b = 0; b < this.delegates.length; b++) {
/* 115 */       if (b > 0) {
/* 116 */         stringBuilder.append(',');
/*     */       }
/* 118 */       stringBuilder.append(this.delegates[b]);
/*     */     } 
/* 120 */     stringBuilder.append('}');
/* 121 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\comparator\CompositeFileComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */