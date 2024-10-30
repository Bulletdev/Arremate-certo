/*     */ package org.apache.xmlbeans.impl.store;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ import javax.xml.namespace.b;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.QNameSet;
/*     */ import org.apache.xmlbeans.SchemaField;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.impl.values.NamespaceManager;
/*     */ import org.apache.xmlbeans.impl.values.TypeStore;
/*     */ import org.apache.xmlbeans.impl.values.TypeStoreUser;
/*     */ import org.apache.xmlbeans.impl.values.TypeStoreVisitor;
/*     */ import org.w3c.dom.DOMImplementation;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Public2
/*     */ {
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   private static Locale newLocale(Saaj paramSaaj) {
/*  59 */     XmlOptions xmlOptions = null;
/*     */     
/*  61 */     if (paramSaaj != null) {
/*     */       
/*  63 */       xmlOptions = new XmlOptions();
/*  64 */       xmlOptions.put("SAAJ_IMPL", paramSaaj);
/*     */     } 
/*     */     
/*  67 */     return Locale.getLocale(null, xmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   private static Locale newLocale() {
/*  72 */     return Locale.getLocale(null, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setSync(Document paramDocument, boolean paramBoolean) {
/*  77 */     assert paramDocument instanceof DomImpl.Dom;
/*     */     
/*  79 */     Locale locale = ((DomImpl.Dom)paramDocument).locale();
/*     */     
/*  81 */     locale._noSync = !paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String compilePath(String paramString, XmlOptions paramXmlOptions) {
/*  86 */     return Path.compilePath(paramString, paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public static DOMImplementation getDomImplementation() {
/*  91 */     return newLocale();
/*     */   }
/*     */ 
/*     */   
/*     */   public static DOMImplementation getDomImplementation(Saaj paramSaaj) {
/*  96 */     return newLocale(paramSaaj);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Document parse(String paramString) throws XmlException {
/*     */     DomImpl.Dom dom;
/* 102 */     Locale locale = newLocale();
/*     */ 
/*     */ 
/*     */     
/* 106 */     if (locale.noSync()) { locale.enter(); try { dom = locale.load(paramString); } finally { locale.exit(); }  }
/* 107 */     else { synchronized (locale) { locale.enter(); try { dom = locale.load(paramString); } finally { locale.exit(); }  }
/*     */        }
/* 109 */      return (Document)dom;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Document parse(String paramString, XmlOptions paramXmlOptions) throws XmlException {
/*     */     DomImpl.Dom dom;
/* 115 */     Locale locale = newLocale();
/*     */ 
/*     */ 
/*     */     
/* 119 */     if (locale.noSync()) { locale.enter(); try { dom = locale.load(paramString, paramXmlOptions); } finally { locale.exit(); }  }
/* 120 */     else { synchronized (locale) { locale.enter(); try { dom = locale.load(paramString, paramXmlOptions); } finally { locale.exit(); }  }
/*     */        }
/* 122 */      return (Document)dom;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Document parse(String paramString, Saaj paramSaaj) throws XmlException {
/*     */     DomImpl.Dom dom;
/* 128 */     Locale locale = newLocale(paramSaaj);
/*     */ 
/*     */ 
/*     */     
/* 132 */     if (locale.noSync()) { locale.enter(); try { dom = locale.load(paramString); } finally { locale.exit(); }  }
/* 133 */     else { synchronized (locale) { locale.enter(); try { dom = locale.load(paramString); } finally { locale.exit(); }  }
/*     */        }
/* 135 */      return (Document)dom;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Document parse(InputStream paramInputStream, XmlOptions paramXmlOptions) throws XmlException, IOException {
/*     */     DomImpl.Dom dom;
/* 141 */     Locale locale = newLocale();
/*     */ 
/*     */ 
/*     */     
/* 145 */     if (locale.noSync()) { locale.enter(); try { dom = locale.load(paramInputStream, paramXmlOptions); } finally { locale.exit(); }  }
/* 146 */     else { synchronized (locale) { locale.enter(); try { dom = locale.load(paramInputStream, paramXmlOptions); } finally { locale.exit(); }  }
/*     */        }
/* 148 */      return (Document)dom;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Document parse(InputStream paramInputStream, Saaj paramSaaj) throws XmlException, IOException {
/*     */     DomImpl.Dom dom;
/* 154 */     Locale locale = newLocale(paramSaaj);
/*     */ 
/*     */ 
/*     */     
/* 158 */     if (locale.noSync()) { locale.enter(); try { dom = locale.load(paramInputStream); } finally { locale.exit(); }  }
/* 159 */     else { synchronized (locale) { locale.enter(); try { dom = locale.load(paramInputStream); } finally { locale.exit(); }  }
/*     */        }
/* 161 */      return (Document)dom;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Node getNode(XMLStreamReader paramXMLStreamReader) {
/* 166 */     return Jsr173.nodeFromStream(paramXMLStreamReader);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XMLStreamReader getStream(Node paramNode) {
/* 171 */     assert paramNode instanceof DomImpl.Dom;
/*     */     
/* 173 */     DomImpl.Dom dom = (DomImpl.Dom)paramNode;
/*     */     
/* 175 */     Locale locale = dom.locale();
/*     */     
/* 177 */     if (locale.noSync()) { locale.enter(); try { return DomImpl.getXmlStreamReader(dom); } finally { locale.exit(); }  }
/* 178 */      synchronized (locale) { locale.enter(); try { return DomImpl.getXmlStreamReader(dom); } finally { locale.exit(); }
/*     */        }
/*     */   
/*     */   }
/*     */   public static String save(Node paramNode) {
/* 183 */     return save(paramNode, (XmlOptions)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void save(Node paramNode, OutputStream paramOutputStream, XmlOptions paramXmlOptions) throws IOException {
/* 188 */     XmlCursor xmlCursor = getCursor(paramNode);
/*     */     
/* 190 */     xmlCursor.save(paramOutputStream, paramXmlOptions);
/*     */     
/* 192 */     xmlCursor.dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   public static String save(Node paramNode, XmlOptions paramXmlOptions) {
/* 197 */     assert paramNode instanceof DomImpl.Dom;
/*     */     
/* 199 */     DomImpl.Dom dom = (DomImpl.Dom)paramNode;
/*     */     
/* 201 */     Locale locale = dom.locale();
/*     */     
/* 203 */     if (locale.noSync()) { locale.enter(); try { return saveImpl(dom, paramXmlOptions); } finally { locale.exit(); }  }
/* 204 */      synchronized (locale) { locale.enter(); try { return saveImpl(dom, paramXmlOptions); } finally { locale.exit(); }
/*     */        }
/*     */   
/*     */   }
/*     */   private static String saveImpl(DomImpl.Dom paramDom, XmlOptions paramXmlOptions) {
/* 209 */     Cur cur = paramDom.tempCur();
/*     */     
/* 211 */     String str = (new Saver.TextSaver(cur, paramXmlOptions, null)).saveToString();
/*     */     
/* 213 */     cur.release();
/*     */     
/* 215 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String save(XmlCursor paramXmlCursor) {
/* 220 */     return save(paramXmlCursor, (XmlOptions)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String save(XmlCursor paramXmlCursor, XmlOptions paramXmlOptions) {
/* 225 */     Cursor cursor = (Cursor)paramXmlCursor;
/*     */     
/* 227 */     Locale locale = cursor.locale();
/*     */     
/* 229 */     if (locale.noSync()) { locale.enter(); try { return saveImpl(cursor, paramXmlOptions); } finally { locale.exit(); }  }
/* 230 */      synchronized (locale) { locale.enter(); try { return saveImpl(cursor, paramXmlOptions); } finally { locale.exit(); }
/*     */        }
/*     */   
/*     */   }
/*     */   private static String saveImpl(Cursor paramCursor, XmlOptions paramXmlOptions) {
/* 235 */     Cur cur = paramCursor.tempCur();
/*     */     
/* 237 */     String str = (new Saver.TextSaver(cur, paramXmlOptions, null)).saveToString();
/*     */     
/* 239 */     cur.release();
/*     */     
/* 241 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public static XmlCursor newStore() {
/* 246 */     return newStore(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XmlCursor newStore(Saaj paramSaaj) {
/* 251 */     Locale locale = newLocale(paramSaaj);
/*     */     
/* 253 */     if (locale.noSync()) { locale.enter(); try { return _newStore(locale); } finally { locale.exit(); }  }
/* 254 */      synchronized (locale) { locale.enter(); try { return _newStore(locale); } finally { locale.exit(); }
/*     */        }
/*     */   
/*     */   }
/*     */   public static XmlCursor _newStore(Locale paramLocale) {
/* 259 */     Cur cur = paramLocale.tempCur();
/*     */     
/* 261 */     cur.createRoot();
/*     */     
/* 263 */     Cursor cursor = new Cursor(cur);
/*     */     
/* 265 */     cur.release();
/*     */     
/* 267 */     return cursor;
/*     */   }
/*     */ 
/*     */   
/*     */   public static XmlCursor getCursor(Node paramNode) {
/* 272 */     assert paramNode instanceof DomImpl.Dom;
/*     */     
/* 274 */     DomImpl.Dom dom = (DomImpl.Dom)paramNode;
/*     */     
/* 276 */     Locale locale = dom.locale();
/*     */     
/* 278 */     if (locale.noSync()) { locale.enter(); try { return DomImpl.getXmlCursor(dom); } finally { locale.exit(); }  }
/* 279 */      synchronized (locale) { locale.enter(); try { return DomImpl.getXmlCursor(dom); } finally { locale.exit(); }
/*     */        }
/*     */   
/*     */   }
/*     */   public static void dump(PrintStream paramPrintStream, DomImpl.Dom paramDom) {
/* 284 */     paramDom.dump(paramPrintStream);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void dump(PrintStream paramPrintStream, Node paramNode) {
/* 289 */     dump(paramPrintStream, (DomImpl.Dom)paramNode);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void dump(PrintStream paramPrintStream, XmlCursor paramXmlCursor) {
/* 294 */     ((Cursor)paramXmlCursor).dump(paramPrintStream);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void dump(PrintStream paramPrintStream, XmlObject paramXmlObject) {
/* 299 */     XmlCursor xmlCursor = paramXmlObject.newCursor();
/* 300 */     Node node = xmlCursor.getDomNode();
/* 301 */     DomImpl.Dom dom = (DomImpl.Dom)node;
/* 302 */     xmlCursor.dispose();
/*     */     
/* 304 */     dump(paramPrintStream, dom);
/*     */   }
/*     */   
/* 307 */   public static void dump(DomImpl.Dom paramDom) { dump(System.out, paramDom); }
/* 308 */   public static void dump(Node paramNode) { dump(System.out, paramNode); }
/* 309 */   public static void dump(XmlCursor paramXmlCursor) { dump(System.out, paramXmlCursor); } public static void dump(XmlObject paramXmlObject) {
/* 310 */     dump(System.out, paramXmlObject);
/*     */   }
/*     */   private static class TestTypeStoreUser implements TypeStoreUser { private String _value;
/*     */     TestTypeStoreUser(String param1String) {
/* 314 */       this._value = param1String;
/*     */     }
/* 316 */     public SchemaType get_schema_type() { throw new RuntimeException("Not impl"); } public void attach_store(TypeStore param1TypeStore) {} public TypeStore get_store() {
/* 317 */       throw new RuntimeException("Not impl");
/*     */     } public void invalidate_value() {}
/* 319 */     public boolean uses_invalidate_value() { throw new RuntimeException("Not impl"); }
/* 320 */     public String build_text(NamespaceManager param1NamespaceManager) { return this._value; }
/* 321 */     public boolean build_nil() { throw new RuntimeException("Not impl"); }
/* 322 */     public void invalidate_nilvalue() { throw new RuntimeException("Not impl"); }
/* 323 */     public void invalidate_element_order() { throw new RuntimeException("Not impl"); }
/* 324 */     public void validate_now() { throw new RuntimeException("Not impl"); }
/* 325 */     public void disconnect_store() { throw new RuntimeException("Not impl"); }
/* 326 */     public TypeStoreUser create_element_user(b param1b1, b param1b2) { return new TestTypeStoreUser("ELEM"); }
/* 327 */     public TypeStoreUser create_attribute_user(b param1b) { throw new RuntimeException("Not impl"); }
/* 328 */     public String get_default_element_text(b param1b) { throw new RuntimeException("Not impl"); }
/* 329 */     public String get_default_attribute_text(b param1b) { throw new RuntimeException("Not impl"); }
/* 330 */     public SchemaType get_element_type(b param1b1, b param1b2) { throw new RuntimeException("Not impl"); }
/* 331 */     public SchemaType get_attribute_type(b param1b) { throw new RuntimeException("Not impl"); }
/* 332 */     public int get_elementflags(b param1b) { throw new RuntimeException("Not impl"); }
/* 333 */     public int get_attributeflags(b param1b) { throw new RuntimeException("Not impl"); }
/* 334 */     public SchemaField get_attribute_field(b param1b) { throw new RuntimeException("Not impl"); }
/* 335 */     public boolean is_child_element_order_sensitive() { throw new RuntimeException("Not impl"); }
/* 336 */     public QNameSet get_element_ending_delimiters(b param1b) { throw new RuntimeException("Not impl"); } public TypeStoreVisitor new_visitor() {
/* 337 */       throw new RuntimeException("Not impl");
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void test() throws Exception {
/* 344 */     Xobj xobj = (Xobj)parse("<a>XY</a>");
/*     */     
/* 346 */     Locale locale = xobj._locale;
/*     */     
/* 348 */     locale.enter();
/*     */ 
/*     */     
/*     */     try {
/* 352 */       Cur cur1 = xobj.tempCur();
/*     */       
/* 354 */       cur1.next();
/*     */       
/* 356 */       Cur cur2 = cur1.tempCur();
/* 357 */       cur2.next();
/*     */       
/* 359 */       Cur cur3 = cur2.tempCur();
/* 360 */       cur3.nextChars(1);
/*     */       
/* 362 */       Cur cur4 = cur3.tempCur();
/* 363 */       cur4.nextChars(1);
/*     */       
/* 365 */       cur1.dump();
/*     */       
/* 367 */       cur1.moveNodeContents(cur1, true);
/*     */       
/* 369 */       cur1.dump();
/*     */     }
/* 371 */     catch (Throwable throwable) {
/*     */       
/* 373 */       throwable.printStackTrace();
/*     */     }
/*     */     finally {
/*     */       
/* 377 */       locale.exit();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\store\Public2.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */