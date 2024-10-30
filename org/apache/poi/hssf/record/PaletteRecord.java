/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ public final class PaletteRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 146;
/*     */   public static final byte STANDARD_PALETTE_SIZE = 56;
/*     */   public static final short FIRST_COLOR_INDEX = 8;
/*     */   private final List<PColor> _colors;
/*     */   
/*     */   public PaletteRecord() {
/*  41 */     PColor[] arrayOfPColor = createDefaultPalette();
/*  42 */     this._colors = new ArrayList<PColor>(arrayOfPColor.length);
/*  43 */     for (PColor pColor : arrayOfPColor) {
/*  44 */       this._colors.add(pColor);
/*     */     }
/*     */   }
/*     */   
/*     */   public PaletteRecord(RecordInputStream paramRecordInputStream) {
/*  49 */     short s = paramRecordInputStream.readShort();
/*  50 */     this._colors = new ArrayList<PColor>(s);
/*  51 */     for (byte b = 0; b < s; b++) {
/*  52 */       this._colors.add(new PColor(paramRecordInputStream));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  58 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  60 */     stringBuffer.append("[PALETTE]\n");
/*  61 */     stringBuffer.append("  numcolors     = ").append(this._colors.size()).append('\n');
/*  62 */     for (byte b = 0; b < this._colors.size(); b++) {
/*  63 */       PColor pColor = this._colors.get(b);
/*  64 */       stringBuffer.append("* colornum      = ").append(b).append('\n');
/*  65 */       stringBuffer.append(pColor.toString());
/*  66 */       stringBuffer.append("/*colornum      = ").append(b).append('\n');
/*     */     } 
/*  68 */     stringBuffer.append("[/PALETTE]\n");
/*  69 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  74 */     paramLittleEndianOutput.writeShort(this._colors.size());
/*  75 */     for (byte b = 0; b < this._colors.size(); b++) {
/*  76 */       ((PColor)this._colors.get(b)).serialize(paramLittleEndianOutput);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getDataSize() {
/*  82 */     return 2 + this._colors.size() * 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  87 */     return 146;
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
/*     */   public byte[] getColor(int paramInt) {
/*  99 */     int i = paramInt - 8;
/* 100 */     if (i < 0 || i >= this._colors.size()) {
/* 101 */       return null;
/*     */     }
/* 103 */     return ((PColor)this._colors.get(i)).getTriplet();
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColor(short paramShort, byte paramByte1, byte paramByte2, byte paramByte3) {
/* 120 */     int i = paramShort - 8;
/* 121 */     if (i < 0 || i >= 56) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 126 */     while (this._colors.size() <= i) {
/* 127 */       this._colors.add(new PColor(0, 0, 0));
/*     */     }
/* 129 */     PColor pColor = new PColor(paramByte1, paramByte2, paramByte3);
/* 130 */     this._colors.set(i, pColor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static PColor[] createDefaultPalette() {
/* 138 */     return new PColor[] { pc(0, 0, 0), pc(255, 255, 255), pc(255, 0, 0), pc(0, 255, 0), pc(0, 0, 255), pc(255, 255, 0), pc(255, 0, 255), pc(0, 255, 255), pc(128, 0, 0), pc(0, 128, 0), pc(0, 0, 128), pc(128, 128, 0), pc(128, 0, 128), pc(0, 128, 128), pc(192, 192, 192), pc(128, 128, 128), pc(153, 153, 255), pc(153, 51, 102), pc(255, 255, 204), pc(204, 255, 255), pc(102, 0, 102), pc(255, 128, 128), pc(0, 102, 204), pc(204, 204, 255), pc(0, 0, 128), pc(255, 0, 255), pc(255, 255, 0), pc(0, 255, 255), pc(128, 0, 128), pc(128, 0, 0), pc(0, 128, 128), pc(0, 0, 255), pc(0, 204, 255), pc(204, 255, 255), pc(204, 255, 204), pc(255, 255, 153), pc(153, 204, 255), pc(255, 153, 204), pc(204, 153, 255), pc(255, 204, 153), pc(51, 102, 255), pc(51, 204, 204), pc(153, 204, 0), pc(255, 204, 0), pc(255, 153, 0), pc(255, 102, 0), pc(102, 102, 153), pc(150, 150, 150), pc(0, 51, 102), pc(51, 153, 102), pc(0, 51, 0), pc(51, 51, 0), pc(153, 51, 0), pc(153, 51, 102), pc(51, 51, 153), pc(51, 51, 51) };
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
/*     */   private static PColor pc(int paramInt1, int paramInt2, int paramInt3) {
/* 199 */     return new PColor(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class PColor
/*     */   {
/*     */     public static final short ENCODED_SIZE = 4;
/*     */     
/*     */     private final int _red;
/*     */     private final int _green;
/*     */     private final int _blue;
/*     */     
/*     */     public PColor(int param1Int1, int param1Int2, int param1Int3) {
/* 212 */       this._red = param1Int1;
/* 213 */       this._green = param1Int2;
/* 214 */       this._blue = param1Int3;
/*     */     }
/*     */     
/*     */     public byte[] getTriplet() {
/* 218 */       return new byte[] { (byte)this._red, (byte)this._green, (byte)this._blue };
/*     */     }
/*     */     
/*     */     public PColor(RecordInputStream param1RecordInputStream) {
/* 222 */       this._red = param1RecordInputStream.readByte();
/* 223 */       this._green = param1RecordInputStream.readByte();
/* 224 */       this._blue = param1RecordInputStream.readByte();
/* 225 */       param1RecordInputStream.readByte();
/*     */     }
/*     */     
/*     */     public void serialize(LittleEndianOutput param1LittleEndianOutput) {
/* 229 */       param1LittleEndianOutput.writeByte(this._red);
/* 230 */       param1LittleEndianOutput.writeByte(this._green);
/* 231 */       param1LittleEndianOutput.writeByte(this._blue);
/* 232 */       param1LittleEndianOutput.writeByte(0);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 237 */       StringBuffer stringBuffer = new StringBuffer();
/* 238 */       stringBuffer.append("  red   = ").append(this._red & 0xFF).append('\n');
/* 239 */       stringBuffer.append("  green = ").append(this._green & 0xFF).append('\n');
/* 240 */       stringBuffer.append("  blue  = ").append(this._blue & 0xFF).append('\n');
/* 241 */       return stringBuffer.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\PaletteRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */