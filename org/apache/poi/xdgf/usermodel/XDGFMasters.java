/*     */ package org.apache.poi.xdgf.usermodel;
/*     */ 
/*     */ import com.microsoft.schemas.office.visio.x2012.main.MasterType;
/*     */ import com.microsoft.schemas.office.visio.x2012.main.MastersDocument;
/*     */ import com.microsoft.schemas.office.visio.x2012.main.MastersType;
/*     */ import java.io.IOException;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.xdgf.exceptions.XDGFException;
/*     */ import org.apache.poi.xdgf.xml.XDGFXMLDocumentPart;
/*     */ import org.apache.xmlbeans.XmlException;
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
/*     */ public class XDGFMasters
/*     */   extends XDGFXMLDocumentPart
/*     */ {
/*     */   MastersType _mastersObject;
/*  47 */   protected Map<Long, XDGFMaster> _masters = new HashMap<Long, XDGFMaster>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XDGFMasters(PackagePart paramPackagePart, XDGFDocument paramXDGFDocument) {
/*  53 */     super(paramPackagePart, paramXDGFDocument);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public XDGFMasters(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship, XDGFDocument paramXDGFDocument) {
/*  61 */     this(paramPackagePart, paramXDGFDocument);
/*     */   }
/*     */   
/*     */   @Internal
/*     */   protected MastersType getXmlObject() {
/*  66 */     return this._mastersObject;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onDocumentRead() {
/*     */     try {
/*     */       try {
/*  73 */         this._mastersObject = MastersDocument.Factory.parse(getPackagePart().getInputStream()).getMasters();
/*  74 */       } catch (XmlException xmlException) {
/*  75 */         throw new POIXMLException(xmlException);
/*  76 */       } catch (IOException iOException) {
/*  77 */         throw new POIXMLException(iOException);
/*     */       } 
/*     */       
/*  80 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*  81 */       for (MasterType masterType : this._mastersObject.getMasterArray()) {
/*  82 */         hashMap.put(masterType.getRel().getId(), masterType);
/*     */       }
/*     */ 
/*     */       
/*  86 */       for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
/*  87 */         POIXMLDocumentPart pOIXMLDocumentPart = relationPart.getDocumentPart();
/*     */         
/*  89 */         String str = relationPart.getRelationship().getId();
/*  90 */         MasterType masterType = (MasterType)hashMap.get(str);
/*     */         
/*  92 */         if (masterType == null) {
/*  93 */           throw new POIXMLException("Master relationship for " + str + " not found");
/*     */         }
/*     */         
/*  96 */         if (!(pOIXMLDocumentPart instanceof XDGFMasterContents)) {
/*  97 */           throw new POIXMLException("Unexpected masters relationship for " + str + ": " + pOIXMLDocumentPart);
/*     */         }
/*     */         
/* 100 */         XDGFMasterContents xDGFMasterContents = (XDGFMasterContents)pOIXMLDocumentPart;
/* 101 */         xDGFMasterContents.onDocumentRead();
/*     */         
/* 103 */         XDGFMaster xDGFMaster = new XDGFMaster(masterType, xDGFMasterContents, this._document);
/* 104 */         this._masters.put(Long.valueOf(xDGFMaster.getID()), xDGFMaster);
/*     */       } 
/* 106 */     } catch (POIXMLException pOIXMLException) {
/* 107 */       throw XDGFException.wrap(this, pOIXMLException);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Collection<XDGFMaster> getMastersList() {
/* 112 */     return Collections.unmodifiableCollection(this._masters.values());
/*     */   }
/*     */   
/*     */   public XDGFMaster getMasterById(long paramLong) {
/* 116 */     return this._masters.get(Long.valueOf(paramLong));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\XDGFMasters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */