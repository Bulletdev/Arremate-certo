/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import org.apache.poi.ddf.EscherBoolProperty;
/*     */ import org.apache.poi.ddf.EscherChildAnchorRecord;
/*     */ import org.apache.poi.ddf.EscherClientAnchorRecord;
/*     */ import org.apache.poi.ddf.EscherContainerRecord;
/*     */ import org.apache.poi.ddf.EscherOptRecord;
/*     */ import org.apache.poi.ddf.EscherProperty;
/*     */ import org.apache.poi.ddf.EscherRGBProperty;
/*     */ import org.apache.poi.ddf.EscherRecord;
/*     */ import org.apache.poi.ddf.EscherSimpleProperty;
/*     */ import org.apache.poi.ddf.EscherSpRecord;
/*     */ import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
/*     */ import org.apache.poi.hssf.record.ObjRecord;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
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
/*     */ public abstract class HSSFShape
/*     */ {
/*  48 */   private static final POILogger LOG = POILogFactory.getLogger(HSSFShape.class);
/*     */   
/*     */   public static final int LINEWIDTH_ONE_PT = 12700;
/*     */   
/*     */   public static final int LINEWIDTH_DEFAULT = 9525;
/*     */   
/*     */   public static final int LINESTYLE__COLOR_DEFAULT = 134217792;
/*     */   
/*     */   public static final int FILL__FILLCOLOR_DEFAULT = 134217737;
/*     */   
/*     */   public static final boolean NO_FILL_DEFAULT = true;
/*     */   
/*     */   public static final int LINESTYLE_SOLID = 0;
/*     */   
/*     */   public static final int LINESTYLE_DASHSYS = 1;
/*     */   
/*     */   public static final int LINESTYLE_DOTSYS = 2;
/*     */   
/*     */   public static final int LINESTYLE_DASHDOTSYS = 3;
/*     */   
/*     */   public static final int LINESTYLE_DASHDOTDOTSYS = 4;
/*     */   
/*     */   public static final int LINESTYLE_DOTGEL = 5;
/*     */   
/*     */   public static final int LINESTYLE_DASHGEL = 6;
/*     */   public static final int LINESTYLE_LONGDASHGEL = 7;
/*     */   public static final int LINESTYLE_DASHDOTGEL = 8;
/*     */   public static final int LINESTYLE_LONGDASHDOTGEL = 9;
/*     */   public static final int LINESTYLE_LONGDASHDOTDOTGEL = 10;
/*     */   public static final int LINESTYLE_NONE = -1;
/*     */   public static final int LINESTYLE_DEFAULT = -1;
/*     */   private HSSFShape parent;
/*     */   HSSFAnchor anchor;
/*     */   private HSSFPatriarch _patriarch;
/*     */   private final EscherContainerRecord _escherContainer;
/*     */   private final ObjRecord _objRecord;
/*     */   private final EscherOptRecord _optRecord;
/*     */   public static final int NO_FILLHITTEST_TRUE = 1114112;
/*     */   public static final int NO_FILLHITTEST_FALSE = 65536;
/*     */   
/*     */   public HSSFShape(EscherContainerRecord paramEscherContainerRecord, ObjRecord paramObjRecord) {
/*  89 */     this._escherContainer = paramEscherContainerRecord;
/*  90 */     this._objRecord = paramObjRecord;
/*  91 */     this._optRecord = (EscherOptRecord)paramEscherContainerRecord.getChildById((short)-4085);
/*  92 */     this.anchor = HSSFAnchor.createAnchorFromEscher(paramEscherContainerRecord);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFShape(HSSFShape paramHSSFShape, HSSFAnchor paramHSSFAnchor) {
/*  99 */     this.parent = paramHSSFShape;
/* 100 */     this.anchor = paramHSSFAnchor;
/* 101 */     this._escherContainer = createSpContainer();
/* 102 */     this._optRecord = (EscherOptRecord)this._escherContainer.getChildById((short)-4085);
/* 103 */     this._objRecord = createObjRecord();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract EscherContainerRecord createSpContainer();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract ObjRecord createObjRecord();
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void afterRemove(HSSFPatriarch paramHSSFPatriarch);
/*     */ 
/*     */ 
/*     */   
/*     */   void setShapeId(int paramInt) {
/* 123 */     EscherSpRecord escherSpRecord = (EscherSpRecord)this._escherContainer.getChildById((short)-4086);
/* 124 */     escherSpRecord.setShapeId(paramInt);
/* 125 */     CommonObjectDataSubRecord commonObjectDataSubRecord = this._objRecord.getSubRecords().get(0);
/* 126 */     commonObjectDataSubRecord.setObjectId((short)(paramInt % 1024));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getShapeId() {
/* 133 */     return ((EscherSpRecord)this._escherContainer.getChildById((short)-4086)).getShapeId();
/*     */   }
/*     */   
/*     */   abstract void afterInsert(HSSFPatriarch paramHSSFPatriarch);
/*     */   
/*     */   protected EscherContainerRecord getEscherContainer() {
/* 139 */     return this._escherContainer;
/*     */   }
/*     */   
/*     */   protected ObjRecord getObjRecord() {
/* 143 */     return this._objRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EscherOptRecord getOptRecord() {
/* 152 */     return this._optRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFShape getParent() {
/* 159 */     return this.parent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFAnchor getAnchor() {
/* 166 */     return this.anchor;
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
/*     */   public void setAnchor(HSSFAnchor paramHSSFAnchor) {
/* 180 */     byte b = 0;
/* 181 */     short s = -1;
/* 182 */     if (this.parent == null) {
/* 183 */       if (paramHSSFAnchor instanceof HSSFChildAnchor)
/* 184 */         throw new IllegalArgumentException("Must use client anchors for shapes directly attached to sheet."); 
/* 185 */       EscherClientAnchorRecord escherClientAnchorRecord = (EscherClientAnchorRecord)this._escherContainer.getChildById((short)-4080);
/* 186 */       if (null != escherClientAnchorRecord) {
/* 187 */         for (b = 0; b < this._escherContainer.getChildRecords().size(); b++) {
/* 188 */           if (this._escherContainer.getChild(b).getRecordId() == -4080 && 
/* 189 */             b != this._escherContainer.getChildRecords().size() - 1) {
/* 190 */             s = this._escherContainer.getChild(b + 1).getRecordId();
/*     */           }
/*     */         } 
/*     */         
/* 194 */         this._escherContainer.removeChildRecord((EscherRecord)escherClientAnchorRecord);
/*     */       } 
/*     */     } else {
/* 197 */       if (paramHSSFAnchor instanceof HSSFClientAnchor)
/* 198 */         throw new IllegalArgumentException("Must use child anchors for shapes attached to groups."); 
/* 199 */       EscherChildAnchorRecord escherChildAnchorRecord = (EscherChildAnchorRecord)this._escherContainer.getChildById((short)-4081);
/* 200 */       if (null != escherChildAnchorRecord) {
/* 201 */         for (b = 0; b < this._escherContainer.getChildRecords().size(); b++) {
/* 202 */           if (this._escherContainer.getChild(b).getRecordId() == -4081 && 
/* 203 */             b != this._escherContainer.getChildRecords().size() - 1) {
/* 204 */             s = this._escherContainer.getChild(b + 1).getRecordId();
/*     */           }
/*     */         } 
/*     */         
/* 208 */         this._escherContainer.removeChildRecord((EscherRecord)escherChildAnchorRecord);
/*     */       } 
/*     */     } 
/* 211 */     if (-1 == s) {
/* 212 */       this._escherContainer.addChildRecord(paramHSSFAnchor.getEscherAnchor());
/*     */     } else {
/* 214 */       this._escherContainer.addChildBefore(paramHSSFAnchor.getEscherAnchor(), s);
/*     */     } 
/* 216 */     this.anchor = paramHSSFAnchor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLineStyleColor() {
/* 223 */     EscherRGBProperty escherRGBProperty = (EscherRGBProperty)this._optRecord.lookup(448);
/* 224 */     return (escherRGBProperty == null) ? 134217792 : escherRGBProperty.getRgbColor();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineStyleColor(int paramInt) {
/* 231 */     setPropertyValue((EscherProperty)new EscherRGBProperty((short)448, paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineStyleColor(int paramInt1, int paramInt2, int paramInt3) {
/* 238 */     int i = paramInt3 << 16 | paramInt2 << 8 | paramInt1;
/* 239 */     setPropertyValue((EscherProperty)new EscherRGBProperty((short)448, i));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFillColor() {
/* 246 */     EscherRGBProperty escherRGBProperty = (EscherRGBProperty)this._optRecord.lookup(385);
/* 247 */     return (escherRGBProperty == null) ? 134217737 : escherRGBProperty.getRgbColor();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFillColor(int paramInt) {
/* 254 */     setPropertyValue((EscherProperty)new EscherRGBProperty((short)385, paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFillColor(int paramInt1, int paramInt2, int paramInt3) {
/* 261 */     int i = paramInt3 << 16 | paramInt2 << 8 | paramInt1;
/* 262 */     setPropertyValue((EscherProperty)new EscherRGBProperty((short)385, i));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLineWidth() {
/* 269 */     EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty)this._optRecord.lookup(459);
/* 270 */     return (escherSimpleProperty == null) ? 9525 : escherSimpleProperty.getPropertyValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineWidth(int paramInt) {
/* 280 */     setPropertyValue((EscherProperty)new EscherSimpleProperty((short)459, paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLineStyle() {
/* 287 */     EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty)this._optRecord.lookup(462);
/* 288 */     if (null == escherSimpleProperty) {
/* 289 */       return -1;
/*     */     }
/* 291 */     return escherSimpleProperty.getPropertyValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineStyle(int paramInt) {
/* 300 */     setPropertyValue((EscherProperty)new EscherSimpleProperty((short)462, paramInt));
/* 301 */     if (getLineStyle() != 0) {
/* 302 */       setPropertyValue((EscherProperty)new EscherSimpleProperty((short)471, 0));
/* 303 */       if (getLineStyle() == -1) {
/* 304 */         setPropertyValue((EscherProperty)new EscherBoolProperty((short)511, 524288));
/*     */       } else {
/* 306 */         setPropertyValue((EscherProperty)new EscherBoolProperty((short)511, 524296));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isNoFill() {
/* 315 */     EscherBoolProperty escherBoolProperty = (EscherBoolProperty)this._optRecord.lookup(447);
/* 316 */     return (escherBoolProperty == null) ? true : ((escherBoolProperty.getPropertyValue() == 1114112));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoFill(boolean paramBoolean) {
/* 323 */     setPropertyValue((EscherProperty)new EscherBoolProperty((short)447, paramBoolean ? 1114112 : 65536));
/*     */   }
/*     */   
/*     */   protected void setPropertyValue(EscherProperty paramEscherProperty) {
/* 327 */     this._optRecord.setEscherProperty(paramEscherProperty);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFlipVertical(boolean paramBoolean) {
/* 334 */     EscherSpRecord escherSpRecord = (EscherSpRecord)getEscherContainer().getChildById((short)-4086);
/* 335 */     if (paramBoolean) {
/* 336 */       escherSpRecord.setFlags(escherSpRecord.getFlags() | 0x80);
/*     */     } else {
/* 338 */       escherSpRecord.setFlags(escherSpRecord.getFlags() & 0x7FFFFF7F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFlipHorizontal(boolean paramBoolean) {
/* 346 */     EscherSpRecord escherSpRecord = (EscherSpRecord)getEscherContainer().getChildById((short)-4086);
/* 347 */     if (paramBoolean) {
/* 348 */       escherSpRecord.setFlags(escherSpRecord.getFlags() | 0x40);
/*     */     } else {
/* 350 */       escherSpRecord.setFlags(escherSpRecord.getFlags() & 0x7FFFFFBF);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFlipVertical() {
/* 358 */     EscherSpRecord escherSpRecord = (EscherSpRecord)getEscherContainer().getChildById((short)-4086);
/* 359 */     return ((escherSpRecord.getFlags() & 0x80) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFlipHorizontal() {
/* 366 */     EscherSpRecord escherSpRecord = (EscherSpRecord)getEscherContainer().getChildById((short)-4086);
/* 367 */     return ((escherSpRecord.getFlags() & 0x40) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRotationDegree() {
/* 374 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 375 */     EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty)getOptRecord().lookup(4);
/* 376 */     if (null == escherSimpleProperty) {
/* 377 */       return 0;
/*     */     }
/*     */     try {
/* 380 */       LittleEndian.putInt(escherSimpleProperty.getPropertyValue(), byteArrayOutputStream);
/* 381 */       return LittleEndian.getShort(byteArrayOutputStream.toByteArray(), 2);
/* 382 */     } catch (IOException iOException) {
/* 383 */       LOG.log(7, new Object[] { "can't determine rotation degree", iOException });
/* 384 */       return 0;
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
/*     */   public void setRotationDegree(short paramShort) {
/* 397 */     setPropertyValue((EscherProperty)new EscherSimpleProperty((short)4, paramShort << 16));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int countOfAllChildren() {
/* 404 */     return 1;
/*     */   }
/*     */   
/*     */   protected abstract HSSFShape cloneShape();
/*     */   
/*     */   protected void setPatriarch(HSSFPatriarch paramHSSFPatriarch) {
/* 410 */     this._patriarch = paramHSSFPatriarch;
/*     */   }
/*     */   
/*     */   public HSSFPatriarch getPatriarch() {
/* 414 */     return this._patriarch;
/*     */   }
/*     */   
/*     */   protected void setParent(HSSFShape paramHSSFShape) {
/* 418 */     this.parent = paramHSSFShape;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */