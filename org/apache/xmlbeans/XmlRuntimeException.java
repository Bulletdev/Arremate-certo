/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XmlRuntimeException
/*     */   extends RuntimeException
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private List _errors;
/*     */   
/*     */   public XmlRuntimeException(String paramString) {
/*  37 */     super(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlRuntimeException(String paramString, Throwable paramThrowable) {
/*  42 */     super(paramString, paramThrowable);
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlRuntimeException(Throwable paramThrowable) {
/*  47 */     super(paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlRuntimeException(String paramString, Throwable paramThrowable, Collection paramCollection) {
/*  54 */     super(paramString, paramThrowable);
/*     */     
/*  56 */     if (paramCollection != null) {
/*  57 */       this._errors = Collections.unmodifiableList(new ArrayList(paramCollection));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlRuntimeException(XmlError paramXmlError) {
/*  65 */     this(paramXmlError.toString(), (Throwable)null, paramXmlError);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlRuntimeException(String paramString, Throwable paramThrowable, XmlError paramXmlError) {
/*  73 */     this(paramString, paramThrowable, Collections.singletonList(paramXmlError));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlRuntimeException(XmlException paramXmlException) {
/*  81 */     super(paramXmlException.getMessage(), paramXmlException.getCause());
/*     */     
/*  83 */     Collection collection = paramXmlException.getErrors();
/*     */     
/*  85 */     if (collection != null) {
/*  86 */       this._errors = Collections.unmodifiableList(new ArrayList(collection));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlError getError() {
/*  94 */     if (this._errors == null || this._errors.size() == 0) {
/*  95 */       return null;
/*     */     }
/*  97 */     return this._errors.get(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection getErrors() {
/* 105 */     return this._errors;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlRuntimeException.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */