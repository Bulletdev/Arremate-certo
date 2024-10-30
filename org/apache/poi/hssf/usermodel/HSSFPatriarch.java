/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import java.io.FileNotFoundException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.ddf.EscherComplexProperty;
/*     */ import org.apache.poi.ddf.EscherContainerRecord;
/*     */ import org.apache.poi.ddf.EscherDgRecord;
/*     */ import org.apache.poi.ddf.EscherOptRecord;
/*     */ import org.apache.poi.ddf.EscherProperty;
/*     */ import org.apache.poi.ddf.EscherRecord;
/*     */ import org.apache.poi.ddf.EscherSpRecord;
/*     */ import org.apache.poi.ddf.EscherSpgrRecord;
/*     */ import org.apache.poi.hssf.model.DrawingManager2;
/*     */ import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
/*     */ import org.apache.poi.hssf.record.EmbeddedObjectRefSubRecord;
/*     */ import org.apache.poi.hssf.record.EndSubRecord;
/*     */ import org.apache.poi.hssf.record.EscherAggregate;
/*     */ import org.apache.poi.hssf.record.FtCfSubRecord;
/*     */ import org.apache.poi.hssf.record.FtPioGrbitSubRecord;
/*     */ import org.apache.poi.hssf.record.NoteRecord;
/*     */ import org.apache.poi.hssf.record.ObjRecord;
/*     */ import org.apache.poi.hssf.record.SubRecord;
/*     */ import org.apache.poi.hssf.util.CellReference;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryEntry;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*     */ import org.apache.poi.ss.usermodel.Chart;
/*     */ import org.apache.poi.ss.usermodel.ClientAnchor;
/*     */ import org.apache.poi.ss.usermodel.Comment;
/*     */ import org.apache.poi.ss.usermodel.Drawing;
/*     */ import org.apache.poi.ss.usermodel.Picture;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.NotImplemented;
/*     */ import org.apache.poi.util.StringUtil;
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
/*     */ public final class HSSFPatriarch
/*     */   implements HSSFShapeContainer, Drawing
/*     */ {
/*  62 */   private final List<HSSFShape> _shapes = new ArrayList<HSSFShape>();
/*     */ 
/*     */ 
/*     */   
/*     */   private final EscherSpgrRecord _spgrRecord;
/*     */ 
/*     */ 
/*     */   
/*     */   private final EscherContainerRecord _mainSpgrContainer;
/*     */ 
/*     */ 
/*     */   
/*     */   private EscherAggregate _boundAggregate;
/*     */ 
/*     */   
/*     */   private final HSSFSheet _sheet;
/*     */ 
/*     */ 
/*     */   
/*     */   HSSFPatriarch(HSSFSheet paramHSSFSheet, EscherAggregate paramEscherAggregate) {
/*  82 */     this._sheet = paramHSSFSheet;
/*  83 */     this._boundAggregate = paramEscherAggregate;
/*  84 */     this._mainSpgrContainer = this._boundAggregate.getEscherContainer().getChildContainers().get(0);
/*  85 */     EscherContainerRecord escherContainerRecord = (EscherContainerRecord)((EscherContainerRecord)this._boundAggregate.getEscherContainer().getChildContainers().get(0)).getChild(0);
/*     */     
/*  87 */     this._spgrRecord = (EscherSpgrRecord)escherContainerRecord.getChildById((short)-4087);
/*  88 */     buildShapeTree();
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
/*     */   static HSSFPatriarch createPatriarch(HSSFPatriarch paramHSSFPatriarch, HSSFSheet paramHSSFSheet) {
/* 100 */     HSSFPatriarch hSSFPatriarch = new HSSFPatriarch(paramHSSFSheet, new EscherAggregate(true));
/* 101 */     hSSFPatriarch.afterCreate();
/* 102 */     for (HSSFShape hSSFShape1 : paramHSSFPatriarch.getChildren()) {
/*     */       HSSFShape hSSFShape2;
/* 104 */       if (hSSFShape1 instanceof HSSFShapeGroup) {
/* 105 */         hSSFShape2 = ((HSSFShapeGroup)hSSFShape1).cloneShape(hSSFPatriarch);
/*     */       } else {
/* 107 */         hSSFShape2 = hSSFShape1.cloneShape();
/*     */       } 
/* 109 */       hSSFPatriarch.onCreate(hSSFShape2);
/* 110 */       hSSFPatriarch.addShape(hSSFShape2);
/*     */     } 
/* 112 */     return hSSFPatriarch;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void preSerialize() {
/* 120 */     Map map = this._boundAggregate.getTailRecords();
/*     */ 
/*     */ 
/*     */     
/* 124 */     HashSet<String> hashSet = new HashSet(map.size());
/* 125 */     for (NoteRecord noteRecord : map.values()) {
/* 126 */       String str = (new CellReference(noteRecord.getRow(), noteRecord.getColumn())).formatAsString();
/*     */       
/* 128 */       if (hashSet.contains(str)) {
/* 129 */         throw new IllegalStateException("found multiple cell comments for cell " + str);
/*     */       }
/* 131 */       hashSet.add(str);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeShape(HSSFShape paramHSSFShape) {
/* 141 */     boolean bool = this._mainSpgrContainer.removeChildRecord((EscherRecord)paramHSSFShape.getEscherContainer());
/* 142 */     if (bool) {
/* 143 */       paramHSSFShape.afterRemove(this);
/* 144 */       this._shapes.remove(paramHSSFShape);
/*     */     } 
/* 146 */     return bool;
/*     */   }
/*     */   
/*     */   void afterCreate() {
/* 150 */     DrawingManager2 drawingManager2 = this._sheet.getWorkbook().getWorkbook().getDrawingManager();
/* 151 */     short s = drawingManager2.findNewDrawingGroupId();
/* 152 */     this._boundAggregate.setDgId(s);
/* 153 */     this._boundAggregate.setMainSpRecordId(newShapeId());
/* 154 */     drawingManager2.incrementDrawingsSaved();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFShapeGroup createGroup(HSSFClientAnchor paramHSSFClientAnchor) {
/* 165 */     HSSFShapeGroup hSSFShapeGroup = new HSSFShapeGroup(null, paramHSSFClientAnchor);
/* 166 */     addShape(hSSFShapeGroup);
/* 167 */     onCreate(hSSFShapeGroup);
/* 168 */     return hSSFShapeGroup;
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
/*     */   public HSSFSimpleShape createSimpleShape(HSSFClientAnchor paramHSSFClientAnchor) {
/* 184 */     HSSFSimpleShape hSSFSimpleShape = new HSSFSimpleShape(null, paramHSSFClientAnchor);
/* 185 */     addShape(hSSFSimpleShape);
/*     */     
/* 187 */     onCreate(hSSFSimpleShape);
/* 188 */     return hSSFSimpleShape;
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
/*     */   public HSSFPicture createPicture(HSSFClientAnchor paramHSSFClientAnchor, int paramInt) {
/* 200 */     HSSFPicture hSSFPicture = new HSSFPicture(null, paramHSSFClientAnchor);
/* 201 */     hSSFPicture.setPictureIndex(paramInt);
/* 202 */     addShape(hSSFPicture);
/*     */     
/* 204 */     onCreate(hSSFPicture);
/* 205 */     return hSSFPicture;
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
/*     */   public HSSFPicture createPicture(ClientAnchor paramClientAnchor, int paramInt) {
/* 218 */     return createPicture((HSSFClientAnchor)paramClientAnchor, paramInt);
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
/*     */   public HSSFObjectData createObjectData(HSSFClientAnchor paramHSSFClientAnchor, int paramInt1, int paramInt2) {
/*     */     DirectoryEntry directoryEntry;
/* 233 */     ObjRecord objRecord = new ObjRecord();
/*     */     
/* 235 */     CommonObjectDataSubRecord commonObjectDataSubRecord = new CommonObjectDataSubRecord();
/* 236 */     commonObjectDataSubRecord.setObjectType((short)8);
/*     */     
/* 238 */     commonObjectDataSubRecord.setLocked(true);
/* 239 */     commonObjectDataSubRecord.setPrintable(true);
/* 240 */     commonObjectDataSubRecord.setAutofill(true);
/* 241 */     commonObjectDataSubRecord.setAutoline(true);
/* 242 */     commonObjectDataSubRecord.setReserved1(0);
/* 243 */     commonObjectDataSubRecord.setReserved2(0);
/* 244 */     commonObjectDataSubRecord.setReserved3(0);
/* 245 */     objRecord.addSubRecord((SubRecord)commonObjectDataSubRecord);
/*     */ 
/*     */     
/* 248 */     FtCfSubRecord ftCfSubRecord = new FtCfSubRecord();
/* 249 */     HSSFPictureData hSSFPictureData = getSheet().getWorkbook().getAllPictures().get(paramInt2 - 1);
/* 250 */     switch (hSSFPictureData.getFormat()) {
/*     */       
/*     */       case 2:
/*     */       case 3:
/* 254 */         ftCfSubRecord.setFlags((short)2);
/*     */         break;
/*     */       case 4:
/*     */       case 5:
/*     */       case 6:
/*     */       case 7:
/* 260 */         ftCfSubRecord.setFlags((short)9);
/*     */         break;
/*     */       default:
/* 263 */         throw new IllegalStateException("Invalid picture type: " + hSSFPictureData.getFormat());
/*     */     } 
/* 265 */     objRecord.addSubRecord((SubRecord)ftCfSubRecord);
/*     */     
/* 267 */     FtPioGrbitSubRecord ftPioGrbitSubRecord = new FtPioGrbitSubRecord();
/* 268 */     ftPioGrbitSubRecord.setFlagByBit(1, true);
/* 269 */     objRecord.addSubRecord((SubRecord)ftPioGrbitSubRecord);
/*     */     
/* 271 */     EmbeddedObjectRefSubRecord embeddedObjectRefSubRecord = new EmbeddedObjectRefSubRecord();
/* 272 */     embeddedObjectRefSubRecord.setUnknownFormulaData(new byte[] { 2, 0, 0, 0, 0 });
/* 273 */     embeddedObjectRefSubRecord.setOleClassname("Paket");
/* 274 */     embeddedObjectRefSubRecord.setStorageId(paramInt1);
/*     */     
/* 276 */     objRecord.addSubRecord((SubRecord)embeddedObjectRefSubRecord);
/* 277 */     objRecord.addSubRecord((SubRecord)new EndSubRecord());
/*     */     
/* 279 */     String str = "MBD" + HexDump.toHex(paramInt1);
/*     */     
/*     */     try {
/* 282 */       DirectoryNode directoryNode = this._sheet.getWorkbook().getRootDirectory();
/* 283 */       if (directoryNode == null) throw new FileNotFoundException(); 
/* 284 */       directoryEntry = (DirectoryEntry)directoryNode.getEntry(str);
/* 285 */     } catch (FileNotFoundException fileNotFoundException) {
/* 286 */       throw new IllegalStateException("trying to add ole shape without actually adding data first - use HSSFWorkbook.addOlePackage first", fileNotFoundException);
/*     */     } 
/*     */ 
/*     */     
/* 290 */     HSSFPicture hSSFPicture = new HSSFPicture(null, paramHSSFClientAnchor);
/* 291 */     hSSFPicture.setPictureIndex(paramInt2);
/* 292 */     EscherContainerRecord escherContainerRecord = hSSFPicture.getEscherContainer();
/* 293 */     EscherSpRecord escherSpRecord = (EscherSpRecord)escherContainerRecord.getChildById((short)-4086);
/* 294 */     escherSpRecord.setFlags(escherSpRecord.getFlags() | 0x10);
/*     */     
/* 296 */     HSSFObjectData hSSFObjectData = new HSSFObjectData(escherContainerRecord, objRecord, directoryEntry);
/* 297 */     addShape(hSSFObjectData);
/* 298 */     onCreate(hSSFObjectData);
/*     */ 
/*     */     
/* 301 */     return hSSFObjectData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFPolygon createPolygon(HSSFClientAnchor paramHSSFClientAnchor) {
/* 312 */     HSSFPolygon hSSFPolygon = new HSSFPolygon(null, paramHSSFClientAnchor);
/* 313 */     addShape(hSSFPolygon);
/* 314 */     onCreate(hSSFPolygon);
/* 315 */     return hSSFPolygon;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFTextbox createTextbox(HSSFClientAnchor paramHSSFClientAnchor) {
/* 326 */     HSSFTextbox hSSFTextbox = new HSSFTextbox(null, paramHSSFClientAnchor);
/* 327 */     addShape(hSSFTextbox);
/* 328 */     onCreate(hSSFTextbox);
/* 329 */     return hSSFTextbox;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFComment createComment(HSSFAnchor paramHSSFAnchor) {
/* 340 */     HSSFComment hSSFComment = new HSSFComment(null, paramHSSFAnchor);
/* 341 */     addShape(hSSFComment);
/* 342 */     onCreate(hSSFComment);
/* 343 */     return hSSFComment;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   HSSFSimpleShape createComboBox(HSSFAnchor paramHSSFAnchor) {
/* 352 */     HSSFCombobox hSSFCombobox = new HSSFCombobox(null, paramHSSFAnchor);
/* 353 */     addShape(hSSFCombobox);
/* 354 */     onCreate(hSSFCombobox);
/* 355 */     return hSSFCombobox;
/*     */   }
/*     */   
/*     */   public HSSFComment createCellComment(ClientAnchor paramClientAnchor) {
/* 359 */     return createComment((HSSFAnchor)paramClientAnchor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<HSSFShape> getChildren() {
/* 366 */     return Collections.unmodifiableList(this._shapes);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public void addShape(HSSFShape paramHSSFShape) {
/* 374 */     paramHSSFShape.setPatriarch(this);
/* 375 */     this._shapes.add(paramHSSFShape);
/*     */   }
/*     */   
/*     */   private void onCreate(HSSFShape paramHSSFShape) {
/* 379 */     EscherContainerRecord escherContainerRecord1 = this._boundAggregate.getEscherContainer().getChildContainers().get(0);
/*     */ 
/*     */     
/* 382 */     EscherContainerRecord escherContainerRecord2 = paramHSSFShape.getEscherContainer();
/* 383 */     int i = newShapeId();
/* 384 */     paramHSSFShape.setShapeId(i);
/*     */     
/* 386 */     escherContainerRecord1.addChildRecord((EscherRecord)escherContainerRecord2);
/* 387 */     paramHSSFShape.afterInsert(this);
/* 388 */     setFlipFlags(paramHSSFShape);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int countOfAllChildren() {
/* 396 */     int i = this._shapes.size();
/* 397 */     for (HSSFShape hSSFShape : this._shapes)
/*     */     {
/* 399 */       i += hSSFShape.countOfAllChildren();
/*     */     }
/* 401 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCoordinates(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 409 */     this._spgrRecord.setRectY1(paramInt2);
/* 410 */     this._spgrRecord.setRectY2(paramInt4);
/* 411 */     this._spgrRecord.setRectX1(paramInt1);
/* 412 */     this._spgrRecord.setRectX2(paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 419 */     ArrayList<HSSFShape> arrayList = new ArrayList<HSSFShape>(this._shapes);
/* 420 */     for (HSSFShape hSSFShape : arrayList) {
/* 421 */       removeShape(hSSFShape);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int newShapeId() {
/* 429 */     DrawingManager2 drawingManager2 = this._sheet.getWorkbook().getWorkbook().getDrawingManager();
/* 430 */     EscherDgRecord escherDgRecord = (EscherDgRecord)this._boundAggregate.getEscherContainer().getChildById((short)-4088);
/*     */     
/* 432 */     short s = escherDgRecord.getDrawingGroupId();
/* 433 */     return drawingManager2.allocateShapeId(s, escherDgRecord);
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
/*     */   public boolean containsChart() {
/* 447 */     EscherOptRecord escherOptRecord = (EscherOptRecord)this._boundAggregate.findFirstWithId((short)-4085);
/*     */     
/* 449 */     if (escherOptRecord == null)
/*     */     {
/* 451 */       return false;
/*     */     }
/*     */     
/* 454 */     for (EscherProperty escherProperty : escherOptRecord.getEscherProperties()) {
/*     */       
/* 456 */       if (escherProperty.getPropertyNumber() == 896 && escherProperty.isComplex()) {
/* 457 */         EscherComplexProperty escherComplexProperty = (EscherComplexProperty)escherProperty;
/* 458 */         String str = StringUtil.getFromUnicodeLE(escherComplexProperty.getComplexData());
/*     */         
/* 460 */         if (str.equals("Chart 1\000")) {
/* 461 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 466 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getX1() {
/* 473 */     return this._spgrRecord.getRectX1();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getY1() {
/* 480 */     return this._spgrRecord.getRectY1();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getX2() {
/* 487 */     return this._spgrRecord.getRectX2();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getY2() {
/* 494 */     return this._spgrRecord.getRectY2();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public EscherAggregate getBoundAggregate() {
/* 503 */     return this._boundAggregate;
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
/*     */   public HSSFClientAnchor createAnchor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
/* 521 */     return new HSSFClientAnchor(paramInt1, paramInt2, paramInt3, paramInt4, (short)paramInt5, paramInt6, (short)paramInt7, paramInt8);
/*     */   }
/*     */   
/*     */   @NotImplemented
/*     */   public Chart createChart(ClientAnchor paramClientAnchor) {
/* 526 */     throw new RuntimeException("NotImplemented");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void buildShapeTree() {
/* 534 */     EscherContainerRecord escherContainerRecord1 = this._boundAggregate.getEscherContainer();
/* 535 */     if (escherContainerRecord1 == null) {
/*     */       return;
/*     */     }
/* 538 */     EscherContainerRecord escherContainerRecord2 = escherContainerRecord1.getChildContainers().get(0);
/* 539 */     List<EscherContainerRecord> list = escherContainerRecord2.getChildContainers();
/*     */     
/* 541 */     for (byte b = 0; b < list.size(); b++) {
/* 542 */       EscherContainerRecord escherContainerRecord = list.get(b);
/* 543 */       if (b != 0) {
/* 544 */         HSSFShapeFactory.createShapeTree(escherContainerRecord, this._boundAggregate, this, this._sheet.getWorkbook().getRootDirectory());
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void setFlipFlags(HSSFShape paramHSSFShape) {
/* 550 */     EscherSpRecord escherSpRecord = (EscherSpRecord)paramHSSFShape.getEscherContainer().getChildById((short)-4086);
/* 551 */     if (paramHSSFShape.getAnchor().isHorizontallyFlipped()) {
/* 552 */       escherSpRecord.setFlags(escherSpRecord.getFlags() | 0x40);
/*     */     }
/* 554 */     if (paramHSSFShape.getAnchor().isVerticallyFlipped()) {
/* 555 */       escherSpRecord.setFlags(escherSpRecord.getFlags() | 0x80);
/*     */     }
/*     */   }
/*     */   
/*     */   public Iterator<HSSFShape> iterator() {
/* 560 */     return this._shapes.iterator();
/*     */   }
/*     */   
/*     */   protected HSSFSheet getSheet() {
/* 564 */     return this._sheet;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFPatriarch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */