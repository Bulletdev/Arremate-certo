/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
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
/*     */ public final class ColumnInfoRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 125;
/*     */   private int _firstCol;
/*     */   private int _lastCol;
/*     */   private int _colWidth;
/*     */   private int _xfIndex;
/*     */   private int _options;
/*  38 */   private static final BitField hidden = BitFieldFactory.getInstance(1);
/*  39 */   private static final BitField outlevel = BitFieldFactory.getInstance(1792);
/*  40 */   private static final BitField collapsed = BitFieldFactory.getInstance(4096);
/*     */ 
/*     */   
/*     */   private int field_6_reserved;
/*     */ 
/*     */ 
/*     */   
/*     */   public ColumnInfoRecord() {
/*  48 */     setColumnWidth(2275);
/*  49 */     this._options = 2;
/*  50 */     this._xfIndex = 15;
/*  51 */     this.field_6_reserved = 2;
/*     */   }
/*     */   
/*     */   public ColumnInfoRecord(RecordInputStream paramRecordInputStream) {
/*  55 */     this._firstCol = paramRecordInputStream.readUShort();
/*  56 */     this._lastCol = paramRecordInputStream.readUShort();
/*  57 */     this._colWidth = paramRecordInputStream.readUShort();
/*  58 */     this._xfIndex = paramRecordInputStream.readUShort();
/*  59 */     this._options = paramRecordInputStream.readUShort();
/*  60 */     switch (paramRecordInputStream.remaining()) {
/*     */       case 2:
/*  62 */         this.field_6_reserved = paramRecordInputStream.readUShort();
/*     */         return;
/*     */ 
/*     */       
/*     */       case 1:
/*  67 */         this.field_6_reserved = paramRecordInputStream.readByte();
/*     */         return;
/*     */ 
/*     */ 
/*     */       
/*     */       case 0:
/*  73 */         this.field_6_reserved = 0;
/*     */         return;
/*     */     } 
/*  76 */     throw new RuntimeException("Unusual record size remaining=(" + paramRecordInputStream.remaining() + ")");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFirstColumn(int paramInt) {
/*  85 */     this._firstCol = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastColumn(int paramInt) {
/*  93 */     this._lastCol = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColumnWidth(int paramInt) {
/* 101 */     this._colWidth = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setXFIndex(int paramInt) {
/* 110 */     this._xfIndex = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHidden(boolean paramBoolean) {
/* 118 */     this._options = hidden.setBoolean(this._options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOutlineLevel(int paramInt) {
/* 126 */     this._options = outlevel.setValue(this._options, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCollapsed(boolean paramBoolean) {
/* 134 */     this._options = collapsed.setBoolean(this._options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFirstColumn() {
/* 142 */     return this._firstCol;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLastColumn() {
/* 150 */     return this._lastCol;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColumnWidth() {
/* 157 */     return this._colWidth;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getXFIndex() {
/* 166 */     return this._xfIndex;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getHidden() {
/* 173 */     return hidden.isSet(this._options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOutlineLevel() {
/* 180 */     return outlevel.getValue(this._options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCollapsed() {
/* 187 */     return collapsed.isSet(this._options);
/*     */   }
/*     */   
/*     */   public boolean containsColumn(int paramInt) {
/* 191 */     return (this._firstCol <= paramInt && paramInt <= this._lastCol);
/*     */   }
/*     */   public boolean isAdjacentBefore(ColumnInfoRecord paramColumnInfoRecord) {
/* 194 */     return (this._lastCol == paramColumnInfoRecord._firstCol - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean formatMatches(ColumnInfoRecord paramColumnInfoRecord) {
/* 203 */     if (this._xfIndex != paramColumnInfoRecord._xfIndex) {
/* 204 */       return false;
/*     */     }
/* 206 */     if (this._options != paramColumnInfoRecord._options) {
/* 207 */       return false;
/*     */     }
/* 209 */     if (this._colWidth != paramColumnInfoRecord._colWidth) {
/* 210 */       return false;
/*     */     }
/* 212 */     return true;
/*     */   }
/*     */   
/*     */   public short getSid() {
/* 216 */     return 125;
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 220 */     paramLittleEndianOutput.writeShort(getFirstColumn());
/* 221 */     paramLittleEndianOutput.writeShort(getLastColumn());
/* 222 */     paramLittleEndianOutput.writeShort(getColumnWidth());
/* 223 */     paramLittleEndianOutput.writeShort(getXFIndex());
/* 224 */     paramLittleEndianOutput.writeShort(this._options);
/* 225 */     paramLittleEndianOutput.writeShort(this.field_6_reserved);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 229 */     return 12;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 233 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 235 */     stringBuilder.append("[COLINFO]\n");
/* 236 */     stringBuilder.append("  colfirst = ").append(getFirstColumn()).append("\n");
/* 237 */     stringBuilder.append("  collast  = ").append(getLastColumn()).append("\n");
/* 238 */     stringBuilder.append("  colwidth = ").append(getColumnWidth()).append("\n");
/* 239 */     stringBuilder.append("  xfindex  = ").append(getXFIndex()).append("\n");
/* 240 */     stringBuilder.append("  options  = ").append(HexDump.shortToHex(this._options)).append("\n");
/* 241 */     stringBuilder.append("    hidden   = ").append(getHidden()).append("\n");
/* 242 */     stringBuilder.append("    olevel   = ").append(getOutlineLevel()).append("\n");
/* 243 */     stringBuilder.append("    collapsed= ").append(getCollapsed()).append("\n");
/* 244 */     stringBuilder.append("[/COLINFO]\n");
/* 245 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public ColumnInfoRecord clone() {
/* 250 */     ColumnInfoRecord columnInfoRecord = new ColumnInfoRecord();
/* 251 */     columnInfoRecord._firstCol = this._firstCol;
/* 252 */     columnInfoRecord._lastCol = this._lastCol;
/* 253 */     columnInfoRecord._colWidth = this._colWidth;
/* 254 */     columnInfoRecord._xfIndex = this._xfIndex;
/* 255 */     columnInfoRecord._options = this._options;
/* 256 */     columnInfoRecord.field_6_reserved = this.field_6_reserved;
/* 257 */     return columnInfoRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\ColumnInfoRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */