/*     */ package org.apache.poi.ss.usermodel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum IndexedColors
/*     */ {
/*  35 */   BLACK(8),
/*  36 */   WHITE(9),
/*  37 */   RED(10),
/*  38 */   BRIGHT_GREEN(11),
/*  39 */   BLUE(12),
/*  40 */   YELLOW(13),
/*  41 */   PINK(14),
/*  42 */   TURQUOISE(15),
/*  43 */   DARK_RED(16),
/*  44 */   GREEN(17),
/*  45 */   DARK_BLUE(18),
/*  46 */   DARK_YELLOW(19),
/*  47 */   VIOLET(20),
/*  48 */   TEAL(21),
/*  49 */   GREY_25_PERCENT(22),
/*  50 */   GREY_50_PERCENT(23),
/*  51 */   CORNFLOWER_BLUE(24),
/*  52 */   MAROON(25),
/*  53 */   LEMON_CHIFFON(26),
/*     */   
/*  55 */   ORCHID(28),
/*  56 */   CORAL(29),
/*  57 */   ROYAL_BLUE(30),
/*  58 */   LIGHT_CORNFLOWER_BLUE(31),
/*  59 */   SKY_BLUE(40),
/*  60 */   LIGHT_TURQUOISE(41),
/*  61 */   LIGHT_GREEN(42),
/*  62 */   LIGHT_YELLOW(43),
/*  63 */   PALE_BLUE(44),
/*  64 */   ROSE(45),
/*  65 */   LAVENDER(46),
/*  66 */   TAN(47),
/*  67 */   LIGHT_BLUE(48),
/*  68 */   AQUA(49),
/*  69 */   LIME(50),
/*  70 */   GOLD(51),
/*  71 */   LIGHT_ORANGE(52),
/*  72 */   ORANGE(53),
/*  73 */   BLUE_GREY(54),
/*  74 */   GREY_40_PERCENT(55),
/*  75 */   DARK_TEAL(56),
/*  76 */   SEA_GREEN(57),
/*  77 */   DARK_GREEN(58),
/*  78 */   OLIVE_GREEN(59),
/*  79 */   BROWN(60),
/*  80 */   PLUM(61),
/*  81 */   INDIGO(62),
/*  82 */   GREY_80_PERCENT(63),
/*  83 */   AUTOMATIC(64);
/*     */   static {
/*  85 */     _values = new IndexedColors[65];
/*     */     
/*  87 */     for (IndexedColors indexedColors : values())
/*  88 */       _values[indexedColors.index] = indexedColors; 
/*     */   }
/*     */   
/*     */   private static final IndexedColors[] _values;
/*     */   public final short index;
/*     */   
/*     */   IndexedColors(int paramInt1) {
/*  95 */     this.index = (short)paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getIndex() {
/* 104 */     return this.index;
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
/*     */   public static IndexedColors fromInt(int paramInt) {
/* 116 */     if (paramInt < 0 || paramInt >= _values.length) {
/* 117 */       throw new IllegalArgumentException("Illegal IndexedColor index: " + paramInt);
/*     */     }
/* 119 */     IndexedColors indexedColors = _values[paramInt];
/* 120 */     if (indexedColors == null) {
/* 121 */       throw new IllegalArgumentException("Illegal IndexedColor index: " + paramInt);
/*     */     }
/* 123 */     return indexedColors;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\IndexedColors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */