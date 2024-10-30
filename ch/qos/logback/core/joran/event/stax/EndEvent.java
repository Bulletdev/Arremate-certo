/*    */ package ch.qos.logback.core.joran.event.stax;
/*    */ 
/*    */ import javax.xml.stream.Location;
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
/*    */ public class EndEvent
/*    */   extends StaxEvent
/*    */ {
/*    */   public EndEvent(String paramString, Location paramLocation) {
/* 28 */     super(paramString, paramLocation);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 33 */     return "EndEvent(" + getName() + ")  [" + this.location.getLineNumber() + "," + this.location.getColumnNumber() + "]";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\event\stax\EndEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */