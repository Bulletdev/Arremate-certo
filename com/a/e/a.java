/*     */ package com.a.e;
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
/*     */ public class a
/*     */ {
/*  41 */   protected Object[] q = null;
/*  42 */   protected int size = 0;
/*     */   
/*     */   public a() {
/*  45 */     this.q = new Object[2];
/*     */   }
/*     */   
/*     */   public a(int paramInt) {
/*  49 */     this.q = new Object[paramInt];
/*     */   }
/*     */   
/*     */   public a(Object[] paramArrayOfObject, int paramInt) {
/*  53 */     if (paramArrayOfObject == null) {
/*  54 */       throw new IllegalArgumentException("data array cannot be null.");
/*     */     }
/*  56 */     if (paramInt < 0 || paramInt > paramArrayOfObject.length) {
/*  57 */       throw new IllegalArgumentException("required: (size >= 0 && size <= data.length) but: (size = " + paramInt + ", data.length = " + paramArrayOfObject.length + ")");
/*     */     }
/*  59 */     this.q = paramArrayOfObject;
/*  60 */     this.size = paramInt;
/*     */   }
/*     */   
/*     */   public void add(Object paramObject) {
/*  64 */     c(paramObject, this.size);
/*     */   }
/*     */   
/*     */   public int size() {
/*  68 */     return this.size;
/*     */   }
/*     */   
/*     */   public void setSize(int paramInt) {
/*  72 */     if (paramInt < 0 || paramInt > this.q.length) {
/*  73 */       throw new IllegalArgumentException("required: (size >= 0 && size <= data.length) but: (size = " + this.size + ", data.length = " + this.q.length + ")");
/*     */     }
/*  75 */     this.size = paramInt;
/*     */   }
/*     */   
/*     */   public void c(Object paramObject, int paramInt) {
/*  79 */     if (paramInt < 0 || paramInt > this.size) {
/*  80 */       throw new IllegalArgumentException("required: (index >= 0 && index <= size) but: (index = " + paramInt + ", size = " + this.size + ")");
/*     */     }
/*  82 */     ensureCapacity(this.size + 1);
/*     */     
/*  84 */     for (int i = this.size; i > paramInt; i--) {
/*  85 */       this.q[i] = this.q[i - 1];
/*     */     }
/*  87 */     this.q[paramInt] = paramObject;
/*  88 */     this.size++;
/*     */   }
/*     */   
/*     */   public void ensureCapacity(int paramInt) {
/*  92 */     if (paramInt > this.q.length) {
/*  93 */       int i = 2 * this.q.length;
/*     */       
/*  95 */       if (i < paramInt) {
/*  96 */         i = paramInt;
/*     */       }
/*  98 */       Object[] arrayOfObject = new Object[i];
/*     */       
/* 100 */       for (byte b = 0; b < this.size; b++) {
/* 101 */         arrayOfObject[b] = this.q[b];
/*     */       }
/* 103 */       this.q = arrayOfObject;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getCapacity() {
/* 108 */     return this.q.length;
/*     */   }
/*     */   
/*     */   private int a(Object paramObject, int paramInt, boolean paramBoolean) {
/* 112 */     if (paramInt < 0 || paramInt >= this.size) return -1;
/*     */     
/* 114 */     if (paramBoolean) {
/* 115 */       if (paramObject == null) {
/* 116 */         for (; paramInt < this.size; paramInt++) {
/* 117 */           if (this.q[paramInt] == null)
/* 118 */             return paramInt; 
/*     */         } 
/*     */       } else {
/* 121 */         for (; paramInt < this.size; paramInt++) {
/* 122 */           if (paramObject.equals(this.q[paramInt])) {
/* 123 */             return paramInt;
/*     */           }
/*     */         } 
/*     */       } 
/* 127 */     } else if (paramObject == null) {
/* 128 */       for (; paramInt >= 0; paramInt--) {
/* 129 */         if (this.q[paramInt] == null)
/* 130 */           return paramInt; 
/*     */       } 
/*     */     } else {
/* 133 */       for (; paramInt >= 0; paramInt--) {
/* 134 */         if (paramObject.equals(this.q[paramInt]))
/* 135 */           return paramInt; 
/*     */       } 
/*     */     } 
/* 138 */     return -1;
/*     */   }
/*     */   
/*     */   public int q(Object paramObject) {
/* 142 */     int i = a(paramObject, 0, true);
/* 143 */     if (i >= 0)
/* 144 */       remove(i); 
/* 145 */     return i;
/*     */   }
/*     */   
/*     */   public Object remove(int paramInt) {
/* 149 */     if (paramInt < 0 || paramInt >= this.size) {
/* 150 */       throw new IllegalArgumentException("required: (index >= 0 && index < size) but: (index = " + paramInt + ", size = " + this.size + ")");
/*     */     }
/* 152 */     Object object = this.q[paramInt];
/*     */     
/* 154 */     for (int i = paramInt + 1; i < this.size; i++) {
/* 155 */       this.q[i - 1] = this.q[i];
/*     */     }
/* 157 */     this.q[--this.size] = null;
/* 158 */     return object;
/*     */   }
/*     */   
/*     */   public Object get(int paramInt) {
/* 162 */     if (paramInt < 0 || paramInt >= this.size) {
/* 163 */       throw new IllegalArgumentException("required: (index >= 0 && index < size) but: (index = " + paramInt + ", size = " + this.size + ")");
/*     */     }
/* 165 */     return this.q[paramInt];
/*     */   }
/*     */   
/*     */   public Object b(Object paramObject, int paramInt) {
/* 169 */     if (paramInt < 0 || paramInt >= this.size) {
/* 170 */       throw new IllegalArgumentException("required: (index >= 0 && index < size) but: (index = " + paramInt + ", size = " + this.size + ")");
/*     */     }
/* 172 */     Object object = this.q[paramInt];
/* 173 */     this.q[paramInt] = paramObject;
/* 174 */     return object;
/*     */   }
/*     */   
/*     */   public boolean contains(Object paramObject) {
/* 178 */     return (a(paramObject, 0, true) >= 0);
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 182 */     return (this.size == 0);
/*     */   }
/*     */   
/*     */   public void gr() {
/* 186 */     if (this.size < this.q.length) {
/* 187 */       Object[] arrayOfObject = new Object[this.size];
/* 188 */       for (byte b = 0; b < this.size; b++)
/* 189 */         arrayOfObject[b] = this.q[b]; 
/* 190 */       this.q = arrayOfObject;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int indexOf(Object paramObject) {
/* 195 */     return a(paramObject, 0, true);
/*     */   }
/*     */   
/*     */   public int indexOf(Object paramObject, int paramInt) {
/* 199 */     return a(paramObject, paramInt, true);
/*     */   }
/*     */   
/*     */   public int lastIndexOf(Object paramObject) {
/* 203 */     return a(paramObject, this.size - 1, false);
/*     */   }
/*     */   
/*     */   public int c(Object paramObject, int paramInt) {
/* 207 */     return a(paramObject, paramInt, false);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\e\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */