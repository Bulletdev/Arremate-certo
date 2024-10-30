/*     */ package org.apache.poi.hssf.record.common;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ExtendedColor
/*     */   implements Cloneable
/*     */ {
/*     */   public static final int TYPE_AUTO = 0;
/*     */   public static final int TYPE_INDEXED = 1;
/*     */   public static final int TYPE_RGB = 2;
/*     */   public static final int TYPE_THEMED = 3;
/*     */   public static final int TYPE_UNSET = 4;
/*     */   public static final int THEME_DARK_1 = 0;
/*     */   public static final int THEME_LIGHT_1 = 1;
/*     */   public static final int THEME_DARK_2 = 2;
/*     */   public static final int THEME_LIGHT_2 = 3;
/*     */   public static final int THEME_ACCENT_1 = 4;
/*     */   public static final int THEME_ACCENT_2 = 5;
/*     */   public static final int THEME_ACCENT_3 = 6;
/*     */   public static final int THEME_ACCENT_4 = 7;
/*     */   public static final int THEME_ACCENT_5 = 8;
/*     */   public static final int THEME_ACCENT_6 = 9;
/*     */   public static final int THEME_HYPERLINK = 10;
/*     */   public static final int THEME_FOLLOWED_HYPERLINK = 11;
/*     */   private int type;
/*     */   private int colorIndex;
/*     */   private byte[] rgba;
/*     */   private int themeIndex;
/*     */   private double tint;
/*     */   
/*     */   public ExtendedColor() {
/*  66 */     this.type = 1;
/*  67 */     this.colorIndex = 0;
/*  68 */     this.tint = 0.0D;
/*     */   }
/*     */   public ExtendedColor(LittleEndianInput paramLittleEndianInput) {
/*  71 */     this.type = paramLittleEndianInput.readInt();
/*  72 */     if (this.type == 1) {
/*  73 */       this.colorIndex = paramLittleEndianInput.readInt();
/*  74 */     } else if (this.type == 2) {
/*  75 */       this.rgba = new byte[4];
/*  76 */       paramLittleEndianInput.readFully(this.rgba);
/*  77 */     } else if (this.type == 3) {
/*  78 */       this.themeIndex = paramLittleEndianInput.readInt();
/*     */     } else {
/*     */       
/*  81 */       paramLittleEndianInput.readInt();
/*     */     } 
/*  83 */     this.tint = paramLittleEndianInput.readDouble();
/*     */   }
/*     */   
/*     */   public int getType() {
/*  87 */     return this.type;
/*     */   }
/*     */   public void setType(int paramInt) {
/*  90 */     this.type = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColorIndex() {
/*  97 */     return this.colorIndex;
/*     */   }
/*     */   public void setColorIndex(int paramInt) {
/* 100 */     this.colorIndex = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getRGBA() {
/* 107 */     return this.rgba;
/*     */   }
/*     */   public void setRGBA(byte[] paramArrayOfbyte) {
/* 110 */     this.rgba = (paramArrayOfbyte == null) ? null : (byte[])paramArrayOfbyte.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getThemeIndex() {
/* 117 */     return this.themeIndex;
/*     */   }
/*     */   public void setThemeIndex(int paramInt) {
/* 120 */     this.themeIndex = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double getTint() {
/* 126 */     return this.tint;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTint(double paramDouble) {
/* 132 */     if (paramDouble < -1.0D || paramDouble > 1.0D) {
/* 133 */       throw new IllegalArgumentException("Tint/Shade must be between -1 and +1");
/*     */     }
/* 135 */     this.tint = paramDouble;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 139 */     StringBuffer stringBuffer = new StringBuffer();
/* 140 */     stringBuffer.append("    [Extended Color]\n");
/* 141 */     stringBuffer.append("          .type  = ").append(this.type).append("\n");
/* 142 */     stringBuffer.append("          .tint  = ").append(this.tint).append("\n");
/* 143 */     stringBuffer.append("          .c_idx = ").append(this.colorIndex).append("\n");
/* 144 */     stringBuffer.append("          .rgba  = ").append(HexDump.toHex(this.rgba)).append("\n");
/* 145 */     stringBuffer.append("          .t_idx = ").append(this.themeIndex).append("\n");
/* 146 */     stringBuffer.append("    [/Extended Color]\n");
/* 147 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public ExtendedColor clone() {
/* 152 */     ExtendedColor extendedColor = new ExtendedColor();
/* 153 */     extendedColor.type = this.type;
/* 154 */     extendedColor.tint = this.tint;
/* 155 */     if (this.type == 1) {
/* 156 */       extendedColor.colorIndex = this.colorIndex;
/* 157 */     } else if (this.type == 2) {
/* 158 */       extendedColor.rgba = new byte[4];
/* 159 */       System.arraycopy(this.rgba, 0, extendedColor.rgba, 0, 4);
/* 160 */     } else if (this.type == 3) {
/* 161 */       extendedColor.themeIndex = this.themeIndex;
/*     */     } 
/* 163 */     return extendedColor;
/*     */   }
/*     */   
/*     */   public int getDataLength() {
/* 167 */     return 16;
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 171 */     paramLittleEndianOutput.writeInt(this.type);
/* 172 */     if (this.type == 1) {
/* 173 */       paramLittleEndianOutput.writeInt(this.colorIndex);
/* 174 */     } else if (this.type == 2) {
/* 175 */       paramLittleEndianOutput.write(this.rgba);
/* 176 */     } else if (this.type == 3) {
/* 177 */       paramLittleEndianOutput.writeInt(this.themeIndex);
/*     */     } else {
/* 179 */       paramLittleEndianOutput.writeInt(0);
/*     */     } 
/* 181 */     paramLittleEndianOutput.writeDouble(this.tint);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\common\ExtendedColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */