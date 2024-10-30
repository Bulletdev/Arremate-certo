/*    */ package org.apache.poi.hssf.record;
/*    */ 
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
/*    */ public final class TabIdRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 317;
/* 30 */   private static final short[] EMPTY_SHORT_ARRAY = new short[0];
/*    */   
/*    */   public short[] _tabids;
/*    */   
/*    */   public TabIdRecord() {
/* 35 */     this._tabids = EMPTY_SHORT_ARRAY;
/*    */   }
/*    */   
/*    */   public TabIdRecord(RecordInputStream paramRecordInputStream) {
/* 39 */     int i = paramRecordInputStream.remaining() / 2;
/* 40 */     this._tabids = new short[i];
/* 41 */     for (byte b = 0; b < this._tabids.length; b++) {
/* 42 */       this._tabids[b] = paramRecordInputStream.readShort();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setTabIdArray(short[] paramArrayOfshort) {
/* 51 */     this._tabids = (short[])paramArrayOfshort.clone();
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 57 */     stringBuffer.append("[TABID]\n");
/* 58 */     stringBuffer.append("    .elements        = ").append(this._tabids.length).append("\n");
/* 59 */     for (byte b = 0; b < this._tabids.length; b++) {
/* 60 */       stringBuffer.append("    .element_").append(b).append(" = ").append(this._tabids[b]).append("\n");
/*    */     }
/* 62 */     stringBuffer.append("[/TABID]\n");
/* 63 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 67 */     short[] arrayOfShort = this._tabids;
/*    */     
/* 69 */     for (byte b = 0; b < arrayOfShort.length; b++) {
/* 70 */       paramLittleEndianOutput.writeShort(arrayOfShort[b]);
/*    */     }
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 75 */     return this._tabids.length * 2;
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 79 */     return 317;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\TabIdRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */