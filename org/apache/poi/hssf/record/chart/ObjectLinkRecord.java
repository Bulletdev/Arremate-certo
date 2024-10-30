/*     */ package org.apache.poi.hssf.record.chart;
/*     */ 
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.hssf.record.StandardRecord;
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
/*     */ public final class ObjectLinkRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 4135;
/*     */   private short field_1_anchorId;
/*     */   public static final short ANCHOR_ID_CHART_TITLE = 1;
/*     */   public static final short ANCHOR_ID_Y_AXIS = 2;
/*     */   public static final short ANCHOR_ID_X_AXIS = 3;
/*     */   public static final short ANCHOR_ID_SERIES_OR_POINT = 4;
/*     */   public static final short ANCHOR_ID_Z_AXIS = 7;
/*     */   private short field_2_link1;
/*     */   private short field_3_link2;
/*     */   
/*     */   public ObjectLinkRecord() {}
/*     */   
/*     */   public ObjectLinkRecord(RecordInputStream paramRecordInputStream) {
/*  47 */     this.field_1_anchorId = paramRecordInputStream.readShort();
/*  48 */     this.field_2_link1 = paramRecordInputStream.readShort();
/*  49 */     this.field_3_link2 = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  55 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  57 */     stringBuffer.append("[OBJECTLINK]\n");
/*  58 */     stringBuffer.append("    .anchorId             = ").append("0x").append(HexDump.toHex(getAnchorId())).append(" (").append(getAnchorId()).append(" )");
/*     */ 
/*     */     
/*  61 */     stringBuffer.append(System.getProperty("line.separator"));
/*  62 */     stringBuffer.append("    .link1                = ").append("0x").append(HexDump.toHex(getLink1())).append(" (").append(getLink1()).append(" )");
/*     */ 
/*     */     
/*  65 */     stringBuffer.append(System.getProperty("line.separator"));
/*  66 */     stringBuffer.append("    .link2                = ").append("0x").append(HexDump.toHex(getLink2())).append(" (").append(getLink2()).append(" )");
/*     */ 
/*     */     
/*  69 */     stringBuffer.append(System.getProperty("line.separator"));
/*     */     
/*  71 */     stringBuffer.append("[/OBJECTLINK]\n");
/*  72 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  76 */     paramLittleEndianOutput.writeShort(this.field_1_anchorId);
/*  77 */     paramLittleEndianOutput.writeShort(this.field_2_link1);
/*  78 */     paramLittleEndianOutput.writeShort(this.field_3_link2);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  82 */     return 6;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  87 */     return 4135;
/*     */   }
/*     */ 
/*     */   
/*     */   public ObjectLinkRecord clone() {
/*  92 */     ObjectLinkRecord objectLinkRecord = new ObjectLinkRecord();
/*     */     
/*  94 */     objectLinkRecord.field_1_anchorId = this.field_1_anchorId;
/*  95 */     objectLinkRecord.field_2_link1 = this.field_2_link1;
/*  96 */     objectLinkRecord.field_3_link2 = this.field_3_link2;
/*  97 */     return objectLinkRecord;
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
/*     */ 
/*     */   
/*     */   public short getAnchorId() {
/* 115 */     return this.field_1_anchorId;
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
/*     */   public void setAnchorId(short paramShort) {
/* 131 */     this.field_1_anchorId = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getLink1() {
/* 139 */     return this.field_2_link1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLink1(short paramShort) {
/* 147 */     this.field_2_link1 = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getLink2() {
/* 155 */     return this.field_3_link2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLink2(short paramShort) {
/* 163 */     this.field_3_link2 = paramShort;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\ObjectLinkRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */