/*     */ package org.apache.poi.xwpf.model;
/*     */ 
/*     */ import com.microsoft.schemas.office.office.CTLock;
/*     */ import com.microsoft.schemas.office.office.STConnectType;
/*     */ import com.microsoft.schemas.vml.CTFormulas;
/*     */ import com.microsoft.schemas.vml.CTGroup;
/*     */ import com.microsoft.schemas.vml.CTH;
/*     */ import com.microsoft.schemas.vml.CTHandles;
/*     */ import com.microsoft.schemas.vml.CTPath;
/*     */ import com.microsoft.schemas.vml.CTShape;
/*     */ import com.microsoft.schemas.vml.CTShapetype;
/*     */ import com.microsoft.schemas.vml.CTTextPath;
/*     */ import com.microsoft.schemas.vml.STExt;
/*     */ import com.microsoft.schemas.vml.STTrueFalse;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLFactory;
/*     */ import org.apache.poi.POIXMLRelation;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.xwpf.usermodel.IBody;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFDocument;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFFactory;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFFooter;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFHeader;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFHeaderFooter;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFParagraph;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFRelation;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.FtrDocument;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.HdrDocument;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHdrFtr;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XWPFHeaderFooterPolicy
/*     */ {
/*  70 */   private static final POILogger LOG = POILogFactory.getLogger(XWPFHeaderFooterPolicy.class);
/*     */   
/*  72 */   public static final STHdrFtr.Enum DEFAULT = STHdrFtr.DEFAULT;
/*  73 */   public static final STHdrFtr.Enum EVEN = STHdrFtr.EVEN;
/*  74 */   public static final STHdrFtr.Enum FIRST = STHdrFtr.FIRST;
/*     */ 
/*     */   
/*     */   private XWPFDocument doc;
/*     */   
/*     */   private XWPFHeader firstPageHeader;
/*     */   
/*     */   private XWPFFooter firstPageFooter;
/*     */   
/*     */   private XWPFHeader evenPageHeader;
/*     */   
/*     */   private XWPFFooter evenPageFooter;
/*     */   
/*     */   private XWPFHeader defaultHeader;
/*     */   
/*     */   private XWPFFooter defaultFooter;
/*     */ 
/*     */   
/*     */   public XWPFHeaderFooterPolicy(XWPFDocument paramXWPFDocument) {
/*  93 */     this(paramXWPFDocument, paramXWPFDocument.getDocument().getBody().getSectPr());
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
/*     */   public XWPFHeaderFooterPolicy(XWPFDocument paramXWPFDocument, CTSectPr paramCTSectPr) {
/* 106 */     this.doc = paramXWPFDocument; byte b;
/* 107 */     for (b = 0; b < paramCTSectPr.sizeOfHeaderReferenceArray(); b++) {
/*     */       
/* 109 */       CTHdrFtrRef cTHdrFtrRef = paramCTSectPr.getHeaderReferenceArray(b);
/* 110 */       POIXMLDocumentPart pOIXMLDocumentPart = paramXWPFDocument.getRelationById(cTHdrFtrRef.getId());
/* 111 */       XWPFHeader xWPFHeader = null;
/* 112 */       if (pOIXMLDocumentPart != null && pOIXMLDocumentPart instanceof XWPFHeader) {
/* 113 */         xWPFHeader = (XWPFHeader)pOIXMLDocumentPart;
/*     */       }
/*     */       
/* 116 */       STHdrFtr.Enum enum_ = cTHdrFtrRef.getType();
/* 117 */       assignHeader(xWPFHeader, enum_);
/*     */     } 
/* 119 */     for (b = 0; b < paramCTSectPr.sizeOfFooterReferenceArray(); b++) {
/*     */       
/* 121 */       CTHdrFtrRef cTHdrFtrRef = paramCTSectPr.getFooterReferenceArray(b);
/* 122 */       POIXMLDocumentPart pOIXMLDocumentPart = paramXWPFDocument.getRelationById(cTHdrFtrRef.getId());
/* 123 */       XWPFFooter xWPFFooter = null;
/* 124 */       if (pOIXMLDocumentPart != null && pOIXMLDocumentPart instanceof XWPFFooter) {
/* 125 */         xWPFFooter = (XWPFFooter)pOIXMLDocumentPart;
/*     */       }
/*     */       
/* 128 */       STHdrFtr.Enum enum_ = cTHdrFtrRef.getType();
/* 129 */       assignFooter(xWPFFooter, enum_);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void assignFooter(XWPFFooter paramXWPFFooter, STHdrFtr.Enum paramEnum) {
/* 134 */     if (paramEnum == STHdrFtr.FIRST) {
/* 135 */       this.firstPageFooter = paramXWPFFooter;
/* 136 */     } else if (paramEnum == STHdrFtr.EVEN) {
/* 137 */       this.evenPageFooter = paramXWPFFooter;
/*     */     } else {
/* 139 */       this.defaultFooter = paramXWPFFooter;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void assignHeader(XWPFHeader paramXWPFHeader, STHdrFtr.Enum paramEnum) {
/* 144 */     if (paramEnum == STHdrFtr.FIRST) {
/* 145 */       this.firstPageHeader = paramXWPFHeader;
/* 146 */     } else if (paramEnum == STHdrFtr.EVEN) {
/* 147 */       this.evenPageHeader = paramXWPFHeader;
/*     */     } else {
/* 149 */       this.defaultHeader = paramXWPFHeader;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFHeader createHeader(STHdrFtr.Enum paramEnum) throws IOException {
/* 158 */     return createHeader(paramEnum, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFHeader createHeader(STHdrFtr.Enum paramEnum, XWPFParagraph[] paramArrayOfXWPFParagraph) throws IOException {
/* 167 */     XWPFRelation xWPFRelation = XWPFRelation.HEADER;
/* 168 */     String str = "Header";
/* 169 */     int i = getRelationIndex(xWPFRelation);
/* 170 */     HdrDocument hdrDocument = HdrDocument.Factory.newInstance();
/*     */     
/* 172 */     XWPFHeader xWPFHeader = (XWPFHeader)this.doc.createRelationship((POIXMLRelation)xWPFRelation, (POIXMLFactory)XWPFFactory.getInstance(), i);
/* 173 */     xWPFHeader.setXWPFDocument(this.doc);
/*     */     
/* 175 */     CTHdrFtr cTHdrFtr = buildHdr(paramEnum, str, (XWPFHeaderFooter)xWPFHeader, paramArrayOfXWPFParagraph);
/* 176 */     xWPFHeader.setHeaderFooter(cTHdrFtr);
/*     */     
/* 178 */     OutputStream outputStream = xWPFHeader.getPackagePart().getOutputStream();
/* 179 */     hdrDocument.setHdr(cTHdrFtr);
/*     */     
/* 181 */     assignHeader(xWPFHeader, paramEnum);
/* 182 */     hdrDocument.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 183 */     outputStream.close();
/*     */     
/* 185 */     return xWPFHeader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFFooter createFooter(STHdrFtr.Enum paramEnum) throws IOException {
/* 193 */     return createFooter(paramEnum, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFFooter createFooter(STHdrFtr.Enum paramEnum, XWPFParagraph[] paramArrayOfXWPFParagraph) throws IOException {
/* 202 */     XWPFRelation xWPFRelation = XWPFRelation.FOOTER;
/* 203 */     String str = "Footer";
/* 204 */     int i = getRelationIndex(xWPFRelation);
/* 205 */     FtrDocument ftrDocument = FtrDocument.Factory.newInstance();
/*     */     
/* 207 */     XWPFFooter xWPFFooter = (XWPFFooter)this.doc.createRelationship((POIXMLRelation)xWPFRelation, (POIXMLFactory)XWPFFactory.getInstance(), i);
/* 208 */     xWPFFooter.setXWPFDocument(this.doc);
/*     */     
/* 210 */     CTHdrFtr cTHdrFtr = buildFtr(paramEnum, str, (XWPFHeaderFooter)xWPFFooter, paramArrayOfXWPFParagraph);
/* 211 */     xWPFFooter.setHeaderFooter(cTHdrFtr);
/*     */     
/* 213 */     OutputStream outputStream = xWPFFooter.getPackagePart().getOutputStream();
/* 214 */     ftrDocument.setFtr(cTHdrFtr);
/*     */     
/* 216 */     assignFooter(xWPFFooter, paramEnum);
/* 217 */     ftrDocument.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 218 */     outputStream.close();
/* 219 */     return xWPFFooter;
/*     */   }
/*     */   
/*     */   private int getRelationIndex(XWPFRelation paramXWPFRelation) {
/* 223 */     byte b = 1;
/* 224 */     for (POIXMLDocumentPart.RelationPart relationPart : this.doc.getRelationParts()) {
/* 225 */       if (relationPart.getRelationship().getRelationshipType().equals(paramXWPFRelation.getRelation())) {
/* 226 */         b++;
/*     */       }
/*     */     } 
/* 229 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   private CTHdrFtr buildFtr(STHdrFtr.Enum paramEnum, String paramString, XWPFHeaderFooter paramXWPFHeaderFooter, XWPFParagraph[] paramArrayOfXWPFParagraph) {
/* 234 */     CTHdrFtr cTHdrFtr = buildHdrFtr(paramString, paramArrayOfXWPFParagraph, paramXWPFHeaderFooter);
/* 235 */     setFooterReference(paramEnum, paramXWPFHeaderFooter);
/* 236 */     return cTHdrFtr;
/*     */   }
/*     */ 
/*     */   
/*     */   private CTHdrFtr buildHdr(STHdrFtr.Enum paramEnum, String paramString, XWPFHeaderFooter paramXWPFHeaderFooter, XWPFParagraph[] paramArrayOfXWPFParagraph) {
/* 241 */     CTHdrFtr cTHdrFtr = buildHdrFtr(paramString, paramArrayOfXWPFParagraph, paramXWPFHeaderFooter);
/* 242 */     setHeaderReference(paramEnum, paramXWPFHeaderFooter);
/* 243 */     return cTHdrFtr;
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
/*     */   private CTHdrFtr buildHdrFtr(String paramString, XWPFParagraph[] paramArrayOfXWPFParagraph, XWPFHeaderFooter paramXWPFHeaderFooter) {
/* 259 */     CTHdrFtr cTHdrFtr = paramXWPFHeaderFooter._getHdrFtr();
/* 260 */     if (paramArrayOfXWPFParagraph != null) {
/* 261 */       for (byte b = 0; b < paramArrayOfXWPFParagraph.length; b++) {
/* 262 */         CTP cTP = cTHdrFtr.addNewP();
/* 263 */         cTHdrFtr.setPArray(b, paramArrayOfXWPFParagraph[b].getCTP());
/*     */       } 
/*     */     } else {
/* 266 */       CTP cTP = cTHdrFtr.addNewP();
/* 267 */       CTBody cTBody = this.doc.getDocument().getBody();
/* 268 */       if (cTBody.sizeOfPArray() > 0) {
/* 269 */         CTP cTP1 = cTBody.getPArray(0);
/* 270 */         if (cTP1.isSetRsidR()) {
/* 271 */           byte[] arrayOfByte1 = cTP1.getRsidR();
/* 272 */           byte[] arrayOfByte2 = cTP1.getRsidRDefault();
/* 273 */           cTP.setRsidP(arrayOfByte1);
/* 274 */           cTP.setRsidRDefault(arrayOfByte2);
/*     */         } 
/*     */       } 
/* 277 */       CTPPr cTPPr = cTP.addNewPPr();
/* 278 */       cTPPr.addNewPStyle().setVal(paramString);
/*     */     } 
/* 280 */     return cTHdrFtr;
/*     */   }
/*     */ 
/*     */   
/*     */   private void setFooterReference(STHdrFtr.Enum paramEnum, XWPFHeaderFooter paramXWPFHeaderFooter) {
/* 285 */     CTHdrFtrRef cTHdrFtrRef = this.doc.getDocument().getBody().getSectPr().addNewFooterReference();
/* 286 */     cTHdrFtrRef.setType(paramEnum);
/* 287 */     cTHdrFtrRef.setId(this.doc.getRelationId((POIXMLDocumentPart)paramXWPFHeaderFooter));
/*     */   }
/*     */ 
/*     */   
/*     */   private void setHeaderReference(STHdrFtr.Enum paramEnum, XWPFHeaderFooter paramXWPFHeaderFooter) {
/* 292 */     CTHdrFtrRef cTHdrFtrRef = this.doc.getDocument().getBody().getSectPr().addNewHeaderReference();
/* 293 */     cTHdrFtrRef.setType(paramEnum);
/* 294 */     cTHdrFtrRef.setId(this.doc.getRelationId((POIXMLDocumentPart)paramXWPFHeaderFooter));
/*     */   }
/*     */   
/*     */   public XWPFHeader getFirstPageHeader() {
/* 298 */     return this.firstPageHeader;
/*     */   }
/*     */   
/*     */   public XWPFFooter getFirstPageFooter() {
/* 302 */     return this.firstPageFooter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFHeader getOddPageHeader() {
/* 310 */     return this.defaultHeader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFFooter getOddPageFooter() {
/* 318 */     return this.defaultFooter;
/*     */   }
/*     */   
/*     */   public XWPFHeader getEvenPageHeader() {
/* 322 */     return this.evenPageHeader;
/*     */   }
/*     */   
/*     */   public XWPFFooter getEvenPageFooter() {
/* 326 */     return this.evenPageFooter;
/*     */   }
/*     */   
/*     */   public XWPFHeader getDefaultHeader() {
/* 330 */     return this.defaultHeader;
/*     */   }
/*     */   
/*     */   public XWPFFooter getDefaultFooter() {
/* 334 */     return this.defaultFooter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFHeader getHeader(int paramInt) {
/* 344 */     if (paramInt == 1 && this.firstPageHeader != null) {
/* 345 */       return this.firstPageHeader;
/*     */     }
/* 347 */     if (paramInt % 2 == 0 && this.evenPageHeader != null) {
/* 348 */       return this.evenPageHeader;
/*     */     }
/* 350 */     return this.defaultHeader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFFooter getFooter(int paramInt) {
/* 360 */     if (paramInt == 1 && this.firstPageFooter != null) {
/* 361 */       return this.firstPageFooter;
/*     */     }
/* 363 */     if (paramInt % 2 == 0 && this.evenPageFooter != null) {
/* 364 */       return this.evenPageFooter;
/*     */     }
/* 366 */     return this.defaultFooter;
/*     */   }
/*     */   
/*     */   public void createWatermark(String paramString) {
/* 370 */     XWPFParagraph[] arrayOfXWPFParagraph = new XWPFParagraph[1];
/*     */     try {
/* 372 */       arrayOfXWPFParagraph[0] = getWatermarkParagraph(paramString, 1);
/* 373 */       createHeader(DEFAULT, arrayOfXWPFParagraph);
/* 374 */       arrayOfXWPFParagraph[0] = getWatermarkParagraph(paramString, 2);
/* 375 */       createHeader(FIRST, arrayOfXWPFParagraph);
/* 376 */       arrayOfXWPFParagraph[0] = getWatermarkParagraph(paramString, 3);
/* 377 */       createHeader(EVEN, arrayOfXWPFParagraph);
/* 378 */     } catch (IOException iOException) {
/* 379 */       LOG.log(7, new Object[] { "error while creating watermark", iOException });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private XWPFParagraph getWatermarkParagraph(String paramString, int paramInt) {
/* 388 */     CTP cTP = CTP.Factory.newInstance();
/* 389 */     byte[] arrayOfByte1 = this.doc.getDocument().getBody().getPArray(0).getRsidR();
/* 390 */     byte[] arrayOfByte2 = this.doc.getDocument().getBody().getPArray(0).getRsidRDefault();
/* 391 */     cTP.setRsidP(arrayOfByte1);
/* 392 */     cTP.setRsidRDefault(arrayOfByte2);
/* 393 */     CTPPr cTPPr = cTP.addNewPPr();
/* 394 */     cTPPr.addNewPStyle().setVal("Header");
/*     */     
/* 396 */     CTR cTR = cTP.addNewR();
/* 397 */     CTRPr cTRPr = cTR.addNewRPr();
/* 398 */     cTRPr.addNewNoProof();
/* 399 */     CTPicture cTPicture = cTR.addNewPict();
/* 400 */     CTGroup cTGroup = CTGroup.Factory.newInstance();
/* 401 */     CTShapetype cTShapetype = cTGroup.addNewShapetype();
/* 402 */     cTShapetype.setId("_x0000_t136");
/* 403 */     cTShapetype.setCoordsize("1600,21600");
/* 404 */     cTShapetype.setSpt(136.0F);
/* 405 */     cTShapetype.setAdj("10800");
/* 406 */     cTShapetype.setPath2("m@7,0l@8,0m@5,21600l@6,21600e");
/* 407 */     CTFormulas cTFormulas = cTShapetype.addNewFormulas();
/* 408 */     cTFormulas.addNewF().setEqn("sum #0 0 10800");
/* 409 */     cTFormulas.addNewF().setEqn("prod #0 2 1");
/* 410 */     cTFormulas.addNewF().setEqn("sum 21600 0 @1");
/* 411 */     cTFormulas.addNewF().setEqn("sum 0 0 @2");
/* 412 */     cTFormulas.addNewF().setEqn("sum 21600 0 @3");
/* 413 */     cTFormulas.addNewF().setEqn("if @0 @3 0");
/* 414 */     cTFormulas.addNewF().setEqn("if @0 21600 @1");
/* 415 */     cTFormulas.addNewF().setEqn("if @0 0 @2");
/* 416 */     cTFormulas.addNewF().setEqn("if @0 @4 21600");
/* 417 */     cTFormulas.addNewF().setEqn("mid @5 @6");
/* 418 */     cTFormulas.addNewF().setEqn("mid @8 @5");
/* 419 */     cTFormulas.addNewF().setEqn("mid @7 @8");
/* 420 */     cTFormulas.addNewF().setEqn("mid @6 @7");
/* 421 */     cTFormulas.addNewF().setEqn("sum @6 0 @5");
/* 422 */     CTPath cTPath = cTShapetype.addNewPath();
/* 423 */     cTPath.setTextpathok(STTrueFalse.T);
/* 424 */     cTPath.setConnecttype(STConnectType.CUSTOM);
/* 425 */     cTPath.setConnectlocs("@9,0;@10,10800;@11,21600;@12,10800");
/* 426 */     cTPath.setConnectangles("270,180,90,0");
/* 427 */     CTTextPath cTTextPath1 = cTShapetype.addNewTextpath();
/* 428 */     cTTextPath1.setOn(STTrueFalse.T);
/* 429 */     cTTextPath1.setFitshape(STTrueFalse.T);
/* 430 */     CTHandles cTHandles = cTShapetype.addNewHandles();
/* 431 */     CTH cTH = cTHandles.addNewH();
/* 432 */     cTH.setPosition("#0,bottomRight");
/* 433 */     cTH.setXrange("6629,14971");
/* 434 */     CTLock cTLock = cTShapetype.addNewLock();
/* 435 */     cTLock.setExt(STExt.EDIT);
/* 436 */     CTShape cTShape = cTGroup.addNewShape();
/* 437 */     cTShape.setId("PowerPlusWaterMarkObject" + paramInt);
/* 438 */     cTShape.setSpid("_x0000_s102" + (4 + paramInt));
/* 439 */     cTShape.setType("#_x0000_t136");
/* 440 */     cTShape.setStyle("position:absolute;margin-left:0;margin-top:0;width:415pt;height:207.5pt;z-index:-251654144;mso-wrap-edited:f;mso-position-horizontal:center;mso-position-horizontal-relative:margin;mso-position-vertical:center;mso-position-vertical-relative:margin");
/* 441 */     cTShape.setWrapcoords("616 5068 390 16297 39 16921 -39 17155 7265 17545 7186 17467 -39 17467 18904 17467 10507 17467 8710 17545 18904 17077 18787 16843 18358 16297 18279 12554 19178 12476 20701 11774 20779 11228 21131 10059 21248 8811 21248 7563 20975 6316 20935 5380 19490 5146 14022 5068 2616 5068");
/* 442 */     cTShape.setFillcolor("black");
/* 443 */     cTShape.setStroked(STTrueFalse.FALSE);
/* 444 */     CTTextPath cTTextPath2 = cTShape.addNewTextpath();
/* 445 */     cTTextPath2.setStyle("font-family:&quot;Cambria&quot;;font-size:1pt");
/* 446 */     cTTextPath2.setString(paramString);
/* 447 */     cTPicture.set((XmlObject)cTGroup);
/*     */     
/* 449 */     return new XWPFParagraph(cTP, (IBody)this.doc);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwpf\model\XWPFHeaderFooterPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */