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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PaneRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 65;
/*     */   private short field_1_x;
/*     */   private short field_2_y;
/*     */   private short field_3_topRow;
/*     */   private short field_4_leftColumn;
/*     */   private short field_5_activePane;
/*     */   public static final short ACTIVE_PANE_LOWER_RIGHT = 0;
/*     */   public static final short ACTIVE_PANE_UPPER_RIGHT = 1;
/*     */   public static final short ACTIVE_PANE_LOWER_LEFT = 2;
/*     */   public static final short ACTIVE_PANE_UPPER_LEFT = 3;
/*     */   
/*     */   public PaneRecord() {}
/*     */   
/*     */   public PaneRecord(RecordInputStream paramRecordInputStream) {
/*  47 */     this.field_1_x = paramRecordInputStream.readShort();
/*  48 */     this.field_2_y = paramRecordInputStream.readShort();
/*  49 */     this.field_3_topRow = paramRecordInputStream.readShort();
/*  50 */     this.field_4_leftColumn = paramRecordInputStream.readShort();
/*  51 */     this.field_5_activePane = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  57 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  59 */     stringBuffer.append("[PANE]\n");
/*  60 */     stringBuffer.append("    .x                    = ").append("0x").append(HexDump.toHex(getX())).append(" (").append(getX()).append(" )");
/*     */ 
/*     */     
/*  63 */     stringBuffer.append(System.getProperty("line.separator"));
/*  64 */     stringBuffer.append("    .y                    = ").append("0x").append(HexDump.toHex(getY())).append(" (").append(getY()).append(" )");
/*     */ 
/*     */     
/*  67 */     stringBuffer.append(System.getProperty("line.separator"));
/*  68 */     stringBuffer.append("    .topRow               = ").append("0x").append(HexDump.toHex(getTopRow())).append(" (").append(getTopRow()).append(" )");
/*     */ 
/*     */     
/*  71 */     stringBuffer.append(System.getProperty("line.separator"));
/*  72 */     stringBuffer.append("    .leftColumn           = ").append("0x").append(HexDump.toHex(getLeftColumn())).append(" (").append(getLeftColumn()).append(" )");
/*     */ 
/*     */     
/*  75 */     stringBuffer.append(System.getProperty("line.separator"));
/*  76 */     stringBuffer.append("    .activePane           = ").append("0x").append(HexDump.toHex(getActivePane())).append(" (").append(getActivePane()).append(" )");
/*     */ 
/*     */     
/*  79 */     stringBuffer.append(System.getProperty("line.separator"));
/*     */     
/*  81 */     stringBuffer.append("[/PANE]\n");
/*  82 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  87 */     paramLittleEndianOutput.writeShort(this.field_1_x);
/*  88 */     paramLittleEndianOutput.writeShort(this.field_2_y);
/*  89 */     paramLittleEndianOutput.writeShort(this.field_3_topRow);
/*  90 */     paramLittleEndianOutput.writeShort(this.field_4_leftColumn);
/*  91 */     paramLittleEndianOutput.writeShort(this.field_5_activePane);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getDataSize() {
/*  96 */     return 10;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 102 */     return 65;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object clone() {
/* 107 */     PaneRecord paneRecord = new PaneRecord();
/*     */     
/* 109 */     paneRecord.field_1_x = this.field_1_x;
/* 110 */     paneRecord.field_2_y = this.field_2_y;
/* 111 */     paneRecord.field_3_topRow = this.field_3_topRow;
/* 112 */     paneRecord.field_4_leftColumn = this.field_4_leftColumn;
/* 113 */     paneRecord.field_5_activePane = this.field_5_activePane;
/* 114 */     return paneRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getX() {
/* 124 */     return this.field_1_x;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setX(short paramShort) {
/* 134 */     this.field_1_x = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getY() {
/* 144 */     return this.field_2_y;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setY(short paramShort) {
/* 154 */     this.field_2_y = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getTopRow() {
/* 164 */     return this.field_3_topRow;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTopRow(short paramShort) {
/* 174 */     this.field_3_topRow = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getLeftColumn() {
/* 184 */     return this.field_4_leftColumn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLeftColumn(short paramShort) {
/* 194 */     this.field_4_leftColumn = paramShort;
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
/*     */   public short getActivePane() {
/* 208 */     return this.field_5_activePane;
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
/*     */   public void setActivePane(short paramShort) {
/* 223 */     this.field_5_activePane = paramShort;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\PaneRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */