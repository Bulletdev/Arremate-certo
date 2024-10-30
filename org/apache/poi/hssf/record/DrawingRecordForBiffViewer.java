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
/*    */ public final class DrawingRecordForBiffViewer
/*    */   extends AbstractEscherHolderRecord
/*    */ {
/*    */   public static final short sid = 236;
/*    */   
/*    */   public DrawingRecordForBiffViewer() {}
/*    */   
/*    */   public DrawingRecordForBiffViewer(RecordInputStream paramRecordInputStream) {
/* 35 */     super(paramRecordInputStream);
/*    */   }
/*    */ 
/*    */   
/*    */   public DrawingRecordForBiffViewer(DrawingRecord paramDrawingRecord) {
/* 40 */     super(convertToInputStream(paramDrawingRecord));
/* 41 */     convertRawBytesToEscherRecords();
/*    */   }
/*    */   
/*    */   private static RecordInputStream convertToInputStream(DrawingRecord paramDrawingRecord) {
/* 45 */     byte[] arrayOfByte = paramDrawingRecord.serialize();
/* 46 */     RecordInputStream recordInputStream = new RecordInputStream(new ByteArrayInputStream(arrayOfByte));
/*    */ 
/*    */     
/* 49 */     recordInputStream.nextRecord();
/* 50 */     return recordInputStream;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getRecordName() {
/* 55 */     return "MSODRAWING";
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 60 */     return 236;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\DrawingRecordForBiffViewer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */