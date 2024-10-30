/*     */ package org.apache.xmlbeans.impl.jam.xml;
/*     */ 
/*     */ import java.io.Writer;
/*     */ import javax.xml.stream.XMLOutputFactory;
/*     */ import javax.xml.stream.XMLStreamException;
/*     */ import javax.xml.stream.XMLStreamWriter;
/*     */ import org.apache.xmlbeans.impl.jam.JAnnotatedElement;
/*     */ import org.apache.xmlbeans.impl.jam.JAnnotation;
/*     */ import org.apache.xmlbeans.impl.jam.JAnnotationValue;
/*     */ import org.apache.xmlbeans.impl.jam.JClass;
/*     */ import org.apache.xmlbeans.impl.jam.JComment;
/*     */ import org.apache.xmlbeans.impl.jam.JConstructor;
/*     */ import org.apache.xmlbeans.impl.jam.JField;
/*     */ import org.apache.xmlbeans.impl.jam.JInvokable;
/*     */ import org.apache.xmlbeans.impl.jam.JMethod;
/*     */ import org.apache.xmlbeans.impl.jam.JParameter;
/*     */ import org.apache.xmlbeans.impl.jam.JSourcePosition;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class JamXmlWriter
/*     */   implements JamXmlElements
/*     */ {
/*     */   private XMLStreamWriter mOut;
/*     */   private boolean mInBody = false;
/*     */   private boolean mWriteSourceURI = false;
/*     */   
/*     */   public JamXmlWriter(Writer paramWriter) throws XMLStreamException {
/*  50 */     if (paramWriter == null) throw new IllegalArgumentException("null out"); 
/*  51 */     this.mOut = XMLOutputFactory.newInstance().createXMLStreamWriter(paramWriter);
/*     */   }
/*     */   
/*     */   public JamXmlWriter(XMLStreamWriter paramXMLStreamWriter) {
/*  55 */     if (paramXMLStreamWriter == null) throw new IllegalArgumentException("null out"); 
/*  56 */     this.mOut = paramXMLStreamWriter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void begin() throws XMLStreamException {
/*  64 */     if (this.mInBody) throw new XMLStreamException("begin() already called"); 
/*  65 */     this.mOut.writeStartElement("jam-service");
/*  66 */     this.mInBody = true;
/*     */   }
/*     */   
/*     */   public void end() throws XMLStreamException {
/*  70 */     if (!this.mInBody) throw new XMLStreamException("begin() never called"); 
/*  71 */     this.mOut.writeEndElement();
/*  72 */     this.mInBody = false;
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
/*     */   public void write(JClass paramJClass) throws XMLStreamException {
/*  87 */     assertStarted();
/*  88 */     this.mOut.writeStartElement("class");
/*  89 */     writeValueElement("name", paramJClass.getFieldDescriptor());
/*  90 */     writeValueElement("is-interface", paramJClass.isInterface());
/*  91 */     writeModifiers(paramJClass.getModifiers());
/*  92 */     JClass jClass = paramJClass.getSuperclass();
/*  93 */     if (jClass != null) writeValueElement("superclass", jClass.getFieldDescriptor()); 
/*  94 */     writeClassList("interface", paramJClass.getInterfaces());
/*     */     
/*  96 */     JField[] arrayOfJField = paramJClass.getDeclaredFields(); byte b;
/*  97 */     for (b = 0; b < arrayOfJField.length; ) { write(arrayOfJField[b]); b++; }
/*     */     
/*  99 */     JConstructor[] arrayOfJConstructor = paramJClass.getConstructors();
/* 100 */     for (b = 0; b < arrayOfJConstructor.length; ) { write(arrayOfJConstructor[b]); b++; }
/*     */     
/* 102 */     JMethod[] arrayOfJMethod = paramJClass.getDeclaredMethods();
/* 103 */     for (b = 0; b < arrayOfJMethod.length; ) { write(arrayOfJMethod[b]); b++; }
/*     */ 
/*     */     
/* 106 */     writeAnnotatedElement((JAnnotatedElement)paramJClass);
/* 107 */     this.mOut.writeEndElement();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void write(JMethod paramJMethod) throws XMLStreamException {
/* 115 */     this.mOut.writeStartElement("method");
/* 116 */     writeValueElement("name", paramJMethod.getSimpleName());
/* 117 */     writeValueElement("return-type", paramJMethod.getReturnType().getFieldDescriptor());
/*     */     
/* 119 */     writeInvokable((JInvokable)paramJMethod);
/* 120 */     this.mOut.writeEndElement();
/*     */   }
/*     */   
/*     */   private void write(JConstructor paramJConstructor) throws XMLStreamException {
/* 124 */     this.mOut.writeStartElement("constructor");
/* 125 */     writeInvokable((JInvokable)paramJConstructor);
/* 126 */     this.mOut.writeEndElement();
/*     */   }
/*     */   
/*     */   private void write(JField paramJField) throws XMLStreamException {
/* 130 */     this.mOut.writeStartElement("field");
/* 131 */     writeValueElement("name", paramJField.getSimpleName());
/* 132 */     writeModifiers(paramJField.getModifiers());
/* 133 */     writeValueElement("type", paramJField.getType().getFieldDescriptor());
/* 134 */     writeAnnotatedElement((JAnnotatedElement)paramJField);
/* 135 */     this.mOut.writeEndElement();
/*     */   }
/*     */   
/*     */   private void writeInvokable(JInvokable paramJInvokable) throws XMLStreamException {
/* 139 */     writeModifiers(paramJInvokable.getModifiers());
/* 140 */     JParameter[] arrayOfJParameter = paramJInvokable.getParameters();
/* 141 */     for (byte b = 0; b < arrayOfJParameter.length; b++) {
/* 142 */       this.mOut.writeStartElement("parameter");
/* 143 */       writeValueElement("name", arrayOfJParameter[b].getSimpleName());
/* 144 */       writeValueElement("type", arrayOfJParameter[b].getType().getFieldDescriptor());
/* 145 */       writeAnnotatedElement((JAnnotatedElement)arrayOfJParameter[b]);
/* 146 */       this.mOut.writeEndElement();
/*     */     } 
/* 148 */     writeAnnotatedElement((JAnnotatedElement)paramJInvokable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeClassList(String paramString, JClass[] paramArrayOfJClass) throws XMLStreamException {
/* 154 */     for (byte b = 0; b < paramArrayOfJClass.length; b++) {
/* 155 */       this.mOut.writeStartElement(paramString);
/* 156 */       this.mOut.writeCharacters(paramArrayOfJClass[b].getFieldDescriptor());
/* 157 */       this.mOut.writeEndElement();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void writeModifiers(int paramInt) throws XMLStreamException {
/* 162 */     this.mOut.writeStartElement("modifiers");
/* 163 */     this.mOut.writeCharacters(String.valueOf(paramInt));
/* 164 */     this.mOut.writeEndElement();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeValueElement(String paramString, boolean paramBoolean) throws XMLStreamException {
/* 170 */     this.mOut.writeStartElement(paramString);
/* 171 */     this.mOut.writeCharacters(String.valueOf(paramBoolean));
/* 172 */     this.mOut.writeEndElement();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeValueElement(String paramString, int paramInt) throws XMLStreamException {
/* 178 */     this.mOut.writeStartElement(paramString);
/* 179 */     this.mOut.writeCharacters(String.valueOf(paramInt));
/* 180 */     this.mOut.writeEndElement();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeValueElement(String paramString1, String paramString2) throws XMLStreamException {
/* 186 */     this.mOut.writeStartElement(paramString1);
/* 187 */     this.mOut.writeCharacters(paramString2);
/* 188 */     this.mOut.writeEndElement();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeValueElement(String paramString, String[] paramArrayOfString) throws XMLStreamException {
/* 194 */     for (byte b = 0; b < paramArrayOfString.length; ) { writeValueElement(paramString, paramArrayOfString[b]); b++; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeAnnotatedElement(JAnnotatedElement paramJAnnotatedElement) throws XMLStreamException {
/* 201 */     JAnnotation[] arrayOfJAnnotation = paramJAnnotatedElement.getAnnotations();
/* 202 */     for (byte b = 0; b < arrayOfJAnnotation.length; b++) {
/* 203 */       writeAnnotation(arrayOfJAnnotation[b]);
/*     */     }
/* 205 */     JComment jComment = paramJAnnotatedElement.getComment();
/* 206 */     if (jComment != null) {
/* 207 */       String str = jComment.getText();
/* 208 */       if (str != null) {
/* 209 */         str = str.trim();
/* 210 */         if (str.length() > 0) {
/* 211 */           this.mOut.writeStartElement("comment");
/* 212 */           this.mOut.writeCData(jComment.getText());
/* 213 */           this.mOut.writeEndElement();
/*     */         } 
/*     */       } 
/*     */     } 
/* 217 */     JSourcePosition jSourcePosition = paramJAnnotatedElement.getSourcePosition();
/* 218 */     if (jSourcePosition != null) {
/* 219 */       this.mOut.writeStartElement("source-position");
/* 220 */       if (jSourcePosition.getLine() != -1) {
/* 221 */         writeValueElement("line", jSourcePosition.getLine());
/*     */       }
/* 223 */       if (jSourcePosition.getColumn() != -1) {
/* 224 */         writeValueElement("column", jSourcePosition.getColumn());
/*     */       }
/* 226 */       if (this.mWriteSourceURI && jSourcePosition.getSourceURI() != null)
/* 227 */         writeValueElement("source-uri", jSourcePosition.getSourceURI().toString()); 
/* 228 */       this.mOut.writeEndElement();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void writeAnnotation(JAnnotation paramJAnnotation) throws XMLStreamException {
/* 233 */     this.mOut.writeStartElement("annotation");
/* 234 */     writeValueElement("name", paramJAnnotation.getQualifiedName());
/* 235 */     JAnnotationValue[] arrayOfJAnnotationValue = paramJAnnotation.getValues();
/* 236 */     for (byte b = 0; b < arrayOfJAnnotationValue.length; b++) {
/* 237 */       writeAnnotationValue(arrayOfJAnnotationValue[b]);
/*     */     }
/* 239 */     this.mOut.writeEndElement();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeAnnotationValue(JAnnotationValue paramJAnnotationValue) throws XMLStreamException {
/* 245 */     this.mOut.writeStartElement("annotation-value");
/* 246 */     writeValueElement("name", paramJAnnotationValue.getName());
/* 247 */     writeValueElement("type", paramJAnnotationValue.getType().getFieldDescriptor());
/* 248 */     if (paramJAnnotationValue.getType().isArrayType()) {
/* 249 */       writeValueElement("value", paramJAnnotationValue.asStringArray());
/*     */     } else {
/* 251 */       writeValueElement("value", paramJAnnotationValue.asString());
/*     */     } 
/*     */     
/* 254 */     this.mOut.writeEndElement();
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
/*     */   private void assertStarted() throws XMLStreamException {
/* 266 */     if (!this.mInBody) throw new XMLStreamException("begin() not called"); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\xml\JamXmlWriter.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */