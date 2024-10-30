/*     */ package org.apache.poi.xwpf.usermodel;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ public enum UnderlinePatterns
/*     */ {
/*  34 */   SINGLE(1),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  41 */   WORDS(2),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  47 */   DOUBLE(3),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   THICK(4),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  59 */   DOTTED(5),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  65 */   DOTTED_HEAVY(6),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   DASH(7),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  77 */   DASHED_HEAVY(8),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  83 */   DASH_LONG(9),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  89 */   DASH_LONG_HEAVY(10),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  95 */   DOT_DASH(11),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 101 */   DASH_DOT_HEAVY(12),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 107 */   DOT_DOT_DASH(13),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 113 */   DASH_DOT_DOT_HEAVY(14),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 119 */   WAVE(15),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 125 */   WAVY_HEAVY(16),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 131 */   WAVY_DOUBLE(17),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 136 */   NONE(18);
/*     */   static {
/* 138 */     imap = new HashMap<Integer, UnderlinePatterns>();
/*     */ 
/*     */     
/* 141 */     for (UnderlinePatterns underlinePatterns : values())
/* 142 */       imap.put(Integer.valueOf(underlinePatterns.getValue()), underlinePatterns); 
/*     */   }
/*     */   
/*     */   private static Map<Integer, UnderlinePatterns> imap;
/*     */   private final int value;
/*     */   
/*     */   UnderlinePatterns(int paramInt1) {
/* 149 */     this.value = paramInt1;
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
/*     */   public int getValue() {
/* 161 */     return this.value;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\UnderlinePatterns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */