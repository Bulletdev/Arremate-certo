/*    */ package org.apache.commons.text.lookup;
/*    */ 
/*    */ import java.util.Date;
/*    */ import org.apache.commons.lang3.time.FastDateFormat;
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
/*    */ final class DateStringLookup
/*    */   extends AbstractStringLookup
/*    */ {
/* 52 */   static final DateStringLookup INSTANCE = new DateStringLookup();
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
/*    */   private String formatDate(long paramLong, String paramString) {
/* 69 */     FastDateFormat fastDateFormat = null;
/* 70 */     if (paramString != null) {
/*    */       try {
/* 72 */         fastDateFormat = FastDateFormat.getInstance(paramString);
/* 73 */       } catch (Exception exception) {
/* 74 */         throw IllegalArgumentExceptions.format(exception, "Invalid date format: [%s]", new Object[] { paramString });
/*    */       } 
/*    */     }
/* 77 */     if (fastDateFormat == null) {
/* 78 */       fastDateFormat = FastDateFormat.getInstance();
/*    */     }
/* 80 */     return fastDateFormat.format(new Date(paramLong));
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
/*    */   public String lookup(String paramString) {
/* 92 */     return formatDate(System.currentTimeMillis(), paramString);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\lookup\DateStringLookup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */