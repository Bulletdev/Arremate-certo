/*     */ package org.apache.poi.ss.formula.ptg;
/*     */ 
/*     */ import org.apache.poi.ss.formula.SheetIdentifier;
/*     */ import org.apache.poi.ss.formula.SheetNameFormatter;
/*     */ import org.apache.poi.ss.formula.SheetRangeIdentifier;
/*     */ import org.apache.poi.ss.util.AreaReference;
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
/*     */ public final class Area3DPxg
/*     */   extends AreaPtgBase
/*     */   implements Pxg3D
/*     */ {
/*  35 */   private int externalWorkbookNumber = -1;
/*     */   private String firstSheetName;
/*     */   private String lastSheetName;
/*     */   
/*     */   public Area3DPxg(int paramInt, SheetIdentifier paramSheetIdentifier, String paramString) {
/*  40 */     this(paramInt, paramSheetIdentifier, new AreaReference(paramString));
/*     */   }
/*     */   public Area3DPxg(int paramInt, SheetIdentifier paramSheetIdentifier, AreaReference paramAreaReference) {
/*  43 */     super(paramAreaReference);
/*  44 */     this.externalWorkbookNumber = paramInt;
/*  45 */     this.firstSheetName = paramSheetIdentifier.getSheetIdentifier().getName();
/*  46 */     if (paramSheetIdentifier instanceof SheetRangeIdentifier) {
/*  47 */       this.lastSheetName = ((SheetRangeIdentifier)paramSheetIdentifier).getLastSheetIdentifier().getName();
/*     */     } else {
/*  49 */       this.lastSheetName = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public Area3DPxg(SheetIdentifier paramSheetIdentifier, String paramString) {
/*  54 */     this(paramSheetIdentifier, new AreaReference(paramString));
/*     */   }
/*     */   public Area3DPxg(SheetIdentifier paramSheetIdentifier, AreaReference paramAreaReference) {
/*  57 */     this(-1, paramSheetIdentifier, paramAreaReference);
/*     */   }
/*     */ 
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
/*  70 */     stringBuffer.append("sheet=").append(getSheetName());
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
/* 109 */     SheetNameFormatter.appendFormat(stringBuffer, this.firstSheetName);
/* 110 */     if (this.lastSheetName != null) {
/* 111 */       stringBuffer.append(':');
/* 112 */       SheetNameFormatter.appendFormat(stringBuffer, this.lastSheetName);
/*     */     } 
/* 114 */     stringBuffer.append('!');
/* 115 */     stringBuffer.append(formatReferenceAsString());
/* 116 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public int getSize() {
/* 120 */     return 1;
/*     */   }
/*     */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 123 */     throw new IllegalStateException("XSSF-only Ptg, should not be serialised");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\Area3DPxg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */