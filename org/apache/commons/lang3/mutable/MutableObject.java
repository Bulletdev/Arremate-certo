/*     */ package org.apache.commons.lang3.mutable;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ public class MutableObject<T>
/*     */   implements Serializable, Mutable<T>
/*     */ {
/*     */   private static final long serialVersionUID = 86241875189L;
/*     */   private T value;
/*     */   
/*     */   public MutableObject() {}
/*     */   
/*     */   public MutableObject(T paramT) {
/*  54 */     this.value = paramT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T getValue() {
/*  65 */     return this.value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(T paramT) {
/*  75 */     this.value = paramT;
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
/*     */   public boolean equals(Object paramObject) {
/*  93 */     if (paramObject == null) {
/*  94 */       return false;
/*     */     }
/*  96 */     if (this == paramObject) {
/*  97 */       return true;
/*     */     }
/*  99 */     if (getClass() == paramObject.getClass()) {
/* 100 */       MutableObject mutableObject = (MutableObject)paramObject;
/* 101 */       return this.value.equals(mutableObject.value);
/*     */     } 
/* 103 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 113 */     return (this.value == null) ? 0 : this.value.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 124 */     return (this.value == null) ? "null" : this.value.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\mutable\MutableObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */