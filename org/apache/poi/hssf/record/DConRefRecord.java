/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import org.apache.poi.util.LittleEndian;
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
/*     */ public class DConRefRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 81;
/*     */   private int firstRow;
/*     */   private int lastRow;
/*     */   private int firstCol;
/*     */   private int lastCol;
/*     */   private int charCount;
/*     */   private int charType;
/*     */   private byte[] path;
/*     */   private byte[] _unused;
/*     */   
/*     */   public DConRefRecord(byte[] paramArrayOfbyte) {
/* 113 */     int i = 0;
/* 114 */     if (LittleEndian.getShort(paramArrayOfbyte, i) != 81)
/* 115 */       throw new RecordFormatException("incompatible sid."); 
/* 116 */     i += true;
/*     */ 
/*     */     
/* 119 */     i += true;
/*     */     
/* 121 */     this.firstRow = LittleEndian.getUShort(paramArrayOfbyte, i);
/* 122 */     i += true;
/* 123 */     this.lastRow = LittleEndian.getUShort(paramArrayOfbyte, i);
/* 124 */     i += true;
/* 125 */     this.firstCol = LittleEndian.getUByte(paramArrayOfbyte, i);
/* 126 */     i++;
/* 127 */     this.lastCol = LittleEndian.getUByte(paramArrayOfbyte, i);
/* 128 */     i++;
/* 129 */     this.charCount = LittleEndian.getUShort(paramArrayOfbyte, i);
/* 130 */     i += 2;
/* 131 */     if (this.charCount < 2) {
/* 132 */       throw new RecordFormatException("Character count must be >= 2");
/*     */     }
/*     */     
/* 135 */     this.charType = LittleEndian.getUByte(paramArrayOfbyte, i);
/* 136 */     i++;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 143 */     int j = this.charCount * ((this.charType & 0x1) + 1);
/*     */     
/* 145 */     this.path = LittleEndian.getByteArray(paramArrayOfbyte, i, j);
/* 146 */     i += j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 152 */     if (this.path[0] == 2) {
/* 153 */       this._unused = LittleEndian.getByteArray(paramArrayOfbyte, i, this.charType + 1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DConRefRecord(RecordInputStream paramRecordInputStream) {
/* 164 */     if (paramRecordInputStream.getSid() != 81) {
/* 165 */       throw new RecordFormatException("Wrong sid: " + paramRecordInputStream.getSid());
/*     */     }
/* 167 */     this.firstRow = paramRecordInputStream.readUShort();
/* 168 */     this.lastRow = paramRecordInputStream.readUShort();
/* 169 */     this.firstCol = paramRecordInputStream.readUByte();
/* 170 */     this.lastCol = paramRecordInputStream.readUByte();
/*     */     
/* 172 */     this.charCount = paramRecordInputStream.readUShort();
/* 173 */     this.charType = paramRecordInputStream.readUByte() & 0x1;
/*     */ 
/*     */     
/* 176 */     int i = this.charCount * (this.charType + 1);
/*     */     
/* 178 */     this.path = new byte[i];
/* 179 */     paramRecordInputStream.readFully(this.path);
/*     */     
/* 181 */     if (this.path[0] == 2) {
/* 182 */       this._unused = paramRecordInputStream.readRemainder();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getDataSize() {
/* 193 */     int i = 9 + this.path.length;
/* 194 */     if (this.path[0] == 2)
/* 195 */       i += this._unused.length; 
/* 196 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 202 */     paramLittleEndianOutput.writeShort(this.firstRow);
/* 203 */     paramLittleEndianOutput.writeShort(this.lastRow);
/* 204 */     paramLittleEndianOutput.writeByte(this.firstCol);
/* 205 */     paramLittleEndianOutput.writeByte(this.lastCol);
/* 206 */     paramLittleEndianOutput.writeShort(this.charCount);
/* 207 */     paramLittleEndianOutput.writeByte(this.charType);
/* 208 */     paramLittleEndianOutput.write(this.path);
/* 209 */     if (this.path[0] == 2) {
/* 210 */       paramLittleEndianOutput.write(this._unused);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 216 */     return 81;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFirstColumn() {
/* 224 */     return this.firstCol;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFirstRow() {
/* 232 */     return this.firstRow;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLastColumn() {
/* 240 */     return this.lastCol;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLastRow() {
/* 248 */     return this.lastRow;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 254 */     StringBuilder stringBuilder = new StringBuilder();
/* 255 */     stringBuilder.append("[DCONREF]\n");
/* 256 */     stringBuilder.append("    .ref\n");
/* 257 */     stringBuilder.append("        .firstrow   = ").append(this.firstRow).append("\n");
/* 258 */     stringBuilder.append("        .lastrow    = ").append(this.lastRow).append("\n");
/* 259 */     stringBuilder.append("        .firstcol   = ").append(this.firstCol).append("\n");
/* 260 */     stringBuilder.append("        .lastcol    = ").append(this.lastCol).append("\n");
/* 261 */     stringBuilder.append("    .cch            = ").append(this.charCount).append("\n");
/* 262 */     stringBuilder.append("    .stFile\n");
/* 263 */     stringBuilder.append("        .h          = ").append(this.charType).append("\n");
/* 264 */     stringBuilder.append("        .rgb        = ").append(getReadablePath()).append("\n");
/* 265 */     stringBuilder.append("[/DCONREF]\n");
/*     */     
/* 267 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getPath() {
/* 276 */     return Arrays.copyOf(this.path, this.path.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReadablePath() {
/* 285 */     if (this.path != null) {
/*     */ 
/*     */ 
/*     */       
/* 289 */       byte b = 1;
/* 290 */       while (this.path[b] < 32 && b < this.path.length)
/*     */       {
/* 292 */         b++;
/*     */       }
/* 294 */       String str = new String(Arrays.copyOfRange(this.path, b, this.path.length), StringUtil.UTF8);
/*     */       
/* 296 */       str = str.replaceAll("\003", "/");
/* 297 */       return str;
/*     */     } 
/* 299 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isExternalRef() {
/* 309 */     if (this.path[0] == 1)
/* 310 */       return true; 
/* 311 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\DConRefRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */