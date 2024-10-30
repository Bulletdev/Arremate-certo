/*     */ package org.apache.poi.ss.formula.ptg;
/*     */ 
/*     */ import org.apache.poi.ss.formula.SheetIdentifier;
/*     */ import org.apache.poi.ss.formula.SheetNameFormatter;
/*     */ import org.apache.poi.ss.formula.SheetRangeIdentifier;
/*     */ import org.apache.poi.ss.util.CellReference;
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
/*     */ 
/*     */ public final class Ref3DPxg
/*     */   extends RefPtgBase
/*     */   implements Pxg3D
/*     */ {
/*  35 */   private int externalWorkbookNumber = -1;
/*     */   private String firstSheetName;
/*     */   private String lastSheetName;
/*     */   
/*     */   public Ref3DPxg(int paramInt, SheetIdentifier paramSheetIdentifier, String paramString) {
/*  40 */     this(paramInt, paramSheetIdentifier, new CellReference(paramString));
/*     */   }
/*     */   public Ref3DPxg(int paramInt, SheetIdentifier paramSheetIdentifier, CellReference paramCellReference) {
/*  43 */     super(paramCellReference);
/*  44 */     this.externalWorkbookNumber = paramInt;
/*     */     
/*  46 */     this.firstSheetName = paramSheetIdentifier.getSheetIdentifier().getName();
/*  47 */     if (paramSheetIdentifier instanceof SheetRangeIdentifier) {
/*  48 */       this.lastSheetName = ((SheetRangeIdentifier)paramSheetIdentifier).getLastSheetIdentifier().getName();
/*     */     } else {
/*  50 */       this.lastSheetName = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public Ref3DPxg(SheetIdentifier paramSheetIdentifier, String paramString) {
/*  55 */     this(paramSheetIdentifier, new CellReference(paramString));
/*     */   }
/*     */   public Ref3DPxg(SheetIdentifier paramSheetIdentifier, CellReference paramCellReference) {
/*  58 */     this(-1, paramSheetIdentifier, paramCellReference);
/*     */   }
/*     */   
/*     */   public String toString() {
/*  62 */     StringBuffer stringBuffer = new StringBuffer();
/*  63 */     stringBuffer.append(getClass().getName());
/*  64 */     stringBuffer.append(" [");
/*  65 */     if (this.externalWorkbookNumber >= 0) {
/*  66 */       stringBuffer.append(" [");
/*  67 */       stringBuffer.append("workbook=").append(getExternalWorkbookNumber());
/*  68 */       stringBuffer.append("] ");
/*     */     } 
/*  70 */     stringBuffer.append("sheet=").append(this.firstSheetName);
/*  71 */     if (this.lastSheetName != null) {
/*  72 */       stringBuffer.append(" : ");
/*  73 */       stringBuffer.append("sheet=").append(this.lastSheetName);
/*     */     } 
/*  75 */     stringBuffer.append(" ! ");
/*  76 */     stringBuffer.append(formatReferenceAsString());
/*  77 */     stringBuffer.append("]");
/*  78 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public int getExternalWorkbookNumber() {
/*  82 */     return this.externalWorkbookNumber;
/*     */   }
/*     */   public String getSheetName() {
/*  85 */     return this.firstSheetName;
/*     */   }
/*     */   public String getLastSheetName() {
/*  88 */     return this.lastSheetName;
/*     */   }
/*     */   
/*     */   public void setSheetName(String paramString) {
/*  92 */     this.firstSheetName = paramString;
/*     */   }
/*     */   public void setLastSheetName(String paramString) {
/*  95 */     this.lastSheetName = paramString;
/*     */   }
/*     */   
/*     */   public String format2DRefAsString() {
/*  99 */     return formatReferenceAsString();
/*     */   }
/*     */   
/*     */   public String toFormulaString() {
/* 103 */     StringBuffer stringBuffer = new StringBuffer();
/* 104 */     if (this.externalWorkbookNumber >= 0) {
/* 105 */       stringBuffer.append('[');
/* 106 */       stringBuffer.append(this.externalWorkbookNumber);
/* 107 */       stringBuffer.append(']');
/*     */     } 
/* 109 */     if (this.firstSheetName != null) {
/* 110 */       SheetNameFormatter.appendFormat(stringBuffer, this.firstSheetName);
/*     */     }
/* 112 */     if (this.lastSheetName != null) {
/* 113 */       stringBuffer.append(':');
/* 114 */       SheetNameFormatter.appendFormat(stringBuffer, this.lastSheetName);
/*     */     } 
/* 116 */     stringBuffer.append('!');
/* 117 */     stringBuffer.append(formatReferenceAsString());
/* 118 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public int getSize() {
/* 122 */     return 1;
/*     */   }
/*     */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 125 */     throw new IllegalStateException("XSSF-only Ptg, should not be serialised");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\Ref3DPxg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */