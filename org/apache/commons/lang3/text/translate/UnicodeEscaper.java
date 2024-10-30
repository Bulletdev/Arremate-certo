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
/*     */ @Deprecated
/*     */ public class UnicodeEscaper
/*     */   extends CodePointTranslator
/*     */ {
/*     */   private final int below;
/*     */   private final int above;
/*     */   private final boolean between;
/*     */   
/*     */   public UnicodeEscaper() {
/*  41 */     this(0, 2147483647, true);
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
/*     */   protected UnicodeEscaper(int paramInt1, int paramInt2, boolean paramBoolean) {
/*  55 */     this.below = paramInt1;
/*  56 */     this.above = paramInt2;
/*  57 */     this.between = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static UnicodeEscaper below(int paramInt) {
/*  67 */     return outsideOf(paramInt, 2147483647);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static UnicodeEscaper above(int paramInt) {
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
/*     */   public static UnicodeEscaper outsideOf(int paramInt1, int paramInt2) {
/*  88 */     return new UnicodeEscaper(paramInt1, paramInt2, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static UnicodeEscaper between(int paramInt1, int paramInt2) {
/*  99 */     return new UnicodeEscaper(paramInt1, paramInt2, true);
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
/*     */     
/* 118 */     if (paramInt > 65535) {
/* 119 */       paramWriter.write(toUtf16Escape(paramInt));
/*     */     } else {
/* 121 */       paramWriter.write("\\u");
/* 122 */       paramWriter.write(HEX_DIGITS[paramInt >> 12 & 0xF]);
/* 123 */       paramWriter.write(HEX_DIGITS[paramInt >> 8 & 0xF]);
/* 124 */       paramWriter.write(HEX_DIGITS[paramInt >> 4 & 0xF]);
/* 125 */       paramWriter.write(HEX_DIGITS[paramInt & 0xF]);
/*     */     } 
/* 127 */     return true;
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
/*     */   protected String toUtf16Escape(int paramInt) {
/* 140 */     return "\\u" + hex(paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\text\translate\UnicodeEscaper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */