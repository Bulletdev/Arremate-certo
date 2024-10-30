/*      */ package org.apache.xmlbeans.impl.values;
/*      */ 
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.DataInputStream;
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.io.ObjectOutputStream;
/*      */ import java.io.ObjectStreamException;
/*      */ import java.io.OutputStream;
/*      */ import java.io.Reader;
/*      */ import java.io.Serializable;
/*      */ import java.io.Writer;
/*      */ import java.lang.reflect.Array;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Calendar;
/*      */ import java.util.Collection;
/*      */ import java.util.Date;
/*      */ import java.util.HashSet;
/*      */ import java.util.List;
/*      */ import javax.xml.namespace.b;
/*      */ import javax.xml.stream.XMLStreamReader;
/*      */ import org.apache.xmlbeans.DelegateXmlObject;
/*      */ import org.apache.xmlbeans.GDate;
/*      */ import org.apache.xmlbeans.GDateSpecification;
/*      */ import org.apache.xmlbeans.GDuration;
/*      */ import org.apache.xmlbeans.GDurationSpecification;
/*      */ import org.apache.xmlbeans.QNameSet;
/*      */ import org.apache.xmlbeans.SchemaAttributeModel;
/*      */ import org.apache.xmlbeans.SchemaField;
/*      */ import org.apache.xmlbeans.SchemaLocalAttribute;
/*      */ import org.apache.xmlbeans.SchemaProperty;
/*      */ import org.apache.xmlbeans.SchemaType;
/*      */ import org.apache.xmlbeans.SchemaTypeLoader;
/*      */ import org.apache.xmlbeans.SimpleValue;
/*      */ import org.apache.xmlbeans.StringEnumAbstractBase;
/*      */ import org.apache.xmlbeans.XmlAnySimpleType;
/*      */ import org.apache.xmlbeans.XmlBeans;
/*      */ import org.apache.xmlbeans.XmlCursor;
/*      */ import org.apache.xmlbeans.XmlDocumentProperties;
/*      */ import org.apache.xmlbeans.XmlError;
/*      */ import org.apache.xmlbeans.XmlException;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.XmlOptions;
/*      */ import org.apache.xmlbeans.XmlRuntimeException;
/*      */ import org.apache.xmlbeans.impl.common.GlobalLock;
/*      */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*      */ import org.apache.xmlbeans.impl.common.ValidationContext;
/*      */ import org.apache.xmlbeans.impl.common.ValidatorListener;
/*      */ import org.apache.xmlbeans.impl.common.XmlErrorWatcher;
/*      */ import org.apache.xmlbeans.impl.common.XmlLocale;
/*      */ import org.apache.xmlbeans.impl.common.XmlWhitespace;
/*      */ import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;
/*      */ import org.apache.xmlbeans.impl.schema.SchemaTypeVisitorImpl;
/*      */ import org.apache.xmlbeans.impl.validator.Validator;
/*      */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*      */ import org.w3c.dom.Node;
/*      */ import org.xml.sax.ContentHandler;
/*      */ import org.xml.sax.SAXException;
/*      */ import org.xml.sax.ext.LexicalHandler;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class XmlObjectBase
/*      */   implements Serializable, SimpleValue, XmlObject, TypeStoreUser
/*      */ {
/*      */   public static final short MAJOR_VERSION_NUMBER = 1;
/*      */   public static final short MINOR_VERSION_NUMBER = 1;
/*      */   public static final short KIND_SETTERHELPER_SINGLETON = 1;
/*      */   public static final short KIND_SETTERHELPER_ARRAYITEM = 2;
/*      */   
/*      */   public final Object monitor() {
/*   97 */     if (has_store())
/*   98 */       return get_store().get_locale(); 
/*   99 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   private static XmlObjectBase underlying(XmlObject paramXmlObject) {
/*  104 */     if (paramXmlObject == null)
/*  105 */       return null; 
/*  106 */     if (paramXmlObject instanceof XmlObjectBase)
/*  107 */       return (XmlObjectBase)paramXmlObject; 
/*  108 */     while (paramXmlObject instanceof DelegateXmlObject)
/*  109 */       paramXmlObject = ((DelegateXmlObject)paramXmlObject).underlyingXmlObject(); 
/*  110 */     if (paramXmlObject instanceof XmlObjectBase)
/*  111 */       return (XmlObjectBase)paramXmlObject; 
/*  112 */     throw new IllegalStateException("Non-native implementations of XmlObject should extend FilterXmlObject or implement DelegateXmlObject");
/*      */   }
/*      */ 
/*      */   
/*      */   public final XmlObject copy() {
/*  117 */     if (preCheck()) {
/*  118 */       return _copy();
/*      */     }
/*  120 */     synchronized (monitor()) {
/*      */       
/*  122 */       return _copy();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final XmlObject copy(XmlOptions paramXmlOptions) {
/*  128 */     if (preCheck()) {
/*  129 */       return _copy(paramXmlOptions);
/*      */     }
/*  131 */     synchronized (monitor()) {
/*      */       
/*  133 */       return _copy(paramXmlOptions);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean preCheck() {
/*  141 */     if (has_store())
/*  142 */       return get_store().get_locale().noSync(); 
/*  143 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final XmlObject _copy() {
/*  152 */     return _copy(null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final XmlObject _copy(XmlOptions paramXmlOptions) {
/*  163 */     if (isImmutable()) {
/*  164 */       return this;
/*      */     }
/*  166 */     check_orphaned();
/*      */     
/*  168 */     SchemaTypeLoader schemaTypeLoader = get_store().get_schematypeloader();
/*  169 */     return (XmlObject)get_store().copy(schemaTypeLoader, schemaType(), paramXmlOptions);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlDocumentProperties documentProperties() {
/*  175 */     XmlCursor xmlCursor = newCursorForce(); try { return xmlCursor.documentProperties(); } finally { xmlCursor.dispose(); }
/*      */   
/*      */   }
/*      */ 
/*      */   
/*      */   public XMLInputStream newXMLInputStream() {
/*  181 */     return newXMLInputStream(null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public XMLInputStream newXMLInputStream(XmlOptions paramXmlOptions) {
/*  187 */     XmlCursor xmlCursor = newCursorForce(); try { return xmlCursor.newXMLInputStream(makeInnerOptions(paramXmlOptions)); } finally { xmlCursor.dispose(); }
/*      */   
/*      */   } public XMLStreamReader newXMLStreamReader() {
/*  190 */     return newXMLStreamReader(null);
/*      */   }
/*      */   public XMLStreamReader newXMLStreamReader(XmlOptions paramXmlOptions) {
/*  193 */     XmlCursor xmlCursor = newCursorForce(); try { return xmlCursor.newXMLStreamReader(makeInnerOptions(paramXmlOptions)); } finally { xmlCursor.dispose(); }
/*      */   
/*      */   } public InputStream newInputStream() {
/*  196 */     return newInputStream(null);
/*      */   }
/*      */   public InputStream newInputStream(XmlOptions paramXmlOptions) {
/*  199 */     XmlCursor xmlCursor = newCursorForce(); try { return xmlCursor.newInputStream(makeInnerOptions(paramXmlOptions)); } finally { xmlCursor.dispose(); }
/*      */   
/*      */   } public Reader newReader() {
/*  202 */     return newReader(null);
/*      */   }
/*      */   public Reader newReader(XmlOptions paramXmlOptions) {
/*  205 */     XmlCursor xmlCursor = newCursorForce(); try { return xmlCursor.newReader(makeInnerOptions(paramXmlOptions)); } finally { xmlCursor.dispose(); }
/*      */   
/*      */   } public Node getDomNode() {
/*  208 */     XmlCursor xmlCursor = newCursorForce(); try { return xmlCursor.getDomNode(); } finally { xmlCursor.dispose(); }
/*      */   
/*      */   } public Node newDomNode() {
/*  211 */     return newDomNode(null);
/*      */   }
/*      */   public Node newDomNode(XmlOptions paramXmlOptions) {
/*  214 */     XmlCursor xmlCursor = newCursorForce(); try { return xmlCursor.newDomNode(makeInnerOptions(paramXmlOptions)); } finally { xmlCursor.dispose(); }
/*      */   
/*      */   } public void save(ContentHandler paramContentHandler, LexicalHandler paramLexicalHandler, XmlOptions paramXmlOptions) throws SAXException {
/*  217 */     XmlCursor xmlCursor = newCursorForce(); try { xmlCursor.save(paramContentHandler, paramLexicalHandler, makeInnerOptions(paramXmlOptions)); } finally { xmlCursor.dispose(); }
/*      */   
/*      */   } public void save(File paramFile, XmlOptions paramXmlOptions) throws IOException {
/*  220 */     XmlCursor xmlCursor = newCursorForce(); try { xmlCursor.save(paramFile, makeInnerOptions(paramXmlOptions)); } finally { xmlCursor.dispose(); }
/*      */   
/*      */   } public void save(OutputStream paramOutputStream, XmlOptions paramXmlOptions) throws IOException {
/*  223 */     XmlCursor xmlCursor = newCursorForce(); try { xmlCursor.save(paramOutputStream, makeInnerOptions(paramXmlOptions)); } finally { xmlCursor.dispose(); }
/*      */   
/*      */   } public void save(Writer paramWriter, XmlOptions paramXmlOptions) throws IOException {
/*  226 */     XmlCursor xmlCursor = newCursorForce(); try { xmlCursor.save(paramWriter, makeInnerOptions(paramXmlOptions)); } finally { xmlCursor.dispose(); }
/*      */   
/*      */   } public void save(ContentHandler paramContentHandler, LexicalHandler paramLexicalHandler) throws SAXException {
/*  229 */     save(paramContentHandler, paramLexicalHandler, null);
/*      */   }
/*      */   public void save(File paramFile) throws IOException {
/*  232 */     save(paramFile, (XmlOptions)null);
/*      */   }
/*      */   public void save(OutputStream paramOutputStream) throws IOException {
/*  235 */     save(paramOutputStream, (XmlOptions)null);
/*      */   }
/*      */   public void save(Writer paramWriter) throws IOException {
/*  238 */     save(paramWriter, (XmlOptions)null);
/*      */   }
/*      */   public void dump() {
/*  241 */     XmlCursor xmlCursor = newCursorForce(); try { xmlCursor.dump(); } finally { xmlCursor.dispose(); }
/*      */   
/*      */   }
/*      */   public XmlCursor newCursorForce() {
/*  245 */     synchronized (monitor()) {
/*      */       
/*  247 */       return ensureStore().newCursor();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private XmlObject ensureStore() {
/*  253 */     if ((this._flags & 0x10) != 0) {
/*  254 */       return this;
/*      */     }
/*  256 */     check_dated();
/*      */     
/*  258 */     String str = ((this._flags & 0x40) != 0) ? "" : compute_text(has_store() ? get_store() : null);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  263 */     XmlOptions xmlOptions = (new XmlOptions()).setDocumentType(schemaType());
/*      */     
/*  265 */     XmlObject xmlObject = XmlObject.Factory.newInstance(xmlOptions);
/*      */     
/*  267 */     XmlCursor xmlCursor = xmlObject.newCursor();
/*  268 */     xmlCursor.toNextToken();
/*  269 */     xmlCursor.insertChars(str);
/*      */     
/*  271 */     return xmlObject;
/*      */   }
/*      */ 
/*      */   
/*      */   private static XmlOptions makeInnerOptions(XmlOptions paramXmlOptions) {
/*  276 */     XmlOptions xmlOptions = new XmlOptions(paramXmlOptions);
/*  277 */     xmlOptions.put("SAVE_INNER");
/*  278 */     return xmlOptions;
/*      */   }
/*      */ 
/*      */   
/*      */   public XmlCursor newCursor() {
/*  283 */     if ((this._flags & 0x10) == 0) {
/*  284 */       throw new IllegalStateException("XML Value Objects cannot create cursors");
/*      */     }
/*  286 */     check_orphaned();
/*      */ 
/*      */ 
/*      */     
/*  290 */     XmlLocale xmlLocale = getXmlLocale();
/*      */     
/*  292 */     if (xmlLocale.noSync()) { xmlLocale.enter(); try { return get_store().new_cursor(); } finally { xmlLocale.exit(); }  }
/*  293 */      synchronized (xmlLocale) { xmlLocale.enter(); try { return get_store().new_cursor(); } finally { xmlLocale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaType instanceType() {
/*  300 */     synchronized (monitor()) { return isNil() ? null : schemaType(); }
/*      */   
/*      */   } private SchemaField schemaField() {
/*  303 */     SchemaType schemaType = schemaType();
/*      */ 
/*      */ 
/*      */     
/*  307 */     SchemaField schemaField = schemaType.getContainerField();
/*      */     
/*  309 */     if (schemaField == null) {
/*  310 */       schemaField = get_store().get_schema_field();
/*      */     }
/*  312 */     return schemaField;
/*      */   }
/*      */ 
/*      */   
/*      */   private static final class ValueOutOfRangeValidationContext
/*      */     implements ValidationContext
/*      */   {
/*      */     private ValueOutOfRangeValidationContext() {}
/*      */ 
/*      */     
/*      */     public void invalid(String param1String) {
/*  323 */       throw new XmlValueOutOfRangeException(param1String);
/*      */     }
/*      */ 
/*      */     
/*      */     public void invalid(String param1String, Object[] param1ArrayOfObject) {
/*  328 */       throw new XmlValueOutOfRangeException(param1String, param1ArrayOfObject);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static final class ImmutableValueValidationContext
/*      */     implements ValidationContext
/*      */   {
/*      */     private XmlObject _loc;
/*      */     
/*      */     private Collection _coll;
/*      */     
/*      */     ImmutableValueValidationContext(Collection param1Collection, XmlObject param1XmlObject) {
/*  341 */       this._coll = param1Collection;
/*  342 */       this._loc = param1XmlObject;
/*      */     }
/*      */     
/*      */     public void invalid(String param1String) {
/*  346 */       this._coll.add(XmlError.forObject(param1String, this._loc));
/*      */     }
/*      */     
/*      */     public void invalid(String param1String, Object[] param1ArrayOfObject) {
/*  350 */       this._coll.add(XmlError.forObject(param1String, param1ArrayOfObject, this._loc));
/*      */     }
/*      */   }
/*      */   
/*  354 */   public static final ValidationContext _voorVc = new ValueOutOfRangeValidationContext(); private int _flags; private Object _textsource; private static final int FLAG_NILLABLE = 1; private static final int FLAG_HASDEFAULT = 2; private static final int FLAG_FIXED = 4; private static final int FLAG_ATTRIBUTE = 8; private static final int FLAG_STORE = 16; private static final int FLAG_VALUE_DATED = 32; private static final int FLAG_NIL = 64; private static final int FLAG_NIL_DATED = 128; private static final int FLAG_ISDEFAULT = 256; private static final int FLAG_ELEMENT_DATED = 512; private static final int FLAG_SETTINGDEFAULT = 1024; private static final int FLAG_ORPHANED = 2048; private static final int FLAG_IMMUTABLE = 4096; private static final int FLAG_COMPLEXTYPE = 8192; private static final int FLAG_COMPLEXCONTENT = 16384; private static final int FLAG_NOT_VARIABLE = 32768; private static final int FLAG_VALIDATE_ON_SET = 65536; private static final int FLAGS_DATED = 672; private static final int FLAGS_ELEMENT = 7;
/*      */   
/*      */   public boolean validate() {
/*  357 */     return validate(null);
/*      */   }
/*      */   
/*      */   public boolean validate(XmlOptions paramXmlOptions) {
/*  361 */     if ((this._flags & 0x10) == 0) {
/*      */       
/*  363 */       if ((this._flags & 0x1000) != 0)
/*      */       {
/*  365 */         return validate_immutable(paramXmlOptions);
/*      */       }
/*      */       
/*  368 */       throw new IllegalStateException("XML objects with no underlying store cannot be validated");
/*      */     } 
/*      */ 
/*      */     
/*  372 */     synchronized (monitor()) {
/*      */       
/*  374 */       if ((this._flags & 0x800) != 0) {
/*  375 */         throw new XmlValueDisconnectedException();
/*      */       }
/*  377 */       SchemaField schemaField = schemaField();
/*  378 */       SchemaType schemaType = schemaType();
/*      */       
/*  380 */       TypeStore typeStore = get_store();
/*      */       
/*  382 */       Validator validator = new Validator(schemaType, schemaField, typeStore.get_schematypeloader(), paramXmlOptions, null);
/*      */ 
/*      */ 
/*      */       
/*  386 */       typeStore.validate((ValidatorListener)validator);
/*      */       
/*  388 */       return validator.isValid();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean validate_immutable(XmlOptions paramXmlOptions) {
/*  394 */     Collection collection = (paramXmlOptions == null) ? null : (Collection)paramXmlOptions.get("ERROR_LISTENER");
/*  395 */     XmlErrorWatcher xmlErrorWatcher = new XmlErrorWatcher(collection);
/*  396 */     if (!schemaType().isSimpleType() && (paramXmlOptions == null || !paramXmlOptions.hasOption("VALIDATE_TEXT_ONLY"))) {
/*      */ 
/*      */ 
/*      */       
/*  400 */       SchemaProperty[] arrayOfSchemaProperty = schemaType().getProperties();
/*  401 */       for (byte b = 0; b < arrayOfSchemaProperty.length; b++) {
/*      */         
/*  403 */         if (arrayOfSchemaProperty[b].getMinOccurs().signum() > 0)
/*      */         {
/*      */           
/*  406 */           if (arrayOfSchemaProperty[b].isAttribute()) {
/*  407 */             xmlErrorWatcher.add(XmlError.forObject("cvc-complex-type.4", new Object[] { QNameHelper.pretty(arrayOfSchemaProperty[b].getName()) }, this));
/*      */           } else {
/*  409 */             xmlErrorWatcher.add(XmlError.forObject("cvc-complex-type.2.4c", new Object[] { arrayOfSchemaProperty[b].getMinOccurs(), QNameHelper.pretty(arrayOfSchemaProperty[b].getName()) }, this));
/*      */           } 
/*      */         }
/*      */       } 
/*  413 */       if (schemaType().getContentType() != 2) {
/*  414 */         return !xmlErrorWatcher.hasError();
/*      */       }
/*      */     } 
/*  417 */     String str = (String)this._textsource;
/*  418 */     if (str == null)
/*  419 */       str = ""; 
/*  420 */     validate_simpleval(str, new ImmutableValueValidationContext((Collection)xmlErrorWatcher, this));
/*  421 */     return !xmlErrorWatcher.hasError();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void validate_simpleval(String paramString, ValidationContext paramValidationContext) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private static XmlObject[] _typedArray(XmlObject[] paramArrayOfXmlObject) {
/*  431 */     if (paramArrayOfXmlObject.length == 0)
/*  432 */       return paramArrayOfXmlObject; 
/*  433 */     SchemaType schemaType = paramArrayOfXmlObject[0].schemaType();
/*  434 */     if (schemaType.equals(XmlObject.type) || schemaType.isNoType())
/*  435 */       return paramArrayOfXmlObject; 
/*  436 */     for (byte b = 1; b < paramArrayOfXmlObject.length; b++) {
/*      */       
/*  438 */       if (paramArrayOfXmlObject[b].schemaType().isNoType())
/*  439 */         return paramArrayOfXmlObject; 
/*  440 */       schemaType = schemaType.getCommonBaseType(paramArrayOfXmlObject[b].schemaType());
/*  441 */       if (schemaType.equals(XmlObject.type))
/*  442 */         return paramArrayOfXmlObject; 
/*      */     } 
/*  444 */     Class clazz = schemaType.getJavaClass();
/*  445 */     while (clazz == null) {
/*      */       
/*  447 */       schemaType = schemaType.getBaseType();
/*  448 */       if (XmlObject.type.equals(schemaType))
/*  449 */         return paramArrayOfXmlObject; 
/*  450 */       clazz = schemaType.getJavaClass();
/*      */     } 
/*      */     
/*  453 */     XmlObject[] arrayOfXmlObject = (XmlObject[])Array.newInstance(clazz, paramArrayOfXmlObject.length);
/*  454 */     System.arraycopy(paramArrayOfXmlObject, 0, arrayOfXmlObject, 0, paramArrayOfXmlObject.length);
/*  455 */     return arrayOfXmlObject;
/*      */   }
/*      */ 
/*      */   
/*      */   public XmlObject[] selectPath(String paramString) {
/*  460 */     return selectPath(paramString, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlObject[] selectPath(String paramString, XmlOptions paramXmlOptions) {
/*      */     XmlObject[] arrayOfXmlObject;
/*  469 */     XmlCursor xmlCursor = newCursor();
/*      */     
/*  471 */     if (xmlCursor == null) {
/*  472 */       throw new XmlValueDisconnectedException();
/*      */     }
/*      */     
/*      */     try {
/*  476 */       xmlCursor.selectPath(paramString, paramXmlOptions);
/*      */       
/*  478 */       if (!xmlCursor.hasNextSelection()) {
/*  479 */         arrayOfXmlObject = EMPTY_RESULT;
/*      */       } else {
/*      */         
/*  482 */         arrayOfXmlObject = new XmlObject[xmlCursor.getSelectionCount()];
/*      */         
/*  484 */         for (byte b = 0; xmlCursor.toNextSelection(); b++)
/*      */         {
/*  486 */           arrayOfXmlObject[b] = xmlCursor.getObject(); if (xmlCursor.getObject() == null)
/*      */           {
/*  488 */             arrayOfXmlObject[b] = xmlCursor.getObject(); if (!xmlCursor.toParent() || xmlCursor.getObject() == null) {
/*  489 */               throw new XmlRuntimeException("Path must select only elements and attributes");
/*      */             }
/*      */           }
/*      */         
/*      */         }
/*      */       
/*      */       }
/*      */     
/*      */     } finally {
/*      */       
/*  499 */       xmlCursor.dispose();
/*      */     } 
/*      */     
/*  502 */     return _typedArray(arrayOfXmlObject);
/*      */   }
/*      */ 
/*      */   
/*      */   public XmlObject[] execQuery(String paramString) {
/*  507 */     return execQuery(paramString, null);
/*      */   }
/*      */ 
/*      */   
/*      */   public XmlObject[] execQuery(String paramString, XmlOptions paramXmlOptions) {
/*  512 */     synchronized (monitor()) {
/*      */       
/*  514 */       TypeStore typeStore = get_store();
/*      */       
/*  516 */       if (typeStore == null)
/*      */       {
/*  518 */         throw new XmlRuntimeException("Cannot do XQuery on XML Value Objects");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       try {
/*  525 */         return _typedArray(typeStore.exec_query(paramString, paramXmlOptions));
/*      */       }
/*  527 */       catch (XmlException xmlException) {
/*      */         
/*  529 */         throw new XmlRuntimeException(xmlException);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public XmlObject changeType(SchemaType paramSchemaType) {
/*  536 */     if (paramSchemaType == null) {
/*  537 */       throw new IllegalArgumentException("Invalid type (null)");
/*      */     }
/*  539 */     if ((this._flags & 0x10) == 0)
/*      */     {
/*  541 */       throw new IllegalStateException("XML Value Objects cannot have thier type changed");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  546 */     synchronized (monitor()) {
/*      */       
/*  548 */       check_orphaned();
/*  549 */       return (XmlObject)get_store().change_type(paramSchemaType);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public XmlObject substitute(b paramb, SchemaType paramSchemaType) {
/*  555 */     if (paramb == null) {
/*  556 */       throw new IllegalArgumentException("Invalid name (null)");
/*      */     }
/*  558 */     if (paramSchemaType == null) {
/*  559 */       throw new IllegalArgumentException("Invalid type (null)");
/*      */     }
/*  561 */     if ((this._flags & 0x10) == 0)
/*      */     {
/*  563 */       throw new IllegalStateException("XML Value Objects cannot be used with substitution");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  568 */     synchronized (monitor()) {
/*      */       
/*  570 */       check_orphaned();
/*  571 */       return (XmlObject)get_store().substitute(paramb, paramSchemaType);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected XmlObjectBase() {
/*  580 */     this._flags = 65;
/*      */   }
/*      */ 
/*      */   
/*      */   public void init_flags(SchemaProperty paramSchemaProperty) {
/*  585 */     if (paramSchemaProperty == null)
/*      */       return; 
/*  587 */     if (paramSchemaProperty.hasDefault() == 1 || paramSchemaProperty.hasFixed() == 1 || paramSchemaProperty.hasNillable() == 1) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  592 */     this._flags &= 0xFFFFFFF8;
/*  593 */     this._flags |= ((paramSchemaProperty.hasDefault() == 0) ? 0 : 2) | ((paramSchemaProperty.hasFixed() == 0) ? 0 : 4) | ((paramSchemaProperty.hasNillable() == 0) ? 0 : 1) | 0x8000;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void initComplexType(boolean paramBoolean1, boolean paramBoolean2) {
/*  651 */     this._flags |= (paramBoolean1 ? 8192 : 0) | (paramBoolean2 ? 16384 : 0);
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean _isComplexType() {
/*  656 */     return ((this._flags & 0x2000) != 0);
/*      */   }
/*      */   protected boolean _isComplexContent() {
/*  659 */     return ((this._flags & 0x4000) != 0);
/*      */   }
/*      */   public void setValidateOnSet() {
/*  662 */     this._flags |= 0x10000;
/*      */   }
/*      */   
/*      */   protected boolean _validateOnSet() {
/*  666 */     return ((this._flags & 0x10000) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean isNil() {
/*  673 */     synchronized (monitor()) {
/*      */       
/*  675 */       check_dated();
/*  676 */       return ((this._flags & 0x40) != 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean isFixed() {
/*  685 */     check_element_dated();
/*  686 */     return ((this._flags & 0x4) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean isNillable() {
/*  694 */     check_element_dated();
/*  695 */     return ((this._flags & 0x1) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean isDefaultable() {
/*  703 */     check_element_dated();
/*  704 */     return ((this._flags & 0x2) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean isDefault() {
/*  712 */     check_dated();
/*  713 */     return ((this._flags & 0x100) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void setNil() {
/*  722 */     synchronized (monitor()) {
/*      */       
/*  724 */       set_prepare();
/*      */ 
/*      */       
/*  727 */       if ((this._flags & 0x1) == 0 && (this._flags & 0x10000) != 0)
/*      */       {
/*  729 */         throw new XmlValueNotNillableException();
/*      */       }
/*      */       
/*  732 */       set_nil();
/*      */ 
/*      */       
/*  735 */       this._flags |= 0x40;
/*      */ 
/*      */       
/*  738 */       if ((this._flags & 0x10) != 0) {
/*      */         
/*  740 */         get_store().invalidate_text();
/*  741 */         this._flags &= 0xFFFFFD5F;
/*  742 */         get_store().invalidate_nil();
/*      */       }
/*      */       else {
/*      */         
/*  746 */         this._textsource = null;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int elementFlags() {
/*  758 */     check_element_dated();
/*  759 */     return this._flags & 0x7;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setImmutable() {
/*  772 */     if ((this._flags & 0x1010) != 0) {
/*  773 */       throw new IllegalStateException();
/*      */     }
/*  775 */     this._flags |= 0x1000;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isImmutable() {
/*  783 */     return ((this._flags & 0x1000) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void attach_store(TypeStore paramTypeStore) {
/*  800 */     this._textsource = paramTypeStore;
/*  801 */     if ((this._flags & 0x1000) != 0)
/*  802 */       throw new IllegalStateException(); 
/*  803 */     this._flags |= 0x2B0;
/*      */     
/*  805 */     if (paramTypeStore.is_attribute()) {
/*  806 */       this._flags |= 0x8;
/*      */     }
/*  808 */     if (paramTypeStore.validate_on_set()) {
/*  809 */       this._flags |= 0x10000;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void invalidate_value() {
/*  819 */     assert (this._flags & 0x10) != 0;
/*  820 */     this._flags |= 0x20;
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean uses_invalidate_value() {
/*  825 */     SchemaType schemaType = schemaType();
/*  826 */     return (schemaType.isSimpleType() || schemaType.getContentType() == 2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void invalidate_nilvalue() {
/*  837 */     assert (this._flags & 0x10) != 0;
/*  838 */     this._flags |= 0xA0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void invalidate_element_order() {
/*  850 */     assert (this._flags & 0x10) != 0;
/*  851 */     this._flags |= 0x2A0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final TypeStore get_store() {
/*  860 */     assert (this._flags & 0x10) != 0;
/*  861 */     return (TypeStore)this._textsource;
/*      */   }
/*      */ 
/*      */   
/*      */   public final XmlLocale getXmlLocale() {
/*  866 */     return get_store().get_locale();
/*      */   }
/*      */ 
/*      */   
/*      */   protected final boolean has_store() {
/*  871 */     return ((this._flags & 0x10) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String build_text(NamespaceManager paramNamespaceManager) {
/*  881 */     assert (this._flags & 0x10) != 0;
/*  882 */     assert (this._flags & 0x20) == 0;
/*  883 */     if ((this._flags & 0x140) != 0)
/*  884 */       return ""; 
/*  885 */     return compute_text((paramNamespaceManager == null) ? (has_store() ? get_store() : null) : paramNamespaceManager);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean build_nil() {
/*  895 */     assert (this._flags & 0x10) != 0;
/*  896 */     assert (this._flags & 0x20) == 0;
/*  897 */     return ((this._flags & 0x40) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void validate_now() {
/*  907 */     check_dated();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void disconnect_store() {
/*  920 */     assert (this._flags & 0x10) != 0;
/*  921 */     this._flags |= 0xAA0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TypeStoreUser create_element_user(b paramb1, b paramb2) {
/*  938 */     return (TypeStoreUser)((SchemaTypeImpl)schemaType()).createElementType(paramb1, paramb2, get_store().get_schematypeloader());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TypeStoreUser create_attribute_user(b paramb) {
/*  960 */     return (TypeStoreUser)((SchemaTypeImpl)schemaType()).createAttributeType(paramb, get_store().get_schematypeloader());
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaType get_schema_type() {
/*  965 */     return schemaType();
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaType get_element_type(b paramb1, b paramb2) {
/*  970 */     return schemaType().getElementType(paramb1, paramb2, get_store().get_schematypeloader());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaType get_attribute_type(b paramb) {
/*  976 */     return schemaType().getAttributeType(paramb, get_store().get_schematypeloader());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String get_default_element_text(b paramb) {
/*  990 */     assert _isComplexContent();
/*  991 */     if (!_isComplexContent()) {
/*  992 */       throw new IllegalStateException();
/*      */     }
/*  994 */     SchemaProperty schemaProperty = schemaType().getElementProperty(paramb);
/*  995 */     if (schemaProperty == null)
/*  996 */       return ""; 
/*  997 */     return schemaProperty.getDefaultText();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String get_default_attribute_text(b paramb) {
/* 1006 */     assert _isComplexType();
/* 1007 */     if (!_isComplexType()) {
/* 1008 */       throw new IllegalStateException();
/*      */     }
/* 1010 */     SchemaProperty schemaProperty = schemaType().getAttributeProperty(paramb);
/* 1011 */     if (schemaProperty == null)
/* 1012 */       return ""; 
/* 1013 */     return schemaProperty.getDefaultText();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int get_elementflags(b paramb) {
/* 1022 */     if (!_isComplexContent()) {
/* 1023 */       return 0;
/*      */     }
/* 1025 */     SchemaProperty schemaProperty = schemaType().getElementProperty(paramb);
/* 1026 */     if (schemaProperty == null)
/* 1027 */       return 0; 
/* 1028 */     if (schemaProperty.hasDefault() == 1 || schemaProperty.hasFixed() == 1 || schemaProperty.hasNillable() == 1)
/*      */     {
/*      */       
/* 1031 */       return -1; } 
/* 1032 */     return ((schemaProperty.hasDefault() == 0) ? 0 : 2) | ((schemaProperty.hasFixed() == 0) ? 0 : 4) | ((schemaProperty.hasNillable() == 0) ? 0 : 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int get_attributeflags(b paramb) {
/* 1043 */     if (!_isComplexType())
/* 1044 */       return 0; 
/* 1045 */     SchemaProperty schemaProperty = schemaType().getAttributeProperty(paramb);
/* 1046 */     if (schemaProperty == null)
/* 1047 */       return 0; 
/* 1048 */     return ((schemaProperty.hasDefault() == 0) ? 0 : 2) | ((schemaProperty.hasFixed() == 0) ? 0 : 4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean is_child_element_order_sensitive() {
/* 1061 */     if (!_isComplexType())
/* 1062 */       return false; 
/* 1063 */     return schemaType().isOrderSensitive();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final QNameSet get_element_ending_delimiters(b paramb) {
/* 1084 */     SchemaProperty schemaProperty = schemaType().getElementProperty(paramb);
/* 1085 */     if (schemaProperty == null)
/* 1086 */       return null; 
/* 1087 */     return schemaProperty.getJavaSetterDelimiter();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TypeStoreVisitor new_visitor() {
/* 1096 */     if (!_isComplexContent())
/* 1097 */       return null; 
/* 1098 */     return (TypeStoreVisitor)new SchemaTypeVisitorImpl(schemaType().getContentModel());
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaField get_attribute_field(b paramb) {
/* 1103 */     SchemaAttributeModel schemaAttributeModel = schemaType().getAttributeModel();
/* 1104 */     if (schemaAttributeModel == null)
/* 1105 */       return null; 
/* 1106 */     return (SchemaField)schemaAttributeModel.getAttribute(paramb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void set_String(String paramString) {
/* 1118 */     if ((this._flags & 0x1000) != 0) {
/* 1119 */       throw new IllegalStateException();
/*      */     }
/* 1121 */     boolean bool = ((this._flags & 0x40) != 0) ? true : false;
/*      */ 
/*      */     
/* 1124 */     String str = apply_wscanon(paramString);
/* 1125 */     update_from_wscanon_text(str);
/*      */ 
/*      */     
/* 1128 */     if ((this._flags & 0x10) != 0) {
/*      */       
/* 1130 */       this._flags &= 0xFFFFFFDF;
/* 1131 */       if ((this._flags & 0x400) == 0)
/* 1132 */         get_store().store_text(paramString); 
/* 1133 */       if (bool) {
/* 1134 */         get_store().invalidate_nil();
/*      */       }
/*      */     } else {
/* 1137 */       this._textsource = paramString;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void update_from_complex_content() {
/* 1145 */     throw new XmlValueNotSupportedException("Complex content");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final void update_from_wscanon_text(String paramString) {
/* 1158 */     if ((this._flags & 0x2) != 0 && (this._flags & 0x400) == 0)
/*      */     {
/*      */ 
/*      */       
/* 1162 */       if ((this._flags & 0x8) == 0 && paramString.equals("")) {
/*      */         
/* 1164 */         String str = get_store().compute_default_text();
/* 1165 */         if (str == null) {
/* 1166 */           throw new XmlValueOutOfRangeException();
/*      */         }
/*      */         
/* 1169 */         this._flags |= 0x400; 
/* 1170 */         try { setStringValue(str); }
/* 1171 */         finally { this._flags &= 0xFFFFFBFF; }
/* 1172 */          this._flags &= 0xFFFFFFBF;
/* 1173 */         this._flags |= 0x100;
/*      */ 
/*      */         
/*      */         return;
/*      */       } 
/*      */     }
/*      */     
/* 1180 */     set_text(paramString);
/* 1181 */     this._flags &= 0xFFFFFEBF;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean is_defaultable_ws(String paramString) {
/* 1190 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int get_wscanon_rule() {
/* 1204 */     return 3;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final String apply_wscanon(String paramString) {
/* 1217 */     return XmlWhitespace.collapse(paramString, get_wscanon_rule());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final void check_element_dated() {
/* 1227 */     if ((this._flags & 0x200) != 0 && (this._flags & 0x8000) == 0) {
/*      */ 
/*      */       
/* 1230 */       if ((this._flags & 0x800) != 0) {
/* 1231 */         throw new XmlValueDisconnectedException();
/*      */       }
/* 1233 */       int i = get_store().compute_flags();
/*      */       
/* 1235 */       this._flags &= 0xFFFFFDF8;
/* 1236 */       this._flags |= i;
/*      */     } 
/* 1238 */     if ((this._flags & 0x8000) != 0) {
/* 1239 */       this._flags &= 0xFFFFFDFF;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final boolean is_orphaned() {
/* 1247 */     return ((this._flags & 0x800) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void check_orphaned() {
/* 1257 */     if (is_orphaned()) {
/* 1258 */       throw new XmlValueDisconnectedException();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void check_dated() {
/* 1271 */     if ((this._flags & 0x2A0) != 0) {
/*      */       
/* 1273 */       if ((this._flags & 0x800) != 0) {
/* 1274 */         throw new XmlValueDisconnectedException();
/*      */       }
/* 1276 */       assert (this._flags & 0x10) != 0;
/*      */       
/* 1278 */       check_element_dated();
/*      */       
/* 1280 */       if ((this._flags & 0x200) != 0) {
/*      */         
/* 1282 */         int i = get_store().compute_flags();
/* 1283 */         this._flags &= 0xFFFFFDF8;
/* 1284 */         this._flags |= i;
/*      */       } 
/*      */       
/* 1287 */       boolean bool = false;
/*      */       
/* 1289 */       if ((this._flags & 0x80) != 0) {
/*      */         
/* 1291 */         if (get_store().find_nil()) {
/*      */           
/* 1293 */           if ((this._flags & 0x1) == 0 && (this._flags & 0x10000) != 0)
/*      */           {
/* 1295 */             throw new XmlValueOutOfRangeException();
/*      */           }
/*      */           
/* 1298 */           set_nil();
/*      */           
/* 1300 */           this._flags |= 0x40;
/* 1301 */           bool = true;
/*      */         }
/*      */         else {
/*      */           
/* 1305 */           this._flags &= 0xFFFFFFBF;
/*      */         } 
/* 1307 */         this._flags &= 0xFFFFFF7F;
/*      */       } 
/*      */       
/* 1310 */       if (!bool) {
/*      */         String str;
/*      */ 
/*      */         
/* 1314 */         if ((this._flags & 0x4000) != 0 || (str = get_wscanon_text()) == null) {
/* 1315 */           update_from_complex_content();
/*      */         } else {
/*      */           
/* 1318 */           NamespaceContext.push(new NamespaceContext(get_store())); 
/* 1319 */           try { update_from_wscanon_text(str); }
/* 1320 */           finally { NamespaceContext.pop(); }
/*      */         
/*      */         } 
/*      */       } 
/* 1324 */       this._flags &= 0xFFFFFFDF;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final void set_prepare() {
/* 1336 */     check_element_dated();
/* 1337 */     if ((this._flags & 0x1000) != 0) {
/* 1338 */       throw new IllegalStateException();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final void set_commit() {
/* 1350 */     boolean bool = ((this._flags & 0x40) != 0) ? true : false;
/* 1351 */     this._flags &= 0xFFFFFEBF;
/*      */     
/* 1353 */     if ((this._flags & 0x10) != 0) {
/*      */       
/* 1355 */       this._flags &= 0xFFFFFD5F;
/* 1356 */       get_store().invalidate_text();
/* 1357 */       if (bool) {
/* 1358 */         get_store().invalidate_nil();
/*      */       }
/*      */     } else {
/*      */       
/* 1362 */       this._textsource = null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String get_wscanon_text() {
/* 1373 */     if ((this._flags & 0x10) == 0)
/*      */     {
/* 1375 */       return apply_wscanon((String)this._textsource);
/*      */     }
/* 1377 */     return get_store().fetch_text(get_wscanon_rule());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float getFloatValue() {
/* 1402 */     BigDecimal bigDecimal = getBigDecimalValue(); return (bigDecimal == null) ? 0.0F : bigDecimal.floatValue();
/*      */   } public double getDoubleValue() {
/* 1404 */     BigDecimal bigDecimal = getBigDecimalValue(); return (bigDecimal == null) ? 0.0D : bigDecimal.doubleValue();
/*      */   } public BigDecimal getBigDecimalValue() {
/* 1406 */     throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[] { getPrimitiveTypeName(), "numeric" });
/*      */   }
/*      */ 
/*      */   
/*      */   public BigInteger getBigIntegerValue() {
/* 1411 */     BigDecimal bigDecimal = bigDecimalValue(); return (bigDecimal == null) ? null : bigDecimal.toBigInteger();
/*      */   }
/*      */   
/*      */   public byte getByteValue() {
/* 1415 */     long l = getIntValue();
/* 1416 */     if (l > 127L) throw new XmlValueOutOfRangeException(); 
/* 1417 */     if (l < -128L) throw new XmlValueOutOfRangeException(); 
/* 1418 */     return (byte)(int)l;
/*      */   }
/*      */ 
/*      */   
/*      */   public short getShortValue() {
/* 1423 */     long l = getIntValue();
/* 1424 */     if (l > 32767L) throw new XmlValueOutOfRangeException(); 
/* 1425 */     if (l < -32768L) throw new XmlValueOutOfRangeException(); 
/* 1426 */     return (short)(int)l;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getIntValue() {
/* 1431 */     long l = getLongValue();
/* 1432 */     if (l > 2147483647L) throw new XmlValueOutOfRangeException(); 
/* 1433 */     if (l < -2147483648L) throw new XmlValueOutOfRangeException(); 
/* 1434 */     return (int)l;
/*      */   }
/* 1436 */   private static final BigInteger _max = BigInteger.valueOf(Long.MAX_VALUE);
/* 1437 */   private static final BigInteger _min = BigInteger.valueOf(Long.MIN_VALUE);
/*      */ 
/*      */   
/*      */   public long getLongValue() {
/* 1441 */     BigInteger bigInteger = getBigIntegerValue();
/* 1442 */     if (bigInteger == null) return 0L; 
/* 1443 */     if (bigInteger.compareTo(_max) >= 0) throw new XmlValueOutOfRangeException(); 
/* 1444 */     if (bigInteger.compareTo(_min) <= 0) throw new XmlValueOutOfRangeException(); 
/* 1445 */     return bigInteger.longValue();
/*      */   }
/*      */   
/* 1448 */   private static final XmlOptions _toStringOptions = buildInnerPrettyOptions();
/*      */ 
/*      */ 
/*      */   
/*      */   static final XmlOptions buildInnerPrettyOptions() {
/* 1453 */     XmlOptions xmlOptions = new XmlOptions();
/* 1454 */     xmlOptions.put("SAVE_INNER");
/* 1455 */     xmlOptions.put("SAVE_PRETTY_PRINT");
/* 1456 */     xmlOptions.put("SAVE_AGGRESSIVE_NAMESPACES");
/* 1457 */     xmlOptions.put("SAVE_USE_DEFAULT_NAMESPACE");
/* 1458 */     return xmlOptions;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String toString() {
/* 1483 */     synchronized (monitor()) {
/*      */       
/* 1485 */       return ensureStore().xmlText(_toStringOptions);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public String xmlText() {
/* 1491 */     return xmlText(null);
/*      */   }
/*      */ 
/*      */   
/*      */   public String xmlText(XmlOptions paramXmlOptions) {
/* 1496 */     XmlCursor xmlCursor = newCursorForce();
/*      */ 
/*      */     
/*      */     try {
/* 1500 */       return xmlCursor.xmlText(makeInnerOptions(paramXmlOptions));
/*      */     }
/*      */     finally {
/*      */       
/* 1504 */       xmlCursor.dispose();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public StringEnumAbstractBase getEnumValue() {
/* 1510 */     throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[] { getPrimitiveTypeName(), "enum" });
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStringValue() {
/* 1516 */     if (isImmutable()) {
/*      */       
/* 1518 */       if ((this._flags & 0x40) != 0)
/* 1519 */         return null; 
/* 1520 */       return compute_text(null);
/*      */     } 
/*      */ 
/*      */     
/* 1524 */     synchronized (monitor()) {
/*      */       
/* 1526 */       if (_isComplexContent()) {
/* 1527 */         return get_store().fetch_text(1);
/*      */       }
/* 1529 */       check_dated();
/* 1530 */       if ((this._flags & 0x40) != 0)
/* 1531 */         return null; 
/* 1532 */       return compute_text(has_store() ? get_store() : null);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public String stringValue() {
/* 1538 */     return getStringValue();
/*      */   }
/*      */   public boolean booleanValue() {
/* 1541 */     return getBooleanValue();
/*      */   }
/*      */   public byte byteValue() {
/* 1544 */     return getByteValue();
/*      */   }
/*      */   public short shortValue() {
/* 1547 */     return getShortValue();
/*      */   }
/*      */   public int intValue() {
/* 1550 */     return getIntValue();
/*      */   }
/*      */   public long longValue() {
/* 1553 */     return getLongValue();
/*      */   }
/*      */   public BigInteger bigIntegerValue() {
/* 1556 */     return getBigIntegerValue();
/*      */   }
/*      */   public BigDecimal bigDecimalValue() {
/* 1559 */     return getBigDecimalValue();
/*      */   }
/*      */   public float floatValue() {
/* 1562 */     return getFloatValue();
/*      */   }
/*      */   public double doubleValue() {
/* 1565 */     return getDoubleValue();
/*      */   }
/*      */   public byte[] byteArrayValue() {
/* 1568 */     return getByteArrayValue();
/*      */   }
/*      */   public StringEnumAbstractBase enumValue() {
/* 1571 */     return getEnumValue();
/*      */   }
/*      */   public Calendar calendarValue() {
/* 1574 */     return getCalendarValue();
/*      */   }
/*      */   public Date dateValue() {
/* 1577 */     return getDateValue();
/*      */   }
/*      */   public GDate gDateValue() {
/* 1580 */     return getGDateValue();
/*      */   }
/*      */   public GDuration gDurationValue() {
/* 1583 */     return getGDurationValue();
/*      */   }
/*      */   public b qNameValue() {
/* 1586 */     return getQNameValue();
/*      */   }
/*      */   public List xlistValue() {
/* 1589 */     return xgetListValue();
/*      */   }
/*      */   public List listValue() {
/* 1592 */     return getListValue();
/*      */   }
/*      */   public Object objectValue() {
/* 1595 */     return getObjectValue();
/*      */   }
/*      */   
/*      */   public void set(String paramString) {
/* 1599 */     setStringValue(paramString);
/*      */   }
/*      */   public void set(boolean paramBoolean) {
/* 1602 */     setBooleanValue(paramBoolean);
/*      */   }
/*      */   public void set(byte paramByte) {
/* 1605 */     setByteValue(paramByte);
/*      */   }
/*      */   public void set(short paramShort) {
/* 1608 */     setShortValue(paramShort);
/*      */   }
/*      */   public void set(int paramInt) {
/* 1611 */     setIntValue(paramInt);
/*      */   }
/*      */   public void set(long paramLong) {
/* 1614 */     setLongValue(paramLong);
/*      */   }
/*      */   public void set(BigInteger paramBigInteger) {
/* 1617 */     setBigIntegerValue(paramBigInteger);
/*      */   }
/*      */   public void set(BigDecimal paramBigDecimal) {
/* 1620 */     setBigDecimalValue(paramBigDecimal);
/*      */   }
/*      */   public void set(float paramFloat) {
/* 1623 */     setFloatValue(paramFloat);
/*      */   }
/*      */   public void set(double paramDouble) {
/* 1626 */     setDoubleValue(paramDouble);
/*      */   }
/*      */   public void set(byte[] paramArrayOfbyte) {
/* 1629 */     setByteArrayValue(paramArrayOfbyte);
/*      */   }
/*      */   public void set(StringEnumAbstractBase paramStringEnumAbstractBase) {
/* 1632 */     setEnumValue(paramStringEnumAbstractBase);
/*      */   }
/*      */   public void set(Calendar paramCalendar) {
/* 1635 */     setCalendarValue(paramCalendar);
/*      */   }
/*      */   public void set(Date paramDate) {
/* 1638 */     setDateValue(paramDate);
/*      */   }
/*      */   public void set(GDateSpecification paramGDateSpecification) {
/* 1641 */     setGDateValue(paramGDateSpecification);
/*      */   }
/*      */   public void set(GDurationSpecification paramGDurationSpecification) {
/* 1644 */     setGDurationValue(paramGDurationSpecification);
/*      */   }
/*      */   public void set(b paramb) {
/* 1647 */     setQNameValue(paramb);
/*      */   }
/*      */   public void set(List paramList) {
/* 1650 */     setListValue(paramList);
/*      */   }
/*      */   public void objectSet(Object paramObject) {
/* 1653 */     setObjectValue(paramObject);
/*      */   }
/*      */   public byte[] getByteArrayValue() {
/* 1656 */     throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[] { getPrimitiveTypeName(), "byte[]" });
/*      */   }
/*      */   public boolean getBooleanValue() {
/* 1659 */     throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[] { getPrimitiveTypeName(), "boolean" });
/*      */   }
/*      */   public GDate getGDateValue() {
/* 1662 */     throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[] { getPrimitiveTypeName(), "Date" });
/*      */   }
/*      */   public Date getDateValue() {
/* 1665 */     throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[] { getPrimitiveTypeName(), "Date" });
/*      */   }
/*      */   public Calendar getCalendarValue() {
/* 1668 */     throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[] { getPrimitiveTypeName(), "Calendar" });
/*      */   }
/*      */   public GDuration getGDurationValue() {
/* 1671 */     throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[] { getPrimitiveTypeName(), "Duration" });
/*      */   }
/*      */   public b getQNameValue() {
/* 1674 */     throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[] { getPrimitiveTypeName(), "QName" });
/*      */   }
/*      */   public List getListValue() {
/* 1677 */     throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[] { getPrimitiveTypeName(), "List" });
/*      */   }
/*      */   public List xgetListValue() {
/* 1680 */     throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[] { getPrimitiveTypeName(), "List" });
/*      */   }
/*      */   public Object getObjectValue() {
/* 1683 */     return java_value(this);
/*      */   }
/*      */   
/*      */   public final void setBooleanValue(boolean paramBoolean) {
/* 1687 */     synchronized (monitor()) { set_prepare(); set_boolean(paramBoolean); set_commit(); }
/*      */   
/* 1689 */   } public final void setByteValue(byte paramByte) { synchronized (monitor()) { set_prepare(); set_byte(paramByte); set_commit(); }
/*      */      }
/* 1691 */   public final void setShortValue(short paramShort) { synchronized (monitor()) { set_prepare(); set_short(paramShort); set_commit(); }
/*      */      }
/* 1693 */   public final void setIntValue(int paramInt) { synchronized (monitor()) { set_prepare(); set_int(paramInt); set_commit(); }
/*      */      }
/* 1695 */   public final void setLongValue(long paramLong) { synchronized (monitor()) { set_prepare(); set_long(paramLong); set_commit(); }
/*      */      }
/* 1697 */   public final void setFloatValue(float paramFloat) { synchronized (monitor()) { set_prepare(); set_float(paramFloat); set_commit(); }
/*      */      }
/* 1699 */   public final void setDoubleValue(double paramDouble) { synchronized (monitor()) { set_prepare(); set_double(paramDouble); set_commit(); }
/*      */      }
/* 1701 */   public final void setByteArrayValue(byte[] paramArrayOfbyte) { if (paramArrayOfbyte == null) { setNil(); } else { synchronized (monitor()) { set_prepare(); set_ByteArray(paramArrayOfbyte); set_commit(); }
/*      */        }
/* 1703 */      } public final void setEnumValue(StringEnumAbstractBase paramStringEnumAbstractBase) { if (paramStringEnumAbstractBase == null) { setNil(); } else { synchronized (monitor()) { set_prepare(); set_enum(paramStringEnumAbstractBase); set_commit(); }
/*      */        }
/* 1705 */      } public final void setBigIntegerValue(BigInteger paramBigInteger) { if (paramBigInteger == null) { setNil(); } else { synchronized (monitor()) { set_prepare(); set_BigInteger(paramBigInteger); set_commit(); }
/*      */        }
/* 1707 */      } public final void setBigDecimalValue(BigDecimal paramBigDecimal) { if (paramBigDecimal == null) { setNil(); } else { synchronized (monitor()) { set_prepare(); set_BigDecimal(paramBigDecimal); set_commit(); }
/*      */        }
/* 1709 */      } public final void setCalendarValue(Calendar paramCalendar) { if (paramCalendar == null) { setNil(); } else { synchronized (monitor()) { set_prepare(); set_Calendar(paramCalendar); set_commit(); }
/*      */        }
/* 1711 */      } public final void setDateValue(Date paramDate) { if (paramDate == null) { setNil(); } else { synchronized (monitor()) { set_prepare(); set_Date(paramDate); set_commit(); }
/*      */        }
/* 1713 */      } public final void setGDateValue(GDate paramGDate) { if (paramGDate == null) { setNil(); } else { synchronized (monitor()) { set_prepare(); set_GDate((GDateSpecification)paramGDate); set_commit(); }
/*      */        }
/* 1715 */      } public final void setGDateValue(GDateSpecification paramGDateSpecification) { if (paramGDateSpecification == null) { setNil(); } else { synchronized (monitor()) { set_prepare(); set_GDate(paramGDateSpecification); set_commit(); }
/*      */        }
/* 1717 */      } public final void setGDurationValue(GDuration paramGDuration) { if (paramGDuration == null) { setNil(); } else { synchronized (monitor()) { set_prepare(); set_GDuration((GDurationSpecification)paramGDuration); set_commit(); }
/*      */        }
/* 1719 */      } public final void setGDurationValue(GDurationSpecification paramGDurationSpecification) { if (paramGDurationSpecification == null) { setNil(); } else { synchronized (monitor()) { set_prepare(); set_GDuration(paramGDurationSpecification); set_commit(); }
/*      */        }
/* 1721 */      } public final void setQNameValue(b paramb) { if (paramb == null) { setNil(); } else { synchronized (monitor()) { set_prepare(); set_QName(paramb); set_commit(); }
/*      */        }
/* 1723 */      } public final void setListValue(List paramList) { if (paramList == null) { setNil(); } else { synchronized (monitor()) { set_prepare(); set_list(paramList); set_commit(); }
/*      */        }
/* 1725 */      } public final void setStringValue(String paramString) { if (paramString == null) { setNil(); } else { synchronized (monitor()) { set_prepare(); set_String(paramString); }
/*      */        }
/*      */      }
/*      */    public void setObjectValue(Object paramObject) {
/* 1729 */     if (paramObject == null) {
/*      */       
/* 1731 */       setNil();
/*      */       
/*      */       return;
/*      */     } 
/* 1735 */     if (paramObject instanceof XmlObject) {
/* 1736 */       set((XmlObject)paramObject);
/* 1737 */     } else if (paramObject instanceof String) {
/* 1738 */       setStringValue((String)paramObject);
/* 1739 */     } else if (paramObject instanceof StringEnumAbstractBase) {
/* 1740 */       setEnumValue((StringEnumAbstractBase)paramObject);
/* 1741 */     } else if (paramObject instanceof BigInteger) {
/* 1742 */       setBigIntegerValue((BigInteger)paramObject);
/* 1743 */     } else if (paramObject instanceof BigDecimal) {
/* 1744 */       setBigDecimalValue((BigDecimal)paramObject);
/* 1745 */     } else if (paramObject instanceof Byte) {
/* 1746 */       setByteValue(((Byte)paramObject).byteValue());
/* 1747 */     } else if (paramObject instanceof Short) {
/* 1748 */       setShortValue(((Short)paramObject).shortValue());
/* 1749 */     } else if (paramObject instanceof Integer) {
/* 1750 */       setIntValue(((Integer)paramObject).intValue());
/* 1751 */     } else if (paramObject instanceof Long) {
/* 1752 */       setLongValue(((Long)paramObject).longValue());
/* 1753 */     } else if (paramObject instanceof Boolean) {
/* 1754 */       setBooleanValue(((Boolean)paramObject).booleanValue());
/* 1755 */     } else if (paramObject instanceof Float) {
/* 1756 */       setFloatValue(((Float)paramObject).floatValue());
/* 1757 */     } else if (paramObject instanceof Double) {
/* 1758 */       setDoubleValue(((Double)paramObject).doubleValue());
/* 1759 */     } else if (paramObject instanceof Calendar) {
/* 1760 */       setCalendarValue((Calendar)paramObject);
/* 1761 */     } else if (paramObject instanceof Date) {
/* 1762 */       setDateValue((Date)paramObject);
/* 1763 */     } else if (paramObject instanceof GDateSpecification) {
/* 1764 */       setGDateValue((GDateSpecification)paramObject);
/* 1765 */     } else if (paramObject instanceof GDurationSpecification) {
/* 1766 */       setGDurationValue((GDurationSpecification)paramObject);
/* 1767 */     } else if (paramObject instanceof b) {
/* 1768 */       setQNameValue((b)paramObject);
/* 1769 */     } else if (paramObject instanceof List) {
/* 1770 */       setListValue((List)paramObject);
/* 1771 */     } else if (paramObject instanceof byte[]) {
/* 1772 */       setByteArrayValue((byte[])paramObject);
/*      */     } else {
/*      */       
/* 1775 */       throw new XmlValueNotSupportedException("Can't set union object of class : " + paramObject.getClass().getName());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void set_newValue(XmlObject paramXmlObject) {
/* 1784 */     if (paramXmlObject == null || paramXmlObject.isNil()) {
/*      */       
/* 1786 */       setNil();
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 1791 */     if (paramXmlObject instanceof XmlAnySimpleType)
/*      */     
/* 1793 */     { XmlAnySimpleType xmlAnySimpleType = (XmlAnySimpleType)paramXmlObject;
/* 1794 */       SchemaType schemaType = ((SimpleValue)xmlAnySimpleType).instanceType();
/* 1795 */       assert schemaType != null : "Nil case should have been handled already";
/*      */ 
/*      */       
/* 1798 */       if (schemaType.getSimpleVariety() == 3)
/*      */       {
/* 1800 */         synchronized (monitor()) {
/*      */           
/* 1802 */           set_prepare();
/* 1803 */           set_list(((SimpleValue)xmlAnySimpleType).xgetListValue());
/* 1804 */           set_commit();
/*      */           
/*      */           return;
/*      */         } 
/*      */       }
/*      */       
/* 1810 */       synchronized (monitor())
/*      */       { boolean bool1; byte[] arrayOfByte; b b1; float f; double d; byte b; short s; int i; long l; BigInteger bigInteger; BigDecimal bigDecimal; String str2; GDuration gDuration; GDate gDate; String str1; boolean bool;
/* 1812 */         assert schemaType.getSimpleVariety() == 1;
/* 1813 */         switch (schemaType.getPrimitiveType().getBuiltinTypeCode())
/*      */         
/*      */         { default:
/* 1816 */             assert false : "encountered nonprimitive type.";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1986 */             throw new IllegalStateException("Complex type unexpected");case 3: bool1 = ((SimpleValue)xmlAnySimpleType).getBooleanValue(); set_prepare(); set_boolean(bool1); break;case 4: arrayOfByte = ((SimpleValue)xmlAnySimpleType).getByteArrayValue(); set_prepare(); set_b64(arrayOfByte); break;case 5: arrayOfByte = ((SimpleValue)xmlAnySimpleType).getByteArrayValue(); set_prepare(); set_hex(arrayOfByte); break;case 7: b1 = ((SimpleValue)xmlAnySimpleType).getQNameValue(); set_prepare(); set_QName(b1); break;case 9: f = ((SimpleValue)xmlAnySimpleType).getFloatValue(); set_prepare(); set_float(f); break;case 10: d = ((SimpleValue)xmlAnySimpleType).getDoubleValue(); set_prepare(); set_double(d); break;case 11: switch (schemaType.getDecimalSize()) { case 8: b = ((SimpleValue)xmlAnySimpleType).getByteValue(); set_prepare(); set_byte(b); break;case 16: s = ((SimpleValue)xmlAnySimpleType).getShortValue(); set_prepare(); set_short(s); break;case 32: i = ((SimpleValue)xmlAnySimpleType).getIntValue(); set_prepare(); set_int(i); break;case 64: l = ((SimpleValue)xmlAnySimpleType).getLongValue(); set_prepare(); set_long(l); break;case 1000000: bigInteger = ((SimpleValue)xmlAnySimpleType).getBigIntegerValue(); set_prepare(); set_BigInteger(bigInteger); break;default: assert false : "invalid numeric bit count"; break;case 1000001: break; }  bigDecimal = ((SimpleValue)xmlAnySimpleType).getBigDecimalValue(); set_prepare(); set_BigDecimal(bigDecimal); break;case 6: str2 = xmlAnySimpleType.getStringValue(); set_prepare(); set_text(str2); break;case 8: str2 = xmlAnySimpleType.getStringValue(); set_prepare(); set_notation(str2); break;case 13: gDuration = ((SimpleValue)xmlAnySimpleType).getGDurationValue(); set_prepare(); set_GDuration((GDurationSpecification)gDuration); break;case 14: case 15: case 16: case 17: case 18: case 19: case 20: case 21: gDate = ((SimpleValue)xmlAnySimpleType).getGDateValue(); set_prepare(); set_GDate((GDateSpecification)gDate); break;case 12: str1 = xmlAnySimpleType.getStringValue(); set_prepare(); set_String(str1); break;case 2: bool = false; if (!xmlAnySimpleType.isImmutable()) { bool = true; NamespaceContext.push(new NamespaceContext((XmlObject)xmlAnySimpleType)); }  try { set_prepare(); set_xmlanysimple(xmlAnySimpleType); } finally { if (bool) NamespaceContext.pop();  }  break; }  set_commit(); return; }  }  throw new IllegalStateException("Complex type unexpected");
/*      */   }
/*      */ 
/*      */   
/*      */   private TypeStoreUser setterHelper(XmlObjectBase paramXmlObjectBase) {
/* 1991 */     check_orphaned();
/*      */     
/* 1993 */     paramXmlObjectBase.check_orphaned();
/*      */     
/* 1995 */     return get_store().copy_contents_from(paramXmlObjectBase.get_store()).get_store().change_type(paramXmlObjectBase.schemaType());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final XmlObject set(XmlObject paramXmlObject) {
/* 2002 */     if (isImmutable()) {
/* 2003 */       throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
/*      */     }
/* 2005 */     XmlObjectBase xmlObjectBase = underlying(paramXmlObject);
/*      */     
/* 2007 */     TypeStoreUser typeStoreUser = this;
/*      */     
/* 2009 */     if (xmlObjectBase == null) {
/*      */       
/* 2011 */       setNil();
/* 2012 */       return this;
/*      */     } 
/*      */     
/* 2015 */     if (xmlObjectBase.isImmutable()) {
/* 2016 */       setStringValue(xmlObjectBase.getStringValue());
/*      */     } else {
/*      */       
/* 2019 */       boolean bool1 = preCheck();
/* 2020 */       boolean bool2 = xmlObjectBase.preCheck();
/*      */       
/* 2022 */       if (monitor() == xmlObjectBase.monitor()) {
/*      */         
/* 2024 */         if (bool1) {
/* 2025 */           TypeStoreUser typeStoreUser1 = setterHelper(xmlObjectBase);
/*      */         } else {
/*      */           
/* 2028 */           synchronized (monitor()) {
/* 2029 */             TypeStoreUser typeStoreUser1 = setterHelper(xmlObjectBase);
/*      */           }
/*      */         
/*      */         }
/*      */       
/*      */       }
/* 2035 */       else if (bool1) {
/*      */         
/* 2037 */         if (bool2)
/*      */         {
/* 2039 */           TypeStoreUser typeStoreUser1 = setterHelper(xmlObjectBase);
/*      */         }
/*      */         else
/*      */         {
/* 2043 */           synchronized (xmlObjectBase.monitor()) {
/* 2044 */             TypeStoreUser typeStoreUser1 = setterHelper(xmlObjectBase);
/*      */           }
/*      */         
/*      */         }
/*      */       
/*      */       }
/* 2050 */       else if (bool2) {
/*      */         
/* 2052 */         synchronized (monitor()) {
/* 2053 */           TypeStoreUser typeStoreUser1 = setterHelper(xmlObjectBase);
/*      */         }
/*      */       
/*      */       } else {
/*      */         
/* 2058 */         boolean bool = false;
/*      */ 
/*      */ 
/*      */         
/*      */         try {
/* 2063 */           GlobalLock.acquire();
/* 2064 */           bool = true;
/*      */           
/* 2066 */           synchronized (monitor()) {
/*      */             
/* 2068 */             synchronized (xmlObjectBase.monitor())
/*      */             {
/* 2070 */               GlobalLock.release();
/* 2071 */               bool = false;
/*      */               
/* 2073 */               typeStoreUser = setterHelper(xmlObjectBase);
/*      */             }
/*      */           
/*      */           } 
/* 2077 */         } catch (InterruptedException interruptedException) {
/*      */           
/* 2079 */           throw new XmlRuntimeException(interruptedException);
/*      */         }
/*      */         finally {
/*      */           
/* 2083 */           if (bool) {
/* 2084 */             GlobalLock.release();
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 2091 */     return (XmlObject)typeStoreUser;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final XmlObject generatedSetterHelperImpl(XmlObject paramXmlObject, b paramb, int paramInt, short paramShort) {
/* 2098 */     XmlObjectBase xmlObjectBase = underlying(paramXmlObject);
/*      */     
/* 2100 */     if (xmlObjectBase == null)
/*      */     {
/* 2102 */       synchronized (monitor()) {
/*      */         
/* 2104 */         XmlObjectBase xmlObjectBase1 = getTargetForSetter(paramb, paramInt, paramShort);
/* 2105 */         xmlObjectBase1.setNil();
/* 2106 */         return xmlObjectBase1;
/*      */       } 
/*      */     }
/*      */     
/* 2110 */     if (xmlObjectBase.isImmutable())
/*      */     {
/* 2112 */       synchronized (monitor()) {
/*      */         
/* 2114 */         XmlObjectBase xmlObjectBase1 = getTargetForSetter(paramb, paramInt, paramShort);
/* 2115 */         xmlObjectBase1.setStringValue(xmlObjectBase.getStringValue());
/* 2116 */         return xmlObjectBase1;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/* 2121 */     boolean bool1 = preCheck();
/* 2122 */     boolean bool2 = xmlObjectBase.preCheck();
/*      */     
/* 2124 */     if (monitor() == xmlObjectBase.monitor()) {
/*      */       
/* 2126 */       if (bool1)
/*      */       {
/* 2128 */         return (XmlObject)objSetterHelper(xmlObjectBase, paramb, paramInt, paramShort);
/*      */       }
/*      */ 
/*      */       
/* 2132 */       synchronized (monitor()) {
/*      */         
/* 2134 */         return (XmlObject)objSetterHelper(xmlObjectBase, paramb, paramInt, paramShort);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2140 */     if (bool1) {
/*      */       
/* 2142 */       if (bool2)
/*      */       {
/* 2144 */         return (XmlObject)objSetterHelper(xmlObjectBase, paramb, paramInt, paramShort);
/*      */       }
/*      */ 
/*      */       
/* 2148 */       synchronized (xmlObjectBase.monitor()) {
/*      */         
/* 2150 */         return (XmlObject)objSetterHelper(xmlObjectBase, paramb, paramInt, paramShort);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2156 */     if (bool2)
/*      */     {
/* 2158 */       synchronized (monitor()) {
/*      */         
/* 2160 */         return (XmlObject)objSetterHelper(xmlObjectBase, paramb, paramInt, paramShort);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/* 2165 */     boolean bool = false;
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/* 2170 */       GlobalLock.acquire();
/* 2171 */       bool = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/* 2184 */     catch (InterruptedException interruptedException) {
/*      */       
/* 2186 */       throw new XmlRuntimeException(interruptedException);
/*      */     }
/*      */     finally {
/*      */       
/* 2190 */       if (bool) {
/* 2191 */         GlobalLock.release();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private TypeStoreUser objSetterHelper(XmlObjectBase paramXmlObjectBase, b paramb, int paramInt, short paramShort) {
/* 2199 */     XmlObjectBase xmlObjectBase = getTargetForSetter(paramb, paramInt, paramShort);
/*      */     
/* 2201 */     xmlObjectBase.check_orphaned();
/* 2202 */     paramXmlObjectBase.check_orphaned();
/*      */     
/* 2204 */     return xmlObjectBase.get_store().copy_contents_from(paramXmlObjectBase.get_store()).get_store().change_type(paramXmlObjectBase.schemaType());
/*      */   }
/*      */ 
/*      */   
/*      */   private XmlObjectBase getTargetForSetter(b paramb, int paramInt, short paramShort) {
/*      */     XmlObjectBase xmlObjectBase;
/* 2210 */     switch (paramShort) {
/*      */ 
/*      */       
/*      */       case 1:
/* 2214 */         check_orphaned();
/* 2215 */         xmlObjectBase = null;
/* 2216 */         xmlObjectBase = (XmlObjectBase)get_store().find_element_user(paramb, paramInt);
/* 2217 */         if (xmlObjectBase == null)
/*      */         {
/* 2219 */           xmlObjectBase = (XmlObjectBase)get_store().add_element_user(paramb);
/*      */         }
/*      */         
/* 2222 */         if (xmlObjectBase.isImmutable()) {
/* 2223 */           throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
/*      */         }
/* 2225 */         return xmlObjectBase;
/*      */ 
/*      */ 
/*      */       
/*      */       case 2:
/* 2230 */         check_orphaned();
/* 2231 */         xmlObjectBase = null;
/* 2232 */         xmlObjectBase = (XmlObjectBase)get_store().find_element_user(paramb, paramInt);
/* 2233 */         if (xmlObjectBase == null)
/*      */         {
/* 2235 */           throw new IndexOutOfBoundsException();
/*      */         }
/*      */         
/* 2238 */         if (xmlObjectBase.isImmutable()) {
/* 2239 */           throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
/*      */         }
/* 2241 */         return xmlObjectBase;
/*      */     } 
/*      */ 
/*      */     
/* 2245 */     throw new IllegalArgumentException("Unknown kindSetterHelper: " + paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final XmlObject _set(XmlObject paramXmlObject) {
/* 2255 */     if (isImmutable()) {
/* 2256 */       throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
/*      */     }
/* 2258 */     XmlObjectBase xmlObjectBase = underlying(paramXmlObject);
/*      */     
/* 2260 */     TypeStoreUser typeStoreUser = this;
/*      */     
/* 2262 */     if (xmlObjectBase == null) {
/*      */       
/* 2264 */       setNil();
/* 2265 */       return this;
/*      */     } 
/*      */     
/* 2268 */     if (xmlObjectBase.isImmutable()) {
/* 2269 */       set(xmlObjectBase.stringValue());
/*      */     } else {
/*      */       
/* 2272 */       check_orphaned();
/* 2273 */       xmlObjectBase.check_orphaned();
/*      */       
/* 2275 */       typeStoreUser = get_store().copy_contents_from(xmlObjectBase.get_store()).get_store().change_type(xmlObjectBase.schemaType());
/*      */     } 
/*      */     
/* 2278 */     return (XmlObject)typeStoreUser;
/*      */   }
/*      */   
/*      */   protected void set_list(List paramList) {
/* 2282 */     throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[] { "List", getPrimitiveTypeName() });
/*      */   }
/*      */   protected void set_boolean(boolean paramBoolean) {
/* 2285 */     throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[] { "boolean", getPrimitiveTypeName() });
/*      */   }
/*      */   protected void set_byte(byte paramByte) {
/* 2288 */     set_int(paramByte);
/*      */   } protected void set_short(short paramShort) {
/* 2290 */     set_int(paramShort);
/*      */   } protected void set_int(int paramInt) {
/* 2292 */     set_long(paramInt);
/*      */   } protected void set_long(long paramLong) {
/* 2294 */     set_BigInteger(BigInteger.valueOf(paramLong));
/*      */   } protected void set_char(char paramChar) {
/* 2296 */     set_String(Character.toString(paramChar));
/*      */   } protected void set_float(float paramFloat) {
/* 2298 */     set_BigDecimal(new BigDecimal(paramFloat));
/*      */   } protected void set_double(double paramDouble) {
/* 2300 */     set_BigDecimal(new BigDecimal(paramDouble));
/*      */   }
/*      */   protected void set_enum(StringEnumAbstractBase paramStringEnumAbstractBase) {
/* 2303 */     throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[] { "enum", getPrimitiveTypeName() });
/*      */   }
/*      */   
/*      */   protected void set_ByteArray(byte[] paramArrayOfbyte) {
/* 2307 */     throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[] { "byte[]", getPrimitiveTypeName() });
/*      */   }
/*      */   protected void set_b64(byte[] paramArrayOfbyte) {
/* 2310 */     set_ByteArray(paramArrayOfbyte);
/*      */   } protected void set_hex(byte[] paramArrayOfbyte) {
/* 2312 */     set_ByteArray(paramArrayOfbyte);
/*      */   } protected void set_BigInteger(BigInteger paramBigInteger) {
/* 2314 */     set_BigDecimal(new BigDecimal(paramBigInteger));
/*      */   } protected void set_BigDecimal(BigDecimal paramBigDecimal) {
/* 2316 */     throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[] { "numeric", getPrimitiveTypeName() });
/*      */   }
/*      */   protected void set_Date(Date paramDate) {
/* 2319 */     throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[] { "Date", getPrimitiveTypeName() });
/*      */   }
/*      */   protected void set_Calendar(Calendar paramCalendar) {
/* 2322 */     throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[] { "Calendar", getPrimitiveTypeName() });
/*      */   }
/*      */   protected void set_GDate(GDateSpecification paramGDateSpecification) {
/* 2325 */     throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[] { "Date", getPrimitiveTypeName() });
/*      */   }
/*      */   protected void set_GDuration(GDurationSpecification paramGDurationSpecification) {
/* 2328 */     throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[] { "Duration", getPrimitiveTypeName() });
/*      */   }
/*      */   protected void set_ComplexXml(XmlObject paramXmlObject) {
/* 2331 */     throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[] { "complex content", getPrimitiveTypeName() });
/*      */   }
/*      */   protected void set_QName(b paramb) {
/* 2334 */     throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[] { "QName", getPrimitiveTypeName() });
/*      */   }
/*      */   
/*      */   protected void set_notation(String paramString) {
/* 2338 */     throw new XmlValueNotSupportedException();
/*      */   }
/*      */   protected void set_xmlanysimple(XmlAnySimpleType paramXmlAnySimpleType) {
/* 2341 */     set_String(paramXmlAnySimpleType.getStringValue());
/*      */   }
/*      */   
/*      */   private final String getPrimitiveTypeName() {
/* 2345 */     SchemaType schemaType1 = schemaType();
/* 2346 */     if (schemaType1.isNoType())
/* 2347 */       return "unknown"; 
/* 2348 */     SchemaType schemaType2 = schemaType1.getPrimitiveType();
/* 2349 */     if (schemaType2 == null) {
/* 2350 */       return "complex";
/*      */     }
/* 2352 */     return schemaType2.getName().dT();
/*      */   }
/*      */ 
/*      */   
/*      */   private final boolean comparable_value_spaces(SchemaType paramSchemaType1, SchemaType paramSchemaType2) {
/* 2357 */     assert paramSchemaType1.getSimpleVariety() != 2 && paramSchemaType2.getSimpleVariety() != 2;
/*      */     
/* 2359 */     if (!paramSchemaType1.isSimpleType() && !paramSchemaType2.isSimpleType()) {
/* 2360 */       return (paramSchemaType1.getContentType() == paramSchemaType2.getContentType());
/*      */     }
/* 2362 */     if (!paramSchemaType1.isSimpleType() || !paramSchemaType2.isSimpleType()) {
/* 2363 */       return false;
/*      */     }
/* 2365 */     if (paramSchemaType1.getSimpleVariety() == 3 && paramSchemaType2.getSimpleVariety() == 3) {
/* 2366 */       return true;
/*      */     }
/* 2368 */     if (paramSchemaType1.getSimpleVariety() == 3 || paramSchemaType2.getSimpleVariety() == 3) {
/* 2369 */       return false;
/*      */     }
/* 2371 */     return paramSchemaType1.getPrimitiveType().equals(paramSchemaType2.getPrimitiveType());
/*      */   }
/*      */ 
/*      */   
/*      */   private final boolean valueEqualsImpl(XmlObject paramXmlObject) {
/* 2376 */     check_dated();
/*      */     
/* 2378 */     SchemaType schemaType1 = instanceType();
/* 2379 */     SchemaType schemaType2 = ((SimpleValue)paramXmlObject).instanceType();
/*      */     
/* 2381 */     if (schemaType1 == null && schemaType2 == null) {
/* 2382 */       return true;
/*      */     }
/* 2384 */     if (schemaType1 == null || schemaType2 == null) {
/* 2385 */       return false;
/*      */     }
/* 2387 */     if (!comparable_value_spaces(schemaType1, schemaType2)) {
/* 2388 */       return false;
/*      */     }
/* 2390 */     if (paramXmlObject.schemaType().getSimpleVariety() == 2) {
/* 2391 */       return underlying(paramXmlObject).equal_to(this);
/*      */     }
/* 2393 */     return equal_to(paramXmlObject);
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean valueEquals(XmlObject paramXmlObject) {
/* 2398 */     boolean bool = false;
/*      */     
/*      */     try {
/* 2401 */       if (isImmutable()) {
/*      */         
/* 2403 */         if (paramXmlObject.isImmutable())
/*      */         {
/* 2405 */           return valueEqualsImpl(paramXmlObject);
/*      */         }
/*      */ 
/*      */         
/* 2409 */         synchronized (paramXmlObject.monitor()) {
/*      */           
/* 2411 */           return valueEqualsImpl(paramXmlObject);
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 2417 */       if (paramXmlObject.isImmutable() || monitor() == paramXmlObject.monitor())
/*      */       {
/* 2419 */         synchronized (monitor()) {
/*      */           
/* 2421 */           return valueEqualsImpl(paramXmlObject);
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 2426 */       GlobalLock.acquire();
/* 2427 */       bool = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/* 2441 */     catch (InterruptedException interruptedException) {
/*      */       
/* 2443 */       throw new XmlRuntimeException(interruptedException);
/*      */     }
/*      */     finally {
/*      */       
/* 2447 */       if (bool) {
/* 2448 */         GlobalLock.release();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int compareTo(Object paramObject) {
/* 2458 */     int i = compareValue((XmlObject)paramObject);
/* 2459 */     if (i == 2)
/* 2460 */       throw new ClassCastException(); 
/* 2461 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final int compareValueImpl(XmlObject paramXmlObject) {
/*      */     try {
/* 2473 */       schemaType1 = instanceType();
/* 2474 */       schemaType2 = ((SimpleValue)paramXmlObject).instanceType();
/*      */     }
/* 2476 */     catch (XmlValueOutOfRangeException xmlValueOutOfRangeException) {
/*      */       
/* 2478 */       return 2;
/*      */     } 
/*      */     
/* 2481 */     if (schemaType1 == null && schemaType2 == null)
/* 2482 */       return 0; 
/* 2483 */     if (schemaType1 == null || schemaType2 == null) {
/* 2484 */       return 2;
/*      */     }
/* 2486 */     if (!schemaType1.isSimpleType() || schemaType1.isURType()) {
/* 2487 */       return 2;
/*      */     }
/* 2489 */     if (!schemaType2.isSimpleType() || schemaType2.isURType()) {
/* 2490 */       return 2;
/*      */     }
/* 2492 */     SchemaType schemaType1 = schemaType1.getPrimitiveType();
/* 2493 */     SchemaType schemaType2 = schemaType2.getPrimitiveType();
/*      */ 
/*      */     
/* 2496 */     if (schemaType1.getBuiltinTypeCode() != schemaType2.getBuiltinTypeCode()) {
/* 2497 */       return 2;
/*      */     }
/*      */     
/* 2500 */     return compare_to(paramXmlObject);
/*      */   }
/*      */ 
/*      */   
/*      */   public final int compareValue(XmlObject paramXmlObject) {
/* 2505 */     if (paramXmlObject == null) {
/* 2506 */       return 2;
/*      */     }
/* 2508 */     boolean bool = false;
/*      */     
/*      */     try {
/* 2511 */       if (isImmutable()) {
/*      */         
/* 2513 */         if (paramXmlObject.isImmutable())
/*      */         {
/* 2515 */           return compareValueImpl(paramXmlObject);
/*      */         }
/*      */ 
/*      */         
/* 2519 */         synchronized (paramXmlObject.monitor()) {
/*      */           
/* 2521 */           return compareValueImpl(paramXmlObject);
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 2527 */       if (paramXmlObject.isImmutable() || monitor() == paramXmlObject.monitor())
/*      */       {
/* 2529 */         synchronized (monitor()) {
/*      */           
/* 2531 */           return compareValueImpl(paramXmlObject);
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 2536 */       GlobalLock.acquire();
/* 2537 */       bool = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/* 2551 */     catch (InterruptedException interruptedException) {
/*      */       
/* 2553 */       throw new XmlRuntimeException(interruptedException);
/*      */     }
/*      */     finally {
/*      */       
/* 2557 */       if (bool) {
/* 2558 */         GlobalLock.release();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int compare_to(XmlObject paramXmlObject) {
/* 2572 */     if (equal_to(paramXmlObject))
/* 2573 */       return 0; 
/* 2574 */     return 2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int valueHashCode() {
/* 2583 */     synchronized (monitor()) {
/*      */       
/* 2585 */       return value_hash_code();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isInstanceOf(SchemaType paramSchemaType) {
/* 2594 */     if (paramSchemaType.getSimpleVariety() != 2) {
/*      */       
/* 2596 */       for (SchemaType schemaType1 = instanceType(); schemaType1 != null; schemaType1 = schemaType1.getBaseType()) {
/* 2597 */         if (paramSchemaType == schemaType1)
/* 2598 */           return true; 
/* 2599 */       }  return false;
/*      */     } 
/*      */ 
/*      */     
/* 2603 */     HashSet hashSet = new HashSet(Arrays.asList((Object[])paramSchemaType.getUnionConstituentTypes()));
/* 2604 */     for (SchemaType schemaType = instanceType(); schemaType != null; schemaType = schemaType.getBaseType()) {
/* 2605 */       if (hashSet.contains(schemaType))
/* 2606 */         return true; 
/* 2607 */     }  return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean equals(Object paramObject) {
/* 2613 */     if (!isImmutable()) {
/* 2614 */       return super.equals(paramObject);
/*      */     }
/* 2616 */     if (!(paramObject instanceof XmlObject)) {
/* 2617 */       return false;
/*      */     }
/* 2619 */     XmlObject xmlObject = (XmlObject)paramObject;
/* 2620 */     if (!xmlObject.isImmutable()) {
/* 2621 */       return false;
/*      */     }
/* 2623 */     return valueEquals(xmlObject);
/*      */   }
/*      */ 
/*      */   
/*      */   public final int hashCode() {
/* 2628 */     if (!isImmutable()) {
/* 2629 */       return super.hashCode();
/*      */     }
/* 2631 */     synchronized (monitor()) {
/*      */       
/* 2633 */       if (isNil()) {
/* 2634 */         return 0;
/*      */       }
/* 2636 */       return value_hash_code();
/*      */     } 
/*      */   }
/*      */   
/* 2640 */   private static final XmlObject[] EMPTY_RESULT = new XmlObject[0];
/*      */ 
/*      */   
/*      */   static final boolean $assertionsDisabled;
/*      */ 
/*      */   
/*      */   public XmlObject[] selectChildren(b paramb) {
/* 2647 */     XmlCursor xmlCursor = newCursor();
/*      */     
/*      */     try {
/* 2650 */       if (!xmlCursor.isContainer()) {
/* 2651 */         return EMPTY_RESULT;
/*      */       }
/* 2653 */       ArrayList arrayList = new ArrayList();
/*      */       
/* 2655 */       if (xmlCursor.toChild(paramb)) {
/*      */         do
/*      */         {
/*      */ 
/*      */           
/* 2660 */           arrayList.add(xmlCursor.getObject());
/*      */         }
/* 2662 */         while (xmlCursor.toNextSibling(paramb));
/*      */       }
/* 2664 */       if (arrayList.size() == 0) {
/* 2665 */         return EMPTY_RESULT;
/*      */       }
/* 2667 */       return arrayList.<XmlObject>toArray(EMPTY_RESULT);
/*      */     }
/*      */     finally {
/*      */       
/* 2671 */       xmlCursor.dispose();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlObject[] selectChildren(String paramString1, String paramString2) {
/* 2680 */     return selectChildren(new b(paramString1, paramString2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlObject[] selectChildren(QNameSet paramQNameSet) {
/* 2688 */     if (paramQNameSet == null) {
/* 2689 */       throw new IllegalArgumentException();
/*      */     }
/* 2691 */     XmlCursor xmlCursor = newCursor();
/*      */     
/*      */     try {
/* 2694 */       if (!xmlCursor.isContainer()) {
/* 2695 */         return EMPTY_RESULT;
/*      */       }
/* 2697 */       ArrayList arrayList = new ArrayList();
/*      */       
/* 2699 */       if (xmlCursor.toFirstChild()) {
/*      */         do
/*      */         {
/*      */ 
/*      */           
/* 2704 */           assert xmlCursor.isContainer();
/* 2705 */           if (!paramQNameSet.contains(xmlCursor.getName()))
/*      */             continue; 
/* 2707 */           arrayList.add(xmlCursor.getObject());
/*      */         
/*      */         }
/* 2710 */         while (xmlCursor.toNextSibling());
/*      */       }
/* 2712 */       if (arrayList.size() == 0) {
/* 2713 */         return EMPTY_RESULT;
/*      */       }
/* 2715 */       return arrayList.<XmlObject>toArray(EMPTY_RESULT);
/*      */     }
/*      */     finally {
/*      */       
/* 2719 */       xmlCursor.dispose();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlObject selectAttribute(b paramb) {
/* 2728 */     XmlCursor xmlCursor = newCursor();
/*      */ 
/*      */     
/*      */     try {
/* 2732 */       if (!xmlCursor.isContainer()) {
/* 2733 */         return null;
/*      */       }
/* 2735 */       if (xmlCursor.toFirstAttribute()) {
/*      */         do
/*      */         {
/*      */ 
/*      */           
/* 2740 */           if (xmlCursor.getName().equals(paramb))
/*      */           {
/* 2742 */             return xmlCursor.getObject();
/*      */           }
/*      */         }
/* 2745 */         while (xmlCursor.toNextAttribute());
/*      */       }
/* 2747 */       return null;
/*      */     }
/*      */     finally {
/*      */       
/* 2751 */       xmlCursor.dispose();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlObject selectAttribute(String paramString1, String paramString2) {
/* 2760 */     return selectAttribute(new b(paramString1, paramString2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlObject[] selectAttributes(QNameSet paramQNameSet) {
/* 2768 */     if (paramQNameSet == null) {
/* 2769 */       throw new IllegalArgumentException();
/*      */     }
/* 2771 */     XmlCursor xmlCursor = newCursor();
/*      */     
/*      */     try {
/* 2774 */       if (!xmlCursor.isContainer()) {
/* 2775 */         return EMPTY_RESULT;
/*      */       }
/* 2777 */       ArrayList arrayList = new ArrayList();
/*      */       
/* 2779 */       if (xmlCursor.toFirstAttribute()) {
/*      */         do
/*      */         {
/*      */ 
/*      */           
/* 2784 */           if (!paramQNameSet.contains(xmlCursor.getName()))
/*      */             continue; 
/* 2786 */           arrayList.add(xmlCursor.getObject());
/*      */         
/*      */         }
/* 2789 */         while (xmlCursor.toNextAttribute());
/*      */       }
/*      */       
/* 2792 */       if (arrayList.size() == 0) {
/* 2793 */         return EMPTY_RESULT;
/*      */       }
/* 2795 */       return arrayList.<XmlObject>toArray(EMPTY_RESULT);
/*      */     }
/*      */     finally {
/*      */       
/* 2799 */       xmlCursor.dispose();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object writeReplace() {
/* 2824 */     synchronized (monitor()) {
/*      */       
/* 2826 */       if (isRootXmlObject()) {
/* 2827 */         return new SerializedRootObject(this);
/*      */       }
/* 2829 */       return new SerializedInteriorObject(this, getRootXmlObject());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isRootXmlObject() {
/* 2838 */     XmlCursor xmlCursor = newCursor();
/* 2839 */     if (xmlCursor == null) {
/* 2840 */       return false;
/*      */     }
/* 2842 */     boolean bool = !xmlCursor.toParent() ? true : false;
/* 2843 */     xmlCursor.dispose();
/* 2844 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private XmlObject getRootXmlObject() {
/* 2852 */     XmlCursor xmlCursor = newCursor();
/* 2853 */     if (xmlCursor == null)
/* 2854 */       return this; 
/* 2855 */     xmlCursor.toStartDoc();
/* 2856 */     XmlObject xmlObject = xmlCursor.getObject();
/* 2857 */     xmlCursor.dispose();
/* 2858 */     return xmlObject;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static class SerializedRootObject
/*      */     implements Serializable
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */     
/*      */     transient Class _xbeanClass;
/*      */ 
/*      */     
/*      */     transient XmlObject _impl;
/*      */ 
/*      */     
/*      */     private SerializedRootObject() {}
/*      */ 
/*      */     
/*      */     private SerializedRootObject(XmlObject param1XmlObject) {
/* 2879 */       this._xbeanClass = param1XmlObject.schemaType().getJavaClass();
/* 2880 */       this._impl = param1XmlObject;
/*      */     }
/*      */ 
/*      */     
/*      */     private void writeObject(ObjectOutputStream param1ObjectOutputStream) throws IOException {
/* 2885 */       param1ObjectOutputStream.writeObject(this._xbeanClass);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2890 */       param1ObjectOutputStream.writeShort(0);
/* 2891 */       param1ObjectOutputStream.writeShort(1);
/* 2892 */       param1ObjectOutputStream.writeShort(1);
/*      */ 
/*      */ 
/*      */       
/* 2896 */       String str = this._impl.xmlText();
/* 2897 */       param1ObjectOutputStream.writeObject(str);
/* 2898 */       param1ObjectOutputStream.writeBoolean(false);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void readObject(ObjectInputStream param1ObjectInputStream) throws IOException {
/*      */       try {
/* 2909 */         this._xbeanClass = (Class)param1ObjectInputStream.readObject();
/*      */         
/* 2911 */         int i = param1ObjectInputStream.readUnsignedShort();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2917 */         int j = 0;
/* 2918 */         int k = 0;
/* 2919 */         if (i == 0) {
/*      */           
/* 2921 */           j = param1ObjectInputStream.readUnsignedShort();
/* 2922 */           k = param1ObjectInputStream.readUnsignedShort();
/*      */         } 
/*      */         
/* 2925 */         String str = null;
/* 2926 */         switch (j) {
/*      */ 
/*      */           
/*      */           case 0:
/* 2930 */             str = readObjectV0(param1ObjectInputStream, i);
/* 2931 */             param1ObjectInputStream.readBoolean();
/*      */             break;
/*      */           
/*      */           case 1:
/* 2935 */             switch (k) {
/*      */               
/*      */               case 1:
/* 2938 */                 str = (String)param1ObjectInputStream.readObject();
/* 2939 */                 param1ObjectInputStream.readBoolean();
/*      */                 break;
/*      */             } 
/*      */             
/* 2943 */             throw new IOException("Deserialization error: version number " + j + "." + k + " not supported.");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           default:
/* 2950 */             throw new IOException("Deserialization error: version number " + j + "." + k + " not supported.");
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/* 2955 */         XmlOptions xmlOptions = (new XmlOptions()).setDocumentType(XmlBeans.typeForClass(this._xbeanClass));
/* 2956 */         this._impl = XmlBeans.getContextTypeLoader().parse(str, null, xmlOptions);
/*      */       }
/* 2958 */       catch (Exception exception) {
/*      */         
/* 2960 */         throw (IOException)(new IOException(exception.getMessage())).initCause(exception);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private String readObjectV0(ObjectInputStream param1ObjectInputStream, int param1Int) throws IOException {
/* 2982 */       byte[] arrayOfByte = new byte[param1Int + 2];
/*      */ 
/*      */ 
/*      */       
/* 2986 */       arrayOfByte[0] = (byte)(0xFF & param1Int >> 8);
/* 2987 */       arrayOfByte[1] = (byte)(0xFF & param1Int);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2992 */       int i = 0;
/*      */       
/* 2994 */       while (i < param1Int) {
/*      */         
/* 2996 */         int j = param1ObjectInputStream.read(arrayOfByte, 2 + i, param1Int - i);
/*      */         
/* 2998 */         if (j == -1) {
/*      */           break;
/*      */         }
/* 3001 */         i += j;
/*      */       } 
/*      */       
/* 3004 */       if (i != param1Int)
/*      */       {
/* 3006 */         throw new IOException("Error reading backwards compatible XmlObject: number of bytes read (" + i + ") != number expected (" + param1Int + ")");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3014 */       DataInputStream dataInputStream = null;
/* 3015 */       String str = null;
/*      */       
/*      */       try {
/* 3018 */         dataInputStream = new DataInputStream(new ByteArrayInputStream(arrayOfByte));
/* 3019 */         str = dataInputStream.readUTF();
/*      */       }
/*      */       finally {
/*      */         
/* 3023 */         if (dataInputStream != null) {
/* 3024 */           dataInputStream.close();
/*      */         }
/*      */       } 
/* 3027 */       return str;
/*      */     }
/*      */ 
/*      */     
/*      */     private Object readResolve() throws ObjectStreamException {
/* 3032 */       return this._impl;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static class SerializedInteriorObject
/*      */     implements Serializable
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */     
/*      */     transient XmlObject _impl;
/*      */ 
/*      */     
/*      */     transient XmlObject _root;
/*      */ 
/*      */     
/*      */     private SerializedInteriorObject() {}
/*      */ 
/*      */     
/*      */     private SerializedInteriorObject(XmlObject param1XmlObject1, XmlObject param1XmlObject2) {
/* 3054 */       this._impl = param1XmlObject1;
/* 3055 */       this._root = param1XmlObject2;
/*      */     }
/*      */ 
/*      */     
/*      */     private void writeObject(ObjectOutputStream param1ObjectOutputStream) throws IOException {
/* 3060 */       param1ObjectOutputStream.writeObject(this._root);
/* 3061 */       param1ObjectOutputStream.writeBoolean(false);
/* 3062 */       param1ObjectOutputStream.writeInt(distanceToRoot());
/*      */     }
/*      */ 
/*      */     
/*      */     private void readObject(ObjectInputStream param1ObjectInputStream) throws IOException, ClassNotFoundException {
/* 3067 */       this._root = (XmlObject)param1ObjectInputStream.readObject();
/* 3068 */       param1ObjectInputStream.readBoolean();
/* 3069 */       this._impl = objectAtDistance(param1ObjectInputStream.readInt());
/*      */     }
/*      */ 
/*      */     
/*      */     private Object readResolve() throws ObjectStreamException {
/* 3074 */       return this._impl;
/*      */     }
/*      */ 
/*      */     
/*      */     private int distanceToRoot() {
/* 3079 */       XmlCursor xmlCursor = this._impl.newCursor();
/* 3080 */       byte b = 0;
/* 3081 */       while (!xmlCursor.toPrevToken().isNone()) {
/*      */         
/* 3083 */         if (!xmlCursor.currentTokenType().isNamespace())
/*      */         {
/* 3085 */           b++;
/*      */         }
/*      */       } 
/*      */       
/* 3089 */       xmlCursor.dispose();
/* 3090 */       return b;
/*      */     }
/*      */ 
/*      */     
/*      */     private XmlObject objectAtDistance(int param1Int) {
/* 3095 */       XmlCursor xmlCursor = this._root.newCursor();
/* 3096 */       while (param1Int > 0) {
/*      */         
/* 3098 */         xmlCursor.toNextToken();
/* 3099 */         if (!xmlCursor.currentTokenType().isNamespace())
/*      */         {
/* 3101 */           param1Int--;
/*      */         }
/*      */       } 
/*      */       
/* 3105 */       XmlObject xmlObject = xmlCursor.getObject();
/* 3106 */       xmlCursor.dispose();
/* 3107 */       return xmlObject;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   protected static Object java_value(XmlObject paramXmlObject) {
/* 3113 */     if (paramXmlObject.isNil()) {
/* 3114 */       return null;
/*      */     }
/* 3116 */     if (!(paramXmlObject instanceof XmlAnySimpleType)) {
/* 3117 */       return paramXmlObject;
/*      */     }
/* 3119 */     SchemaType schemaType = ((SimpleValue)paramXmlObject).instanceType();
/* 3120 */     assert schemaType != null : "Nil case should have been handled above";
/*      */ 
/*      */     
/* 3123 */     if (schemaType.getSimpleVariety() == 3) {
/* 3124 */       return ((SimpleValue)paramXmlObject).getListValue();
/*      */     }
/* 3126 */     SimpleValue simpleValue = (SimpleValue)paramXmlObject;
/*      */     
/* 3128 */     switch (schemaType.getPrimitiveType().getBuiltinTypeCode()) {
/*      */       
/*      */       case 3:
/* 3131 */         return simpleValue.getBooleanValue() ? Boolean.TRUE : Boolean.FALSE;
/*      */       
/*      */       case 4:
/*      */       case 5:
/* 3135 */         return simpleValue.getByteArrayValue();
/*      */       
/*      */       case 7:
/* 3138 */         return simpleValue.getQNameValue();
/*      */       
/*      */       case 9:
/* 3141 */         return new Float(simpleValue.getFloatValue());
/*      */       
/*      */       case 10:
/* 3144 */         return new Double(simpleValue.getDoubleValue());
/*      */ 
/*      */       
/*      */       case 11:
/* 3148 */         switch (schemaType.getDecimalSize()) {
/*      */           
/*      */           case 8:
/* 3151 */             return new Byte(simpleValue.getByteValue());
/*      */           
/*      */           case 16:
/* 3154 */             return new Short(simpleValue.getShortValue());
/*      */           
/*      */           case 32:
/* 3157 */             return new Integer(simpleValue.getIntValue());
/*      */           
/*      */           case 64:
/* 3160 */             return new Long(simpleValue.getLongValue());
/*      */           
/*      */           case 1000000:
/* 3163 */             return simpleValue.getBigIntegerValue();
/*      */           
/*      */           default:
/* 3166 */             assert false : "invalid numeric bit count"; break;
/*      */           case 1000001:
/*      */             break;
/* 3169 */         }  return simpleValue.getBigDecimalValue();
/*      */ 
/*      */       
/*      */       case 6:
/* 3173 */         return simpleValue.getStringValue();
/*      */       
/*      */       case 13:
/* 3176 */         return simpleValue.getGDurationValue();
/*      */       
/*      */       case 14:
/*      */       case 15:
/*      */       case 16:
/*      */       case 17:
/*      */       case 18:
/*      */       case 19:
/*      */       case 20:
/*      */       case 21:
/* 3186 */         return simpleValue.getCalendarValue();
/*      */       
/*      */       default:
/* 3189 */         assert false : "encountered nonprimitive type.";
/*      */         break;
/*      */       
/*      */       case 2:
/*      */       case 8:
/*      */       case 12:
/*      */         break;
/*      */     } 
/*      */     
/* 3198 */     return simpleValue.getStringValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected XmlAnySimpleType get_default_attribute_value(b paramb) {
/* 3208 */     SchemaType schemaType = schemaType();
/* 3209 */     SchemaAttributeModel schemaAttributeModel = schemaType.getAttributeModel();
/* 3210 */     if (schemaAttributeModel == null)
/* 3211 */       return null; 
/* 3212 */     SchemaLocalAttribute schemaLocalAttribute = schemaAttributeModel.getAttribute(paramb);
/* 3213 */     if (schemaLocalAttribute == null)
/* 3214 */       return null; 
/* 3215 */     return schemaLocalAttribute.getDefaultValue();
/*      */   }
/*      */   
/*      */   public abstract SchemaType schemaType();
/*      */   
/*      */   protected abstract void set_text(String paramString);
/*      */   
/*      */   protected abstract void set_nil();
/*      */   
/*      */   protected abstract String compute_text(NamespaceManager paramNamespaceManager);
/*      */   
/*      */   protected abstract boolean equal_to(XmlObject paramXmlObject);
/*      */   
/*      */   protected abstract int value_hash_code();
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\XmlObjectBase.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */