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
/*     */ public class EscherClientDataRecord
/*     */   extends EscherRecord
/*     */ {
/*     */   public static final short RECORD_ID = -4079;
/*     */   public static final String RECORD_DESCRIPTION = "MsofbtClientData";
/*     */   private byte[] remainingData;
/*     */   
/*     */   public int fillFields(byte[] paramArrayOfbyte, int paramInt, EscherRecordFactory paramEscherRecordFactory) {
/*  38 */     int i = readHeader(paramArrayOfbyte, paramInt);
/*  39 */     int j = paramInt + 8;
/*  40 */     this.remainingData = new byte[i];
/*  41 */     System.arraycopy(paramArrayOfbyte, j, this.remainingData, 0, i);
/*  42 */     return 8 + i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte, EscherSerializationListener paramEscherSerializationListener) {
/*  47 */     paramEscherSerializationListener.beforeRecordSerialize(paramInt, getRecordId(), this);
/*     */     
/*  49 */     if (this.remainingData == null) this.remainingData = new byte[0]; 
/*  50 */     LittleEndian.putShort(paramArrayOfbyte, paramInt, getOptions());
/*  51 */     LittleEndian.putShort(paramArrayOfbyte, paramInt + 2, getRecordId());
/*  52 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 4, this.remainingData.length);
/*  53 */     System.arraycopy(this.remainingData, 0, paramArrayOfbyte, paramInt + 8, this.remainingData.length);
/*  54 */     int i = paramInt + 8 + this.remainingData.length;
/*     */     
/*  56 */     paramEscherSerializationListener.afterRecordSerialize(i, getRecordId(), i - paramInt, this);
/*  57 */     return i - paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRecordSize() {
/*  63 */     return 8 + ((this.remainingData == null) ? 0 : this.remainingData.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public short getRecordId() {
/*  68 */     return -4079;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getRecordName() {
/*  73 */     return "ClientData";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  82 */     String str1 = System.getProperty("line.separator");
/*  83 */     String str2 = HexDump.dump(getRemainingData(), 0L, 0);
/*  84 */     return getClass().getName() + ":" + str1 + "  RecordId: 0x" + HexDump.toHex((short)-4079) + str1 + "  Version: 0x" + HexDump.toHex(getVersion()) + str1 + "  Instance: 0x" + HexDump.toHex(getInstance()) + str1 + "  Extra Data:" + str1 + str2;
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
/*  95 */     String str = HexDump.dump(getRemainingData(), 0L, 0).trim();
/*  96 */     StringBuilder stringBuilder = new StringBuilder();
/*  97 */     stringBuilder.append(paramString).append(formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance()))).append(paramString).append("\t").append("<ExtraData>").append(str).append("</ExtraData>\n");
/*     */ 
/*     */     
/* 100 */     stringBuilder.append(paramString).append("</").append(getClass().getSimpleName()).append(">\n");
/* 101 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getRemainingData() {
/* 111 */     return this.remainingData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRemainingData(byte[] paramArrayOfbyte) {
/* 120 */     this.remainingData = (paramArrayOfbyte == null) ? new byte[0] : (byte[])paramArrayOfbyte.clone();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherClientDataRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */