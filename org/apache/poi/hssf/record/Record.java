/*    */ package org.apache.poi.hssf.record;
/*    */ 
/*    */ import java.io.ByteArrayInputStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class Record
/*    */   extends RecordBase
/*    */ {
/*    */   public final byte[] serialize() {
/* 39 */     byte[] arrayOfByte = new byte[getRecordSize()];
/*    */     
/* 41 */     serialize(0, arrayOfByte);
/* 42 */     return arrayOfByte;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 50 */     return super.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract short getSid();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Object clone() throws CloneNotSupportedException {
/* 62 */     throw new CloneNotSupportedException("The class " + getClass().getName() + " needs to define a clone method");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Record cloneViaReserialise() {
/* 79 */     byte[] arrayOfByte = serialize();
/* 80 */     RecordInputStream recordInputStream = new RecordInputStream(new ByteArrayInputStream(arrayOfByte));
/* 81 */     recordInputStream.nextRecord();
/*    */     
/* 83 */     Record[] arrayOfRecord = RecordFactory.createRecord(recordInputStream);
/* 84 */     if (arrayOfRecord.length != 1) {
/* 85 */       throw new IllegalStateException("Re-serialised a record to clone it, but got " + arrayOfRecord.length + " records back!");
/*    */     }
/* 87 */     return arrayOfRecord[0];
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\Record.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */