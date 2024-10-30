/*     */ package org.apache.commons.lang3.concurrent;
/*     */ 
/*     */ import java.util.Objects;
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
/*     */ public class ConstantInitializer<T>
/*     */   implements ConcurrentInitializer<T>
/*     */ {
/*     */   private static final String FMT_TO_STRING = "ConstantInitializer@%d [ object = %s ]";
/*     */   private final T object;
/*     */   
/*     */   public ConstantInitializer(T paramT) {
/*  57 */     this.object = paramT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final T getObject() {
/*  68 */     return this.object;
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
/*     */   public T get() throws ConcurrentException {
/*  80 */     return getObject();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  91 */     return (getObject() != null) ? getObject().hashCode() : 0;
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
/*     */   public boolean equals(Object paramObject) {
/* 105 */     if (this == paramObject) {
/* 106 */       return true;
/*     */     }
/* 108 */     if (!(paramObject instanceof ConstantInitializer)) {
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     ConstantInitializer constantInitializer = (ConstantInitializer)paramObject;
/* 113 */     return Objects.equals(getObject(), constantInitializer.getObject());
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
/*     */   public String toString() {
/* 125 */     return String.format("ConstantInitializer@%d [ object = %s ]", new Object[] { Integer.valueOf(System.identityHashCode(this)), 
/* 126 */           String.valueOf(getObject()) });
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\concurrent\ConstantInitializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */