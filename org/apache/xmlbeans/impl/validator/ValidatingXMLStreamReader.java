/*     */ package org.apache.xmlbeans.impl.validator;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import javax.xml.namespace.b;
/*     */ import javax.xml.stream.Location;
/*     */ import javax.xml.stream.XMLStreamException;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import javax.xml.stream.util.StreamReaderDelegate;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SchemaTypeLoader;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlError;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*     */ import org.apache.xmlbeans.impl.common.ValidatorListener;
/*     */ import org.apache.xmlbeans.impl.common.XmlWhitespace;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ValidatingXMLStreamReader
/*     */   extends StreamReaderDelegate
/*     */   implements XMLStreamReader
/*     */ {
/*     */   public static final String OPTION_ATTTRIBUTE_VALIDATION_COMPAT_MODE = "OPTION_ATTTRIBUTE_VALIDATION_COMPAT_MODE";
/*     */   private static final String URI_XSI = "http://www.w3.org/2001/XMLSchema-instance";
/*  58 */   private static final b XSI_TYPE = new b("http://www.w3.org/2001/XMLSchema-instance", "type");
/*  59 */   private static final b XSI_NIL = new b("http://www.w3.org/2001/XMLSchema-instance", "nil");
/*  60 */   private static final b XSI_SL = new b("http://www.w3.org/2001/XMLSchema-instance", "schemaLocation");
/*  61 */   private static final b XSI_NSL = new b("http://www.w3.org/2001/XMLSchema-instance", "noNamespaceSchemaLocation");
/*     */   
/*     */   private SchemaType _contentType;
/*     */   
/*     */   private SchemaTypeLoader _stl;
/*     */   private XmlOptions _options;
/*     */   private Collection _errorListener;
/*     */   protected Validator _validator;
/*     */   private final ElementEventImpl _elemEvent;
/*     */   private final AttributeEventImpl _attEvent;
/*     */   private final SimpleEventImpl _simpleEvent;
/*     */   private PackTextXmlStreamReader _packTextXmlStreamReader;
/*     */   private int _state;
/*  74 */   private final int STATE_FIRSTEVENT = 0;
/*  75 */   private final int STATE_VALIDATING = 1;
/*  76 */   private final int STATE_ATTBUFFERING = 2;
/*  77 */   private final int STATE_ERROR = 3;
/*     */ 
/*     */   
/*     */   private List _attNamesList;
/*     */   
/*     */   private List _attValuesList;
/*     */   
/*     */   private SchemaType _xsiType;
/*     */   
/*     */   private int _depth;
/*     */   
/*     */   static final boolean $assertionsDisabled;
/*     */ 
/*     */   
/*     */   public ValidatingXMLStreamReader() {
/*  92 */     this._elemEvent = new ElementEventImpl();
/*  93 */     this._attEvent = new AttributeEventImpl();
/*  94 */     this._simpleEvent = new SimpleEventImpl();
/*  95 */     this._packTextXmlStreamReader = new PackTextXmlStreamReader();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(XMLStreamReader paramXMLStreamReader, boolean paramBoolean, SchemaType paramSchemaType, SchemaTypeLoader paramSchemaTypeLoader, XmlOptions paramXmlOptions, Collection paramCollection) {
/* 110 */     this._packTextXmlStreamReader.init(paramXMLStreamReader);
/*     */ 
/*     */     
/* 113 */     setParent(this._packTextXmlStreamReader);
/* 114 */     this._contentType = paramSchemaType;
/* 115 */     this._stl = paramSchemaTypeLoader;
/* 116 */     this._options = paramXmlOptions;
/* 117 */     this._errorListener = paramCollection;
/*     */ 
/*     */ 
/*     */     
/* 121 */     this._elemEvent.setXMLStreamReader(this._packTextXmlStreamReader);
/* 122 */     this._attEvent.setXMLStreamReader(this._packTextXmlStreamReader);
/* 123 */     this._simpleEvent.setXMLStreamReader(this._packTextXmlStreamReader);
/* 124 */     this._validator = null;
/* 125 */     this._state = 0;
/* 126 */     if (this._attNamesList != null) {
/*     */       
/* 128 */       this._attNamesList.clear();
/* 129 */       this._attValuesList.clear();
/*     */     } 
/* 131 */     this._xsiType = null;
/* 132 */     this._depth = 0;
/*     */     
/* 134 */     if (paramBoolean) {
/*     */       
/* 136 */       int i = getEventType();
/* 137 */       validate_event(i);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static class PackTextXmlStreamReader
/*     */     extends StreamReaderDelegate
/*     */     implements XMLStreamReader
/*     */   {
/*     */     private boolean _hasBufferedText;
/* 146 */     private StringBuffer _buffer = new StringBuffer();
/*     */     private int _textEventType;
/*     */     static final boolean $assertionsDisabled;
/*     */     
/*     */     void init(XMLStreamReader param1XMLStreamReader) {
/* 151 */       setParent(param1XMLStreamReader);
/* 152 */       this._hasBufferedText = false;
/* 153 */       this._buffer.delete(0, this._buffer.length());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int next() throws XMLStreamException {
/* 159 */       if (this._hasBufferedText) {
/*     */         
/* 161 */         clearBuffer();
/* 162 */         return super.getEventType();
/*     */       } 
/*     */       
/* 165 */       int i = super.next();
/*     */       
/* 167 */       if (i == 4 || i == 12 || i == 6) {
/*     */         
/* 169 */         this._textEventType = i;
/* 170 */         bufferText();
/*     */       } 
/*     */       
/* 173 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     private void clearBuffer() {
/* 178 */       this._buffer.delete(0, this._buffer.length());
/* 179 */       this._hasBufferedText = false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void bufferText() throws XMLStreamException {
/* 185 */       if (super.hasText()) {
/* 186 */         this._buffer.append(super.getText());
/*     */       }
/* 188 */       this._hasBufferedText = true;
/*     */       
/* 190 */       while (hasNext()) {
/*     */         
/* 192 */         int i = super.next();
/*     */         
/* 194 */         switch (i) {
/*     */           
/*     */           case 4:
/*     */           case 6:
/*     */           case 12:
/* 199 */             if (super.hasText()) {
/* 200 */               this._buffer.append(super.getText());
/*     */             }
/*     */             continue;
/*     */           case 5:
/*     */             continue;
/*     */         } 
/*     */         return;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getText() {
/* 213 */       assert this._hasBufferedText;
/* 214 */       return this._buffer.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public int getTextLength() {
/* 219 */       assert this._hasBufferedText;
/* 220 */       return this._buffer.length();
/*     */     }
/*     */ 
/*     */     
/*     */     public int getTextStart() {
/* 225 */       assert this._hasBufferedText;
/* 226 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public char[] getTextCharacters() {
/* 231 */       assert this._hasBufferedText;
/* 232 */       return this._buffer.toString().toCharArray();
/*     */     }
/*     */ 
/*     */     
/*     */     public int getTextCharacters(int param1Int1, char[] param1ArrayOfchar, int param1Int2, int param1Int3) {
/* 237 */       assert this._hasBufferedText;
/* 238 */       this._buffer.getChars(param1Int1, param1Int1 + param1Int3, param1ArrayOfchar, param1Int2);
/* 239 */       return param1Int3;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isWhiteSpace() {
/* 244 */       assert this._hasBufferedText;
/* 245 */       return XmlWhitespace.isAllSpace(this._buffer);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasText() {
/* 250 */       if (this._hasBufferedText) {
/* 251 */         return true;
/*     */       }
/* 253 */       return super.hasText();
/*     */     }
/*     */ 
/*     */     
/*     */     public int getEventType() {
/* 258 */       if (this._hasBufferedText) {
/* 259 */         return this._textEventType;
/*     */       }
/* 261 */       return super.getEventType();
/*     */     }
/*     */     
/*     */     private PackTextXmlStreamReader() {}
/*     */   }
/*     */   
/*     */   private static class ElementEventImpl implements ValidatorListener.Event {
/*     */     private static final int BUF_LENGTH = 1024;
/* 269 */     private char[] _buf = new char[1024];
/*     */     
/*     */     private int _length;
/*     */     
/*     */     private boolean _supportForGetTextCharacters = true;
/*     */     private XMLStreamReader _xmlStream;
/*     */     
/*     */     private void setXMLStreamReader(XMLStreamReader param1XMLStreamReader) {
/* 277 */       this._xmlStream = param1XMLStreamReader;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlCursor getLocationAsCursor() {
/* 283 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public Location getLocation() {
/* 288 */       return this._xmlStream.getLocation();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getXsiType() {
/* 294 */       return this._xmlStream.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getXsiNil() {
/* 300 */       return this._xmlStream.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getXsiLoc() {
/* 306 */       return this._xmlStream.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "schemaLocation");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getXsiNoLoc() {
/* 312 */       return this._xmlStream.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "noNamespaceSchemaLocation");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b getName() {
/* 319 */       if (this._xmlStream.hasName()) {
/* 320 */         return new b(this._xmlStream.getNamespaceURI(), this._xmlStream.getLocalName());
/*     */       }
/* 322 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getText() {
/* 328 */       this._length = 0;
/* 329 */       addTextToBuffer();
/* 330 */       return new String(this._buf, 0, this._length);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getText(int param1Int) {
/* 336 */       return XmlWhitespace.collapse(this._xmlStream.getText(), param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean textIsWhitespace() {
/* 341 */       return this._xmlStream.isWhiteSpace();
/*     */     }
/*     */ 
/*     */     
/*     */     public String getNamespaceForPrefix(String param1String) {
/* 346 */       return this._xmlStream.getNamespaceURI(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     private void addTextToBuffer() {
/* 351 */       int i = this._xmlStream.getTextLength();
/* 352 */       ensureBufferLength(i);
/*     */       
/* 354 */       if (this._supportForGetTextCharacters) {
/*     */         
/*     */         try {
/* 357 */           this._length = this._xmlStream.getTextCharacters(0, this._buf, this._length, i);
/*     */         }
/* 359 */         catch (Exception exception) {
/*     */           
/* 361 */           this._supportForGetTextCharacters = false;
/*     */         } 
/*     */       }
/* 364 */       if (!this._supportForGetTextCharacters) {
/*     */         
/* 366 */         System.arraycopy(this._xmlStream.getTextCharacters(), this._xmlStream.getTextStart(), this._buf, this._length, i);
/* 367 */         this._length += i;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private void ensureBufferLength(int param1Int) {
/* 373 */       if (this._length + param1Int > this._buf.length) {
/*     */         
/* 375 */         char[] arrayOfChar = new char[this._length + param1Int];
/* 376 */         if (this._length > 0)
/* 377 */           System.arraycopy(this._buf, 0, arrayOfChar, 0, this._length); 
/* 378 */         this._buf = arrayOfChar;
/*     */       } 
/*     */     }
/*     */     
/*     */     private ElementEventImpl() {}
/*     */   }
/*     */   
/*     */   private static final class AttributeEventImpl
/*     */     implements ValidatorListener.Event {
/*     */     private int _attIndex;
/*     */     private XMLStreamReader _xmlStream;
/*     */     
/*     */     private void setXMLStreamReader(XMLStreamReader param1XMLStreamReader) {
/* 391 */       this._xmlStream = param1XMLStreamReader;
/*     */     }
/*     */     static final boolean $assertionsDisabled;
/*     */     private AttributeEventImpl() {}
/*     */     
/*     */     public XmlCursor getLocationAsCursor() {
/* 397 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public Location getLocation() {
/* 402 */       return this._xmlStream.getLocation();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getXsiType() {
/* 408 */       throw new IllegalStateException();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getXsiNil() {
/* 414 */       throw new IllegalStateException();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getXsiLoc() {
/* 420 */       throw new IllegalStateException();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getXsiNoLoc() {
/* 426 */       throw new IllegalStateException();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public b getName() {
/* 432 */       assert this._xmlStream.isStartElement() : "Not on Start Element.";
/* 433 */       String str = this._xmlStream.getAttributeNamespace(this._attIndex);
/* 434 */       return new b((str == null) ? "" : str, this._xmlStream.getAttributeLocalName(this._attIndex));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getText() {
/* 442 */       assert this._xmlStream.isStartElement() : "Not on Start Element.";
/* 443 */       return this._xmlStream.getAttributeValue(this._attIndex);
/*     */     }
/*     */ 
/*     */     
/*     */     public String getText(int param1Int) {
/* 448 */       assert this._xmlStream.isStartElement() : "Not on Start Element.";
/* 449 */       return XmlWhitespace.collapse(this._xmlStream.getAttributeValue(this._attIndex), param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean textIsWhitespace() {
/* 454 */       throw new IllegalStateException();
/*     */     }
/*     */ 
/*     */     
/*     */     public String getNamespaceForPrefix(String param1String) {
/* 459 */       assert this._xmlStream.isStartElement() : "Not on Start Element.";
/* 460 */       return this._xmlStream.getNamespaceURI(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     private void setAttributeIndex(int param1Int) {
/* 465 */       this._attIndex = param1Int;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class SimpleEventImpl
/*     */     implements ValidatorListener.Event
/*     */   {
/*     */     private String _text;
/*     */     
/*     */     private b _qname;
/*     */     
/*     */     private XMLStreamReader _xmlStream;
/*     */     
/*     */     private SimpleEventImpl() {}
/*     */     
/*     */     private void setXMLStreamReader(XMLStreamReader param1XMLStreamReader) {
/* 482 */       this._xmlStream = param1XMLStreamReader;
/*     */     }
/*     */ 
/*     */     
/*     */     public XmlCursor getLocationAsCursor() {
/* 487 */       return null;
/*     */     }
/*     */     
/*     */     public Location getLocation() {
/* 491 */       return this._xmlStream.getLocation();
/*     */     }
/*     */ 
/*     */     
/*     */     public String getXsiType() {
/* 496 */       return null;
/*     */     }
/*     */     
/*     */     public String getXsiNil() {
/* 500 */       return null;
/*     */     }
/*     */     
/*     */     public String getXsiLoc() {
/* 504 */       return null;
/*     */     }
/*     */     
/*     */     public String getXsiNoLoc() {
/* 508 */       return null;
/*     */     }
/*     */     
/*     */     public b getName() {
/* 512 */       return this._qname;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getText() {
/* 517 */       return this._text;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getText(int param1Int) {
/* 522 */       return XmlWhitespace.collapse(this._text, param1Int);
/*     */     }
/*     */     
/*     */     public boolean textIsWhitespace() {
/* 526 */       return false;
/*     */     }
/*     */     
/*     */     public String getNamespaceForPrefix(String param1String) {
/* 530 */       return this._xmlStream.getNamespaceURI(param1String);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getProperty(String paramString) throws IllegalArgumentException {
/* 538 */     return super.getProperty(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public int next() throws XMLStreamException {
/* 543 */     int i = super.next();
/*     */ 
/*     */     
/* 546 */     validate_event(i);
/*     */     
/* 548 */     return i;
/*     */   }
/*     */   
/*     */   private void validate_event(int paramInt) {
/*     */     int i;
/* 553 */     if (this._state == 3) {
/*     */       return;
/*     */     }
/* 556 */     if (this._depth < 0) {
/* 557 */       throw new IllegalArgumentException("ValidatingXMLStreamReader cannot go further than the subtree is was initialized on.");
/*     */     }
/* 559 */     switch (paramInt) {
/*     */       
/*     */       case 1:
/* 562 */         this._depth++;
/* 563 */         if (this._state == 2) {
/* 564 */           pushBufferedAttributes();
/*     */         }
/* 566 */         if (this._validator == null) {
/*     */ 
/*     */           
/* 569 */           b b1 = new b(getNamespaceURI(), getLocalName());
/*     */           
/* 571 */           if (this._contentType == null) {
/* 572 */             this._contentType = typeForGlobalElement(b1);
/*     */           }
/* 574 */           if (this._state == 3) {
/*     */             return;
/*     */           }
/* 577 */           initValidator(this._contentType);
/* 578 */           this._validator.nextEvent(1, this._elemEvent);
/*     */         } 
/*     */         
/* 581 */         this._validator.nextEvent(1, this._elemEvent);
/*     */         
/* 583 */         i = getAttributeCount();
/* 584 */         validate_attributes(i);
/*     */ 
/*     */ 
/*     */       
/*     */       case 10:
/* 589 */         if (getAttributeCount() != 0)
/*     */         {
/*     */           
/* 592 */           if (this._state == 0 || this._state == 2) {
/*     */ 
/*     */             
/* 595 */             for (byte b1 = 0; b1 < getAttributeCount(); b1++) {
/*     */ 
/*     */               
/* 598 */               b b2 = new b(getAttributeNamespace(b1), getAttributeLocalName(b1));
/*     */               
/* 600 */               if (b2.equals(XSI_TYPE)) {
/*     */                 
/* 602 */                 String str1 = getAttributeValue(b1);
/* 603 */                 String str2 = getNamespaceURI(QNameHelper.getPrefixPart(str1));
/* 604 */                 b b3 = new b(str2, QNameHelper.getLocalPart(str1));
/* 605 */                 this._xsiType = this._stl.findType(b3);
/*     */               } 
/*     */               
/* 608 */               if (this._attNamesList == null) {
/*     */                 
/* 610 */                 this._attNamesList = new ArrayList();
/* 611 */                 this._attValuesList = new ArrayList();
/*     */               } 
/*     */               
/* 614 */               if (!isSpecialAttribute(b2)) {
/*     */ 
/*     */                 
/* 617 */                 this._attNamesList.add(b2);
/* 618 */                 this._attValuesList.add(getAttributeValue(b1));
/*     */               } 
/* 620 */             }  this._state = 2;
/*     */           } else {
/*     */             
/* 623 */             throw new IllegalStateException("ATT event must be only at the beggining of the stream.");
/*     */           } 
/*     */         }
/*     */       
/*     */       case 2:
/*     */       case 8:
/* 629 */         this._depth--;
/* 630 */         if (this._state == 2) {
/* 631 */           pushBufferedAttributes();
/*     */         }
/* 633 */         this._validator.nextEvent(2, this._elemEvent);
/*     */ 
/*     */       
/*     */       case 4:
/*     */       case 12:
/* 638 */         if (this._state == 2) {
/* 639 */           pushBufferedAttributes();
/*     */         }
/* 641 */         if (this._validator == null)
/*     */         {
/* 643 */           if (this._contentType == null)
/*     */           
/* 645 */           { if (!isWhiteSpace()) {
/*     */ 
/*     */               
/* 648 */               addError("No content type provided for validation of a content model.");
/* 649 */               this._state = 3;
/*     */             }  }
/*     */           else
/* 652 */           { initValidator(this._contentType);
/* 653 */             this._validator.nextEvent(1, this._simpleEvent);
/*     */ 
/*     */             
/* 656 */             this._validator.nextEvent(3, this._elemEvent); }  }  this._validator.nextEvent(3, this._elemEvent);
/*     */ 
/*     */       
/*     */       case 7:
/* 660 */         this._depth++;
/*     */ 
/*     */       
/*     */       case 3:
/*     */       case 5:
/*     */       case 6:
/*     */       case 9:
/*     */       case 11:
/*     */       case 13:
/*     */       case 14:
/*     */       case 15:
/*     */         return;
/*     */     } 
/*     */ 
/*     */     
/* 675 */     throw new IllegalStateException("Unknown event type.");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void pushBufferedAttributes() {
/* 681 */     SchemaType schemaType = null;
/*     */     
/* 683 */     if (this._xsiType != null) {
/*     */       
/* 685 */       if (this._contentType == null) {
/*     */         
/* 687 */         schemaType = this._xsiType;
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 692 */       else if (this._contentType.isAssignableFrom(this._xsiType)) {
/*     */         
/* 694 */         schemaType = this._xsiType;
/*     */       }
/*     */       else {
/*     */         
/* 698 */         addError("Specified type '" + this._contentType + "' not compatible with found xsi:type '" + this._xsiType + "'.");
/*     */         
/* 700 */         this._state = 3;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/* 707 */     } else if (this._contentType != null) {
/*     */       
/* 709 */       schemaType = this._contentType;
/*     */     }
/* 711 */     else if (this._attNamesList != null) {
/*     */ 
/*     */ 
/*     */       
/* 715 */       schemaType = this._stl.findAttributeType(this._attNamesList.get(0));
/* 716 */       if (schemaType == null) {
/*     */         
/* 718 */         addError("A schema global attribute with name '" + this._attNamesList.get(0) + "' could not be found in the current schema type loader.");
/*     */         
/* 720 */         this._state = 3;
/*     */ 
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } else {
/* 727 */       addError("No content type provided for validation of a content model.");
/* 728 */       this._state = 3;
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 734 */     initValidator(schemaType);
/* 735 */     this._validator.nextEvent(1, this._simpleEvent);
/*     */ 
/*     */     
/* 738 */     validate_attributes(this._attNamesList.size());
/* 739 */     this._attNamesList = null;
/* 740 */     this._attValuesList = null;
/*     */     
/* 742 */     this._state = 1;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isSpecialAttribute(b paramb) {
/* 747 */     if (paramb.getNamespaceURI().equals("http://www.w3.org/2001/XMLSchema-instance")) {
/* 748 */       return (paramb.dT().equals(XSI_TYPE.dT()) || paramb.dT().equals(XSI_NIL.dT()) || paramb.dT().equals(XSI_SL.dT()) || paramb.dT().equals(XSI_NSL.dT()));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 753 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initValidator(SchemaType paramSchemaType) {
/* 762 */     assert paramSchemaType != null;
/*     */     
/* 764 */     this._validator = new Validator(paramSchemaType, null, this._stl, this._options, this._errorListener);
/*     */   }
/*     */ 
/*     */   
/*     */   private SchemaType typeForGlobalElement(b paramb) {
/* 769 */     assert paramb != null;
/*     */     
/* 771 */     SchemaType schemaType = this._stl.findDocumentType(paramb);
/*     */     
/* 773 */     if (schemaType == null) {
/*     */       
/* 775 */       addError("Schema document type not found for element '" + paramb + "'.");
/* 776 */       this._state = 3;
/*     */     } 
/* 778 */     return schemaType;
/*     */   }
/*     */ 
/*     */   
/*     */   private void addError(String paramString) {
/* 783 */     String str = null;
/* 784 */     Location location = getLocation();
/*     */     
/* 786 */     if (location != null) {
/*     */       
/* 788 */       str = location.getPublicId();
/* 789 */       if (str == null) {
/* 790 */         str = location.getSystemId();
/*     */       }
/* 792 */       this._errorListener.add(XmlError.forLocation(paramString, str, location));
/*     */     } else {
/*     */       
/* 795 */       this._errorListener.add(XmlError.forMessage(paramString));
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void validate_attributes(int paramInt) {
/* 800 */     for (byte b1 = 0; b1 < paramInt; b1++)
/*     */     {
/* 802 */       validate_attribute(b1);
/*     */     }
/*     */     
/* 805 */     if (this._options == null || !this._options.hasOption("OPTION_ATTTRIBUTE_VALIDATION_COMPAT_MODE"))
/*     */     {
/*     */       
/* 808 */       this._validator.nextEvent(5, this._simpleEvent);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void validate_attribute(int paramInt) {
/*     */     SimpleEventImpl simpleEventImpl;
/* 814 */     if (this._attNamesList == null) {
/*     */       
/* 816 */       this._attEvent.setAttributeIndex(paramInt);
/* 817 */       b b1 = this._attEvent.getName();
/* 818 */       if (isSpecialAttribute(b1)) {
/*     */         return;
/*     */       }
/* 821 */       AttributeEventImpl attributeEventImpl = this._attEvent;
/*     */     }
/*     */     else {
/*     */       
/* 825 */       this._simpleEvent._qname = this._attNamesList.get(paramInt);
/* 826 */       this._simpleEvent._text = this._attValuesList.get(paramInt);
/* 827 */       simpleEventImpl = this._simpleEvent;
/*     */     } 
/*     */     
/* 830 */     this._validator.nextEvent(4, simpleEventImpl);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValid() {
/* 839 */     if (this._state == 3 || this._validator == null) {
/* 840 */       return false;
/*     */     }
/* 842 */     return this._validator.isValid();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\validator\ValidatingXMLStreamReader.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */