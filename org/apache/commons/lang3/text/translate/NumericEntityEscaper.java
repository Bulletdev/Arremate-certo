/*     */ package org.apache.commons.lang3.text.translate;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class NumericEntityEscaper
/*     */   extends CodePointTranslator
/*     */ {
/*     */   private final int below;
/*     */   private final int above;
/*     */   private final boolean between;
/*     */   
/*     */   private NumericEntityEscaper(int paramInt1, int paramInt2, boolean paramBoolean) {
/*  48 */     this.below = paramInt1;
/*  49 */     this.above = paramInt2;
/*  50 */     this.between = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NumericEntityEscaper() {
/*  57 */     this(0, 2147483647, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static NumericEntityEscaper below(int paramInt) {
/*  67 */     return outsideOf(paramInt, 2147483647);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static NumericEntityEscaper above(int paramInt) {
/*  77 */     return outsideOf(0, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static NumericEntityEscaper between(int paramInt1, int paramInt2) {
/*  88 */     return new NumericEntityEscaper(paramInt1, paramInt2, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static NumericEntityEscaper outsideOf(int paramInt1, int paramInt2) {
/*  99 */     return new NumericEntityEscaper(paramInt1, paramInt2, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean translate(int paramInt, Writer paramWriter) throws IOException {
/* 107 */     if (this.between) {
/* 108 */       if (paramInt < this.below || paramInt > this.above) {
/* 109 */         return false;
/*     */       }
/*     */     }
/* 112 */     else if (paramInt >= this.below && paramInt <= this.above) {
/* 113 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 117 */     paramWriter.write("&#");
/* 118 */     paramWriter.write(Integer.toString(paramInt, 10));
/* 119 */     paramWriter.write(59);
/* 120 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\text\translate\NumericEntityEscaper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */