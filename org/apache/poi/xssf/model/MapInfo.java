/*     */ package org.apache.poi.xssf.model;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.xssf.usermodel.XSSFMap;
/*     */ import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMap;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSchema;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.MapInfoDocument;
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
/*     */ public class MapInfo
/*     */   extends POIXMLDocumentPart
/*     */ {
/*     */   private CTMapInfo mapInfo;
/*     */   private Map<Integer, XSSFMap> maps;
/*     */   
/*     */   public MapInfo() {
/*  60 */     this.mapInfo = CTMapInfo.Factory.newInstance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MapInfo(PackagePart paramPackagePart) throws IOException {
/*  68 */     super(paramPackagePart);
/*  69 */     readFrom(paramPackagePart.getInputStream());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MapInfo(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException {
/*  76 */     this(paramPackagePart);
/*     */   }
/*     */   
/*     */   public void readFrom(InputStream paramInputStream) throws IOException {
/*     */     try {
/*  81 */       MapInfoDocument mapInfoDocument = MapInfoDocument.Factory.parse(paramInputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*  82 */       this.mapInfo = mapInfoDocument.getMapInfo();
/*     */       
/*  84 */       this.maps = new HashMap<Integer, XSSFMap>();
/*  85 */       for (CTMap cTMap : this.mapInfo.getMapArray()) {
/*  86 */         this.maps.put(Integer.valueOf((int)cTMap.getID()), new XSSFMap(cTMap, this));
/*     */       }
/*     */     }
/*  89 */     catch (XmlException xmlException) {
/*  90 */       throw new IOException(xmlException.getLocalizedMessage());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFWorkbook getWorkbook() {
/* 100 */     return (XSSFWorkbook)getParent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CTMapInfo getCTMapInfo() {
/* 108 */     return this.mapInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CTSchema getCTSchemaById(String paramString) {
/* 118 */     CTSchema cTSchema = null;
/*     */     
/* 120 */     for (CTSchema cTSchema1 : this.mapInfo.getSchemaArray()) {
/* 121 */       if (cTSchema1.getID().equals(paramString)) {
/* 122 */         cTSchema = cTSchema1;
/*     */         break;
/*     */       } 
/*     */     } 
/* 126 */     return cTSchema;
/*     */   }
/*     */ 
/*     */   
/*     */   public XSSFMap getXSSFMapById(int paramInt) {
/* 131 */     return this.maps.get(Integer.valueOf(paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   public XSSFMap getXSSFMapByName(String paramString) {
/* 136 */     XSSFMap xSSFMap = null;
/*     */     
/* 138 */     for (XSSFMap xSSFMap1 : this.maps.values()) {
/* 139 */       if (xSSFMap1.getCtMap().getName() != null && xSSFMap1.getCtMap().getName().equals(paramString)) {
/* 140 */         xSSFMap = xSSFMap1;
/*     */       }
/*     */     } 
/*     */     
/* 144 */     return xSSFMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<XSSFMap> getAllXSSFMaps() {
/* 152 */     return this.maps.values();
/*     */   }
/*     */   
/*     */   protected void writeTo(OutputStream paramOutputStream) throws IOException {
/* 156 */     MapInfoDocument mapInfoDocument = MapInfoDocument.Factory.newInstance();
/* 157 */     mapInfoDocument.setMapInfo(this.mapInfo);
/* 158 */     mapInfoDocument.save(paramOutputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void commit() throws IOException {
/* 163 */     PackagePart packagePart = getPackagePart();
/* 164 */     OutputStream outputStream = packagePart.getOutputStream();
/* 165 */     writeTo(outputStream);
/* 166 */     outputStream.close();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\model\MapInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */