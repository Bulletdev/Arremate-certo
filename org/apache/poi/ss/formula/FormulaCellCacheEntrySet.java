/*     */ package org.apache.poi.ss.formula;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class FormulaCellCacheEntrySet
/*     */ {
/*  30 */   private static final FormulaCellCacheEntry[] EMPTY_ARRAY = new FormulaCellCacheEntry[0];
/*     */ 
/*     */   
/*     */   private int _size;
/*     */ 
/*     */   
/*  36 */   private FormulaCellCacheEntry[] _arr = EMPTY_ARRAY;
/*     */ 
/*     */   
/*     */   public FormulaCellCacheEntry[] toArray() {
/*  40 */     int i = this._size;
/*  41 */     if (i < 1) {
/*  42 */       return EMPTY_ARRAY;
/*     */     }
/*  44 */     FormulaCellCacheEntry[] arrayOfFormulaCellCacheEntry = new FormulaCellCacheEntry[i];
/*  45 */     byte b1 = 0;
/*  46 */     for (byte b2 = 0; b2 < this._arr.length; b2++) {
/*  47 */       FormulaCellCacheEntry formulaCellCacheEntry = this._arr[b2];
/*  48 */       if (formulaCellCacheEntry != null) {
/*  49 */         arrayOfFormulaCellCacheEntry[b1++] = formulaCellCacheEntry;
/*     */       }
/*     */     } 
/*  52 */     if (b1 != i) {
/*  53 */       throw new IllegalStateException("size mismatch");
/*     */     }
/*  55 */     return arrayOfFormulaCellCacheEntry;
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(CellCacheEntry paramCellCacheEntry) {
/*  60 */     if (this._size * 3 >= this._arr.length * 2) {
/*     */       
/*  62 */       FormulaCellCacheEntry[] arrayOfFormulaCellCacheEntry1 = this._arr;
/*  63 */       FormulaCellCacheEntry[] arrayOfFormulaCellCacheEntry2 = new FormulaCellCacheEntry[4 + this._arr.length * 3 / 2];
/*  64 */       for (byte b = 0; b < arrayOfFormulaCellCacheEntry1.length; b++) {
/*  65 */         FormulaCellCacheEntry formulaCellCacheEntry = this._arr[b];
/*  66 */         if (formulaCellCacheEntry != null) {
/*  67 */           addInternal((CellCacheEntry[])arrayOfFormulaCellCacheEntry2, formulaCellCacheEntry);
/*     */         }
/*     */       } 
/*  70 */       this._arr = arrayOfFormulaCellCacheEntry2;
/*     */     } 
/*  72 */     if (addInternal((CellCacheEntry[])this._arr, paramCellCacheEntry)) {
/*  73 */       this._size++;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean addInternal(CellCacheEntry[] paramArrayOfCellCacheEntry, CellCacheEntry paramCellCacheEntry) {
/*  79 */     int i = Math.abs(paramCellCacheEntry.hashCode() % paramArrayOfCellCacheEntry.length);
/*     */     int j;
/*  81 */     for (j = i; j < paramArrayOfCellCacheEntry.length; j++) {
/*  82 */       CellCacheEntry cellCacheEntry = paramArrayOfCellCacheEntry[j];
/*  83 */       if (cellCacheEntry == paramCellCacheEntry)
/*     */       {
/*  85 */         return false;
/*     */       }
/*  87 */       if (cellCacheEntry == null) {
/*  88 */         paramArrayOfCellCacheEntry[j] = paramCellCacheEntry;
/*  89 */         return true;
/*     */       } 
/*     */     } 
/*  92 */     for (j = 0; j < i; j++) {
/*  93 */       CellCacheEntry cellCacheEntry = paramArrayOfCellCacheEntry[j];
/*  94 */       if (cellCacheEntry == paramCellCacheEntry)
/*     */       {
/*  96 */         return false;
/*     */       }
/*  98 */       if (cellCacheEntry == null) {
/*  99 */         paramArrayOfCellCacheEntry[j] = paramCellCacheEntry;
/* 100 */         return true;
/*     */       } 
/*     */     } 
/* 103 */     throw new IllegalStateException("No empty space found");
/*     */   }
/*     */   
/*     */   public boolean remove(CellCacheEntry paramCellCacheEntry) {
/* 107 */     FormulaCellCacheEntry[] arrayOfFormulaCellCacheEntry = this._arr;
/*     */     
/* 109 */     if (this._size * 3 < this._arr.length && this._arr.length > 8) {
/*     */       
/* 111 */       boolean bool = false;
/* 112 */       FormulaCellCacheEntry[] arrayOfFormulaCellCacheEntry1 = this._arr;
/* 113 */       FormulaCellCacheEntry[] arrayOfFormulaCellCacheEntry2 = new FormulaCellCacheEntry[this._arr.length / 2];
/* 114 */       for (byte b = 0; b < arrayOfFormulaCellCacheEntry1.length; b++) {
/* 115 */         FormulaCellCacheEntry formulaCellCacheEntry = this._arr[b];
/* 116 */         if (formulaCellCacheEntry != null)
/* 117 */           if (formulaCellCacheEntry == paramCellCacheEntry) {
/* 118 */             bool = true;
/* 119 */             this._size--;
/*     */           }
/*     */           else {
/*     */             
/* 123 */             addInternal((CellCacheEntry[])arrayOfFormulaCellCacheEntry2, formulaCellCacheEntry);
/*     */           }  
/*     */       } 
/* 126 */       this._arr = arrayOfFormulaCellCacheEntry2;
/* 127 */       return bool;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 132 */     int i = Math.abs(paramCellCacheEntry.hashCode() % arrayOfFormulaCellCacheEntry.length);
/*     */     
/*     */     int j;
/* 135 */     for (j = i; j < arrayOfFormulaCellCacheEntry.length; j++) {
/* 136 */       FormulaCellCacheEntry formulaCellCacheEntry = arrayOfFormulaCellCacheEntry[j];
/* 137 */       if (formulaCellCacheEntry == paramCellCacheEntry) {
/*     */         
/* 139 */         arrayOfFormulaCellCacheEntry[j] = null;
/* 140 */         this._size--;
/* 141 */         return true;
/*     */       } 
/*     */     } 
/* 144 */     for (j = 0; j < i; j++) {
/* 145 */       FormulaCellCacheEntry formulaCellCacheEntry = arrayOfFormulaCellCacheEntry[j];
/* 146 */       if (formulaCellCacheEntry == paramCellCacheEntry) {
/*     */         
/* 148 */         arrayOfFormulaCellCacheEntry[j] = null;
/* 149 */         this._size--;
/* 150 */         return true;
/*     */       } 
/*     */     } 
/* 153 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\FormulaCellCacheEntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */