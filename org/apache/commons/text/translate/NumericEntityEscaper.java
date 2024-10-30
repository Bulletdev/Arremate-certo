/*     */ package org.apache.commons.text.translate;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ import org.apache.commons.lang3.Range;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NumericEntityEscaper
/*     */   extends CodePointTranslator
/*     */ {
/*     */   private final boolean between;
/*     */   private final Range<Integer> range;
/*     */   
/*     */   private NumericEntityEscaper(int paramInt1, int paramInt2, boolean paramBoolean) {
/*  46 */     this.range = Range.between(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
/*  47 */     this.between = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NumericEntityEscaper() {
/*  54 */     this(0, 2147483647, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static NumericEntityEscaper below(int paramInt) {
/*  64 */     return outsideOf(paramInt, 2147483647);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static NumericEntityEscaper above(int paramInt) {
/*  74 */     return outsideOf(0, paramInt);
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
/*  85 */     return new NumericEntityEscaper(paramInt1, paramInt2, true);
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
/*  96 */     return new NumericEntityEscaper(paramInt1, paramInt2, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean translate(int paramInt, Writer paramWriter) throws IOException {
/* 104 */     if (this.between != this.range.contains(Integer.valueOf(paramInt))) {
/* 105 */       return false;
/*     */     }
/* 107 */     paramWriter.write("&#");
/* 108 */     paramWriter.write(Integer.toString(paramInt, 10));
/* 109 */     paramWriter.write(59);
/* 110 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\translate\NumericEntityEscaper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */