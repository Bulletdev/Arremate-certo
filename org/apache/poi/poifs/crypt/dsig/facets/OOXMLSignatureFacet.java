/*     */ package org.apache.poi.poifs.crypt.dsig.facets;
/*     */ 
/*     */ import com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1;
/*     */ import com.microsoft.schemas.office.x2006.digsig.SignatureInfoV1Document;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import javax.xml.crypto.XMLStructure;
/*     */ import javax.xml.crypto.dom.DOMStructure;
/*     */ import javax.xml.crypto.dsig.Manifest;
/*     */ import javax.xml.crypto.dsig.Reference;
/*     */ import javax.xml.crypto.dsig.SignatureProperties;
/*     */ import javax.xml.crypto.dsig.SignatureProperty;
/*     */ import javax.xml.crypto.dsig.Transform;
/*     */ import javax.xml.crypto.dsig.XMLObject;
/*     */ import javax.xml.crypto.dsig.XMLSignatureException;
/*     */ import javax.xml.crypto.dsig.spec.TransformParameterSpec;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackagePartName;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
/*     */ import org.apache.poi.openxml4j.opc.PackagingURIHelper;
/*     */ import org.apache.poi.openxml4j.opc.TargetMode;
/*     */ import org.apache.poi.poifs.crypt.dsig.services.RelationshipTransformService;
/*     */ import org.apache.poi.util.LocaleUtil;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime;
/*     */ import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.SignatureTimeDocument;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
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
/*     */ public class OOXMLSignatureFacet
/*     */   extends SignatureFacet
/*     */ {
/*  79 */   private static final POILogger LOG = POILogFactory.getLogger(OOXMLSignatureFacet.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void preSign(Document paramDocument, List<Reference> paramList, List<XMLObject> paramList1) throws XMLSignatureException {
/*  87 */     LOG.log(1, new Object[] { "pre sign" });
/*  88 */     addManifestObject(paramDocument, paramList, paramList1);
/*  89 */     addSignatureInfo(paramDocument, paramList, paramList1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addManifestObject(Document paramDocument, List<Reference> paramList, List<XMLObject> paramList1) throws XMLSignatureException {
/*  98 */     ArrayList<Reference> arrayList = new ArrayList();
/*  99 */     addManifestReferences(arrayList);
/* 100 */     Manifest manifest = getSignatureFactory().newManifest(arrayList);
/*     */     
/* 102 */     String str = "idPackageObject";
/* 103 */     ArrayList<Manifest> arrayList1 = new ArrayList();
/* 104 */     arrayList1.add(manifest);
/*     */     
/* 106 */     addSignatureTime(paramDocument, (List)arrayList1);
/*     */     
/* 108 */     XMLObject xMLObject = getSignatureFactory().newXMLObject(arrayList1, str, null, null);
/* 109 */     paramList1.add(xMLObject);
/*     */     
/* 111 */     Reference reference = newReference("#" + str, null, "http://www.w3.org/2000/09/xmldsig#Object", null, null);
/* 112 */     paramList.add(reference);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addManifestReferences(List<Reference> paramList) throws XMLSignatureException {
/* 119 */     OPCPackage oPCPackage = this.signatureConfig.getOpcPackage();
/* 120 */     ArrayList arrayList = oPCPackage.getPartsByContentType("application/vnd.openxmlformats-package.relationships+xml");
/*     */     
/* 122 */     HashSet<String> hashSet = new HashSet();
/* 123 */     for (PackagePart packagePart : arrayList) {
/* 124 */       PackageRelationshipCollection packageRelationshipCollection; String str = packagePart.getPartName().getName().replaceFirst("(.*)/_rels/.*", "$1");
/*     */ 
/*     */       
/*     */       try {
/* 128 */         packageRelationshipCollection = new PackageRelationshipCollection(oPCPackage);
/* 129 */         packageRelationshipCollection.parseRelationshipsPart(packagePart);
/* 130 */       } catch (InvalidFormatException invalidFormatException) {
/* 131 */         throw new XMLSignatureException("Invalid relationship descriptor: " + packagePart.getPartName().getName(), invalidFormatException);
/*     */       } 
/*     */       
/* 134 */       RelationshipTransformService.RelationshipTransformParameterSpec relationshipTransformParameterSpec = new RelationshipTransformService.RelationshipTransformParameterSpec();
/* 135 */       for (PackageRelationship packageRelationship : packageRelationshipCollection) {
/* 136 */         String str3, str1 = packageRelationship.getRelationshipType();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 143 */         if (TargetMode.EXTERNAL == packageRelationship.getTargetMode()) {
/*     */           continue;
/*     */         }
/*     */         
/* 147 */         if (!isSignedRelationship(str1))
/*     */           continue; 
/* 149 */         relationshipTransformParameterSpec.addRelationshipReference(packageRelationship.getId());
/*     */ 
/*     */         
/* 152 */         String str2 = packageRelationship.getTargetURI().toString();
/* 153 */         if (!str2.startsWith(str)) {
/* 154 */           str2 = str + str2;
/*     */         }
/*     */         try {
/* 157 */           str2 = (new URI(str2)).normalize().getPath().replace('\\', '/');
/* 158 */           LOG.log(1, new Object[] { "part name: " + str2 });
/* 159 */         } catch (URISyntaxException uRISyntaxException) {
/* 160 */           throw new XMLSignatureException(uRISyntaxException);
/*     */         } 
/*     */ 
/*     */         
/*     */         try {
/* 165 */           PackagePartName packagePartName = PackagingURIHelper.createPartName(str2);
/* 166 */           PackagePart packagePart1 = oPCPackage.getPart(packagePartName);
/* 167 */           str3 = packagePart1.getContentType();
/* 168 */         } catch (InvalidFormatException invalidFormatException) {
/* 169 */           throw new XMLSignatureException(invalidFormatException);
/*     */         } 
/*     */         
/* 172 */         if (str1.endsWith("customXml") && !str3.equals("inkml+xml") && !str3.equals("text/xml")) {
/*     */           
/* 174 */           LOG.log(1, new Object[] { "skipping customXml with content type: " + str3 });
/*     */           
/*     */           continue;
/*     */         } 
/* 178 */         if (!hashSet.contains(str2)) {
/*     */           
/* 180 */           String str4 = str2 + "?ContentType=" + str3;
/* 181 */           Reference reference = newReference(str4, null, null, null, null);
/* 182 */           paramList.add(reference);
/* 183 */           hashSet.add(str2);
/*     */         } 
/*     */       } 
/*     */       
/* 187 */       if (relationshipTransformParameterSpec.hasSourceIds()) {
/* 188 */         ArrayList<Transform> arrayList1 = new ArrayList();
/* 189 */         arrayList1.add(newTransform("http://schemas.openxmlformats.org/package/2006/RelationshipTransform", (TransformParameterSpec)relationshipTransformParameterSpec));
/* 190 */         arrayList1.add(newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315"));
/* 191 */         String str1 = packagePart.getPartName().getName() + "?ContentType=application/vnd.openxmlformats-package.relationships+xml";
/*     */         
/* 193 */         Reference reference = newReference(str1, arrayList1, null, null, null);
/* 194 */         paramList.add(reference);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addSignatureTime(Document paramDocument, List<XMLStructure> paramList) {
/* 204 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ROOT);
/* 205 */     simpleDateFormat.setTimeZone(LocaleUtil.TIMEZONE_UTC);
/* 206 */     String str = simpleDateFormat.format(this.signatureConfig.getExecutionTime());
/* 207 */     LOG.log(1, new Object[] { "now: " + str });
/*     */     
/* 209 */     SignatureTimeDocument signatureTimeDocument = SignatureTimeDocument.Factory.newInstance();
/* 210 */     CTSignatureTime cTSignatureTime = signatureTimeDocument.addNewSignatureTime();
/* 211 */     cTSignatureTime.setFormat("YYYY-MM-DDThh:mm:ssTZD");
/* 212 */     cTSignatureTime.setValue(str);
/*     */     
/* 214 */     Element element = (Element)paramDocument.importNode(cTSignatureTime.getDomNode(), true);
/* 215 */     ArrayList<DOMStructure> arrayList = new ArrayList();
/* 216 */     arrayList.add(new DOMStructure(element));
/* 217 */     SignatureProperty signatureProperty = getSignatureFactory().newSignatureProperty(arrayList, "#" + this.signatureConfig.getPackageSignatureId(), "idSignatureTime");
/*     */ 
/*     */     
/* 220 */     ArrayList<SignatureProperty> arrayList1 = new ArrayList();
/* 221 */     arrayList1.add(signatureProperty);
/* 222 */     SignatureProperties signatureProperties = getSignatureFactory().newSignatureProperties(arrayList1, "id-signature-time-" + this.signatureConfig.getExecutionTime());
/*     */ 
/*     */     
/* 225 */     paramList.add(signatureProperties);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addSignatureInfo(Document paramDocument, List<Reference> paramList, List<XMLObject> paramList1) throws XMLSignatureException {
/* 232 */     ArrayList<SignatureProperties> arrayList = new ArrayList();
/*     */     
/* 234 */     SignatureInfoV1Document signatureInfoV1Document = SignatureInfoV1Document.Factory.newInstance();
/* 235 */     CTSignatureInfoV1 cTSignatureInfoV1 = signatureInfoV1Document.addNewSignatureInfoV1();
/* 236 */     cTSignatureInfoV1.setManifestHashAlgorithm(this.signatureConfig.getDigestMethodUri());
/* 237 */     Element element = (Element)paramDocument.importNode(cTSignatureInfoV1.getDomNode(), true);
/* 238 */     element.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", "http://schemas.microsoft.com/office/2006/digsig");
/*     */     
/* 240 */     ArrayList<DOMStructure> arrayList1 = new ArrayList();
/* 241 */     arrayList1.add(new DOMStructure(element));
/* 242 */     SignatureProperty signatureProperty = getSignatureFactory().newSignatureProperty(arrayList1, "#" + this.signatureConfig.getPackageSignatureId(), "idOfficeV1Details");
/*     */ 
/*     */ 
/*     */     
/* 246 */     ArrayList<SignatureProperty> arrayList2 = new ArrayList();
/* 247 */     arrayList2.add(signatureProperty);
/* 248 */     SignatureProperties signatureProperties = getSignatureFactory().newSignatureProperties(arrayList2, null);
/*     */     
/* 250 */     arrayList.add(signatureProperties);
/*     */     
/* 252 */     String str = "idOfficeObject";
/* 253 */     paramList1.add(getSignatureFactory().newXMLObject(arrayList, str, null, null));
/*     */     
/* 255 */     Reference reference = newReference("#" + str, null, "http://www.w3.org/2000/09/xmldsig#Object", null, null);
/* 256 */     paramList.add(reference);
/*     */   }
/*     */   
/*     */   protected static String getRelationshipReferenceURI(String paramString) {
/* 260 */     return "/" + paramString + "?ContentType=application/vnd.openxmlformats-package.relationships+xml";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static String getResourceReferenceURI(String paramString1, String paramString2) {
/* 266 */     return "/" + paramString1 + "?ContentType=" + paramString2;
/*     */   }
/*     */   
/*     */   protected static boolean isSignedRelationship(String paramString) {
/* 270 */     LOG.log(1, new Object[] { "relationship type: " + paramString });
/* 271 */     for (String str : signed) {
/* 272 */       if (paramString.endsWith(str)) {
/* 273 */         return true;
/*     */       }
/*     */     } 
/* 276 */     if (paramString.endsWith("customXml")) {
/* 277 */       LOG.log(1, new Object[] { "customXml relationship type" });
/* 278 */       return true;
/*     */     } 
/* 280 */     return false;
/*     */   }
/*     */   
/* 283 */   public static final String[] contentTypes = new String[] { "application/vnd.openxmlformats-officedocument.wordprocessingml.document.main+xml", "application/vnd.openxmlformats-officedocument.wordprocessingml.fontTable+xml", "application/vnd.openxmlformats-officedocument.wordprocessingml.settings+xml", "application/vnd.openxmlformats-officedocument.wordprocessingml.styles+xml", "application/vnd.openxmlformats-officedocument.theme+xml", "application/vnd.openxmlformats-officedocument.wordprocessingml.webSettings+xml", "application/vnd.openxmlformats-officedocument.wordprocessingml.numbering+xml", "application/vnd.ms-word.stylesWithEffects+xml", "application/vnd.openxmlformats-officedocument.spreadsheetml.sharedStrings+xml", "application/vnd.openxmlformats-officedocument.spreadsheetml.worksheet+xml", "application/vnd.openxmlformats-officedocument.spreadsheetml.styles+xml", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet.main+xml", "application/vnd.openxmlformats-officedocument.presentationml.presentation.main+xml", "application/vnd.openxmlformats-officedocument.presentationml.slideLayout+xml", "application/vnd.openxmlformats-officedocument.presentationml.slideMaster+xml", "application/vnd.openxmlformats-officedocument.presentationml.slide+xml", "application/vnd.openxmlformats-officedocument.presentationml.tableStyles+xml", "application/vnd.openxmlformats-officedocument.presentationml.viewProps+xml", "application/vnd.openxmlformats-officedocument.presentationml.presProps+xml" };
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
/* 327 */   public static final String[] signed = new String[] { "powerPivotData", "activeXControlBinary", "attachedToolbars", "connectorXml", "downRev", "functionPrototypes", "graphicFrameDoc", "groupShapeXml", "ink", "keyMapCustomizations", "legacyDiagramText", "legacyDocTextInfo", "officeDocument", "pictureXml", "shapeXml", "smartTags", "ui/altText", "ui/buttonSize", "ui/controlID", "ui/description", "ui/enabled", "ui/extensibility", "ui/helperText", "ui/imageID", "ui/imageMso", "ui/keyTip", "ui/label", "ui/lcid", "ui/loud", "ui/pressed", "ui/progID", "ui/ribbonID", "ui/showImage", "ui/showLabel", "ui/supertip", "ui/target", "ui/text", "ui/title", "ui/tooltip", "ui/userCustomization", "ui/visible", "userXmlData", "vbaProject", "wordVbaData", "wsSortMap", "xlBinaryIndex", "xlExternalLinkPath/xlAlternateStartup", "xlExternalLinkPath/xlLibrary", "xlExternalLinkPath/xlPathMissing", "xlExternalLinkPath/xlStartup", "xlIntlMacrosheet", "xlMacrosheet", "customData", "diagramDrawing", "hdphoto", "inkXml", "media", "slicer", "slicerCache", "stylesWithEffects", "ui/extensibility", "chartColorStyle", "chartLayout", "chartStyle", "dictionary", "timeline", "timelineCache", "aFChunk", "attachedTemplate", "audio", "calcChain", "chart", "chartsheet", "chartUserShapes", "commentAuthors", "comments", "connections", "control", "customProperty", "customXml", "diagramColors", "diagramData", "diagramLayout", "diagramQuickStyle", "dialogsheet", "drawing", "endnotes", "externalLink", "externalLinkPath", "font", "fontTable", "footer", "footnotes", "glossaryDocument", "handoutMaster", "header", "hyperlink", "image", "mailMergeHeaderSource", "mailMergeRecipientData", "mailMergeSource", "notesMaster", "notesSlide", "numbering", "officeDocument", "oleObject", "package", "pivotCacheDefinition", "pivotCacheRecords", "pivotTable", "presProps", "printerSettings", "queryTable", "recipientData", "settings", "sharedStrings", "sheetMetadata", "slide", "slideLayout", "slideMaster", "slideUpdateInfo", "slideUpdateUrl", "styles", "table", "tableSingleCells", "tableStyles", "tags", "theme", "themeOverride", "transform", "video", "viewProps", "volatileDependencies", "webSettings", "worksheet", "xmlMaps", "ctrlProp", "customData", "diagram", "diagramColorsHeader", "diagramLayoutHeader", "diagramQuickStyleHeader", "documentParts", "slicer", "slicerCache", "vmlDrawing" };
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\dsig\facets\OOXMLSignatureFacet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */