/*     */ package org.apache.poi.openxml4j.opc;
/*     */ 
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
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
/*     */ public final class PackageRelationship
/*     */ {
/*     */   private static URI containerRelationshipPart;
/*     */   public static final String ID_ATTRIBUTE_NAME = "Id";
/*     */   public static final String RELATIONSHIPS_TAG_NAME = "Relationships";
/*     */   public static final String RELATIONSHIP_TAG_NAME = "Relationship";
/*     */   public static final String TARGET_ATTRIBUTE_NAME = "Target";
/*     */   public static final String TARGET_MODE_ATTRIBUTE_NAME = "TargetMode";
/*     */   public static final String TYPE_ATTRIBUTE_NAME = "Type";
/*     */   private String id;
/*     */   private OPCPackage container;
/*     */   private String relationshipType;
/*     */   private PackagePart source;
/*     */   private TargetMode targetMode;
/*     */   private URI targetUri;
/*     */   
/*     */   static {
/*     */     try {
/*  35 */       containerRelationshipPart = new URI("/_rels/.rels");
/*  36 */     } catch (URISyntaxException uRISyntaxException) {}
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
/*     */   public PackageRelationship(OPCPackage paramOPCPackage, PackagePart paramPackagePart, URI paramURI, TargetMode paramTargetMode, String paramString1, String paramString2) {
/* 100 */     if (paramOPCPackage == null)
/* 101 */       throw new IllegalArgumentException("pkg"); 
/* 102 */     if (paramURI == null)
/* 103 */       throw new IllegalArgumentException("targetUri"); 
/* 104 */     if (paramString1 == null)
/* 105 */       throw new IllegalArgumentException("relationshipType"); 
/* 106 */     if (paramString2 == null) {
/* 107 */       throw new IllegalArgumentException("id");
/*     */     }
/* 109 */     this.container = paramOPCPackage;
/* 110 */     this.source = paramPackagePart;
/* 111 */     this.targetUri = paramURI;
/* 112 */     this.targetMode = paramTargetMode;
/* 113 */     this.relationshipType = paramString1;
/* 114 */     this.id = paramString2;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 119 */     if (!(paramObject instanceof PackageRelationship)) {
/* 120 */       return false;
/*     */     }
/* 122 */     PackageRelationship packageRelationship = (PackageRelationship)paramObject;
/* 123 */     return (this.id.equals(packageRelationship.id) && this.relationshipType.equals(packageRelationship.relationshipType) && (packageRelationship.source == null || packageRelationship.source.equals(this.source)) && this.targetMode == packageRelationship.targetMode && this.targetUri.equals(packageRelationship.targetUri));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 132 */     return this.id.hashCode() + this.relationshipType.hashCode() + ((this.source == null) ? 0 : this.source.hashCode()) + this.targetMode.hashCode() + this.targetUri.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static URI getContainerPartRelationship() {
/* 142 */     return containerRelationshipPart;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OPCPackage getPackage() {
/* 149 */     return this.container;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getId() {
/* 156 */     return this.id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRelationshipType() {
/* 163 */     return this.relationshipType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PackagePart getSource() {
/* 170 */     return this.source;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URI getSourceURI() {
/* 178 */     if (this.source == null) {
/* 179 */       return PackagingURIHelper.PACKAGE_ROOT_URI;
/*     */     }
/* 181 */     return this.source._partName.getURI();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TargetMode getTargetMode() {
/* 188 */     return this.targetMode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URI getTargetURI() {
/* 197 */     if (this.targetMode == TargetMode.EXTERNAL) {
/* 198 */       return this.targetUri;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 204 */     if (!this.targetUri.toASCIIString().startsWith("/"))
/*     */     {
/* 206 */       return PackagingURIHelper.resolvePartUri(getSourceURI(), this.targetUri);
/*     */     }
/* 208 */     return this.targetUri;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 213 */     StringBuilder stringBuilder = new StringBuilder();
/* 214 */     stringBuilder.append((this.id == null) ? "id=null" : ("id=" + this.id));
/* 215 */     stringBuilder.append((this.container == null) ? " - container=null" : (" - container=" + this.container.toString()));
/*     */     
/* 217 */     stringBuilder.append((this.relationshipType == null) ? " - relationshipType=null" : (" - relationshipType=" + this.relationshipType));
/*     */     
/* 219 */     stringBuilder.append((this.source == null) ? " - source=null" : (" - source=" + getSourceURI().toASCIIString()));
/*     */     
/* 221 */     stringBuilder.append((this.targetUri == null) ? " - target=null" : (" - target=" + getTargetURI().toASCIIString()));
/*     */     
/* 223 */     stringBuilder.append((this.targetMode == null) ? ",targetMode=null" : (",targetMode=" + this.targetMode.toString()));
/*     */     
/* 225 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\PackageRelationship.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */