/*     */ package org.apache.poi.ss.formula.ptg;
/*     */ 
/*     */ import org.apache.poi.ss.formula.SheetNameFormatter;
/*     */ import org.apache.poi.util.LittleEndianOutput;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class NameXPxg
/*     */   extends OperandPtg
/*     */   implements Pxg
/*     */ {
/*  31 */   private int externalWorkbookNumber = -1;
/*     */   private String sheetName;
/*     */   private String nameName;
/*     */   
/*     */   public NameXPxg(int paramInt, String paramString1, String paramString2) {
/*  36 */     this.externalWorkbookNumber = paramInt;
/*  37 */     this.sheetName = paramString1;
/*  38 */     this.nameName = paramString2;
/*     */   }
/*     */   public NameXPxg(String paramString1, String paramString2) {
/*  41 */     this(-1, paramString1, paramString2);
/*     */   }
/*     */   public NameXPxg(String paramString) {
/*  44 */     this(-1, null, paramString);
/*     */   }
/*     */   
/*     */   public String toString() {
/*  48 */     StringBuffer stringBuffer = new StringBuffer();
/*  49 */     stringBuffer.append(getClass().getName());
/*  50 */     stringBuffer.append(" [");
/*  51 */     if (this.externalWorkbookNumber >= 0) {
/*  52 */       stringBuffer.append(" [");
/*  53 */       stringBuffer.append("workbook=").append(getExternalWorkbookNumber());
/*  54 */       stringBuffer.append("] ");
/*     */     } 
/*  56 */     stringBuffer.append("sheet=").append(getSheetName());
/*  57 */     stringBuffer.append(" ! ");
/*  58 */     stringBuffer.append("name=");
/*  59 */     stringBuffer.append(this.nameName);
/*  60 */     stringBuffer.append("]");
/*  61 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public int getExternalWorkbookNumber() {
/*  65 */     return this.externalWorkbookNumber;
/*     */   }
/*     */   public String getSheetName() {
/*  68 */     return this.sheetName;
/*     */   }
/*     */   public String getNameName() {
/*  71 */     return this.nameName;
/*     */   }
/*     */   
/*     */   public void setSheetName(String paramString) {
/*  75 */     this.sheetName = paramString;
/*     */   }
/*     */   
/*     */   public String toFormulaString() {
/*  79 */     StringBuffer stringBuffer = new StringBuffer();
/*  80 */     boolean bool = false;
/*  81 */     if (this.externalWorkbookNumber >= 0) {
/*  82 */       stringBuffer.append('[');
/*  83 */       stringBuffer.append(this.externalWorkbookNumber);
/*  84 */       stringBuffer.append(']');
/*  85 */       bool = true;
/*     */     } 
/*  87 */     if (this.sheetName != null) {
/*  88 */       SheetNameFormatter.appendFormat(stringBuffer, this.sheetName);
/*  89 */       bool = true;
/*     */     } 
/*  91 */     if (bool) {
/*  92 */       stringBuffer.append('!');
/*     */     }
/*  94 */     stringBuffer.append(this.nameName);
/*  95 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public byte getDefaultOperandClass() {
/*  99 */     return 32;
/*     */   }
/*     */   
/*     */   public int getSize() {
/* 103 */     return 1;
/*     */   }
/*     */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 106 */     throw new IllegalStateException("XSSF-only Ptg, should not be serialised");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\NameXPxg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */