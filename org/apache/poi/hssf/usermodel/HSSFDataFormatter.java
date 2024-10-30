/*    */ package org.apache.poi.hssf.usermodel;
/*    */ 
/*    */ import java.util.Locale;
/*    */ import org.apache.poi.ss.usermodel.DataFormatter;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class HSSFDataFormatter
/*    */   extends DataFormatter
/*    */ {
/*    */   public HSSFDataFormatter(Locale paramLocale) {
/* 72 */     super(paramLocale);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public HSSFDataFormatter() {
/* 79 */     this(LocaleUtil.getUserLocale());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFDataFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */