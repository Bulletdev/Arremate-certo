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
/*     */ public class EscherBlipRecord
/*     */   extends EscherRecord
/*     */ {
/*     */   public static final short RECORD_ID_START = -4072;
/*     */   public static final short RECORD_ID_END = -3817;
/*     */   public static final String RECORD_DESCRIPTION = "msofbtBlip";
/*     */   private static final int HEADER_SIZE = 8;
/*     */   protected byte[] field_pictureData;
/*     */   
/*     */   public int fillFields(byte[] paramArrayOfbyte, int paramInt, EscherRecordFactory paramEscherRecordFactory) {
/*  37 */     int i = readHeader(paramArrayOfbyte, paramInt);
/*  38 */     int j = paramInt + 8;
/*     */     
/*  40 */     this.field_pictureData = new byte[i];
/*  41 */     System.arraycopy(paramArrayOfbyte, j, this.field_pictureData, 0, i);
/*     */     
/*  43 */     return i + 8;
/*     */   }
/*     */ 
/*     */   
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte, EscherSerializationListener paramEscherSerializationListener) {
/*  48 */     paramEscherSerializationListener.beforeRecordSerialize(paramInt, getRecordId(), this);
/*     */     
/*  50 */     LittleEndian.putShort(paramArrayOfbyte, paramInt, getOptions());
/*  51 */     LittleEndian.putShort(paramArrayOfbyte, paramInt + 2, getRecordId());
/*     */     
/*  53 */     System.arraycopy(this.field_pictureData, 0, paramArrayOfbyte, paramInt + 4, this.field_pictureData.length);
/*     */     
/*  55 */     paramEscherSerializationListener.afterRecordSerialize(paramInt + 4 + this.field_pictureData.length, getRecordId(), this.field_pictureData.length + 4, this);
/*  56 */     return this.field_pictureData.length + 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRecordSize() {
/*  61 */     return this.field_pictureData.length + 8;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getRecordName() {
/*  66 */     return "Blip";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getPicturedata() {
/*  75 */     return this.field_pictureData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPictureData(byte[] paramArrayOfbyte) {
/*  84 */     if (paramArrayOfbyte == null) {
/*  85 */       throw new IllegalArgumentException("picture data can't be null");
/*     */     }
/*  87 */     this.field_pictureData = (byte[])paramArrayOfbyte.clone();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  92 */     String str = HexDump.toHex(this.field_pictureData, 32);
/*  93 */     return getClass().getName() + ":" + '\n' + "  RecordId: 0x" + HexDump.toHex(getRecordId()) + '\n' + "  Version: 0x" + HexDump.toHex(getVersion()) + '\n' + "  Instance: 0x" + HexDump.toHex(getInstance()) + '\n' + "  Extra Data:" + '\n' + str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toXml(String paramString) {
/* 102 */     String str = HexDump.toHex(this.field_pictureData, 32);
/* 103 */     StringBuilder stringBuilder = new StringBuilder();
/* 104 */     stringBuilder.append(paramString).append(formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance()))).append(paramString).append("\t").append("<ExtraData>").append(str).append("</ExtraData>\n");
/*     */     
/* 106 */     stringBuilder.append(paramString).append("</").append(getClass().getSimpleName()).append(">\n");
/* 107 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherBlipRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */