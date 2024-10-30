/*     */ package org.apache.poi.xdgf.usermodel;
/*     */ 
/*     */ import com.microsoft.schemas.office.visio.x2012.main.ShapeSheetType;
/*     */ import com.microsoft.schemas.office.visio.x2012.main.SheetType;
/*     */ import com.microsoft.schemas.office.visio.x2012.main.TextType;
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Stroke;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Path2D;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.xdgf.exceptions.XDGFException;
/*     */ import org.apache.poi.xdgf.usermodel.section.CombinedIterable;
/*     */ import org.apache.poi.xdgf.usermodel.section.GeometrySection;
/*     */ import org.apache.poi.xdgf.usermodel.section.XDGFSection;
/*     */ import org.apache.poi.xdgf.usermodel.shape.ShapeVisitor;
/*     */ import org.apache.poi.xdgf.usermodel.shape.exceptions.StopVisitingThisBranch;
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
/*     */ public class XDGFShape
/*     */   extends XDGFSheet
/*     */ {
/*     */   XDGFBaseContents _parentPage;
/*     */   XDGFShape _parent;
/*  52 */   XDGFMaster _master = null;
/*  53 */   XDGFShape _masterShape = null;
/*     */   
/*  55 */   XDGFText _text = null;
/*     */ 
/*     */   
/*  58 */   List<XDGFShape> _shapes = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   Double _pinX = null;
/*  64 */   Double _pinY = null;
/*     */   
/*  66 */   Double _width = null;
/*  67 */   Double _height = null;
/*     */ 
/*     */   
/*  70 */   Double _locPinX = null;
/*  71 */   Double _locPinY = null;
/*     */ 
/*     */ 
/*     */   
/*  75 */   Double _beginX = null;
/*  76 */   Double _beginY = null;
/*     */ 
/*     */ 
/*     */   
/*  80 */   Double _endX = null;
/*  81 */   Double _endY = null;
/*     */   
/*  83 */   Double _angle = null;
/*  84 */   Double _rotationXAngle = null;
/*  85 */   Double _rotationYAngle = null;
/*  86 */   Double _rotationZAngle = null;
/*     */ 
/*     */   
/*  89 */   Boolean _flipX = null;
/*  90 */   Boolean _flipY = null;
/*     */ 
/*     */   
/*  93 */   Double _txtPinX = null;
/*  94 */   Double _txtPinY = null;
/*     */ 
/*     */   
/*  97 */   Double _txtLocPinX = null;
/*  98 */   Double _txtLocPinY = null;
/*     */   
/* 100 */   Double _txtAngle = null;
/*     */   
/* 102 */   Double _txtWidth = null;
/* 103 */   Double _txtHeight = null;
/*     */ 
/*     */   
/*     */   public XDGFShape(ShapeSheetType paramShapeSheetType, XDGFBaseContents paramXDGFBaseContents, XDGFDocument paramXDGFDocument) {
/* 107 */     this((XDGFShape)null, paramShapeSheetType, paramXDGFBaseContents, paramXDGFDocument);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public XDGFShape(XDGFShape paramXDGFShape, ShapeSheetType paramShapeSheetType, XDGFBaseContents paramXDGFBaseContents, XDGFDocument paramXDGFDocument) {
/* 113 */     super((SheetType)paramShapeSheetType, paramXDGFDocument);
/*     */     
/* 115 */     this._parent = paramXDGFShape;
/* 116 */     this._parentPage = paramXDGFBaseContents;
/*     */     
/* 118 */     TextType textType = paramShapeSheetType.getText();
/* 119 */     if (textType != null) {
/* 120 */       this._text = new XDGFText(textType, this);
/*     */     }
/* 122 */     if (paramShapeSheetType.isSetShapes()) {
/* 123 */       this._shapes = new ArrayList<XDGFShape>();
/* 124 */       for (ShapeSheetType shapeSheetType : paramShapeSheetType.getShapes().getShapeArray()) {
/* 125 */         this._shapes.add(new XDGFShape(this, shapeSheetType, paramXDGFBaseContents, paramXDGFDocument));
/*     */       }
/*     */     } 
/* 128 */     readProperties();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 133 */     if (this._parentPage instanceof XDGFMasterContents) {
/* 134 */       return this._parentPage + ": <Shape ID=\"" + getID() + "\">";
/*     */     }
/* 136 */     return "<Shape ID=\"" + getID() + "\">";
/*     */   }
/*     */ 
/*     */   
/*     */   protected void readProperties() {
/* 141 */     this._pinX = XDGFCell.maybeGetDouble(this._cells, "PinX");
/* 142 */     this._pinY = XDGFCell.maybeGetDouble(this._cells, "PinY");
/* 143 */     this._width = XDGFCell.maybeGetDouble(this._cells, "Width");
/* 144 */     this._height = XDGFCell.maybeGetDouble(this._cells, "Height");
/* 145 */     this._locPinX = XDGFCell.maybeGetDouble(this._cells, "LocPinX");
/* 146 */     this._locPinY = XDGFCell.maybeGetDouble(this._cells, "LocPinY");
/* 147 */     this._beginX = XDGFCell.maybeGetDouble(this._cells, "BeginX");
/* 148 */     this._beginY = XDGFCell.maybeGetDouble(this._cells, "BeginY");
/* 149 */     this._endX = XDGFCell.maybeGetDouble(this._cells, "EndX");
/* 150 */     this._endY = XDGFCell.maybeGetDouble(this._cells, "EndY");
/*     */     
/* 152 */     this._angle = XDGFCell.maybeGetDouble(this._cells, "Angle");
/* 153 */     this._rotationXAngle = XDGFCell.maybeGetDouble(this._cells, "RotationXAngle");
/* 154 */     this._rotationYAngle = XDGFCell.maybeGetDouble(this._cells, "RotationYAngle");
/* 155 */     this._rotationZAngle = XDGFCell.maybeGetDouble(this._cells, "RotationZAngle");
/*     */     
/* 157 */     this._flipX = XDGFCell.maybeGetBoolean(this._cells, "FlipX");
/* 158 */     this._flipY = XDGFCell.maybeGetBoolean(this._cells, "FlipY");
/*     */     
/* 160 */     this._txtPinX = XDGFCell.maybeGetDouble(this._cells, "TxtPinX");
/* 161 */     this._txtPinY = XDGFCell.maybeGetDouble(this._cells, "TxtPinY");
/* 162 */     this._txtLocPinX = XDGFCell.maybeGetDouble(this._cells, "TxtLocPinX");
/* 163 */     this._txtLocPinY = XDGFCell.maybeGetDouble(this._cells, "TxtLocPinY");
/* 164 */     this._txtWidth = XDGFCell.maybeGetDouble(this._cells, "TxtWidth");
/* 165 */     this._txtHeight = XDGFCell.maybeGetDouble(this._cells, "TxtHeight");
/*     */     
/* 167 */     this._txtAngle = XDGFCell.maybeGetDouble(this._cells, "TxtAngle");
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
/*     */   protected void setupMaster(XDGFPageContents paramXDGFPageContents, XDGFMasterContents paramXDGFMasterContents) {
/* 180 */     ShapeSheetType shapeSheetType = getXmlObject();
/*     */     
/* 182 */     if (shapeSheetType.isSetMaster()) {
/* 183 */       this._master = paramXDGFPageContents.getMasterById(shapeSheetType.getMaster());
/* 184 */       if (this._master == null) {
/* 185 */         throw XDGFException.error("refers to non-existant master " + shapeSheetType.getMaster(), this);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 196 */       List<XDGFShape> list = this._master.getContent().getTopLevelShapes();
/*     */ 
/*     */       
/* 199 */       switch (list.size()) {
/*     */         case 0:
/* 201 */           throw XDGFException.error("Could not retrieve master shape from " + this._master, this);
/*     */ 
/*     */         
/*     */         case 1:
/* 205 */           this._masterShape = list.iterator().next();
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */     
/* 211 */     } else if (shapeSheetType.isSetMasterShape()) {
/* 212 */       this._masterShape = paramXDGFMasterContents.getShapeById(shapeSheetType.getMasterShape());
/* 213 */       if (this._masterShape == null) {
/* 214 */         throw XDGFException.error("refers to non-existant master shape " + shapeSheetType.getMasterShape(), this);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 220 */     setupSectionMasters();
/*     */     
/* 222 */     if (this._shapes != null) {
/* 223 */       for (XDGFShape xDGFShape : this._shapes) {
/* 224 */         xDGFShape.setupMaster(paramXDGFPageContents, (this._master == null) ? paramXDGFMasterContents : this._master.getContent());
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setupSectionMasters() {
/* 232 */     if (this._masterShape == null) {
/*     */       return;
/*     */     }
/*     */     try {
/* 236 */       for (Map.Entry<String, XDGFSection> entry : this._sections.entrySet()) {
/* 237 */         XDGFSection xDGFSection = this._masterShape.getSection((String)entry.getKey());
/* 238 */         if (xDGFSection != null) {
/* 239 */           ((XDGFSection)entry.getValue()).setupMaster(xDGFSection);
/*     */         }
/*     */       } 
/* 242 */       for (Map.Entry<Long, GeometrySection> entry : this._geometry.entrySet()) {
/* 243 */         GeometrySection geometrySection = this._masterShape.getGeometryByIdx(((Long)entry.getKey()).longValue());
/*     */         
/* 245 */         if (geometrySection != null)
/* 246 */           ((GeometrySection)entry.getValue()).setupMaster((XDGFSection)geometrySection); 
/*     */       } 
/* 248 */     } catch (POIXMLException pOIXMLException) {
/* 249 */       throw XDGFException.wrap(toString(), pOIXMLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public ShapeSheetType getXmlObject() {
/* 256 */     return (ShapeSheetType)this._sheet;
/*     */   }
/*     */   
/*     */   public long getID() {
/* 260 */     return getXmlObject().getID();
/*     */   }
/*     */   
/*     */   public String getType() {
/* 264 */     return getXmlObject().getType();
/*     */   }
/*     */   
/*     */   public String getTextAsString() {
/* 268 */     XDGFText xDGFText = getText();
/* 269 */     if (xDGFText == null) {
/* 270 */       return "";
/*     */     }
/* 272 */     return xDGFText.getTextContent();
/*     */   }
/*     */   
/*     */   public boolean hasText() {
/* 276 */     return (this._text != null || (this._masterShape != null && this._masterShape._text != null));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public XDGFCell getCell(String paramString) {
/* 282 */     XDGFCell xDGFCell = super.getCell(paramString);
/*     */ 
/*     */     
/* 285 */     if (xDGFCell == null && this._masterShape != null) {
/* 286 */       xDGFCell = this._masterShape.getCell(paramString);
/*     */     }
/*     */     
/* 289 */     return xDGFCell;
/*     */   }
/*     */   
/*     */   public GeometrySection getGeometryByIdx(long paramLong) {
/* 293 */     return this._geometry.get(Long.valueOf(paramLong));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<XDGFShape> getShapes() {
/* 301 */     return this._shapes;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 306 */     String str = getXmlObject().getName();
/* 307 */     if (str == null)
/* 308 */       return ""; 
/* 309 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getShapeType() {
/* 314 */     String str = getXmlObject().getType();
/* 315 */     if (str == null)
/* 316 */       return ""; 
/* 317 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSymbolName() {
/* 323 */     if (this._master == null) {
/* 324 */       return "";
/*     */     }
/* 326 */     String str = this._master.getName();
/* 327 */     if (str == null) {
/* 328 */       return "";
/*     */     }
/* 330 */     return str;
/*     */   }
/*     */   
/*     */   public XDGFShape getMasterShape() {
/* 334 */     return this._masterShape;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XDGFShape getParentShape() {
/* 341 */     return this._parent;
/*     */   }
/*     */   
/*     */   public XDGFShape getTopmostParentShape() {
/* 345 */     XDGFShape xDGFShape = null;
/* 346 */     if (this._parent != null) {
/* 347 */       xDGFShape = this._parent.getTopmostParentShape();
/* 348 */       if (xDGFShape == null) {
/* 349 */         xDGFShape = this._parent;
/*     */       }
/*     */     } 
/* 352 */     return xDGFShape;
/*     */   }
/*     */   
/*     */   public boolean hasMaster() {
/* 356 */     return (this._master != null);
/*     */   }
/*     */   
/*     */   public boolean hasMasterShape() {
/* 360 */     return (this._masterShape != null);
/*     */   }
/*     */   
/*     */   public boolean hasParent() {
/* 364 */     return (this._parent != null);
/*     */   }
/*     */   
/*     */   public boolean hasShapes() {
/* 368 */     return (this._shapes != null);
/*     */   }
/*     */   
/*     */   public boolean isTopmost() {
/* 372 */     return (this._parent == null);
/*     */   }
/*     */   
/*     */   public boolean isShape1D() {
/* 376 */     return (getBeginX() != null);
/*     */   }
/*     */   
/*     */   public boolean isDeleted() {
/* 380 */     return getXmlObject().isSetDel() ? getXmlObject().getDel() : false;
/*     */   }
/*     */   
/*     */   public XDGFText getText() {
/* 384 */     if (this._text == null && this._masterShape != null) {
/* 385 */       return this._masterShape.getText();
/*     */     }
/* 387 */     return this._text;
/*     */   }
/*     */   
/*     */   public Double getPinX() {
/* 391 */     if (this._pinX == null && this._masterShape != null) {
/* 392 */       return this._masterShape.getPinX();
/*     */     }
/* 394 */     if (this._pinX == null) {
/* 395 */       throw XDGFException.error("PinX not set!", this);
/*     */     }
/* 397 */     return this._pinX;
/*     */   }
/*     */   
/*     */   public Double getPinY() {
/* 401 */     if (this._pinY == null && this._masterShape != null) {
/* 402 */       return this._masterShape.getPinY();
/*     */     }
/* 404 */     if (this._pinY == null) {
/* 405 */       throw XDGFException.error("PinY not specified!", this);
/*     */     }
/* 407 */     return this._pinY;
/*     */   }
/*     */   
/*     */   public Double getWidth() {
/* 411 */     if (this._width == null && this._masterShape != null) {
/* 412 */       return this._masterShape.getWidth();
/*     */     }
/* 414 */     if (this._width == null) {
/* 415 */       throw XDGFException.error("Width not specified!", this);
/*     */     }
/* 417 */     return this._width;
/*     */   }
/*     */   
/*     */   public Double getHeight() {
/* 421 */     if (this._height == null && this._masterShape != null) {
/* 422 */       return this._masterShape.getHeight();
/*     */     }
/* 424 */     if (this._height == null) {
/* 425 */       throw XDGFException.error("Height not specified!", this);
/*     */     }
/* 427 */     return this._height;
/*     */   }
/*     */   
/*     */   public Double getLocPinX() {
/* 431 */     if (this._locPinX == null && this._masterShape != null) {
/* 432 */       return this._masterShape.getLocPinX();
/*     */     }
/* 434 */     if (this._locPinX == null) {
/* 435 */       throw XDGFException.error("LocPinX not specified!", this);
/*     */     }
/* 437 */     return this._locPinX;
/*     */   }
/*     */   
/*     */   public Double getLocPinY() {
/* 441 */     if (this._locPinY == null && this._masterShape != null) {
/* 442 */       return this._masterShape.getLocPinY();
/*     */     }
/* 444 */     if (this._locPinY == null) {
/* 445 */       throw XDGFException.error("LocPinY not specified!", this);
/*     */     }
/* 447 */     return this._locPinY;
/*     */   }
/*     */   
/*     */   public Double getBeginX() {
/* 451 */     if (this._beginX == null && this._masterShape != null) {
/* 452 */       return this._masterShape.getBeginX();
/*     */     }
/* 454 */     return this._beginX;
/*     */   }
/*     */   
/*     */   public Double getBeginY() {
/* 458 */     if (this._beginY == null && this._masterShape != null) {
/* 459 */       return this._masterShape.getBeginY();
/*     */     }
/* 461 */     return this._beginY;
/*     */   }
/*     */   
/*     */   public Double getEndX() {
/* 465 */     if (this._endX == null && this._masterShape != null) {
/* 466 */       return this._masterShape.getEndX();
/*     */     }
/* 468 */     return this._endX;
/*     */   }
/*     */   
/*     */   public Double getEndY() {
/* 472 */     if (this._endY == null && this._masterShape != null) {
/* 473 */       return this._masterShape.getEndY();
/*     */     }
/* 475 */     return this._endY;
/*     */   }
/*     */   
/*     */   public Double getAngle() {
/* 479 */     if (this._angle == null && this._masterShape != null) {
/* 480 */       return this._masterShape.getAngle();
/*     */     }
/* 482 */     return this._angle;
/*     */   }
/*     */   
/*     */   public Boolean getFlipX() {
/* 486 */     if (this._flipX == null && this._masterShape != null) {
/* 487 */       return this._masterShape.getFlipX();
/*     */     }
/* 489 */     return this._flipX;
/*     */   }
/*     */   
/*     */   public Boolean getFlipY() {
/* 493 */     if (this._flipY == null && this._masterShape != null) {
/* 494 */       return this._masterShape.getFlipY();
/*     */     }
/* 496 */     return this._flipY;
/*     */   }
/*     */   
/*     */   public Double getTxtPinX() {
/* 500 */     if (this._txtPinX == null && this._masterShape != null && this._masterShape._txtPinX != null)
/*     */     {
/* 502 */       return this._masterShape._txtPinX;
/*     */     }
/* 504 */     if (this._txtPinX == null) {
/* 505 */       return Double.valueOf(getWidth().doubleValue() * 0.5D);
/*     */     }
/* 507 */     return this._txtPinX;
/*     */   }
/*     */   
/*     */   public Double getTxtPinY() {
/* 511 */     if (this._txtLocPinY == null && this._masterShape != null && this._masterShape._txtLocPinY != null)
/*     */     {
/* 513 */       return this._masterShape._txtLocPinY;
/*     */     }
/* 515 */     if (this._txtPinY == null) {
/* 516 */       return Double.valueOf(getHeight().doubleValue() * 0.5D);
/*     */     }
/* 518 */     return this._txtPinY;
/*     */   }
/*     */   
/*     */   public Double getTxtLocPinX() {
/* 522 */     if (this._txtLocPinX == null && this._masterShape != null && this._masterShape._txtLocPinX != null)
/*     */     {
/* 524 */       return this._masterShape._txtLocPinX;
/*     */     }
/* 526 */     if (this._txtLocPinX == null) {
/* 527 */       return Double.valueOf(getTxtWidth().doubleValue() * 0.5D);
/*     */     }
/* 529 */     return this._txtLocPinX;
/*     */   }
/*     */   
/*     */   public Double getTxtLocPinY() {
/* 533 */     if (this._txtLocPinY == null && this._masterShape != null && this._masterShape._txtLocPinY != null)
/*     */     {
/* 535 */       return this._masterShape._txtLocPinY;
/*     */     }
/* 537 */     if (this._txtLocPinY == null) {
/* 538 */       return Double.valueOf(getTxtHeight().doubleValue() * 0.5D);
/*     */     }
/* 540 */     return this._txtLocPinY;
/*     */   }
/*     */   
/*     */   public Double getTxtAngle() {
/* 544 */     if (this._txtAngle == null && this._masterShape != null) {
/* 545 */       return this._masterShape.getTxtAngle();
/*     */     }
/* 547 */     return this._txtAngle;
/*     */   }
/*     */   
/*     */   public Double getTxtWidth() {
/* 551 */     if (this._txtWidth == null && this._masterShape != null && this._masterShape._txtWidth != null)
/*     */     {
/* 553 */       return this._masterShape._txtWidth;
/*     */     }
/* 555 */     if (this._txtWidth == null) {
/* 556 */       return getWidth();
/*     */     }
/* 558 */     return this._txtWidth;
/*     */   }
/*     */   
/*     */   public Double getTxtHeight() {
/* 562 */     if (this._txtHeight == null && this._masterShape != null && this._masterShape._txtHeight != null)
/*     */     {
/* 564 */       return this._masterShape._txtHeight;
/*     */     }
/* 566 */     if (this._txtHeight == null) {
/* 567 */       return getHeight();
/*     */     }
/* 569 */     return this._txtHeight;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getLineCap() {
/* 575 */     Integer integer = super.getLineCap();
/* 576 */     if (integer != null) {
/* 577 */       return integer;
/*     */     }
/*     */     
/* 580 */     if (this._masterShape != null) {
/* 581 */       return this._masterShape.getLineCap();
/*     */     }
/*     */ 
/*     */     
/* 585 */     return this._document.getDefaultLineStyle().getLineCap();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getLineColor() {
/* 591 */     Color color = super.getLineColor();
/* 592 */     if (color != null) {
/* 593 */       return color;
/*     */     }
/*     */     
/* 596 */     if (this._masterShape != null) {
/* 597 */       return this._masterShape.getLineColor();
/*     */     }
/*     */ 
/*     */     
/* 601 */     return this._document.getDefaultLineStyle().getLineColor();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getLinePattern() {
/* 607 */     Integer integer = super.getLinePattern();
/* 608 */     if (integer != null) {
/* 609 */       return integer;
/*     */     }
/*     */     
/* 612 */     if (this._masterShape != null) {
/* 613 */       return this._masterShape.getLinePattern();
/*     */     }
/*     */ 
/*     */     
/* 617 */     return this._document.getDefaultLineStyle().getLinePattern();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Double getLineWeight() {
/* 623 */     Double double_ = super.getLineWeight();
/* 624 */     if (double_ != null) {
/* 625 */       return double_;
/*     */     }
/*     */     
/* 628 */     if (this._masterShape != null) {
/* 629 */       return this._masterShape.getLineWeight();
/*     */     }
/*     */ 
/*     */     
/* 633 */     return this._document.getDefaultLineStyle().getLineWeight();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getFontColor() {
/* 639 */     Color color = super.getFontColor();
/* 640 */     if (color != null) {
/* 641 */       return color;
/*     */     }
/*     */     
/* 644 */     if (this._masterShape != null) {
/* 645 */       return this._masterShape.getFontColor();
/*     */     }
/*     */ 
/*     */     
/* 649 */     return this._document.getDefaultTextStyle().getFontColor();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Double getFontSize() {
/* 655 */     Double double_ = super.getFontSize();
/* 656 */     if (double_ != null) {
/* 657 */       return double_;
/*     */     }
/*     */     
/* 660 */     if (this._masterShape != null) {
/* 661 */       return this._masterShape.getFontSize();
/*     */     }
/*     */ 
/*     */     
/* 665 */     return this._document.getDefaultTextStyle().getFontSize();
/*     */   }
/*     */   
/*     */   public Stroke getStroke() {
/*     */     byte b;
/* 670 */     float f1 = getLineWeight().floatValue();
/*     */     
/* 672 */     boolean bool = false;
/* 673 */     float f2 = 10.0F;
/*     */     
/* 675 */     switch (getLineCap().intValue()) {
/*     */       case 0:
/* 677 */         b = 1;
/*     */         break;
/*     */       case 1:
/* 680 */         b = 2;
/*     */         break;
/*     */       case 2:
/* 683 */         b = 0;
/*     */         break;
/*     */       default:
/* 686 */         throw new POIXMLException("Invalid line cap specified");
/*     */     } 
/*     */     
/* 689 */     float[] arrayOfFloat = null;
/*     */ 
/*     */     
/* 692 */     switch (getLinePattern().intValue()) {
/*     */       case 0:
/*     */       case 1:
/*     */         break;
/*     */       
/*     */       case 2:
/* 698 */         arrayOfFloat = new float[] { 5.0F, 3.0F };
/*     */         break;
/*     */       case 3:
/* 701 */         arrayOfFloat = new float[] { 1.0F, 4.0F };
/*     */         break;
/*     */       case 4:
/* 704 */         arrayOfFloat = new float[] { 6.0F, 3.0F, 1.0F, 3.0F };
/*     */         break;
/*     */       case 5:
/* 707 */         arrayOfFloat = new float[] { 6.0F, 3.0F, 1.0F, 3.0F, 1.0F, 3.0F };
/*     */         break;
/*     */       case 6:
/* 710 */         arrayOfFloat = new float[] { 1.0F, 3.0F, 6.0F, 3.0F, 6.0F, 3.0F };
/*     */         break;
/*     */       case 7:
/* 713 */         arrayOfFloat = new float[] { 15.0F, 3.0F, 6.0F, 3.0F };
/*     */         break;
/*     */       case 8:
/* 716 */         arrayOfFloat = new float[] { 6.0F, 3.0F, 6.0F, 3.0F };
/*     */         break;
/*     */       case 9:
/* 719 */         arrayOfFloat = new float[] { 3.0F, 2.0F };
/*     */         break;
/*     */       case 10:
/* 722 */         arrayOfFloat = new float[] { 1.0F, 2.0F };
/*     */         break;
/*     */       case 11:
/* 725 */         arrayOfFloat = new float[] { 3.0F, 2.0F, 1.0F, 2.0F };
/*     */         break;
/*     */       case 12:
/* 728 */         arrayOfFloat = new float[] { 3.0F, 2.0F, 1.0F, 2.0F, 1.0F };
/*     */         break;
/*     */       case 13:
/* 731 */         arrayOfFloat = new float[] { 1.0F, 2.0F, 3.0F, 2.0F, 3.0F, 2.0F };
/*     */         break;
/*     */       case 14:
/* 734 */         arrayOfFloat = new float[] { 3.0F, 2.0F, 7.0F, 2.0F };
/*     */         break;
/*     */       case 15:
/* 737 */         arrayOfFloat = new float[] { 7.0F, 2.0F, 3.0F, 2.0F, 3.0F, 2.0F };
/*     */         break;
/*     */       case 16:
/* 740 */         arrayOfFloat = new float[] { 12.0F, 6.0F };
/*     */         break;
/*     */       case 17:
/* 743 */         arrayOfFloat = new float[] { 1.0F, 6.0F };
/*     */         break;
/*     */       case 18:
/* 746 */         arrayOfFloat = new float[] { 1.0F, 6.0F, 12.0F, 6.0F };
/*     */         break;
/*     */       case 19:
/* 749 */         arrayOfFloat = new float[] { 1.0F, 6.0F, 1.0F, 6.0F, 12.0F, 6.0F };
/*     */         break;
/*     */       case 20:
/* 752 */         arrayOfFloat = new float[] { 1.0F, 6.0F, 12.0F, 6.0F, 12.0F, 6.0F };
/*     */         break;
/*     */       case 21:
/* 755 */         arrayOfFloat = new float[] { 30.0F, 6.0F, 12.0F, 6.0F };
/*     */         break;
/*     */       case 22:
/* 758 */         arrayOfFloat = new float[] { 30.0F, 6.0F, 12.0F, 6.0F, 12.0F, 6.0F };
/*     */         break;
/*     */       case 23:
/* 761 */         arrayOfFloat = new float[] { 1.0F };
/*     */         break;
/*     */       case 254:
/* 764 */         throw new POIXMLException("Unsupported line pattern value");
/*     */       default:
/* 766 */         throw new POIXMLException("Invalid line pattern value");
/*     */     } 
/*     */ 
/*     */     
/* 770 */     if (arrayOfFloat != null) {
/* 771 */       for (byte b1 = 0; b1 < arrayOfFloat.length; b1++) {
/* 772 */         arrayOfFloat[b1] = arrayOfFloat[b1] * f1;
/*     */       }
/*     */     }
/*     */     
/* 776 */     return new BasicStroke(f1, b, bool, f2, arrayOfFloat, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterable<GeometrySection> getGeometrySections() {
/* 784 */     return (Iterable<GeometrySection>)new CombinedIterable(this._geometry, (this._masterShape != null) ? this._masterShape._geometry : null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle2D.Double getBounds() {
/* 792 */     return new Rectangle2D.Double(0.0D, 0.0D, getWidth().doubleValue(), getHeight().doubleValue());
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
/*     */   public Path2D.Double getBoundsAsPath() {
/* 804 */     Double double_1 = getWidth();
/* 805 */     Double double_2 = getHeight();
/*     */     
/* 807 */     Path2D.Double double_ = new Path2D.Double();
/* 808 */     double_.moveTo(0.0D, 0.0D);
/* 809 */     double_.lineTo(double_1.doubleValue(), 0.0D);
/* 810 */     double_.lineTo(double_1.doubleValue(), double_2.doubleValue());
/* 811 */     double_.lineTo(0.0D, double_2.doubleValue());
/* 812 */     double_.lineTo(0.0D, 0.0D);
/*     */     
/* 814 */     return double_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Path2D.Double getPath() {
/* 821 */     for (GeometrySection geometrySection : getGeometrySections()) {
/* 822 */       if (geometrySection.getNoShow().booleanValue() == true) {
/*     */         continue;
/*     */       }
/* 825 */       return geometrySection.getPath(this);
/*     */     } 
/*     */     
/* 828 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasGeometry() {
/* 835 */     for (GeometrySection geometrySection : getGeometrySections()) {
/* 836 */       if (!geometrySection.getNoShow().booleanValue())
/* 837 */         return true; 
/*     */     } 
/* 839 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AffineTransform getParentTransform() {
/* 848 */     AffineTransform affineTransform = new AffineTransform();
/*     */     
/* 850 */     Double double_1 = getLocPinX();
/* 851 */     Double double_2 = getLocPinY();
/* 852 */     Boolean bool1 = getFlipX();
/* 853 */     Boolean bool2 = getFlipY();
/* 854 */     Double double_3 = getAngle();
/*     */     
/* 856 */     affineTransform.translate(-double_1.doubleValue(), -double_2.doubleValue());
/*     */     
/* 858 */     affineTransform.translate(getPinX().doubleValue(), getPinY().doubleValue());
/*     */ 
/*     */     
/* 861 */     if (double_3 != null && Math.abs(double_3.doubleValue()) > 0.001D) {
/* 862 */       affineTransform.rotate(double_3.doubleValue(), double_1.doubleValue(), double_2.doubleValue());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 867 */     if (bool1 != null && bool1.booleanValue()) {
/* 868 */       affineTransform.scale(-1.0D, 1.0D);
/* 869 */       affineTransform.translate(-getWidth().doubleValue(), 0.0D);
/*     */     } 
/*     */     
/* 872 */     if (bool2 != null && bool2.booleanValue()) {
/* 873 */       affineTransform.scale(1.0D, -1.0D);
/* 874 */       affineTransform.translate(0.0D, -getHeight().doubleValue());
/*     */     } 
/*     */     
/* 877 */     return affineTransform;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitShapes(ShapeVisitor paramShapeVisitor, AffineTransform paramAffineTransform, int paramInt) {
/* 888 */     paramAffineTransform = (AffineTransform)paramAffineTransform.clone();
/* 889 */     paramAffineTransform.concatenate(getParentTransform());
/*     */     
/*     */     try {
/* 892 */       if (paramShapeVisitor.accept(this)) {
/* 893 */         paramShapeVisitor.visit(this, paramAffineTransform, paramInt);
/*     */       }
/* 895 */       if (this._shapes != null) {
/* 896 */         for (XDGFShape xDGFShape : this._shapes) {
/* 897 */           xDGFShape.visitShapes(paramShapeVisitor, paramAffineTransform, paramInt + 1);
/*     */         }
/*     */       }
/* 900 */     } catch (StopVisitingThisBranch stopVisitingThisBranch) {
/*     */     
/* 902 */     } catch (POIXMLException pOIXMLException) {
/* 903 */       throw XDGFException.wrap(toString(), pOIXMLException);
/*     */     } 
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
/*     */   public void visitShapes(ShapeVisitor paramShapeVisitor, int paramInt) {
/*     */     try {
/* 917 */       if (paramShapeVisitor.accept(this)) {
/* 918 */         paramShapeVisitor.visit(this, null, paramInt);
/*     */       }
/* 920 */       if (this._shapes != null) {
/* 921 */         for (XDGFShape xDGFShape : this._shapes) {
/* 922 */           xDGFShape.visitShapes(paramShapeVisitor, paramInt + 1);
/*     */         }
/*     */       }
/* 925 */     } catch (StopVisitingThisBranch stopVisitingThisBranch) {
/*     */     
/* 927 */     } catch (POIXMLException pOIXMLException) {
/* 928 */       throw XDGFException.wrap(toString(), pOIXMLException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\XDGFShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */