/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.util.HexDump;
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
/*     */ public abstract class OldCellRecord
/*     */ {
/*     */   private final short sid;
/*     */   private final boolean isBiff2;
/*     */   private final int field_1_row;
/*     */   private final short field_2_column;
/*     */   private int field_3_cell_attrs;
/*     */   private short field_3_xf_index;
/*     */   
/*     */   protected OldCellRecord(RecordInputStream paramRecordInputStream, boolean paramBoolean) {
/*  36 */     this.sid = paramRecordInputStream.getSid();
/*  37 */     this.isBiff2 = paramBoolean;
/*  38 */     this.field_1_row = paramRecordInputStream.readUShort();
/*  39 */     this.field_2_column = paramRecordInputStream.readShort();
/*     */     
/*  41 */     if (paramBoolean) {
/*  42 */       this.field_3_cell_attrs = paramRecordInputStream.readUShort() << 8;
/*  43 */       this.field_3_cell_attrs += paramRecordInputStream.readUByte();
/*     */     } else {
/*  45 */       this.field_3_xf_index = paramRecordInputStream.readShort();
/*     */     } 
/*     */   }
/*     */   
/*     */   public final int getRow() {
/*  50 */     return this.field_1_row;
/*     */   }
/*     */   
/*     */   public final short getColumn() {
/*  54 */     return this.field_2_column;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final short getXFIndex() {
/*  64 */     return this.field_3_xf_index;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCellAttrs() {
/*  69 */     return this.field_3_cell_attrs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBiff2() {
/*  78 */     return this.isBiff2;
/*     */   }
/*     */   
/*     */   public short getSid() {
/*  82 */     return this.sid;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/*  87 */     StringBuilder stringBuilder = new StringBuilder();
/*  88 */     String str = getRecordName();
/*     */     
/*  90 */     stringBuilder.append("[").append(str).append("]\n");
/*  91 */     stringBuilder.append("    .row    = ").append(HexDump.shortToHex(getRow())).append("\n");
/*  92 */     stringBuilder.append("    .col    = ").append(HexDump.shortToHex(getColumn())).append("\n");
/*  93 */     if (isBiff2()) {
/*  94 */       stringBuilder.append("    .cellattrs = ").append(HexDump.shortToHex(getCellAttrs())).append("\n");
/*     */     } else {
/*  96 */       stringBuilder.append("    .xfindex   = ").append(HexDump.shortToHex(getXFIndex())).append("\n");
/*     */     } 
/*  98 */     appendValueText(stringBuilder);
/*  99 */     stringBuilder.append("\n");
/* 100 */     stringBuilder.append("[/").append(str).append("]\n");
/* 101 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   protected abstract void appendValueText(StringBuilder paramStringBuilder);
/*     */   
/*     */   protected abstract String getRecordName();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\OldCellRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */