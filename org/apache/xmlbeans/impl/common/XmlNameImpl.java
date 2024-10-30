/*     */ package org.apache.xmlbeans.impl.common;
/*     */ 
/*     */ import org.apache.xmlbeans.xml.stream.XMLName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XmlNameImpl
/*     */   implements XMLName
/*     */ {
/*  22 */   private String namespaceUri = null;
/*  23 */   private String localName = null;
/*  24 */   private String prefix = null;
/*  25 */   private int hash = 0;
/*     */   public XmlNameImpl() {}
/*     */   
/*     */   public XmlNameImpl(String paramString) {
/*  29 */     this.localName = paramString;
/*     */   }
/*     */   public XmlNameImpl(String paramString1, String paramString2) {
/*  32 */     setNamespaceUri(paramString1);
/*  33 */     this.localName = paramString2;
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlNameImpl(String paramString1, String paramString2, String paramString3) {
/*  38 */     setNamespaceUri(paramString1);
/*  39 */     this.localName = paramString2;
/*  40 */     this.prefix = paramString3;
/*     */   }
/*     */   
/*  43 */   public String getNamespaceUri() { return this.namespaceUri; }
/*  44 */   public String getLocalName() { return this.localName; } public String getPrefix() {
/*  45 */     return this.prefix;
/*     */   }
/*     */   public void setNamespaceUri(String paramString) {
/*  48 */     this.hash = 0;
/*  49 */     if (paramString != null && paramString.equals(""))
/*  50 */       return;  this.namespaceUri = paramString;
/*     */   }
/*     */   public void setLocalName(String paramString) {
/*  53 */     this.localName = paramString;
/*  54 */     this.hash = 0;
/*     */   } public void setPrefix(String paramString) {
/*  56 */     this.prefix = paramString;
/*     */   }
/*     */   public String getQualifiedName() {
/*  59 */     if (this.prefix != null && this.prefix.length() > 0) {
/*  60 */       return this.prefix + ":" + this.localName;
/*     */     }
/*  62 */     return this.localName;
/*     */   }
/*     */   public String toString() {
/*  65 */     if (getNamespaceUri() != null) {
/*  66 */       return "['" + getNamespaceUri() + "']:" + getQualifiedName();
/*     */     }
/*  68 */     return getQualifiedName();
/*     */   }
/*     */   
/*     */   public final int hashCode() {
/*  72 */     int i = this.hash;
/*  73 */     if (i == 0) {
/*  74 */       i = 17;
/*  75 */       if (this.namespaceUri != null) {
/*  76 */         i = 37 * i + this.namespaceUri.hashCode();
/*     */       }
/*  78 */       if (this.localName != null) {
/*  79 */         i = 37 * i + this.localName.hashCode();
/*     */       }
/*  81 */       this.hash = i;
/*     */     } 
/*  83 */     return i;
/*     */   }
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/*  87 */     if (paramObject == this) return true;
/*     */     
/*  89 */     if (paramObject instanceof XMLName) {
/*  90 */       XMLName xMLName = (XMLName)paramObject;
/*     */       
/*  92 */       String str = this.localName;
/*  93 */       if ((str == null) ? (xMLName.getLocalName() == null) : str.equals(xMLName.getLocalName())) {
/*     */ 
/*     */ 
/*     */         
/*  97 */         String str1 = this.namespaceUri;
/*  98 */         return (str1 == null) ? ((xMLName.getNamespaceUri() == null)) : str1.equals(xMLName.getNamespaceUri());
/*     */       } 
/*     */       return false;
/*     */     } 
/* 102 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\XmlNameImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */