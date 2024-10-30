/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.ss.usermodel.ClientAnchor;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.Removal;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;
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
/*     */ public final class XSSFClientAnchor
/*     */   extends XSSFAnchor
/*     */   implements ClientAnchor
/*     */ {
/*  32 */   private ClientAnchor.AnchorType DEFAULT_ANCHOR_TYPE = ClientAnchor.AnchorType.MOVE_AND_RESIZE;
/*     */ 
/*     */ 
/*     */   
/*     */   private ClientAnchor.AnchorType anchorType;
/*     */ 
/*     */ 
/*     */   
/*     */   private CTMarker cell1;
/*     */ 
/*     */ 
/*     */   
/*     */   private CTMarker cell2;
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFClientAnchor() {
/*  49 */     this.anchorType = this.DEFAULT_ANCHOR_TYPE;
/*  50 */     this.cell1 = CTMarker.Factory.newInstance();
/*  51 */     this.cell1.setCol(0);
/*  52 */     this.cell1.setColOff(0L);
/*  53 */     this.cell1.setRow(0);
/*  54 */     this.cell1.setRowOff(0L);
/*  55 */     this.cell2 = CTMarker.Factory.newInstance();
/*  56 */     this.cell2.setCol(0);
/*  57 */     this.cell2.setColOff(0L);
/*  58 */     this.cell2.setRow(0);
/*  59 */     this.cell2.setRowOff(0L);
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
/*     */   public XSSFClientAnchor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
/*  76 */     this();
/*  77 */     this.cell1.setCol(paramInt5);
/*  78 */     this.cell1.setColOff(paramInt1);
/*  79 */     this.cell1.setRow(paramInt6);
/*  80 */     this.cell1.setRowOff(paramInt2);
/*  81 */     this.cell2.setCol(paramInt7);
/*  82 */     this.cell2.setColOff(paramInt3);
/*  83 */     this.cell2.setRow(paramInt8);
/*  84 */     this.cell2.setRowOff(paramInt4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected XSSFClientAnchor(CTMarker paramCTMarker1, CTMarker paramCTMarker2) {
/*  94 */     this.anchorType = this.DEFAULT_ANCHOR_TYPE;
/*  95 */     this.cell1 = paramCTMarker1;
/*  96 */     this.cell2 = paramCTMarker2;
/*     */   }
/*     */   
/*     */   public short getCol1() {
/* 100 */     return (short)this.cell1.getCol();
/*     */   }
/*     */   
/*     */   public void setCol1(int paramInt) {
/* 104 */     this.cell1.setCol(paramInt);
/*     */   }
/*     */   
/*     */   public short getCol2() {
/* 108 */     return (short)this.cell2.getCol();
/*     */   }
/*     */   
/*     */   public void setCol2(int paramInt) {
/* 112 */     this.cell2.setCol(paramInt);
/*     */   }
/*     */   
/*     */   public int getRow1() {
/* 116 */     return this.cell1.getRow();
/*     */   }
/*     */   
/*     */   public void setRow1(int paramInt) {
/* 120 */     this.cell1.setRow(paramInt);
/*     */   }
/*     */   
/*     */   public int getRow2() {
/* 124 */     return this.cell2.getRow();
/*     */   }
/*     */   
/*     */   public void setRow2(int paramInt) {
/* 128 */     this.cell2.setRow(paramInt);
/*     */   }
/*     */   
/*     */   public int getDx1() {
/* 132 */     return (int)this.cell1.getColOff();
/*     */   }
/*     */   
/*     */   public void setDx1(int paramInt) {
/* 136 */     this.cell1.setColOff(paramInt);
/*     */   }
/*     */   
/*     */   public int getDy1() {
/* 140 */     return (int)this.cell1.getRowOff();
/*     */   }
/*     */   
/*     */   public void setDy1(int paramInt) {
/* 144 */     this.cell1.setRowOff(paramInt);
/*     */   }
/*     */   
/*     */   public int getDy2() {
/* 148 */     return (int)this.cell2.getRowOff();
/*     */   }
/*     */   
/*     */   public void setDy2(int paramInt) {
/* 152 */     this.cell2.setRowOff(paramInt);
/*     */   }
/*     */   
/*     */   public int getDx2() {
/* 156 */     return (int)this.cell2.getColOff();
/*     */   }
/*     */   
/*     */   public void setDx2(int paramInt) {
/* 160 */     this.cell2.setColOff(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 165 */     if (paramObject == null || !(paramObject instanceof XSSFClientAnchor)) return false;
/*     */     
/* 167 */     XSSFClientAnchor xSSFClientAnchor = (XSSFClientAnchor)paramObject;
/* 168 */     return (getDx1() == xSSFClientAnchor.getDx1() && getDx2() == xSSFClientAnchor.getDx2() && getDy1() == xSSFClientAnchor.getDy1() && getDy2() == xSSFClientAnchor.getDy2() && getCol1() == xSSFClientAnchor.getCol1() && getCol2() == xSSFClientAnchor.getCol2() && getRow1() == xSSFClientAnchor.getRow1() && getRow2() == xSSFClientAnchor.getRow2());
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
/*     */   public int hashCode() {
/* 181 */     assert false : "hashCode not designed";
/* 182 */     return 42;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 187 */     return "from : " + this.cell1.toString() + "; to: " + this.cell2.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTMarker getFrom() {
/* 197 */     return this.cell1;
/*     */   }
/*     */   
/*     */   protected void setFrom(CTMarker paramCTMarker) {
/* 201 */     this.cell1 = paramCTMarker;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTMarker getTo() {
/* 211 */     return this.cell2;
/*     */   }
/*     */   
/*     */   protected void setTo(CTMarker paramCTMarker) {
/* 215 */     this.cell2 = paramCTMarker;
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
/*     */   public void setAnchorType(ClientAnchor.AnchorType paramAnchorType) {
/* 227 */     this.anchorType = paramAnchorType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Removal(version = "3.17")
/*     */   public void setAnchorType(int paramInt) {
/* 238 */     this.anchorType = ClientAnchor.AnchorType.byId(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClientAnchor.AnchorType getAnchorType() {
/* 249 */     return this.anchorType;
/*     */   }
/*     */   
/*     */   public boolean isSet() {
/* 253 */     return (this.cell1.getCol() != 0 || this.cell2.getCol() != 0 || this.cell1.getRow() != 0 || this.cell2.getRow() != 0);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFClientAnchor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */