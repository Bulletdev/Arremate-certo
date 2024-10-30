/*     */ package org.apache.poi;
/*     */ 
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
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
/*     */ public abstract class POIXMLFactory
/*     */ {
/*  31 */   private static final POILogger LOGGER = POILogFactory.getLogger(POIXMLFactory.class);
/*     */   
/*  33 */   private static final Class<?>[] PARENT_PART = new Class[] { POIXMLDocumentPart.class, PackagePart.class };
/*  34 */   private static final Class<?>[] ORPHAN_PART = new Class[] { PackagePart.class };
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
/*     */   public POIXMLDocumentPart createDocumentPart(POIXMLDocumentPart paramPOIXMLDocumentPart, PackagePart paramPackagePart) {
/*  47 */     PackageRelationship packageRelationship = getPackageRelationship(paramPOIXMLDocumentPart, paramPackagePart);
/*  48 */     POIXMLRelation pOIXMLRelation = getDescriptor(packageRelationship.getRelationshipType());
/*     */     
/*  50 */     if (pOIXMLRelation == null || pOIXMLRelation.getRelationClass() == null) {
/*  51 */       LOGGER.log(1, new Object[] { "using default POIXMLDocumentPart for " + packageRelationship.getRelationshipType() });
/*  52 */       return new POIXMLDocumentPart(paramPOIXMLDocumentPart, paramPackagePart);
/*     */     } 
/*     */     
/*  55 */     Class<? extends POIXMLDocumentPart> clazz = pOIXMLRelation.getRelationClass();
/*     */     
/*     */     try {
/*  58 */       return createDocumentPart(clazz, PARENT_PART, new Object[] { paramPOIXMLDocumentPart, paramPackagePart });
/*  59 */     } catch (NoSuchMethodException noSuchMethodException) {
/*  60 */       return createDocumentPart(clazz, ORPHAN_PART, new Object[] { paramPackagePart });
/*     */     }
/*  62 */     catch (Exception exception) {
/*  63 */       throw new POIXMLException(exception);
/*     */     } 
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
/*     */   protected abstract POIXMLDocumentPart createDocumentPart(Class<? extends POIXMLDocumentPart> paramClass, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) throws SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;
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
/*     */   protected abstract POIXMLRelation getDescriptor(String paramString);
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
/*     */   @Deprecated
/*     */   public final POIXMLDocumentPart createDocumentPart(POIXMLDocumentPart paramPOIXMLDocumentPart, PackageRelationship paramPackageRelationship, PackagePart paramPackagePart) {
/* 109 */     return createDocumentPart(paramPOIXMLDocumentPart, paramPackagePart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POIXMLDocumentPart newDocumentPart(POIXMLRelation paramPOIXMLRelation) {
/* 120 */     Class<? extends POIXMLDocumentPart> clazz = paramPOIXMLRelation.getRelationClass();
/*     */     try {
/* 122 */       return createDocumentPart(clazz, (Class<?>[])null, (Object[])null);
/* 123 */     } catch (Exception exception) {
/* 124 */       throw new POIXMLException(exception);
/*     */     } 
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
/*     */   protected PackageRelationship getPackageRelationship(POIXMLDocumentPart paramPOIXMLDocumentPart, PackagePart paramPackagePart) {
/*     */     try {
/* 142 */       String str = paramPackagePart.getPartName().getName();
/* 143 */       for (PackageRelationship packageRelationship : paramPOIXMLDocumentPart.getPackagePart().getRelationships()) {
/* 144 */         String str1 = packageRelationship.getTargetURI().toASCIIString();
/* 145 */         if (str1.equalsIgnoreCase(str)) {
/* 146 */           return packageRelationship;
/*     */         }
/*     */       } 
/* 149 */     } catch (InvalidFormatException invalidFormatException) {
/* 150 */       throw new POIXMLException("error while determining package relations", invalidFormatException);
/*     */     } 
/*     */     
/* 153 */     throw new POIXMLException("package part isn't a child of the parent document.");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\POIXMLFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */