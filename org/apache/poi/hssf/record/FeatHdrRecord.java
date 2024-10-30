/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.hssf.record.common.FtrHeader;
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
/*     */ public final class FeatHdrRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final int SHAREDFEATURES_ISFPROTECTION = 2;
/*     */   public static final int SHAREDFEATURES_ISFFEC2 = 3;
/*     */   public static final int SHAREDFEATURES_ISFFACTOID = 4;
/*     */   public static final int SHAREDFEATURES_ISFLIST = 5;
/*     */   public static final short sid = 2151;
/*     */   private FtrHeader futureHeader;
/*     */   private int isf_sharedFeatureType;
/*     */   private byte reserved;
/*     */   private long cbHdrData;
/*     */   private byte[] rgbHdrData;
/*     */   
/*     */   public FeatHdrRecord() {
/*  68 */     this.futureHeader = new FtrHeader();
/*  69 */     this.futureHeader.setRecordType((short)2151);
/*     */   }
/*     */   
/*     */   public short getSid() {
/*  73 */     return 2151;
/*     */   }
/*     */   
/*     */   public FeatHdrRecord(RecordInputStream paramRecordInputStream) {
/*  77 */     this.futureHeader = new FtrHeader(paramRecordInputStream);
/*     */     
/*  79 */     this.isf_sharedFeatureType = paramRecordInputStream.readShort();
/*  80 */     this.reserved = paramRecordInputStream.readByte();
/*  81 */     this.cbHdrData = paramRecordInputStream.readInt();
/*     */     
/*  83 */     this.rgbHdrData = paramRecordInputStream.readRemainder();
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuffer stringBuffer = new StringBuffer();
/*  88 */     stringBuffer.append("[FEATURE HEADER]\n");
/*     */ 
/*     */ 
/*     */     
/*  92 */     stringBuffer.append("[/FEATURE HEADER]\n");
/*  93 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  97 */     this.futureHeader.serialize(paramLittleEndianOutput);
/*     */     
/*  99 */     paramLittleEndianOutput.writeShort(this.isf_sharedFeatureType);
/* 100 */     paramLittleEndianOutput.writeByte(this.reserved);
/* 101 */     paramLittleEndianOutput.writeInt((int)this.cbHdrData);
/* 102 */     paramLittleEndianOutput.write(this.rgbHdrData);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 106 */     return 19 + this.rgbHdrData.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FeatHdrRecord clone() {
/* 112 */     return (FeatHdrRecord)cloneViaReserialise();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\FeatHdrRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */