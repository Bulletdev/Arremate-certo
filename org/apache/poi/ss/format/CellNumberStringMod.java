/*     */ package org.apache.poi.ss.format;
/*     */ 
/*     */ import org.apache.poi.util.Internal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Internal
/*     */ public class CellNumberStringMod
/*     */   implements Comparable<CellNumberStringMod>
/*     */ {
/*     */   public static final int BEFORE = 1;
/*     */   public static final int AFTER = 2;
/*     */   public static final int REPLACE = 3;
/*     */   private final CellNumberFormatter.Special special;
/*     */   private final int op;
/*     */   private CharSequence toAdd;
/*     */   private CellNumberFormatter.Special end;
/*     */   private boolean startInclusive;
/*     */   private boolean endInclusive;
/*     */   
/*     */   public CellNumberStringMod(CellNumberFormatter.Special paramSpecial, CharSequence paramCharSequence, int paramInt) {
/*  47 */     this.special = paramSpecial;
/*  48 */     this.toAdd = paramCharSequence;
/*  49 */     this.op = paramInt;
/*     */   }
/*     */   
/*     */   public CellNumberStringMod(CellNumberFormatter.Special paramSpecial1, boolean paramBoolean1, CellNumberFormatter.Special paramSpecial2, boolean paramBoolean2, char paramChar) {
/*  53 */     this(paramSpecial1, paramBoolean1, paramSpecial2, paramBoolean2);
/*  54 */     this.toAdd = paramChar + "";
/*     */   }
/*     */   
/*     */   public CellNumberStringMod(CellNumberFormatter.Special paramSpecial1, boolean paramBoolean1, CellNumberFormatter.Special paramSpecial2, boolean paramBoolean2) {
/*  58 */     this.special = paramSpecial1;
/*  59 */     this.startInclusive = paramBoolean1;
/*  60 */     this.end = paramSpecial2;
/*  61 */     this.endInclusive = paramBoolean2;
/*  62 */     this.op = 3;
/*  63 */     this.toAdd = "";
/*     */   }
/*     */   
/*     */   public int compareTo(CellNumberStringMod paramCellNumberStringMod) {
/*  67 */     int i = this.special.pos - paramCellNumberStringMod.special.pos;
/*  68 */     return (i != 0) ? i : (this.op - paramCellNumberStringMod.op);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*     */     try {
/*  74 */       return (compareTo((CellNumberStringMod)paramObject) == 0);
/*  75 */     } catch (RuntimeException runtimeException) {
/*     */       
/*  77 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  83 */     return this.special.hashCode() + this.op;
/*     */   }
/*     */   
/*     */   public CellNumberFormatter.Special getSpecial() {
/*  87 */     return this.special;
/*     */   }
/*     */   
/*     */   public int getOp() {
/*  91 */     return this.op;
/*     */   }
/*     */   
/*     */   public CharSequence getToAdd() {
/*  95 */     return this.toAdd;
/*     */   }
/*     */   
/*     */   public CellNumberFormatter.Special getEnd() {
/*  99 */     return this.end;
/*     */   }
/*     */   
/*     */   public boolean isStartInclusive() {
/* 103 */     return this.startInclusive;
/*     */   }
/*     */   
/*     */   public boolean isEndInclusive() {
/* 107 */     return this.endInclusive;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\format\CellNumberStringMod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */