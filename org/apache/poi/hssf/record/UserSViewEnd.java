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
/*    */ public final class UserSViewEnd
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 427;
/*    */   private byte[] _rawData;
/*    */   
/*    */   public UserSViewEnd(byte[] paramArrayOfbyte) {
/* 34 */     this._rawData = paramArrayOfbyte;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public UserSViewEnd(RecordInputStream paramRecordInputStream) {
/* 43 */     this._rawData = paramRecordInputStream.readRemainder();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 50 */     paramLittleEndianOutput.write(this._rawData);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 54 */     return this._rawData.length;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 59 */     return 427;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 65 */     stringBuffer.append("[").append("USERSVIEWEND").append("] (0x");
/* 66 */     stringBuffer.append(Integer.toHexString(427).toUpperCase(Locale.ROOT) + ")\n");
/* 67 */     stringBuffer.append("  rawData=").append(HexDump.toHex(this._rawData)).append("\n");
/* 68 */     stringBuffer.append("[/").append("USERSVIEWEND").append("]\n");
/* 69 */     return stringBuffer.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public Object clone() {
/* 74 */     return cloneViaReserialise();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\UserSViewEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */