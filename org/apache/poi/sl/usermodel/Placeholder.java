/*     */ package org.apache.poi.sl.usermodel;
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
/*     */ public enum Placeholder
/*     */ {
/*  24 */   NONE(0, 0, 0, 0, 0),
/*     */ 
/*     */ 
/*     */   
/*  28 */   TITLE(13, 1, 1, 1, 1),
/*     */ 
/*     */ 
/*     */   
/*  32 */   BODY(14, 2, 12, 6, 2),
/*     */ 
/*     */ 
/*     */   
/*  36 */   CENTERED_TITLE(15, 3, 3, 3, 3),
/*     */ 
/*     */ 
/*     */   
/*  40 */   SUBTITLE(16, 4, 4, 4, 4),
/*     */ 
/*     */ 
/*     */   
/*  44 */   DATETIME(7, 7, 7, 7, 5),
/*     */ 
/*     */ 
/*     */   
/*  48 */   SLIDE_NUMBER(8, 8, 8, 8, 6),
/*     */ 
/*     */ 
/*     */   
/*  52 */   FOOTER(9, 9, 9, 9, 7),
/*     */ 
/*     */ 
/*     */   
/*  56 */   HEADER(10, 10, 10, 10, 8),
/*     */ 
/*     */ 
/*     */   
/*  60 */   CONTENT(19, 19, 19, 19, 9),
/*     */ 
/*     */ 
/*     */   
/*  64 */   CHART(20, 20, 20, 20, 10),
/*     */ 
/*     */ 
/*     */   
/*  68 */   TABLE(21, 21, 21, 21, 11),
/*     */ 
/*     */ 
/*     */   
/*  72 */   CLIP_ART(22, 22, 22, 22, 12),
/*     */ 
/*     */ 
/*     */   
/*  76 */   DGM(23, 23, 23, 23, 13),
/*     */ 
/*     */ 
/*     */   
/*  80 */   MEDIA(24, 24, 24, 24, 14),
/*     */ 
/*     */ 
/*     */   
/*  84 */   SLIDE_IMAGE(11, 11, 11, 5, 15),
/*     */ 
/*     */ 
/*     */   
/*  88 */   PICTURE(26, 26, 26, 26, 16),
/*     */ 
/*     */ 
/*     */   
/*  92 */   VERTICAL_OBJECT(25, 25, 25, 25, -2),
/*     */ 
/*     */ 
/*     */   
/*  96 */   VERTICAL_TEXT_TITLE(17, 17, 17, 17, -2),
/*     */ 
/*     */ 
/*     */   
/* 100 */   VERTICAL_TEXT_BODY(18, 18, 18, 18, -2);
/*     */   
/*     */   public final int nativeSlideId;
/*     */   
/*     */   public final int nativeSlideMasterId;
/*     */   public final int nativeNotesId;
/*     */   public final int nativeNotesMasterId;
/*     */   public final int ooxmlId;
/*     */   
/*     */   Placeholder(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 110 */     this.nativeSlideId = paramInt1;
/* 111 */     this.nativeSlideMasterId = paramInt2;
/* 112 */     this.nativeNotesId = paramInt3;
/* 113 */     this.nativeNotesMasterId = paramInt4;
/* 114 */     this.ooxmlId = paramInt5;
/*     */   }
/*     */   
/*     */   public static Placeholder lookupNative(int paramInt) {
/* 118 */     for (Placeholder placeholder : values()) {
/* 119 */       if (placeholder.nativeSlideId == paramInt || placeholder.nativeSlideMasterId == paramInt || placeholder.nativeNotesId == paramInt || placeholder.nativeNotesMasterId == paramInt)
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 124 */         return placeholder;
/*     */       }
/*     */     } 
/* 127 */     return null;
/*     */   }
/*     */   
/*     */   public static Placeholder lookupOoxml(int paramInt) {
/* 131 */     for (Placeholder placeholder : values()) {
/* 132 */       if (placeholder.ooxmlId == paramInt) {
/* 133 */         return placeholder;
/*     */       }
/*     */     } 
/* 136 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\Placeholder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */