/*     */ package org.apache.poi.xdgf.usermodel;
/*     */ 
/*     */ import com.microsoft.schemas.office.visio.x2012.main.ConnectType;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XDGFConnection
/*     */ {
/*     */   public static final int visConnectFromError = -1;
/*     */   public static final int visFromNone = 0;
/*     */   public static final int visLeftEdge = 1;
/*     */   public static final int visCenterEdge = 2;
/*     */   public static final int visRightEdge = 3;
/*     */   public static final int visBottomEdge = 4;
/*     */   public static final int visMiddleEdge = 5;
/*     */   public static final int visTopEdge = 6;
/*     */   public static final int visBeginX = 7;
/*     */   public static final int visBeginY = 8;
/*     */   public static final int visBegin = 9;
/*     */   public static final int visEndX = 10;
/*     */   public static final int visEndY = 11;
/*     */   public static final int visEnd = 12;
/*     */   public static final int visFromAngle = 13;
/*     */   public static final int visFromPin = 14;
/*     */   public static final int visConnectToError = -1;
/*     */   public static final int visToNone = 0;
/*     */   public static final int visGuideX = 1;
/*     */   public static final int visGuideY = 2;
/*     */   public static final int visWholeShape = 3;
/*     */   public static final int visGuideIntersect = 4;
/*     */   public static final int visToAngle = 7;
/*     */   private ConnectType _connect;
/*     */   private XDGFShape _from;
/*     */   private XDGFShape _to;
/*     */   
/*     */   public XDGFConnection(ConnectType paramConnectType, XDGFShape paramXDGFShape1, XDGFShape paramXDGFShape2) {
/* 105 */     this._connect = paramConnectType;
/* 106 */     this._from = paramXDGFShape1;
/* 107 */     this._to = paramXDGFShape2;
/*     */   }
/*     */   
/*     */   public XDGFShape getFromShape() {
/* 111 */     return this._from;
/*     */   }
/*     */   
/*     */   public XDGFCell getFromCell() {
/* 115 */     return this._from.getCell(this._connect.getFromCell());
/*     */   }
/*     */   
/*     */   public String getFromCellName() {
/* 119 */     return this._connect.getFromCell();
/*     */   }
/*     */   
/*     */   public XDGFShape getToShape() {
/* 123 */     return this._to;
/*     */   }
/*     */   
/*     */   public String getToCellName() {
/* 127 */     return this._connect.getToCell();
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getFromPart() {
/* 132 */     if (this._connect.isSetFromPart()) {
/* 133 */       return Integer.valueOf(this._connect.getFromPart());
/*     */     }
/* 135 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getToPart() {
/* 144 */     if (this._connect.isSetToPart()) {
/* 145 */       return Integer.valueOf(this._connect.getToPart());
/*     */     }
/* 147 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\XDGFConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */