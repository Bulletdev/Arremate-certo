/*     */ package org.apache.poi.ddf;
/*     */ 
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndian;
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
/*     */ public class EscherDgRecord
/*     */   extends EscherRecord
/*     */ {
/*     */   public static final short RECORD_ID = -4088;
/*     */   public static final String RECORD_DESCRIPTION = "MsofbtDg";
/*     */   private int field_1_numShapes;
/*     */   private int field_2_lastMSOSPID;
/*     */   
/*     */   public int fillFields(byte[] paramArrayOfbyte, int paramInt, EscherRecordFactory paramEscherRecordFactory) {
/*  39 */     readHeader(paramArrayOfbyte, paramInt);
/*  40 */     int i = paramInt + 8;
/*  41 */     byte b = 0;
/*  42 */     this.field_1_numShapes = LittleEndian.getInt(paramArrayOfbyte, i + b); b += 4;
/*  43 */     this.field_2_lastMSOSPID = LittleEndian.getInt(paramArrayOfbyte, i + b); b += 4;
/*     */ 
/*     */ 
/*     */     
/*  47 */     return getRecordSize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte, EscherSerializationListener paramEscherSerializationListener) {
/*  53 */     paramEscherSerializationListener.beforeRecordSerialize(paramInt, getRecordId(), this);
/*     */     
/*  55 */     LittleEndian.putShort(paramArrayOfbyte, paramInt, getOptions());
/*  56 */     LittleEndian.putShort(paramArrayOfbyte, paramInt + 2, getRecordId());
/*  57 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 4, 8);
/*  58 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 8, this.field_1_numShapes);
/*  59 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 12, this.field_2_lastMSOSPID);
/*     */ 
/*     */ 
/*     */     
/*  63 */     paramEscherSerializationListener.afterRecordSerialize(paramInt + 16, getRecordId(), getRecordSize(), this);
/*  64 */     return getRecordSize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRecordSize() {
/*  75 */     return 16;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getRecordId() {
/*  80 */     return -4088;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getRecordName() {
/*  85 */     return "Dg";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  93 */     return getClass().getName() + ":" + '\n' + "  RecordId: 0x" + HexDump.toHex((short)-4088) + '\n' + "  Version: 0x" + HexDump.toHex(getVersion()) + '\n' + "  Instance: 0x" + HexDump.toHex(getInstance()) + '\n' + "  NumShapes: " + this.field_1_numShapes + '\n' + "  LastMSOSPID: " + this.field_2_lastMSOSPID + '\n';
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toXml(String paramString) {
/* 103 */     StringBuilder stringBuilder = new StringBuilder();
/* 104 */     stringBuilder.append(paramString).append(formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance()))).append(paramString).append("\t").append("<NumShapes>").append(this.field_1_numShapes).append("</NumShapes>\n").append(paramString).append("\t").append("<LastMSOSPID>").append(this.field_2_lastMSOSPID).append("</LastMSOSPID>\n");
/*     */ 
/*     */     
/* 107 */     stringBuilder.append(paramString).append("</").append(getClass().getSimpleName()).append(">\n");
/* 108 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumShapes() {
/* 118 */     return this.field_1_numShapes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNumShapes(int paramInt) {
/* 128 */     this.field_1_numShapes = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLastMSOSPID() {
/* 138 */     return this.field_2_lastMSOSPID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastMSOSPID(int paramInt) {
/* 148 */     this.field_2_lastMSOSPID = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getDrawingGroupId() {
/* 159 */     return (short)(getOptions() >> 4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void incrementShapeCount() {
/* 167 */     this.field_1_numShapes++;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherDgRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */