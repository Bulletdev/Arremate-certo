/*     */ package org.apache.xmlbeans.impl.schema;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.apache.xmlbeans.SchemaAnnotation;
/*     */ import org.apache.xmlbeans.SchemaAttributeGroup;
/*     */ import org.apache.xmlbeans.SchemaComponent;
/*     */ import org.apache.xmlbeans.SchemaGlobalAttribute;
/*     */ import org.apache.xmlbeans.SchemaGlobalElement;
/*     */ import org.apache.xmlbeans.SchemaIdentityConstraint;
/*     */ import org.apache.xmlbeans.SchemaModelGroup;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SchemaTypeSystem;
/*     */ 
/*     */ class SchemaContainer
/*     */ {
/*     */   private String _namespace;
/*     */   private SchemaTypeSystem _typeSystem;
/*     */   boolean _immutable;
/*     */   private List _globalElements;
/*     */   private List _globalAttributes;
/*     */   private List _modelGroups;
/*     */   private List _redefinedModelGroups;
/*     */   private List _attributeGroups;
/*     */   private List _redefinedAttributeGroups;
/*     */   private List _globalTypes;
/*     */   private List _redefinedGlobalTypes;
/*     */   private List _documentTypes;
/*     */   private List _attributeTypes;
/*     */   private List _identityConstraints;
/*     */   private List _annotations;
/*     */   
/*     */   String getNamespace() {
/*     */     return this._namespace;
/*     */   }
/*     */   
/*     */   synchronized SchemaTypeSystem getTypeSystem() {
/*     */     return this._typeSystem;
/*     */   }
/*     */   
/*     */   synchronized void setTypeSystem(SchemaTypeSystem paramSchemaTypeSystem) {
/*     */     this._typeSystem = paramSchemaTypeSystem;
/*     */   }
/*     */   
/*     */   synchronized void setImmutable() {
/*     */     this._immutable = true;
/*     */   }
/*     */   
/*     */   synchronized void unsetImmutable() {
/*     */     this._immutable = false;
/*     */   }
/*     */   
/*     */   private void check_immutable() {
/*     */     if (this._immutable)
/*     */       throw new IllegalStateException("Cannot add components to immutable SchemaContainer"); 
/*     */   }
/*     */   
/*     */   void addGlobalElement(SchemaGlobalElement.Ref paramRef) {
/*     */     check_immutable();
/*     */     this._globalElements.add(paramRef);
/*     */   }
/*     */   
/*     */   List globalElements() {
/*     */     return getComponentList(this._globalElements);
/*     */   }
/*     */   
/*     */   void addGlobalAttribute(SchemaGlobalAttribute.Ref paramRef) {
/*     */     check_immutable();
/*     */     this._globalAttributes.add(paramRef);
/*     */   }
/*     */   
/*     */   List globalAttributes() {
/*     */     return getComponentList(this._globalAttributes);
/*     */   }
/*     */   
/*     */   void addModelGroup(SchemaModelGroup.Ref paramRef) {
/*     */     check_immutable();
/*     */     this._modelGroups.add(paramRef);
/*     */   }
/*     */   
/*     */   List modelGroups() {
/*     */     return getComponentList(this._modelGroups);
/*     */   }
/*     */   
/*     */   void addRedefinedModelGroup(SchemaModelGroup.Ref paramRef) {
/*     */     check_immutable();
/*     */     this._redefinedModelGroups.add(paramRef);
/*     */   }
/*     */   
/*     */   List redefinedModelGroups() {
/*     */     return getComponentList(this._redefinedModelGroups);
/*     */   }
/*     */   
/*     */   SchemaContainer(String paramString) {
/*  96 */     this._globalElements = new ArrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 105 */     this._globalAttributes = new ArrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     this._modelGroups = new ArrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 123 */     this._redefinedModelGroups = new ArrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 132 */     this._attributeGroups = new ArrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 141 */     this._redefinedAttributeGroups = new ArrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 150 */     this._globalTypes = new ArrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 159 */     this._redefinedGlobalTypes = new ArrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 168 */     this._documentTypes = new ArrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 177 */     this._attributeTypes = new ArrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 186 */     this._identityConstraints = new ArrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 195 */     this._annotations = new ArrayList(); this._namespace = paramString; }
/*     */   void addAttributeGroup(SchemaAttributeGroup.Ref paramRef) { check_immutable(); this._attributeGroups.add(paramRef); }
/*     */   List attributeGroups() { return getComponentList(this._attributeGroups); }
/* 198 */   void addRedefinedAttributeGroup(SchemaAttributeGroup.Ref paramRef) { check_immutable(); this._redefinedAttributeGroups.add(paramRef); } List redefinedAttributeGroups() { return getComponentList(this._redefinedAttributeGroups); } void addGlobalType(SchemaType.Ref paramRef) { check_immutable(); this._globalTypes.add(paramRef); } List globalTypes() { return getComponentList(this._globalTypes); } void addRedefinedType(SchemaType.Ref paramRef) { check_immutable(); this._redefinedGlobalTypes.add(paramRef); } void addAnnotation(SchemaAnnotation paramSchemaAnnotation) { check_immutable(); this._annotations.add(paramSchemaAnnotation); }
/*     */   List redefinedGlobalTypes() { return getComponentList(this._redefinedGlobalTypes); }
/*     */   void addDocumentType(SchemaType.Ref paramRef) { check_immutable(); this._documentTypes.add(paramRef); }
/* 201 */   List documentTypes() { return getComponentList(this._documentTypes); } void addAttributeType(SchemaType.Ref paramRef) { check_immutable(); this._attributeTypes.add(paramRef); } List attributeTypes() { return getComponentList(this._attributeTypes); } void addIdentityConstraint(SchemaIdentityConstraint.Ref paramRef) { check_immutable(); this._identityConstraints.add(paramRef); } List identityConstraints() { return getComponentList(this._identityConstraints); } List annotations() { return Collections.unmodifiableList(this._annotations); }
/*     */ 
/*     */   
/*     */   private List getComponentList(List paramList) {
/* 205 */     ArrayList arrayList = new ArrayList();
/* 206 */     for (byte b = 0; b < paramList.size(); b++)
/* 207 */       arrayList.add(((SchemaComponent.Ref)paramList.get(b)).getComponent()); 
/* 208 */     return Collections.unmodifiableList(arrayList);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\SchemaContainer.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */