/*    */ package org.apache.poi.hssf.record;
/*    */ 
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import org.apache.poi.util.CodePageUtil;
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
/*    */ public final class OldStringRecord
/*    */ {
/*    */   public static final short biff2_sid = 7;
/*    */   public static final short biff345_sid = 519;
/*    */   private short sid;
/*    */   private short field_1_string_len;
/*    */   private byte[] field_2_bytes;
/*    */   private CodepageRecord codepage;
/*    */   
/*    */   public OldStringRecord(RecordInputStream paramRecordInputStream) {
/* 42 */     this.sid = paramRecordInputStream.getSid();
/*    */     
/* 44 */     if (paramRecordInputStream.getSid() == 7) {
/* 45 */       this.field_1_string_len = (short)paramRecordInputStream.readUByte();
/*    */     } else {
/* 47 */       this.field_1_string_len = paramRecordInputStream.readShort();
/*    */     } 
/*    */ 
/*    */     
/* 51 */     this.field_2_bytes = new byte[this.field_1_string_len];
/* 52 */     paramRecordInputStream.read(this.field_2_bytes, 0, this.field_1_string_len);
/*    */   }
/*    */   
/*    */   public boolean isBiff2() {
/* 56 */     return (this.sid == 7);
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 60 */     return this.sid;
/*    */   }
/*    */   
/*    */   public void setCodePage(CodepageRecord paramCodepageRecord) {
/* 64 */     this.codepage = paramCodepageRecord;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getString() {
/* 72 */     return getString(this.field_2_bytes, this.codepage);
/*    */   }
/*    */   
/*    */   protected static String getString(byte[] paramArrayOfbyte, CodepageRecord paramCodepageRecord) {
/* 76 */     int i = 28591;
/* 77 */     if (paramCodepageRecord != null) {
/* 78 */       i = paramCodepageRecord.getCodepage() & 0xFFFF;
/*    */     }
/*    */     try {
/* 81 */       return CodePageUtil.getStringFromCodePage(paramArrayOfbyte, i);
/* 82 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 83 */       throw new IllegalArgumentException("Unsupported codepage requested", unsupportedEncodingException);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 91 */     stringBuffer.append("[OLD STRING]\n");
/* 92 */     stringBuffer.append("    .string            = ").append(getString()).append("\n");
/*    */     
/* 94 */     stringBuffer.append("[/OLD STRING]\n");
/* 95 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\OldStringRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */