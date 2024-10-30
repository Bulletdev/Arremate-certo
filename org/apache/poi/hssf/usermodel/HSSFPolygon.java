/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.ddf.EscherArrayProperty;
/*     */ import org.apache.poi.ddf.EscherBoolProperty;
/*     */ import org.apache.poi.ddf.EscherClientDataRecord;
/*     */ import org.apache.poi.ddf.EscherContainerRecord;
/*     */ import org.apache.poi.ddf.EscherOptRecord;
/*     */ import org.apache.poi.ddf.EscherProperty;
/*     */ import org.apache.poi.ddf.EscherRGBProperty;
/*     */ import org.apache.poi.ddf.EscherRecord;
/*     */ import org.apache.poi.ddf.EscherShapePathProperty;
/*     */ import org.apache.poi.ddf.EscherSimpleProperty;
/*     */ import org.apache.poi.ddf.EscherSpRecord;
/*     */ import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
/*     */ import org.apache.poi.hssf.record.EndSubRecord;
/*     */ import org.apache.poi.hssf.record.ObjRecord;
/*     */ import org.apache.poi.hssf.record.SubRecord;
/*     */ import org.apache.poi.hssf.record.TextObjectRecord;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HSSFPolygon
/*     */   extends HSSFSimpleShape
/*     */ {
/*  30 */   private static POILogger logger = POILogFactory.getLogger(HSSFPolygon.class);
/*     */   public static final short OBJECT_TYPE_MICROSOFT_OFFICE_DRAWING = 30;
/*     */   
/*     */   public HSSFPolygon(EscherContainerRecord paramEscherContainerRecord, ObjRecord paramObjRecord, TextObjectRecord paramTextObjectRecord) {
/*  34 */     super(paramEscherContainerRecord, paramObjRecord, paramTextObjectRecord);
/*     */   }
/*     */   
/*     */   public HSSFPolygon(EscherContainerRecord paramEscherContainerRecord, ObjRecord paramObjRecord) {
/*  38 */     super(paramEscherContainerRecord, paramObjRecord);
/*     */   }
/*     */   
/*     */   HSSFPolygon(HSSFShape paramHSSFShape, HSSFAnchor paramHSSFAnchor) {
/*  42 */     super(paramHSSFShape, paramHSSFAnchor);
/*     */   }
/*     */ 
/*     */   
/*     */   protected TextObjectRecord createTextObjRecord() {
/*  47 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected EscherContainerRecord createSpContainer() {
/*  54 */     EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
/*  55 */     EscherSpRecord escherSpRecord = new EscherSpRecord();
/*  56 */     EscherOptRecord escherOptRecord = new EscherOptRecord();
/*  57 */     EscherClientDataRecord escherClientDataRecord = new EscherClientDataRecord();
/*     */     
/*  59 */     escherContainerRecord.setRecordId((short)-4092);
/*  60 */     escherContainerRecord.setOptions((short)15);
/*  61 */     escherSpRecord.setRecordId((short)-4086);
/*  62 */     escherSpRecord.setOptions((short)2);
/*  63 */     if (getParent() == null) {
/*  64 */       escherSpRecord.setFlags(2560);
/*     */     } else {
/*  66 */       escherSpRecord.setFlags(2562);
/*     */     } 
/*  68 */     escherOptRecord.setRecordId((short)-4085);
/*  69 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherSimpleProperty((short)4, false, false, 0));
/*  70 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherSimpleProperty((short)322, false, false, 100));
/*  71 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherSimpleProperty((short)323, false, false, 100));
/*  72 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherShapePathProperty((short)324, 4));
/*     */     
/*  74 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherSimpleProperty((short)383, false, false, 65537));
/*  75 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherSimpleProperty((short)464, false, false, 0));
/*  76 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherSimpleProperty((short)465, false, false, 0));
/*  77 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherSimpleProperty((short)471, false, false, 0));
/*     */     
/*  79 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherSimpleProperty((short)462, 0));
/*  80 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherBoolProperty((short)511, 524296));
/*  81 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherSimpleProperty((short)459, 9525));
/*  82 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherRGBProperty((short)385, 134217737));
/*  83 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherRGBProperty((short)448, 134217792));
/*  84 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherBoolProperty((short)447, 1));
/*     */     
/*  86 */     escherOptRecord.setEscherProperty((EscherProperty)new EscherBoolProperty((short)959, 524288));
/*     */     
/*  88 */     EscherRecord escherRecord = getAnchor().getEscherAnchor();
/*  89 */     escherClientDataRecord.setRecordId((short)-4079);
/*  90 */     escherClientDataRecord.setOptions((short)0);
/*     */     
/*  92 */     escherContainerRecord.addChildRecord((EscherRecord)escherSpRecord);
/*  93 */     escherContainerRecord.addChildRecord((EscherRecord)escherOptRecord);
/*  94 */     escherContainerRecord.addChildRecord(escherRecord);
/*  95 */     escherContainerRecord.addChildRecord((EscherRecord)escherClientDataRecord);
/*     */     
/*  97 */     return escherContainerRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ObjRecord createObjRecord() {
/* 104 */     ObjRecord objRecord = new ObjRecord();
/* 105 */     CommonObjectDataSubRecord commonObjectDataSubRecord = new CommonObjectDataSubRecord();
/* 106 */     commonObjectDataSubRecord.setObjectType((short)30);
/* 107 */     commonObjectDataSubRecord.setLocked(true);
/* 108 */     commonObjectDataSubRecord.setPrintable(true);
/* 109 */     commonObjectDataSubRecord.setAutofill(true);
/* 110 */     commonObjectDataSubRecord.setAutoline(true);
/* 111 */     EndSubRecord endSubRecord = new EndSubRecord();
/* 112 */     objRecord.addSubRecord((SubRecord)commonObjectDataSubRecord);
/* 113 */     objRecord.addSubRecord((SubRecord)endSubRecord);
/* 114 */     return objRecord;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void afterRemove(HSSFPatriarch paramHSSFPatriarch) {
/* 119 */     paramHSSFPatriarch.getBoundAggregate().removeShapeToObjRecord(getEscherContainer().getChildById((short)-4079));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getXPoints() {
/* 126 */     EscherArrayProperty escherArrayProperty = (EscherArrayProperty)getOptRecord().lookup(325);
/* 127 */     if (null == escherArrayProperty) {
/* 128 */       return new int[0];
/*     */     }
/* 130 */     int[] arrayOfInt = new int[escherArrayProperty.getNumberOfElementsInArray() - 1];
/* 131 */     for (byte b = 0; b < escherArrayProperty.getNumberOfElementsInArray() - 1; b++) {
/* 132 */       byte[] arrayOfByte = escherArrayProperty.getElement(b);
/* 133 */       short s = LittleEndian.getShort(arrayOfByte, 0);
/* 134 */       arrayOfInt[b] = s;
/*     */     } 
/* 136 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getYPoints() {
/* 143 */     EscherArrayProperty escherArrayProperty = (EscherArrayProperty)getOptRecord().lookup(325);
/* 144 */     if (null == escherArrayProperty) {
/* 145 */       return new int[0];
/*     */     }
/* 147 */     int[] arrayOfInt = new int[escherArrayProperty.getNumberOfElementsInArray() - 1];
/* 148 */     for (byte b = 0; b < escherArrayProperty.getNumberOfElementsInArray() - 1; b++) {
/* 149 */       byte[] arrayOfByte = escherArrayProperty.getElement(b);
/* 150 */       short s = LittleEndian.getShort(arrayOfByte, 2);
/* 151 */       arrayOfInt[b] = s;
/*     */     } 
/* 153 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPoints(int[] paramArrayOfint1, int[] paramArrayOfint2) {
/* 161 */     if (paramArrayOfint1.length != paramArrayOfint2.length) {
/* 162 */       logger.log(7, new Object[] { "xPoint.length must be equal to yPoints.length" });
/*     */       return;
/*     */     } 
/* 165 */     if (paramArrayOfint1.length == 0) {
/* 166 */       logger.log(7, new Object[] { "HSSFPolygon must have at least one point" });
/*     */     }
/* 168 */     EscherArrayProperty escherArrayProperty1 = new EscherArrayProperty((short)325, false, new byte[0]);
/* 169 */     escherArrayProperty1.setNumberOfElementsInArray(paramArrayOfint1.length + 1);
/* 170 */     escherArrayProperty1.setNumberOfElementsInMemory(paramArrayOfint1.length + 1);
/* 171 */     escherArrayProperty1.setSizeOfElements(65520); int i;
/* 172 */     for (i = 0; i < paramArrayOfint1.length; i++) {
/*     */       
/* 174 */       byte[] arrayOfByte1 = new byte[4];
/* 175 */       LittleEndian.putShort(arrayOfByte1, 0, (short)paramArrayOfint1[i]);
/* 176 */       LittleEndian.putShort(arrayOfByte1, 2, (short)paramArrayOfint2[i]);
/* 177 */       escherArrayProperty1.setElement(i, arrayOfByte1);
/*     */     } 
/* 179 */     i = paramArrayOfint1.length;
/* 180 */     byte[] arrayOfByte = new byte[4];
/* 181 */     LittleEndian.putShort(arrayOfByte, 0, (short)paramArrayOfint1[0]);
/* 182 */     LittleEndian.putShort(arrayOfByte, 2, (short)paramArrayOfint2[0]);
/* 183 */     escherArrayProperty1.setElement(i, arrayOfByte);
/* 184 */     setPropertyValue((EscherProperty)escherArrayProperty1);
/*     */     
/* 186 */     EscherArrayProperty escherArrayProperty2 = new EscherArrayProperty((short)326, false, null);
/* 187 */     escherArrayProperty2.setSizeOfElements(2);
/* 188 */     escherArrayProperty2.setNumberOfElementsInArray(paramArrayOfint1.length * 2 + 4);
/* 189 */     escherArrayProperty2.setNumberOfElementsInMemory(paramArrayOfint1.length * 2 + 4);
/* 190 */     escherArrayProperty2.setElement(0, new byte[] { 0, 64 });
/* 191 */     escherArrayProperty2.setElement(1, new byte[] { 0, -84 });
/* 192 */     for (byte b = 0; b < paramArrayOfint1.length; b++) {
/*     */       
/* 194 */       escherArrayProperty2.setElement(2 + b * 2, new byte[] { 1, 0 });
/* 195 */       escherArrayProperty2.setElement(3 + b * 2, new byte[] { 0, -84 });
/*     */     } 
/* 197 */     escherArrayProperty2.setElement(escherArrayProperty2.getNumberOfElementsInArray() - 2, new byte[] { 1, 96 });
/* 198 */     escherArrayProperty2.setElement(escherArrayProperty2.getNumberOfElementsInArray() - 1, new byte[] { 0, Byte.MIN_VALUE });
/* 199 */     setPropertyValue((EscherProperty)escherArrayProperty2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPolygonDrawArea(int paramInt1, int paramInt2) {
/* 208 */     setPropertyValue((EscherProperty)new EscherSimpleProperty((short)322, paramInt1));
/* 209 */     setPropertyValue((EscherProperty)new EscherSimpleProperty((short)323, paramInt2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDrawAreaWidth() {
/* 216 */     EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty)getOptRecord().lookup(322);
/* 217 */     return (escherSimpleProperty == null) ? 100 : escherSimpleProperty.getPropertyValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDrawAreaHeight() {
/* 224 */     EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty)getOptRecord().lookup(323);
/* 225 */     return (escherSimpleProperty == null) ? 100 : escherSimpleProperty.getPropertyValue();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFPolygon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */