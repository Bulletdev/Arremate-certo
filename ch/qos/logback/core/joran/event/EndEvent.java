/*    */ package ch.qos.logback.core.joran.event;
/*    */ 
/*    */ import org.xml.sax.Locator;
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
/*    */ public class EndEvent
/*    */   extends SaxEvent
/*    */ {
/*    */   EndEvent(String paramString1, String paramString2, String paramString3, Locator paramLocator) {
/* 21 */     super(paramString1, paramString2, paramString3, paramLocator);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 26 */     return "  EndEvent(" + getQName() + ")  [" + this.locator.getLineNumber() + "," + this.locator.getColumnNumber() + "]";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\event\EndEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */