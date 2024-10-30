/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.common.usermodel.HyperlinkType;
/*     */ import org.apache.poi.hssf.record.HyperlinkRecord;
/*     */ import org.apache.poi.ss.usermodel.Hyperlink;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HSSFHyperlink
/*     */   implements Hyperlink
/*     */ {
/*     */   protected final HyperlinkRecord record;
/*     */   protected final HyperlinkType link_type;
/*     */   
/*     */   @Internal(since = "3.15 beta 3")
/*     */   protected HSSFHyperlink(int paramInt) {
/*  51 */     this(HyperlinkType.forInt(paramInt));
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
/*     */   @Internal(since = "3.15 beta 3")
/*     */   protected HSSFHyperlink(HyperlinkType paramHyperlinkType) {
/*  65 */     this.link_type = paramHyperlinkType;
/*  66 */     this.record = new HyperlinkRecord();
/*  67 */     switch (paramHyperlinkType) {
/*     */       case URL:
/*     */       case EMAIL:
/*  70 */         this.record.newUrlLink();
/*     */         return;
/*     */       case FILE:
/*  73 */         this.record.newFileLink();
/*     */         return;
/*     */       case DOCUMENT:
/*  76 */         this.record.newDocumentLink();
/*     */         return;
/*     */     } 
/*  79 */     throw new IllegalArgumentException("Invalid type: " + paramHyperlinkType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected HSSFHyperlink(HyperlinkRecord paramHyperlinkRecord) {
/*  90 */     this.record = paramHyperlinkRecord;
/*  91 */     this.link_type = getType(paramHyperlinkRecord);
/*     */   }
/*     */ 
/*     */   
/*     */   private static HyperlinkType getType(HyperlinkRecord paramHyperlinkRecord) {
/*     */     HyperlinkType hyperlinkType;
/*  97 */     if (paramHyperlinkRecord.isFileLink()) {
/*  98 */       hyperlinkType = HyperlinkType.FILE;
/*  99 */     } else if (paramHyperlinkRecord.isDocumentLink()) {
/* 100 */       hyperlinkType = HyperlinkType.DOCUMENT;
/*     */     }
/* 102 */     else if (paramHyperlinkRecord.getAddress() != null && paramHyperlinkRecord.getAddress().startsWith("mailto:")) {
/*     */       
/* 104 */       hyperlinkType = HyperlinkType.EMAIL;
/*     */     } else {
/* 106 */       hyperlinkType = HyperlinkType.URL;
/*     */     } 
/*     */     
/* 109 */     return hyperlinkType;
/*     */   }
/*     */   
/*     */   protected HSSFHyperlink(Hyperlink paramHyperlink) {
/* 113 */     if (paramHyperlink instanceof HSSFHyperlink) {
/* 114 */       HSSFHyperlink hSSFHyperlink = (HSSFHyperlink)paramHyperlink;
/* 115 */       this.record = hSSFHyperlink.record.clone();
/* 116 */       this.link_type = getType(this.record);
/*     */     } else {
/*     */       
/* 119 */       this.link_type = paramHyperlink.getTypeEnum();
/* 120 */       this.record = new HyperlinkRecord();
/* 121 */       setFirstRow(paramHyperlink.getFirstRow());
/* 122 */       setFirstColumn(paramHyperlink.getFirstColumn());
/* 123 */       setLastRow(paramHyperlink.getLastRow());
/* 124 */       setLastColumn(paramHyperlink.getLastColumn());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFirstRow() {
/* 135 */     return this.record.getFirstRow();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFirstRow(int paramInt) {
/* 145 */     this.record.setFirstRow(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLastRow() {
/* 155 */     return this.record.getLastRow();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastRow(int paramInt) {
/* 165 */     this.record.setLastRow(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFirstColumn() {
/* 175 */     return this.record.getFirstColumn();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFirstColumn(int paramInt) {
/* 185 */     this.record.setFirstColumn((short)paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLastColumn() {
/* 195 */     return this.record.getLastColumn();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastColumn(int paramInt) {
/* 205 */     this.record.setLastColumn((short)paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAddress() {
/* 215 */     return this.record.getAddress();
/*     */   }
/*     */   public String getTextMark() {
/* 218 */     return this.record.getTextMark();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextMark(String paramString) {
/* 227 */     this.record.setTextMark(paramString);
/*     */   }
/*     */   public String getShortFilename() {
/* 230 */     return this.record.getShortFilename();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShortFilename(String paramString) {
/* 238 */     this.record.setShortFilename(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddress(String paramString) {
/* 248 */     this.record.setAddress(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLabel() {
/* 258 */     return this.record.getLabel();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLabel(String paramString) {
/* 268 */     this.record.setLabel(paramString);
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
/*     */   public int getType() {
/* 281 */     return this.link_type.getCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HyperlinkType getTypeEnum() {
/* 291 */     return this.link_type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 299 */     if (this == paramObject) return true; 
/* 300 */     if (!(paramObject instanceof HSSFHyperlink)) return false; 
/* 301 */     HSSFHyperlink hSSFHyperlink = (HSSFHyperlink)paramObject;
/* 302 */     return (this.record == hSSFHyperlink.record);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 307 */     return this.record.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFHyperlink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */