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
/*     */ public class EscherBitmapBlip
/*     */   extends EscherBlipRecord
/*     */ {
/*     */   public static final short RECORD_ID_JPEG = -4067;
/*     */   public static final short RECORD_ID_PNG = -4066;
/*     */   public static final short RECORD_ID_DIB = -4065;
/*     */   private static final int HEADER_SIZE = 8;
/*  30 */   private final byte[] field_1_UID = new byte[16];
/*  31 */   private byte field_2_marker = -1;
/*     */ 
/*     */   
/*     */   public int fillFields(byte[] paramArrayOfbyte, int paramInt, EscherRecordFactory paramEscherRecordFactory) {
/*  35 */     int i = readHeader(paramArrayOfbyte, paramInt);
/*  36 */     int j = paramInt + 8;
/*     */     
/*  38 */     System.arraycopy(paramArrayOfbyte, j, this.field_1_UID, 0, 16); j += 16;
/*  39 */     this.field_2_marker = paramArrayOfbyte[j]; j++;
/*     */     
/*  41 */     this.field_pictureData = new byte[i - 17];
/*  42 */     System.arraycopy(paramArrayOfbyte, j, this.field_pictureData, 0, this.field_pictureData.length);
/*     */     
/*  44 */     return i + 8;
/*     */   }
/*     */ 
/*     */   
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte, EscherSerializationListener paramEscherSerializationListener) {
/*  49 */     paramEscherSerializationListener.beforeRecordSerialize(paramInt, getRecordId(), this);
/*     */     
/*  51 */     LittleEndian.putShort(paramArrayOfbyte, paramInt, getOptions());
/*  52 */     LittleEndian.putShort(paramArrayOfbyte, paramInt + 2, getRecordId());
/*  53 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 4, getRecordSize() - 8);
/*  54 */     int i = paramInt + 8;
/*     */     
/*  56 */     System.arraycopy(this.field_1_UID, 0, paramArrayOfbyte, i, 16);
/*  57 */     paramArrayOfbyte[i + 16] = this.field_2_marker;
/*  58 */     System.arraycopy(this.field_pictureData, 0, paramArrayOfbyte, i + 17, this.field_pictureData.length);
/*     */     
/*  60 */     paramEscherSerializationListener.afterRecordSerialize(paramInt + getRecordSize(), getRecordId(), getRecordSize(), this);
/*  61 */     return 25 + this.field_pictureData.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRecordSize() {
/*  66 */     return 25 + this.field_pictureData.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getUID() {
/*  76 */     return this.field_1_UID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUID(byte[] paramArrayOfbyte) {
/*  86 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length != 16) {
/*  87 */       throw new IllegalArgumentException("field_1_UID must be byte[16]");
/*     */     }
/*  89 */     System.arraycopy(paramArrayOfbyte, 0, this.field_1_UID, 0, 16);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getMarker() {
/*  99 */     return this.field_2_marker;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMarker(byte paramByte) {
/* 109 */     this.field_2_marker = paramByte;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     String str1 = System.getProperty("line.separator");
/*     */     
/* 116 */     String str2 = HexDump.dump(this.field_pictureData, 0L, 0);
/*     */     
/* 118 */     return getClass().getName() + ":" + str1 + "  RecordId: 0x" + HexDump.toHex(getRecordId()) + str1 + "  Version: 0x" + HexDump.toHex(getVersion()) + str1 + "  Instance: 0x" + HexDump.toHex(getInstance()) + str1 + "  UID: 0x" + HexDump.toHex(this.field_1_UID) + str1 + "  Marker: 0x" + HexDump.toHex(this.field_2_marker) + str1 + "  Extra Data:" + str1 + str2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toXml(String paramString) {
/* 129 */     String str = HexDump.dump(this.field_pictureData, 0L, 0);
/* 130 */     StringBuilder stringBuilder = new StringBuilder();
/* 131 */     stringBuilder.append(paramString).append(formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance()))).append(paramString).append("\t").append("<UID>0x").append(HexDump.toHex(this.field_1_UID)).append("</UID>\n").append(paramString).append("\t").append("<Marker>0x").append(HexDump.toHex(this.field_2_marker)).append("</Marker>\n").append(paramString).append("\t").append("<ExtraData>").append(str).append("</ExtraData>\n");
/*     */ 
/*     */ 
/*     */     
/* 135 */     stringBuilder.append(paramString).append("</").append(getClass().getSimpleName()).append(">\n");
/* 136 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherBitmapBlip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */