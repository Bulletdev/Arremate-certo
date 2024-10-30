/*     */ package org.apache.poi.ddf;
/*     */ 
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EscherColorRef
/*     */ {
/*  27 */   int opid = -1;
/*  28 */   int colorRef = 0;
/*     */   
/*     */   public enum SysIndexSource
/*     */   {
/*  32 */     FILL_COLOR(240),
/*     */     
/*  34 */     LINE_OR_FILL_COLOR(241),
/*     */     
/*  36 */     LINE_COLOR(242),
/*     */     
/*  38 */     SHADOW_COLOR(243),
/*     */     
/*  40 */     CURRENT_OR_LAST_COLOR(244),
/*     */     
/*  42 */     FILL_BACKGROUND_COLOR(245),
/*     */     
/*  44 */     LINE_BACKGROUND_COLOR(246),
/*     */     
/*  46 */     FILL_OR_LINE_COLOR(247);
/*     */     
/*     */     SysIndexSource(int param1Int1) {
/*  49 */       this.value = param1Int1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum SysIndexProcedure
/*     */   {
/*  64 */     DARKEN_COLOR(1),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  70 */     LIGHTEN_COLOR(2),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  75 */     ADD_GRAY_LEVEL(3),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  80 */     SUB_GRAY_LEVEL(4),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  86 */     REVERSE_GRAY_LEVEL(5),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  92 */     THRESHOLD(6),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  97 */     INVERT_AFTER(32),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 103 */     INVERT_HIGHBIT_AFTER(64);
/*     */     BitField mask;
/*     */     
/*     */     SysIndexProcedure(int param1Int1) {
/* 107 */       this.mask = new BitField(param1Int1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 116 */   private static final BitField FLAG_SYS_INDEX = new BitField(268435456);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 123 */   private static final BitField FLAG_SCHEME_INDEX = new BitField(134217728);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 130 */   private static final BitField FLAG_SYSTEM_RGB = new BitField(67108864);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 137 */   private static final BitField FLAG_PALETTE_RGB = new BitField(33554432);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 144 */   private static final BitField FLAG_PALETTE_INDEX = new BitField(16777216);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 150 */   private static final BitField FLAG_BLUE = new BitField(16711680);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 156 */   private static final BitField FLAG_GREEN = new BitField(65280);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 162 */   private static final BitField FLAG_RED = new BitField(255);
/*     */   
/*     */   public EscherColorRef(int paramInt) {
/* 165 */     this.colorRef = paramInt;
/*     */   }
/*     */   
/*     */   public EscherColorRef(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 169 */     assert paramInt2 == 4 || paramInt2 == 6;
/*     */     
/* 171 */     int i = paramInt1;
/* 172 */     if (paramInt2 == 6) {
/* 173 */       this.opid = LittleEndian.getUShort(paramArrayOfbyte, i);
/* 174 */       i += 2;
/*     */     } 
/* 176 */     this.colorRef = LittleEndian.getInt(paramArrayOfbyte, i);
/*     */   }
/*     */   
/*     */   public boolean hasSysIndexFlag() {
/* 180 */     return FLAG_SYS_INDEX.isSet(this.colorRef);
/*     */   }
/*     */   
/*     */   public void setSysIndexFlag(boolean paramBoolean) {
/* 184 */     this.colorRef = FLAG_SYS_INDEX.setBoolean(this.colorRef, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean hasSchemeIndexFlag() {
/* 188 */     return FLAG_SCHEME_INDEX.isSet(this.colorRef);
/*     */   }
/*     */   
/*     */   public void setSchemeIndexFlag(boolean paramBoolean) {
/* 192 */     this.colorRef = FLAG_SCHEME_INDEX.setBoolean(this.colorRef, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean hasSystemRGBFlag() {
/* 196 */     return FLAG_SYSTEM_RGB.isSet(this.colorRef);
/*     */   }
/*     */   
/*     */   public void setSystemRGBFlag(boolean paramBoolean) {
/* 200 */     this.colorRef = FLAG_SYSTEM_RGB.setBoolean(this.colorRef, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean hasPaletteRGBFlag() {
/* 204 */     return FLAG_PALETTE_RGB.isSet(this.colorRef);
/*     */   }
/*     */   
/*     */   public void setPaletteRGBFlag(boolean paramBoolean) {
/* 208 */     this.colorRef = FLAG_PALETTE_RGB.setBoolean(this.colorRef, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean hasPaletteIndexFlag() {
/* 212 */     return FLAG_PALETTE_INDEX.isSet(this.colorRef);
/*     */   }
/*     */   
/*     */   public void setPaletteIndexFlag(boolean paramBoolean) {
/* 216 */     this.colorRef = FLAG_PALETTE_INDEX.setBoolean(this.colorRef, paramBoolean);
/*     */   }
/*     */   
/*     */   public int[] getRGB() {
/* 220 */     return new int[] { FLAG_RED.getValue(this.colorRef), FLAG_GREEN.getValue(this.colorRef), FLAG_BLUE.getValue(this.colorRef) };
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
/*     */   public SysIndexSource getSysIndexSource() {
/* 232 */     if (!hasSysIndexFlag()) return null; 
/* 233 */     int i = FLAG_RED.getValue(this.colorRef);
/* 234 */     for (SysIndexSource sysIndexSource : SysIndexSource.values()) {
/* 235 */       if (sysIndexSource.value == i) return sysIndexSource; 
/*     */     } 
/* 237 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SysIndexProcedure getSysIndexProcedure() {
/* 245 */     if (!hasSysIndexFlag()) return null; 
/* 246 */     int i = FLAG_GREEN.getValue(this.colorRef);
/* 247 */     for (SysIndexProcedure sysIndexProcedure : SysIndexProcedure.values()) {
/* 248 */       if (sysIndexProcedure != SysIndexProcedure.INVERT_AFTER && sysIndexProcedure != SysIndexProcedure.INVERT_HIGHBIT_AFTER && 
/* 249 */         sysIndexProcedure.mask.isSet(i)) return sysIndexProcedure; 
/*     */     } 
/* 251 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSysIndexInvert() {
/* 259 */     if (!hasSysIndexFlag()) return 0; 
/* 260 */     int i = FLAG_GREEN.getValue(this.colorRef);
/* 261 */     if (SysIndexProcedure.INVERT_AFTER.mask.isSet(i)) return 1; 
/* 262 */     if (SysIndexProcedure.INVERT_HIGHBIT_AFTER.mask.isSet(i)) return 2; 
/* 263 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSchemeIndex() {
/* 272 */     if (!hasSchemeIndexFlag()) return -1; 
/* 273 */     return FLAG_RED.getValue(this.colorRef);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPaletteIndex() {
/* 280 */     return hasPaletteIndexFlag() ? getIndex() : -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSysIndex() {
/* 289 */     return hasSysIndexFlag() ? getIndex() : -1;
/*     */   }
/*     */   
/*     */   private int getIndex() {
/* 293 */     return FLAG_GREEN.getValue(this.colorRef) << 8 | FLAG_RED.getValue(this.colorRef);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherColorRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */