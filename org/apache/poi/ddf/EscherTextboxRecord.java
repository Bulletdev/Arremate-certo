/*     */ package org.apache.poi.ddf;
/*     */ 
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ import org.apache.poi.util.RecordFormatException;
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
/*     */ public final class EscherTextboxRecord
/*     */   extends EscherRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short RECORD_ID = -4083;
/*     */   public static final String RECORD_DESCRIPTION = "msofbtClientTextbox";
/*  34 */   private static final byte[] NO_BYTES = new byte[0];
/*     */ 
/*     */   
/*  37 */   private byte[] thedata = NO_BYTES;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int fillFields(byte[] paramArrayOfbyte, int paramInt, EscherRecordFactory paramEscherRecordFactory) {
/*  45 */     int i = readHeader(paramArrayOfbyte, paramInt);
/*     */ 
/*     */ 
/*     */     
/*  49 */     this.thedata = new byte[i];
/*  50 */     System.arraycopy(paramArrayOfbyte, paramInt + 8, this.thedata, 0, i);
/*  51 */     return i + 8;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte, EscherSerializationListener paramEscherSerializationListener) {
/*  57 */     paramEscherSerializationListener.beforeRecordSerialize(paramInt, getRecordId(), this);
/*     */     
/*  59 */     LittleEndian.putShort(paramArrayOfbyte, paramInt, getOptions());
/*  60 */     LittleEndian.putShort(paramArrayOfbyte, paramInt + 2, getRecordId());
/*  61 */     int i = this.thedata.length;
/*  62 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 4, i);
/*  63 */     System.arraycopy(this.thedata, 0, paramArrayOfbyte, paramInt + 8, this.thedata.length);
/*  64 */     int j = paramInt + 8 + this.thedata.length;
/*     */     
/*  66 */     paramEscherSerializationListener.afterRecordSerialize(j, getRecordId(), j - paramInt, this);
/*  67 */     int k = j - paramInt;
/*  68 */     if (k != getRecordSize())
/*  69 */       throw new RecordFormatException(k + " bytes written but getRecordSize() reports " + getRecordSize()); 
/*  70 */     return k;
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
/*     */   public byte[] getData() {
/*  83 */     return this.thedata;
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
/*     */   public void setData(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  97 */     this.thedata = new byte[paramInt2];
/*  98 */     System.arraycopy(paramArrayOfbyte, paramInt1, this.thedata, 0, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setData(byte[] paramArrayOfbyte) {
/* 109 */     setData(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRecordSize() {
/* 115 */     return 8 + this.thedata.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public EscherTextboxRecord clone() {
/* 120 */     EscherTextboxRecord escherTextboxRecord = new EscherTextboxRecord();
/* 121 */     escherTextboxRecord.setOptions(getOptions());
/* 122 */     escherTextboxRecord.setRecordId(getRecordId());
/* 123 */     escherTextboxRecord.thedata = (byte[])this.thedata.clone();
/* 124 */     return escherTextboxRecord;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getRecordName() {
/* 129 */     return "ClientTextbox";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     String str1 = System.getProperty("line.separator");
/*     */     
/* 137 */     String str2 = "";
/*     */     
/*     */     try {
/* 140 */       if (this.thedata.length != 0)
/*     */       {
/* 142 */         str2 = "  Extra Data:" + str1;
/* 143 */         str2 = str2 + HexDump.dump(this.thedata, 0L, 0);
/*     */       }
/*     */     
/* 146 */     } catch (Exception exception) {
/*     */       
/* 148 */       str2 = "Error!!";
/*     */     } 
/*     */     
/* 151 */     return getClass().getName() + ":" + str1 + "  isContainer: " + isContainerRecord() + str1 + "  version: 0x" + HexDump.toHex(getVersion()) + str1 + "  instance: 0x" + HexDump.toHex(getInstance()) + str1 + "  recordId: 0x" + HexDump.toHex(getRecordId()) + str1 + "  numchildren: " + getChildRecords().size() + str1 + str2;
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
/* 162 */     String str = "";
/*     */     
/*     */     try {
/* 165 */       if (this.thedata.length != 0)
/*     */       {
/* 167 */         str = str + HexDump.dump(this.thedata, 0L, 0);
/*     */       }
/*     */     }
/* 170 */     catch (Exception exception) {
/*     */       
/* 172 */       str = "Error!!";
/*     */     } 
/* 174 */     StringBuilder stringBuilder = new StringBuilder();
/* 175 */     stringBuilder.append(paramString).append(formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance()))).append(paramString).append("\t").append("<ExtraData>").append(str).append("</ExtraData>\n");
/*     */     
/* 177 */     stringBuilder.append(paramString).append("</").append(getClass().getSimpleName()).append(">\n");
/* 178 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherTextboxRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */