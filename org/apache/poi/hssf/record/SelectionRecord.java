/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.hssf.util.CellRangeAddress8Bit;
/*     */ import org.apache.poi.util.HexDump;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SelectionRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 29;
/*     */   private byte field_1_pane;
/*     */   private int field_2_row_active_cell;
/*     */   private int field_3_col_active_cell;
/*     */   private int field_4_active_cell_ref_index;
/*     */   private CellRangeAddress8Bit[] field_6_refs;
/*     */   
/*     */   public SelectionRecord(int paramInt1, int paramInt2) {
/*  46 */     this.field_1_pane = 3;
/*  47 */     this.field_2_row_active_cell = paramInt1;
/*  48 */     this.field_3_col_active_cell = paramInt2;
/*  49 */     this.field_4_active_cell_ref_index = 0;
/*  50 */     this.field_6_refs = new CellRangeAddress8Bit[] { new CellRangeAddress8Bit(paramInt1, paramInt1, paramInt2, paramInt2) };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SelectionRecord(RecordInputStream paramRecordInputStream) {
/*  56 */     this.field_1_pane = paramRecordInputStream.readByte();
/*  57 */     this.field_2_row_active_cell = paramRecordInputStream.readUShort();
/*  58 */     this.field_3_col_active_cell = paramRecordInputStream.readShort();
/*  59 */     this.field_4_active_cell_ref_index = paramRecordInputStream.readShort();
/*  60 */     int i = paramRecordInputStream.readUShort();
/*     */     
/*  62 */     this.field_6_refs = new CellRangeAddress8Bit[i];
/*  63 */     for (byte b = 0; b < this.field_6_refs.length; b++) {
/*  64 */       this.field_6_refs[b] = new CellRangeAddress8Bit(paramRecordInputStream);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPane(byte paramByte) {
/*  73 */     this.field_1_pane = paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActiveCellRow(int paramInt) {
/*  81 */     this.field_2_row_active_cell = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActiveCellCol(short paramShort) {
/*  89 */     this.field_3_col_active_cell = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActiveCellRef(short paramShort) {
/*  97 */     this.field_4_active_cell_ref_index = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getPane() {
/* 104 */     return this.field_1_pane;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getActiveCellRow() {
/* 112 */     return this.field_2_row_active_cell;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getActiveCellCol() {
/* 120 */     return this.field_3_col_active_cell;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getActiveCellRef() {
/* 128 */     return this.field_4_active_cell_ref_index;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 133 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 135 */     stringBuffer.append("[SELECTION]\n");
/* 136 */     stringBuffer.append("    .pane            = ").append(HexDump.byteToHex(getPane())).append("\n");
/* 137 */     stringBuffer.append("    .activecellrow   = ").append(HexDump.shortToHex(getActiveCellRow())).append("\n");
/* 138 */     stringBuffer.append("    .activecellcol   = ").append(HexDump.shortToHex(getActiveCellCol())).append("\n");
/* 139 */     stringBuffer.append("    .activecellref   = ").append(HexDump.shortToHex(getActiveCellRef())).append("\n");
/* 140 */     stringBuffer.append("    .numrefs         = ").append(HexDump.shortToHex(this.field_6_refs.length)).append("\n");
/* 141 */     stringBuffer.append("[/SELECTION]\n");
/* 142 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 146 */     return 9 + CellRangeAddress8Bit.getEncodedSize(this.field_6_refs.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 151 */     paramLittleEndianOutput.writeByte(getPane());
/* 152 */     paramLittleEndianOutput.writeShort(getActiveCellRow());
/* 153 */     paramLittleEndianOutput.writeShort(getActiveCellCol());
/* 154 */     paramLittleEndianOutput.writeShort(getActiveCellRef());
/* 155 */     int i = this.field_6_refs.length;
/* 156 */     paramLittleEndianOutput.writeShort(i);
/* 157 */     for (CellRangeAddress8Bit cellRangeAddress8Bit : this.field_6_refs) {
/* 158 */       cellRangeAddress8Bit.serialize(paramLittleEndianOutput);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 164 */     return 29;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object clone() {
/* 169 */     SelectionRecord selectionRecord = new SelectionRecord(this.field_2_row_active_cell, this.field_3_col_active_cell);
/* 170 */     selectionRecord.field_1_pane = this.field_1_pane;
/* 171 */     selectionRecord.field_4_active_cell_ref_index = this.field_4_active_cell_ref_index;
/* 172 */     selectionRecord.field_6_refs = this.field_6_refs;
/* 173 */     return selectionRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\SelectionRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */