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
/*     */ public enum HorizontalAlignment
/*     */ {
/*  31 */   GENERAL,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  39 */   LEFT,
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  44 */   CENTER,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  50 */   RIGHT,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  67 */   FILL,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  74 */   JUSTIFY,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  82 */   CENTER_SELECTION,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  94 */   DISTRIBUTED;
/*     */   
/*     */   public short getCode() {
/*  97 */     return (short)ordinal();
/*     */   }
/*     */   public static HorizontalAlignment forInt(int paramInt) {
/* 100 */     if (paramInt < 0 || paramInt >= (values()).length) {
/* 101 */       throw new IllegalArgumentException("Invalid HorizontalAlignment code: " + paramInt);
/*     */     }
/* 103 */     return values()[paramInt];
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\HorizontalAlignment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */