/*    */ package ch.qos.logback.classic.sift;
/*    */ 
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*    */ import ch.qos.logback.core.sift.AbstractDiscriminator;
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
/*    */ public class MDCBasedDiscriminator
/*    */   extends AbstractDiscriminator<ILoggingEvent>
/*    */ {
/*    */   private String key;
/*    */   private String defaultValue;
/*    */   
/*    */   public String getDiscriminatingValue(ILoggingEvent paramILoggingEvent) {
/* 42 */     Map map = paramILoggingEvent.getMDCPropertyMap();
/* 43 */     if (map == null) {
/* 44 */       return this.defaultValue;
/*    */     }
/* 46 */     String str = (String)map.get(this.key);
/* 47 */     if (str == null) {
/* 48 */       return this.defaultValue;
/*    */     }
/* 50 */     return str;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void start() {
/* 56 */     byte b = 0;
/* 57 */     if (OptionHelper.isEmpty(this.key)) {
/* 58 */       b++;
/* 59 */       addError("The \"Key\" property must be set");
/*    */     } 
/* 61 */     if (OptionHelper.isEmpty(this.defaultValue)) {
/* 62 */       b++;
/* 63 */       addError("The \"DefaultValue\" property must be set");
/*    */     } 
/* 65 */     if (b == 0) {
/* 66 */       this.started = true;
/*    */     }
/*    */   }
/*    */   
/*    */   public String getKey() {
/* 71 */     return this.key;
/*    */   }
/*    */   
/*    */   public void setKey(String paramString) {
/* 75 */     this.key = paramString;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getDefaultValue() {
/* 83 */     return this.defaultValue;
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
/*    */   public void setDefaultValue(String paramString) {
/* 97 */     this.defaultValue = paramString;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\sift\MDCBasedDiscriminator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */