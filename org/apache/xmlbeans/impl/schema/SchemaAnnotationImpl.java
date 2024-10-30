/*     */ package org.apache.xmlbeans.impl.schema;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaAnnotation;
/*     */ import org.apache.xmlbeans.SchemaComponent;
/*     */ import org.apache.xmlbeans.SchemaTypeSystem;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.Annotated;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SchemaAnnotationImpl
/*     */   implements SchemaAnnotation
/*     */ {
/*     */   private SchemaContainer _container;
/*     */   private String[] _appInfoAsXml;
/*     */   private AppinfoDocument.Appinfo[] _appInfo;
/*     */   private String[] _documentationAsXml;
/*     */   private DocumentationDocument.Documentation[] _documentation;
/*     */   private SchemaAnnotation.Attribute[] _attributes;
/*     */   private String _filename;
/*     */   
/*     */   public void setFilename(String paramString) {
/*  46 */     this._filename = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSourceName() {
/*  51 */     return this._filename;
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlObject[] getApplicationInformation() {
/*  56 */     if (this._appInfo == null) {
/*     */       
/*  58 */       int i = this._appInfoAsXml.length;
/*  59 */       this._appInfo = new AppinfoDocument.Appinfo[i];
/*  60 */       for (byte b = 0; b < i; b++) {
/*     */         
/*  62 */         String str = this._appInfoAsXml[b];
/*     */         
/*     */         try {
/*  65 */           this._appInfo[b] = AppinfoDocument.Factory.parse(str).getAppinfo();
/*     */         
/*     */         }
/*  68 */         catch (XmlException xmlException) {
/*     */ 
/*     */           
/*  71 */           this._appInfo[b] = AppinfoDocument.Factory.newInstance().getAppinfo();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  76 */     return (XmlObject[])this._appInfo;
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlObject[] getUserInformation() {
/*  81 */     if (this._documentation == null) {
/*     */       
/*  83 */       int i = this._documentationAsXml.length;
/*  84 */       this._documentation = new DocumentationDocument.Documentation[i];
/*  85 */       for (byte b = 0; b < i; b++) {
/*     */         
/*  87 */         String str = this._documentationAsXml[b];
/*     */         
/*     */         try {
/*  90 */           this._documentation[b] = DocumentationDocument.Factory.parse(str).getDocumentation();
/*     */         
/*     */         }
/*  93 */         catch (XmlException xmlException) {
/*     */ 
/*     */           
/*  96 */           this._documentation[b] = DocumentationDocument.Factory.newInstance().getDocumentation();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 101 */     return (XmlObject[])this._documentation;
/*     */   }
/*     */   
/*     */   public SchemaAnnotation.Attribute[] getAttributes() {
/* 105 */     return this._attributes;
/*     */   }
/*     */   public int getComponentType() {
/* 108 */     return 8;
/*     */   }
/*     */   public SchemaTypeSystem getTypeSystem() {
/* 111 */     return (this._container != null) ? this._container.getTypeSystem() : null;
/*     */   }
/*     */   SchemaContainer getContainer() {
/* 114 */     return this._container;
/*     */   }
/*     */   public b getName() {
/* 117 */     return null;
/*     */   }
/*     */   public SchemaComponent.Ref getComponentRef() {
/* 120 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static SchemaAnnotationImpl getAnnotation(SchemaContainer paramSchemaContainer, Annotated paramAnnotated) {
/* 125 */     AnnotationDocument.Annotation annotation = paramAnnotated.getAnnotation();
/*     */     
/* 127 */     return getAnnotation(paramSchemaContainer, (XmlObject)paramAnnotated, annotation);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SchemaAnnotationImpl getAnnotation(SchemaContainer paramSchemaContainer, XmlObject paramXmlObject, AnnotationDocument.Annotation paramAnnotation) {
/* 134 */     if (StscState.get().noAnn()) {
/* 135 */       return null;
/*     */     }
/* 137 */     SchemaAnnotationImpl schemaAnnotationImpl = new SchemaAnnotationImpl(paramSchemaContainer);
/*     */     
/* 139 */     ArrayList arrayList = new ArrayList(2);
/* 140 */     addNoSchemaAttributes(paramXmlObject, arrayList);
/* 141 */     if (paramAnnotation == null) {
/*     */       
/* 143 */       if (arrayList.size() == 0) {
/* 144 */         return null;
/*     */       }
/*     */       
/* 147 */       schemaAnnotationImpl._appInfo = new AppinfoDocument.Appinfo[0];
/* 148 */       schemaAnnotationImpl._documentation = new DocumentationDocument.Documentation[0];
/*     */     }
/*     */     else {
/*     */       
/* 152 */       schemaAnnotationImpl._appInfo = paramAnnotation.getAppinfoArray();
/* 153 */       schemaAnnotationImpl._documentation = paramAnnotation.getDocumentationArray();
/*     */       
/* 155 */       addNoSchemaAttributes((XmlObject)paramAnnotation, arrayList);
/*     */     } 
/*     */     
/* 158 */     schemaAnnotationImpl._attributes = (SchemaAnnotation.Attribute[])arrayList.toArray((Object[])new AttributeImpl[arrayList.size()]);
/*     */     
/* 160 */     return schemaAnnotationImpl;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void addNoSchemaAttributes(XmlObject paramXmlObject, List paramList) {
/* 165 */     XmlCursor xmlCursor = paramXmlObject.newCursor();
/* 166 */     boolean bool = xmlCursor.toFirstAttribute();
/* 167 */     while (bool) {
/*     */       
/* 169 */       b b = xmlCursor.getName();
/* 170 */       String str = b.getNamespaceURI();
/* 171 */       if (!"".equals(str) && !"http://www.w3.org/2001/XMLSchema".equals(str)) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 176 */         String str3, str1 = xmlCursor.getTextValue();
/*     */ 
/*     */         
/* 179 */         if (str1.indexOf(':') > 0) {
/* 180 */           str3 = str1.substring(0, str1.indexOf(':'));
/*     */         } else {
/* 182 */           str3 = "";
/* 183 */         }  xmlCursor.push();
/* 184 */         xmlCursor.toParent();
/* 185 */         String str2 = xmlCursor.namespaceForPrefix(str3);
/* 186 */         xmlCursor.pop();
/* 187 */         paramList.add(new AttributeImpl(b, str1, str2));
/*     */       } 
/* 189 */       bool = xmlCursor.toNextAttribute();
/*     */     } 
/* 191 */     xmlCursor.dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   private SchemaAnnotationImpl(SchemaContainer paramSchemaContainer) {
/* 196 */     this._container = paramSchemaContainer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   SchemaAnnotationImpl(SchemaContainer paramSchemaContainer, String[] paramArrayOfString1, String[] paramArrayOfString2, SchemaAnnotation.Attribute[] paramArrayOfAttribute) {
/* 203 */     this._container = paramSchemaContainer;
/* 204 */     this._appInfoAsXml = paramArrayOfString1;
/* 205 */     this._documentationAsXml = paramArrayOfString2;
/* 206 */     this._attributes = paramArrayOfAttribute;
/*     */   }
/*     */   
/*     */   static class AttributeImpl
/*     */     implements SchemaAnnotation.Attribute
/*     */   {
/*     */     private b _name;
/*     */     private String _value;
/*     */     private String _valueUri;
/*     */     
/*     */     AttributeImpl(b param1b, String param1String1, String param1String2) {
/* 217 */       this._name = param1b;
/* 218 */       this._value = param1String1;
/* 219 */       this._valueUri = param1String2;
/*     */     }
/*     */     
/*     */     public b getName() {
/* 223 */       return this._name;
/*     */     }
/*     */     public String getValue() {
/* 226 */       return this._value;
/*     */     }
/*     */     public String getValueUri() {
/* 229 */       return this._valueUri;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\SchemaAnnotationImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */