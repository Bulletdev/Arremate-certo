/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndianInput;
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
/*     */ public final class DrawingSelectionRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 237;
/*     */   private OfficeArtRecordHeader _header;
/*     */   private int _cpsp;
/*     */   private int _dgslk;
/*     */   private int _spidFocus;
/*     */   private int[] _shapeIds;
/*     */   
/*     */   private static final class OfficeArtRecordHeader
/*     */   {
/*     */     public static final int ENCODED_SIZE = 8;
/*     */     private final int _verAndInstance;
/*     */     private final int _type;
/*     */     private final int _length;
/*     */     
/*     */     public OfficeArtRecordHeader(LittleEndianInput param1LittleEndianInput) {
/*  48 */       this._verAndInstance = param1LittleEndianInput.readUShort();
/*  49 */       this._type = param1LittleEndianInput.readUShort();
/*  50 */       this._length = param1LittleEndianInput.readInt();
/*     */     }
/*     */     
/*     */     public void serialize(LittleEndianOutput param1LittleEndianOutput) {
/*  54 */       param1LittleEndianOutput.writeShort(this._verAndInstance);
/*  55 */       param1LittleEndianOutput.writeShort(this._type);
/*  56 */       param1LittleEndianOutput.writeInt(this._length);
/*     */     }
/*     */     
/*     */     public String debugFormatAsString() {
/*  60 */       StringBuffer stringBuffer = new StringBuffer(32);
/*  61 */       stringBuffer.append("ver+inst=").append(HexDump.shortToHex(this._verAndInstance));
/*  62 */       stringBuffer.append(" type=").append(HexDump.shortToHex(this._type));
/*  63 */       stringBuffer.append(" len=").append(HexDump.intToHex(this._length));
/*  64 */       return stringBuffer.toString();
/*     */     }
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
/*     */ 
/*     */   
/*     */   public DrawingSelectionRecord(RecordInputStream paramRecordInputStream) {
/*  79 */     this._header = new OfficeArtRecordHeader(paramRecordInputStream);
/*  80 */     this._cpsp = paramRecordInputStream.readInt();
/*  81 */     this._dgslk = paramRecordInputStream.readInt();
/*  82 */     this._spidFocus = paramRecordInputStream.readInt();
/*  83 */     int i = paramRecordInputStream.available() / 4;
/*  84 */     int[] arrayOfInt = new int[i];
/*  85 */     for (byte b = 0; b < i; b++) {
/*  86 */       arrayOfInt[b] = paramRecordInputStream.readInt();
/*     */     }
/*  88 */     this._shapeIds = arrayOfInt;
/*     */   }
/*     */   
/*     */   public short getSid() {
/*  92 */     return 237;
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  96 */     return 20 + this._shapeIds.length * 4;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 102 */     this._header.serialize(paramLittleEndianOutput);
/* 103 */     paramLittleEndianOutput.writeInt(this._cpsp);
/* 104 */     paramLittleEndianOutput.writeInt(this._dgslk);
/* 105 */     paramLittleEndianOutput.writeInt(this._spidFocus);
/* 106 */     for (byte b = 0; b < this._shapeIds.length; b++) {
/* 107 */       paramLittleEndianOutput.writeInt(this._shapeIds[b]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DrawingSelectionRecord clone() {
/* 114 */     return this;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 118 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 120 */     stringBuffer.append("[MSODRAWINGSELECTION]\n");
/* 121 */     stringBuffer.append("    .rh       =(").append(this._header.debugFormatAsString()).append(")\n");
/* 122 */     stringBuffer.append("    .cpsp     =").append(HexDump.intToHex(this._cpsp)).append('\n');
/* 123 */     stringBuffer.append("    .dgslk    =").append(HexDump.intToHex(this._dgslk)).append('\n');
/* 124 */     stringBuffer.append("    .spidFocus=").append(HexDump.intToHex(this._spidFocus)).append('\n');
/* 125 */     stringBuffer.append("    .shapeIds =(");
/* 126 */     for (byte b = 0; b < this._shapeIds.length; b++) {
/* 127 */       if (b > 0) {
/* 128 */         stringBuffer.append(", ");
/*     */       }
/* 130 */       stringBuffer.append(HexDump.intToHex(this._shapeIds[b]));
/*     */     } 
/* 132 */     stringBuffer.append(")\n");
/*     */     
/* 134 */     stringBuffer.append("[/MSODRAWINGSELECTION]\n");
/* 135 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\DrawingSelectionRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */