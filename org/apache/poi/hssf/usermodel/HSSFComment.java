/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.ddf.DefaultEscherRecordFactory;
/*     */ import org.apache.poi.ddf.EscherBSERecord;
/*     */ import org.apache.poi.ddf.EscherContainerRecord;
/*     */ import org.apache.poi.ddf.EscherOptRecord;
/*     */ import org.apache.poi.ddf.EscherProperty;
/*     */ import org.apache.poi.ddf.EscherRecordFactory;
/*     */ import org.apache.poi.ddf.EscherSimpleProperty;
/*     */ import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
/*     */ import org.apache.poi.hssf.record.EndSubRecord;
/*     */ import org.apache.poi.hssf.record.NoteRecord;
/*     */ import org.apache.poi.hssf.record.NoteStructureSubRecord;
/*     */ import org.apache.poi.hssf.record.ObjRecord;
/*     */ import org.apache.poi.hssf.record.SubRecord;
/*     */ import org.apache.poi.hssf.record.TextObjectRecord;
/*     */ import org.apache.poi.ss.usermodel.ClientAnchor;
/*     */ import org.apache.poi.ss.usermodel.Comment;
/*     */ import org.apache.poi.ss.usermodel.RichTextString;
/*     */ import org.apache.poi.ss.util.CellAddress;
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
/*     */ public class HSSFComment
/*     */   extends HSSFTextbox
/*     */   implements Comment
/*     */ {
/*     */   private static final int FILL_TYPE_SOLID = 0;
/*     */   private static final int FILL_TYPE_PICTURE = 3;
/*     */   private static final int GROUP_SHAPE_PROPERTY_DEFAULT_VALUE = 655362;
/*     */   private static final int GROUP_SHAPE_HIDDEN_MASK = 16777218;
/*     */   private static final int GROUP_SHAPE_NOT_HIDDEN_MASK = -16777219;
/*     */   private final NoteRecord _note;
/*     */   
/*     */   public HSSFComment(EscherContainerRecord paramEscherContainerRecord, ObjRecord paramObjRecord, TextObjectRecord paramTextObjectRecord, NoteRecord paramNoteRecord) {
/*  60 */     super(paramEscherContainerRecord, paramObjRecord, paramTextObjectRecord);
/*  61 */     this._note = paramNoteRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFComment(HSSFShape paramHSSFShape, HSSFAnchor paramHSSFAnchor) {
/*  71 */     this(paramHSSFShape, paramHSSFAnchor, createNoteRecord());
/*     */   }
/*     */   
/*     */   private HSSFComment(HSSFShape paramHSSFShape, HSSFAnchor paramHSSFAnchor, NoteRecord paramNoteRecord) {
/*  75 */     super(paramHSSFShape, paramHSSFAnchor);
/*  76 */     this._note = paramNoteRecord;
/*     */     
/*  78 */     setFillColor(134217808);
/*     */ 
/*     */     
/*  81 */     setVisible(false);
/*  82 */     setAuthor("");
/*  83 */     CommonObjectDataSubRecord commonObjectDataSubRecord = getObjRecord().getSubRecords().get(0);
/*  84 */     commonObjectDataSubRecord.setObjectType((short)25);
/*     */   }
/*     */   
/*     */   protected HSSFComment(NoteRecord paramNoteRecord, TextObjectRecord paramTextObjectRecord) {
/*  88 */     this((HSSFShape)null, new HSSFClientAnchor(), paramNoteRecord);
/*     */   }
/*     */ 
/*     */   
/*     */   void afterInsert(HSSFPatriarch paramHSSFPatriarch) {
/*  93 */     super.afterInsert(paramHSSFPatriarch);
/*  94 */     paramHSSFPatriarch.getBoundAggregate().addTailRecord(getNoteRecord());
/*     */   }
/*     */ 
/*     */   
/*     */   protected EscherContainerRecord createSpContainer() {
/*  99 */     EscherContainerRecord escherContainerRecord = super.createSpContainer();
/* 100 */     EscherOptRecord escherOptRecord = (EscherOptRecord)escherContainerRecord.getChildById((short)-4085);
/* 101 */     escherOptRecord.removeEscherProperty(129);
/* 102 */     escherOptRecord.removeEscherProperty(131);
/* 103 */     escherOptRecord.removeEscherProperty(130);
/* 104 */     escherOptRecord.removeEscherProperty(132);
/* 105 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherSimpleProperty((short)959, false, false, 655362));
/* 106 */     return escherContainerRecord;
/*     */   }
/*     */ 
/*     */   
/*     */   protected ObjRecord createObjRecord() {
/* 111 */     ObjRecord objRecord = new ObjRecord();
/* 112 */     CommonObjectDataSubRecord commonObjectDataSubRecord = new CommonObjectDataSubRecord();
/* 113 */     commonObjectDataSubRecord.setObjectType((short)202);
/* 114 */     commonObjectDataSubRecord.setLocked(true);
/* 115 */     commonObjectDataSubRecord.setPrintable(true);
/* 116 */     commonObjectDataSubRecord.setAutofill(false);
/* 117 */     commonObjectDataSubRecord.setAutoline(true);
/*     */     
/* 119 */     NoteStructureSubRecord noteStructureSubRecord = new NoteStructureSubRecord();
/* 120 */     EndSubRecord endSubRecord = new EndSubRecord();
/* 121 */     objRecord.addSubRecord((SubRecord)commonObjectDataSubRecord);
/* 122 */     objRecord.addSubRecord((SubRecord)noteStructureSubRecord);
/* 123 */     objRecord.addSubRecord((SubRecord)endSubRecord);
/* 124 */     return objRecord;
/*     */   }
/*     */   
/*     */   private static NoteRecord createNoteRecord() {
/* 128 */     NoteRecord noteRecord = new NoteRecord();
/* 129 */     noteRecord.setFlags((short)0);
/* 130 */     noteRecord.setAuthor("");
/* 131 */     return noteRecord;
/*     */   }
/*     */ 
/*     */   
/*     */   void setShapeId(int paramInt) {
/* 136 */     if (paramInt > 65535) {
/* 137 */       throw new IllegalArgumentException("Cannot add more than 65535 shapes");
/*     */     }
/* 139 */     super.setShapeId(paramInt);
/* 140 */     CommonObjectDataSubRecord commonObjectDataSubRecord = getObjRecord().getSubRecords().get(0);
/* 141 */     commonObjectDataSubRecord.setObjectId(paramInt);
/* 142 */     this._note.setShapeId(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVisible(boolean paramBoolean) {
/* 152 */     this._note.setFlags(paramBoolean ? 2 : 0);
/* 153 */     setHidden(!paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isVisible() {
/* 163 */     return (this._note.getFlags() == 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public CellAddress getAddress() {
/* 168 */     return new CellAddress(getRow(), getColumn());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAddress(CellAddress paramCellAddress) {
/* 173 */     setRow(paramCellAddress.getRow());
/* 174 */     setColumn(paramCellAddress.getColumn());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAddress(int paramInt1, int paramInt2) {
/* 179 */     setRow(paramInt1);
/* 180 */     setColumn(paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRow() {
/* 190 */     return this._note.getRow();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRow(int paramInt) {
/* 200 */     this._note.setRow(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColumn() {
/* 210 */     return this._note.getColumn();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColumn(int paramInt) {
/* 220 */     this._note.setColumn(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAuthor() {
/* 230 */     return this._note.getAuthor();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAuthor(String paramString) {
/* 240 */     if (this._note != null) this._note.setAuthor(paramString);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected NoteRecord getNoteRecord() {
/* 247 */     return this._note;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasPosition() {
/* 254 */     if (this._note == null) return false; 
/* 255 */     if (getColumn() < 0 || getRow() < 0) return false; 
/* 256 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ClientAnchor getClientAnchor() {
/* 261 */     HSSFAnchor hSSFAnchor = getAnchor();
/* 262 */     if (hSSFAnchor instanceof ClientAnchor) {
/* 263 */       return (ClientAnchor)hSSFAnchor;
/*     */     }
/*     */     
/* 266 */     throw new IllegalStateException("Anchor can not be changed in " + ClientAnchor.class.getSimpleName());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShapeType(int paramInt) {
/* 272 */     throw new IllegalStateException("Shape type can not be changed in " + getClass().getSimpleName());
/*     */   }
/*     */ 
/*     */   
/*     */   public void afterRemove(HSSFPatriarch paramHSSFPatriarch) {
/* 277 */     super.afterRemove(paramHSSFPatriarch);
/* 278 */     paramHSSFPatriarch.getBoundAggregate().removeTailRecord(getNoteRecord());
/*     */   }
/*     */ 
/*     */   
/*     */   protected HSSFShape cloneShape() {
/* 283 */     TextObjectRecord textObjectRecord = (TextObjectRecord)getTextObjectRecord().cloneViaReserialise();
/* 284 */     EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
/* 285 */     byte[] arrayOfByte = getEscherContainer().serialize();
/* 286 */     escherContainerRecord.fillFields(arrayOfByte, 0, (EscherRecordFactory)new DefaultEscherRecordFactory());
/* 287 */     ObjRecord objRecord = (ObjRecord)getObjRecord().cloneViaReserialise();
/* 288 */     NoteRecord noteRecord = (NoteRecord)getNoteRecord().cloneViaReserialise();
/* 289 */     return new HSSFComment(escherContainerRecord, objRecord, textObjectRecord, noteRecord);
/*     */   }
/*     */   
/*     */   public void setBackgroundImage(int paramInt) {
/* 293 */     setPropertyValue((EscherProperty)new EscherSimpleProperty((short)390, false, true, paramInt));
/* 294 */     setPropertyValue((EscherProperty)new EscherSimpleProperty((short)384, false, false, 3));
/* 295 */     EscherBSERecord escherBSERecord = getPatriarch().getSheet().getWorkbook().getWorkbook().getBSERecord(paramInt);
/* 296 */     escherBSERecord.setRef(escherBSERecord.getRef() + 1);
/*     */   }
/*     */   
/*     */   public void resetBackgroundImage() {
/* 300 */     EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty)getOptRecord().lookup(390);
/* 301 */     if (null != escherSimpleProperty) {
/* 302 */       EscherBSERecord escherBSERecord = getPatriarch().getSheet().getWorkbook().getWorkbook().getBSERecord(escherSimpleProperty.getPropertyValue());
/* 303 */       escherBSERecord.setRef(escherBSERecord.getRef() - 1);
/* 304 */       getOptRecord().removeEscherProperty(390);
/*     */     } 
/* 306 */     setPropertyValue((EscherProperty)new EscherSimpleProperty((short)384, false, false, 0));
/*     */   }
/*     */   
/*     */   public int getBackgroundImageId() {
/* 310 */     EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty)getOptRecord().lookup(390);
/* 311 */     return (escherSimpleProperty == null) ? 0 : escherSimpleProperty.getPropertyValue();
/*     */   }
/*     */   
/*     */   private void setHidden(boolean paramBoolean) {
/* 315 */     EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty)getOptRecord().lookup(959);
/*     */     
/* 317 */     if (paramBoolean) {
/* 318 */       setPropertyValue((EscherProperty)new EscherSimpleProperty((short)959, false, false, escherSimpleProperty.getPropertyValue() | 0x1000002));
/*     */     } else {
/* 320 */       setPropertyValue((EscherProperty)new EscherSimpleProperty((short)959, false, false, escherSimpleProperty.getPropertyValue() & 0xFEFFFFFD));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 326 */     if (!(paramObject instanceof HSSFComment)) {
/* 327 */       return false;
/*     */     }
/* 329 */     HSSFComment hSSFComment = (HSSFComment)paramObject;
/* 330 */     return getNoteRecord().equals(hSSFComment.getNoteRecord());
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 335 */     return (getRow() * 17 + getColumn()) * 31;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFComment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */