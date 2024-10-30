/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.util.IntList;
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
/*     */ public final class IndexRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 523;
/*     */   private int field_2_first_row;
/*     */   private int field_3_last_row_add1;
/*     */   private int field_4_zero;
/*     */   private IntList field_5_dbcells;
/*     */   
/*     */   public IndexRecord() {}
/*     */   
/*     */   public IndexRecord(RecordInputStream paramRecordInputStream) {
/*  43 */     int i = paramRecordInputStream.readInt();
/*  44 */     if (i != 0) {
/*  45 */       throw new RecordFormatException("Expected zero for field 1 but got " + i);
/*     */     }
/*  47 */     this.field_2_first_row = paramRecordInputStream.readInt();
/*  48 */     this.field_3_last_row_add1 = paramRecordInputStream.readInt();
/*  49 */     this.field_4_zero = paramRecordInputStream.readInt();
/*     */     
/*  51 */     int j = paramRecordInputStream.remaining() / 4;
/*  52 */     this.field_5_dbcells = new IntList(j);
/*  53 */     for (byte b = 0; b < j; b++) {
/*  54 */       this.field_5_dbcells.add(paramRecordInputStream.readInt());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFirstRow(int paramInt) {
/*  60 */     this.field_2_first_row = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLastRowAdd1(int paramInt) {
/*  65 */     this.field_3_last_row_add1 = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addDbcell(int paramInt) {
/*  70 */     if (this.field_5_dbcells == null)
/*     */     {
/*  72 */       this.field_5_dbcells = new IntList();
/*     */     }
/*  74 */     this.field_5_dbcells.add(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDbcell(int paramInt1, int paramInt2) {
/*  79 */     this.field_5_dbcells.set(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFirstRow() {
/*  84 */     return this.field_2_first_row;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLastRowAdd1() {
/*  89 */     return this.field_3_last_row_add1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumDbcells() {
/*  94 */     if (this.field_5_dbcells == null)
/*     */     {
/*  96 */       return 0;
/*     */     }
/*  98 */     return this.field_5_dbcells.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDbcellAt(int paramInt) {
/* 103 */     return this.field_5_dbcells.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 109 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 111 */     stringBuffer.append("[INDEX]\n");
/* 112 */     stringBuffer.append("    .firstrow       = ").append(Integer.toHexString(getFirstRow())).append("\n");
/*     */     
/* 114 */     stringBuffer.append("    .lastrowadd1    = ").append(Integer.toHexString(getLastRowAdd1())).append("\n");
/*     */     
/* 116 */     for (byte b = 0; b < getNumDbcells(); b++) {
/* 117 */       stringBuffer.append("    .dbcell_").append(b).append(" = ").append(Integer.toHexString(getDbcellAt(b))).append("\n");
/*     */     }
/*     */     
/* 120 */     stringBuffer.append("[/INDEX]\n");
/* 121 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 127 */     paramLittleEndianOutput.writeInt(0);
/* 128 */     paramLittleEndianOutput.writeInt(getFirstRow());
/* 129 */     paramLittleEndianOutput.writeInt(getLastRowAdd1());
/* 130 */     paramLittleEndianOutput.writeInt(this.field_4_zero);
/* 131 */     for (byte b = 0; b < getNumDbcells(); b++) {
/* 132 */       paramLittleEndianOutput.writeInt(getDbcellAt(b));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getDataSize() {
/* 138 */     return 16 + getNumDbcells() * 4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getRecordSizeForBlockCount(int paramInt) {
/* 147 */     return 20 + 4 * paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 152 */     return 523;
/*     */   }
/*     */ 
/*     */   
/*     */   public IndexRecord clone() {
/* 157 */     IndexRecord indexRecord = new IndexRecord();
/* 158 */     indexRecord.field_2_first_row = this.field_2_first_row;
/* 159 */     indexRecord.field_3_last_row_add1 = this.field_3_last_row_add1;
/* 160 */     indexRecord.field_4_zero = this.field_4_zero;
/* 161 */     indexRecord.field_5_dbcells = new IntList();
/* 162 */     indexRecord.field_5_dbcells.addAll(this.field_5_dbcells);
/* 163 */     return indexRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\IndexRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */