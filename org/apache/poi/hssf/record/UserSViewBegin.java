/*    */ package org.apache.poi.hssf.record;
/*    */ 
/*    */ import java.util.Locale;
/*    */ import org.apache.poi.util.HexDump;
/*    */ import org.apache.poi.util.LittleEndianOutput;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class UserSViewBegin
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 426;
/*    */   private byte[] _rawData;
/*    */   
/*    */   public UserSViewBegin(byte[] paramArrayOfbyte) {
/* 39 */     this._rawData = paramArrayOfbyte;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public UserSViewBegin(RecordInputStream paramRecordInputStream) {
/* 48 */     this._rawData = paramRecordInputStream.readRemainder();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 55 */     paramLittleEndianOutput.write(this._rawData);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 59 */     return this._rawData.length;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 64 */     return 426;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public byte[] getGuid() {
/* 71 */     byte[] arrayOfByte = new byte[16];
/* 72 */     System.arraycopy(this._rawData, 0, arrayOfByte, 0, arrayOfByte.length);
/* 73 */     return arrayOfByte;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 79 */     stringBuffer.append("[").append("USERSVIEWBEGIN").append("] (0x");
/* 80 */     stringBuffer.append(Integer.toHexString(426).toUpperCase(Locale.ROOT) + ")\n");
/* 81 */     stringBuffer.append("  rawData=").append(HexDump.toHex(this._rawData)).append("\n");
/* 82 */     stringBuffer.append("[/").append("USERSVIEWBEGIN").append("]\n");
/* 83 */     return stringBuffer.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public Object clone() {
/* 88 */     return cloneViaReserialise();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\UserSViewBegin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */