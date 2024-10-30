/*    */ package ch.qos.logback.core.property;
/*    */ 
/*    */ import ch.qos.logback.core.PropertyDefinerBase;
/*    */ import ch.qos.logback.core.util.Loader;
/*    */ import ch.qos.logback.core.util.OptionHelper;
/*    */ import java.net.URL;
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
/*    */ public class ResourceExistsPropertyDefiner
/*    */   extends PropertyDefinerBase
/*    */ {
/*    */   String resourceStr;
/*    */   
/*    */   public String getResource() {
/* 38 */     return this.resourceStr;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setResource(String paramString) {
/* 47 */     this.resourceStr = paramString;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getPropertyValue() {
/* 57 */     if (OptionHelper.isEmpty(this.resourceStr)) {
/* 58 */       addError("The \"resource\" property must be set.");
/* 59 */       return null;
/*    */     } 
/*    */     
/* 62 */     URL uRL = Loader.getResourceBySelfClassLoader(this.resourceStr);
/* 63 */     return booleanAsStr((uRL != null));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\property\ResourceExistsPropertyDefiner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */