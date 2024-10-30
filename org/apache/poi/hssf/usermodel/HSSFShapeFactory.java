/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.ddf.EscherClientDataRecord;
/*     */ import org.apache.poi.ddf.EscherContainerRecord;
/*     */ import org.apache.poi.ddf.EscherOptRecord;
/*     */ import org.apache.poi.ddf.EscherProperty;
/*     */ import org.apache.poi.ddf.EscherRecord;
/*     */ import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
/*     */ import org.apache.poi.hssf.record.EscherAggregate;
/*     */ import org.apache.poi.hssf.record.ObjRecord;
/*     */ import org.apache.poi.hssf.record.SubRecord;
/*     */ import org.apache.poi.hssf.record.TextObjectRecord;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryEntry;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryNode;
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
/*     */ public class HSSFShapeFactory
/*     */ {
/*     */   public static void createShapeTree(EscherContainerRecord paramEscherContainerRecord, EscherAggregate paramEscherAggregate, HSSFShapeContainer paramHSSFShapeContainer, DirectoryNode paramDirectoryNode) {
/*  40 */     if (paramEscherContainerRecord.getRecordId() == -4093) {
/*  41 */       ObjRecord objRecord = null;
/*  42 */       EscherClientDataRecord escherClientDataRecord = (EscherClientDataRecord)((EscherContainerRecord)paramEscherContainerRecord.getChild(0)).getChildById((short)-4079);
/*  43 */       if (null != escherClientDataRecord) {
/*  44 */         objRecord = (ObjRecord)paramEscherAggregate.getShapeToObjMapping().get(escherClientDataRecord);
/*     */       }
/*  46 */       HSSFShapeGroup hSSFShapeGroup = new HSSFShapeGroup(paramEscherContainerRecord, objRecord);
/*  47 */       List<EscherContainerRecord> list = paramEscherContainerRecord.getChildContainers();
/*     */       
/*  49 */       for (byte b = 0; b < list.size(); b++) {
/*  50 */         EscherContainerRecord escherContainerRecord = list.get(b);
/*  51 */         if (b != 0) {
/*  52 */           createShapeTree(escherContainerRecord, paramEscherAggregate, hSSFShapeGroup, paramDirectoryNode);
/*     */         }
/*     */       } 
/*  55 */       paramHSSFShapeContainer.addShape(hSSFShapeGroup);
/*  56 */     } else if (paramEscherContainerRecord.getRecordId() == -4092) {
/*  57 */       HSSFPicture hSSFPicture; HSSFSimpleShape hSSFSimpleShape; EscherOptRecord escherOptRecord; EscherProperty escherProperty; Map map = paramEscherAggregate.getShapeToObjMapping();
/*  58 */       ObjRecord objRecord = null;
/*  59 */       TextObjectRecord textObjectRecord = null;
/*     */       
/*  61 */       for (EscherRecord escherRecord : paramEscherContainerRecord.getChildRecords()) {
/*  62 */         switch (escherRecord.getRecordId()) {
/*     */           case -4079:
/*  64 */             objRecord = (ObjRecord)map.get(escherRecord);
/*     */           
/*     */           case -4083:
/*  67 */             textObjectRecord = (TextObjectRecord)map.get(escherRecord);
/*     */         } 
/*     */ 
/*     */ 
/*     */       
/*     */       } 
/*  73 */       if (isEmbeddedObject(objRecord)) {
/*  74 */         HSSFObjectData hSSFObjectData = new HSSFObjectData(paramEscherContainerRecord, objRecord, (DirectoryEntry)paramDirectoryNode);
/*  75 */         paramHSSFShapeContainer.addShape(hSSFObjectData);
/*     */         return;
/*     */       } 
/*  78 */       CommonObjectDataSubRecord commonObjectDataSubRecord = objRecord.getSubRecords().get(0);
/*     */       
/*  80 */       switch (commonObjectDataSubRecord.getObjectType()) {
/*     */         case 8:
/*  82 */           hSSFPicture = new HSSFPicture(paramEscherContainerRecord, objRecord);
/*     */           break;
/*     */         case 2:
/*  85 */           hSSFSimpleShape = new HSSFSimpleShape(paramEscherContainerRecord, objRecord, textObjectRecord);
/*     */           break;
/*     */         case 1:
/*  88 */           hSSFSimpleShape = new HSSFSimpleShape(paramEscherContainerRecord, objRecord);
/*     */           break;
/*     */         case 20:
/*  91 */           hSSFSimpleShape = new HSSFCombobox(paramEscherContainerRecord, objRecord);
/*     */           break;
/*     */         case 30:
/*  94 */           escherOptRecord = (EscherOptRecord)paramEscherContainerRecord.getChildById((short)-4085);
/*  95 */           if (escherOptRecord == null) {
/*  96 */             hSSFSimpleShape = new HSSFSimpleShape(paramEscherContainerRecord, objRecord, textObjectRecord); break;
/*     */           } 
/*  98 */           escherProperty = escherOptRecord.lookup(325);
/*  99 */           if (null != escherProperty) {
/* 100 */             hSSFSimpleShape = new HSSFPolygon(paramEscherContainerRecord, objRecord, textObjectRecord); break;
/*     */           } 
/* 102 */           hSSFSimpleShape = new HSSFSimpleShape(paramEscherContainerRecord, objRecord, textObjectRecord);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 6:
/* 107 */           hSSFSimpleShape = new HSSFTextbox(paramEscherContainerRecord, objRecord, textObjectRecord);
/*     */           break;
/*     */         case 25:
/* 110 */           hSSFSimpleShape = new HSSFComment(paramEscherContainerRecord, objRecord, textObjectRecord, paramEscherAggregate.getNoteRecordByObj(objRecord));
/*     */           break;
/*     */         default:
/* 113 */           hSSFSimpleShape = new HSSFSimpleShape(paramEscherContainerRecord, objRecord, textObjectRecord); break;
/*     */       } 
/* 115 */       paramHSSFShapeContainer.addShape(hSSFSimpleShape);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static boolean isEmbeddedObject(ObjRecord paramObjRecord) {
/* 120 */     Iterator<SubRecord> iterator = paramObjRecord.getSubRecords().iterator();
/* 121 */     while (iterator.hasNext()) {
/* 122 */       SubRecord subRecord = iterator.next();
/* 123 */       if (subRecord instanceof org.apache.poi.hssf.record.EmbeddedObjectRefSubRecord) {
/* 124 */         return true;
/*     */       }
/*     */     } 
/* 127 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFShapeFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */