/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.poi.ddf.DefaultEscherRecordFactory;
/*     */ import org.apache.poi.ddf.EscherBoolProperty;
/*     */ import org.apache.poi.ddf.EscherChildAnchorRecord;
/*     */ import org.apache.poi.ddf.EscherClientAnchorRecord;
/*     */ import org.apache.poi.ddf.EscherClientDataRecord;
/*     */ import org.apache.poi.ddf.EscherContainerRecord;
/*     */ import org.apache.poi.ddf.EscherOptRecord;
/*     */ import org.apache.poi.ddf.EscherProperty;
/*     */ import org.apache.poi.ddf.EscherRecord;
/*     */ import org.apache.poi.ddf.EscherRecordFactory;
/*     */ import org.apache.poi.ddf.EscherSpRecord;
/*     */ import org.apache.poi.ddf.EscherSpgrRecord;
/*     */ import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
/*     */ import org.apache.poi.hssf.record.EndSubRecord;
/*     */ import org.apache.poi.hssf.record.EscherAggregate;
/*     */ import org.apache.poi.hssf.record.GroupMarkerSubRecord;
/*     */ import org.apache.poi.hssf.record.ObjRecord;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.hssf.record.SubRecord;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HSSFShapeGroup
/*     */   extends HSSFShape
/*     */   implements HSSFShapeContainer
/*     */ {
/*  33 */   private final List<HSSFShape> shapes = new ArrayList<HSSFShape>();
/*     */   private EscherSpgrRecord _spgrRecord;
/*     */   
/*     */   public HSSFShapeGroup(EscherContainerRecord paramEscherContainerRecord, ObjRecord paramObjRecord) {
/*  37 */     super(paramEscherContainerRecord, paramObjRecord);
/*     */ 
/*     */     
/*  40 */     EscherContainerRecord escherContainerRecord = paramEscherContainerRecord.getChildContainers().get(0);
/*  41 */     this._spgrRecord = (EscherSpgrRecord)escherContainerRecord.getChild(0);
/*  42 */     for (EscherRecord escherRecord : escherContainerRecord.getChildRecords()) {
/*  43 */       switch (escherRecord.getRecordId()) {
/*     */ 
/*     */         
/*     */         case -4080:
/*  47 */           this.anchor = new HSSFClientAnchor((EscherClientAnchorRecord)escherRecord);
/*     */         
/*     */         case -4081:
/*  50 */           this.anchor = new HSSFChildAnchor((EscherChildAnchorRecord)escherRecord);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFShapeGroup(HSSFShape paramHSSFShape, HSSFAnchor paramHSSFAnchor) {
/*  59 */     super(paramHSSFShape, paramHSSFAnchor);
/*  60 */     this._spgrRecord = (EscherSpgrRecord)((EscherContainerRecord)getEscherContainer().getChild(0)).getChildById((short)-4087);
/*     */   }
/*     */ 
/*     */   
/*     */   protected EscherContainerRecord createSpContainer() {
/*  65 */     EscherContainerRecord escherContainerRecord1 = new EscherContainerRecord();
/*  66 */     EscherContainerRecord escherContainerRecord2 = new EscherContainerRecord();
/*  67 */     EscherSpgrRecord escherSpgrRecord = new EscherSpgrRecord();
/*  68 */     EscherSpRecord escherSpRecord = new EscherSpRecord();
/*  69 */     EscherOptRecord escherOptRecord = new EscherOptRecord();
/*     */     
/*  71 */     EscherClientDataRecord escherClientDataRecord = new EscherClientDataRecord();
/*     */     
/*  73 */     escherContainerRecord1.setRecordId((short)-4093);
/*  74 */     escherContainerRecord1.setOptions((short)15);
/*  75 */     escherContainerRecord2.setRecordId((short)-4092);
/*  76 */     escherContainerRecord2.setOptions((short)15);
/*  77 */     escherSpgrRecord.setRecordId((short)-4087);
/*  78 */     escherSpgrRecord.setOptions((short)1);
/*  79 */     escherSpgrRecord.setRectX1(0);
/*  80 */     escherSpgrRecord.setRectY1(0);
/*  81 */     escherSpgrRecord.setRectX2(1023);
/*  82 */     escherSpgrRecord.setRectY2(255);
/*  83 */     escherSpRecord.setRecordId((short)-4086);
/*  84 */     escherSpRecord.setOptions((short)2);
/*  85 */     if (getAnchor() instanceof HSSFClientAnchor) {
/*  86 */       escherSpRecord.setFlags(513);
/*     */     } else {
/*  88 */       escherSpRecord.setFlags(515);
/*     */     } 
/*  90 */     escherOptRecord.setRecordId((short)-4085);
/*  91 */     escherOptRecord.setOptions((short)35);
/*  92 */     escherOptRecord.addEscherProperty((EscherProperty)new EscherBoolProperty((short)127, 262148));
/*  93 */     escherOptRecord.addEscherProperty((EscherProperty)new EscherBoolProperty((short)959, 524288));
/*     */     
/*  95 */     EscherRecord escherRecord = getAnchor().getEscherAnchor();
/*  96 */     escherClientDataRecord.setRecordId((short)-4079);
/*  97 */     escherClientDataRecord.setOptions((short)0);
/*     */     
/*  99 */     escherContainerRecord1.addChildRecord((EscherRecord)escherContainerRecord2);
/* 100 */     escherContainerRecord2.addChildRecord((EscherRecord)escherSpgrRecord);
/* 101 */     escherContainerRecord2.addChildRecord((EscherRecord)escherSpRecord);
/* 102 */     escherContainerRecord2.addChildRecord((EscherRecord)escherOptRecord);
/* 103 */     escherContainerRecord2.addChildRecord(escherRecord);
/* 104 */     escherContainerRecord2.addChildRecord((EscherRecord)escherClientDataRecord);
/* 105 */     return escherContainerRecord1;
/*     */   }
/*     */ 
/*     */   
/*     */   protected ObjRecord createObjRecord() {
/* 110 */     ObjRecord objRecord = new ObjRecord();
/* 111 */     CommonObjectDataSubRecord commonObjectDataSubRecord = new CommonObjectDataSubRecord();
/* 112 */     commonObjectDataSubRecord.setObjectType((short)0);
/* 113 */     commonObjectDataSubRecord.setLocked(true);
/* 114 */     commonObjectDataSubRecord.setPrintable(true);
/* 115 */     commonObjectDataSubRecord.setAutofill(true);
/* 116 */     commonObjectDataSubRecord.setAutoline(true);
/* 117 */     GroupMarkerSubRecord groupMarkerSubRecord = new GroupMarkerSubRecord();
/* 118 */     EndSubRecord endSubRecord = new EndSubRecord();
/* 119 */     objRecord.addSubRecord((SubRecord)commonObjectDataSubRecord);
/* 120 */     objRecord.addSubRecord((SubRecord)groupMarkerSubRecord);
/* 121 */     objRecord.addSubRecord((SubRecord)endSubRecord);
/* 122 */     return objRecord;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void afterRemove(HSSFPatriarch paramHSSFPatriarch) {
/* 127 */     paramHSSFPatriarch.getBoundAggregate().removeShapeToObjRecord(((EscherContainerRecord)getEscherContainer().getChildContainers().get(0)).getChildById((short)-4079));
/*     */     
/* 129 */     for (byte b = 0; b < this.shapes.size(); b++) {
/* 130 */       HSSFShape hSSFShape = this.shapes.get(b);
/* 131 */       removeShape(hSSFShape);
/* 132 */       hSSFShape.afterRemove(getPatriarch());
/*     */     } 
/* 134 */     this.shapes.clear();
/*     */   }
/*     */   
/*     */   private void onCreate(HSSFShape paramHSSFShape) {
/* 138 */     if (getPatriarch() != null) {
/* 139 */       EscherSpRecord escherSpRecord; EscherContainerRecord escherContainerRecord = paramHSSFShape.getEscherContainer();
/* 140 */       int i = getPatriarch().newShapeId();
/* 141 */       paramHSSFShape.setShapeId(i);
/* 142 */       getEscherContainer().addChildRecord((EscherRecord)escherContainerRecord);
/* 143 */       paramHSSFShape.afterInsert(getPatriarch());
/*     */       
/* 145 */       if (paramHSSFShape instanceof HSSFShapeGroup) {
/* 146 */         escherSpRecord = (EscherSpRecord)((EscherContainerRecord)paramHSSFShape.getEscherContainer().getChildContainers().get(0)).getChildById((short)-4086);
/*     */       } else {
/* 148 */         escherSpRecord = (EscherSpRecord)paramHSSFShape.getEscherContainer().getChildById((short)-4086);
/*     */       } 
/* 150 */       escherSpRecord.setFlags(escherSpRecord.getFlags() | 0x2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFShapeGroup createGroup(HSSFChildAnchor paramHSSFChildAnchor) {
/* 161 */     HSSFShapeGroup hSSFShapeGroup = new HSSFShapeGroup(this, paramHSSFChildAnchor);
/* 162 */     hSSFShapeGroup.setParent(this);
/* 163 */     hSSFShapeGroup.setAnchor(paramHSSFChildAnchor);
/* 164 */     this.shapes.add(hSSFShapeGroup);
/* 165 */     onCreate(hSSFShapeGroup);
/* 166 */     return hSSFShapeGroup;
/*     */   }
/*     */   
/*     */   public void addShape(HSSFShape paramHSSFShape) {
/* 170 */     paramHSSFShape.setPatriarch(getPatriarch());
/* 171 */     paramHSSFShape.setParent(this);
/* 172 */     this.shapes.add(paramHSSFShape);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFSimpleShape createShape(HSSFChildAnchor paramHSSFChildAnchor) {
/* 182 */     HSSFSimpleShape hSSFSimpleShape = new HSSFSimpleShape(this, paramHSSFChildAnchor);
/* 183 */     hSSFSimpleShape.setParent(this);
/* 184 */     hSSFSimpleShape.setAnchor(paramHSSFChildAnchor);
/* 185 */     this.shapes.add(hSSFSimpleShape);
/* 186 */     onCreate(hSSFSimpleShape);
/* 187 */     EscherSpRecord escherSpRecord = (EscherSpRecord)hSSFSimpleShape.getEscherContainer().getChildById((short)-4086);
/* 188 */     if (hSSFSimpleShape.getAnchor().isHorizontallyFlipped()) {
/* 189 */       escherSpRecord.setFlags(escherSpRecord.getFlags() | 0x40);
/*     */     }
/* 191 */     if (hSSFSimpleShape.getAnchor().isVerticallyFlipped()) {
/* 192 */       escherSpRecord.setFlags(escherSpRecord.getFlags() | 0x80);
/*     */     }
/* 194 */     return hSSFSimpleShape;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFTextbox createTextbox(HSSFChildAnchor paramHSSFChildAnchor) {
/* 204 */     HSSFTextbox hSSFTextbox = new HSSFTextbox(this, paramHSSFChildAnchor);
/* 205 */     hSSFTextbox.setParent(this);
/* 206 */     hSSFTextbox.setAnchor(paramHSSFChildAnchor);
/* 207 */     this.shapes.add(hSSFTextbox);
/* 208 */     onCreate(hSSFTextbox);
/* 209 */     return hSSFTextbox;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFPolygon createPolygon(HSSFChildAnchor paramHSSFChildAnchor) {
/* 220 */     HSSFPolygon hSSFPolygon = new HSSFPolygon(this, paramHSSFChildAnchor);
/* 221 */     hSSFPolygon.setParent(this);
/* 222 */     hSSFPolygon.setAnchor(paramHSSFChildAnchor);
/* 223 */     this.shapes.add(hSSFPolygon);
/* 224 */     onCreate(hSSFPolygon);
/* 225 */     return hSSFPolygon;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFPicture createPicture(HSSFChildAnchor paramHSSFChildAnchor, int paramInt) {
/* 236 */     HSSFPicture hSSFPicture = new HSSFPicture(this, paramHSSFChildAnchor);
/* 237 */     hSSFPicture.setParent(this);
/* 238 */     hSSFPicture.setAnchor(paramHSSFChildAnchor);
/* 239 */     hSSFPicture.setPictureIndex(paramInt);
/* 240 */     this.shapes.add(hSSFPicture);
/* 241 */     onCreate(hSSFPicture);
/* 242 */     EscherSpRecord escherSpRecord = (EscherSpRecord)hSSFPicture.getEscherContainer().getChildById((short)-4086);
/* 243 */     if (hSSFPicture.getAnchor().isHorizontallyFlipped()) {
/* 244 */       escherSpRecord.setFlags(escherSpRecord.getFlags() | 0x40);
/*     */     }
/* 246 */     if (hSSFPicture.getAnchor().isVerticallyFlipped()) {
/* 247 */       escherSpRecord.setFlags(escherSpRecord.getFlags() | 0x80);
/*     */     }
/* 249 */     return hSSFPicture;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<HSSFShape> getChildren() {
/* 256 */     return Collections.unmodifiableList(this.shapes);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCoordinates(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 264 */     this._spgrRecord.setRectX1(paramInt1);
/* 265 */     this._spgrRecord.setRectX2(paramInt3);
/* 266 */     this._spgrRecord.setRectY1(paramInt2);
/* 267 */     this._spgrRecord.setRectY2(paramInt4);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 271 */     ArrayList<HSSFShape> arrayList = new ArrayList<HSSFShape>(this.shapes);
/* 272 */     for (HSSFShape hSSFShape : arrayList) {
/* 273 */       removeShape(hSSFShape);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getX1() {
/* 281 */     return this._spgrRecord.getRectX1();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getY1() {
/* 288 */     return this._spgrRecord.getRectY1();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getX2() {
/* 295 */     return this._spgrRecord.getRectX2();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getY2() {
/* 302 */     return this._spgrRecord.getRectY2();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int countOfAllChildren() {
/* 309 */     int i = this.shapes.size();
/* 310 */     for (HSSFShape hSSFShape : this.shapes)
/*     */     {
/* 312 */       i += hSSFShape.countOfAllChildren();
/*     */     }
/* 314 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   void afterInsert(HSSFPatriarch paramHSSFPatriarch) {
/* 319 */     EscherAggregate escherAggregate = paramHSSFPatriarch.getBoundAggregate();
/* 320 */     EscherContainerRecord escherContainerRecord = (EscherContainerRecord)getEscherContainer().getChildById((short)-4092);
/* 321 */     escherAggregate.associateShapeToObjRecord(escherContainerRecord.getChildById((short)-4079), (Record)getObjRecord());
/*     */   }
/*     */ 
/*     */   
/*     */   void setShapeId(int paramInt) {
/* 326 */     EscherContainerRecord escherContainerRecord = (EscherContainerRecord)getEscherContainer().getChildById((short)-4092);
/* 327 */     EscherSpRecord escherSpRecord = (EscherSpRecord)escherContainerRecord.getChildById((short)-4086);
/* 328 */     escherSpRecord.setShapeId(paramInt);
/* 329 */     CommonObjectDataSubRecord commonObjectDataSubRecord = getObjRecord().getSubRecords().get(0);
/* 330 */     commonObjectDataSubRecord.setObjectId((short)(paramInt % 1024));
/*     */   }
/*     */ 
/*     */   
/*     */   int getShapeId() {
/* 335 */     EscherContainerRecord escherContainerRecord = (EscherContainerRecord)getEscherContainer().getChildById((short)-4092);
/* 336 */     return ((EscherSpRecord)escherContainerRecord.getChildById((short)-4086)).getShapeId();
/*     */   }
/*     */ 
/*     */   
/*     */   protected HSSFShape cloneShape() {
/* 341 */     throw new IllegalStateException("Use method cloneShape(HSSFPatriarch patriarch)");
/*     */   }
/*     */   
/*     */   protected HSSFShape cloneShape(HSSFPatriarch paramHSSFPatriarch) {
/* 345 */     EscherContainerRecord escherContainerRecord1 = new EscherContainerRecord();
/* 346 */     escherContainerRecord1.setRecordId((short)-4093);
/* 347 */     escherContainerRecord1.setOptions((short)15);
/* 348 */     EscherContainerRecord escherContainerRecord2 = new EscherContainerRecord();
/* 349 */     EscherContainerRecord escherContainerRecord3 = (EscherContainerRecord)getEscherContainer().getChildById((short)-4092);
/* 350 */     byte[] arrayOfByte = escherContainerRecord3.serialize();
/* 351 */     escherContainerRecord2.fillFields(arrayOfByte, 0, (EscherRecordFactory)new DefaultEscherRecordFactory());
/*     */     
/* 353 */     escherContainerRecord1.addChildRecord((EscherRecord)escherContainerRecord2);
/* 354 */     ObjRecord objRecord = null;
/* 355 */     if (null != getObjRecord()) {
/* 356 */       objRecord = (ObjRecord)getObjRecord().cloneViaReserialise();
/*     */     }
/*     */     
/* 359 */     HSSFShapeGroup hSSFShapeGroup = new HSSFShapeGroup(escherContainerRecord1, objRecord);
/* 360 */     hSSFShapeGroup.setPatriarch(paramHSSFPatriarch);
/*     */     
/* 362 */     for (HSSFShape hSSFShape1 : getChildren()) {
/*     */       HSSFShape hSSFShape2;
/* 364 */       if (hSSFShape1 instanceof HSSFShapeGroup) {
/* 365 */         hSSFShape2 = ((HSSFShapeGroup)hSSFShape1).cloneShape(paramHSSFPatriarch);
/*     */       } else {
/* 367 */         hSSFShape2 = hSSFShape1.cloneShape();
/*     */       } 
/* 369 */       hSSFShapeGroup.addShape(hSSFShape2);
/* 370 */       hSSFShapeGroup.onCreate(hSSFShape2);
/*     */     } 
/* 372 */     return hSSFShapeGroup;
/*     */   }
/*     */   
/*     */   public boolean removeShape(HSSFShape paramHSSFShape) {
/* 376 */     boolean bool = getEscherContainer().removeChildRecord((EscherRecord)paramHSSFShape.getEscherContainer());
/* 377 */     if (bool) {
/* 378 */       paramHSSFShape.afterRemove(getPatriarch());
/* 379 */       this.shapes.remove(paramHSSFShape);
/*     */     } 
/* 381 */     return bool;
/*     */   }
/*     */   
/*     */   public Iterator<HSSFShape> iterator() {
/* 385 */     return this.shapes.iterator();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFShapeGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */