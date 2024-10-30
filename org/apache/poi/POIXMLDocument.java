/*     */ package org.apache.poi;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.openxml4j.opc.PackageAccess;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
/*     */ import org.apache.poi.poifs.filesystem.DocumentFactoryHelper;
/*     */ import org.apache.xmlbeans.impl.common.SystemCache;
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
/*     */ public abstract class POIXMLDocument
/*     */   extends POIXMLDocumentPart
/*     */   implements Closeable
/*     */ {
/*     */   public static final String DOCUMENT_CREATOR = "Apache POI";
/*     */   public static final String OLE_OBJECT_REL_TYPE = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/oleObject";
/*     */   public static final String PACK_OBJECT_REL_TYPE = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/package";
/*     */   private OPCPackage pkg;
/*     */   private POIXMLProperties properties;
/*     */   
/*     */   protected POIXMLDocument(OPCPackage paramOPCPackage) {
/*  62 */     super(paramOPCPackage);
/*  63 */     init(paramOPCPackage);
/*     */   }
/*     */   
/*     */   protected POIXMLDocument(OPCPackage paramOPCPackage, String paramString) {
/*  67 */     super(paramOPCPackage, paramString);
/*  68 */     init(paramOPCPackage);
/*     */   }
/*     */   
/*     */   private void init(OPCPackage paramOPCPackage) {
/*  72 */     this.pkg = paramOPCPackage;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  77 */     SystemCache.get().setSaxLoader(null);
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
/*     */   public static OPCPackage openPackage(String paramString) throws IOException {
/*     */     try {
/*  90 */       return OPCPackage.open(paramString);
/*  91 */     } catch (InvalidFormatException invalidFormatException) {
/*  92 */       throw new IOException(invalidFormatException.toString(), invalidFormatException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OPCPackage getPackage() {
/* 102 */     return this.pkg;
/*     */   }
/*     */   
/*     */   protected PackagePart getCorePart() {
/* 106 */     return getPackagePart();
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
/*     */   protected PackagePart[] getRelatedByType(String paramString) throws InvalidFormatException {
/* 125 */     PackageRelationshipCollection packageRelationshipCollection = getPackagePart().getRelationshipsByType(paramString);
/*     */ 
/*     */     
/* 128 */     PackagePart[] arrayOfPackagePart = new PackagePart[packageRelationshipCollection.size()];
/* 129 */     byte b = 0;
/* 130 */     for (PackageRelationship packageRelationship : packageRelationshipCollection) {
/* 131 */       arrayOfPackagePart[b] = getPackagePart().getRelatedPart(packageRelationship);
/* 132 */       b++;
/*     */     } 
/* 134 */     return arrayOfPackagePart;
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
/*     */   @Deprecated
/*     */   public static boolean hasOOXMLHeader(InputStream paramInputStream) throws IOException {
/* 154 */     return DocumentFactoryHelper.hasOOXMLHeader(paramInputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POIXMLProperties getProperties() {
/* 164 */     if (this.properties == null) {
/*     */       try {
/* 166 */         this.properties = new POIXMLProperties(this.pkg);
/* 167 */       } catch (Exception exception) {
/* 168 */         throw new POIXMLException(exception);
/*     */       } 
/*     */     }
/* 171 */     return this.properties;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract List<PackagePart> getAllEmbedds() throws OpenXML4JException;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void load(POIXMLFactory paramPOIXMLFactory) throws IOException {
/* 184 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*     */     try {
/* 186 */       read(paramPOIXMLFactory, (Map)hashMap);
/* 187 */     } catch (OpenXML4JException openXML4JException) {
/* 188 */       throw new POIXMLException(openXML4JException);
/*     */     } 
/* 190 */     onDocumentRead();
/* 191 */     hashMap.clear();
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
/*     */   public void close() throws IOException {
/* 206 */     if (this.pkg != null) {
/* 207 */       if (this.pkg.getPackageAccess() == PackageAccess.READ) {
/* 208 */         this.pkg.revert();
/*     */       } else {
/* 210 */         this.pkg.close();
/*     */       } 
/* 212 */       this.pkg = null;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(OutputStream paramOutputStream) throws IOException {
/* 234 */     OPCPackage oPCPackage = getPackage();
/* 235 */     if (oPCPackage == null) {
/* 236 */       throw new IOException("Cannot write data, document seems to have been closed already");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 241 */     HashSet<PackagePart> hashSet = new HashSet();
/* 242 */     onSave(hashSet);
/* 243 */     hashSet.clear();
/*     */ 
/*     */     
/* 246 */     getProperties().commit();
/*     */     
/* 248 */     oPCPackage.save(paramOutputStream);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\POIXMLDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */