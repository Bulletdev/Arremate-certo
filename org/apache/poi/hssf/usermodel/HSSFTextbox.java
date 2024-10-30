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
/*     */ public class HSSFTextbox
/*     */   extends HSSFSimpleShape
/*     */ {
/*     */   public static final short OBJECT_TYPE_TEXT = 6;
/*     */   public static final short HORIZONTAL_ALIGNMENT_LEFT = 1;
/*     */   public static final short HORIZONTAL_ALIGNMENT_CENTERED = 2;
/*     */   public static final short HORIZONTAL_ALIGNMENT_RIGHT = 3;
/*     */   public static final short HORIZONTAL_ALIGNMENT_JUSTIFIED = 4;
/*     */   public static final short HORIZONTAL_ALIGNMENT_DISTRIBUTED = 7;
/*     */   public static final short VERTICAL_ALIGNMENT_TOP = 1;
/*     */   public static final short VERTICAL_ALIGNMENT_CENTER = 2;
/*     */   public static final short VERTICAL_ALIGNMENT_BOTTOM = 3;
/*     */   public static final short VERTICAL_ALIGNMENT_JUSTIFY = 4;
/*     */   public static final short VERTICAL_ALIGNMENT_DISTRIBUTED = 7;
/*     */   
/*     */   public HSSFTextbox(EscherContainerRecord paramEscherContainerRecord, ObjRecord paramObjRecord, TextObjectRecord paramTextObjectRecord) {
/*  48 */     super(paramEscherContainerRecord, paramObjRecord, paramTextObjectRecord);
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
/*     */   public HSSFTextbox(HSSFShape paramHSSFShape, HSSFAnchor paramHSSFAnchor) {
/*  61 */     super(paramHSSFShape, paramHSSFAnchor);
/*  62 */     setHorizontalAlignment((short)1);
/*  63 */     setVerticalAlignment((short)1);
/*  64 */     setString(new HSSFRichTextString(""));
/*     */   }
/*     */ 
/*     */   
/*     */   protected ObjRecord createObjRecord() {
/*  69 */     ObjRecord objRecord = new ObjRecord();
/*  70 */     CommonObjectDataSubRecord commonObjectDataSubRecord = new CommonObjectDataSubRecord();
/*  71 */     commonObjectDataSubRecord.setObjectType((short)6);
/*  72 */     commonObjectDataSubRecord.setLocked(true);
/*  73 */     commonObjectDataSubRecord.setPrintable(true);
/*  74 */     commonObjectDataSubRecord.setAutofill(true);
/*  75 */     commonObjectDataSubRecord.setAutoline(true);
/*  76 */     EndSubRecord endSubRecord = new EndSubRecord();
/*  77 */     objRecord.addSubRecord((SubRecord)commonObjectDataSubRecord);
/*  78 */     objRecord.addSubRecord((SubRecord)endSubRecord);
/*  79 */     return objRecord;
/*     */   }
/*     */ 
/*     */   
/*     */   protected EscherContainerRecord createSpContainer() {
/*  84 */     EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
/*  85 */     EscherSpRecord escherSpRecord = new EscherSpRecord();
/*  86 */     EscherOptRecord escherOptRecord = new EscherOptRecord();
/*  87 */     EscherClientDataRecord escherClientDataRecord = new EscherClientDataRecord();
/*  88 */     EscherTextboxRecord escherTextboxRecord = new EscherTextboxRecord();
/*     */     
/*  90 */     escherContainerRecord.setRecordId((short)-4092);
/*  91 */     escherContainerRecord.setOptions((short)15);
/*  92 */     escherSpRecord.setRecordId((short)-4086);
/*  93 */     escherSpRecord.setOptions((short)3234);
/*     */     
/*  95 */     escherSpRecord.setFlags(2560);
/*  96 */     escherOptRecord.setRecordId((short)-4085);
/*  97 */     escherOptRecord.addEscherProperty((EscherProperty)new EscherSimpleProperty((short)128, 0));
/*  98 */     escherOptRecord.addEscherProperty((EscherProperty)new EscherSimpleProperty((short)133, 0));
/*  99 */     escherOptRecord.addEscherProperty((EscherProperty)new EscherSimpleProperty((short)135, 0));
/* 100 */     escherOptRecord.addEscherProperty((EscherProperty)new EscherSimpleProperty((short)959, 524288));
/*     */     
/* 102 */     escherOptRecord.addEscherProperty((EscherProperty)new EscherSimpleProperty((short)129, 0));
/* 103 */     escherOptRecord.addEscherProperty((EscherProperty)new EscherSimpleProperty((short)131, 0));
/* 104 */     escherOptRecord.addEscherProperty((EscherProperty)new EscherSimpleProperty((short)130, 0));
/* 105 */     escherOptRecord.addEscherProperty((EscherProperty)new EscherSimpleProperty((short)132, 0));
/*     */     
/* 107 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherSimpleProperty((short)462, 0));
/* 108 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherBoolProperty((short)511, 524296));
/* 109 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherSimpleProperty((short)459, 9525));
/* 110 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherRGBProperty((short)385, 134217737));
/* 111 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherRGBProperty((short)448, 134217792));
/* 112 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherBoolProperty((short)447, 65536));
/* 113 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherBoolProperty((short)959, 524288));
/*     */     
/* 115 */     EscherRecord escherRecord = getAnchor().getEscherAnchor();
/* 116 */     escherClientDataRecord.setRecordId((short)-4079);
/* 117 */     escherClientDataRecord.setOptions((short)0);
/* 118 */     escherTextboxRecord.setRecordId((short)-4083);
/* 119 */     escherTextboxRecord.setOptions((short)0);
/*     */     
/* 121 */     escherContainerRecord.addChildRecord((EscherRecord)escherSpRecord);
/* 122 */     escherContainerRecord.addChildRecord((EscherRecord)escherOptRecord);
/* 123 */     escherContainerRecord.addChildRecord(escherRecord);
/* 124 */     escherContainerRecord.addChildRecord((EscherRecord)escherClientDataRecord);
/* 125 */     escherContainerRecord.addChildRecord((EscherRecord)escherTextboxRecord);
/*     */     
/* 127 */     return escherContainerRecord;
/*     */   }
/*     */ 
/*     */   
/*     */   void afterInsert(HSSFPatriarch paramHSSFPatriarch) {
/* 132 */     EscherAggregate escherAggregate = paramHSSFPatriarch.getBoundAggregate();
/* 133 */     escherAggregate.associateShapeToObjRecord(getEscherContainer().getChildById((short)-4079), (Record)getObjRecord());
/* 134 */     if (getTextObjectRecord() != null) {
/* 135 */       escherAggregate.associateShapeToObjRecord(getEscherContainer().getChildById((short)-4083), (Record)getTextObjectRecord());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMarginLeft() {
/* 143 */     EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty)getOptRecord().lookup(129);
/* 144 */     return (escherSimpleProperty == null) ? 0 : escherSimpleProperty.getPropertyValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMarginLeft(int paramInt) {
/* 151 */     setPropertyValue((EscherProperty)new EscherSimpleProperty((short)129, paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMarginRight() {
/* 158 */     EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty)getOptRecord().lookup(131);
/* 159 */     return (escherSimpleProperty == null) ? 0 : escherSimpleProperty.getPropertyValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMarginRight(int paramInt) {
/* 166 */     setPropertyValue((EscherProperty)new EscherSimpleProperty((short)131, paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMarginTop() {
/* 173 */     EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty)getOptRecord().lookup(130);
/* 174 */     return (escherSimpleProperty == null) ? 0 : escherSimpleProperty.getPropertyValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMarginTop(int paramInt) {
/* 181 */     setPropertyValue((EscherProperty)new EscherSimpleProperty((short)130, paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMarginBottom() {
/* 188 */     EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty)getOptRecord().lookup(132);
/* 189 */     return (escherSimpleProperty == null) ? 0 : escherSimpleProperty.getPropertyValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMarginBottom(int paramInt) {
/* 196 */     setPropertyValue((EscherProperty)new EscherSimpleProperty((short)132, paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getHorizontalAlignment() {
/* 203 */     return (short)getTextObjectRecord().getHorizontalTextAlignment();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHorizontalAlignment(short paramShort) {
/* 210 */     getTextObjectRecord().setHorizontalTextAlignment(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getVerticalAlignment() {
/* 217 */     return (short)getTextObjectRecord().getVerticalTextAlignment();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVerticalAlignment(short paramShort) {
/* 224 */     getTextObjectRecord().setVerticalTextAlignment(paramShort);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setShapeType(int paramInt) {
/* 229 */     throw new IllegalStateException("Shape type can not be changed in " + getClass().getSimpleName());
/*     */   }
/*     */ 
/*     */   
/*     */   protected HSSFShape cloneShape() {
/* 234 */     TextObjectRecord textObjectRecord = (getTextObjectRecord() == null) ? null : (TextObjectRecord)getTextObjectRecord().cloneViaReserialise();
/* 235 */     EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
/* 236 */     byte[] arrayOfByte = getEscherContainer().serialize();
/* 237 */     escherContainerRecord.fillFields(arrayOfByte, 0, (EscherRecordFactory)new DefaultEscherRecordFactory());
/* 238 */     ObjRecord objRecord = (ObjRecord)getObjRecord().cloneViaReserialise();
/* 239 */     return new HSSFTextbox(escherContainerRecord, objRecord, textObjectRecord);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void afterRemove(HSSFPatriarch paramHSSFPatriarch) {
/* 244 */     paramHSSFPatriarch.getBoundAggregate().removeShapeToObjRecord(getEscherContainer().getChildById((short)-4079));
/* 245 */     paramHSSFPatriarch.getBoundAggregate().removeShapeToObjRecord(getEscherContainer().getChildById((short)-4083));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFTextbox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */