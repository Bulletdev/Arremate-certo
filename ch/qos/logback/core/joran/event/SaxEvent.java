/*    */ package ch.qos.logback.core.joran.event;
/*    */ 
/*    */ import org.xml.sax.Locator;
/*    */ import org.xml.sax.helpers.LocatorImpl;
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
/*    */ public class SaxEvent
/*    */ {
/*    */   public final String namespaceURI;
/*    */   public final String localName;
/*    */   public final String qName;
/*    */   public final Locator locator;
/*    */   
/*    */   SaxEvent(String paramString1, String paramString2, String paramString3, Locator paramLocator) {
/* 27 */     this.namespaceURI = paramString1;
/* 28 */     this.localName = paramString2;
/* 29 */     this.qName = paramString3;
/*    */     
/* 31 */     this.locator = new LocatorImpl(paramLocator);
/*    */   }
/*    */   
/*    */   public String getLocalName() {
/* 35 */     return this.localName;
/*    */   }
/*    */   
/*    */   public Locator getLocator() {
/* 39 */     return this.locator;
/*    */   }
/*    */   
/*    */   public String getNamespaceURI() {
/* 43 */     return this.namespaceURI;
/*    */   }
/*    */   
/*    */   public String getQName() {
/* 47 */     return this.qName;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\event\SaxEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */