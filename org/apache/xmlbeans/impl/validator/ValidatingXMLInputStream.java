/*     */ package org.apache.xmlbeans.impl.validator;
/*     */ 
/*     */ import java.util.AbstractCollection;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import javax.xml.namespace.b;
/*     */ import javax.xml.stream.Location;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SchemaTypeLoader;
/*     */ import org.apache.xmlbeans.XMLStreamValidationException;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlError;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.impl.common.GenericXmlInputStream;
/*     */ import org.apache.xmlbeans.impl.common.ValidatorListener;
/*     */ import org.apache.xmlbeans.impl.common.XMLNameHelper;
/*     */ import org.apache.xmlbeans.impl.common.XmlWhitespace;
/*     */ import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
/*     */ import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;
/*     */ import org.apache.xmlbeans.xml.stream.Attribute;
/*     */ import org.apache.xmlbeans.xml.stream.AttributeIterator;
/*     */ import org.apache.xmlbeans.xml.stream.CharacterData;
/*     */ import org.apache.xmlbeans.xml.stream.Location;
/*     */ import org.apache.xmlbeans.xml.stream.StartElement;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ValidatingXMLInputStream
/*     */   extends GenericXmlInputStream
/*     */   implements ValidatorListener.Event
/*     */ {
/*     */   private XMLStreamValidationException _exception;
/*     */   private XMLInputStream _source;
/*     */   private Validator _validator;
/*     */   private StringBuffer _text;
/*     */   private boolean _finished;
/*     */   private String _xsiType;
/*     */   private String _xsiNil;
/*     */   private String _xsiLoc;
/*     */   private String _xsiNoLoc;
/*     */   private XMLName _name;
/*     */   private StartElement _startElement;
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   public ValidatingXMLInputStream(XMLInputStream paramXMLInputStream, SchemaTypeLoader paramSchemaTypeLoader, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XMLStreamException {
/* 381 */     this._text = new StringBuffer();
/*     */     this._source = paramXMLInputStream;
/*     */     paramXmlOptions = XmlOptions.maskNull(paramXmlOptions);
/*     */     SchemaType schemaType = (SchemaType)paramXmlOptions.get("DOCUMENT_TYPE");
/*     */     if (schemaType == null)
/*     */       schemaType = paramSchemaType; 
/*     */     if (schemaType == null) {
/*     */       SchemaTypeImpl schemaTypeImpl = BuiltinSchemaTypeSystem.ST_ANY_TYPE;
/*     */       paramXMLInputStream = paramXMLInputStream.getSubStream();
/*     */       if (paramXMLInputStream.skip(2)) {
/*     */         SchemaType schemaType1 = paramSchemaTypeLoader.findDocumentType(XMLNameHelper.getQName(paramXMLInputStream.next().getName()));
/*     */         if (schemaType1 != null)
/*     */           schemaType = schemaType1; 
/*     */       } 
/*     */       paramXMLInputStream.close();
/*     */     } 
/*     */     this._validator = new Validator(schemaType, null, paramSchemaTypeLoader, paramXmlOptions, new ExceptionXmlErrorListener());
/*     */     nextEvent(1);
/*     */   }
/*     */   
/*     */   protected XMLEvent nextEvent() throws XMLStreamException {
/*     */     XMLEvent xMLEvent = this._source.next();
/*     */     if (xMLEvent == null) {
/*     */       if (!this._finished) {
/*     */         flushText();
/*     */         nextEvent(2);
/*     */         this._finished = true;
/*     */       } 
/*     */     } else {
/*     */       CharacterData characterData;
/*     */       StartElement startElement;
/*     */       AttributeIterator attributeIterator;
/*     */       switch (xMLEvent.getType()) {
/*     */         case 16:
/*     */         case 64:
/*     */           characterData = (CharacterData)xMLEvent;
/*     */           if (characterData.hasContent())
/*     */             this._text.append(characterData.getContent()); 
/*     */           break;
/*     */         case 2:
/*     */           startElement = (StartElement)xMLEvent;
/*     */           flushText();
/*     */           this._startElement = startElement;
/*     */           attributeIterator = startElement.getAttributes();
/*     */           while (attributeIterator.hasNext()) {
/*     */             Attribute attribute = attributeIterator.next();
/*     */             XMLName xMLName = attribute.getName();
/*     */             if ("http://www.w3.org/2001/XMLSchema-instance".equals(xMLName.getNamespaceUri())) {
/*     */               String str = xMLName.getLocalName();
/*     */               if (str.equals("type")) {
/*     */                 this._xsiType = attribute.getValue();
/*     */                 continue;
/*     */               } 
/*     */               if (str.equals("nil")) {
/*     */                 this._xsiNil = attribute.getValue();
/*     */                 continue;
/*     */               } 
/*     */               if (str.equals("schemaLocation")) {
/*     */                 this._xsiLoc = attribute.getValue();
/*     */                 continue;
/*     */               } 
/*     */               if (str.equals("noNamespaceSchemaLocation"))
/*     */                 this._xsiNoLoc = attribute.getValue(); 
/*     */             } 
/*     */           } 
/*     */           this._name = xMLEvent.getName();
/*     */           nextEvent(1);
/*     */           attributeIterator = startElement.getAttributes();
/*     */           while (attributeIterator.hasNext()) {
/*     */             Attribute attribute = attributeIterator.next();
/*     */             XMLName xMLName = attribute.getName();
/*     */             if ("http://www.w3.org/2001/XMLSchema-instance".equals(xMLName.getNamespaceUri())) {
/*     */               String str = xMLName.getLocalName();
/*     */               if (str.equals("type"))
/*     */                 continue; 
/*     */               if (str.equals("nil"))
/*     */                 continue; 
/*     */               if (str.equals("schemaLocation"))
/*     */                 continue; 
/*     */               if (str.equals("noNamespaceSchemaLocation"))
/*     */                 continue; 
/*     */             } 
/*     */             this._text.append(attribute.getValue());
/*     */             this._name = attribute.getName();
/*     */             nextEvent(4);
/*     */           } 
/*     */           clearText();
/*     */           this._startElement = null;
/*     */           break;
/*     */         case 4:
/*     */           flushText();
/*     */           nextEvent(2);
/*     */           break;
/*     */       } 
/*     */     } 
/*     */     return xMLEvent;
/*     */   }
/*     */   
/*     */   private void clearText() {
/*     */     this._text.delete(0, this._text.length());
/*     */   }
/*     */   
/*     */   private void flushText() throws XMLStreamException {
/*     */     if (this._text.length() > 0) {
/*     */       nextEvent(3);
/*     */       clearText();
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getNamespaceForPrefix(String paramString) {
/*     */     if (this._startElement == null)
/*     */       return null; 
/*     */     Map map = this._startElement.getNamespaceMap();
/*     */     if (map == null)
/*     */       return null; 
/*     */     return (String)map.get(paramString);
/*     */   }
/*     */   
/*     */   public XmlCursor getLocationAsCursor() {
/*     */     return null;
/*     */   }
/*     */   
/*     */   public Location getLocation() {
/*     */     try {
/*     */       final Location xeLoc = this._source.peek().getLocation();
/*     */       if (location == null)
/*     */         return null; 
/*     */       return new Location() {
/*     */           private final Location val$xeLoc;
/*     */           private final ValidatingXMLInputStream this$0;
/*     */           
/*     */           public int getLineNumber() {
/*     */             return xeLoc.getLineNumber();
/*     */           }
/*     */           
/*     */           public int getColumnNumber() {
/*     */             return xeLoc.getColumnNumber();
/*     */           }
/*     */           
/*     */           public int getCharacterOffset() {
/*     */             return -1;
/*     */           }
/*     */           
/*     */           public String getPublicId() {
/*     */             return xeLoc.getPublicId();
/*     */           }
/*     */           
/*     */           public String getSystemId() {
/*     */             return xeLoc.getSystemId();
/*     */           }
/*     */         };
/*     */     } catch (XMLStreamException xMLStreamException) {
/*     */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getXsiType() {
/*     */     return this._xsiType;
/*     */   }
/*     */   
/*     */   public String getXsiNil() {
/*     */     return this._xsiNil;
/*     */   }
/*     */   
/*     */   public String getXsiLoc() {
/*     */     return this._xsiLoc;
/*     */   }
/*     */   
/*     */   public String getXsiNoLoc() {
/*     */     return this._xsiNoLoc;
/*     */   }
/*     */   
/*     */   public b getName() {
/*     */     return XMLNameHelper.getQName(this._name);
/*     */   }
/*     */   
/*     */   public String getText() {
/*     */     return this._text.toString();
/*     */   }
/*     */   
/*     */   public String getText(int paramInt) {
/*     */     return XmlWhitespace.collapse(this._text.toString(), paramInt);
/*     */   }
/*     */   
/*     */   public boolean textIsWhitespace() {
/*     */     for (byte b = 0; b < this._text.length(); b++) {
/*     */       switch (this._text.charAt(b)) {
/*     */         case '\t':
/*     */         case '\n':
/*     */         case '\r':
/*     */         case ' ':
/*     */           break;
/*     */         default:
/*     */           return false;
/*     */       } 
/*     */     } 
/*     */     return true;
/*     */   }
/*     */   
/*     */   private final class ExceptionXmlErrorListener extends AbstractCollection {
/*     */     static final boolean $assertionsDisabled;
/*     */     private final ValidatingXMLInputStream this$0;
/*     */     
/*     */     private ExceptionXmlErrorListener() {}
/*     */     
/*     */     public boolean add(Object param1Object) {
/*     */       assert ValidatingXMLInputStream.this._exception == null;
/*     */       ValidatingXMLInputStream.this._exception = new XMLStreamValidationException((XmlError)param1Object);
/*     */       return false;
/*     */     }
/*     */     
/*     */     public Iterator iterator() {
/*     */       return Collections.EMPTY_LIST.iterator();
/*     */     }
/*     */     
/*     */     public int size() {
/*     */       return 0;
/*     */     }
/*     */   }
/*     */   
/*     */   private void nextEvent(int paramInt) throws XMLStreamException {
/*     */     assert this._exception == null;
/*     */     this._validator.nextEvent(paramInt, this);
/*     */     if (this._exception != null)
/*     */       throw this._exception; 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\validator\ValidatingXMLInputStream.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */