/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Locale;
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
/*     */ public final class HeaderFooterRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*  33 */   private static final byte[] BLANK_GUID = new byte[16];
/*     */   
/*     */   public static final short sid = 2204;
/*     */   private byte[] _rawData;
/*     */   
/*     */   public HeaderFooterRecord(byte[] paramArrayOfbyte) {
/*  39 */     this._rawData = paramArrayOfbyte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HeaderFooterRecord(RecordInputStream paramRecordInputStream) {
/*  48 */     this._rawData = paramRecordInputStream.readRemainder();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  55 */     paramLittleEndianOutput.write(this._rawData);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  59 */     return this._rawData.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  64 */     return 2204;
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
/*     */   public byte[] getGuid() {
/*  76 */     byte[] arrayOfByte = new byte[16];
/*  77 */     System.arraycopy(this._rawData, 12, arrayOfByte, 0, arrayOfByte.length);
/*  78 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCurrentSheet() {
/*  85 */     return Arrays.equals(getGuid(), BLANK_GUID);
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  91 */     stringBuffer.append("[").append("HEADERFOOTER").append("] (0x");
/*  92 */     stringBuffer.append(Integer.toHexString(2204).toUpperCase(Locale.ROOT) + ")\n");
/*  93 */     stringBuffer.append("  rawData=").append(HexDump.toHex(this._rawData)).append("\n");
/*  94 */     stringBuffer.append("[/").append("HEADERFOOTER").append("]\n");
/*  95 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HeaderFooterRecord clone() {
/* 101 */     return (HeaderFooterRecord)cloneViaReserialise();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\HeaderFooterRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */