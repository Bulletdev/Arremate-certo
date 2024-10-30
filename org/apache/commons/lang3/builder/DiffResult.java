/*     */ package org.apache.commons.lang3.builder;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang3.Validate;
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
/*     */ public class DiffResult<T>
/*     */   implements Iterable<Diff<?>>
/*     */ {
/*     */   public static final String OBJECTS_SAME_STRING = "";
/*     */   private static final String DIFFERS_STRING = "differs from";
/*     */   private final List<Diff<?>> diffs;
/*     */   private final T lhs;
/*     */   private final T rhs;
/*     */   private final ToStringStyle style;
/*     */   
/*     */   DiffResult(T paramT1, T paramT2, List<Diff<?>> paramList, ToStringStyle paramToStringStyle) {
/*  76 */     Validate.notNull(paramT1, "Left hand object cannot be null", new Object[0]);
/*  77 */     Validate.notNull(paramT2, "Right hand object cannot be null", new Object[0]);
/*  78 */     Validate.notNull(paramList, "List of differences cannot be null", new Object[0]);
/*     */     
/*  80 */     this.diffs = paramList;
/*  81 */     this.lhs = paramT1;
/*  82 */     this.rhs = paramT2;
/*     */     
/*  84 */     if (paramToStringStyle == null) {
/*  85 */       this.style = ToStringStyle.DEFAULT_STYLE;
/*     */     } else {
/*  87 */       this.style = paramToStringStyle;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T getLeft() {
/*  98 */     return this.lhs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T getRight() {
/* 108 */     return this.rhs;
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
/*     */   public List<Diff<?>> getDiffs() {
/* 120 */     return Collections.unmodifiableList(this.diffs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfDiffs() {
/* 131 */     return this.diffs.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ToStringStyle getToStringStyle() {
/* 142 */     return this.style;
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
/*     */   public String toString() {
/* 178 */     return toString(this.style);
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
/*     */   
/*     */   public String toString(ToStringStyle paramToStringStyle) {
/* 193 */     if (this.diffs.isEmpty()) {
/* 194 */       return "";
/*     */     }
/*     */     
/* 197 */     ToStringBuilder toStringBuilder1 = new ToStringBuilder(this.lhs, paramToStringStyle);
/* 198 */     ToStringBuilder toStringBuilder2 = new ToStringBuilder(this.rhs, paramToStringStyle);
/*     */     
/* 200 */     for (Diff<?> diff : this.diffs) {
/* 201 */       toStringBuilder1.append(diff.getFieldName(), diff.getLeft());
/* 202 */       toStringBuilder2.append(diff.getFieldName(), diff.getRight());
/*     */     } 
/*     */     
/* 205 */     return String.format("%s %s %s", new Object[] { toStringBuilder1.build(), "differs from", toStringBuilder2
/* 206 */           .build() });
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
/*     */   public Iterator<Diff<?>> iterator() {
/* 218 */     return this.diffs.iterator();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\builder\DiffResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */