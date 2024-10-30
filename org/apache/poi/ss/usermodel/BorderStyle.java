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
/*     */ public enum BorderStyle
/*     */ {
/*  30 */   NONE(0),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  35 */   THIN(1),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  40 */   MEDIUM(2),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  45 */   DASHED(3),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  50 */   DOTTED(4),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   THICK(5),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  60 */   DOUBLE(6),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  65 */   HAIR(7),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  70 */   MEDIUM_DASHED(8),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  75 */   DASH_DOT(9),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  80 */   MEDIUM_DASH_DOT(10),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  85 */   DASH_DOT_DOT(11),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  90 */   MEDIUM_DASH_DOT_DOT(12),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  95 */   SLANTED_DASH_DOT(13);
/*     */   private final short code;
/*     */   private static final BorderStyle[] _table;
/*     */   
/*     */   BorderStyle(int paramInt1) {
/* 100 */     this.code = (short)paramInt1;
/*     */   }
/*     */   
/*     */   public short getCode() {
/* 104 */     return this.code;
/*     */   }
/*     */   static {
/* 107 */     _table = new BorderStyle[14];
/*     */     
/* 109 */     for (BorderStyle borderStyle : values())
/* 110 */       _table[borderStyle.getCode()] = borderStyle; 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\BorderStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */