/*    */ package org.apache.poi.ss.usermodel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum FontCharset
/*    */ {
/* 29 */   ANSI(0),
/* 30 */   DEFAULT(1),
/* 31 */   SYMBOL(2),
/* 32 */   MAC(77),
/* 33 */   SHIFTJIS(128),
/* 34 */   HANGEUL(129),
/* 35 */   JOHAB(130),
/* 36 */   GB2312(134),
/* 37 */   CHINESEBIG5(136),
/* 38 */   GREEK(161),
/* 39 */   TURKISH(162),
/* 40 */   VIETNAMESE(163),
/* 41 */   HEBREW(177),
/* 42 */   ARABIC(178),
/* 43 */   BALTIC(186),
/* 44 */   RUSSIAN(204),
/* 45 */   THAI(222),
/* 46 */   EASTEUROPE(238),
/* 47 */   OEM(255);
/*    */   
/*    */   private int charset;
/*    */   private static FontCharset[] _table;
/*    */   
/*    */   FontCharset(int paramInt1) {
/* 53 */     this.charset = paramInt1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getValue() {
/* 62 */     return this.charset;
/*    */   }
/*    */   static {
/* 65 */     _table = new FontCharset[256];
/*    */     
/* 67 */     for (FontCharset fontCharset : values())
/* 68 */       _table[fontCharset.getValue()] = fontCharset; 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\FontCharset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */