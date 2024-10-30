/*    */ package ch.qos.logback.core.joran.event;
/*    */ 
/*    */ import ch.qos.logback.core.joran.spi.ElementPath;
/*    */ import org.xml.sax.Attributes;
/*    */ import org.xml.sax.Locator;
/*    */ import org.xml.sax.helpers.AttributesImpl;
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
/*    */   extends SaxEvent
/*    */ {
/*    */   public final Attributes attributes;
/*    */   public final ElementPath elementPath;
/*    */   
/*    */   StartEvent(ElementPath paramElementPath, String paramString1, String paramString2, String paramString3, Attributes paramAttributes, Locator paramLocator) {
/* 27 */     super(paramString1, paramString2, paramString3, paramLocator);
/*    */     
/* 29 */     this.attributes = new AttributesImpl(paramAttributes);
/* 30 */     this.elementPath = paramElementPath;
/*    */   }
/*    */   
/*    */   public Attributes getAttributes() {
/* 34 */     return this.attributes;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 39 */     StringBuilder stringBuilder = new StringBuilder("StartEvent(");
/* 40 */     stringBuilder.append(getQName());
/* 41 */     if (this.attributes != null) {
/* 42 */       for (byte b = 0; b < this.attributes.getLength(); b++) {
/* 43 */         if (b > 0)
/* 44 */           stringBuilder.append(' '); 
/* 45 */         stringBuilder.append(this.attributes.getLocalName(b)).append("=\"").append(this.attributes.getValue(b)).append("\"");
/*    */       } 
/*    */     }
/* 48 */     stringBuilder.append(")  [");
/* 49 */     stringBuilder.append(this.locator.getLineNumber());
/* 50 */     stringBuilder.append(",");
/* 51 */     stringBuilder.append(this.locator.getColumnNumber());
/* 52 */     stringBuilder.append("]");
/* 53 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\event\StartEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */