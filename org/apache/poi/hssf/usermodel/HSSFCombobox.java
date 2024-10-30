/*    */ package org.apache.poi.hssf.usermodel;
/*    */ 
/*    */ import org.apache.poi.ddf.EscherBoolProperty;
/*    */ import org.apache.poi.ddf.EscherClientDataRecord;
/*    */ import org.apache.poi.ddf.EscherContainerRecord;
/*    */ import org.apache.poi.ddf.EscherOptRecord;
/*    */ import org.apache.poi.ddf.EscherProperty;
/*    */ import org.apache.poi.ddf.EscherRecord;
/*    */ import org.apache.poi.ddf.EscherSimpleProperty;
/*    */ import org.apache.poi.ddf.EscherSpRecord;
/*    */ import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
/*    */ import org.apache.poi.hssf.record.EndSubRecord;
/*    */ import org.apache.poi.hssf.record.FtCblsSubRecord;
/*    */ import org.apache.poi.hssf.record.LbsDataSubRecord;
/*    */ import org.apache.poi.hssf.record.ObjRecord;
/*    */ import org.apache.poi.hssf.record.SubRecord;
/*    */ import org.apache.poi.hssf.record.TextObjectRecord;
/*    */ import org.apache.poi.ss.usermodel.ClientAnchor;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HSSFCombobox
/*    */   extends HSSFSimpleShape
/*    */ {
/*    */   public HSSFCombobox(EscherContainerRecord paramEscherContainerRecord, ObjRecord paramObjRecord) {
/* 30 */     super(paramEscherContainerRecord, paramObjRecord);
/*    */   }
/*    */   
/*    */   public HSSFCombobox(HSSFShape paramHSSFShape, HSSFAnchor paramHSSFAnchor) {
/* 34 */     super(paramHSSFShape, paramHSSFAnchor);
/* 35 */     super.setShapeType(201);
/* 36 */     CommonObjectDataSubRecord commonObjectDataSubRecord = getObjRecord().getSubRecords().get(0);
/* 37 */     commonObjectDataSubRecord.setObjectType((short)20);
/*    */   }
/*    */ 
/*    */   
/*    */   protected TextObjectRecord createTextObjRecord() {
/* 42 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   protected EscherContainerRecord createSpContainer() {
/* 47 */     EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
/* 48 */     EscherSpRecord escherSpRecord = new EscherSpRecord();
/* 49 */     EscherOptRecord escherOptRecord = new EscherOptRecord();
/* 50 */     EscherClientDataRecord escherClientDataRecord = new EscherClientDataRecord();
/*    */     
/* 52 */     escherContainerRecord.setRecordId((short)-4092);
/* 53 */     escherContainerRecord.setOptions((short)15);
/* 54 */     escherSpRecord.setRecordId((short)-4086);
/* 55 */     escherSpRecord.setOptions((short)3218);
/*    */     
/* 57 */     escherSpRecord.setFlags(2560);
/* 58 */     escherOptRecord.setRecordId((short)-4085);
/* 59 */     escherOptRecord.addEscherProperty((EscherProperty)new EscherBoolProperty((short)127, 17039620));
/* 60 */     escherOptRecord.addEscherProperty((EscherProperty)new EscherBoolProperty((short)191, 524296));
/* 61 */     escherOptRecord.addEscherProperty((EscherProperty)new EscherBoolProperty((short)511, 524288));
/* 62 */     escherOptRecord.addEscherProperty((EscherProperty)new EscherSimpleProperty((short)959, 131072));
/*    */     
/* 64 */     HSSFClientAnchor hSSFClientAnchor = (HSSFClientAnchor)getAnchor();
/* 65 */     hSSFClientAnchor.setAnchorType(ClientAnchor.AnchorType.DONT_MOVE_DO_RESIZE);
/* 66 */     EscherRecord escherRecord = hSSFClientAnchor.getEscherAnchor();
/* 67 */     escherClientDataRecord.setRecordId((short)-4079);
/* 68 */     escherClientDataRecord.setOptions((short)0);
/*    */     
/* 70 */     escherContainerRecord.addChildRecord((EscherRecord)escherSpRecord);
/* 71 */     escherContainerRecord.addChildRecord((EscherRecord)escherOptRecord);
/* 72 */     escherContainerRecord.addChildRecord(escherRecord);
/* 73 */     escherContainerRecord.addChildRecord((EscherRecord)escherClientDataRecord);
/*    */     
/* 75 */     return escherContainerRecord;
/*    */   }
/*    */ 
/*    */   
/*    */   protected ObjRecord createObjRecord() {
/* 80 */     ObjRecord objRecord = new ObjRecord();
/* 81 */     CommonObjectDataSubRecord commonObjectDataSubRecord = new CommonObjectDataSubRecord();
/* 82 */     commonObjectDataSubRecord.setObjectType((short)201);
/* 83 */     commonObjectDataSubRecord.setLocked(true);
/* 84 */     commonObjectDataSubRecord.setPrintable(false);
/* 85 */     commonObjectDataSubRecord.setAutofill(true);
/* 86 */     commonObjectDataSubRecord.setAutoline(false);
/* 87 */     FtCblsSubRecord ftCblsSubRecord = new FtCblsSubRecord();
/* 88 */     LbsDataSubRecord lbsDataSubRecord = LbsDataSubRecord.newAutoFilterInstance();
/* 89 */     EndSubRecord endSubRecord = new EndSubRecord();
/* 90 */     objRecord.addSubRecord((SubRecord)commonObjectDataSubRecord);
/* 91 */     objRecord.addSubRecord((SubRecord)ftCblsSubRecord);
/* 92 */     objRecord.addSubRecord((SubRecord)lbsDataSubRecord);
/* 93 */     objRecord.addSubRecord((SubRecord)endSubRecord);
/* 94 */     return objRecord;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setShapeType(int paramInt) {
/* 99 */     throw new IllegalStateException("Shape type can not be changed in " + getClass().getSimpleName());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFCombobox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */