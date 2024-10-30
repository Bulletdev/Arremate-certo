/*     */ package org.apache.xmlbeans.impl.tool;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
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
/*     */ public abstract class SchemaImportResolver
/*     */ {
/*     */   public abstract SchemaResource lookupResource(String paramString1, String paramString2);
/*     */   
/*     */   public abstract void reportActualNamespace(SchemaResource paramSchemaResource, String paramString);
/*     */   
/*     */   protected final void resolveImports(SchemaResource[] paramArrayOfSchemaResource) {
/*  69 */     LinkedList linkedList = new LinkedList(Arrays.asList((Object[])paramArrayOfSchemaResource));
/*  70 */     LinkedList linkedList1 = new LinkedList();
/*  71 */     HashSet hashSet = new HashSet();
/*     */ 
/*     */     
/*     */     while (true) {
/*     */       SchemaResource schemaResource;
/*     */ 
/*     */       
/*  78 */       if (!linkedList.isEmpty()) {
/*     */ 
/*     */         
/*  81 */         schemaResource = linkedList.removeFirst();
/*     */       }
/*  83 */       else if (!linkedList1.isEmpty()) {
/*     */ 
/*     */         
/*  86 */         SchemaLocator schemaLocator = linkedList1.removeFirst();
/*  87 */         schemaResource = lookupResource(schemaLocator.namespace, schemaLocator.schemaLocation);
/*  88 */         if (schemaResource == null) {
/*     */           continue;
/*     */         }
/*     */       } else {
/*     */         break;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  98 */       if (hashSet.contains(schemaResource))
/*     */         continue; 
/* 100 */       hashSet.add(schemaResource);
/*     */ 
/*     */       
/* 103 */       SchemaDocument.Schema schema = schemaResource.getSchema();
/* 104 */       if (schema == null) {
/*     */         continue;
/*     */       }
/*     */       
/* 108 */       String str1 = schema.getTargetNamespace();
/* 109 */       if (str1 == null) {
/* 110 */         str1 = "";
/*     */       }
/*     */       
/* 113 */       String str2 = schemaResource.getNamespace();
/* 114 */       if (str2 == null || !str1.equals(str2))
/*     */       {
/*     */         
/* 117 */         reportActualNamespace(schemaResource, str1);
/*     */       }
/*     */ 
/*     */       
/* 121 */       ImportDocument.Import[] arrayOfImport = schema.getImportArray();
/* 122 */       for (byte b1 = 0; b1 < arrayOfImport.length; b1++)
/*     */       {
/* 124 */         linkedList1.add(new SchemaLocator((arrayOfImport[b1].getNamespace() == null) ? "" : arrayOfImport[b1].getNamespace(), arrayOfImport[b1].getSchemaLocation()));
/*     */       }
/*     */ 
/*     */       
/* 128 */       IncludeDocument.Include[] arrayOfInclude = schema.getIncludeArray();
/* 129 */       for (byte b2 = 0; b2 < arrayOfInclude.length; b2++)
/*     */       {
/* 131 */         linkedList1.add(new SchemaLocator(null, arrayOfInclude[b2].getSchemaLocation())); } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static class SchemaLocator {
/*     */     public final String namespace;
/*     */     public final String schemaLocation;
/*     */     
/*     */     public SchemaLocator(String param1String1, String param1String2) {
/* 140 */       this.namespace = param1String1;
/* 141 */       this.schemaLocation = param1String2;
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface SchemaResource {
/*     */     SchemaDocument.Schema getSchema();
/*     */     
/*     */     String getNamespace();
/*     */     
/*     */     String getSchemaLocation();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\tool\SchemaImportResolver.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */