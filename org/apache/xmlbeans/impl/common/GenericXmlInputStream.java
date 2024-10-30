/*     */ package org.apache.xmlbeans.impl.common;
/*     */ 
/*     */ import org.apache.xmlbeans.xml.stream.ReferenceResolver;
/*     */ import org.apache.xmlbeans.xml.stream.XMLEvent;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLName;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
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
/*     */ public class GenericXmlInputStream
/*     */   implements XMLInputStream
/*     */ {
/*     */   private boolean _initialized;
/*     */   private EventItem _nextEvent;
/*     */   private int _elementCount;
/*     */   private GenericXmlInputStream _master;
/*     */   
/*     */   public GenericXmlInputStream() {
/*  31 */     this._master = this;
/*  32 */     this._elementCount = 1;
/*     */   }
/*     */ 
/*     */   
/*     */   private GenericXmlInputStream(GenericXmlInputStream paramGenericXmlInputStream) {
/*  37 */     (this._master = paramGenericXmlInputStream).ensureInit();
/*  38 */     this._nextEvent = paramGenericXmlInputStream._nextEvent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected XMLEvent nextEvent() throws XMLStreamException {
/*  47 */     throw new RuntimeException("nextEvent not overridden");
/*     */   }
/*     */ 
/*     */   
/*     */   private class EventItem
/*     */   {
/*     */     final XMLEvent _event;
/*     */     EventItem _next;
/*     */     private final GenericXmlInputStream this$0;
/*     */     
/*     */     EventItem(XMLEvent param1XMLEvent) {
/*  58 */       this._event = param1XMLEvent;
/*     */     }
/*     */     
/*  61 */     int getType() { return this._event.getType(); }
/*  62 */     boolean hasName() { return this._event.hasName(); } XMLName getName() {
/*  63 */       return this._event.getName();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void ensureInit() {
/*  72 */     if (!this._master._initialized) {
/*     */ 
/*     */       
/*     */       try {
/*  76 */         this._master._nextEvent = getNextEvent();
/*     */       }
/*  78 */       catch (XMLStreamException xMLStreamException) {
/*     */         
/*  80 */         throw new RuntimeException(xMLStreamException);
/*     */       } 
/*     */       
/*  83 */       this._master._initialized = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private EventItem getNextEvent() throws XMLStreamException {
/*  89 */     XMLEvent xMLEvent = nextEvent();
/*     */     
/*  91 */     return (xMLEvent == null) ? null : new EventItem(xMLEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   public XMLEvent next() throws XMLStreamException {
/*  96 */     ensureInit();
/*     */     
/*  98 */     EventItem eventItem = this._nextEvent;
/*     */     
/* 100 */     if (this._nextEvent != null) {
/*     */       
/* 102 */       if (this._nextEvent._next == null) {
/* 103 */         this._nextEvent._next = this._master.getNextEvent();
/*     */       }
/* 105 */       this._nextEvent = this._nextEvent._next;
/*     */     } 
/*     */     
/* 108 */     if (eventItem == null) {
/* 109 */       return null;
/*     */     }
/* 111 */     if (eventItem.getType() == 4) {
/*     */       
/* 113 */       if (--this._elementCount <= 0) {
/* 114 */         this._nextEvent = null;
/*     */       }
/* 116 */     } else if (eventItem.getType() == 2) {
/* 117 */       this._elementCount++;
/*     */     } 
/* 119 */     return eventItem._event;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasNext() throws XMLStreamException {
/* 124 */     ensureInit();
/*     */     
/* 126 */     return (this._nextEvent != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void skip() throws XMLStreamException {
/* 131 */     next();
/*     */   }
/*     */ 
/*     */   
/*     */   public void skipElement() throws XMLStreamException {
/* 136 */     ensureInit();
/*     */     
/* 138 */     for (; this._nextEvent != null; next()) {
/*     */       
/* 140 */       if (this._nextEvent.getType() == 2) {
/*     */         break;
/*     */       }
/*     */     } 
/* 144 */     byte b = 0;
/*     */     
/* 146 */     for (; this._nextEvent != null; next()) {
/*     */       
/* 148 */       int i = next().getType();
/*     */       
/* 150 */       if (i == 2) {
/* 151 */         b++;
/* 152 */       } else if (i == 4 && --b == 0) {
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public XMLEvent peek() throws XMLStreamException {
/* 159 */     ensureInit();
/*     */     
/* 161 */     return this._nextEvent._event;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean skip(int paramInt) throws XMLStreamException {
/* 166 */     ensureInit();
/*     */     
/* 168 */     for (; this._nextEvent != null; next()) {
/*     */       
/* 170 */       if (this._nextEvent.getType() == paramInt) {
/* 171 */         return true;
/*     */       }
/*     */     } 
/* 174 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean skip(XMLName paramXMLName) throws XMLStreamException {
/* 179 */     ensureInit();
/*     */     
/* 181 */     for (; this._nextEvent != null; next()) {
/*     */       
/* 183 */       if (this._nextEvent.hasName() && this._nextEvent.getName().equals(paramXMLName)) {
/* 184 */         return true;
/*     */       }
/*     */     } 
/* 187 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean skip(XMLName paramXMLName, int paramInt) throws XMLStreamException {
/* 192 */     ensureInit();
/*     */     
/* 194 */     for (; this._nextEvent != null; next()) {
/*     */       
/* 196 */       if (this._nextEvent.getType() == paramInt && this._nextEvent.hasName() && this._nextEvent.getName().equals(paramXMLName))
/*     */       {
/*     */ 
/*     */         
/* 200 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 204 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public XMLInputStream getSubStream() throws XMLStreamException {
/* 209 */     ensureInit();
/*     */     
/* 211 */     GenericXmlInputStream genericXmlInputStream = new GenericXmlInputStream(this);
/*     */     
/* 213 */     genericXmlInputStream.skip(2);
/*     */     
/* 215 */     return genericXmlInputStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws XMLStreamException {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReferenceResolver getReferenceResolver() {
/* 227 */     ensureInit();
/*     */     
/* 229 */     throw new RuntimeException("Not impl");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setReferenceResolver(ReferenceResolver paramReferenceResolver) {
/* 234 */     ensureInit();
/*     */     
/* 236 */     throw new RuntimeException("Not impl");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\GenericXmlInputStream.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */