/*     */ package javax.xml.stream.util;
/*     */ 
/*     */ import javax.xml.stream.XMLEventReader;
/*     */ import javax.xml.stream.XMLStreamException;
/*     */ import javax.xml.stream.events.XMLEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EventReaderDelegate
/*     */   implements XMLEventReader
/*     */ {
/*     */   private XMLEventReader reader;
/*     */   
/*     */   public EventReaderDelegate() {}
/*     */   
/*     */   public EventReaderDelegate(XMLEventReader paramXMLEventReader) {
/*  38 */     this.reader = paramXMLEventReader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParent(XMLEventReader paramXMLEventReader) {
/*  46 */     this.reader = paramXMLEventReader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMLEventReader getParent() {
/*  54 */     return this.reader;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public XMLEvent nextEvent() throws XMLStreamException {
/*  60 */     return this.reader.nextEvent();
/*     */   }
/*     */   
/*     */   public Object next() {
/*  64 */     return this.reader.next();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/*  69 */     return this.reader.hasNext();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public XMLEvent peek() throws XMLStreamException {
/*  75 */     return this.reader.peek();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws XMLStreamException {
/*  81 */     this.reader.close();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getElementText() throws XMLStreamException {
/*  87 */     return this.reader.getElementText();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public XMLEvent nextTag() throws XMLStreamException {
/*  93 */     return this.reader.nextTag();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getProperty(String paramString) throws IllegalArgumentException {
/*  99 */     return this.reader.getProperty(paramString);
/*     */   }
/*     */   
/*     */   public void remove() {
/* 103 */     this.reader.remove();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\javax\xml\strea\\util\EventReaderDelegate.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */