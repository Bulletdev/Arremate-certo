/*    */ package ch.qos.logback.classic.pattern;
/*    */ 
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*    */ import ch.qos.logback.core.util.OptionHelper;
/*    */ import java.util.Map;
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
/*    */ public class MDCConverter
/*    */   extends ClassicConverter
/*    */ {
/*    */   private String key;
/* 25 */   private String defaultValue = "";
/*    */ 
/*    */   
/*    */   public void start() {
/* 29 */     String[] arrayOfString = OptionHelper.extractDefaultReplacement(getFirstOption());
/* 30 */     this.key = arrayOfString[0];
/* 31 */     if (arrayOfString[1] != null) {
/* 32 */       this.defaultValue = arrayOfString[1];
/*    */     }
/* 34 */     super.start();
/*    */   }
/*    */ 
/*    */   
/*    */   public void stop() {
/* 39 */     this.key = null;
/* 40 */     super.stop();
/*    */   }
/*    */ 
/*    */   
/*    */   public String convert(ILoggingEvent paramILoggingEvent) {
/* 45 */     Map<String, String> map = paramILoggingEvent.getMDCPropertyMap();
/*    */     
/* 47 */     if (map == null) {
/* 48 */       return this.defaultValue;
/*    */     }
/*    */     
/* 51 */     if (this.key == null) {
/* 52 */       return outputMDCForAllKeys(map);
/*    */     }
/*    */     
/* 55 */     String str = map.get(this.key);
/* 56 */     if (str != null) {
/* 57 */       return str;
/*    */     }
/* 59 */     return this.defaultValue;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private String outputMDCForAllKeys(Map<String, String> paramMap) {
/* 68 */     StringBuilder stringBuilder = new StringBuilder();
/* 69 */     boolean bool = true;
/* 70 */     for (Map.Entry<String, String> entry : paramMap.entrySet()) {
/* 71 */       if (bool) {
/* 72 */         bool = false;
/*    */       } else {
/* 74 */         stringBuilder.append(", ");
/*    */       } 
/*    */       
/* 77 */       stringBuilder.append((String)entry.getKey()).append('=').append((String)entry.getValue());
/*    */     } 
/* 79 */     return stringBuilder.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getKey() {
/* 87 */     return this.key;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\pattern\MDCConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */