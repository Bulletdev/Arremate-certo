/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndianInput;
/*     */ import org.apache.poi.util.LittleEndianOutput;
/*     */ import org.apache.poi.util.LittleEndianOutputStream;
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
/*     */ public abstract class SubRecord
/*     */ {
/*     */   public static SubRecord createSubRecord(LittleEndianInput paramLittleEndianInput, int paramInt) {
/*  44 */     int i = paramLittleEndianInput.readUShort();
/*  45 */     int j = paramLittleEndianInput.readUShort();
/*     */     
/*  47 */     switch (i) {
/*     */       case 21:
/*  49 */         return new CommonObjectDataSubRecord(paramLittleEndianInput, j);
/*     */       case 9:
/*  51 */         return new EmbeddedObjectRefSubRecord(paramLittleEndianInput, j);
/*     */       case 6:
/*  53 */         return new GroupMarkerSubRecord(paramLittleEndianInput, j);
/*     */       case 0:
/*  55 */         return new EndSubRecord(paramLittleEndianInput, j);
/*     */       case 13:
/*  57 */         return new NoteStructureSubRecord(paramLittleEndianInput, j);
/*     */       case 19:
/*  59 */         return new LbsDataSubRecord(paramLittleEndianInput, j, paramInt);
/*     */       case 12:
/*  61 */         return new FtCblsSubRecord(paramLittleEndianInput, j);
/*     */       case 8:
/*  63 */         return new FtPioGrbitSubRecord(paramLittleEndianInput, j);
/*     */       case 7:
/*  65 */         return new FtCfSubRecord(paramLittleEndianInput, j);
/*     */     } 
/*  67 */     return new UnknownSubRecord(paramLittleEndianInput, i, j);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract int getDataSize();
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] serialize() {
/*  77 */     int i = getDataSize() + 4;
/*  78 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i);
/*  79 */     serialize((LittleEndianOutput)new LittleEndianOutputStream(byteArrayOutputStream));
/*  80 */     if (byteArrayOutputStream.size() != i) {
/*  81 */       throw new RuntimeException("write size mismatch");
/*     */     }
/*  83 */     return byteArrayOutputStream.toByteArray();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void serialize(LittleEndianOutput paramLittleEndianOutput);
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract Object clone();
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTerminating() {
/*  98 */     return false;
/*     */   }
/*     */   
/*     */   private static final class UnknownSubRecord
/*     */     extends SubRecord {
/*     */     private final int _sid;
/*     */     private final byte[] _data;
/*     */     
/*     */     public UnknownSubRecord(LittleEndianInput param1LittleEndianInput, int param1Int1, int param1Int2) {
/* 107 */       this._sid = param1Int1;
/* 108 */       byte[] arrayOfByte = new byte[param1Int2];
/* 109 */       param1LittleEndianInput.readFully(arrayOfByte);
/* 110 */       this._data = arrayOfByte;
/*     */     }
/*     */     protected int getDataSize() {
/* 113 */       return this._data.length;
/*     */     }
/*     */     public void serialize(LittleEndianOutput param1LittleEndianOutput) {
/* 116 */       param1LittleEndianOutput.writeShort(this._sid);
/* 117 */       param1LittleEndianOutput.writeShort(this._data.length);
/* 118 */       param1LittleEndianOutput.write(this._data);
/*     */     }
/*     */     public Object clone() {
/* 121 */       return this;
/*     */     }
/*     */     public String toString() {
/* 124 */       StringBuffer stringBuffer = new StringBuffer(64);
/* 125 */       stringBuffer.append(getClass().getName()).append(" [");
/* 126 */       stringBuffer.append("sid=").append(HexDump.shortToHex(this._sid));
/* 127 */       stringBuffer.append(" size=").append(this._data.length);
/* 128 */       stringBuffer.append(" : ").append(HexDump.toHex(this._data));
/* 129 */       stringBuffer.append("]\n");
/* 130 */       return stringBuffer.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\SubRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */