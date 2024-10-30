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
/*    */ public class BodyEvent
/*    */   extends StaxEvent
/*    */ {
/*    */   private String text;
/*    */   
/*    */   BodyEvent(String paramString, Location paramLocation) {
/* 23 */     super(null, paramLocation);
/* 24 */     this.text = paramString;
/*    */   }
/*    */   
/*    */   public String getText() {
/* 28 */     return this.text;
/*    */   }
/*    */   
/*    */   void append(String paramString) {
/* 32 */     this.text += paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 37 */     return "BodyEvent(" + getText() + ")" + this.location.getLineNumber() + "," + this.location.getColumnNumber();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\event\stax\BodyEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */