/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Iterator;
/*     */ import org.apache.poi.ddf.DefaultEscherRecordFactory;
/*     */ import org.apache.poi.ddf.EscherBSERecord;
/*     */ import org.apache.poi.ddf.EscherContainerRecord;
/*     */ import org.apache.poi.ddf.EscherRecordFactory;
/*     */ import org.apache.poi.hssf.record.EmbeddedObjectRefSubRecord;
/*     */ import org.apache.poi.hssf.record.EscherAggregate;
/*     */ import org.apache.poi.hssf.record.ObjRecord;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryEntry;
/*     */ import org.apache.poi.poifs.filesystem.Entry;
/*     */ import org.apache.poi.util.HexDump;
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
/*     */ public final class HSSFObjectData
/*     */   extends HSSFPicture
/*     */ {
/*     */   private final DirectoryEntry _root;
/*     */   
/*     */   public HSSFObjectData(EscherContainerRecord paramEscherContainerRecord, ObjRecord paramObjRecord, DirectoryEntry paramDirectoryEntry) {
/*  42 */     super(paramEscherContainerRecord, paramObjRecord);
/*  43 */     this._root = paramDirectoryEntry;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOLE2ClassName() {
/*  50 */     return findObjectRecord().getOLEClassName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DirectoryEntry getDirectory() throws IOException {
/*  61 */     EmbeddedObjectRefSubRecord embeddedObjectRefSubRecord = findObjectRecord();
/*     */     
/*  63 */     int i = embeddedObjectRefSubRecord.getStreamId().intValue();
/*  64 */     String str = "MBD" + HexDump.toHex(i);
/*     */     
/*  66 */     Entry entry = this._root.getEntry(str);
/*  67 */     if (entry instanceof DirectoryEntry) {
/*  68 */       return (DirectoryEntry)entry;
/*     */     }
/*  70 */     throw new IOException("Stream " + str + " was not an OLE2 directory");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getObjectData() {
/*  79 */     return findObjectRecord().getObjectData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasDirectoryEntry() {
/*  88 */     EmbeddedObjectRefSubRecord embeddedObjectRefSubRecord = findObjectRecord();
/*     */ 
/*     */     
/*  91 */     Integer integer = embeddedObjectRefSubRecord.getStreamId();
/*  92 */     return (integer != null && integer.intValue() != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected EmbeddedObjectRefSubRecord findObjectRecord() {
/* 100 */     Iterator<Object> iterator = getObjRecord().getSubRecords().iterator();
/*     */     
/* 102 */     while (iterator.hasNext()) {
/* 103 */       EmbeddedObjectRefSubRecord embeddedObjectRefSubRecord = (EmbeddedObjectRefSubRecord)iterator.next();
/* 104 */       if (embeddedObjectRefSubRecord instanceof EmbeddedObjectRefSubRecord) {
/* 105 */         return embeddedObjectRefSubRecord;
/*     */       }
/*     */     } 
/*     */     
/* 109 */     throw new IllegalStateException("Object data does not contain a reference to an embedded object OLE2 directory");
/*     */   }
/*     */ 
/*     */   
/*     */   protected EscherContainerRecord createSpContainer() {
/* 114 */     throw new IllegalStateException("HSSFObjectData cannot be created from scratch");
/*     */   }
/*     */ 
/*     */   
/*     */   protected ObjRecord createObjRecord() {
/* 119 */     throw new IllegalStateException("HSSFObjectData cannot be created from scratch");
/*     */   }
/*     */ 
/*     */   
/*     */   protected void afterRemove(HSSFPatriarch paramHSSFPatriarch) {
/* 124 */     throw new IllegalStateException("HSSFObjectData cannot be created from scratch");
/*     */   }
/*     */ 
/*     */   
/*     */   void afterInsert(HSSFPatriarch paramHSSFPatriarch) {
/* 129 */     EscherAggregate escherAggregate = paramHSSFPatriarch.getBoundAggregate();
/* 130 */     escherAggregate.associateShapeToObjRecord(getEscherContainer().getChildById((short)-4079), (Record)getObjRecord());
/* 131 */     EscherBSERecord escherBSERecord = paramHSSFPatriarch.getSheet().getWorkbook().getWorkbook().getBSERecord(getPictureIndex());
/*     */     
/* 133 */     escherBSERecord.setRef(escherBSERecord.getRef() + 1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected HSSFShape cloneShape() {
/* 138 */     EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
/* 139 */     byte[] arrayOfByte = getEscherContainer().serialize();
/* 140 */     escherContainerRecord.fillFields(arrayOfByte, 0, (EscherRecordFactory)new DefaultEscherRecordFactory());
/* 141 */     ObjRecord objRecord = (ObjRecord)getObjRecord().cloneViaReserialise();
/* 142 */     return new HSSFObjectData(escherContainerRecord, objRecord, this._root);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFObjectData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */