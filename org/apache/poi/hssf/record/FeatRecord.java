/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.hssf.record.common.FeatFormulaErr2;
/*     */ import org.apache.poi.hssf.record.common.FeatProtection;
/*     */ import org.apache.poi.hssf.record.common.FeatSmartTag;
/*     */ import org.apache.poi.hssf.record.common.FtrHeader;
/*     */ import org.apache.poi.hssf.record.common.SharedFeature;
/*     */ import org.apache.poi.ss.util.CellRangeAddress;
/*     */ import org.apache.poi.util.LittleEndianOutput;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
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
/*     */ public final class FeatRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*  37 */   private static POILogger logger = POILogFactory.getLogger(FeatRecord.class);
/*     */ 
/*     */   
/*     */   public static final short sid = 2152;
/*     */ 
/*     */   
/*     */   public static final short v11_sid = 2162;
/*     */   
/*     */   public static final short v12_sid = 2168;
/*     */   
/*     */   private FtrHeader futureHeader;
/*     */   
/*     */   private int isf_sharedFeatureType;
/*     */   
/*     */   private byte reserved1;
/*     */   
/*     */   private long reserved2;
/*     */   
/*     */   private long cbFeatData;
/*     */   
/*     */   private int reserved3;
/*     */   
/*     */   private CellRangeAddress[] cellRefs;
/*     */   
/*     */   private SharedFeature sharedFeature;
/*     */ 
/*     */   
/*     */   public FeatRecord() {
/*  65 */     this.futureHeader = new FtrHeader();
/*  66 */     this.futureHeader.setRecordType((short)2152);
/*     */   }
/*     */   
/*     */   public short getSid() {
/*  70 */     return 2152;
/*     */   }
/*     */   
/*     */   public FeatRecord(RecordInputStream paramRecordInputStream) {
/*  74 */     this.futureHeader = new FtrHeader(paramRecordInputStream);
/*     */     
/*  76 */     this.isf_sharedFeatureType = paramRecordInputStream.readShort();
/*  77 */     this.reserved1 = paramRecordInputStream.readByte();
/*  78 */     this.reserved2 = paramRecordInputStream.readInt();
/*  79 */     int i = paramRecordInputStream.readUShort();
/*  80 */     this.cbFeatData = paramRecordInputStream.readInt();
/*  81 */     this.reserved3 = paramRecordInputStream.readShort();
/*     */     
/*  83 */     this.cellRefs = new CellRangeAddress[i];
/*  84 */     for (byte b = 0; b < this.cellRefs.length; b++) {
/*  85 */       this.cellRefs[b] = new CellRangeAddress(paramRecordInputStream);
/*     */     }
/*     */     
/*  88 */     switch (this.isf_sharedFeatureType) {
/*     */       case 2:
/*  90 */         this.sharedFeature = (SharedFeature)new FeatProtection(paramRecordInputStream);
/*     */         return;
/*     */       case 3:
/*  93 */         this.sharedFeature = (SharedFeature)new FeatFormulaErr2(paramRecordInputStream);
/*     */         return;
/*     */       case 4:
/*  96 */         this.sharedFeature = (SharedFeature)new FeatSmartTag(paramRecordInputStream);
/*     */         return;
/*     */     } 
/*  99 */     logger.log(7, new Object[] { "Unknown Shared Feature " + this.isf_sharedFeatureType + " found!" });
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuffer stringBuffer = new StringBuffer();
/* 105 */     stringBuffer.append("[SHARED FEATURE]\n");
/*     */ 
/*     */ 
/*     */     
/* 109 */     stringBuffer.append("[/SHARED FEATURE]\n");
/* 110 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 114 */     this.futureHeader.serialize(paramLittleEndianOutput);
/*     */     
/* 116 */     paramLittleEndianOutput.writeShort(this.isf_sharedFeatureType);
/* 117 */     paramLittleEndianOutput.writeByte(this.reserved1);
/* 118 */     paramLittleEndianOutput.writeInt((int)this.reserved2);
/* 119 */     paramLittleEndianOutput.writeShort(this.cellRefs.length);
/* 120 */     paramLittleEndianOutput.writeInt((int)this.cbFeatData);
/* 121 */     paramLittleEndianOutput.writeShort(this.reserved3);
/*     */     
/* 123 */     for (byte b = 0; b < this.cellRefs.length; b++) {
/* 124 */       this.cellRefs[b].serialize(paramLittleEndianOutput);
/*     */     }
/*     */     
/* 127 */     this.sharedFeature.serialize(paramLittleEndianOutput);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 131 */     return 27 + this.cellRefs.length * 8 + this.sharedFeature.getDataSize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getIsf_sharedFeatureType() {
/* 137 */     return this.isf_sharedFeatureType;
/*     */   }
/*     */   
/*     */   public long getCbFeatData() {
/* 141 */     return this.cbFeatData;
/*     */   }
/*     */   public void setCbFeatData(long paramLong) {
/* 144 */     this.cbFeatData = paramLong;
/*     */   }
/*     */   
/*     */   public CellRangeAddress[] getCellRefs() {
/* 148 */     return this.cellRefs;
/*     */   }
/*     */   public void setCellRefs(CellRangeAddress[] paramArrayOfCellRangeAddress) {
/* 151 */     this.cellRefs = paramArrayOfCellRangeAddress;
/*     */   }
/*     */   
/*     */   public SharedFeature getSharedFeature() {
/* 155 */     return this.sharedFeature;
/*     */   }
/*     */   public void setSharedFeature(SharedFeature paramSharedFeature) {
/* 158 */     this.sharedFeature = paramSharedFeature;
/*     */     
/* 160 */     if (paramSharedFeature instanceof FeatProtection) {
/* 161 */       this.isf_sharedFeatureType = 2;
/*     */     }
/* 163 */     if (paramSharedFeature instanceof FeatFormulaErr2) {
/* 164 */       this.isf_sharedFeatureType = 3;
/*     */     }
/* 166 */     if (paramSharedFeature instanceof FeatSmartTag) {
/* 167 */       this.isf_sharedFeatureType = 4;
/*     */     }
/*     */     
/* 170 */     if (this.isf_sharedFeatureType == 3) {
/* 171 */       this.cbFeatData = this.sharedFeature.getDataSize();
/*     */     } else {
/* 173 */       this.cbFeatData = 0L;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FeatRecord clone() {
/* 181 */     return (FeatRecord)cloneViaReserialise();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\FeatRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */