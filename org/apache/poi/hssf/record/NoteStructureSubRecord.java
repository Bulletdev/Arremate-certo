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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class NoteStructureSubRecord
/*     */   extends SubRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 13;
/*     */   private static final int ENCODED_SIZE = 22;
/*     */   private byte[] reserved;
/*     */   
/*     */   public NoteStructureSubRecord() {
/*  43 */     this.reserved = new byte[22];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NoteStructureSubRecord(LittleEndianInput paramLittleEndianInput, int paramInt) {
/*  53 */     if (paramInt != 22) {
/*  54 */       throw new RecordFormatException("Unexpected size (" + paramInt + ")");
/*     */     }
/*     */     
/*  57 */     byte[] arrayOfByte = new byte[paramInt];
/*  58 */     paramLittleEndianInput.readFully(arrayOfByte);
/*  59 */     this.reserved = arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  69 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  71 */     stringBuffer.append("[ftNts ]").append("\n");
/*  72 */     stringBuffer.append("  size     = ").append(getDataSize()).append("\n");
/*  73 */     stringBuffer.append("  reserved = ").append(HexDump.toHex(this.reserved)).append("\n");
/*  74 */     stringBuffer.append("[/ftNts ]").append("\n");
/*  75 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  85 */     paramLittleEndianOutput.writeShort(13);
/*  86 */     paramLittleEndianOutput.writeShort(this.reserved.length);
/*  87 */     paramLittleEndianOutput.write(this.reserved);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getDataSize() {
/*  92 */     return this.reserved.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 100 */     return 13;
/*     */   }
/*     */ 
/*     */   
/*     */   public NoteStructureSubRecord clone() {
/* 105 */     NoteStructureSubRecord noteStructureSubRecord = new NoteStructureSubRecord();
/* 106 */     byte[] arrayOfByte = new byte[this.reserved.length];
/* 107 */     System.arraycopy(this.reserved, 0, arrayOfByte, 0, arrayOfByte.length);
/* 108 */     noteStructureSubRecord.reserved = arrayOfByte;
/* 109 */     return noteStructureSubRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\NoteStructureSubRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */