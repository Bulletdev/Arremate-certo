/*     */ package org.apache.poi.ss.util;
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
/*     */ public class PaneInformation
/*     */ {
/*     */   public static final byte PANE_LOWER_RIGHT = 0;
/*     */   public static final byte PANE_UPPER_RIGHT = 1;
/*     */   public static final byte PANE_LOWER_LEFT = 2;
/*     */   public static final byte PANE_UPPER_LEFT = 3;
/*     */   private final short x;
/*     */   private final short y;
/*     */   private final short topRow;
/*     */   private final short leftColumn;
/*     */   private final byte activePane;
/*     */   private final boolean frozen;
/*     */   
/*     */   public PaneInformation(short paramShort1, short paramShort2, short paramShort3, short paramShort4, byte paramByte, boolean paramBoolean) {
/*  43 */     this.x = paramShort1;
/*  44 */     this.y = paramShort2;
/*  45 */     this.topRow = paramShort3;
/*  46 */     this.leftColumn = paramShort4;
/*  47 */     this.activePane = paramByte;
/*  48 */     this.frozen = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getVerticalSplitPosition() {
/*  59 */     return this.x;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getHorizontalSplitPosition() {
/*  69 */     return this.y;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getHorizontalSplitTopRow() {
/*  77 */     return this.topRow;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getVerticalSplitLeftColumn() {
/*  85 */     return this.leftColumn;
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
/*     */   public byte getActivePane() {
/*  97 */     return this.activePane;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFreezePane() {
/* 103 */     return this.frozen;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\PaneInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */