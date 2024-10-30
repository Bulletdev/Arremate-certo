/*    */ package org.apache.poi.xssf.usermodel;
/*    */ 
/*    */ import org.apache.poi.ss.usermodel.BuiltinFormats;
/*    */ import org.apache.poi.ss.usermodel.DataFormat;
/*    */ import org.apache.poi.xssf.model.StylesTable;
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
/*    */ public class XSSFDataFormat
/*    */   implements DataFormat
/*    */ {
/*    */   private final StylesTable stylesSource;
/*    */   
/*    */   protected XSSFDataFormat(StylesTable paramStylesTable) {
/* 38 */     this.stylesSource = paramStylesTable;
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
/*    */   public short getFormat(String paramString) {
/* 51 */     int i = BuiltinFormats.getBuiltinFormat(paramString);
/* 52 */     if (i == -1) i = this.stylesSource.putNumberFormat(paramString); 
/* 53 */     return (short)i;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getFormat(short paramShort) {
/* 63 */     return getFormat(paramShort & 0xFFFF);
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
/*    */   public String getFormat(int paramInt) {
/* 77 */     String str = this.stylesSource.getNumberFormatAt(paramInt);
/* 78 */     if (str == null) str = BuiltinFormats.getBuiltinFormat(paramInt); 
/* 79 */     return str;
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
/*    */   public void putFormat(short paramShort, String paramString) {
/* 92 */     this.stylesSource.putNumberFormat(paramShort, paramString);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFDataFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */