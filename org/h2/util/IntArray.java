/*     */ package org.h2.util;
/*     */ 
/*     */ import org.h2.engine.SysProperties;
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
/*     */ public class IntArray
/*     */ {
/*     */   private int[] data;
/*     */   private int size;
/*     */   private int hash;
/*     */   
/*     */   public IntArray() {
/*  23 */     this(10);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntArray(int paramInt) {
/*  32 */     this.data = new int[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntArray(int[] paramArrayOfint) {
/*  41 */     this.data = paramArrayOfint;
/*  42 */     this.size = paramArrayOfint.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(int paramInt) {
/*  51 */     if (this.size >= this.data.length) {
/*  52 */       ensureCapacity(this.size + this.size);
/*     */     }
/*  54 */     this.data[this.size++] = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int get(int paramInt) {
/*  64 */     if (SysProperties.CHECK && 
/*  65 */       paramInt >= this.size) {
/*  66 */       throw new ArrayIndexOutOfBoundsException("i=" + paramInt + " size=" + this.size);
/*     */     }
/*     */     
/*  69 */     return this.data[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(int paramInt) {
/*  78 */     if (SysProperties.CHECK && 
/*  79 */       paramInt >= this.size) {
/*  80 */       throw new ArrayIndexOutOfBoundsException("i=" + paramInt + " size=" + this.size);
/*     */     }
/*     */     
/*  83 */     System.arraycopy(this.data, paramInt + 1, this.data, paramInt, this.size - paramInt - 1);
/*  84 */     this.size--;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ensureCapacity(int paramInt) {
/*  94 */     paramInt = Math.max(4, paramInt);
/*  95 */     if (paramInt >= this.data.length) {
/*  96 */       int[] arrayOfInt = new int[paramInt];
/*  97 */       System.arraycopy(this.data, 0, arrayOfInt, 0, this.data.length);
/*  98 */       this.data = arrayOfInt;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 104 */     if (!(paramObject instanceof IntArray)) {
/* 105 */       return false;
/*     */     }
/* 107 */     IntArray intArray = (IntArray)paramObject;
/* 108 */     if (hashCode() != intArray.hashCode() || this.size != intArray.size) {
/* 109 */       return false;
/*     */     }
/* 111 */     for (byte b = 0; b < this.size; b++) {
/* 112 */       if (this.data[b] != intArray.data[b]) {
/* 113 */         return false;
/*     */       }
/*     */     } 
/* 116 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     if (this.hash != 0) {
/* 122 */       return this.hash;
/*     */     }
/* 124 */     int i = this.size + 1;
/* 125 */     for (byte b = 0; b < this.size; b++) {
/* 126 */       i = i * 31 + this.data[b];
/*     */     }
/* 128 */     this.hash = i;
/* 129 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 138 */     return this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void toArray(int[] paramArrayOfint) {
/* 147 */     System.arraycopy(this.data, 0, paramArrayOfint, 0, this.size);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 152 */     StatementBuilder statementBuilder = new StatementBuilder("{");
/* 153 */     for (byte b = 0; b < this.size; b++) {
/* 154 */       statementBuilder.appendExceptFirst(", ");
/* 155 */       statementBuilder.append(this.data[b]);
/*     */     } 
/* 157 */     return statementBuilder.append('}').toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeRange(int paramInt1, int paramInt2) {
/* 167 */     if (SysProperties.CHECK && (
/* 168 */       paramInt1 > paramInt2 || paramInt2 > this.size)) {
/* 169 */       throw new ArrayIndexOutOfBoundsException("from=" + paramInt1 + " to=" + paramInt2 + " size=" + this.size);
/*     */     }
/*     */ 
/*     */     
/* 173 */     System.arraycopy(this.data, paramInt2, this.data, paramInt1, this.size - paramInt2);
/* 174 */     this.size -= paramInt2 - paramInt1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\IntArray.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */