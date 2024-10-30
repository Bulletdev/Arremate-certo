/*    */ package org.apache.poi.hssf.record;
/*    */ 
/*    */ import org.apache.poi.hssf.record.common.UnicodeString;
/*    */ import org.apache.poi.util.IntMapper;
/*    */ import org.apache.poi.util.POILogFactory;
/*    */ import org.apache.poi.util.POILogger;
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
/*    */ class SSTDeserializer
/*    */ {
/* 35 */   private static POILogger logger = POILogFactory.getLogger(SSTDeserializer.class);
/*    */   
/*    */   private IntMapper<UnicodeString> strings;
/*    */   
/*    */   public SSTDeserializer(IntMapper<UnicodeString> paramIntMapper) {
/* 40 */     this.strings = paramIntMapper;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void manufactureStrings(int paramInt, RecordInputStream paramRecordInputStream) {
/* 50 */     for (byte b = 0; b < paramInt; b++) {
/*    */       UnicodeString unicodeString;
/*    */       
/* 53 */       if (paramRecordInputStream.available() == 0 && !paramRecordInputStream.hasNextRecord()) {
/* 54 */         logger.log(7, new Object[] { "Ran out of data before creating all the strings! String at index " + b + "" });
/* 55 */         unicodeString = new UnicodeString("");
/*    */       } else {
/* 57 */         unicodeString = new UnicodeString(paramRecordInputStream);
/*    */       } 
/* 59 */       addToStringTable(this.strings, unicodeString);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void addToStringTable(IntMapper<UnicodeString> paramIntMapper, UnicodeString paramUnicodeString) {
/* 65 */     paramIntMapper.add(paramUnicodeString);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\SSTDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */