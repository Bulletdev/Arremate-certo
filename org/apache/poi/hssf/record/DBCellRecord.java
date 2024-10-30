/*     */ package org.apache.poi.hssf.record;
/*     */ 
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
/*     */ public final class DBCellRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 215;
/*     */   public static final int BLOCK_SIZE = 32;
/*     */   private final int field_1_row_offset;
/*     */   private final short[] field_2_cell_offsets;
/*     */   
/*     */   public static final class Builder
/*     */   {
/*  36 */     private short[] _cellOffsets = new short[4];
/*     */     private int _nCellOffsets;
/*     */     
/*     */     public void addCellOffset(int param1Int) {
/*  40 */       if (this._cellOffsets.length <= this._nCellOffsets) {
/*  41 */         short[] arrayOfShort = new short[this._nCellOffsets * 2];
/*  42 */         System.arraycopy(this._cellOffsets, 0, arrayOfShort, 0, this._nCellOffsets);
/*  43 */         this._cellOffsets = arrayOfShort;
/*     */       } 
/*  45 */       this._cellOffsets[this._nCellOffsets] = (short)param1Int;
/*  46 */       this._nCellOffsets++;
/*     */     }
/*     */     
/*     */     public DBCellRecord build(int param1Int) {
/*  50 */       short[] arrayOfShort = new short[this._nCellOffsets];
/*  51 */       System.arraycopy(this._cellOffsets, 0, arrayOfShort, 0, this._nCellOffsets);
/*  52 */       return new DBCellRecord(param1Int, arrayOfShort);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   DBCellRecord(int paramInt, short[] paramArrayOfshort) {
/*  63 */     this.field_1_row_offset = paramInt;
/*  64 */     this.field_2_cell_offsets = paramArrayOfshort;
/*     */   }
/*     */   
/*     */   public DBCellRecord(RecordInputStream paramRecordInputStream) {
/*  68 */     this.field_1_row_offset = paramRecordInputStream.readUShort();
/*  69 */     int i = paramRecordInputStream.remaining();
/*  70 */     this.field_2_cell_offsets = new short[i / 2];
/*     */     
/*  72 */     for (byte b = 0; b < this.field_2_cell_offsets.length; b++)
/*     */     {
/*  74 */       this.field_2_cell_offsets[b] = paramRecordInputStream.readShort();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  80 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  82 */     stringBuffer.append("[DBCELL]\n");
/*  83 */     stringBuffer.append("    .rowoffset = ").append(HexDump.intToHex(this.field_1_row_offset)).append("\n");
/*  84 */     for (byte b = 0; b < this.field_2_cell_offsets.length; b++) {
/*  85 */       stringBuffer.append("    .cell_").append(b).append(" = ").append(HexDump.shortToHex(this.field_2_cell_offsets[b])).append("\n");
/*     */     }
/*     */     
/*  88 */     stringBuffer.append("[/DBCELL]\n");
/*  89 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  93 */     paramLittleEndianOutput.writeInt(this.field_1_row_offset);
/*  94 */     for (byte b = 0; b < this.field_2_cell_offsets.length; b++)
/*  95 */       paramLittleEndianOutput.writeShort(this.field_2_cell_offsets[b]); 
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  99 */     return 4 + this.field_2_cell_offsets.length * 2;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static int calculateSizeOfRecords(int paramInt1, int paramInt2) {
/* 115 */     return paramInt1 * 8 + paramInt2 * 2;
/*     */   }
/*     */   
/*     */   public short getSid() {
/* 119 */     return 215;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DBCellRecord clone() {
/* 125 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\DBCellRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */