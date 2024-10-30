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
/*     */ public enum FontUnderline
/*     */ {
/*  32 */   SINGLE(1),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  39 */   DOUBLE(2),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   SINGLE_ACCOUNTING(3),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   DOUBLE_ACCOUNTING(4),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  58 */   NONE(5);
/*     */   
/*     */   private int value;
/*     */   private static FontUnderline[] _table;
/*     */   
/*     */   FontUnderline(int paramInt1) {
/*  64 */     this.value = paramInt1;
/*     */   }
/*     */   
/*     */   public int getValue() {
/*  68 */     return this.value;
/*     */   }
/*     */   
/*     */   public byte getByteValue() {
/*  72 */     switch (this) {
/*     */       case DOUBLE:
/*  74 */         return 2;
/*     */       case DOUBLE_ACCOUNTING:
/*  76 */         return 34;
/*     */       case SINGLE_ACCOUNTING:
/*  78 */         return 33;
/*     */       case NONE:
/*  80 */         return 0;
/*     */       case SINGLE:
/*  82 */         return 1;
/*     */     } 
/*  84 */     return 1;
/*     */   }
/*     */   
/*     */   static {
/*  88 */     _table = new FontUnderline[6];
/*     */     
/*  90 */     for (FontUnderline fontUnderline : values())
/*  91 */       _table[fontUnderline.getValue()] = fontUnderline; 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\FontUnderline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */