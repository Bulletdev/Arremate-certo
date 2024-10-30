/*    */ package org.apache.poi.ss.format;
/*    */ 
/*    */ import java.util.Formatter;
/*    */ import java.util.Locale;
/*    */ import org.apache.poi.util.LocaleUtil;
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
/*    */ public class CellGeneralFormatter
/*    */   extends CellFormatter
/*    */ {
/*    */   public CellGeneralFormatter() {
/* 32 */     super("General");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void formatValue(StringBuffer paramStringBuffer, Object paramObject) {
/* 43 */     if (paramObject instanceof Number) {
/* 44 */       String str; double d1 = ((Number)paramObject).doubleValue();
/* 45 */       if (d1 == 0.0D) {
/* 46 */         paramStringBuffer.append('0');
/*    */         
/*    */         return;
/*    */       } 
/*    */       
/* 51 */       double d2 = Math.log10(Math.abs(d1));
/* 52 */       boolean bool = true;
/* 53 */       if (d2 > 10.0D || d2 < -9.0D) {
/* 54 */         str = "%1.5E";
/* 55 */       } else if ((long)d1 != d1) {
/* 56 */         str = "%1.9f";
/*    */       } else {
/* 58 */         str = "%1.0f";
/* 59 */         bool = false;
/*    */       } 
/*    */       
/* 62 */       Formatter formatter = new Formatter(paramStringBuffer, LocaleUtil.getUserLocale());
/*    */       try {
/* 64 */         formatter.format(LocaleUtil.getUserLocale(), str, new Object[] { paramObject });
/*    */       } finally {
/* 66 */         formatter.close();
/*    */       } 
/* 68 */       if (bool) {
/*    */         int i;
/*    */         
/* 71 */         if (str.endsWith("E")) {
/* 72 */           i = paramStringBuffer.lastIndexOf("E") - 1;
/*    */         } else {
/* 74 */           i = paramStringBuffer.length() - 1;
/* 75 */         }  while (paramStringBuffer.charAt(i) == '0') {
/* 76 */           paramStringBuffer.deleteCharAt(i--);
/*    */         }
/* 78 */         if (paramStringBuffer.charAt(i) == '.') {
/* 79 */           paramStringBuffer.deleteCharAt(i--);
/*    */         }
/*    */       } 
/* 82 */     } else if (paramObject instanceof Boolean) {
/* 83 */       paramStringBuffer.append(paramObject.toString().toUpperCase(Locale.ROOT));
/*    */     } else {
/* 85 */       paramStringBuffer.append(paramObject.toString());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void simpleValue(StringBuffer paramStringBuffer, Object paramObject) {
/* 91 */     formatValue(paramStringBuffer, paramObject);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\format\CellGeneralFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */