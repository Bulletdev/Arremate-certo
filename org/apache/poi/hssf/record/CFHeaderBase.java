/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.ss.util.CellRangeAddress;
/*     */ import org.apache.poi.ss.util.CellRangeAddressList;
/*     */ import org.apache.poi.ss.util.CellRangeUtil;
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
/*     */ public abstract class CFHeaderBase
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   private int field_1_numcf;
/*     */   private int field_2_need_recalculation_and_id;
/*     */   private CellRangeAddress field_3_enclosing_cell_range;
/*     */   private CellRangeAddressList field_4_cell_ranges;
/*     */   
/*     */   protected CFHeaderBase() {}
/*     */   
/*     */   protected CFHeaderBase(CellRangeAddress[] paramArrayOfCellRangeAddress, int paramInt) {
/*  39 */     CellRangeAddress[] arrayOfCellRangeAddress1 = paramArrayOfCellRangeAddress;
/*  40 */     CellRangeAddress[] arrayOfCellRangeAddress2 = CellRangeUtil.mergeCellRanges(arrayOfCellRangeAddress1);
/*  41 */     setCellRanges(arrayOfCellRangeAddress2);
/*  42 */     this.field_1_numcf = paramInt;
/*     */   }
/*     */   
/*     */   protected void createEmpty() {
/*  46 */     this.field_3_enclosing_cell_range = new CellRangeAddress(0, 0, 0, 0);
/*  47 */     this.field_4_cell_ranges = new CellRangeAddressList();
/*     */   }
/*     */   protected void read(RecordInputStream paramRecordInputStream) {
/*  50 */     this.field_1_numcf = paramRecordInputStream.readShort();
/*  51 */     this.field_2_need_recalculation_and_id = paramRecordInputStream.readShort();
/*  52 */     this.field_3_enclosing_cell_range = new CellRangeAddress(paramRecordInputStream);
/*  53 */     this.field_4_cell_ranges = new CellRangeAddressList(paramRecordInputStream);
/*     */   }
/*     */   
/*     */   public int getNumberOfConditionalFormats() {
/*  57 */     return this.field_1_numcf;
/*     */   }
/*     */   public void setNumberOfConditionalFormats(int paramInt) {
/*  60 */     this.field_1_numcf = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getNeedRecalculation() {
/*  65 */     return ((this.field_2_need_recalculation_and_id & 0x1) == 1);
/*     */   }
/*     */   
/*     */   public void setNeedRecalculation(boolean paramBoolean) {
/*  69 */     if (paramBoolean == getNeedRecalculation())
/*     */       return; 
/*  71 */     if (paramBoolean) {
/*  72 */       this.field_2_need_recalculation_and_id++;
/*     */     } else {
/*  74 */       this.field_2_need_recalculation_and_id--;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getID() {
/*  80 */     return this.field_2_need_recalculation_and_id >> 1;
/*     */   }
/*     */   
/*     */   public void setID(int paramInt) {
/*  84 */     boolean bool = getNeedRecalculation();
/*  85 */     this.field_2_need_recalculation_and_id = paramInt << 1;
/*  86 */     if (bool) {
/*  87 */       this.field_2_need_recalculation_and_id++;
/*     */     }
/*     */   }
/*     */   
/*     */   public CellRangeAddress getEnclosingCellRange() {
/*  92 */     return this.field_3_enclosing_cell_range;
/*     */   }
/*     */   public void setEnclosingCellRange(CellRangeAddress paramCellRangeAddress) {
/*  95 */     this.field_3_enclosing_cell_range = paramCellRangeAddress;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCellRanges(CellRangeAddress[] paramArrayOfCellRangeAddress) {
/* 104 */     if (paramArrayOfCellRangeAddress == null) {
/* 105 */       throw new IllegalArgumentException("cellRanges must not be null");
/*     */     }
/* 107 */     CellRangeAddressList cellRangeAddressList = new CellRangeAddressList();
/* 108 */     CellRangeAddress cellRangeAddress = null;
/* 109 */     for (byte b = 0; b < paramArrayOfCellRangeAddress.length; b++) {
/* 110 */       CellRangeAddress cellRangeAddress1 = paramArrayOfCellRangeAddress[b];
/* 111 */       cellRangeAddress = CellRangeUtil.createEnclosingCellRange(cellRangeAddress1, cellRangeAddress);
/* 112 */       cellRangeAddressList.addCellRangeAddress(cellRangeAddress1);
/*     */     } 
/* 114 */     this.field_3_enclosing_cell_range = cellRangeAddress;
/* 115 */     this.field_4_cell_ranges = cellRangeAddressList;
/*     */   }
/*     */   
/*     */   public CellRangeAddress[] getCellRanges() {
/* 119 */     return this.field_4_cell_ranges.getCellRangeAddresses();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 124 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 126 */     stringBuffer.append("[").append(getRecordName()).append("]\n");
/* 127 */     stringBuffer.append("\t.numCF             = ").append(getNumberOfConditionalFormats()).append("\n");
/* 128 */     stringBuffer.append("\t.needRecalc        = ").append(getNeedRecalculation()).append("\n");
/* 129 */     stringBuffer.append("\t.id                = ").append(getID()).append("\n");
/* 130 */     stringBuffer.append("\t.enclosingCellRange= ").append(getEnclosingCellRange()).append("\n");
/* 131 */     stringBuffer.append("\t.cfranges=[");
/* 132 */     for (byte b = 0; b < this.field_4_cell_ranges.countRanges(); b++) {
/* 133 */       stringBuffer.append((b == 0) ? "" : ",").append(this.field_4_cell_ranges.getCellRangeAddress(b).toString());
/*     */     }
/* 135 */     stringBuffer.append("]\n");
/* 136 */     stringBuffer.append("[/").append(getRecordName()).append("]\n");
/* 137 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 141 */     return 12 + this.field_4_cell_ranges.getSize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 147 */     paramLittleEndianOutput.writeShort(this.field_1_numcf);
/* 148 */     paramLittleEndianOutput.writeShort(this.field_2_need_recalculation_and_id);
/* 149 */     this.field_3_enclosing_cell_range.serialize(paramLittleEndianOutput);
/* 150 */     this.field_4_cell_ranges.serialize(paramLittleEndianOutput);
/*     */   }
/*     */   
/*     */   protected void copyTo(CFHeaderBase paramCFHeaderBase) {
/* 154 */     paramCFHeaderBase.field_1_numcf = this.field_1_numcf;
/* 155 */     paramCFHeaderBase.field_2_need_recalculation_and_id = this.field_2_need_recalculation_and_id;
/* 156 */     paramCFHeaderBase.field_3_enclosing_cell_range = this.field_3_enclosing_cell_range.copy();
/* 157 */     paramCFHeaderBase.field_4_cell_ranges = this.field_4_cell_ranges.copy();
/*     */   }
/*     */   
/*     */   protected abstract String getRecordName();
/*     */   
/*     */   public abstract CFHeaderBase clone();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\CFHeaderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */