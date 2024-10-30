/*     */ package org.apache.poi.hssf.record.pivottable;
/*     */ 
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.hssf.record.StandardRecord;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndianInput;
/*     */ import org.apache.poi.util.LittleEndianOutput;
/*     */ import org.apache.poi.util.StringUtil;
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
/*     */ public final class ViewDefinitionRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 176;
/*     */   private int rwFirst;
/*     */   private int rwLast;
/*     */   private int colFirst;
/*     */   private int colLast;
/*     */   private int rwFirstHead;
/*     */   private int rwFirstData;
/*     */   private int colFirstData;
/*     */   private int iCache;
/*     */   private int reserved;
/*     */   private int sxaxis4Data;
/*     */   private int ipos4Data;
/*     */   private int cDim;
/*     */   private int cDimRw;
/*     */   private int cDimCol;
/*     */   private int cDimPg;
/*     */   private int cDimData;
/*     */   private int cRw;
/*     */   private int cCol;
/*     */   private int grbit;
/*     */   private int itblAutoFmt;
/*     */   private String dataField;
/*     */   private String name;
/*     */   
/*     */   public ViewDefinitionRecord(RecordInputStream paramRecordInputStream) {
/*  62 */     this.rwFirst = paramRecordInputStream.readUShort();
/*  63 */     this.rwLast = paramRecordInputStream.readUShort();
/*  64 */     this.colFirst = paramRecordInputStream.readUShort();
/*  65 */     this.colLast = paramRecordInputStream.readUShort();
/*  66 */     this.rwFirstHead = paramRecordInputStream.readUShort();
/*  67 */     this.rwFirstData = paramRecordInputStream.readUShort();
/*  68 */     this.colFirstData = paramRecordInputStream.readUShort();
/*  69 */     this.iCache = paramRecordInputStream.readUShort();
/*  70 */     this.reserved = paramRecordInputStream.readUShort();
/*  71 */     this.sxaxis4Data = paramRecordInputStream.readUShort();
/*  72 */     this.ipos4Data = paramRecordInputStream.readUShort();
/*  73 */     this.cDim = paramRecordInputStream.readUShort();
/*  74 */     this.cDimRw = paramRecordInputStream.readUShort();
/*  75 */     this.cDimCol = paramRecordInputStream.readUShort();
/*  76 */     this.cDimPg = paramRecordInputStream.readUShort();
/*  77 */     this.cDimData = paramRecordInputStream.readUShort();
/*  78 */     this.cRw = paramRecordInputStream.readUShort();
/*  79 */     this.cCol = paramRecordInputStream.readUShort();
/*  80 */     this.grbit = paramRecordInputStream.readUShort();
/*  81 */     this.itblAutoFmt = paramRecordInputStream.readUShort();
/*  82 */     int i = paramRecordInputStream.readUShort();
/*  83 */     int j = paramRecordInputStream.readUShort();
/*     */     
/*  85 */     this.name = StringUtil.readUnicodeString((LittleEndianInput)paramRecordInputStream, i);
/*  86 */     this.dataField = StringUtil.readUnicodeString((LittleEndianInput)paramRecordInputStream, j);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  91 */     paramLittleEndianOutput.writeShort(this.rwFirst);
/*  92 */     paramLittleEndianOutput.writeShort(this.rwLast);
/*  93 */     paramLittleEndianOutput.writeShort(this.colFirst);
/*  94 */     paramLittleEndianOutput.writeShort(this.colLast);
/*  95 */     paramLittleEndianOutput.writeShort(this.rwFirstHead);
/*  96 */     paramLittleEndianOutput.writeShort(this.rwFirstData);
/*  97 */     paramLittleEndianOutput.writeShort(this.colFirstData);
/*  98 */     paramLittleEndianOutput.writeShort(this.iCache);
/*  99 */     paramLittleEndianOutput.writeShort(this.reserved);
/* 100 */     paramLittleEndianOutput.writeShort(this.sxaxis4Data);
/* 101 */     paramLittleEndianOutput.writeShort(this.ipos4Data);
/* 102 */     paramLittleEndianOutput.writeShort(this.cDim);
/* 103 */     paramLittleEndianOutput.writeShort(this.cDimRw);
/* 104 */     paramLittleEndianOutput.writeShort(this.cDimCol);
/* 105 */     paramLittleEndianOutput.writeShort(this.cDimPg);
/* 106 */     paramLittleEndianOutput.writeShort(this.cDimData);
/* 107 */     paramLittleEndianOutput.writeShort(this.cRw);
/* 108 */     paramLittleEndianOutput.writeShort(this.cCol);
/* 109 */     paramLittleEndianOutput.writeShort(this.grbit);
/* 110 */     paramLittleEndianOutput.writeShort(this.itblAutoFmt);
/* 111 */     paramLittleEndianOutput.writeShort(this.name.length());
/* 112 */     paramLittleEndianOutput.writeShort(this.dataField.length());
/*     */     
/* 114 */     StringUtil.writeUnicodeStringFlagAndData(paramLittleEndianOutput, this.name);
/* 115 */     StringUtil.writeUnicodeStringFlagAndData(paramLittleEndianOutput, this.dataField);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getDataSize() {
/* 120 */     return 40 + StringUtil.getEncodedSize(this.name) + StringUtil.getEncodedSize(this.dataField);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 126 */     return 176;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 131 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 133 */     stringBuffer.append("[SXVIEW]\n");
/* 134 */     stringBuffer.append("    .rwFirst      =").append(HexDump.shortToHex(this.rwFirst)).append('\n');
/* 135 */     stringBuffer.append("    .rwLast       =").append(HexDump.shortToHex(this.rwLast)).append('\n');
/* 136 */     stringBuffer.append("    .colFirst     =").append(HexDump.shortToHex(this.colFirst)).append('\n');
/* 137 */     stringBuffer.append("    .colLast      =").append(HexDump.shortToHex(this.colLast)).append('\n');
/* 138 */     stringBuffer.append("    .rwFirstHead  =").append(HexDump.shortToHex(this.rwFirstHead)).append('\n');
/* 139 */     stringBuffer.append("    .rwFirstData  =").append(HexDump.shortToHex(this.rwFirstData)).append('\n');
/* 140 */     stringBuffer.append("    .colFirstData =").append(HexDump.shortToHex(this.colFirstData)).append('\n');
/* 141 */     stringBuffer.append("    .iCache       =").append(HexDump.shortToHex(this.iCache)).append('\n');
/* 142 */     stringBuffer.append("    .reserved     =").append(HexDump.shortToHex(this.reserved)).append('\n');
/* 143 */     stringBuffer.append("    .sxaxis4Data  =").append(HexDump.shortToHex(this.sxaxis4Data)).append('\n');
/* 144 */     stringBuffer.append("    .ipos4Data    =").append(HexDump.shortToHex(this.ipos4Data)).append('\n');
/* 145 */     stringBuffer.append("    .cDim         =").append(HexDump.shortToHex(this.cDim)).append('\n');
/* 146 */     stringBuffer.append("    .cDimRw       =").append(HexDump.shortToHex(this.cDimRw)).append('\n');
/* 147 */     stringBuffer.append("    .cDimCol      =").append(HexDump.shortToHex(this.cDimCol)).append('\n');
/* 148 */     stringBuffer.append("    .cDimPg       =").append(HexDump.shortToHex(this.cDimPg)).append('\n');
/* 149 */     stringBuffer.append("    .cDimData     =").append(HexDump.shortToHex(this.cDimData)).append('\n');
/* 150 */     stringBuffer.append("    .cRw          =").append(HexDump.shortToHex(this.cRw)).append('\n');
/* 151 */     stringBuffer.append("    .cCol         =").append(HexDump.shortToHex(this.cCol)).append('\n');
/* 152 */     stringBuffer.append("    .grbit        =").append(HexDump.shortToHex(this.grbit)).append('\n');
/* 153 */     stringBuffer.append("    .itblAutoFmt  =").append(HexDump.shortToHex(this.itblAutoFmt)).append('\n');
/* 154 */     stringBuffer.append("    .name         =").append(this.name).append('\n');
/* 155 */     stringBuffer.append("    .dataField    =").append(this.dataField).append('\n');
/*     */     
/* 157 */     stringBuffer.append("[/SXVIEW]\n");
/* 158 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\pivottable\ViewDefinitionRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */