/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.ddf.DefaultEscherRecordFactory;
/*     */ import org.apache.poi.ddf.EscherBoolProperty;
/*     */ import org.apache.poi.ddf.EscherClientDataRecord;
/*     */ import org.apache.poi.ddf.EscherContainerRecord;
/*     */ import org.apache.poi.ddf.EscherOptRecord;
/*     */ import org.apache.poi.ddf.EscherProperty;
/*     */ import org.apache.poi.ddf.EscherRGBProperty;
/*     */ import org.apache.poi.ddf.EscherRecord;
/*     */ import org.apache.poi.ddf.EscherRecordFactory;
/*     */ import org.apache.poi.ddf.EscherShapePathProperty;
/*     */ import org.apache.poi.ddf.EscherSimpleProperty;
/*     */ import org.apache.poi.ddf.EscherSpRecord;
/*     */ import org.apache.poi.ddf.EscherTextboxRecord;
/*     */ import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
/*     */ import org.apache.poi.hssf.record.EndSubRecord;
/*     */ import org.apache.poi.hssf.record.EscherAggregate;
/*     */ import org.apache.poi.hssf.record.ObjRecord;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.hssf.record.SubRecord;
/*     */ import org.apache.poi.hssf.record.TextObjectRecord;
/*     */ import org.apache.poi.ss.usermodel.RichTextString;
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
/*     */ public class HSSFSimpleShape
/*     */   extends HSSFShape
/*     */ {
/*     */   public static final short OBJECT_TYPE_LINE = 20;
/*     */   public static final short OBJECT_TYPE_RECTANGLE = 1;
/*     */   public static final short OBJECT_TYPE_OVAL = 3;
/*     */   public static final short OBJECT_TYPE_ARC = 19;
/*     */   public static final short OBJECT_TYPE_PICTURE = 75;
/*     */   public static final short OBJECT_TYPE_COMBO_BOX = 201;
/*     */   public static final short OBJECT_TYPE_COMMENT = 202;
/*     */   public static final short OBJECT_TYPE_MICROSOFT_OFFICE_DRAWING = 30;
/*     */   public static final int WRAP_SQUARE = 0;
/*     */   public static final int WRAP_BY_POINTS = 1;
/*     */   public static final int WRAP_NONE = 2;
/*     */   private TextObjectRecord _textObjectRecord;
/*     */   
/*     */   public HSSFSimpleShape(EscherContainerRecord paramEscherContainerRecord, ObjRecord paramObjRecord, TextObjectRecord paramTextObjectRecord) {
/*  62 */     super(paramEscherContainerRecord, paramObjRecord);
/*  63 */     this._textObjectRecord = paramTextObjectRecord;
/*     */   }
/*     */   
/*     */   public HSSFSimpleShape(EscherContainerRecord paramEscherContainerRecord, ObjRecord paramObjRecord) {
/*  67 */     super(paramEscherContainerRecord, paramObjRecord);
/*     */   }
/*     */ 
/*     */   
/*     */   public HSSFSimpleShape(HSSFShape paramHSSFShape, HSSFAnchor paramHSSFAnchor) {
/*  72 */     super(paramHSSFShape, paramHSSFAnchor);
/*  73 */     this._textObjectRecord = createTextObjRecord();
/*     */   }
/*     */   
/*     */   protected TextObjectRecord getTextObjectRecord() {
/*  77 */     return this._textObjectRecord;
/*     */   }
/*     */   
/*     */   protected TextObjectRecord createTextObjRecord() {
/*  81 */     TextObjectRecord textObjectRecord = new TextObjectRecord();
/*  82 */     textObjectRecord.setHorizontalTextAlignment(2);
/*  83 */     textObjectRecord.setVerticalTextAlignment(2);
/*  84 */     textObjectRecord.setTextLocked(true);
/*  85 */     textObjectRecord.setTextOrientation(0);
/*  86 */     textObjectRecord.setStr(new HSSFRichTextString(""));
/*  87 */     return textObjectRecord;
/*     */   }
/*     */ 
/*     */   
/*     */   protected EscherContainerRecord createSpContainer() {
/*  92 */     EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
/*  93 */     escherContainerRecord.setRecordId((short)-4092);
/*  94 */     escherContainerRecord.setOptions((short)15);
/*     */     
/*  96 */     EscherSpRecord escherSpRecord = new EscherSpRecord();
/*  97 */     escherSpRecord.setRecordId((short)-4086);
/*  98 */     escherSpRecord.setFlags(2560);
/*  99 */     escherSpRecord.setVersion((short)2);
/*     */     
/* 101 */     EscherClientDataRecord escherClientDataRecord = new EscherClientDataRecord();
/* 102 */     escherClientDataRecord.setRecordId((short)-4079);
/* 103 */     escherClientDataRecord.setOptions((short)0);
/*     */     
/* 105 */     EscherOptRecord escherOptRecord = new EscherOptRecord();
/* 106 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherSimpleProperty((short)462, 0));
/* 107 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherBoolProperty((short)511, 524296));
/*     */     
/* 109 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherRGBProperty((short)385, 134217737));
/* 110 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherRGBProperty((short)448, 134217792));
/* 111 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherBoolProperty((short)447, 65536));
/* 112 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherBoolProperty((short)511, 524296));
/*     */     
/* 114 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherShapePathProperty((short)324, 4));
/* 115 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherBoolProperty((short)959, 524288));
/* 116 */     escherOptRecord.setRecordId((short)-4085);
/*     */     
/* 118 */     EscherTextboxRecord escherTextboxRecord = new EscherTextboxRecord();
/* 119 */     escherTextboxRecord.setRecordId((short)-4083);
/* 120 */     escherTextboxRecord.setOptions((short)0);
/*     */     
/* 122 */     escherContainerRecord.addChildRecord((EscherRecord)escherSpRecord);
/* 123 */     escherContainerRecord.addChildRecord((EscherRecord)escherOptRecord);
/* 124 */     escherContainerRecord.addChildRecord(getAnchor().getEscherAnchor());
/* 125 */     escherContainerRecord.addChildRecord((EscherRecord)escherClientDataRecord);
/* 126 */     escherContainerRecord.addChildRecord((EscherRecord)escherTextboxRecord);
/* 127 */     return escherContainerRecord;
/*     */   }
/*     */ 
/*     */   
/*     */   protected ObjRecord createObjRecord() {
/* 132 */     ObjRecord objRecord = new ObjRecord();
/* 133 */     CommonObjectDataSubRecord commonObjectDataSubRecord = new CommonObjectDataSubRecord();
/* 134 */     commonObjectDataSubRecord.setLocked(true);
/* 135 */     commonObjectDataSubRecord.setPrintable(true);
/* 136 */     commonObjectDataSubRecord.setAutofill(true);
/* 137 */     commonObjectDataSubRecord.setAutoline(true);
/* 138 */     EndSubRecord endSubRecord = new EndSubRecord();
/*     */     
/* 140 */     objRecord.addSubRecord((SubRecord)commonObjectDataSubRecord);
/* 141 */     objRecord.addSubRecord((SubRecord)endSubRecord);
/* 142 */     return objRecord;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void afterRemove(HSSFPatriarch paramHSSFPatriarch) {
/* 147 */     paramHSSFPatriarch.getBoundAggregate().removeShapeToObjRecord(getEscherContainer().getChildById((short)-4079));
/* 148 */     if (null != getEscherContainer().getChildById((short)-4083)) {
/* 149 */       paramHSSFPatriarch.getBoundAggregate().removeShapeToObjRecord(getEscherContainer().getChildById((short)-4083));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFRichTextString getString() {
/* 157 */     return this._textObjectRecord.getStr();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setString(RichTextString paramRichTextString) {
/* 165 */     if (getShapeType() == 0 || getShapeType() == 20) {
/* 166 */       throw new IllegalStateException("Cannot set text for shape type: " + getShapeType());
/*     */     }
/* 168 */     HSSFRichTextString hSSFRichTextString = (HSSFRichTextString)paramRichTextString;
/*     */     
/* 170 */     if (hSSFRichTextString.numFormattingRuns() == 0) hSSFRichTextString.applyFont((short)0); 
/* 171 */     TextObjectRecord textObjectRecord = getOrCreateTextObjRecord();
/* 172 */     textObjectRecord.setStr(hSSFRichTextString);
/* 173 */     if (paramRichTextString.getString() != null) {
/* 174 */       setPropertyValue((EscherProperty)new EscherSimpleProperty((short)128, paramRichTextString.getString().hashCode()));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   void afterInsert(HSSFPatriarch paramHSSFPatriarch) {
/* 180 */     EscherAggregate escherAggregate = paramHSSFPatriarch.getBoundAggregate();
/* 181 */     escherAggregate.associateShapeToObjRecord(getEscherContainer().getChildById((short)-4079), (Record)getObjRecord());
/*     */     
/* 183 */     if (null != getTextObjectRecord()) {
/* 184 */       escherAggregate.associateShapeToObjRecord(getEscherContainer().getChildById((short)-4083), (Record)getTextObjectRecord());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected HSSFShape cloneShape() {
/* 190 */     TextObjectRecord textObjectRecord = null;
/* 191 */     EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
/* 192 */     byte[] arrayOfByte = getEscherContainer().serialize();
/* 193 */     escherContainerRecord.fillFields(arrayOfByte, 0, (EscherRecordFactory)new DefaultEscherRecordFactory());
/* 194 */     ObjRecord objRecord = (ObjRecord)getObjRecord().cloneViaReserialise();
/* 195 */     if (getTextObjectRecord() != null && getString() != null && null != getString().getString()) {
/* 196 */       textObjectRecord = (TextObjectRecord)getTextObjectRecord().cloneViaReserialise();
/*     */     }
/* 198 */     return new HSSFSimpleShape(escherContainerRecord, objRecord, textObjectRecord);
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
/*     */   public int getShapeType() {
/* 213 */     EscherSpRecord escherSpRecord = (EscherSpRecord)getEscherContainer().getChildById((short)-4086);
/* 214 */     return escherSpRecord.getShapeType();
/*     */   }
/*     */   
/*     */   public int getWrapText() {
/* 218 */     EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty)getOptRecord().lookup(133);
/* 219 */     return (null == escherSimpleProperty) ? 0 : escherSimpleProperty.getPropertyValue();
/*     */   }
/*     */   
/*     */   public void setWrapText(int paramInt) {
/* 223 */     setPropertyValue((EscherProperty)new EscherSimpleProperty((short)133, false, false, paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShapeType(int paramInt) {
/* 231 */     CommonObjectDataSubRecord commonObjectDataSubRecord = getObjRecord().getSubRecords().get(0);
/* 232 */     commonObjectDataSubRecord.setObjectType((short)30);
/* 233 */     EscherSpRecord escherSpRecord = (EscherSpRecord)getEscherContainer().getChildById((short)-4086);
/* 234 */     escherSpRecord.setShapeType((short)paramInt);
/*     */   }
/*     */   
/*     */   private TextObjectRecord getOrCreateTextObjRecord() {
/* 238 */     if (getTextObjectRecord() == null) {
/* 239 */       this._textObjectRecord = createTextObjRecord();
/*     */     }
/* 241 */     EscherTextboxRecord escherTextboxRecord = (EscherTextboxRecord)getEscherContainer().getChildById((short)-4083);
/* 242 */     if (null == escherTextboxRecord) {
/* 243 */       escherTextboxRecord = new EscherTextboxRecord();
/* 244 */       escherTextboxRecord.setRecordId((short)-4083);
/* 245 */       escherTextboxRecord.setOptions((short)0);
/* 246 */       getEscherContainer().addChildRecord((EscherRecord)escherTextboxRecord);
/* 247 */       getPatriarch().getBoundAggregate().associateShapeToObjRecord((EscherRecord)escherTextboxRecord, (Record)this._textObjectRecord);
/*     */     } 
/* 249 */     return this._textObjectRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFSimpleShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */