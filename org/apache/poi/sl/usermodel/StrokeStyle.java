/*     */ package org.apache.poi.sl.usermodel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface StrokeStyle
/*     */ {
/*     */   PaintStyle getPaint();
/*     */   
/*     */   LineCap getLineCap();
/*     */   
/*     */   LineDash getLineDash();
/*     */   
/*     */   LineCompound getLineCompound();
/*     */   
/*     */   double getLineWidth();
/*     */   
/*     */   public enum LineCap
/*     */   {
/*  23 */     ROUND(0, 1),
/*     */     
/*  25 */     SQUARE(1, 2),
/*     */     
/*  27 */     FLAT(2, 3);
/*     */     
/*     */     public final int nativeId;
/*     */     public final int ooxmlId;
/*     */     
/*     */     LineCap(int param1Int1, int param1Int2) {
/*  33 */       this.nativeId = param1Int1;
/*  34 */       this.ooxmlId = param1Int2;
/*     */     }
/*     */     
/*     */     public static LineCap fromNativeId(int param1Int) {
/*  38 */       for (LineCap lineCap : values()) {
/*  39 */         if (lineCap.nativeId == param1Int) return lineCap; 
/*     */       } 
/*  41 */       return null;
/*     */     }
/*     */     
/*     */     public static LineCap fromOoxmlId(int param1Int) {
/*  45 */       for (LineCap lineCap : values()) {
/*  46 */         if (lineCap.ooxmlId == param1Int) return lineCap; 
/*     */       } 
/*  48 */       return null;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum LineDash
/*     */   {
/*  59 */     SOLID(1, 1, null),
/*     */     
/*  61 */     DOT(6, 2, new int[] { 1, 1
/*     */       }),
/*  63 */     DASH(7, 3, new int[] { 3, 4
/*     */       }),
/*  65 */     DASH_DOT(9, 5, new int[] { 4, 3, 1, 3
/*     */       }),
/*  67 */     LG_DASH(8, 4, new int[] { 8, 3
/*     */       }),
/*  69 */     LG_DASH_DOT(10, 6, new int[] { 8, 3, 1, 3
/*     */       }),
/*  71 */     LG_DASH_DOT_DOT(11, 7, new int[] { 8, 3, 1, 3, 1, 3
/*     */       }),
/*  73 */     SYS_DASH(2, 8, new int[] { 2, 2
/*     */       }),
/*  75 */     SYS_DOT(3, 9, new int[] { 1, 1
/*     */       }),
/*  77 */     SYS_DASH_DOT(4, 10, new int[] { 2, 2, 1, 1
/*     */       }),
/*  79 */     SYS_DASH_DOT_DOT(5, 11, new int[] { 2, 2, 1, 1, 1, 1 });
/*     */     
/*     */     public final int[] pattern;
/*     */     public final int nativeId;
/*     */     public final int ooxmlId;
/*     */     
/*     */     LineDash(int param1Int1, int param1Int2, int... param1VarArgs) {
/*  86 */       this.nativeId = param1Int1;
/*  87 */       this.ooxmlId = param1Int2;
/*  88 */       this.pattern = (param1VarArgs == null || param1VarArgs.length == 0) ? null : param1VarArgs;
/*     */     }
/*     */     
/*     */     public static LineDash fromNativeId(int param1Int) {
/*  92 */       for (LineDash lineDash : values()) {
/*  93 */         if (lineDash.nativeId == param1Int) return lineDash; 
/*     */       } 
/*  95 */       return null;
/*     */     }
/*     */     
/*     */     public static LineDash fromOoxmlId(int param1Int) {
/*  99 */       for (LineDash lineDash : values()) {
/* 100 */         if (lineDash.ooxmlId == param1Int) return lineDash; 
/*     */       } 
/* 102 */       return null;
/*     */     }
/*     */   }
/*     */   
/*     */   public enum LineCompound
/*     */   {
/* 108 */     SINGLE(0, 1),
/*     */     
/* 110 */     DOUBLE(1, 2),
/*     */     
/* 112 */     THICK_THIN(2, 3),
/*     */     
/* 114 */     THIN_THICK(3, 4),
/*     */     
/* 116 */     TRIPLE(4, 5);
/*     */     
/*     */     public final int nativeId;
/*     */     public final int ooxmlId;
/*     */     
/*     */     LineCompound(int param1Int1, int param1Int2) {
/* 122 */       this.nativeId = param1Int1;
/* 123 */       this.ooxmlId = param1Int2;
/*     */     }
/*     */     
/*     */     public static LineCompound fromNativeId(int param1Int) {
/* 127 */       for (LineCompound lineCompound : values()) {
/* 128 */         if (lineCompound.nativeId == param1Int) return lineCompound; 
/*     */       } 
/* 130 */       return null;
/*     */     }
/*     */     
/*     */     public static LineCompound fromOoxmlId(int param1Int) {
/* 134 */       for (LineCompound lineCompound : values()) {
/* 135 */         if (lineCompound.ooxmlId == param1Int) return lineCompound; 
/*     */       } 
/* 137 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\StrokeStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */