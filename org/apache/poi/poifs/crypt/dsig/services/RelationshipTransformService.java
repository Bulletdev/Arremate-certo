/*     */ package org.apache.poi.poifs.crypt.dsig.services;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.security.InvalidAlgorithmParameterException;
/*     */ import java.security.Provider;
/*     */ import java.security.Security;
/*     */ import java.security.spec.AlgorithmParameterSpec;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import javax.xml.crypto.Data;
/*     */ import javax.xml.crypto.MarshalException;
/*     */ import javax.xml.crypto.OctetStreamData;
/*     */ import javax.xml.crypto.XMLCryptoContext;
/*     */ import javax.xml.crypto.XMLStructure;
/*     */ import javax.xml.crypto.dom.DOMStructure;
/*     */ import javax.xml.crypto.dsig.TransformException;
/*     */ import javax.xml.crypto.dsig.TransformService;
/*     */ import javax.xml.crypto.dsig.spec.TransformParameterSpec;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.util.XmlSort;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.f.a.a.a.i;
/*     */ import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTRelationshipReference;
/*     */ import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.RelationshipReferenceDocument;
/*     */ import org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship;
/*     */ import org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships;
/*     */ import org.openxmlformats.schemas.xpackage.x2006.relationships.RelationshipsDocument;
/*     */ import org.openxmlformats.schemas.xpackage.x2006.relationships.STTargetMode;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RelationshipTransformService
/*     */   extends TransformService
/*     */ {
/*     */   public static final String TRANSFORM_URI = "http://schemas.openxmlformats.org/package/2006/RelationshipTransform";
/*     */   private final List<String> sourceIds;
/*  84 */   private static final POILogger LOG = POILogFactory.getLogger(RelationshipTransformService.class);
/*     */ 
/*     */   
/*     */   public static class RelationshipTransformParameterSpec
/*     */     implements TransformParameterSpec
/*     */   {
/*  90 */     List<String> sourceIds = new ArrayList<String>();
/*     */     public void addRelationshipReference(String param1String) {
/*  92 */       this.sourceIds.add(param1String);
/*     */     }
/*     */     public boolean hasSourceIds() {
/*  95 */       return !this.sourceIds.isEmpty();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RelationshipTransformService() {
/* 102 */     LOG.log(1, new Object[] { "constructor" });
/* 103 */     this.sourceIds = new ArrayList<String>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static synchronized void registerDsigProvider() {
/* 114 */     String str = "POIXmlDsigProvider";
/* 115 */     if (Security.getProperty("POIXmlDsigProvider") == null) {
/* 116 */       Provider provider = new Provider("POIXmlDsigProvider", 1.0D, "POIXmlDsigProvider") {
/*     */           static final long serialVersionUID = 1L;
/*     */         };
/* 119 */       provider.put("TransformService.http://schemas.openxmlformats.org/package/2006/RelationshipTransform", RelationshipTransformService.class.getName());
/* 120 */       provider.put("TransformService.http://schemas.openxmlformats.org/package/2006/RelationshipTransform MechanismType", "DOM");
/* 121 */       Security.addProvider(provider);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(TransformParameterSpec paramTransformParameterSpec) throws InvalidAlgorithmParameterException {
/* 128 */     LOG.log(1, new Object[] { "init(params)" });
/* 129 */     if (!(paramTransformParameterSpec instanceof RelationshipTransformParameterSpec)) {
/* 130 */       throw new InvalidAlgorithmParameterException();
/*     */     }
/* 132 */     RelationshipTransformParameterSpec relationshipTransformParameterSpec = (RelationshipTransformParameterSpec)paramTransformParameterSpec;
/* 133 */     for (String str : relationshipTransformParameterSpec.sourceIds) {
/* 134 */       this.sourceIds.add(str);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void init(XMLStructure paramXMLStructure, XMLCryptoContext paramXMLCryptoContext) throws InvalidAlgorithmParameterException {
/* 140 */     LOG.log(1, new Object[] { "init(parent,context)" });
/* 141 */     LOG.log(1, new Object[] { "parent java type: " + paramXMLStructure.getClass().getName() });
/* 142 */     DOMStructure dOMStructure = (DOMStructure)paramXMLStructure;
/* 143 */     Node node = dOMStructure.getNode();
/*     */     
/*     */     try {
/* 146 */       i i = i.a.a(node, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 147 */       XmlObject[] arrayOfXmlObject = i.a().selectChildren(RelationshipReferenceDocument.type.getDocumentElementName());
/* 148 */       if (arrayOfXmlObject.length == 0) {
/* 149 */         LOG.log(5, new Object[] { "no RelationshipReference/@SourceId parameters present" });
/*     */       }
/* 151 */       for (XmlObject xmlObject : arrayOfXmlObject) {
/* 152 */         String str = ((CTRelationshipReference)xmlObject).getSourceId();
/* 153 */         LOG.log(1, new Object[] { "sourceId: ", str });
/* 154 */         this.sourceIds.add(str);
/*     */       } 
/* 156 */     } catch (XmlException xmlException) {
/* 157 */       throw new InvalidAlgorithmParameterException(xmlException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void marshalParams(XMLStructure paramXMLStructure, XMLCryptoContext paramXMLCryptoContext) throws MarshalException {
/* 163 */     LOG.log(1, new Object[] { "marshallParams(parent,context)" });
/* 164 */     DOMStructure dOMStructure = (DOMStructure)paramXMLStructure;
/* 165 */     Element element = (Element)dOMStructure.getNode();
/*     */     
/* 167 */     Document document = element.getOwnerDocument();
/*     */     
/* 169 */     for (String str : this.sourceIds) {
/* 170 */       RelationshipReferenceDocument relationshipReferenceDocument = RelationshipReferenceDocument.Factory.newInstance();
/* 171 */       relationshipReferenceDocument.addNewRelationshipReference().setSourceId(str);
/* 172 */       Node node = relationshipReferenceDocument.getRelationshipReference().getDomNode();
/* 173 */       node = document.importNode(node, true);
/* 174 */       element.appendChild(node);
/*     */     } 
/*     */   }
/*     */   
/*     */   public AlgorithmParameterSpec getParameterSpec() {
/* 179 */     LOG.log(1, new Object[] { "getParameterSpec" });
/* 180 */     return null;
/*     */   }
/*     */   public Data transform(Data paramData, XMLCryptoContext paramXMLCryptoContext) throws TransformException {
/*     */     RelationshipsDocument relationshipsDocument;
/* 184 */     LOG.log(1, new Object[] { "transform(data,context)" });
/* 185 */     LOG.log(1, new Object[] { "data java type: " + paramData.getClass().getName() });
/* 186 */     OctetStreamData octetStreamData = (OctetStreamData)paramData;
/* 187 */     LOG.log(1, new Object[] { "URI: " + octetStreamData.getURI() });
/* 188 */     InputStream inputStream = octetStreamData.getOctetStream();
/*     */ 
/*     */     
/*     */     try {
/* 192 */       relationshipsDocument = RelationshipsDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 193 */     } catch (Exception exception) {
/* 194 */       throw new TransformException(exception.getMessage(), exception);
/*     */     } 
/* 196 */     LOG.log(1, new Object[] { "relationships document", relationshipsDocument });
/*     */     
/* 198 */     CTRelationships cTRelationships = relationshipsDocument.getRelationships();
/* 199 */     List list = cTRelationships.getRelationshipList();
/* 200 */     Iterator<CTRelationship> iterator = cTRelationships.getRelationshipList().iterator();
/* 201 */     while (iterator.hasNext()) {
/* 202 */       CTRelationship cTRelationship = iterator.next();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 207 */       if (!this.sourceIds.contains(cTRelationship.getId())) {
/* 208 */         LOG.log(1, new Object[] { "removing element: " + cTRelationship.getId() });
/* 209 */         iterator.remove(); continue;
/*     */       } 
/* 211 */       if (!cTRelationship.isSetTargetMode()) {
/* 212 */         cTRelationship.setTargetMode(STTargetMode.INTERNAL);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 218 */     LOG.log(1, new Object[] { "# Relationship elements", Integer.valueOf(list.size()) });
/*     */     
/* 220 */     XmlSort.sort((XmlObject)cTRelationships, new Comparator<XmlCursor>() {
/*     */           public int compare(XmlCursor param1XmlCursor1, XmlCursor param1XmlCursor2) {
/* 222 */             String str1 = ((CTRelationship)param1XmlCursor1.getObject()).getId();
/* 223 */             String str2 = ((CTRelationship)param1XmlCursor2.getObject()).getId();
/* 224 */             return str1.compareTo(str2);
/*     */           }
/*     */         });
/*     */     
/*     */     try {
/* 229 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 230 */       XmlOptions xmlOptions = new XmlOptions();
/* 231 */       xmlOptions.setSaveNoXmlDecl();
/* 232 */       relationshipsDocument.save(byteArrayOutputStream, xmlOptions);
/* 233 */       return new OctetStreamData(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
/* 234 */     } catch (IOException iOException) {
/* 235 */       throw new TransformException(iOException.getMessage(), iOException);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Data transform(Data paramData, XMLCryptoContext paramXMLCryptoContext, OutputStream paramOutputStream) throws TransformException {
/* 240 */     LOG.log(1, new Object[] { "transform(data,context,os)" });
/* 241 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isFeatureSupported(String paramString) {
/* 245 */     LOG.log(1, new Object[] { "isFeatureSupported(feature)" });
/* 246 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\dsig\services\RelationshipTransformService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */