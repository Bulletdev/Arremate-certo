/*    */ package org.apache.http.protocol;
/*    */ 
/*    */ import java.text.DateFormat;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import java.util.Locale;
/*    */ import java.util.TimeZone;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
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
/*    */ @Contract(threading = ThreadingBehavior.SAFE)
/*    */ public class HttpDateGenerator
/*    */ {
/*    */   public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";
/* 52 */   public static final TimeZone GMT = TimeZone.getTimeZone("GMT");
/*    */   
/*    */   private final DateFormat dateformat;
/* 55 */   private long dateAsLong = 0L;
/* 56 */   private String dateAsText = null;
/*    */ 
/*    */   
/*    */   public HttpDateGenerator() {
/* 60 */     this.dateformat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
/* 61 */     this.dateformat.setTimeZone(GMT);
/*    */   }
/*    */   
/*    */   public synchronized String getCurrentDate() {
/* 65 */     long l = System.currentTimeMillis();
/* 66 */     if (l - this.dateAsLong > 1000L) {
/*    */       
/* 68 */       this.dateAsText = this.dateformat.format(new Date(l));
/* 69 */       this.dateAsLong = l;
/*    */     } 
/* 71 */     return this.dateAsText;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\protocol\HttpDateGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */