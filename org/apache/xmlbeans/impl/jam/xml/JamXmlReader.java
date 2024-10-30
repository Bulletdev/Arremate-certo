/*     */ package org.apache.xmlbeans.impl.jam.xml;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.io.StringWriter;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.util.ArrayList;
/*     */ import javax.xml.stream.XMLInputFactory;
/*     */ import javax.xml.stream.XMLStreamException;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.impl.jam.JClass;
/*     */ import org.apache.xmlbeans.impl.jam.internal.CachedClassBuilder;
/*     */ import org.apache.xmlbeans.impl.jam.internal.elements.ClassImpl;
/*     */ import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MAnnotation;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MClass;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MConstructor;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MField;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MInvokable;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MMethod;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MParameter;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MSourcePosition;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class JamXmlReader
/*     */   implements JamXmlElements
/*     */ {
/*     */   private XMLStreamReader mIn;
/*     */   private CachedClassBuilder mCache;
/*     */   private ElementContext mContext;
/*     */   
/*     */   public JamXmlReader(CachedClassBuilder paramCachedClassBuilder, InputStream paramInputStream, ElementContext paramElementContext) throws XMLStreamException {
/*  62 */     this(paramCachedClassBuilder, XMLInputFactory.newInstance().createXMLStreamReader(paramInputStream), paramElementContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JamXmlReader(CachedClassBuilder paramCachedClassBuilder, Reader paramReader, ElementContext paramElementContext) throws XMLStreamException {
/*  70 */     this(paramCachedClassBuilder, XMLInputFactory.newInstance().createXMLStreamReader(paramReader), paramElementContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JamXmlReader(CachedClassBuilder paramCachedClassBuilder, XMLStreamReader paramXMLStreamReader, ElementContext paramElementContext) {
/*  77 */     if (paramCachedClassBuilder == null) throw new IllegalArgumentException("null cache"); 
/*  78 */     if (paramXMLStreamReader == null) throw new IllegalArgumentException("null cache"); 
/*  79 */     if (paramElementContext == null) throw new IllegalArgumentException("null ctx"); 
/*  80 */     this.mIn = paramXMLStreamReader;
/*  81 */     this.mCache = paramCachedClassBuilder;
/*  82 */     this.mContext = paramElementContext;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void read() throws XMLStreamException {
/*  89 */     nextElement();
/*  90 */     assertStart("jam-service");
/*  91 */     nextElement();
/*  92 */     for (; "class".equals(getElementName()); readClass());
/*  93 */     assertEnd("jam-service");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void readClass() throws XMLStreamException {
/* 100 */     assertStart("class");
/* 101 */     nextElement();
/* 102 */     String str1 = assertCurrentString("name");
/* 103 */     int i = str1.lastIndexOf('.');
/* 104 */     String str2 = "";
/* 105 */     if (i != -1) {
/* 106 */       str2 = str1.substring(0, i);
/* 107 */       str1 = str1.substring(i + 1);
/*     */     } 
/* 109 */     MClass mClass = this.mCache.createClassToBuild(str2, str1, null);
/*     */     
/* 111 */     mClass.setIsInterface(assertCurrentBoolean("is-interface"));
/* 112 */     mClass.setModifiers(assertCurrentInt("modifiers"));
/* 113 */     String str3 = checkCurrentString("superclass");
/* 114 */     if (str3 != null) mClass.setSuperclass(str3); 
/* 115 */     while ((str3 = checkCurrentString("interface")) != null) {
/* 116 */       mClass.addInterface(str3);
/*     */     }
/* 118 */     for (; "field".equals(getElementName()); readField(mClass));
/* 119 */     for (; "constructor".equals(getElementName()); readConstructor(mClass));
/* 120 */     for (; "method".equals(getElementName()); readMethod(mClass));
/* 121 */     readAnnotatedElement((MAnnotatedElement)mClass);
/* 122 */     assertEnd("class");
/* 123 */     ((ClassImpl)mClass).setState(6);
/* 124 */     nextElement();
/*     */   }
/*     */   
/*     */   private void readField(MClass paramMClass) throws XMLStreamException {
/* 128 */     assertStart("field");
/* 129 */     MField mField = paramMClass.addNewField();
/* 130 */     nextElement();
/* 131 */     mField.setSimpleName(assertCurrentString("name"));
/* 132 */     mField.setModifiers(assertCurrentInt("modifiers"));
/* 133 */     mField.setType(assertCurrentString("type"));
/* 134 */     readAnnotatedElement((MAnnotatedElement)mField);
/* 135 */     assertEnd("field");
/* 136 */     nextElement();
/*     */   }
/*     */   
/*     */   private void readConstructor(MClass paramMClass) throws XMLStreamException {
/* 140 */     assertStart("constructor");
/* 141 */     MConstructor mConstructor = paramMClass.addNewConstructor();
/* 142 */     nextElement();
/* 143 */     readInvokableContents((MInvokable)mConstructor);
/* 144 */     assertEnd("constructor");
/* 145 */     nextElement();
/*     */   }
/*     */   
/*     */   private void readMethod(MClass paramMClass) throws XMLStreamException {
/* 149 */     assertStart("method");
/* 150 */     MMethod mMethod = paramMClass.addNewMethod();
/* 151 */     nextElement();
/* 152 */     mMethod.setSimpleName(assertCurrentString("name"));
/* 153 */     mMethod.setReturnType(assertCurrentString("return-type"));
/* 154 */     readInvokableContents((MInvokable)mMethod);
/* 155 */     assertEnd("method");
/* 156 */     nextElement();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void readSourcePosition(MAnnotatedElement paramMAnnotatedElement) throws XMLStreamException {
/* 162 */     assertStart("source-position");
/* 163 */     MSourcePosition mSourcePosition = paramMAnnotatedElement.createSourcePosition();
/* 164 */     nextElement();
/* 165 */     if ("line".equals(getElementName())) {
/* 166 */       mSourcePosition.setLine(assertCurrentInt("line"));
/*     */     }
/* 168 */     if ("column".equals(getElementName())) {
/* 169 */       mSourcePosition.setColumn(assertCurrentInt("column"));
/*     */     }
/* 171 */     if ("source-uri".equals(getElementName())) {
/*     */       try {
/* 173 */         mSourcePosition.setSourceURI(new URI(assertCurrentString("source-uri")));
/* 174 */       } catch (URISyntaxException uRISyntaxException) {
/* 175 */         throw new XMLStreamException(uRISyntaxException);
/*     */       } 
/*     */     }
/* 178 */     assertEnd("source-position");
/* 179 */     nextElement();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void readInvokableContents(MInvokable paramMInvokable) throws XMLStreamException {
/* 185 */     paramMInvokable.setModifiers(assertCurrentInt("modifiers"));
/* 186 */     while ("parameter".equals(getElementName())) {
/* 187 */       nextElement();
/* 188 */       MParameter mParameter = paramMInvokable.addNewParameter();
/* 189 */       mParameter.setSimpleName(assertCurrentString("name"));
/* 190 */       mParameter.setType(assertCurrentString("type"));
/* 191 */       readAnnotatedElement((MAnnotatedElement)mParameter);
/* 192 */       assertEnd("parameter");
/* 193 */       nextElement();
/*     */     } 
/* 195 */     readAnnotatedElement((MAnnotatedElement)paramMInvokable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void readAnnotatedElement(MAnnotatedElement paramMAnnotatedElement) throws XMLStreamException {
/* 202 */     while ("annotation".equals(getElementName())) {
/* 203 */       nextElement();
/*     */ 
/*     */       
/* 206 */       MAnnotation mAnnotation = paramMAnnotatedElement.addLiteralAnnotation(assertCurrentString("name"));
/* 207 */       while ("annotation-value".equals(getElementName())) {
/* 208 */         nextElement();
/* 209 */         String str1 = assertCurrentString("name");
/* 210 */         String str2 = assertCurrentString("type");
/* 211 */         JClass jClass = this.mContext.getClassLoader().loadClass(str2);
/* 212 */         if (jClass.isArrayType()) {
/* 213 */           ArrayList arrayList = new ArrayList();
/* 214 */           while ("value".equals(getElementName())) {
/* 215 */             String str = assertCurrentString("value");
/* 216 */             arrayList.add(str);
/*     */           } 
/* 218 */           String[] arrayOfString = new String[arrayList.size()];
/* 219 */           arrayList.toArray(arrayOfString);
/* 220 */           mAnnotation.setSimpleValue(str1, arrayOfString, jClass);
/*     */         } else {
/* 222 */           String str = assertCurrentString("value");
/* 223 */           mAnnotation.setSimpleValue(str1, str, jClass);
/*     */         } 
/* 225 */         assertEnd("annotation-value");
/* 226 */         nextElement();
/*     */       } 
/* 228 */       assertEnd("annotation");
/* 229 */       nextElement();
/*     */     } 
/* 231 */     if ("comment".equals(getElementName())) {
/* 232 */       paramMAnnotatedElement.createComment().setText(this.mIn.getElementText());
/* 233 */       assertEnd("comment");
/* 234 */       nextElement();
/*     */     } 
/* 236 */     if ("source-position".equals(getElementName())) {
/* 237 */       readSourcePosition(paramMAnnotatedElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void assertStart(String paramString) throws XMLStreamException {
/* 243 */     if (!this.mIn.isStartElement() || !paramString.equals(getElementName())) {
/* 244 */       error("expected to get a <" + paramString + ">, ");
/*     */     }
/*     */   }
/*     */   
/*     */   private void assertEnd(String paramString) throws XMLStreamException {
/* 249 */     if (!this.mIn.isEndElement() || !paramString.equals(getElementName())) {
/* 250 */       error("expected to get a </" + paramString + ">, ");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String checkCurrentString(String paramString) throws XMLStreamException {
/* 257 */     if (paramString.equals(getElementName())) {
/* 258 */       String str = this.mIn.getElementText();
/* 259 */       assertEnd(paramString);
/* 260 */       nextElement();
/* 261 */       return str;
/*     */     } 
/* 263 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private String assertCurrentString(String paramString) throws XMLStreamException {
/* 268 */     assertStart(paramString);
/* 269 */     String str = this.mIn.getElementText();
/* 270 */     assertEnd(paramString);
/* 271 */     nextElement();
/* 272 */     return str;
/*     */   }
/*     */   
/*     */   private int assertCurrentInt(String paramString) throws XMLStreamException {
/* 276 */     assertStart(paramString);
/* 277 */     String str = this.mIn.getElementText();
/* 278 */     assertEnd(paramString);
/* 279 */     nextElement();
/* 280 */     return Integer.valueOf(str).intValue();
/*     */   }
/*     */   
/*     */   private boolean assertCurrentBoolean(String paramString) throws XMLStreamException {
/* 284 */     assertStart(paramString);
/* 285 */     String str = this.mIn.getElementText();
/* 286 */     assertEnd(paramString);
/* 287 */     nextElement();
/* 288 */     return Boolean.valueOf(str).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   private void error(String paramString) throws XMLStreamException {
/* 293 */     StringWriter stringWriter = new StringWriter();
/* 294 */     stringWriter.write("<");
/* 295 */     stringWriter.write(this.mIn.getLocalName());
/* 296 */     stringWriter.write("> line:");
/* 297 */     stringWriter.write("" + this.mIn.getLocation().getLineNumber());
/* 298 */     stringWriter.write(" col:");
/* 299 */     stringWriter.write("" + this.mIn.getLocation().getColumnNumber());
/* 300 */     stringWriter.write("]");
/* 301 */     throw new XMLStreamException(paramString + ":\n " + stringWriter.toString());
/*     */   }
/*     */   
/*     */   private void nextElement() throws XMLStreamException {
/*     */     do {
/* 306 */       if (this.mIn.next() == -1) {
/* 307 */         throw new XMLStreamException("Unexpected end of file");
/*     */       }
/* 309 */     } while (!this.mIn.isEndElement() && !this.mIn.isStartElement());
/*     */   }
/*     */   
/*     */   private String getElementName() {
/* 313 */     return this.mIn.getLocalName();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\xml\JamXmlReader.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */