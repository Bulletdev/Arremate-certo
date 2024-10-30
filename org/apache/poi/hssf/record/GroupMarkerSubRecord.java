/*    */ package org.apache.poi.hssf.record;
/*    */ 
/*    */ import org.apache.poi.util.HexDump;
/*    */ import org.apache.poi.util.LittleEndianInput;
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
/*    */ public final class GroupMarkerSubRecord
/*    */   extends SubRecord
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 6;
/* 31 */   private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
/*    */   
/*    */   private byte[] reserved;
/*    */ 
/*    */   
/*    */   public GroupMarkerSubRecord() {
/* 37 */     this.reserved = EMPTY_BYTE_ARRAY;
/*    */   }
/*    */   
/*    */   public GroupMarkerSubRecord(LittleEndianInput paramLittleEndianInput, int paramInt) {
/* 41 */     byte[] arrayOfByte = new byte[paramInt];
/* 42 */     paramLittleEndianInput.readFully(arrayOfByte);
/* 43 */     this.reserved = arrayOfByte;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 48 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 50 */     String str = System.getProperty("line.separator");
/* 51 */     stringBuffer.append("[ftGmo]" + str);
/* 52 */     stringBuffer.append("  reserved = ").append(HexDump.toHex(this.reserved)).append(str);
/* 53 */     stringBuffer.append("[/ftGmo]" + str);
/* 54 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 58 */     paramLittleEndianOutput.writeShort(6);
/* 59 */     paramLittleEndianOutput.writeShort(this.reserved.length);
/* 60 */     paramLittleEndianOutput.write(this.reserved);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 64 */     return this.reserved.length;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 69 */     return 6;
/*    */   }
/*    */ 
/*    */   
/*    */   public GroupMarkerSubRecord clone() {
/* 74 */     GroupMarkerSubRecord groupMarkerSubRecord = new GroupMarkerSubRecord();
/* 75 */     groupMarkerSubRecord.reserved = new byte[this.reserved.length];
/* 76 */     for (byte b = 0; b < this.reserved.length; b++)
/* 77 */       groupMarkerSubRecord.reserved[b] = this.reserved[b]; 
/* 78 */     return groupMarkerSubRecord;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\GroupMarkerSubRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */