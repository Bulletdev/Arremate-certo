/*    */ package org.apache.poi.ss.format;
/*    */ 
/*    */ import java.util.Locale;
/*    */ import java.util.regex.Matcher;
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
/*    */ public class CellTextFormatter
/*    */   extends CellFormatter
/*    */ {
/*    */   private final int[] textPos;
/*    */   private final String desc;
/* 33 */   static final CellFormatter SIMPLE_TEXT = new CellTextFormatter("@");
/*    */   
/*    */   public CellTextFormatter(String paramString) {
/* 36 */     super(paramString);
/*    */     
/* 38 */     final int[] numPlaces = new int[1];
/*    */     
/* 40 */     this.desc = CellFormatPart.parseFormat(paramString, CellFormatType.TEXT, new CellFormatPart.PartHandler()
/*    */         {
/*    */           public String handlePart(Matcher param1Matcher, String param1String, CellFormatType param1CellFormatType, StringBuffer param1StringBuffer)
/*    */           {
/* 44 */             if (param1String.equals("@")) {
/* 45 */               numPlaces[0] = numPlaces[0] + 1;
/* 46 */               return "\000";
/*    */             } 
/* 48 */             return null;
/*    */           }
/*    */         }).toString();
/*    */ 
/*    */     
/* 53 */     this.textPos = new int[arrayOfInt[0]];
/* 54 */     int i = this.desc.length() - 1;
/* 55 */     for (byte b = 0; b < this.textPos.length; b++) {
/* 56 */       this.textPos[b] = this.desc.lastIndexOf("\000", i);
/* 57 */       i = this.textPos[b] - 1;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void formatValue(StringBuffer paramStringBuffer, Object paramObject) {
/* 63 */     int i = paramStringBuffer.length();
/* 64 */     String str = paramObject.toString();
/* 65 */     if (paramObject instanceof Boolean) {
/* 66 */       str = str.toUpperCase(Locale.ROOT);
/*    */     }
/* 68 */     paramStringBuffer.append(this.desc);
/* 69 */     for (byte b = 0; b < this.textPos.length; b++) {
/* 70 */       int j = i + this.textPos[b];
/* 71 */       paramStringBuffer.replace(j, j + 1, str);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void simpleValue(StringBuffer paramStringBuffer, Object paramObject) {
/* 81 */     SIMPLE_TEXT.formatValue(paramStringBuffer, paramObject);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\format\CellTextFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */