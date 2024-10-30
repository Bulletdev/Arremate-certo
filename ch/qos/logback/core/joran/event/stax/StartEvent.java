/*    */ package ch.qos.logback.core.joran.event.stax;
/*    */ 
/*    */ import ch.qos.logback.core.joran.spi.ElementPath;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import javax.xml.stream.Location;
/*    */ import javax.xml.stream.events.Attribute;
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
/*    */ public class StartEvent
/*    */   extends StaxEvent
/*    */ {
/*    */   List<Attribute> attributes;
/*    */   public ElementPath elementPath;
/*    */   
/*    */   StartEvent(ElementPath paramElementPath, String paramString, Iterator<Attribute> paramIterator, Location paramLocation) {
/* 30 */     super(paramString, paramLocation);
/* 31 */     populateAttributes(paramIterator);
/* 32 */     this.elementPath = paramElementPath;
/*    */   }
/*    */   
/*    */   private void populateAttributes(Iterator<Attribute> paramIterator) {
/* 36 */     while (paramIterator.hasNext()) {
/* 37 */       if (this.attributes == null) {
/* 38 */         this.attributes = new ArrayList<Attribute>(2);
/*    */       }
/* 40 */       this.attributes.add(paramIterator.next());
/*    */     } 
/*    */   }
/*    */   
/*    */   public ElementPath getElementPath() {
/* 45 */     return this.elementPath;
/*    */   }
/*    */   
/*    */   public List<Attribute> getAttributeList() {
/* 49 */     return this.attributes;
/*    */   }
/*    */   
/*    */   Attribute getAttributeByName(String paramString) {
/* 53 */     if (this.attributes == null) {
/* 54 */       return null;
/*    */     }
/* 56 */     for (Attribute attribute : this.attributes) {
/* 57 */       if (paramString.equals(attribute.getName().dT()))
/* 58 */         return attribute; 
/*    */     } 
/* 60 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 65 */     return "StartEvent(" + getName() + ")  [" + this.location.getLineNumber() + "," + this.location.getColumnNumber() + "]";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\event\stax\StartEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */