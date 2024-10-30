/*     */ package org.apache.xmlbeans.impl.schema;
/*     */ 
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.Set;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaComponent;
/*     */ import org.apache.xmlbeans.SchemaGlobalElement;
/*     */ import org.apache.xmlbeans.SchemaTypeSystem;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SchemaGlobalElementImpl
/*     */   extends SchemaLocalElementImpl
/*     */   implements SchemaGlobalElement
/*     */ {
/*  30 */   private Set _sgMembers = new LinkedHashSet();
/*  31 */   private static final b[] _namearray = new b[0];
/*     */   
/*     */   private boolean _finalExt;
/*     */   
/*     */   private boolean _finalRest;
/*     */   
/*     */   private SchemaContainer _container;
/*     */   
/*     */   private String _filename;
/*     */   
/*     */   private String _parseTNS;
/*     */   
/*     */   private boolean _chameleon;
/*     */   private SchemaGlobalElement.Ref _sg;
/*     */   private SchemaGlobalElement.Ref _selfref;
/*     */   
/*     */   public SchemaTypeSystem getTypeSystem() {
/*  48 */     return this._container.getTypeSystem();
/*     */   }
/*     */ 
/*     */   
/*     */   SchemaContainer getContainer() {
/*  53 */     return this._container;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSourceName() {
/*  58 */     return this._filename;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFilename(String paramString) {
/*  63 */     this._filename = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   void setFinal(boolean paramBoolean1, boolean paramBoolean2) {
/*  68 */     mutate(); this._finalExt = paramBoolean1; this._finalRest = paramBoolean2;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getComponentType() {
/*  73 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaGlobalElement substitutionGroup() {
/*  78 */     return (this._sg == null) ? null : this._sg.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSubstitutionGroup(SchemaGlobalElement.Ref paramRef) {
/*  83 */     this._sg = paramRef;
/*     */   }
/*     */ 
/*     */   
/*     */   public b[] substitutionGroupMembers() {
/*  88 */     return (b[])this._sgMembers.toArray((Object[])_namearray);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addSubstitutionGroupMember(b paramb) {
/*  93 */     mutate(); this._sgMembers.add(paramb);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean finalExtension() {
/*  99 */     return this._finalExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean finalRestriction() {
/* 104 */     return this._finalRest;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setParseContext(XmlObject paramXmlObject, String paramString, boolean paramBoolean) {
/* 109 */     this._parseObject = paramXmlObject;
/* 110 */     this._parseTNS = paramString;
/* 111 */     this._chameleon = paramBoolean;
/*     */   }
/*     */   
/*     */   public XmlObject getParseObject() {
/* 115 */     return this._parseObject;
/*     */   }
/*     */   public String getTargetNamespace() {
/* 118 */     return this._parseTNS;
/*     */   }
/*     */   public String getChameleonNamespace() {
/* 121 */     return this._chameleon ? this._parseTNS : null;
/*     */   } public SchemaGlobalElementImpl(SchemaContainer paramSchemaContainer) {
/* 123 */     this._selfref = new SchemaGlobalElement.Ref(this);
/*     */     this._container = paramSchemaContainer;
/*     */   } public SchemaGlobalElement.Ref getRef() {
/* 126 */     return this._selfref;
/*     */   }
/*     */   public SchemaComponent.Ref getComponentRef() {
/* 129 */     return (SchemaComponent.Ref)getRef();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\SchemaGlobalElementImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */