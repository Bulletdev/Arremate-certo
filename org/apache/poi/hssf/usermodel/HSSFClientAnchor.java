/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.ddf.EscherClientAnchorRecord;
/*     */ import org.apache.poi.ddf.EscherRecord;
/*     */ import org.apache.poi.ss.SpreadsheetVersion;
/*     */ import org.apache.poi.ss.usermodel.ClientAnchor;
/*     */ import org.apache.poi.util.Removal;
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
/*     */ public final class HSSFClientAnchor
/*     */   extends HSSFAnchor
/*     */   implements ClientAnchor
/*     */ {
/*  32 */   public static final int MAX_COL = SpreadsheetVersion.EXCEL97.getLastColumnIndex();
/*  33 */   public static final int MAX_ROW = SpreadsheetVersion.EXCEL97.getLastRowIndex();
/*     */   
/*     */   private EscherClientAnchorRecord _escherClientAnchor;
/*     */   
/*     */   public HSSFClientAnchor(EscherClientAnchorRecord paramEscherClientAnchorRecord) {
/*  38 */     this._escherClientAnchor = paramEscherClientAnchorRecord;
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
/*     */   
/*     */   public HSSFClientAnchor() {}
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
/*     */   public HSSFClientAnchor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, short paramShort1, int paramInt5, short paramShort2, int paramInt6) {
/*  65 */     super(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */     
/*  67 */     checkRange(paramInt1, 0, 1023, "dx1");
/*  68 */     checkRange(paramInt3, 0, 1023, "dx2");
/*  69 */     checkRange(paramInt2, 0, 255, "dy1");
/*  70 */     checkRange(paramInt4, 0, 255, "dy2");
/*  71 */     checkRange(paramShort1, 0, MAX_COL, "col1");
/*  72 */     checkRange(paramShort2, 0, MAX_COL, "col2");
/*  73 */     checkRange(paramInt5, 0, MAX_ROW, "row1");
/*  74 */     checkRange(paramInt6, 0, MAX_ROW, "row2");
/*     */     
/*  76 */     setCol1((short)Math.min(paramShort1, paramShort2));
/*  77 */     setCol2((short)Math.max(paramShort1, paramShort2));
/*  78 */     setRow1(Math.min(paramInt5, paramInt6));
/*  79 */     setRow2(Math.max(paramInt5, paramInt6));
/*     */     
/*  81 */     if (paramShort1 > paramShort2) {
/*  82 */       this._isHorizontallyFlipped = true;
/*     */     }
/*  84 */     if (paramInt5 > paramInt6) {
/*  85 */       this._isVerticallyFlipped = true;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAnchorHeightInPoints(HSSFSheet paramHSSFSheet) {
/*  96 */     int i = getDy1();
/*  97 */     int j = getDy2();
/*  98 */     int k = Math.min(getRow1(), getRow2());
/*  99 */     int m = Math.max(getRow1(), getRow2());
/*     */     
/* 101 */     float f = 0.0F;
/* 102 */     if (k == m) {
/* 103 */       f = (j - i) / 256.0F * getRowHeightInPoints(paramHSSFSheet, m);
/*     */     } else {
/* 105 */       f += (256.0F - i) / 256.0F * getRowHeightInPoints(paramHSSFSheet, k);
/* 106 */       for (int n = k + 1; n < m; n++) {
/* 107 */         f += getRowHeightInPoints(paramHSSFSheet, n);
/*     */       }
/* 109 */       f += j / 256.0F * getRowHeightInPoints(paramHSSFSheet, m);
/*     */     } 
/*     */     
/* 112 */     return f;
/*     */   }
/*     */   
/*     */   private float getRowHeightInPoints(HSSFSheet paramHSSFSheet, int paramInt) {
/* 116 */     HSSFRow hSSFRow = paramHSSFSheet.getRow(paramInt);
/* 117 */     if (hSSFRow == null) {
/* 118 */       return paramHSSFSheet.getDefaultRowHeightInPoints();
/*     */     }
/* 120 */     return hSSFRow.getHeightInPoints();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getCol1() {
/* 127 */     return this._escherClientAnchor.getCol1();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCol1(short paramShort) {
/* 134 */     checkRange(paramShort, 0, MAX_COL, "col1");
/* 135 */     this._escherClientAnchor.setCol1(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCol1(int paramInt) {
/* 142 */     setCol1((short)paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getCol2() {
/* 149 */     return this._escherClientAnchor.getCol2();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCol2(short paramShort) {
/* 156 */     checkRange(paramShort, 0, MAX_COL, "col2");
/* 157 */     this._escherClientAnchor.setCol2(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCol2(int paramInt) {
/* 164 */     setCol2((short)paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRow1() {
/* 171 */     return unsignedValue(this._escherClientAnchor.getRow1());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRow1(int paramInt) {
/* 178 */     checkRange(paramInt, 0, MAX_ROW, "row1");
/* 179 */     this._escherClientAnchor.setRow1(Integer.valueOf(paramInt).shortValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRow2() {
/* 186 */     return unsignedValue(this._escherClientAnchor.getRow2());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRow2(int paramInt) {
/* 193 */     checkRange(paramInt, 0, MAX_ROW, "row2");
/* 194 */     this._escherClientAnchor.setRow2(Integer.valueOf(paramInt).shortValue());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAnchor(short paramShort1, int paramInt1, int paramInt2, int paramInt3, short paramShort2, int paramInt4, int paramInt5, int paramInt6) {
/* 215 */     checkRange(getDx1(), 0, 1023, "dx1");
/* 216 */     checkRange(getDx2(), 0, 1023, "dx2");
/* 217 */     checkRange(getDy1(), 0, 255, "dy1");
/* 218 */     checkRange(getDy2(), 0, 255, "dy2");
/* 219 */     checkRange(getCol1(), 0, MAX_COL, "col1");
/* 220 */     checkRange(getCol2(), 0, MAX_COL, "col2");
/* 221 */     checkRange(getRow1(), 0, MAX_ROW, "row1");
/* 222 */     checkRange(getRow2(), 0, MAX_ROW, "row2");
/*     */     
/* 224 */     setCol1(paramShort1);
/* 225 */     setRow1(paramInt1);
/* 226 */     setDx1(paramInt2);
/* 227 */     setDy1(paramInt3);
/* 228 */     setCol2(paramShort2);
/* 229 */     setRow2(paramInt4);
/* 230 */     setDx2(paramInt5);
/* 231 */     setDy2(paramInt6);
/*     */   }
/*     */   
/*     */   public boolean isHorizontallyFlipped() {
/* 235 */     return this._isHorizontallyFlipped;
/*     */   }
/*     */   
/*     */   public boolean isVerticallyFlipped() {
/* 239 */     return this._isVerticallyFlipped;
/*     */   }
/*     */ 
/*     */   
/*     */   protected EscherRecord getEscherAnchor() {
/* 244 */     return (EscherRecord)this._escherClientAnchor;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void createEscherAnchor() {
/* 249 */     this._escherClientAnchor = new EscherClientAnchorRecord();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClientAnchor.AnchorType getAnchorType() {
/* 259 */     return ClientAnchor.AnchorType.byId(this._escherClientAnchor.getFlag());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAnchorType(ClientAnchor.AnchorType paramAnchorType) {
/* 269 */     this._escherClientAnchor.setFlag(paramAnchorType.value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Removal(version = "3.17")
/*     */   public void setAnchorType(int paramInt) {
/* 279 */     this._escherClientAnchor.setFlag((short)paramInt);
/*     */   }
/*     */   
/*     */   private void checkRange(int paramInt1, int paramInt2, int paramInt3, String paramString) {
/* 283 */     if (paramInt1 < paramInt2 || paramInt1 > paramInt3) {
/* 284 */       throw new IllegalArgumentException(paramString + " must be between " + paramInt2 + " and " + paramInt3 + ", but was: " + paramInt1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int unsignedValue(short paramShort) {
/* 294 */     return (paramShort < 0) ? (65536 + paramShort) : paramShort;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 299 */     if (paramObject == null)
/* 300 */       return false; 
/* 301 */     if (paramObject == this)
/* 302 */       return true; 
/* 303 */     if (paramObject.getClass() != getClass())
/* 304 */       return false; 
/* 305 */     HSSFClientAnchor hSSFClientAnchor = (HSSFClientAnchor)paramObject;
/*     */     
/* 307 */     return (hSSFClientAnchor.getCol1() == getCol1() && hSSFClientAnchor.getCol2() == getCol2() && hSSFClientAnchor.getDx1() == getDx1() && hSSFClientAnchor.getDx2() == getDx2() && hSSFClientAnchor.getDy1() == getDy1() && hSSFClientAnchor.getDy2() == getDy2() && hSSFClientAnchor.getRow1() == getRow1() && hSSFClientAnchor.getRow2() == getRow2() && hSSFClientAnchor.getAnchorType() == getAnchorType());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 314 */     assert false : "hashCode not designed";
/* 315 */     return 42;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDx1() {
/* 320 */     return this._escherClientAnchor.getDx1();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDx1(int paramInt) {
/* 325 */     this._escherClientAnchor.setDx1(Integer.valueOf(paramInt).shortValue());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDy1() {
/* 330 */     return this._escherClientAnchor.getDy1();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDy1(int paramInt) {
/* 335 */     this._escherClientAnchor.setDy1(Integer.valueOf(paramInt).shortValue());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDy2() {
/* 340 */     return this._escherClientAnchor.getDy2();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDy2(int paramInt) {
/* 345 */     this._escherClientAnchor.setDy2(Integer.valueOf(paramInt).shortValue());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDx2() {
/* 350 */     return this._escherClientAnchor.getDx2();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDx2(int paramInt) {
/* 355 */     this._escherClientAnchor.setDx2(Integer.valueOf(paramInt).shortValue());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFClientAnchor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */