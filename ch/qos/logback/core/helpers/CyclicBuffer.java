/*     */ package ch.qos.logback.core.helpers;
/*     */ 
/*     */ import java.util.ArrayList;
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
/*     */ public class CyclicBuffer<E>
/*     */ {
/*     */   E[] ea;
/*     */   int first;
/*     */   int last;
/*     */   int numElems;
/*     */   int maxSize;
/*     */   
/*     */   public CyclicBuffer(int paramInt) throws IllegalArgumentException {
/*  44 */     if (paramInt < 1) {
/*  45 */       throw new IllegalArgumentException("The maxSize argument (" + paramInt + ") is not a positive integer.");
/*     */     }
/*  47 */     init(paramInt);
/*     */   }
/*     */   
/*     */   public CyclicBuffer(CyclicBuffer<E> paramCyclicBuffer) {
/*  51 */     this.maxSize = paramCyclicBuffer.maxSize;
/*  52 */     this.ea = (E[])new Object[this.maxSize];
/*  53 */     System.arraycopy(paramCyclicBuffer.ea, 0, this.ea, 0, this.maxSize);
/*  54 */     this.last = paramCyclicBuffer.last;
/*  55 */     this.first = paramCyclicBuffer.first;
/*  56 */     this.numElems = paramCyclicBuffer.numElems;
/*     */   }
/*     */ 
/*     */   
/*     */   private void init(int paramInt) {
/*  61 */     this.maxSize = paramInt;
/*  62 */     this.ea = (E[])new Object[paramInt];
/*  63 */     this.first = 0;
/*  64 */     this.last = 0;
/*  65 */     this.numElems = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/*  72 */     init(this.maxSize);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(E paramE) {
/*  80 */     this.ea[this.last] = paramE;
/*  81 */     if (++this.last == this.maxSize) {
/*  82 */       this.last = 0;
/*     */     }
/*  84 */     if (this.numElems < this.maxSize) {
/*  85 */       this.numElems++;
/*  86 */     } else if (++this.first == this.maxSize) {
/*  87 */       this.first = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E get(int paramInt) {
/*  96 */     if (paramInt < 0 || paramInt >= this.numElems) {
/*  97 */       return null;
/*     */     }
/*  99 */     return this.ea[(this.first + paramInt) % this.maxSize];
/*     */   }
/*     */   
/*     */   public int getMaxSize() {
/* 103 */     return this.maxSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E get() {
/* 111 */     Object object = null;
/*     */     
/* 113 */     this.numElems--;
/* 114 */     E e = this.ea[this.first];
/* 115 */     this.ea[this.first] = null;
/* 116 */     if (this.numElems > 0 && ++this.first == this.maxSize) {
/* 117 */       this.first = 0;
/*     */     }
/* 119 */     return e;
/*     */   }
/*     */   
/*     */   public List<E> asList() {
/* 123 */     ArrayList<E> arrayList = new ArrayList();
/* 124 */     for (byte b = 0; b < length(); b++) {
/* 125 */       arrayList.add(get(b));
/*     */     }
/* 127 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int length() {
/* 135 */     return this.numElems;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resize(int paramInt) {
/* 146 */     if (paramInt < 0) {
/* 147 */       throw new IllegalArgumentException("Negative array size [" + paramInt + "] not allowed.");
/*     */     }
/* 149 */     if (paramInt == this.numElems) {
/*     */       return;
/*     */     }
/*     */     
/* 153 */     Object[] arrayOfObject = new Object[paramInt];
/*     */     
/* 155 */     int i = (paramInt < this.numElems) ? paramInt : this.numElems;
/*     */     
/* 157 */     for (byte b = 0; b < i; b++) {
/* 158 */       arrayOfObject[b] = this.ea[this.first];
/* 159 */       this.ea[this.first] = null;
/* 160 */       if (++this.first == this.numElems)
/* 161 */         this.first = 0; 
/*     */     } 
/* 163 */     this.ea = (E[])arrayOfObject;
/* 164 */     this.first = 0;
/* 165 */     this.numElems = i;
/* 166 */     this.maxSize = paramInt;
/* 167 */     if (i == paramInt) {
/* 168 */       this.last = 0;
/*     */     } else {
/* 170 */       this.last = i;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\helpers\CyclicBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */