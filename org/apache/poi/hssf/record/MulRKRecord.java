/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.hssf.util.RKUtil;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class MulRKRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 189;
/*     */   private final int field_1_row;
/*     */   private final short field_2_first_col;
/*     */   private final RkRec[] field_3_rks;
/*     */   private final short field_4_last_col;
/*     */   
/*     */   public int getRow() {
/*  42 */     return this.field_1_row;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFirstColumn() {
/*  50 */     return this.field_2_first_col;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getLastColumn() {
/*  58 */     return this.field_4_last_col;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumColumns() {
/*  66 */     return this.field_4_last_col - this.field_2_first_col + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getXFAt(int paramInt) {
/*  77 */     return (this.field_3_rks[paramInt]).xf;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getRKNumberAt(int paramInt) {
/*  88 */     return RKUtil.decodeNumber((this.field_3_rks[paramInt]).rk);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MulRKRecord(RecordInputStream paramRecordInputStream) {
/*  95 */     this.field_1_row = paramRecordInputStream.readUShort();
/*  96 */     this.field_2_first_col = paramRecordInputStream.readShort();
/*  97 */     this.field_3_rks = RkRec.parseRKs(paramRecordInputStream);
/*  98 */     this.field_4_last_col = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 106 */     stringBuffer.append("[MULRK]\n");
/* 107 */     stringBuffer.append("\t.row\t = ").append(HexDump.shortToHex(getRow())).append("\n");
/* 108 */     stringBuffer.append("\t.firstcol= ").append(HexDump.shortToHex(getFirstColumn())).append("\n");
/* 109 */     stringBuffer.append("\t.lastcol = ").append(HexDump.shortToHex(getLastColumn())).append("\n");
/*     */     
/* 111 */     for (byte b = 0; b < getNumColumns(); b++) {
/* 112 */       stringBuffer.append("\txf[").append(b).append("] = ").append(HexDump.shortToHex(getXFAt(b))).append("\n");
/* 113 */       stringBuffer.append("\trk[").append(b).append("] = ").append(getRKNumberAt(b)).append("\n");
/*     */     } 
/* 115 */     stringBuffer.append("[/MULRK]\n");
/* 116 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 122 */     return 189;
/*     */   }
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 127 */     throw new RecordFormatException("Sorry, you can't serialize MulRK in this release");
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 131 */     throw new RecordFormatException("Sorry, you can't serialize MulRK in this release");
/*     */   }
/*     */   
/*     */   private static final class RkRec {
/*     */     public static final int ENCODED_SIZE = 6;
/*     */     public final short xf;
/*     */     public final int rk;
/*     */     
/*     */     private RkRec(RecordInputStream param1RecordInputStream) {
/* 140 */       this.xf = param1RecordInputStream.readShort();
/* 141 */       this.rk = param1RecordInputStream.readInt();
/*     */     }
/*     */     
/*     */     public static RkRec[] parseRKs(RecordInputStream param1RecordInputStream) {
/* 145 */       int i = (param1RecordInputStream.remaining() - 2) / 6;
/* 146 */       RkRec[] arrayOfRkRec = new RkRec[i];
/* 147 */       for (byte b = 0; b < i; b++) {
/* 148 */         arrayOfRkRec[b] = new RkRec(param1RecordInputStream);
/*     */       }
/* 150 */       return arrayOfRkRec;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\MulRKRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */